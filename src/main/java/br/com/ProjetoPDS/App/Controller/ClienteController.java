package br.com.ProjetoPDS.App.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;
import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;
import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.ServicoService;
import br.com.ProjetoPDS.App.Service.VeiculoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {


	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private ServicoService servicoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView cliente(HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/cliente");
		//buscar cliente pelo id
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		List<Servico> listaServicos = servicoService.buscarServicosPorIdCliente(cliente);
		mv.addObject("listaServicos",listaServicos);
		
		return mv;
		
	}
	
	@GetMapping("/novo")
	public ModelAndView formCliente(){
		
		ModelAndView mv = new ModelAndView("cliente/form");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
		
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarCliente(Cliente cliente, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/novo");
		cliente.setTipo(TipoPessoa.FISICA);
		clienteService.inserir(cliente);
		attributes.addFlashAttribute("message", "O cliente foi cadastrado!");
		return mv;
		
	}
	
	@GetMapping("/novoVeiculo")
	public ModelAndView formVeiculo(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("cliente/formVeiculo");

		Veiculo veiculo = new Veiculo();
		List<String> marcas = veiculoService.listarMarcas();
		mv.addObject("cores", EnumCores.values());
		mv.addObject("marcas", marcas);
		mv.addObject("veiculo", veiculo);
		
		return mv;
	}
	
	@PostMapping("/novoVeiculo")
	public ModelAndView salvarVeiculo(Veiculo veiculo, HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/formVeiculo");
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		//Cliente cliente = clienteService.buscarPorId(temp.getId());
		
		MarcaModelo m = veiculoService.listarMarcaModelo(veiculo.getMarcaModelo().getMarca(), veiculo.getMarcaModelo().getModelo());
		
		veiculo.setMarcaModelo(m);
		
		veiculo.setCliente(cliente);
		cliente.addVeiculo(veiculo);
		
		clienteService.inserir(cliente);
		mv.addObject("message", "Veículo adicionado!");
		return mv;
	}
	
	@RequestMapping("/meusVeiculos")
	public ModelAndView cadastrarVeiculo(HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/meusVeiculos");
		
		Cliente temp = (Cliente) session.getAttribute("usuario");
		Cliente cliente = clienteService.buscarPorId(temp.getId());
		
		clienteService.verificaVeiculo(cliente.getId());
		
		for(Veiculo veiculo : cliente.getVeiculo()){
			
			for(Alerta alerta : veiculo.getAlertas()){
				
				System.out.println(alerta.getTipo());
			}
		}
		
		mv.addObject("cliente", cliente);
		return mv;
		
	}
	
	@GetMapping("/addInfoExtraVeiculo")
	public ModelAndView formInfoExtraVeiculo(@RequestParam(name="id", required=true) String id){

		ModelAndView mv = new ModelAndView("cliente/formInfoExtra");
		
		InfoExtraVeiculo infoExtraVeiculo = new InfoExtraVeiculo();
		Veiculo veiculo = veiculoService.buscarPorId(id);
		
		mv.addObject("veiculo", veiculo);
		mv.addObject("infoExtraVeiculo", infoExtraVeiculo);
		
		return mv;
	}
	
	@PostMapping("/addInfoExtraVeiculo")
	public ModelAndView saveInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo){
	
		ModelAndView mv = new ModelAndView("redirect:meusVeiculos");
		
		veiculoService.adicionarInfoExtra(infoExtraVeiculo);
		
		return mv;
	}
	
	@PostMapping("/removerVeiculo")
	public @ResponseBody String removerVeiculo(String id){
	
		String result = "";
		System.out.println("Remover");
		System.out.println(id);
		
		try{
			
			servicoService.deletarTodos(veiculoService.buscarPorId(id));
			//veiculoService.deleteAlertasVeiculo(veiculoService.buscarPorId(id));
			veiculoService.deletePorId(id);
			result = "Success!";
			
		}catch(DataAccessException e){
			result = "Failed!";
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos( String marca){
		
		
		List<String> modelos = veiculoService.listarMarcaModelo(marca);
		
		return modelos;
		
	}
	
	
}
