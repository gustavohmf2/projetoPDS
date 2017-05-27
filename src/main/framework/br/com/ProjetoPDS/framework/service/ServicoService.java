package br.com.ProjetoPDS.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Enumeracoes.EnumStatus;
import br.com.ProjetoPDS.framework.models.CheckIn;
import br.com.ProjetoPDS.framework.models.Contratante;
import br.com.ProjetoPDS.framework.models.Prestadora;
import br.com.ProjetoPDS.framework.models.Produto;
import br.com.ProjetoPDS.framework.models.Servico;
import br.com.ProjetoPDS.framework.repository.CheckInRepository;
import br.com.ProjetoPDS.framework.repository.ServicoRepository;

@Service
public class ServicoService implements IServicoService{

	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private CheckInRepository checkInRepository;

	
	/**
	 * Requisito gera uma atualização do status do serviço
	 * 
	 * 
	 * @param idServico
	 */
	
	@Override
	public List<Servico> buscarServicosPorContratante(Contratante contratante) {
		return servicoRepository.listarServicoPorContratante(contratante);
	}
	
	@Override
	public List<Servico> buscarServicosPorPrestadora(Prestadora prestadora) {
		return servicoRepository.listarServicoPorPrestadora(prestadora);
	}

	@Override
	public void inserir(Servico servico) {
		servicoRepository.save(servico);
	}

	@Override
	public void deletar(Servico servico) {
		servicoRepository.delete(servico);
	}
	
	@Override
	public void deletarTodos(Produto produto) {
		
		for(Servico serv: produto.getServicos()){
			servicoRepository.delete(serv);
		}
		
	}

	@Override
	public Servico buscarPorId(Integer id) {
		return servicoRepository.getOne(id);
	}

	@Override
	public List<Servico> buscarTodos() {
		return servicoRepository.findAll();
	}


	@Override
	public List<Servico> buscarServicosPorIdContratante(String idCliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void atualizarProduto(Produto produto) {
		servicoRepository.updateProduto(produto);
	}

	@Override
	public List<CheckIn> listarCheckIn(Integer id) {
		// TODO Auto-generated method stub
		return checkInRepository.listarCheckInPorServico(id);
	}
	
	@Override
	public void verificarServico(Integer id){
		
		Servico servi = servicoRepository.findOne(id);
		
		for (CheckIn checkin : servi.getCheckIns()) {
			
			if(checkin.getClassficacao() == 0){
				servicoRepository.delete(servi);
			}
			
		}
	}



}