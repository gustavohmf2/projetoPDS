package br.com.ProjetoPDS.framework.models.status;

public class StatusIniciado extends Status{

	public StatusIniciado() {
		super("Em andamento");
	}
	
	@Override
	public Status iniciar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status parar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status reiniciar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status finalizar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status proximo() {
		// TODO Auto-generated method stub
		return new StatusFinalizado();
	}

}
