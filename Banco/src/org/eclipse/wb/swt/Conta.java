package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.wb.swt.Utilizador.TipoID;

public class Conta {
	

	protected int contaID;        //
	protected double saldo;   // 
	protected ArrayList<Transacao> transacoesC;// 
	protected ArrayList<Integer> clientesDaC;// 
	public TipoC escolhaID;
	
	protected enum TipoC {ABERTA,ENCERADA}



	public Conta(int contaID, double saldo, ArrayList<Transacao> transacoesC, ArrayList<Integer> clientesDaC,
			TipoC escolhaID) {
		super();
		this.contaID = contaID;
		this.saldo = saldo;
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
	
	public Conta(int contaID, double saldo) {
		super();
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


	
	

	
	
	
	





}
