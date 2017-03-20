package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	private String placa;
	//marca 
	private MarcasVeiculos marca;
	//modelo
	private Integer quilometragem;
	//cambio
	
	private Integer numeroChassi;
	private Integer cor;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar ultimaTrocaOleo;
	
	
	

	
	
}
