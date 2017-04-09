package br.com.ProjetoPDS.App.Service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Servico;

public interface IServicoService {

	public List<Servico> buscarServicosPorIdCliente(String idCliente);
	
	//acesso ao banco
	public void inserir(Servico servico);
	public void deletar(Servico servico);
	public Servico buscarPorId(Integer id);
	public List<Servico> buscarTodos();

	void aprovarOrcamentoServico(Integer idServico);
}
