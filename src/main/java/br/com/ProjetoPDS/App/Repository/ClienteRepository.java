package br.com.ProjetoPDS.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Cliente;

@Repository
//Spring Data JPA creates an implementation on the fly
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	

}

