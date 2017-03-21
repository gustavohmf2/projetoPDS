package br.com.ProjetoPDS.App.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;
/**
 * Representa dados "estaticos" do veiculo
 * @author carlos
 *
 */
@Entity
public class IdentidadeVeiculo {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	private Integer numeroChassi;
	private String placa;
	private MarcaModelo marcaModelo;
	private Integer ano;
	private Integer cor = new Integer(EnumCores.BRANCO.getId());
	private Integer cambio;
	
	
	
	public Integer getNumeroChassi() {
		return numeroChassi;
	}
	public void setNumeroChassi(Integer numeroChassi) {
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
	
}
