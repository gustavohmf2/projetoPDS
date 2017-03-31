package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ProjetoPDS.App.Models.Servico;

public class ServicoService implements IServicoService{

	@Autowired
	private DataFacadeService dataFacade;

	@Override
	public List<Servico> buscarServicosPorIdCliente(String idCliente) {
		return dataFacade.getClienteRepository().findOne(idCliente).getServico();
	}

	@Override
	public void inserir(Servico servico) {
		dataFacade.getServicoRepository().save(servico);
	}

	@Override
	public void deletar(Servico servico) {
		dataFacade.getServicoRepository().delete(servico);
	}

	@Override
	public Servico buscarPorId(Integer id) {
		return dataFacade.getServicoRepository().getOne(id);
	}

	@Override
	public List<Servico> buscarTodos() {
		return dataFacade.getServicoRepository().findAll();
	}


	

}
