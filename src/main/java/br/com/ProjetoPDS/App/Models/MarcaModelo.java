package br.com.ProjetoPDS.App.Models;


import javax.persistence.Entity;

/**
 * Definico com id e nome de marca e modelo
 * @author carlos
 *
 */
@Entity
public class MarcaModelo {
	private int idMarca;
	private String marca;
	
	private int idModelo;
	private String modelo;

	public MarcaModelo(int idMarca, String marca, int idModelo, String modelo){
		this.idMarca = idMarca;
		this.marca = marca;
		
		this.idModelo = idModelo;
		this.modelo = modelo;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
