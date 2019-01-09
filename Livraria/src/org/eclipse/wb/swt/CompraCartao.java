package org.eclipse.wb.swt;
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
}
