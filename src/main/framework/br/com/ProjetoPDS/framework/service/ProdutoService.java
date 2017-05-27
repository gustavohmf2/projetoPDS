package br.com.ProjetoPDS.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;
import br.com.ProjetoPDS.App.Models.MarcaModelo;
import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.App.Repository.VeiculoRepository;
import br.com.ProjetoPDS.framework.models.Produto;
import br.com.ProjetoPDS.framework.repository.ProdutoRepository;

@Service
public class ProdutoService implements IProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	

	@Override
	public void inserir(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public Produto buscarPorId(String id) {
		return produtoRepository.getOne(id);
	}

	@Override
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
	
	@Override
	public void deletar(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@Override
	public void deletePorId(String idProduto) {
		
		produtoRepository.deletePorId(idProduto);
	}
	
	@Override
	public void deleteAlertasProduto(Produto produto) {
		//TODO criar esse método
		
		//dataFacade.getAlertaRepository().deleteByTipoAlerta(veiculo);
	}

	
	

}
