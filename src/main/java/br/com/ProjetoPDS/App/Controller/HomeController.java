package br.com.ProjetoPDS.App.Controller;

import java.sql.Date;
import java.util.ArrayList;

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

import br.com.ProjetoPDS.App.Enumeracoes.EnumMarcasModelos;
import br.com.ProjetoPDS.App.Models.CheckIn;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Repository.MarcaModeloRepository;
import br.com.ProjetoPDS.App.Service.CheckInService;
import br.com.ProjetoPDS.App.Service.ClienteService;
import br.com.ProjetoPDS.App.Service.DataFacadeService;
import br.com.ProjetoPDS.App.Service.OficinaService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private OficinaService oficinaService;
	@Autowired
	private CheckInService checkInService;
	@Autowired
	private MarcaModeloRepository mmRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("index");
		
		ArrayList<CheckIn> lista = (ArrayList<CheckIn>) checkInService.buscarCheckInPorId(321321);
		for (CheckIn checkIn : lista) {
			System.out.println(checkIn.getDataHora()+"  "+checkIn.getAcao());
		}
		
		MarcaModelo mm;
		
		if(mmRepository.findAll().size() == 0){
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					mm = new MarcaModelo();
					mm.setMarca(EnumMarcasModelos.getMarcaById(i).toString());
					mm.setModelo(EnumMarcasModelos.getMarcaById(i).getModeloById(j));
					mmRepository.save(mm);
				}
			}
		}
		
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
			attributes.addFlashAttribute("message","Bem Vindo " + cliente.getNome());
			attributes.addFlashAttribute("cliente", cliente);
			session.setAttribute("usuario", cliente);
			mv = new ModelAndView("redirect:cliente");
		}
		else{
			Oficina oficina = oficinaService.buscarPJ(login);
			
			if(oficina != null){
				attributes.addFlashAttribute("message","Bem Vindo " + oficina.getNome());
				attributes.addFlashAttribute("oficina", oficina);
				session.setAttribute("usuario", oficina);
				mv = new ModelAndView("redirect:oficina");
			}
			
			else{
				mv = new ModelAndView("redirect:login");
				attributes.addFlashAttribute("message","Login incorreto ou não existe!");
			}
		}
		
		return mv;
	}
	
	
}
