package br.com.ProjetoPDS.App.Models;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ProjetoPDS.App.Enumeracoes.TipoAlerta;

@Entity
public class Alerta {

	
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String descricao;
	private Calendar data;
	private TipoAlerta tipo;
	@ManyToOne(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id_numeroChassi")
	private Veiculo veiculo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
}
