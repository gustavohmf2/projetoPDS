package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;

import javax.persistence.Entity;




@Entity
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IdentidadeVeiculo identidade;
	InfoExtraVeiculo infoExtra;
	
	
	public IdentidadeVeiculo getIdentidade() {
		return identidade;
	}
	public void setIdentidade(IdentidadeVeiculo identidade) {
		this.identidade = identidade;
	}
	public InfoExtraVeiculo getInfoExtra() {
		return infoExtra;
	}
	public void setInfoExtra(InfoExtraVeiculo infoExtra) {
		this.infoExtra = infoExtra;
	}
	

	
	
}
