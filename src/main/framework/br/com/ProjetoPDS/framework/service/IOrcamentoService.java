package br.com.ProjetoPDS.framework.service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Orcamento;

public interface IOrcamentoService {

	//acesso ao banco
	public void inserir(Orcamento orcamento);
	public void deletar(Orcamento orcamento);
	public List<Orcamento> buscarTodos();
	public Orcamento buscarPorId(Long id);
}
