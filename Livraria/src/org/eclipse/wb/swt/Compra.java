
package org.eclipse.wb.swt;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Classe compra que representa uma compra, identificada por um número de compra único,
 * um objeto Carrinho, um número de identificação fiscal (nif) uma data, o preço total 
 * e o estado da compra, que poderá estar no estado 'submetida', 'paga' ou 'anulada'
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Compra implements Serializable{
	/**
	 * Atributos da classe
	 */
	protected int numCompra;
	protected Carrinho carrinho;
	protected String nif;
	protected GregorianCalendar data;
	protected double total;
	protected Estado estadoCompra;
	protected enum Estado {SUBMETIDA, PAGA, ANULADA};
	
	/**
	 * Construtor da classe Compra sem atributos fornecidos
	 */
	Compra(){
		numCompra = -1;
		carrinho = new Carrinho();
		nif = "";
		data = new GregorianCalendar(0,0,0);
		total = -1;
		estadoCompra = null;
	}
	
	/**
	 * Construtor da classe Compra a partir de todos os seus atributos
	 */
	Compra( int numCompra, Carrinho carrinho, String nif, GregorianCalendar data, Estado estadoCompra){
		this.numCompra = numCompra;
		this.carrinho = carrinho;
		this.nif = nif;
		this.data = data;
		this.total = carrinho.totalCarrinho();
		this.estadoCompra = estadoCompra;
	}
	
	/**
	 * Método toString para impressão de 'Compra'
	 * 
	 * @return String com informações do 'Compra'
	 */
	public String toString() {
		//para cada um dos livros da lista, percorrer e acrescentar cada livro à String
		String s = "****************************\n" + 
				"Compra nº:" + numCompra + "  NIF:" + nif + "  Estado:" + estadoCompra +
				"  Data:" + data.get(Calendar.YEAR) + "/"  + (data.get(Calendar.MONTH)+1) + "/" + data.get(Calendar.DAY_OF_MONTH) + "\n" 
				+ carrinho + "\n" + "TOTAL DA COMPRA:" + total + "€";
		return s;
	}

	/**
	 * 
	 * 
	 * Getters e Setters para os atributos de 'Compra'
	 * 
	 * 
	 */
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public String getNif() {
		return nif;
	}

	public GregorianCalendar getData() {
		return data;
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

	public double getTotal() {
		return total;
	}
}