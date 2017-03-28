package br.com.ProjetoPDS.App.Controller;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Endereco;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.IClienteService;

@Controller
public class HomeController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping("/hello")
	public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		
		
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		endereco.setUf("RN");
		endereco.setCep("58243-770");
		endereco.setCidade("Patu");
		endereco.setBairro("Planalto");
		endereco.setNumero(12);
		
		cliente.setId("0873427222");
		cliente.setTipo(TipoPessoa.FISICA);
		cliente.setNome("dudu");
		cliente.setDataNascimento(new GregorianCalendar(1992,07,07));
		cliente.setEndereco(endereco);
		cliente.setSexo("masculino");
		
		
		clienteService.inserir(cliente);
		model.addAttribute("name", name);
        return "hello";
	}
	
	

}
