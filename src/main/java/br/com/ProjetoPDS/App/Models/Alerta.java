package br.com.ProjetoPDS.App.Models;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ProjetoPDS.App.Enumeracoes.TipoAlerta;

@Entity
public class Alerta {

	
	@Id
	private Long id;
	private String descricao;
	private Calendar data;
	private TipoAlerta tipo;
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
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
	
	
	
}
