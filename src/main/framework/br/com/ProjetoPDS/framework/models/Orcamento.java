package br.com.ProjetoPDS.framework.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_orcamento")
	private Long id;
	private Double precoMaoObra;
	@OneToMany(mappedBy="orcamento", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Peca> pecasTroca;// nome da peça valor
	private String obs;
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico servico;
	
	public Orcamento() {
		// TODO Auto-generated constructor stub
	}

	public Double getPrecoMaoObra() {
		return precoMaoObra;
	}

	public void setPrecoMaoObra(Double precoMaoObra) {
		this.precoMaoObra = precoMaoObra;
	}

	public List<Peca> getPecasTroca() {
		return pecasTroca;
	}

	private void setPecasTroca(List<Peca> pecasTroca) {
		this.pecasTroca = pecasTroca;
	}
	
	public void addPeca(Peca peca){
		
		setPecasTroca(new ArrayList<Peca>());
		pecasTroca.add(peca);
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
