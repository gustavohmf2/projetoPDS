package br.com.ProjetoPDS.App.Controller;

import java.util.GregorianCalendar;

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
	
	@Autowired
	private AcompanhamentoService acompanhamentoService;
	
	@Autowired
	private MarcaModeloRepository mmRepository;
	
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
	public ModelAndView formVeiculo(@RequestParam(name="cpf", required=true) String cpf){
		
		
		ModelAndView mv = new ModelAndView("cliente/formVeiculo");
		
		Cliente cliente = clienteService.buscarPF(cpf);
		
<<<<<<< HEAD
=======
		clienteService.inserir(cliente);
>>>>>>> ac639ab8f1ffc140a4f3be31c30eb7eb97a88aee
		
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	@PostMapping("/novoVeiculo")
	public String cadastrarVeiculo(@RequestParam(name="cliente", required=true) Cliente cliente, Model model){
		
		clienteService.inserir(cliente);
		
		return "cliente/formVeiculo";
		
	}
	
	@RequestMapping("/meusVeiculos")
	public String cadastrarVeiculo(@RequestParam(name="id", required=true, defaultValue="12398754380") String id, Model model){
		
		
		//descer para a camada de validação
		Cliente cliente = clienteService.buscarPF(id);
		
		System.out.println(cliente.getVeiculo().get(0).getInfoExtraVeiculo().getUltimaRevisao().getTime());
		//verifica se há alguma manutenção preventiva em vista
		acompanhamentoService.verificaVeiculo(cliente);
		
		model.addAttribute("cliente", cliente);
		return "cliente/meusVeiculos";
		
	}
	
	//@GetMapping("/addInfoExtraVeiculo)
	@RequestMapping("/addInfoExtraVeiculo")
	public String addInfoExtraVeiculo(@RequestParam(name="id", required=true) String id, Model model){
		
		System.out.println(id);
		
		Veiculo veiculo = veiculoService.buscarPorId(id);
		
		InfoExtraVeiculo infoExtraVeiculo = new InfoExtraVeiculo();
		
		infoExtraVeiculo.setKmAnterior(12000.0);
		infoExtraVeiculo.setKmMedia(13.0);
		infoExtraVeiculo.setKmTotal(25000.0);
		infoExtraVeiculo.setUltimaRevisao(new GregorianCalendar(2015,01,04));
		infoExtraVeiculo.setUltimaTrocaOleo(new GregorianCalendar(2015,01,01));
		infoExtraVeiculo.setUltimaTrocaPneu(new GregorianCalendar(2015,02, 9));
		
		infoExtraVeiculo.setVeiculo(veiculo);
		infoExtraVeiculo.setId(veiculo.getNumeroChassi());
		veiculo.setInfoExtraVeiculo(infoExtraVeiculo);


		veiculoService.inserir(veiculo);
		
		model.addAttribute("cliente", clienteService.buscarPF(id));
		
		return "cliente/meusVeiculos";
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
