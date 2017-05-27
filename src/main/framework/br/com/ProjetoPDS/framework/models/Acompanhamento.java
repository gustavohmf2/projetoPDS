package br.com.ProjetoPDS.framework.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author gustavo
 * A Serialização de Objetos produz um fluxo com informações sobre as classes Java TM para os objetos que estão sendo salvos. 
 * Para objetos serializáveis, informações suficientes são mantidas para restaurar esses objetos mesmo se uma versão diferente 
 * (mas compatível) da implementação da classe estiver presente. 
 * A Serializableinterface é definida para identificar classes que implementam o protocolo serializável:
 *
 */

@Entity
public class Acompanhamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5621070381036507640L;
	
	@Id 
	private Long id;

	
}
