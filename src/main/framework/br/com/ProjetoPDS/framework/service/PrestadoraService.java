package br.com.ProjetoPDS.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.framework.models.Prestadora;
import br.com.ProjetoPDS.framework.repository.PrestadoraRepository;

@Service
public class PrestadoraService implements IPrestadoraService{
	
	@Autowired
	private PrestadoraRepository prestadoraRepository;
	@Autowired
	private LogicaAcompanhamento logicaAcompanhamento;
	
	@Override
	public void inserir(Prestadora prestadora) {
		prestadoraRepository.save(prestadora);
	}

	@Override
	public void deletar(Prestadora prestadora) {
		prestadoraRepository.delete(prestadora);
	}

	@Override
	public Prestadora buscarPorId(String id) {
		return prestadoraRepository.findOne(id);
	}

	@Override
	public List<Prestadora> buscarTodos() {
		return prestadoraRepository.findAll();
	}

}
