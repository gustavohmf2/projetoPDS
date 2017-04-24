package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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

import org.springframework.format.annotation.DateTimeFormat;

import br.com.ProjetoPDS.App.Enumeracoes.TipoPessoa;


@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="id_cliente")
	private String id;
	private String nome;
	private String telefone;
	private String telefoneAlt;
	private String email;
	private String sexo;
	private TipoPessoa tipo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_oficina")
	private Oficina oficina;
	@OneToOne
	private Endereco endereco;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar dataNascimento;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Servico> servico;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Veiculo> veiculo;
	

	public Cliente(){};
	
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Servico> getServico() {
		return servico;
	}
	public void setServico() {
		this.servico = new ArrayList<Servico>();
	}
	public void addServico(Servico servico){
		setServico();
		this.servico.add(servico);
	}
	public TipoPessoa getTipo() {
		return tipo;
	}
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	public List<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setVeiculo() {
		
		this.veiculo = new ArrayList<Veiculo>();
	}
	public void addVeiculo(Veiculo veiculo){
		
		setVeiculo();
		this.veiculo.add(veiculo);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


}