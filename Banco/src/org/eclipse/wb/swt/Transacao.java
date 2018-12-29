package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/



public class Transacao {
	

	protected int contaT;
	protected String data;
	protected double valor;   
	protected int contadestino;
	public TipoT escolhaT;

	protected enum TipoT {DEP_CASH,LEV_CASH,TRANSFERENCIA}

	public Transacao(int contaT, String data, double valor, int contadestino, TipoT escolhaT) {
		super();
		this.contaT = contaT;
		this.data = data;
		this.valor = valor;
		this.contadestino = contadestino;
		this.escolhaT = escolhaT;
	}

	public Transacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getContaT() {
		return contaT;
	}

	public void setContaT(int contaT) {
		this.contaT = contaT;
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

	@Override
	public String toString() {
		return "T["+contaT + ", data=" + data + ", valor=" + valor + ", contadestino=" + contadestino
				+ ", escolhaT=" + escolhaT + "]";
	};
	





}
