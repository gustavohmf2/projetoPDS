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
		endereco.setCep("51234-730");
		endereco.setCidade("Nova Cruz");
		endereco.setBairro("Bela Vista");
		endereco.setNumero(32);
		
<<<<<<< HEAD
		cliente.setId("12398754380");
		cliente.setTipo(TipoPessoa.FISICA);
		cliente.setNome("Roberval Camargo");
		cliente.setDataNascimento(new GregorianCalendar(1974,05, 8));
=======
		cliente.setId("0873427222");
		cliente.setTipo(TipoPessoa.FISICA);
		cliente.setNome("dudu");
		cliente.setDataNascimento(new GregorianCalendar(1992,07,07));
>>>>>>> 88fe9789479a91a1d24f331a70c8ec3f484d75b7
		cliente.setEndereco(endereco);
		cliente.setSexo("masculino");
		
		
<<<<<<< HEAD
		model.addAttribute("name", cliente.getNome());
=======
		clienteService.inserir(cliente);
		model.addAttribute("name", name);
>>>>>>> 88fe9789479a91a1d24f331a70c8ec3f484d75b7
        return "hello";
	}
	
	

}
