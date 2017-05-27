package br.com.ProjetoPDS.framework.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.framework.models.Contratante;

@Transactional
@Repository
//Spring Data JPA creates an implementation on the fly
public interface ContratanteRepository extends JpaRepository<Contratante, String>{
	
	
}

