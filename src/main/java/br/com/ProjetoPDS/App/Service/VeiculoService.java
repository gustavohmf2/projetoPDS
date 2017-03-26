package br.com.ProjetoPDS.App.Service;

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
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private MarcaModeloRepository marcaModeloRepository;
	
	@Override
	public void cadastrar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		veiculoRepository.save(veiculo);
		
	}

	@Override
	public void atualizar(Veiculo veiculo) {
		
		veiculoRepository.save(veiculo);
		
	}

	@Override
	public List<MarcaModelo> listarMarcaModelo() {
		
		return marcaModeloRepository.findAll();
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

}
