package br.com.ProjetoPDS.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.CheckIn;
import br.com.ProjetoPDS.App.Models.Servico;
@Service
public class CheckInService implements ICheckInService{
	
	@Autowired
	private DataFacadeService dataFacade;

	@Override
	public void inserir(CheckIn checkIn) {
		try {
			dataFacade.getCheckInRepository().save(checkIn);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados. [checkIn]");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CheckIn> buscarCheckInPorId(Integer idServico) {
		
		return dataFacade.getCheckInRepository().listarCheckInPorServico(idServico);
	}

	

	


	
	
}
