package br.com.ProjetoPDS.App.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PessoaFisica extends Cliente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String cpf;
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
