package br.com.ProjetoPDS.App.Exceptions;

public class RepositoryException extends Exception{


	@Override
	public String toString(){
		
		return "Erro na camada de Dados!";
	}
}
