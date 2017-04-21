package br.com.ProjetoPDS.App.Service;

import java.util.List;

import br.com.ProjetoPDS.App.Models.CheckIn;

public interface ICheckInService {

	public void inserir(CheckIn checkIn);

	List<CheckIn> buscarCheckInPorId(Integer idServico);

}
