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
	
	// String com login 
	private Map<String, Utilizador> mapUtilizadores; 
	private ArrayList<Conta> lfaturas;
	private Map<Integer, Integer> mapCartaoConta;
	
	
public Gestao(Map<String, Utilizador> mapUtilizadores, ArrayList<Conta> lfaturas,
			Map<Integer, Integer> mapCartaoConta) {
		super();
		this.mapUtilizadores = mapUtilizadores;
		this.lfaturas = lfaturas;
		this.mapCartaoConta = mapCartaoConta;
	}


public Gestao() {
	super();
	this.mapUtilizadores = new HashMap<String, Utilizador>();
	this.lfaturas = new ArrayList<Conta>();
	this.mapCartaoConta = new HashMap<Integer, Integer>();
	
	Administrador MachadoU= new  Administrador(1, "Machado", "Admin", "Machado0",
			"Cb",Administrador.TipoID.CARTAOCIDADAO,78456123,"mail",965420730);
	
	Administrador CorreiaU= new  Administrador(2, "Correia", "Admin", "Coreia",
			"Cb",Administrador.TipoID.CARTAOCIDADAO,12345678,"mail",965420730);
	
	mapUtilizadores.put("Machado",MachadoU);
	mapUtilizadores.put("Machado",CorreiaU);
	
}








public Map<String, Utilizador> getMapUtilizadores() {
	return mapUtilizadores;
}


public void setMapUtilizadores(Map<String, Utilizador> mapUtilizadores) {
	this.mapUtilizadores = mapUtilizadores;
}


public ArrayList<Conta> getLfaturas() {
	return lfaturas;
}


public void setLfaturas(ArrayList<Conta> lfaturas) {
	this.lfaturas = lfaturas;
}


public Map<Integer, Integer> getMapCartaoConta() {
	return mapCartaoConta;
}


public void setMapCartaoConta(Map<Integer, Integer> mapCartaoConta) {
	this.mapCartaoConta = mapCartaoConta;
}

public void Gerir() {
	J_10Login teste = new J_10Login (new Gestao());
	verLog (teste);
	teste.shlLogin.dispose();
	
}


public void verLog (J_10Login janela) {
	
	janela.open();
	
	janela.getPassword();
	System.out.print(janela.getUserLog());
	System.out.print(janela.getPassword());
	System.out.print(janela.getUserLog());
	
	
	
//	if (!verfLogin(teste.getUserLog(),teste.getPassword()).equals(null)) {
//		System.out.print(teste.getUserLog());
//	}
	
}

		
	
	
		
	
	
	

	
 //// faz a verificação das entradas do login
 public Utilizador  verfLogin(String username, String password) {
     
     if (mapUtilizadores.containsKey(username)) {
    	 if (mapUtilizadores.get(username).password.equals(password)) {       	 
             return mapUtilizadores.get(username);
         }
     }
     return null;
 }
 
 
 
 
 
 
}
