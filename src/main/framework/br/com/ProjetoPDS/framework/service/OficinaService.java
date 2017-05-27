package br.com.ProjetoPDS.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Oficina;

@Service
public class OficinaService implements IOficinaService{
	
	@Autowired
	private DataFacadeService dataFacade;
	@Autowired
	private LogicaAcompanhamento logicaAcompanhamento;

	@Override
	public Oficina buscarPJ(String cnpj) {
		return dataFacade.getOficinaRepository().getOne(cnpj);
	}
	
	@Override
	public void inserir(Oficina oficina) {
		dataFacade.getOficinaRepository().save(oficina);
	}

	@Override
	public void deletar(Oficina oficina) {
		dataFacade.getOficinaRepository().delete(oficina);
	}

	@Override
	public Oficina buscarPorId(String id) {
		return dataFacade.getOficinaRepository().findOne(id);
	}

	@Override
	public List<Oficina> buscarTodos() {
		return dataFacade.getOficinaRepository().findAll();
	}

	@Override
	public void verificaCliente(String cpf) {
		// TODO Auto-generated method stub
		
	}

}
