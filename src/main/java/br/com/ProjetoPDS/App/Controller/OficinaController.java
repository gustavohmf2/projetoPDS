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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;
import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.OficinaService;
import br.com.ProjetoPDS.App.Service.ServicoService;
import br.com.ProjetoPDS.App.Service.VeiculoService;

@Controller
@RequestMapping("/oficina")
public class OficinaController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private OficinaService oficinaService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private ServicoService servicoService; 
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView oficina(Model model, HttpSession session){
		ModelAndView mv = new ModelAndView("oficina/oficina");
		
		Oficina oficina = (Oficina) session.getAttribute("usuario");
		List<Servico> listaServicos = servicoService.buscarServicosPorIdOficina(oficina);
		mv.addObject("listaServicos",listaServicos);
		
		return mv;
	}
	
	
	@GetMapping("/cadastro")
	public ModelAndView formCadastroOficina(){
		ModelAndView mv = new ModelAndView("/oficina/cadastro");
		Oficina oficina = new Oficina();
		mv.addObject("oficina", oficina);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView cadastroOficina(Oficina oficina, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/oficina/cadastro");
		oficinaService.inserir(oficina);
		mv.addObject("oficina", oficina);
		attributes.addFlashAttribute("message", "Oficina cadastrada com sucesso!");	
		return mv;
	}
	
	@RequestMapping("/todosServicos")
	public ModelAndView mostrarServicos(HttpSession session){
		
		ModelAndView mv = new ModelAndView("oficina/todosServicos");
		//descer para a camada de validação
		Oficina temp = (Oficina) session.getAttribute("usuario");
		Oficina oficina = oficinaService.buscarPorId(temp.getId());
		return mv;
	}
	
	@GetMapping("/novoServico")
	public ModelAndView cadastrarServico(HttpSession session){
		ModelAndView mv = new ModelAndView("oficina/novoServico");
		
		return mv;
	}
	
	@PostMapping("/novoServico")
	public ModelAndView cadastrarServico(Servico servico){
		ModelAndView mv = new ModelAndView("oficina/novoServico");
		
		return mv;
	}
	
	@GetMapping("/novoVeiculo")
	public ModelAndView formVeiculo(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("oficina/formVeiculoOficina");

		Veiculo veiculo = new Veiculo();
		List<String> marcas = veiculoService.listarMarcas();
		mv.addObject("cores", EnumCores.values());
		mv.addObject("marcas", marcas);
		mv.addObject("veiculo", veiculo);
		
		return mv;
	}
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos( String marca){
		
		List<String> modelos = veiculoService.listarMarcaModelo(marca);
		
		return modelos;
		
	}
	
	@PostMapping("/novoVeiculo")
	public ModelAndView salvarVeiculo(Veiculo veiculo, HttpSession session){
		
		
		ModelAndView mv = new ModelAndView("oficina/formVeiculoOficina");
		
		MarcaModelo m = veiculoService.listarMarcaModelo(veiculo.getMarcaModelo().getMarca(), veiculo.getMarcaModelo().getModelo());
		
		veiculo.setMarcaModelo(m);
		
		//veiculo.setCliente(cliente);
		//cliente.addVeiculo(veiculo);
		
		//clienteService.inserir(cliente);
		
		return mv;
	}
	
	@GetMapping("/novoCliente")
	public ModelAndView formNovoCliente(){
		ModelAndView mv = new ModelAndView("/oficina/formClienteOficina");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/novoCliente")
	public ModelAndView cadastroClienteOficina(Cliente cliente, HttpSession session){
		ModelAndView mv = new ModelAndView("redirect:/oficina/");
		cliente.setTipo(TipoPessoa.FISICA);
		clienteService.inserir(cliente);
		
		return mv;
	}
	
}
