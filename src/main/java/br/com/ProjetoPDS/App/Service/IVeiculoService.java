package br.com.ProjetoPDS.App.Service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Veiculo;

public interface IVeiculoService {
	
	
	public void cadastrar(Veiculo veiculo);
	public void atualizar(Veiculo veiculo);
	public List<MarcaModelo> listarMarcaModelo();
	public void excluir();
	
}
