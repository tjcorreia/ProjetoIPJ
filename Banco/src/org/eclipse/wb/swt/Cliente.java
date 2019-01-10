package org.eclipse.wb.swt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Cliente extends Utilizador implements Serializable{
	
	private ArrayList<Conta> lcontaSC;



	


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.lcontaSC = new ArrayList<Conta>() ;
		// TODO Auto-generated constructor stub
	}

	public Cliente(String login, String password, String nome, String sobrenome, String dataNascimento, String morada,
			TipoID escolhaID, String valorID, String email, int mobile) {
		super(login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
		this.lcontaSC = new ArrayList<Conta>() ;
	}
	

	public Cliente(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, ArrayList<Conta> lcontaSC) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.lcontaSC = lcontaSC;
	}

	public Cliente(String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, ArrayList<Conta> lcontaS) {
		super( login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.lcontaSC = lcontaS;
	}	
	
	
	public ArrayList<Conta> getLcontaSC() {
		return lcontaSC;
	}

	public void setLcontaSC(ArrayList<Conta> lcontaS) {
		this.lcontaSC = lcontaS;
	}
	
	@Override
	public String toString() {
		if (lcontaSC==null) {
			return "Cliente [" + uID + "nome=" + nome + ", morada=" + morada + ", email=" + email + ", mobile=" + mobile + "]";
			}
		return "Cliente [" + uID + "nome=" + nome + ", morada=" + morada + ", email=" + email + ", mobile=" + mobile + "]"+
	"lcontaSC=" + Arrays.toString(lcontaSC.toArray()) ;
	}
	
	public String [] toTable() {
		String [] ClienteL= new String [3] ;
		ClienteL[0]=""+uID;
		ClienteL[1]=""+nome+" "+sobrenome;
		ClienteL[2]="";
		if (lcontaSC==null) {
			ClienteL[2]="0";
			return ClienteL;
					}
		
		for (int i=0;i<lcontaSC.size();i++) {
			ClienteL[2]=ClienteL[2]+"<";
		ClienteL[2]=ClienteL[2]+""+lcontaSC.get(i).getContaID();
		ClienteL[2]=ClienteL[2]+">";
		}
		return ClienteL;
	}

	public String listadeContasC() {
		String ClienteLC="";
		if (lcontaSC==null) {
		ClienteLC="0";
		return ClienteLC;
				}
	
	for (int i=0;i<lcontaSC.size();i++) {
		ClienteLC=ClienteLC+"<";
	ClienteLC=ClienteLC+this.lcontaSC.get(i).getContaID();
	ClienteLC=ClienteLC+">";
	}
	return ClienteLC;
	}
	
	
 public Conta addConta(Conta novaConta) {
	 
	 lcontaSC.add(novaConta);
	 return novaConta;
	 
 }
	
public Conta procuraConta(int idDaConta) {
	 
	if (!(lcontaSC==null)) {
		for (Conta c:lcontaSC) {
		if (c.getContaID()==idDaConta)
			return c;
		}
	}
	return null;
 }
	
public Conta procuraContaPrazo() {
	 
	if (!(lcontaSC==null)) {
		for (Conta c:lcontaSC) {
		if (c instanceof ContaPrazo)
			return c;
		}
	}
	return null;
 }

}
