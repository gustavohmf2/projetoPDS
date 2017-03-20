package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import antlr.collections.List;

public class Servico implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer status;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataRequerimento;
	private Cliente responsavel;
	private Veiculo veiculo;
	private String notaFiscal;
	private Float orcamento;
	private Map<String, Float> pecasTroca;// nome da peça valor
	private String obs;
	
}
