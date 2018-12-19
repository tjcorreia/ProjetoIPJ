<<<<<<< HEAD
package org.eclipse.wb.swt;
import java.util.GregorianCalendar;


public class Compra {
	protected int numCompra;
	protected Carrinho carrinho;
	protected int nif;
	protected GregorianCalendar data;
	protected double total;
	public Estado estadoCompra;//public para poder definir estado da compra a partir de outras classes
	protected enum Estado {SUBMETIDA, RECUSADA, FINALIZADA};//protected para poder ir para a subclasse compraCartão
	
	Compra(){
		numCompra = -1;
		carrinho = new Carrinho();
		nif = -1;
		data = new GregorianCalendar(0,0,0);
		total = -1;
		estadoCompra = null;
	}
	
	Compra( int numCompra, Carrinho carrinho, int nif, GregorianCalendar data, Estado estadoCompra){
		this.numCompra = numCompra;
		this.carrinho = carrinho;
		this.nif = nif;
		this.data = data;
		this.total = carrinho.totalCarrinho();
		this.estadoCompra = estadoCompra;
	}
	
}
=======
package org.eclipse.wb.swt;
import java.util.GregorianCalendar;


public class Compra {
	protected int numCompra;
	protected Carrinho carrinho;
	protected int nif;
	protected GregorianCalendar data;
	protected double total;
	public Estado estadoCompra;//public para poder definir estado da compra a partir de outras classes
	protected enum Estado {SUBMETIDA, RECUSADA, FINALIZADA};//protected para poder ir para a subclasse compraCartï¿½o
	
	Compra(){
		numCompra = -1;
		carrinho = new Carrinho();
		nif = -1;
		data = new GregorianCalendar(0,0,0);
		total = -1;
		estadoCompra = Estado.FINALIZADA;
	}
	
	Compra( int numCompra, Carrinho carrinho, int nif, GregorianCalendar data, Estado estadoCompra){
		this.numCompra = numCompra;
		this.carrinho = carrinho;
		this.nif = nif;
		this.data = data;
		this.total = carrinho.totalCarrinho();
		this.estadoCompra = estadoCompra;
	}
	
}
>>>>>>> branch 'master' of https://github.com/tjcorreia/ProjetoIPJ.git
