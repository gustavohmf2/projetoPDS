package br.com.ProjetoPDS.framework.service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.framework.models.Produto;

public interface IProdutoService {
	
	//acesso ao banco
	public void inserir(Produto produto);
	
	public void deletar(Produto produto);
	public void deletePorId(String idProduto);
	
	public Produto buscarPorId(String id);
	public List<Produto> buscarTodos();

	public void deleteAlertasProduto(Produto produto);
	
	

	
	
	
}
