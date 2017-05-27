package br.com.ProjetoPDS.framework.service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Peca;

public interface IPecaService {

	//acesso ao banco
	public void inserir(Peca peca);
	public void deletar(Peca peca);
	public List<Peca> buscarTodos();
	public Peca buscarPorId(Long id);
}
