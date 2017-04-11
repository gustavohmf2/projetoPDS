package br.com.ProjetoPDS.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.OficinaService;

@Controller
@RequestMapping("/oficina")
public class OficinaController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/cadastro")
	public ModelAndView formCadastroOficina(){
		ModelAndView mv = new ModelAndView("/oficina/cadastro");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView cadastroOficina(Cliente cliente){
		ModelAndView mv = new ModelAndView("redirect:/oficina/cadastro");
		cliente.setTipo(TipoPessoa.JURIDICA.ordinal());
		clienteService.inserir(cliente);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
}
