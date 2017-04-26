package br.com.ProjetoPDS.App.Service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.CheckIn;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Models.Veiculo;

public interface IServicoService {

	public List<Servico> buscarServicosPorIdCliente(String idCliente);
	
	//acesso ao banco
	public void inserir(Servico servico);
	public void deletar(Servico servico);
	public Servico buscarPorId(Integer id);
	public List<Servico> buscarTodos();

	public void aprovarOrcamentoServico(Integer idServico);

	public List<Servico> buscarServicosPorIdCliente(Cliente idCliente);

	public void atualizarVeiculo(Veiculo veiculo);

	public void deletarTodos(Veiculo veiculo);

	public List<CheckIn> listarChekin(Integer id);

	public void verificarServico(Integer id);
	
	
}
