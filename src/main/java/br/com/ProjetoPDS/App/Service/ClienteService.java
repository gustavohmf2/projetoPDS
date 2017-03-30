package br.com.ProjetoPDS.App.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Cliente;

@Service
public class ClienteService implements IClienteService, IDataService{


	
	@Autowired
	private DataFacadeService dataFacade;
	
	public void inserirCliente(Cliente cliente){
		
		//enderecoRepository.save(cliente.getEndereco());
		//clienteRepository.save(cliente);
		dataFacade.getEnderecoRepository().save(cliente.getEndereco());
		dataFacade.getClienteRepository().save(cliente);
	}
	
	

	public Cliente buscarPF(String cpf){
		
		return dataFacade.getClienteRepository().findOne(cpf);
	}
	
	public Cliente buscarPJ(String cnpj){
		
		return dataFacade.getClienteRepository().findOne(cnpj);
	}
	
	

	@Override
	public void inserir(Object objeto) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente)objeto;
		dataFacade.getEnderecoRepository().save(cliente.getEndereco());
		dataFacade.getClienteRepository().save(cliente);
		
	}

	@Override
	public void deletar(Object objeto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarPorId(Integer id, Object objeto) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Object> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void atualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}



}
