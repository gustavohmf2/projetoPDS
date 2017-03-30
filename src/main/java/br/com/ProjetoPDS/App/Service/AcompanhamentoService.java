package br.com.ProjetoPDS.App.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.App.Repository.AlertaRepository;
import br.com.ProjetoPDS.App.Repository.ClienteRepository;
import br.com.ProjetoPDS.App.Repository.VeiculoRepository;

@Service
public class AcompanhamentoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LogicaAcompanhamento logicaAcompanhamento;
	
	@Autowired
	private AlertaRepository alerta;
	

	public void verificaVeiculo(Cliente cliente){
		
		Veiculo veiculo = cliente.getVeiculo().get(0);
		List<Alerta> alertas = new ArrayList<Alerta>();
		
		alertas.add(logicaAcompanhamento.verificarRevisao(veiculo));
		alertas.add(logicaAcompanhamento.alinhamentoBalanceamento(veiculo));
		
		if(!alertas.isEmpty()){
			
			for(int i = 0; i < alertas.size(); i++){
				
				cliente.addAlertas(alertas.get(i));
			}
			
		}
			
	}
	
}
