package br.com.ProjetoPDS.App.Enumeracoes;

public enum EnumStatus {
	PRE_DIGNOSTICO("pré-diagnostico"),//status 0
	VISTORIA_PENDENTE("Vistoria pendente"),//status 1 
	AUTORIZACAO_PENDENTE("Autorizacao pendente"),//status 2 
	SERVICO_AUTORIZADO("Serviço autorizado"), //status 3
	SERVICO_NAO_AUTORIZADO("Serviço não autorizado"), //status 4
	AGUARDANDO_PECAS("Aguardando peças"), //status 5
	AGUARDANDO_CLIENTE("Aguardando cliente"), //status 6
	EM_ANDAMENTO("Em andamento"),//status 7
	AGUARDANDO_COMPLEMENTO("Aguardando complemento"),// status 8
	FINALIZADO("Finalizado");// status 9
	
	private String titulo;
	
	EnumStatus(String titulo){
		this.titulo = titulo;
	}

	public static String getTitulo(Integer id) {
		
		for (EnumStatus marca : EnumStatus.values()) {
			
			System.out.println(marca.ordinal());
			
			if(marca.ordinal() == id){
				return EnumStatus.valueOf(marca.toString()).titulo;
			}
		}
		return "--";
	}

	public Integer getId(){
		return this.ordinal();
	}
	
	
	
	
}
