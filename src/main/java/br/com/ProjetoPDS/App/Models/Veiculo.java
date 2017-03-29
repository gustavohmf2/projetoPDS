package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;


@Entity
public class Veiculo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_numeroChassi")
	private String numeroChassi;
	private String placa;
	@OneToOne
	@JoinColumn(name="id_marcaModelo")
	private MarcaModelo marcaModelo;
	private Integer ano;
	private Integer cor = new Integer(EnumCores.BRANCO.getId());
	private Integer cambio;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_infoExtraVeiculo")
	private InfoExtraVeiculo infoExtraVeiculo;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente", insertable=false, updatable=false)
	private Cliente cliente;
	
	

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
	public Integer getCor() {
		return cor;
	}
	public void setCor(Integer cor) {
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

	
	
}
