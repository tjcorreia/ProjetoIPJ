package org.eclipse.wb.swt;

import java.io.Serializable;
import java.util.ArrayList;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Cliente extends Utilizador implements Serializable{
	
	private ArrayList<Conta> lcontaS;



	


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
	}

	public Cliente(String login, String password, String nome, String sobrenome, String dataNascimento, String morada,
			TipoID escolhaID, String valorID, String email, int mobile) {
		super(login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
		this.lcontaS = new ArrayList<Conta>() ;
	}
	

	public Cliente(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, ArrayList<Conta> lcontaS) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.lcontaS = lcontaS;
	}

	public Cliente(String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, ArrayList<Conta> lcontaS) {
		super( login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.lcontaS = lcontaS;
	}	
	
	
	public ArrayList<Conta> getLcontaS() {
		return lcontaS;
	}

	public void setLcontaS(ArrayList<Conta> lcontaS) {
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
		String [] ClienteL= new String [3] ;
		ClienteL[0]=""+uID;
		ClienteL[1]=""+nome+" "+sobrenome;
		
		if (lcontaS==null) {
			ClienteL[2]="0";
			return ClienteL;
					}
		
		for (int i=0;i<lcontaS.size();i++) {
			ClienteL[2]="<";
		ClienteL[2]=ClienteL[2]+lcontaS.get(i).contaID;
		ClienteL[2]=">";
		}
		return ClienteL;
	}

 public Conta addConta(Conta novaConta) {
	 
	 lcontaS.add(novaConta);
	 return novaConta;
	 
 }
	
	

}
