package estudos.enumerador;

import java.util.ArrayList;

public enum Marcas {

	
	FIAT(modelosFiat()), WV(modelosWV());
	
	
	public ArrayList<String> modelos;
	Marcas(ArrayList<String> modelos){
		this.modelos = modelos;
	}
	
	//Listagem de modelos
	
	
	public static ArrayList<String> modelosFiat(){
		ArrayList<String> modelos = new ArrayList<>();
		modelos.add("Uno");
		modelos.add("Palio");
		return modelos;
	}
	public static ArrayList<String> modelosWV(){
		ArrayList<String> modelos = new ArrayList<>();
		modelos.add("Fox");
		modelos.add("Voiage");
		return modelos;
	}
	
	//gets
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Marcas getMarcaById(int id){
		
		for (Marcas marca : Marcas.values()) {
			if(Marcas.valueOf(marca.toString()).ordinal() == id){
				return Marcas.valueOf(marca.toString());
			}
		}

		return null;
	}
	
	public static ArrayList<String> listaMarcas(){
		ArrayList<String> lista = new ArrayList<>();
		for (Marcas marca : Marcas.values()) {
			lista.add(marca.toString());
		}
		return lista;
	}
	
	public String getModeloById(int id){
		return this.modelos.get(id);
	}
	
}
