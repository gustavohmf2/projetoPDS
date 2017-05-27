package br.com.ProjetoPDS.framework.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.ProjetoPDS.App.Enumeracoes.EnumCores;


@Entity
public class Produto implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_produto")
	private String id;
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.MERGE)
	@JoinColumn(name="id_contratante")
	private Contratante cliente;

	@OneToMany(mappedBy="produto", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.REFRESH})
	private List<Servico> servicos;
	

	public Contratante getCliente() {
		return cliente;
	}
	public void setCliente(Contratante cliente) {
		this.cliente = cliente;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos() {
		this.servicos = new ArrayList<Servico>();
	}
	public void addServico(Servico servico){
		setServicos();
		this.servicos.add(servico);
	}
	
	
}
