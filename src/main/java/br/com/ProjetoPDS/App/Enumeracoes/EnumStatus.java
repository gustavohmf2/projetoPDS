package br.com.ProjetoPDS.App.Enumeracoes;

public enum EnumStatus {
	PRE_DIGNOSTICO("pré-diagnostico"),
	VISTORIA_PENDENTE("Vistoria pendente"), 
	AUTORIZACAO_PENDENTE("Autorizacao pendente"), 
	SERVICO_AUTORIZADO("Serviço autorizado"), 
	SERVICO_NAO_AUTORIZADO("Serviço não autorizado"), 
	AGUARDANDO_PECAS("Aguardando peças"), 
	AGUARDANDO_CLIENTE("Aguardando cliente"), 
	EM_ANDAMENTO("Em andamento"),
	AGUARDANDO_COMPLEMENTO("Aguardando complemento"),
	FINALIZADO("Finalizado");
	
	private String titulo;
	
	EnumStatus(String titulo){
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getId(){
		return this.ordinal();
	}
	
	
}
