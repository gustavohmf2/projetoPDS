package br.com.ProjetoPDS.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Oficina;;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, String>{

}
