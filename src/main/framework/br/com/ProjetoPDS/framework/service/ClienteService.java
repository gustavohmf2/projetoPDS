package br.com.ProjetoPDS.framework.service;


import java.util.List;

import javax.persistence.EnumType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Enumeracoes.TipoAlerta;
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
		
		Alerta alerta1;
		Alerta alerta2;
		
		for(int i = 0;  i < veiculos.size(); i++){
			
			System.out.println("For veiculo");
			
			if(veiculos.get(i).getInfoExtraVeiculo() != null){
				
				System.out.println("Info Extra");
				
				if(!(veiculos.get(i).getAlertas().isEmpty())){
					
					System.out.println("Tem alertas");
					
					for(int j = 0; j < veiculos.get(i).getAlertas().size();j++){
						System.out.println("For alertas");
						
						alerta1 = logicaAcompanhamento.verificarRevisao(veiculos.get(i));
						alerta2 = logicaAcompanhamento.alinhamentoBalanceamento(veiculos.get(i));
						
						alerta1.setVeiculo(veiculos.get(i));
						
						if((dataFacade.getAlertaRepository().findByDescricaoVeiculo(alerta1.getDescricao(), alerta1.getVeiculo()) == null)
							&& (!alerta1.getDescricao().isEmpty())){
							
							System.out.println("Alerta 1");
							
							alerta1.setVeiculo(cliente.getVeiculo().get(i));
							cliente.getVeiculo().get(i).addAlertas(alerta1);
							dataFacade.getClienteRepository().save(cliente);	
							
						}else{
							
							if((cliente.getVeiculo().get(i).getAlertas().get(j).getTipo().equals(alerta1.getTipo()))
								&& ((cliente.getVeiculo().get(i).getAlertas().get(j).getData().getTimeInMillis() - alerta1.getData().getTimeInMillis() < 0))
							){ 
								
								System.out.println("Alerta 2");
								int result = dataFacade.getAlertaRepository().deleteByTipoAlerta(cliente.getVeiculo().get(i));
								
								alerta1.setVeiculo(cliente.getVeiculo().get(i));
								cliente.getVeiculo().get(i).addAlertas(alerta1);
								dataFacade.getClienteRepository().save(cliente);
								
							}
						
						}
							
				
						System.out.println("Alerta 3");
						alerta2.setVeiculo(veiculos.get(i));
						//se não existir um alerta para um veiculo com a mesma descrição e a descrição estiver preenchida adicionar um novo alerta
						if((dataFacade.getAlertaRepository().findByDescricaoVeiculo(alerta2.getDescricao(), alerta2.getVeiculo()) == null) 
								&& (alerta2.getDescricao() != null)){
							alerta2.setVeiculo(cliente.getVeiculo().get(i));
							cliente.getVeiculo().get(i).addAlertas(alerta2);
							dataFacade.getClienteRepository().save(cliente);
						}
					}
				}else{
					
					System.out.println("Alerta 4");
					alerta1 = logicaAcompanhamento.verificarRevisao(veiculos.get(i));
					alerta2 = logicaAcompanhamento.alinhamentoBalanceamento(veiculos.get(i));
					
					
					if(alerta1.getDescricao() != null ){
						
						alerta1.setVeiculo(veiculos.get(i));
						cliente.getVeiculo().get(i).addAlertas(alerta1);
						dataFacade.getClienteRepository().save(cliente);	
						System.out.println(alerta1.getDescricao());
					}
					
					if(alerta2.getDescricao() != null ){
						
						alerta2.setVeiculo(veiculos.get(i));
						cliente.getVeiculo().get(i).addAlertas(alerta2);
						dataFacade.getClienteRepository().save(cliente);
						System.out.println(alerta2.getDescricao());
					}
					

				}
				
			}
	
		}

	}
	
	@Override
	public Cliente buscarPF(String cpf){
		Cliente cliente = null;
		try {
			cliente = dataFacade.getClienteRepository().findOne(cpf);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");
			e.printStackTrace();
		}
		return cliente;
	}
	@Override
	public Cliente buscarPJ(String cnpj){
		Cliente cliente = null;
		try {
			cliente = dataFacade.getClienteRepository().findOne(cnpj);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
		return cliente ;
	}
	
	@Override
	public void inserir(Cliente cliente) {
		try {
			dataFacade.getClienteRepository().save(cliente);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
	}
	@Override
	public void deletar(Cliente cliente) {
		try {
			dataFacade.getClienteRepository().delete(cliente);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
	}

	@Override
	public Cliente buscarPorId(String id) {
		Cliente cliente = null;
		try {
			cliente = dataFacade.getClienteRepository().findOne(id);
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
		return cliente;	
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = null;
		try {
			clientes = dataFacade.getClienteRepository().findAll();
		} catch (DataAccessException e) {
			System.err.println("Erro na camada de dados!");	
			e.printStackTrace();
		}
		return clientes;
	}

}
