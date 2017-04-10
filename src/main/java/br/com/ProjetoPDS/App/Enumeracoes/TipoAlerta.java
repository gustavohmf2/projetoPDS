package br.com.ProjetoPDS.App.Enumeracoes;

public enum TipoAlerta {
	
		REVISAO,TROCAPNEU,TROCAOLEO, ALINHAMENTO_BALANCEAMENTO;
	
	public Integer getId(){
		return this.ordinal();
	}
}
