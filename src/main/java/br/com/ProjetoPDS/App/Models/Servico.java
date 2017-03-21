package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Servico implements Serializable{


	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idServico;
	private Integer status;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataRequerimento;
	private Cliente responsavel;
	private Veiculo veiculo;
	private String notaFiscal;
	private Orcamento orcamento;
	private String descricao;
	private String obs;
	
	public Servico() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Integer getIdServico() {
		return idServico;
	}
	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Calendar getDataRequerimento() {
		return dataRequerimento;
	}
	public void setDataRequerimento(Calendar dataRequerimento) {
		this.dataRequerimento = dataRequerimento;
	}
	public Cliente getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Cliente responsavel) {
		this.responsavel = responsavel;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
	
}
