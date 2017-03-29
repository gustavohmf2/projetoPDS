package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Servico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servico")
	private Integer id;
	private Integer status;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataRequerimento;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar prazoFinal;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(insertable=false, name="id_cliente")
	private Cliente cliente;
	private Veiculo veiculo;
	private String notaFiscal;
	@OneToMany(mappedBy="servico", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Orcamento> orcamento;
	private String descricao;
	private String obs;
	
	
	public Servico() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Integer getIdServico() {
		return id;
	}
	public void setIdServico(Integer idServico) {
		this.id = idServico;
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
		return cliente;
	}
	public void setResponsavel(Cliente cliente) {
		this.cliente = cliente;
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
	public List<Orcamento> getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(List<Orcamento> orcamento) {
		this.orcamento = orcamento;
	}
	public void addOrcamento(Orcamento orcamento){
		
		setOrcamento(new ArrayList<Orcamento>());
		this.orcamento.add(orcamento);
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
