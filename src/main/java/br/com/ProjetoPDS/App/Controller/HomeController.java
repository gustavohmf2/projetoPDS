package br.com.ProjetoPDS.App.Controller;

import java.util.GregorianCalendar;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Endereco;
import br.com.ProjetoPDS.App.Service.ClienteService;

@Controller
public class HomeController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping("/hello")
	public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		
	 Cliente cli = (Cliente) clienteService.buscarTodos().get(0);
	System.out.println(cli.getNome());
	
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		endereco.setUf("RN");
		endereco.setCep("51234-730");
		endereco.setCidade("Nova Cruz");
		endereco.setBairro("Bela Vista");
		endereco.setNumero(32);
		

		cliente.setId("0873427222");
		cliente.setTipo(TipoPessoa.FISICA);
		cliente.setNome("dudu");
		cliente.setDataNascimento(new GregorianCalendar(1992,07,07));
		cliente.setEndereco(endereco);
		cliente.setSexo("masculino");
		

		model.addAttribute("name", cliente.getNome());
		
        return "hello";
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(String login, String senha){
		
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(String login, String senha,RedirectAttributes attributes){
		
		ModelAndView mv;
		
		Cliente cliente = clienteService.buscarPF(login);
		
		if(cliente != null){
			
			attributes.addFlashAttribute("message","Bem Vindo" + cliente.getNome());
			attributes.addFlashAttribute("cliente", cliente);
			mv = new ModelAndView("redirect:cliente");
			
		}else{
			
			mv = new ModelAndView("redirect:login");
			attributes.addFlashAttribute("message","Login incorreto ou não existe!");
		}
		
		return mv;
	}
	
	
}
