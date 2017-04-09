package br.com.ProjetoPDS.App.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.MarcaModelo;
@Repository
public interface MarcaModeloRepository extends JpaRepository<MarcaModelo, Long>{


	public List<MarcaModelo> findByMarca(String marca);
	
	@Query("select m.modelo from MarcaModelo m where m.marca =:marca ")
	List<String> buscarListaModelosPorMarca(@Param("marca")String marca);
}
