package br.com.ProjetoPDS.framework.service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Oficina;

public interface IOficinaService {
	public Oficina buscarPJ(String cnpj);
	public void inserir(Oficina oficina);
	public void deletar(Oficina oficina);
	public Oficina buscarPorId(String id);
	public List<Oficina> buscarTodos();
	void verificaCliente(String cpf);
}
