package br.com.ProjetoPDS.App.Service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Veiculo;

public interface IVeiculoService {

	public List<String> listarMarcaModelo(String marca);
	
	//acesso ao banco
	public void inserir(Veiculo veiculo);
	public void adicionarInfoExtra(InfoExtraVeiculo infoExtra);
	
	public void deletar(Veiculo veiculo);
	public void deletar(String chassi);
	public void deletePorId(String chassi);
	
	public Veiculo buscarPorId(String id);
	public List<Veiculo> buscarTodos();
	
	public List<String> listarMarcas();
	public MarcaModelo listarMarcaModelo(String marca, String modelo);

	public void deleteAlertasVeiculo(Veiculo veiculo);
	
	

	
	
	
}
