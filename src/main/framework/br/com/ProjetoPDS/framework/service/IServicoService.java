package br.com.ProjetoPDS.framework.service;

import java.util.List;

import br.com.ProjetoPDS.framework.models.CheckIn;
import br.com.ProjetoPDS.framework.models.Contratante;
import br.com.ProjetoPDS.framework.models.Prestadora;
import br.com.ProjetoPDS.framework.models.Produto;
import br.com.ProjetoPDS.framework.models.Servico;

public interface IServicoService {

	public List<Servico> buscarServicosPorIdContratante(String contratante);
	
	//acesso ao banco
	public void inserir(Servico servico);
	public void deletar(Servico servico);
	public Servico buscarPorId(Integer id);
	public List<Servico> buscarTodos();

	public List<Servico> buscarServicosPorContratante(Contratante contratante);
	
	public List<Servico> buscarServicosPorPrestadora(Prestadora prestadora);

	public void atualizarProduto(Produto produto);

	public void deletarTodos(Produto produto);

	public List<CheckIn> listarCheckIn(Integer id);

	public void verificarServico(Integer id);
	
	
}