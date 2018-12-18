package org.eclipse.wb.swt;


import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.ibm.icu.util.Calendar;



public class Livro {
	protected String nome;
	protected String isbn;
	protected String autor;
	protected String editora;
	protected String descricao;
	protected GregorianCalendar data;
	protected double preco;
	protected int stock;
	protected Map <GregorianCalendar, Double > precosAnteriores;
	
	// construtor vazio
	Livro(){
		nome = "";
		isbn = "";
		autor = "";
		editora = "";
		descricao = "";
		data = new GregorianCalendar(0,0,0);
		preco = -1;
		stock = -1;
		precosAnteriores = new HashMap <>();
	}
	
	//construtor completo
	Livro(String nome, String isbn, String autor, String editora, String descricao, GregorianCalendar data, 
			double preco, int stock, Map <GregorianCalendar, Double > precosAnteriores){
		this.nome = nome;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.descricao = descricao;
		this.data = data;
		this.preco = preco;
		this.stock = stock;
		this.precosAnteriores = precosAnteriores;
	}
	
	//construtor com todas as instâncias menos os preços anteriores
	Livro(String nome, String isbn, String autor, String editora, String descricao, GregorianCalendar data, 
			double preco, int stock){
		this.nome = nome;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.descricao = descricao;
		this.data = data;
		this.preco = preco;
		this.stock = stock;
		this.precosAnteriores = new HashMap <>();
	}
	
	public String toString() {
		String s = "Livro:" + nome + ", Autor:" + autor + ", Editora:" + editora + 
				"\n\t ISNB:" + isbn + ", Data:" + data.get(Calendar.YEAR) + "/"  + data.get(Calendar.MONTH) +
				"/"  + data.get(Calendar.DAY_OF_MONTH) + "\n\t Descrição:" + descricao;
		return s;
	}
	
}
