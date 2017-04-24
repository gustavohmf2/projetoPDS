package br.com.ProjetoPDS.App.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CheckIn {

	@Id
	@Column(name="id_checkin")
	private Integer id;//id so serviço
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dataHora;
	private String acao;
	
	public CheckIn(Integer id, Date dataHora, String acao) {
		this.id = id;
		this.dataHora = dataHora;
		this.acao = acao;
	}
	
	public CheckIn() {
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	
	
}
