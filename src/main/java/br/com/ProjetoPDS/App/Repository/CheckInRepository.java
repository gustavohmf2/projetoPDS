package br.com.ProjetoPDS.App.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.CheckIn;
@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer>{

	
	@Query("SELECT c FROM CheckIn c WHERE c.id =:id ")
	public List<CheckIn> listarCheckInPorServico(@Param("id")Integer id);

}
