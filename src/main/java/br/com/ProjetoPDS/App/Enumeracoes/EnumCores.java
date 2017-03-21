package br.com.ProjetoPDS.App.Enumeracoes;

public enum EnumCores {
	
	BRANCO, PRETO, CINZA, AMARELO, VERMELHO, PRATA;
	
	public static String getCorById(Integer id){
		for (EnumCores cores : EnumCores.values()) {
			if(EnumCores.valueOf(cores.toString()).ordinal() == id){
				return EnumCores.valueOf(cores.toString()).toString();
			}
		}
		return null;
	}
	
	public Integer getId(){
		return this.ordinal();
	}

	public String getCorStringById(Integer idCor){
		return EnumCores.getCorById(idCor).toString();
	}
	
	
	
	
}
