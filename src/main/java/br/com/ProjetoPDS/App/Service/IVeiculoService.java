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
	public void deletar(Veiculo veiculo);
	public Veiculo buscarPorId(String id);
	public List<Veiculo> buscarTodos();
	public void adicionarInfoExtra(InfoExtraVeiculo infoExtra);

	List<String> listarMarcas();

	MarcaModelo listarMarcaModelo(String marca, String modelo);
	
}
