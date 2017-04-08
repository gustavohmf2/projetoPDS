package br.com.ProjetoPDS.App.Controller;

import java.util.GregorianCalendar;

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

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.App.Repository.MarcaModeloRepository;
import br.com.ProjetoPDS.App.Service.AcompanhamentoService;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.VeiculoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {


	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String cliente( Model model){
		
	
		return "cliente/cliente";
	}
	
	@GetMapping("/novo")
	public ModelAndView formCliente(){
		
		ModelAndView mv = new ModelAndView("cliente/form");
		
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
		
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarCliente(Cliente cliente,RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/novo");
		System.out.println(cliente.getNome());
		
		clienteService.inserir(cliente);
		attributes.addFlashAttribute("message", "O cliente foi cadastrado!");
		return mv;
		
	}
	
	@GetMapping("/novoVeiculo")
	public ModelAndView formVeiculo(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("cliente/formVeiculo");

		Veiculo veiculo = new Veiculo();
		
		mv.addObject("veiculo", veiculo);
		
		return mv;
	}
	
	@PostMapping("/novoVeiculo")
	public ModelAndView cadastrarVeiculo(Veiculo veiculo, HttpSession session, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/formVeiculo");
		System.out.println(veiculo.getPlaca());
		
	
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		
		veiculo.setCliente(cliente);
		cliente.addVeiculo(veiculo);
		
		clienteService.inserir(cliente);
		attributes.addAttribute("message", "veículo cadastrado!");
	
		
		return mv;
		
	}
	
	@RequestMapping("/meusVeiculos")
	public String cadastrarVeiculo(@RequestParam(name="id", required=true) String id, Model model){
		
		
		//descer para a camada de validação
		Cliente cliente = clienteService.buscarPF(id);
		
		clienteService.verificaVeiculo(id);
	
		
		model.addAttribute("cliente", cliente);
		return "cliente/meusVeiculos";
		
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
	public ModelAndView saveInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo, RedirectAttributes attributes){
	
		ModelAndView mv = new ModelAndView("redirect:cliente/formInfoExtra");
		
		System.out.println(infoExtraVeiculo.getUltimaRevisao());
		
		attributes.addAttribute("mesagem", "Informações adicionadas");
		return mv;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
