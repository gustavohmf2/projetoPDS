package br.com.ProjetoPDS.App.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.ServicoService;

@Controller
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/novoServico")
	public ModelAndView formServico(@RequestParam(name="id", required=true) String id){
		
		ModelAndView mv = new ModelAndView("/servico/formServico");
		Servico servico = new Servico();
		mv.addObject("servico", servico);
		
		return mv;
	}

	@PostMapping("/novoServico")
	public ModelAndView cadastrarServico(Servico servico, HttpSession session, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		Cliente tmp = (Cliente) session.getAttribute("usuario");
		
		Cliente cliente = clienteService.buscarPorId(tmp.getId());
		
		cliente.addServico(servico);
		servico.setResponsavel(cliente);
		
		servicoService.inserir(servico);
		attributes.addAttribute("message", "nova visita marcada!");
	
		return mv;
		
	}
	
}