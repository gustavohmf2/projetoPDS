package br.com.ProjetoPDS.App.Repository;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.App.Models.Servico;
import br.com.ProjetoPDS.App.Models.Veiculo;


@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

	@Query("SELECT s FROM  Servico s WHERE s.cliente = :cliente")
	ArrayList<Servico> listarServicoPorId(@Param("cliente") Cliente cliente);
	
	@Query("SELECT s FROM  Servico s WHERE s.oficina = :oficina")
	ArrayList<Servico> listarServicoPorIdOficina(@Param("oficina") Oficina oficina);
	
	@Modifying
	@Query("UPDATE Servico s SET s.veiculo = '' WHERE s.veiculo =:veiculo")
	ArrayList<Servico> updateVeiculo(@Param("veiculo") Veiculo veiculo);
}