package org.eclipse.wb.swt;

import java.util.ArrayList;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Cliente extends Utilizador {
	
	private ArrayList<Conta> lcontaS;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int uID, String login, String password, String nome, String morada, TipoID escolhaID, int valorID,
			String email, int mobile) {
		super(uID, login, password, nome, morada, escolhaID, valorID, email, mobile);
		this.lcontaS = null;
		// TODO Auto-generated constructor stub
	}

	public Cliente(int uID, String login, String password, String nome, String morada, TipoID escolhaID, int valorID,
			String email, int mobile, ArrayList<Conta> lcontaS) {
		super(uID, login, password, nome, morada, escolhaID, valorID, email, mobile);
		this.lcontaS = lcontaS;
	}

	
	@Override
	public String toString() {
		if (lcontaS==null) {
			return "Cliente [" + uID + "nome=" + nome + ", morada=" + morada + ", email=" + email + ", mobile=" + mobile + "]";
			}
		return "Cliente [" + uID + "nome=" + nome + ", morada=" + morada + ", email=" + email + ", mobile=" + mobile + "]"+
	"lcontaS=" + lcontaS.toString() ;
	}
	
	public String [] toTable() {
		String [] ClienteL= new String [6] ;
		ClienteL[0]=""+uID;
		ClienteL[1]=""+nome;
		ClienteL[2]=""+morada;
		ClienteL[3]=""+email;
		ClienteL[4]=""+mobile;
		
		if (lcontaS==null) {
			ClienteL[5]="0";
			return ClienteL;
					}
		
		ClienteL[5]=""+lcontaS.size();
		return ClienteL;
	}


	
	

}
