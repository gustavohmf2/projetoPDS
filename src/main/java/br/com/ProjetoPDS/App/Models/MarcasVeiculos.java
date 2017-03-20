package br.com.ProjetoPDS.App.Models;

import java.util.ArrayList;

public enum MarcasVeiculos {

	
	FIAT(modelosFiat()), VOLKSWAGEN(modelosVW())
	, FORD(modelosFord()), RENAULT(modelosRenault());
	
	
	public ArrayList<String> modelos;
	MarcasVeiculos(ArrayList<String> modelos){
		this.modelos = modelos;
	}
	
	//Listagem de modelos
	
	
	public static ArrayList<String> modelosFiat(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Uno");
		modelos.add("Palio");
		modelos.add("Siena");
		modelos.add("Toro");
		modelos.add("500");
		modelos.add("Mobi");
		modelos.add("Idea");
		modelos.add("Punto");
		modelos.add("Stilo");
		modelos.add("Strada");
		return modelos;
	}
	public static ArrayList<String> modelosVW(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Fox");
		modelos.add("Gol");
		modelos.add("Golf");
		modelos.add("Amarok");
		modelos.add("Crossfox");
		modelos.add("Parati");
		modelos.add("Up");
		modelos.add("Saveiro");
		modelos.add("Polo");
		modelos.add("Jetta");
		return modelos;
	}
	
	public static ArrayList<String> modelosFord(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Edge");
		modelos.add("Escort");
		modelos.add("Ecosport");
		modelos.add("Focus");
		modelos.add("Courier");
		modelos.add("Fiesta");
		modelos.add("F-1000");
		modelos.add("Fusion");
		modelos.add("Ka");
		modelos.add("Ranger");
		return modelos;
	}
	
	public static ArrayList<String> modelosRenault(){
		ArrayList<String> modelos = new ArrayList<String>();
		modelos.add("Clio");
		modelos.add("Duster");
		modelos.add("Logan");
		modelos.add("Fluence");
		modelos.add("Sandero");
		modelos.add("Megane");
		modelos.add("Symbol");
		modelos.add("Trafic");
		modelos.add("Laguna");
		modelos.add("Twingo");
		return modelos;
	}
	
	//gets
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static MarcasVeiculos getMarcaById(int id){
		
		for (MarcasVeiculos marca : MarcasVeiculos.values()) {
			if(MarcasVeiculos.valueOf(marca.toString()).ordinal() == id){
				return MarcasVeiculos.valueOf(marca.toString());
			}
		}

		return null;
	}
	
	public static ArrayList<String> listaMarcas(){
		ArrayList<String> lista = new ArrayList<String>();
		for (MarcasVeiculos marca : MarcasVeiculos.values()) {
			lista.add(marca.toString());
		}
		return lista;
	}
	
	public String getModeloById(int id){
		return this.modelos.get(id);
	}
	
}
