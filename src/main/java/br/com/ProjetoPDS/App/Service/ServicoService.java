package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Models.Servico;

public class ServicoService implements IServicoService{

	@Autowired
	private DataFacadeService dataFacade;

	
	/**
	 * Requisito gera uma atualização do status do serviço
	 * 
	 * 
	 * @param idServico
	 */
	@Override
	public void aprovarOrcamentoServico(Integer idServico){
		Servico ServicoAtualizado = buscarPorId(idServico);
		ServicoAtualizado.setStatus(EnumStatus.SERVICO_AUTORIZADO.getId());
		inserir(ServicoAtualizado);
	}
	
	
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
