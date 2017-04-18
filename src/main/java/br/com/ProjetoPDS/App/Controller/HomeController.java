package br.com.ProjetoPDS.App.Controller;

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
import br.com.ProjetoPDS.App.Service.ClienteService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("index");
		
        return mv;
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(String login, String senha){
		
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@GetMapping("/teste")
	public ModelAndView teste(){
		
		ModelAndView mv = new ModelAndView("teste");
		
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(String login, String senha,RedirectAttributes attributes, HttpSession session){
		
		ModelAndView mv;
		
		Cliente cliente = clienteService.buscarPF(login);
		
		if(cliente != null){
			
			attributes.addFlashAttribute("message","Bem Vindo" + cliente.getNome());
			attributes.addFlashAttribute("cliente", cliente);
			session.setAttribute("usuario", cliente);
			mv = new ModelAndView("redirect:cliente");
			
		}else{
			
			mv = new ModelAndView("redirect:login");
			attributes.addFlashAttribute("message","Login incorreto ou não existe!");
		}
		
		return mv;
	}
	
	
}
