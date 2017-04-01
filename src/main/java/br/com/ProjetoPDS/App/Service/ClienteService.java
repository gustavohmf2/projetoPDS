package br.com.ProjetoPDS.App.Service;


import java.util.ArrayList;
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
	public void verificaVeiculo(Cliente cliente){
	
		Veiculo veiculo = cliente.getVeiculo().get(0);
		List<Alerta> alertas = new ArrayList<Alerta>();
		
		alertas.add(logicaAcompanhamento.verificarRevisao(veiculo));
		alertas.add(logicaAcompanhamento.alinhamentoBalanceamento(veiculo));
		
		if(!alertas.isEmpty()){
			
			for(int i = 0; i < alertas.size(); i++){
				
				cliente.addAlertas(alertas.get(i));
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
<<<<<<< HEAD
	public void inserir(Object objeto) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente)objeto;
		//dataFacade.getEnderecoRepository().save(cliente.getEndereco());
=======
	public void inserir(Cliente cliente) {
>>>>>>> ac639ab8f1ffc140a4f3be31c30eb7eb97a88aee
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
