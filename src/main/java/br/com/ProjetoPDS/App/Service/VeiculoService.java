package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Veiculo;

@Service
public class VeiculoService implements IVeiculoService{

	@Autowired
	private DataFacadeService dataFacade;

	
	@Override
	public List<String> listarMarcaModelo(String marca) {
		return dataFacade.getMarcaModeloRepository().buscarModelosPorMarca(marca);
		
	}
	
	@Override
	public MarcaModelo listarMarcaModelo(String marca, String modelo) {
		return dataFacade.getMarcaModeloRepository().buscarModelosPorMarca(marca, modelo);
		
	}
	
	@Override
	public List<String> listarMarcas() {
		return dataFacade.getMarcaModeloRepository().buscarModelos();
		
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
	
	@Override
	public void deletar(String chassi) {
		dataFacade.getVeiculoRepository().delete(chassi);
	}

	@Override
	public void adicionarInfoExtra(InfoExtraVeiculo infoExtra) {
		
		
		boolean exist = dataFacade.getInfoExtraVeiculoRepository().exists(infoExtra.getId());
		
		if(exist){
			
			infoExtra.setKmAnterior(infoExtra.getKmTotal());
			
		}
		
		Veiculo veiculo = dataFacade.getVeiculoRepository().findOne(infoExtra.getId());

		veiculo.setInfoExtraVeiculo(infoExtra);
		
		dataFacade.getVeiculoRepository().save(veiculo);
		
		
		
	}

	

}
