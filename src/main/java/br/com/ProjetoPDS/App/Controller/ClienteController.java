package br.com.ProjetoPDS.App.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
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
	public ModelAndView cliente(Model model, HttpSession session){
		ModelAndView mv = new ModelAndView("cliente/cliente");
		//buscar cliente pelo id
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		ArrayList<Servico> listaServicos = (ArrayList<Servico>) servicoService.buscarServicosPorIdCliente(cliente);
		ArrayList<String> listaStatus = new ArrayList<String>();
		
		for (Servico servico : listaServicos) {
			listaStatus.add(EnumStatus.getTitulo(servico.getStatus()));
		}
		
		mv.addObject("listaServicos",listaServicos);
		mv.addObject("listaStatus",listaStatus);
		
		return mv;
		
	}
	
	@GetMapping("/novo")
	public ModelAndView formCliente(){
		
		ModelAndView mv = new ModelAndView("cliente/form");
		System.out.println("cadastro oficina");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
		
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarCliente(Cliente cliente,RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/novo");
		cliente.setTipo(TipoPessoa.FISICA.ordinal());
		clienteService.inserir(cliente);
		attributes.addFlashAttribute("message", "O cliente foi cadastrado!");
		return mv;
		
	}
	
	@GetMapping("/novoVeiculo")
	public ModelAndView formVeiculo(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("cliente/formVeiculo");

		Veiculo veiculo = new Veiculo();
		List<String> marcas = veiculoService.listarMarcas();
		mv.addObject("marcas", marcas);
		mv.addObject("veiculo", veiculo);
		
		return mv;
	}
	
	
	
	@RequestMapping("/meusVeiculos")
	public ModelAndView cadastrarVeiculo(HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/meusVeiculos");
		//descer para a camada de validação
		Cliente temp = (Cliente) session.getAttribute("usuario");
		Cliente cliente = clienteService.buscarPorId(temp.getId());
		
		clienteService.verificaVeiculo(cliente.getId());
		
		for(int i = 0; i < cliente.getVeiculo().get(0).getAlertas().size();i++){
			System.out.println(cliente.getVeiculo().get(0).getAlertas().get(i).getDescricao());;
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
	public ModelAndView saveInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo, HttpSession session, RedirectAttributes attributes, String id){
	
		ModelAndView mv = new ModelAndView("redirect:cliente/formInfoExtra");
		
		veiculoService.adicionarInfoExtra(infoExtraVeiculo);
		
		attributes.addAttribute("mesagem", "Informações adicionadas");
		return mv;
	}
	
	@GetMapping("/listarModelos")
	public List<String> listarModelos(@RequestParam(name="marca", defaultValue="Fiat") String marca){
		
		return veiculoService.listarMarcaModelo(marca);
		
	}
	
	
	
	
	
	
	
}
