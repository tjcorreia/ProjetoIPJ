package org.eclipse.wb.swt;
import java.io.Serializable;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Classe 'CompraCartao' que � uma subclasse de 'Compra' e a qual tem adicionalmente
 * os atributos numCartao que define o n�mero de cart�o de d�bito e pin do respetivo cart�o
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
@SuppressWarnings("serial")
public class CompraCartao extends Compra implements Serializable{
	/**
	 * Atributos da classe
	 */
	protected String numCartao;
	protected String pin;
	
	/**
	 * Construtor da classe 'CompraCartao' a partir de todos os seus atributos
	 */
	CompraCartao( int numCompra, Carrinho carrinho, String nif, GregorianCalendar data, Estado estadoCompra, 
			String numCartao, String pin){
		super(numCompra, carrinho, nif, data, estadoCompra);
		this.numCartao = numCartao;
		this.pin = pin;
	}
	
	/**
	 * M�todo toString para impress�o da 'CompraCartao'
	 * 
	 * @return String com informa��es da 'CompraCartao'
	 */
	public String toString() {
		//para cada um dos livros da lista, percorrer e acrescentar cada livro � String
		String s = "****************************\n" + 
				"Compra n�:" + numCompra + "  NIF:" + nif + "  Estado:" + estadoCompra +
				"  Data:" + data.get(Calendar.YEAR) + "/"  + (data.get(Calendar.MONTH)+1) + "/" + data.get(Calendar.DAY_OF_MONTH) + "\n" 
				+ carrinho + "\n" + "N.� Cart�o:" + numCartao + ", PIN:" +pin + "\n" + "TOTAL DA COMPRA:" + total + "�";
		return s;
	}

	/**
	 * 
	 * 
	 * Getters e Setters para os atributos n�mero de cart�o e pin de 'CompraCartao'
	 * 
	 * 
	 */
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
