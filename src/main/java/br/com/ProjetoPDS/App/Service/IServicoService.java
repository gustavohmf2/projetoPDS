package br.com.ProjetoPDS.App.Service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Servico;

public interface IServicoService {

	public List<Servico> buscarServicosPorIdCliente(String idCliente);
}
