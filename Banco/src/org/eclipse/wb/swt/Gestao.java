package org.eclipse.wb.swt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.wb.swt.Utilizador.TipoID;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Gestao {
	
	private ArrayList<Utilizador> lutilizadores;
	private ArrayList<Conta> lfaturas;
	private Map<Integer, Integer> mapQR;
	
	
	
	public Gestao(ArrayList<Utilizador> lutilizadores, ArrayList<Conta> lfaturas, Map<Integer, Integer> mapQR) {
		super();
		this.lutilizadores = lutilizadores;
		this.lfaturas = lfaturas;
		this.mapQR = mapQR;
	}




	
		
		
		public Gestao() {
		super();
		this.lutilizadores = new ArrayList<Utilizador>();
		this.lfaturas = new ArrayList<Conta>();
		this.mapQR = new HashMap<Integer, Integer>();
		
		Administrador Machado= new  Administrador(1, "Machado", "Admin", "Machado0",
				"Cb",Administrador.TipoID.CARTAOCIDADAO,78456123,"mail",965420730);
		
		Administrador Correia= new  Administrador(2, "Correia", "Admin", "Coreia",
				"Cb",Administrador.TipoID.CARTAOCIDADAO,12345678,"mail",965420730);
		// TODO Auto-generated constructor stub
	}


		public ArrayList<Utilizador> getLutilizadores() {
			return lutilizadores;
		}

		public void setLutilizadores(ArrayList<Utilizador> lutilizadores) {
			this.lutilizadores = lutilizadores;
		}

		public ArrayList<Conta> getLfaturas() {
			return lfaturas;
		}

public void setLfaturas(ArrayList<Conta> lfaturas) {
			this.lfaturas = lfaturas;
		}

		public Map<Integer, Integer> getMapQR() {
			return mapQR;
		}

		public void setMapQR(Map<Integer, Integer> mapQR) {
			this.mapQR = mapQR;
		}




		
	
	
		public void Gerir (){
						
			J_10Login teste = new J_10Login (this.lutilizadores);
			teste.open();
			
			
		}
	
	
	
 public void procuraUtl(String log, String pass) {
	 
	 
	 
 }
	

}
