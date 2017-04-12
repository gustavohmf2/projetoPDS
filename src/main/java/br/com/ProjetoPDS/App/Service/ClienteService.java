package br.com.ProjetoPDS.App.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Veiculo;

@Service
public class ClienteService implements IClienteService{


	
	@Autowired
	private DataFacadeService dataFacade;
	
	@Autowired
	private LogicaAcompanhamento logicaAcompanhamento;
	
	@Override
	public void verificaVeiculo(String cpf){
		
		Cliente cliente = dataFacade.getClienteRepository().findOne(cpf);

		List<Veiculo> veiculos = cliente.getVeiculo();
		
		for(int i = 0;  i < veiculos.size(); i++){
			
			if(veiculos.get(i).getInfoExtraVeiculo() != null){
				
				Alerta alerta1 = logicaAcompanhamento.verificarRevisao(veiculos.get(i));
				Alerta alerta2 = logicaAcompanhamento.alinhamentoBalanceamento(veiculos.get(i));
				
				alerta1.setVeiculo(veiculos.get(i));
				if((dataFacade.getAlertaRepository().findByDescricaoVeiculo(alerta1.getDescricao(), alerta1.getVeiculo()).isEmpty())
						&& (!alerta1.getDescricao().isEmpty())){
					
					
					cliente.getVeiculo().get(i).addAlertas(alerta1);
					dataFacade.getClienteRepository().save(cliente);	
				}
				
				alerta2.setVeiculo(veiculos.get(i));
				if((dataFacade.getAlertaRepository().findByDescricaoVeiculo(alerta2.getDescricao(), alerta2.getVeiculo()).isEmpty()) && (alerta2.getDescricao() != null)){
						
					cliente.getVeiculo().get(i).addAlertas(alerta2);
					dataFacade.getClienteRepository().save(cliente);
				}
					
			}
	
		}

	}
	
	@Override
	public Cliente buscarPF(String cpf){
		return dataFacade.getClienteRepository().findOne(cpf);
	}
	@Override
	public Cliente buscarPJ(String cnpj){
		return dataFacade.getClienteRepository().findOne(cnpj);
	}
	
	@Override
	public void inserir(Cliente cliente) {
		dataFacade.getClienteRepository().save(cliente);
	}
	@Override
	public void deletar(Cliente cliente) {
		dataFacade.getClienteRepository().delete(cliente);
	}

	@Override
	public Cliente buscarPorId(String id) {
		return dataFacade.getClienteRepository().findOne(id);	
	}

	@Override
	public List<Cliente> buscarTodos() {
		return dataFacade.getClienteRepository().findAll();
	}

}
