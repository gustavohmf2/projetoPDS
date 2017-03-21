package br.com.ProjetoPDS.App.Models;

import java.util.Map;

import javax.persistence.Entity;

@Entity
public class Orcamento {

	private Double precoMaoObra;
	private Map<String, Double> pecasTroca;// nome da peça valor
	private String obs;
	
	public Orcamento() {
		// TODO Auto-generated constructor stub
	}

	public Double getPrecoMaoObra() {
		return precoMaoObra;
	}

	public void setPrecoMaoObra(Double precoMaoObra) {
		this.precoMaoObra = precoMaoObra;
	}

	public Map<String, Double> getPecasTroca() {
		return pecasTroca;
	}

	public void setPecasTroca(Map<String, Double> pecasTroca) {
		this.pecasTroca = pecasTroca;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
	
}
