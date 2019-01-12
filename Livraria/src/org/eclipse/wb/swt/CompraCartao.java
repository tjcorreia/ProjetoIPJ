package org.eclipse.wb.swt;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.eclipse.wb.swt.Compra.Estado;


public class CompraCartao extends Compra{
	protected String numCartao;
	protected String pin;
	
	CompraCartao(){
		super();
		numCartao = "";
		pin = "";
	}
	
	CompraCartao( int numCompra, Carrinho carrinho, String nif, GregorianCalendar data, Estado estadoCompra){
		super(numCompra, carrinho, nif, data, estadoCompra);
		numCartao = "";
		pin = "";
	}
	
	CompraCartao( int numCompra, Carrinho carrinho, String nif, GregorianCalendar data, Estado estadoCompra, 
			String numCartao, String pin){
		super(numCompra, carrinho, nif, data, estadoCompra);
		this.numCartao = numCartao;
		this.pin = pin;
	}
	
	public String toString() {
		//para cada um dos livros da lista, percorrer e acrescentar cada livro à String
		String s = "****************************\n" + 
				"Compra nº:" + numCompra + "  NIF:" + nif + "  Estado:" + estadoCompra +
				"  Data:" + data.get(Calendar.YEAR) + "/"  + (data.get(Calendar.MONTH)+1) + "/" + data.get(Calendar.DAY_OF_MONTH) + "\n" 
				+ carrinho + "\n" + "N.º Cartão:" + numCartao + ", PIN:" +pin + "\n" + "TOTAL DA COMPRA:" + total + "€";
		return s;
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
