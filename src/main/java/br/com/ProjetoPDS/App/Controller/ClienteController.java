package br.com.ProjetoPDS.App.Controller;

import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.Veiculo;
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
	
	@RequestMapping(method=RequestMethod.GET)
	public String cliente( Model model){
		
	
		return "cliente/cliente";
	}
	
	@RequestMapping("/form")
	public String formCliente(Model model){
		
		
		return "cliente/form";
		
	}
	
	@RequestMapping("/salvar")
	public String salvarCliente(@RequestParam(name="cliente") Cliente cliente, Model model){
		
		System.out.println(cliente.getNome());
		
		return "cliente/form";
		
	}
	
	@RequestMapping("/formVeiculo")
	public String formVeiculo(@RequestParam(name="cpf", required=false, defaultValue="12398754380") String cpf, Model model){
		
		Cliente cliente = clienteService.buscarPF(cpf);
		
		
		Veiculo veiculo = new Veiculo();
		
								 
		veiculo.setNumeroChassi("562nkadh92390");
		veiculo.setPlaca("JVM-7321");
		veiculo.setMarcaModelo(veiculoService.listarMarcaModelo().get(1));
		veiculo.setCor(1);
		
		cliente.addVeiculo(veiculo);
		
		veiculo.setCliente(cliente);
		
		clienteService.atualizarCliente(cliente);
		
		
		return "cliente/formVeiculo";
	}
	
	@RequestMapping("formVeiculo/adicionar")
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
	
	@RequestMapping("/addInfoExtraVeiculo")
	public String addInfoExtraVeiculo(@RequestParam(name="id", required=true) String id, Model model){
		
		System.out.println(id);
		
		Veiculo veiculo = veiculoService.buscarVeiculo(id);
		
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


		veiculoService.atualizar(veiculo);
		
		model.addAttribute("cliente", clienteService.buscarPF(id));
		
		return "cliente/meusVeiculos";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
