package br.com.ProjetoPDS.App.Repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoPDS.App.Models.InfoExtraVeiculo;

@Transactional
@Repository
public interface InfoExtraVeiculoRepository extends JpaRepository<InfoExtraVeiculo, String>{

}
