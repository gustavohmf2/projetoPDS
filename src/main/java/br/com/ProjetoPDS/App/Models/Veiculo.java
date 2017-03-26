package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@OneToOne
	@JoinColumn(name="id_infoExtraVeiculo")
	private InfoExtraVeiculo infoExtraVeiculo;
	@ManyToOne
	@JoinColumn(name="id_numeroChassi", insertable=false, updatable=false)
	private Cliente cliente;
	
	

	public InfoExtraVeiculo getInfoExtra() {
		return infoExtraVeiculo;
	}
	public void setInfoExtra(InfoExtraVeiculo infoExtraVeiculo) {
		this.infoExtraVeiculo = infoExtraVeiculo;
	}
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

	
	
}
