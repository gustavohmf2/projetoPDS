package br.com.ProjetoPDS.framework.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;

@Entity
public class Servico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servico")
	private Integer id;
	private EnumStatus status;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dataRequerimento;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar prazoFinal;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_oficina")
	private Prestadora oficina;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.MERGE)
	@JoinColumn(name="id_cliente")
	private Contratante cliente;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_veiculo")
	private Produto veiculo;
	
	private String notaFiscal;

	@OneToMany(mappedBy="servico", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private List<Orcamento> orcamento;
	
	@OneToMany(mappedBy="servico", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private List<CheckIn> checkin;


	
	private String descricao;
	private String obs;
	
	public Servico() {	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getPrazoFinal() {
		return prazoFinal;
	}

	public void setPrazoFinal(Calendar prazoFinal) {
		this.prazoFinal = prazoFinal;
	}
	
	public Prestadora getOficina(){
		return oficina;
	}

	public void setOficina(Prestadora oficina){
		this.oficina = oficina;
	}

	public Contratante getCliente() {
		return cliente;
	}

	public void setCliente(Contratante cliente) {
		this.cliente = cliente;
	}
	
	public Integer getIdServico() {
		return id;
	}
	public void setIdServico(Integer idServico) {
		this.id = idServico;
	}
	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	public Date getDataRequerimento() {
		return dataRequerimento;
	}
	public void setDataRequerimento(Date dataRequerimento) {
		this.dataRequerimento = dataRequerimento;
	}
	public Contratante getResponsavel() {
		return cliente;
	}
	public void setResponsavel(Contratante cliente) {
		this.cliente = cliente;
	}
	public Produto getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Produto veiculo) {
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

	public List<CheckIn> getCheckin() {
		return checkin;
	}

	public void setCheckin(List<CheckIn> checkin) {
		this.checkin = checkin;
	}
	
	public void addCheckin(CheckIn checkin){
		
		setCheckin(new ArrayList<CheckIn>());
		this.checkin.add(checkin);
	}
	
}
