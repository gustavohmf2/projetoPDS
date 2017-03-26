package br.com.ProjetoPDS.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Veiculo;
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
	
	@RequestMapping("/formVeiculo")
	public String formVeiculo(@RequestParam(name="cpf", required=false, defaultValue="0873427629") String cpf, Model model){
		
		Cliente cliente = clienteService.buscarPF(cpf);
		model.addAttribute("cliente", cliente);
		model.addAttribute("marcaModelos",veiculoService.listarMarcaModelo());
		
		return "cliente/formVeiculo";
	}
}
