package br.com.ProjetoPDS.App.Service;

import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Enumeracoes.EnumMarcasModelos;
import br.com.ProjetoPDS.App.Exceptions.CamadaServicoException;
import br.com.ProjetoPDS.App.Models.Cliente;

@Service
public class ValidacoesService implements IValidacoesService{

	private static ValidacoesService instance = null;
	
	private ValidacoesService() {
		// TODO Auto-generated constructor stub
	}
	public static ValidacoesService getInstance(){
			if(instance == null)
				return new ValidacoesService();		 
			
		return instance;
	}
	
	public void validarCpf(String cpf) throws CamadaServicoException {
		if(cpf.length() != 11){
			throw new CamadaServicoException();
		}
	
	}

	@Override
	public void validarTelefone(String telefone) throws CamadaServicoException {
		if((telefone.length() != 9)||(telefone.length() != 11)
				||(telefone.length() != 12)){
			throw new CamadaServicoException();
		}
	}
	
	@Override
	public void validarCepEndereco(String cep) throws CamadaServicoException {
		if(cep.length() != 8){
			throw new CamadaServicoException();
		}
	}


	
	@Override
	public String validarNumeroChassi(String numeroChassi) throws CamadaServicoException {
		if(numeroChassi.length() != 17){
			throw new CamadaServicoException();
		}
		return numeroChassi;
	}

	@Override
	public Integer validarAno(Integer ano) throws CamadaServicoException {
		if((Integer.toString(ano).length() != 2)
				||(Integer.toString(ano).length() != 4)){
			
			throw new CamadaServicoException();
		}

		return ano;
	}

	@Override
	public String validarPlaca(String placa) throws CamadaServicoException{
		if(placa.length() != 7){
			throw new CamadaServicoException();
		}
		return placa;
	}
	@Override
	public void validarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
	
}
