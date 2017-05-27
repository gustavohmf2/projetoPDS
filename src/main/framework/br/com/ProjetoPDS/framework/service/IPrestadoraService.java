package br.com.ProjetoPDS.framework.service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.framework.models.Prestadora;

public interface IPrestadoraService {
	public Prestadora buscarPorId(String id);
	public void inserir(Prestadora prestadora);
	public void deletar(Prestadora prestadora);
	public List<Prestadora> buscarTodos();
}
