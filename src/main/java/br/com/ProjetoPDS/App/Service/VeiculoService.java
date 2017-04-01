package br.com.ProjetoPDS.App.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.App.Repository.MarcaModeloRepository;
import br.com.ProjetoPDS.App.Repository.VeiculoRepository;

@Service
public class VeiculoService implements IVeiculoService{

	@Autowired
	private DataFacadeService dataFacade;

	@Override
	public List<MarcaModelo> listarMarcaModelo() {
		return null;
		
	}

	@Override
	public void inserir(Veiculo veiculo) {
		dataFacade.getVeiculoRepository().save(veiculo);
	}

	@Override
	public Veiculo buscarPorId(String id) {
		return dataFacade.getVeiculoRepository().getOne(id);
	}

	@Override
	public List<Veiculo> buscarTodos() {
		return dataFacade.getVeiculoRepository().findAll();
	}

	@Override
	public void deletar(Veiculo veiculo) {
		dataFacade.getVeiculoRepository().delete(veiculo);
	}
	

}
