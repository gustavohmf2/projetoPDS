package br.com.ProjetoPDS.framework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Peca {

	@Id
	@Column(name="id_peca")
	private Long id;
	private String nome;
	private Float preco;
	private String descricao;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_orcamento")
	private Orcamento orcamento;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
