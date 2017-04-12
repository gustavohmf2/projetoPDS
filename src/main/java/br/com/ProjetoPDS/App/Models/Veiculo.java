package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;


@Entity
public class Veiculo implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_numeroChassi")
	private String numeroChassi;
	private String placa;
	@OneToOne
	@JoinColumn(name="id_marcaModelo")
	private MarcaModelo marcaModelo;
	private Integer ano;
	private EnumCores cor;
	private Integer cambio;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_infoExtraVeiculo")
	private InfoExtraVeiculo infoExtraVeiculo;
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	@OneToMany(mappedBy="veiculo", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Alerta> alertas;
	

	public String getNumeroChassi() {
		return numeroChassi;
	}
	public void setNumeroChassi(String numeroChassi) {
		this.numeroChassi = numeroChassi;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public MarcaModelo getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(MarcaModelo marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public EnumCores getCor() {
		return cor;
	}
	public void setCor(EnumCores cor) {
		this.cor = cor;
	}
	public Integer getCambio() {
		return cambio;
	}
	public void setCambio(Integer cambio) {
		this.cambio = cambio;
	}
	public InfoExtraVeiculo getInfoExtraVeiculo() {
		return infoExtraVeiculo;
	}
	public void setInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo) {
		this.infoExtraVeiculo = infoExtraVeiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Alerta> getAlertas() {
		return alertas;
	}
	public void setAlertas() {
		this.alertas = new ArrayList<Alerta>();
	}
	public void addAlertas(Alerta novoAlerta){
		setAlertas();
		this.alertas.add(novoAlerta);
	}
	
	
}
