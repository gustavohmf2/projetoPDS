package br.com.ProjetoPDS.App.Service;

import br.com.ProjetoPDS.App.Exceptions.CamadaServicoException;
import br.com.ProjetoPDS.App.Models.Cliente;

public interface IValidacoesService {

	public void validarCliente(Cliente cliente);
	public void validarCpf(String cpf) throws CamadaServicoException;
	public void validarTelefone(String telefone) throws CamadaServicoException;
	public void validarCepEndereco(String cep) throws CamadaServicoException;
	public String validarNumeroChassi(String numeroChassi) throws CamadaServicoException;
	public Integer validarAno(Integer ano) throws CamadaServicoException;
	public String validarPlaca(String placa) throws CamadaServicoException;
}
