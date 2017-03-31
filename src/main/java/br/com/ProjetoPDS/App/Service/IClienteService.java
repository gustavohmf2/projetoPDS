package br.com.ProjetoPDS.App.Service;

import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoPDS.App.Models.Alerta;
import br.com.ProjetoPDS.App.Models.Cliente;
import br.com.ProjetoPDS.App.Models.Veiculo;

public interface IClienteService {
	
	public void verificaVeiculo(Cliente cliente);
	public Cliente buscarPF(String cpf);
	public Cliente buscarPJ(String cnpj);
	public void inserir(Cliente cliente);
	public void deletar(Cliente cliente);
	public Cliente buscarPorId(String id);
	public List<Cliente> buscarTodos();
}
