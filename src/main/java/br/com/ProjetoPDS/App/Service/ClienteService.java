package br.com.ProjetoPDS.App.Service;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Repository.ClienteRepository;
import br.com.ProjetoPDS.App.Repository.EnderecoRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void inserirCliente(Cliente cliente){
		
		enderecoRepository.save(cliente.getEndereco());
		clienteRepository.save(cliente);
	}
	
	public Cliente buscarPF(String cpf){
		
		return clienteRepository.findOne(cpf);
	}
	
	public Cliente buscarPJ(String cnpj){
		
		return clienteRepository.findOne(cnpj);
	}
	
	public void inserir(Cliente cliente){
		
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		
		try{
			
			clienteRepository.save(cliente);
		}catch(PersistentObjectException e){
			
			e.printStackTrace();
		}
		}
}
