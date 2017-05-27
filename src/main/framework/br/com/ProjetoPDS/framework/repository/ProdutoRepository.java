package br.com.ProjetoPDS.framework.repository;

import java.util.ArrayList;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Veiculo;
import br.com.ProjetoPDS.framework.models.Produto;

@Transactional
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	
	@Query("SELECT p FROM  Produto p WHERE p.id = :id")
	ArrayList<Produto> listarPorId(@Param("id") String id);
	
	@Modifying
	@Query("DELETE FROM Produto p WHERE p.id = :id")
	void deletePorId(@Param("id") String id);

}
