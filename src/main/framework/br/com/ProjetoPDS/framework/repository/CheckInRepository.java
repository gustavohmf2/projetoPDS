package br.com.ProjetoPDS.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.framework.models.CheckIn;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer>{

	
	@Query("SELECT c FROM CheckIn c WHERE c.id =:id ")
	public List<CheckIn> listarCheckInPorServico(@Param("id")Integer id);

}
