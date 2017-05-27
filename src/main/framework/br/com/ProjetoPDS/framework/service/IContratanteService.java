package br.com.ProjetoPDS.framework.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.framework.models.Contratante;

public interface IContratanteService {
	
	public Contratante buscarID(String id);
	public Contratante buscarPorId(String id);
	public void inserir(Contratante contratante);
	public void deletar(Contratante contratante);
	public List<Contratante> buscarTodos();
	void verificaProduto(String cpf);
}
