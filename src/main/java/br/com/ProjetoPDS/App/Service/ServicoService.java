package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Models.Veiculo;

@Service
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
		ServicoAtualizado.setStatus(EnumStatus.SERVICO_AUTORIZADO);
		inserir(ServicoAtualizado);
	}
	
	
	@Override
	public List<Servico> buscarServicosPorIdCliente(Cliente idCliente) {
		return dataFacade.getServicoRepository().listarServicoPorId(idCliente);
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
	public void deletarTodos(Veiculo veiculo) {
		
		for(Servico serv: veiculo.getServico()){
			
					dataFacade.getServicoRepository().delete(serv);
		}
		
	}

	@Override
	public Servico buscarPorId(Integer id) {
		return dataFacade.getServicoRepository().getOne(id);
	}

	@Override
	public List<Servico> buscarTodos() {
		return dataFacade.getServicoRepository().findAll();
	}


	@Override
	public List<Servico> buscarServicosPorIdCliente(String idCliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void atualizarVeiculo(Veiculo veiculo ) {
		// TODO Auto-generated method stub
		dataFacade.getServicoRepository().updateVeiculo(veiculo);
	}


	

}
