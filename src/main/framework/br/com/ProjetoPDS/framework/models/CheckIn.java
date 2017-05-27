package br.com.ProjetoPDS.framework.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CheckIn {

	@Id
	@Column(name="id_checkin")
	private Integer id;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dataHora;
	private String acao;
	private Integer classificacao;
	private String descricao;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.REMOVE)
	@JoinColumn(name="id_servico")
	private Servico servico;
	
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
	
	public Integer getClassficacao() {
		return classificacao;
	}

	public void setClassficacao(Integer classficacao) {
		this.classificacao = classficacao;
	}

	public Servico getVeiculo() {
		return servico;
	}

	public void setVeiculo(Servico servico) {
		this.servico = servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
}
