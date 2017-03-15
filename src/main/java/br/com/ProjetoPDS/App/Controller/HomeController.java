package br.com.ProjetoPDS.App.Controller;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Endereco;
import br.com.ProjetoPDS.App.Repository.ClienteRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping("/hello")
	public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		
		
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		endereco.setUf("RN");
		endereco.setCep("59140-780");
		endereco.setCidade("Parnamirim");
		endereco.setBairro("Cohabinal");
		endereco.setNumero(9);
		
		cliente.setCpf("09232578450");
		cliente.setNome("Gustavo Henrique Miguel Ferreira");
		cliente.setDataNascimento(new GregorianCalendar(1992,07,07));
		cliente.setEndereco(endereco);
		cliente.setSexo("masculino");
		
		clienteRepository.save(cliente);
		
		clienteRepository.save(cliente);
		
		model.addAttribute("name", name);
        return "hello";
	}

}
