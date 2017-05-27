package br.com.ProjetoPDS.framework.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Definico com id e nome de marca e modelo
 * @author carlos
 *
 */
@Entity
public class MarcaModelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marcaModelo")
	private Long id;
	private String marca;
	private String modelo;
	@OneToOne(mappedBy="marcaModelo", cascade=CascadeType.ALL)
	private Produto veiculo;

	public MarcaModelo(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idMarca) {
		this.id = idMarca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Produto getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Produto veiculo) {
		this.veiculo = veiculo;
	}
	
}
