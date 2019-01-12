
package org.eclipse.wb.swt;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Compra {
	protected int numCompra;
	protected Carrinho carrinho;
	protected String nif;
	protected GregorianCalendar data;
	protected double total;
	public Estado estadoCompra;//public para poder definir estado da compra a partir de outras classes
		protected enum Estado {SUBMETIDA, PAGA, ANULADA};//protected para poder ir para a subclasse compraCartão
	
	Compra(){
		numCompra = -1;
		carrinho = new Carrinho();
		nif = "";
		data = new GregorianCalendar(0,0,0);
		total = -1;
		estadoCompra = null;
	}
	
	Compra( int numCompra, Carrinho carrinho, String nif, GregorianCalendar data, Estado estadoCompra){
		this.numCompra = numCompra;
		this.carrinho = carrinho;
		this.nif = nif;
		this.data = data;
		this.total = carrinho.totalCarrinho();
		this.estadoCompra = estadoCompra;
	}
	
	public String toString() {
		//para cada um dos livros da lista, percorrer e acrescentar cada livro à String
		String s = "****************************\n" + 
				"Compra nº:" + numCompra + "  NIF:" + nif + "  Estado:" + estadoCompra +
				"  Data:" + data.get(Calendar.YEAR) + "/"  + (data.get(Calendar.MONTH)+1) + "/" + data.get(Calendar.DAY_OF_MONTH) + "\n" 
				+ carrinho + "\n" + "TOTAL DA COMPRA:" + total + "€";
		return s;
	}

	public Estado getEstadoCompra() {
		return estadoCompra;
	}

	public void setEstadoCompra(Estado estadoCompra) {
		this.estadoCompra = estadoCompra;
	}

	public int getNumCompra() {
		return numCompra;
	}

	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}