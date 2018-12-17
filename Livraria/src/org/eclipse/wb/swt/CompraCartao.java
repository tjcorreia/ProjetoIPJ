package org.eclipse.wb.swt;
import java.util.GregorianCalendar;


public class CompraCartao extends Compra{
	protected int numCartao;
	protected int pin;
	
	CompraCartao(){
		super();
		numCartao = -1;
		pin = -1;
	}
	
	CompraCartao( int numCompra, Carrinho carrinho, int nif, GregorianCalendar data, double total, Estado estadoCompra){
		super();
		numCartao = -1;
		pin = -1;
	}
}
