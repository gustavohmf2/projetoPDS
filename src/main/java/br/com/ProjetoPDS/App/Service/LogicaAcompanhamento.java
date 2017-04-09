package br.com.ProjetoPDS.App.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ProjetoPDS.App.Enumeracoes.TipoAlerta;
import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Veiculo;

@Component
public class LogicaAcompanhamento {
	
	private final int MILLIS_IN_DAY = 86400000;
	
	private GregorianCalendar hoje; 
	
	public LogicaAcompanhamento(){
		
		hoje = new GregorianCalendar();
	}
	
	public Alerta verificarRevisao(Veiculo veiculo) {
		
		Alerta alerta = new Alerta();
		
		if( veiculo.getInfoExtraVeiculo() != null){
			System.out.println("verificando revisão");
			Double infoKmTotal = veiculo.getInfoExtraVeiculo().getKmTotal();
			
			Calendar ultimaRevisao = veiculo.getInfoExtraVeiculo().getUltimaRevisao();
			
			Long dias = hoje.getTimeInMillis() - ultimaRevisao.getTimeInMillis() / MILLIS_IN_DAY;
			Long meses = dias / 30;
			
		
			if((infoKmTotal >= 10000 && infoKmTotal < 20000) || meses >= 6){
				
				alerta.setData(hoje);
				alerta.setDescricao("Revisão dos 10.000 Km");
				alerta.setTipo(TipoAlerta.REVISAO);
				
			}else if((infoKmTotal >= 20000 && infoKmTotal < 30000) || meses >= 12){
				
				alerta.setData(hoje);
				alerta.setDescricao("Revisão dos 20.000 Km");
				alerta.setTipo(TipoAlerta.REVISAO);
				
			}else if((infoKmTotal >= 30000 && infoKmTotal < 40000) || meses >= 18){
				
				alerta.setData(hoje);
				alerta.setDescricao("Revisão dos 30.000 Km");
				alerta.setTipo(TipoAlerta.REVISAO);
				
			}else if((infoKmTotal >= 40000 && infoKmTotal < 50000)  || meses >= 24){
				
				alerta.setData(hoje);
				alerta.setDescricao("Revisão dos 40.000 Km");
				alerta.setTipo(TipoAlerta.REVISAO);
				
			}else if((infoKmTotal >= 50000 && infoKmTotal < 60000)  || meses >= 30){
				
				alerta.setData(hoje);
				alerta.setDescricao("Revisão dos 50.000 Km");
				alerta.setTipo(TipoAlerta.REVISAO);
				
			}else if((infoKmTotal >= 60000   && infoKmTotal < 70000)|| meses >= 36){
				
				alerta.setData(hoje);
				alerta.setDescricao("Revisão dos 60.000 Km");
				alerta.setTipo(TipoAlerta.REVISAO);
			}
		}
		
		return alerta;
	}
	
	public List<Alerta> verificaPneu(Veiculo veiculo){
		
		if( veiculo.getInfoExtraVeiculo() != null){
		
			Calendar ultimaTroca = veiculo.getInfoExtraVeiculo().getUltimaTrocaPneu();
			
			Long meses = hoje.getTimeInMillis() - ultimaTroca.getTimeInMillis();
			
			if(meses >= 10){
				
			}
		}
		
		return null;
	}
	
	public Alerta alinhamentoBalanceamento(Veiculo veiculo){
		
		Alerta alerta = new Alerta();
		
		if( veiculo.getInfoExtraVeiculo().getKmAnterior() != null){
			Double ultimaKilometragem = veiculo.getInfoExtraVeiculo().getKmAnterior();
			
			if(ultimaKilometragem >= 10000){
				
				alerta.setData(hoje);
				alerta.setTipo(TipoAlerta.ALINHAMENTO_BALANCEAMENTO);
				alerta.setDescricao("Possível necessidade de realizar os serviços de alinhamento e balanceamento");
				
			}
		}
		
		return alerta;
	}
	
	
	
	
	
}
