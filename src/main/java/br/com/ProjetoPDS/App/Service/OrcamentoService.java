package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Orcamento;

@Service
public class OrcamentoService implements IOrcamentoService{

	@Autowired
	private DataFacadeService dataFacade;
	
	
	
	// acesso banco de dados
	@Override
	public void inserir(Orcamento orcamento) {
		dataFacade.getOrcamentoRepository().save(orcamento);
	}

	@Override
	public void deletar(Orcamento orcamento) {
		dataFacade.getOrcamentoRepository().delete(orcamento);
	}

	@Override
	public Orcamento buscarPorId(Long id) {
		return dataFacade.getOrcamentoRepository().getOne(id);
	}

	@Override
	public List<Orcamento> buscarTodos() {
		return dataFacade.getOrcamentoRepository().findAll();
	}

}
