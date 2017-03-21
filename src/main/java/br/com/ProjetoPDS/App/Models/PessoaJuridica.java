package br.com.ProjetoPDS.App.Models;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica {

	private Integer cnpj;
	
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
