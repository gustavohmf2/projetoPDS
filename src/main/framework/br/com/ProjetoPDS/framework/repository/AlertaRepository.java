package br.com.ProjetoPDS.framework.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Enumeracoes.TipoAlerta;
import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Veiculo;

@Repository
@Transactional
public interface AlertaRepository extends JpaRepository<Alerta, Integer>{

	@Query("SELECT a FROM Alerta a WHERE a.descricao = :descricao AND a.veiculo = :veiculo")
	public Alerta findByDescricaoVeiculo(@Param("descricao") String descricao,@Param("veiculo") Veiculo veiculo);
	
	@Modifying
	@Query("DELETE Alerta a WHERE a.tipo = 'REVISAO' AND a.veiculo = :veiculo")
	public int deleteByTipoAlerta( @Param("veiculo") Veiculo veiculo);
}
