package org.eclipse.wb.swt;

import java.io.Serializable;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/



public class Transacao implements Serializable{
	

	private int tID;
	private int funcionarioID;
	private String data;
	private double valor;
	private String info;
	private int contadestino;
	private TipoT escolhaT;
	public enum TipoT {DEP_CASH,LEV_CASH,TRANSFERENCIA}
	
	public Transacao(int funcionarioID, String data, double valor, String info, int contadestino, TipoT escolhaT) {
		super();
		this.funcionarioID = funcionarioID;
		this.data = data;
		this.valor = valor;
		this.info = info;
		this.contadestino = contadestino;
		this.escolhaT = escolhaT;
	}

	public Transacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int gettID() {
		return tID;
	}

	public void settID(int tID) {
		this.tID = tID;
	}

	public int getFuncionarioID() {
		return funcionarioID;
	}

	public void setFuncionarioID(int funcionarioID) {
		this.funcionarioID = funcionarioID;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getContadestino() {
		return contadestino;
	}

	public void setContadestino(int contadestino) {
		this.contadestino = contadestino;
	}

	public TipoT getEscolhaT() {
		return escolhaT;
	}

	public void setEscolhaT(TipoT escolhaT) {
		this.escolhaT = escolhaT;
	}
	

	
	}
	