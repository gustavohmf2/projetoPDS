package br.com.ProjetoPDS.App.Service;

import java.util.List;

public interface IDataService {
	public void inserir(Object objeto);
	public void deletar(Object objeto);
	public List<Object> buscarTodos();
	public Object buscarPorId(Integer id);
	public void atualizarPorId(Integer id, Object objeto);
}
