package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Oficina implements Serializable{
	

	@Id
	@Column(name="id_oficina")
	private String id;
	private String nome;
	private String telefone;
	private String telefoneAlt;
	private String email;
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy="oficina", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Servico> servicos;
	
	public Oficina(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefoneAlt() {
		return telefoneAlt;
	}
	public void setTelefoneAlt(String telefoneAlt) {
		this.telefoneAlt = telefoneAlt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
