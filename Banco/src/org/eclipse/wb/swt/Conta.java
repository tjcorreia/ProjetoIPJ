package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/

import java.io.Serializable;
import java.util.ArrayList;


public class Conta implements Serializable{
	

	protected int contaID;        //
	protected double saldo;   //
	protected String datacria;
	protected ArrayList<Transacao> transacoesC;// 
	protected ArrayList<Integer> clientesDaC;// 
	public TipoC escolhaID;
	
	protected enum TipoC {ABERTA,ENCERADA}







	public Conta(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
			ArrayList<Integer> clientesDaC, TipoC escolhaID) {
		super();
		this.contaID = contaID;
		this.saldo = saldo;
		this.datacria = datacria;
		this.transacoesC = transacoesC;
		this.clientesDaC = clientesDaC;
		this.escolhaID = escolhaID;
	}


	

	public Conta() {
		super();
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.escolhaID = TipoC.ABERTA;
		// TODO Auto-generated constructor stub
	}
	
	public Conta(int contaID, double saldo, String datacria) {
		super();
		this.contaID = contaID;
		this.saldo = saldo;
		this.datacria = datacria;
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.escolhaID = TipoC.ABERTA;
		// TODO Auto-generated constructor stub
	}




	public int getContaID() {
		return contaID;
	}




	public void setContaID(int contaID) {
		this.contaID = contaID;
	}




	public double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}




	public String getDatacria() {
		return datacria;
	}




	public void setDatacria(String datacria) {
		this.datacria = datacria;
	}




	public ArrayList<Transacao> getTransacoesC() {
		return transacoesC;
	}




	public void setTransacoesC(ArrayList<Transacao> transacoesC) {
		this.transacoesC = transacoesC;
	}




	public ArrayList<Integer> getClientesDaC() {
		return clientesDaC;
	}




	public void setClientesDaC(ArrayList<Integer> clientesDaC) {
		this.clientesDaC = clientesDaC;
	}




	public TipoC getEscolhaID() {
		return escolhaID;
	}




	public void setEscolhaID(TipoC escolhaID) {
		this.escolhaID = escolhaID;
	}




	@Override
	public String toString() {
		return "Conta [contaID=" + contaID + ", saldo=" + saldo + ", datacria=" + datacria + ", transacoesC="
				+ transacoesC + ", clientesDaC=" + clientesDaC + ", escolhaID=" + escolhaID + "]";
	}


	 public int addClienteC(int clienteID) {
		 
		 clientesDaC.add(clienteID);
		 return clienteID;
		 
	 }


	
	

	
	
	
	





}
