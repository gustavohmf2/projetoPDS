package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.App.Models.CheckIn;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Oficina;
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
	public void proximoStatus(Integer idServico) {
		Servico ServicoAtualizado = buscarPorId(idServico);
		int status = ServicoAtualizado.getStatus().ordinal() + 1;
		ServicoAtualizado.setStatus(EnumStatus.fromInteger(status));
		inserir(ServicoAtualizado);
	}
	
	@Override
	public void aprovarOrcamentoServico(Integer idServico){
		Servico ServicoAtualizado = buscarPorId(idServico);
		ServicoAtualizado.setStatus(EnumStatus.SERVICO_AUTORIZADO);
		inserir(ServicoAtualizado);
	}
	
	@Override
	public void vistoriaPendente(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.VISTORIA_PENDENTE);
		inserir(servicoAtualizado);
	}
	
	@Override
	public void naoAutorizado(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.SERVICO_NAO_AUTORIZADO);
		inserir(servicoAtualizado);
	}
	
	@Override
	public void aguardandoPecas(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_PECAS);
		inserir(servicoAtualizado);
	}

	@Override
	public void aguardandoCliente(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.AGUARDANDO_CLIENTE);
		inserir(servicoAtualizado);
	}

	@Override
	public void emAndamento(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.EM_ANDAMENTO);
		inserir(servicoAtualizado);
	}

	@Override
	public void finalizado(Integer idServico) {
		Servico servicoAtualizado = buscarPorId(idServico);
		servicoAtualizado.setStatus(EnumStatus.FINALIZADO);
		inserir(servicoAtualizado);
	}
	
	@Override
	public List<Servico> buscarServicosPorIdCliente(Cliente idCliente) {
		return dataFacade.getServicoRepository().listarServicoPorId(idCliente);
	}
	
	@Override
	public List<Servico> buscarServicosPorIdOficina(Oficina idOficina) {
		return dataFacade.getServicoRepository().listarServicoPorIdOficina(idOficina);
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

	@Override
	public List<CheckIn> listarChekin(Integer id) {
		// TODO Auto-generated method stub
		return dataFacade.getCheckInRepository().listarCheckInPorServico(id);
	}
	
	@Override
	public void verificarServico(Integer id){
		
		Servico servi = dataFacade.getServicoRepository().findOne(id);
		
		for (CheckIn checkin : servi.getCheckin()) {
			
			if(checkin.getClassficacao() == 0){
				
				//dataFacade.getCheckInRepository().delete(checkin);
				dataFacade.getServicoRepository().delete(servi);
			}
			
		}
	}



}