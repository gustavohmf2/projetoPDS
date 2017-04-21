package br.com.ProjetoPDS.App.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Veiculo;

@Transactional
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String>{
	
	
	@Query("SELECT v FROM  Veiculo v WHERE v.id = :id")
	ArrayList<Veiculo> listarPorId(@Param("id") String id);

}
