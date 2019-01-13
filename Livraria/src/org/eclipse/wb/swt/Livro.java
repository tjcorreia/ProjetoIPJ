
package org.eclipse.wb.swt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Livro {
	protected String nome;
	protected String isbn;
	protected String autor;
	protected String editora;
	protected String descricao;
	protected GregorianCalendar data;
	protected double preco;
	protected int stock;
	protected HashMap<GregorianCalendar, Double> precosAnteriores;

	// construtor vazio
	Livro() {
		nome = "";
		isbn = "";
		autor = "";
		editora = "";
		descricao = "";
		data = new GregorianCalendar(0, 0, 0);
		preco = -1;
		stock = -1;
		precosAnteriores = new HashMap<>();
	}

	// construtor completo
	Livro(String nome, String isbn, String autor, String editora, String descricao, GregorianCalendar data,
			double preco, int stock, HashMap<GregorianCalendar, Double> precosAnteriores) {
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

	// construtor com todas as instâncias menos os preços anteriores
	Livro(String nome, String isbn, String autor, String editora, String descricao, GregorianCalendar data,
			double preco, int stock) {
		this.nome = nome;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.descricao = descricao;
		this.data = data;
		this.preco = preco;
		this.stock = stock;
		this.precosAnteriores = new HashMap<>();
	}

	public void imprimirHistoricoPrecos() {
		Set<GregorianCalendar> datas = precosAnteriores.keySet();
		for (GregorianCalendar gc : datas) {
			System.out.println("Data:" + gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH) + 1) + "/"
					+ gc.get(Calendar.DAY_OF_MONTH) + " Preço:" + precosAnteriores.get(gc) + "€");
		}
	}

	public String toString() {
		String s = "Título: " + nome + "\n  Autor: " + autor + "      Editora: " + editora + "\n  ISNB: " + isbn + "     Data: "
				+ data.get(Calendar.YEAR) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.DAY_OF_MONTH)
				+ "    Stock: " + stock + " unidades" + "\n  Descrição: " + descricao + "\n       PREÇO: " + preco + "€";
		return s;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public HashMap<GregorianCalendar, Double> getPrecosAnteriores() {
		return precosAnteriores;
	}

	public void setPrecosAnteriores(HashMap<GregorianCalendar, Double> precosAnteriores) {
		this.precosAnteriores = precosAnteriores;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	
//	//comparador para ordenar livros por titulo
//	public static Comparator<Livro> ordenarPorAutor = new Comparator<Livro>() {
//		public int compare(Livro l1, Livro l2) {
//			String autor1 = l1.getAutor().toUpperCase();
//			String autor2 = l2.getAutor().toUpperCase();
//			// se os dois tiverem em forma ascendente, devolver em forma descendente
//			if (autor1.compareToIgnoreCase(autor2) >= 0) {
//				return autor2.compareTo(autor1);
//			}
//			// se os dois tiverem em forma descendente, devolver em forma ascendente
//			else {
//				return autor1.compareTo(autor2);
//				
//			}
//		}
//	};	

//	/* Comparator for sorting the list by roll no */
//	public static Comparator<Student> StuRollno = new Comparator<Student>() {
//
//		public int compare(Student s1, Student s2) {
//
//			int rollno1 = s1.getRollno();
//			int rollno2 = s2.getRollno();
//
//			/* For ascending order */
//			return rollno1 - rollno2;
//
//			/* For descending order */
//			// rollno2-rollno1;
//		}
//	};

}
