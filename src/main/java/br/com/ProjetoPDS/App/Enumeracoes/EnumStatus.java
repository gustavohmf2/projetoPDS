package br.com.ProjetoPDS.App.Enumeracoes;

public enum EnumStatus {
	VISTORIA_PENDENTE("Vistoria pendente"), 
	APROVACAO_PENDETE("Aprovação pendente"), 
	SERVICO_APROVADO("Serviço aprovado"), 
	SERVICO_NAO_APROVADO("Serviço não aprovado"), 
	AGUARDANDO_PECAS("Aguardando peças"), 
	AGUARDANDO_CLIENTE("Aguardando cliente"), 
	EM_ANDAMENTO("Em andamento"), 
	FINALIZADO("Finalizado");
	
	private String titulo;
	
	EnumStatus(String titulo){
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	
	
	
}
