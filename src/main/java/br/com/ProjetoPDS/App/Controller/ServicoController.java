package br.com.ProjetoPDS.App.Controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;
import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Models.CheckIn;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Models.Veiculo;

import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.OficinaService;
import br.com.ProjetoPDS.App.Service.ServicoService;
import br.com.ProjetoPDS.App.Service.VeiculoService;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private OficinaService oficinaService;
	@Autowired
	private ServicoService servicoService;
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping("/novoServico")
	public ModelAndView formServico(@RequestParam(name="id", required=true) String id, HttpSession session, String descricao){

		ModelAndView mv = new ModelAndView("/servico/formServico");
		Servico servico = new Servico();
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		Cliente temp = clienteService.buscarPorId(cliente.getId());
		
		List<Veiculo> veiculos = temp.getVeiculo();
		List<Oficina> oficinas = oficinaService.buscarTodos();
		
		if(descricao != null){
			servico.setDescricao(descricao);
		}
		
		mv.addObject("servico", servico);
		mv.addObject("veiculos", veiculos);
		mv.addObject("oficinas", oficinas);
		
		return mv;
	}

	@PostMapping("/novoServico")
	public ModelAndView cadastrarServico(Servico servico, HttpSession session, RedirectAttributes attributes){

		ModelAndView mv = new ModelAndView("redirect:/cliente");
		Cliente tmp = (Cliente) session.getAttribute("usuario");
		Cliente cliente = clienteService.buscarPorId(tmp.getId());

		servico.setStatus(EnumStatus.PRE_DIAGNOSTICO);
		
		System.out.println("Veiculo: " + servico.getVeiculo().getNumeroChassi());
		servico.setOficina(oficinaService.buscarPJ(servico.getOficina().getId()));
		servico.setVeiculo(veiculoService.buscarPorId(servico.getVeiculo().getNumeroChassi()));
		servico.setResponsavel(cliente);
		cliente.addServico(servico);
		
		servicoService.inserir(servico);
		attributes.addAttribute("message", "nova visita marcada!");

		return mv;
		
	}
	
	@GetMapping("/novoServicoOficina")
	public ModelAndView formServicoOficina(@RequestParam(name="id", required=true) String id, HttpSession session, String descricao){

		ModelAndView mv = new ModelAndView("/servico/formServicoOficina");
		Servico servico = new Servico();
		
		//Pegando informações para veículo
		List<String> marcas = veiculoService.listarMarcas();
		mv.addObject("cores", EnumCores.values());
		mv.addObject("marcas", marcas);
		
		mv.addObject("servico", servico);
		
		return mv;
	}
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos( String marca){
		
		List<String> modelos = veiculoService.listarMarcaModelo(marca);
		
		return modelos;
		
	}
	
	@PostMapping("/novoServicoOficina")
	public ModelAndView cadastrarServicoOficina(Servico servico, HttpSession session, RedirectAttributes attributes){

		ModelAndView mv = new ModelAndView("redirect:/oficina");
		Oficina tmp = (Oficina) session.getAttribute("usuario");
		Oficina oficina = oficinaService.buscarPorId(tmp.getId());

		servico.setStatus(EnumStatus.PRE_DIAGNOSTICO);
		servico.setOficina(oficina);
		
		Cliente cliente = clienteService.buscarPF(servico.getCliente().getId());
		
		if(cliente == null){
			attributes.addAttribute("message", "Cliente não cadastrado.");
			System.out.println("o cliente não está cadastrado");
			return mv;
		}
		else{
			Veiculo veiculoAtual = null;
			List<Veiculo> veiculos = cliente.getVeiculo();
			for (int i = 0; i < veiculos.size(); i++) {
				if(veiculos.get(i).getPlaca().equals(servico.getVeiculo().getPlaca())){
					veiculoAtual = veiculoService.buscarPorId(veiculos.get(i).getNumeroChassi());
				}
			}
			
			if(veiculoAtual == null){
				attributes.addFlashAttribute("message", "Carro não cadastrado.");
				System.out.println("o carro não está cadastrado");
				return mv;
			}
			
			servico.setCliente(cliente);
			servico.setVeiculo(veiculoAtual);
			oficina.addServico(servico);
			cliente.addServico(servico);
			servicoService.inserir(servico);
		}
		
		
		/*System.out.println("Veiculo: " + servico.getVeiculo().getNumeroChassi());
		cliente.addServico(servico);
		servico.setResponsavel(cliente);

		servicoService.inserir(servico);
		attributes.addAttribute("message", "Nova visita marcada!");*/

		return mv;

	}

	@GetMapping("/relatorio")
	public ModelAndView relatorio(@RequestParam(name="id", required=true) Integer id){
		
		ModelAndView mv = new ModelAndView("/servico/relatorioServico");
		
		Servico servico = servicoService.buscarPorId(id);
		mv.addObject("servico",servico);
		
		return mv;
		
	}
	
	@GetMapping("/proximoStatus")
	public ModelAndView proximoStatus(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.proximoStatus(id);
		return mv;
	}
	
	@GetMapping("/aprovarServico")
	public ModelAndView aprovarServico(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.aprovarOrcamentoServico(id);
		return mv;
	}
	
	@GetMapping("/vistoriaPendente")
	public ModelAndView vistoriaPendente(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.vistoriaPendente(id);
		return mv;
	}
	
	@GetMapping("/naoAutorizado")
	public ModelAndView naoAutorizado(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.vistoriaPendente(id);
		return mv;
	}
	
	@GetMapping("/aguardandoPecas")
	public ModelAndView aguardandoPecas(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.aguardandoPecas(id);
		return mv;
	}
	
	@GetMapping("/aguardandoCliente")
	public ModelAndView aguardandoCliente(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.aguardandoCliente(id);
		return mv;
	}
	
	@GetMapping("/emAndamento")
	public ModelAndView emAndamento(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.emAndamento(id);
		return mv;
	}
	
	@GetMapping("/finalizado")
	public ModelAndView finalizado(@RequestParam(name="id", required=true) Integer id){

		ModelAndView mv = new ModelAndView("redirect:/oficina");		
		servicoService.finalizado(id);
		return mv;
	}
	
	@GetMapping("/acompanhamento")
	public ModelAndView acompanhamento(@RequestParam(name="id", required=true) Integer id){
		
		ModelAndView mv = new ModelAndView("/servico/acompanhamento");	
		
		Servico servico =  servicoService.buscarPorId(id);
		List<CheckIn> lista = null;
		
		
		
		if(servico != null){
			
			lista = servico.getCheckin();
			
			if(lista.isEmpty()){
				
				mv.addObject("msg", "Não há informações sobre o andamento do serviço nesse momento!");
				
			}else{
				
				mv.addObject("lista", lista);
			}
				
		}
		
		return mv;
	}
	
	
	@GetMapping("/finalizar")
	public ModelAndView finalizarServico(@RequestParam(name="id", required=true) Integer id, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("redirect:/cliente");	
		
		//verifica se chegou no checkin de serviço finalizado para remover o servico
		servicoService.verificarServico(id);
		attributes.addAttribute("msg", "Serviço finalizado !");

		return mv;
	}

	
}
