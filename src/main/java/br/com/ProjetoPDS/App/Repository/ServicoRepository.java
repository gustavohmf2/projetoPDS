package br.com.ProjetoPDS.App.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.Servico;
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
