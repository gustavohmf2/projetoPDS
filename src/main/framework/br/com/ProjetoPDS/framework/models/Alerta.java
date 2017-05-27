package br.com.ProjetoPDS.framework.models;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ProjetoPDS.App.Enumeracoes.TipoAlerta;

@Entity
public class Alerta implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_alerta")
	private Integer id;
	private String descricao;
	private Calendar data;
	@Enumerated(EnumType.STRING)
	private TipoAlerta tipo;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.REMOVE)
	@JoinColumn(name="id_numeroChassi")
	private Produto veiculo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public TipoAlerta getTipo() {
		return tipo;
	}
	public void setTipo(TipoAlerta tipo) {
		this.tipo = tipo;
	}
	public Produto getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Produto veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
}
