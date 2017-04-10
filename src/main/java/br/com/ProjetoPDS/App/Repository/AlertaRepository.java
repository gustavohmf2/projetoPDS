package br.com.ProjetoPDS.App.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Veiculo;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Integer>{

	@Query("SELECT a FROM Alerta a WHERE a.descricao = :descricao AND a.veiculo = :veiculo")
	public List<Alerta> findByDescricaoVeiculo(@Param("descricao") String descricao,@Param("veiculo") Veiculo veiculo);
	
}
