package br.com.ProjetoPDS.framework.models.status;

public abstract class Status {
	private String nome;
	private Integer id;
	
	public Status(String nome) {
		this.nome = nome;
	}
	
	public abstract Status iniciar();
	public abstract Status parar();
	public abstract Status proximo();
	public abstract Status reiniciar();
	public abstract Status finalizar();
	
	public String getNome(){
		return nome;
	}
	
}
