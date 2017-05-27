package br.com.ProjetoPDS.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Peca;

@Service
public class PecaService implements IPecaService{

	@Autowired
	private DataFacadeService datafacade;
	
	@Override
	public void inserir(Peca peca) {
		datafacade.getPecaRepository().save(peca);
	}

	@Override
	public void deletar(Peca peca) {
		datafacade.getPecaRepository().delete(peca);
	}

	@Override
	public List<Peca> buscarTodos() {
		return datafacade.getPecaRepository().findAll();
	}

	@Override
	public Peca buscarPorId(Long id) {
		return datafacade.getPecaRepository().getOne(id);
	}

	

}
