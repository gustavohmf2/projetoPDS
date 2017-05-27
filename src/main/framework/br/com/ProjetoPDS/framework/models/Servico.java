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
	@JoinColumn(name="id_prestadora")
	private Prestadora prestadora;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.MERGE)
	@JoinColumn(name="id_contratante")
	private Contratante contratante;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_produto")
	private Produto produto;
	
	private String notaFiscal;

	@OneToMany(mappedBy="servico", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private List<Orcamento> orcamentos;
	
	@OneToMany(mappedBy="servico", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private List<CheckIn> checkIns;
	
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
		return prestadora;
	}

	public void setOficina(Prestadora oficina){
		this.prestadora = oficina;
	}

	public Contratante getCliente() {
		return contratante;
	}

	public void setCliente(Contratante cliente) {
		this.contratante = cliente;
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
		return contratante;
	}
	public void setResponsavel(Contratante cliente) {
		this.contratante = cliente;
	}
	public Produto getVeiculo() {
		return produto;
	}
	public void setVeiculo(Produto veiculo) {
		this.produto = veiculo;
	}
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public List<Orcamento> getOrcamento() {
		return orcamentos;
	}
	public void setOrcamento(List<Orcamento> orcamento) {
		this.orcamentos = orcamento;
	}
	public void addOrcamento(Orcamento orcamento){
		
		setOrcamento(new ArrayList<Orcamento>());
		this.orcamentos.add(orcamento);
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

	public List<CheckIn> getCheckIns() {
		return checkIns;
	}

	public void setCheckIns(List<CheckIn> checkin) {
		this.checkIns = checkin;
	}
	
	public void addCheckIn(CheckIn checkin){
		
		setCheckIns(new ArrayList<CheckIn>());
		this.checkIns.add(checkin);
	}
	
}
