package org.eclipse.wb.swt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.wb.swt.Conta.TipoC;
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
	private ArrayList<Conta> lContas;
	private Map<Integer, Integer> mapCartaoConta;
	
	
	
public Gestao(Map<String, Utilizador> mapUtilizadores, ArrayList<Conta> lfaturas,
			Map<Integer, Integer> mapCartaoConta) {
		super();
		this.mapUtilizadores = mapUtilizadores;
		this.lContas = lfaturas;
		this.mapCartaoConta = mapCartaoConta;
	}


public Gestao() {
	super();
	this.mapUtilizadores = new HashMap<String, Utilizador>();
	this.lContas = new ArrayList<Conta>();
	this.mapCartaoConta = new HashMap<Integer, Integer>();
	
	Administrador MachadoU= new  Administrador(1, "Alberto Jorge V.C. Machado", "Admin", "Machado0",
			"Cb",Administrador.TipoID.CARTAOCIDADAO,78456123,"mail",965420730);
	
	Administrador CorreiaU= new  Administrador(2, "Correia", "Admin", "Coreia",
			"Cb",Administrador.TipoID.CARTAOCIDADAO,12345678,"mail",965420730);
	
	mapUtilizadores.put("Machado",MachadoU);
	mapUtilizadores.put("Correia",CorreiaU);
	
	// Contas 
	
	ContaNormal cn1= new ContaNormal(1,500);
	ContaNormal cn2= new ContaNormal(1,500);
	ContaNormal cn3= new ContaNormal(1,500);
	
	ContaNormal(int contaID, double saldo, ArrayList<Transacao> transacoesC, ArrayList<String> clientesDaC,
			TipoC escolhaID, Cartao cartaodaConta)
	
	
}








public Map<String, Utilizador> getMapUtilizadores() {
	return mapUtilizadores;
}


public void setMapUtilizadores(Map<String, Utilizador> mapUtilizadores) {
	this.mapUtilizadores = mapUtilizadores;
}





public ArrayList<Conta> getlContas() {
	return lContas;
}


public void setlContas(ArrayList<Conta> lContas) {
	this.lContas = lContas;
}


public Map<Integer, Integer> getMapCartaoConta() {
	return mapCartaoConta;
}


public void setMapCartaoConta(Map<Integer, Integer> mapCartaoConta) {
	this.mapCartaoConta = mapCartaoConta;
}

public void Gerir() {
	J_10Login novoLogin = new J_10Login ();

	Utilizador aprovado=new Utilizador();
	do {
		
		novoLogin.open();
		aprovado=novoLogin.utilizadorAprovado();
	} while (aprovado==null);
	
	System.out.print("passou ->>"+novoLogin.utilizadorAprovado().nome);
	if (aprovado instanceof Administrador) {
	
		J04_MenuAdministrador novaJAdmin = new J04_MenuAdministrador (aprovado);
		
		novaJAdmin.open();
	}

	

	
}


	
 //// faz a verificação das entradas do login
 public Utilizador  verfLogin(String username, String passwordV) {
     
     if (mapUtilizadores.containsKey(username)) {
    	 if (mapUtilizadores.get(username).password.equals(passwordV)) {       	 
             return mapUtilizadores.get(username);
         }
     }
     return null;
 }
 
 
 
 
 
 
}
