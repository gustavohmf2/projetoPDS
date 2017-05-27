package br.com.ProjetoPDS.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Oficina;
import br.com.ProjetoPDS.framework.models.Prestadora;;

@Repository
public interface PrestadoraRepository extends JpaRepository<Prestadora, String>{

}
