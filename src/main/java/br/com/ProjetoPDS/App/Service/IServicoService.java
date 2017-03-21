package br.com.ProjetoPDS.App.Service;

import br.com.ProjetoPDS.App.Models.Servico;

public interface IServicoService {

	public void cadastrarServico(Servico servico);
	public void atualizarServico(Servico servico);
	public void excluirServico();
}
