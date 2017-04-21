package br.com.ProjetoPDS.App.Repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Cliente;

@Transactional
@Repository
//Spring Data JPA creates an implementation on the fly
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	

	
	
}

