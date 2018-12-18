package org.eclipse.wb.swt;

import java.util.ArrayList;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Cliente extends Utilizador {
	
	private ArrayList<String> lcontaS;

	
	public Cliente() {
		super();
		this.lcontaS = new ArrayList<String> ();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int uID, String login, String password, String nome, String morada, TipoID escolhaID, String email,
			int mobile) {
		super(uID, login, password, nome, morada, escolhaID, email, mobile);
		// TODO Auto-generated constructor stub
		this.lcontaS = new ArrayList<String> ();
	}
	
	public Cliente(int uID, String login, String password, String nome, String morada, TipoID escolhaID, String email,
			int mobile,ArrayList<String> lcontaS) {
		super(uID, login, password, nome, morada, escolhaID, email, mobile);
		// TODO Auto-generated constructor stub
		
	}

	public ArrayList<String> getLcontaS() {
		return lcontaS;
	}

	public void setLcontaS(ArrayList<String> lcontaS) {
		this.lcontaS = lcontaS;
	}
	
	///  metodo para adicionar lista de contas ao cliente
	public void addcontaS(String novaC) {
		lcontaS.add(novaC);
	}

}
