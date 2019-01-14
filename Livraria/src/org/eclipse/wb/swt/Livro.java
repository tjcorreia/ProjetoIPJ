
package org.eclipse.wb.swt;

import java.io.Serializable;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.HashMap;
import java.util.Set;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Livro implements Serializable {
	/**
	 * Atributos da classe
	 */
	protected String nome;
	protected String isbn;
	protected String autor;
	protected String editora;
	protected String descricao;
	protected GregorianCalendar data;
	protected double preco;
	protected int stock;
	protected HashMap<GregorianCalendar, Double> precosAnteriores;

	/**
	 * Construtor da classe 'Livro' por defeito
	 */
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

	/**
	 * Construtor da classe 'Livro' a partir de todos os seus atributos
	 */
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

	/**
	 * Construtor da classe 'Livro' a partir de todos os seus atributos menos os preços anteriores
	 */
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

	/**
	 * Método para impressão do histórico de preços de um livro
	 * (apenas para verificação)
	 */
	public void imprimirHistoricoPrecos() {
		Set<GregorianCalendar> datas = precosAnteriores.keySet();
		for (GregorianCalendar gc : datas) {
			System.out.println("Data:" + gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH) + 1) + "/"
					+ gc.get(Calendar.DAY_OF_MONTH) + " Preço:" + precosAnteriores.get(gc) + "€");
		}
	}

	/**
	 * Método toString para impressão de um Livro
	 * 
	 * @return String com informação de todos os atributos de um livro
	 */
	public String toString() {
		String s = "Título: " + nome + "\n  Autor: " + autor + "      Editora: " + editora + "\n  ISNB: " + isbn + "     Data: "
				+ data.get(Calendar.YEAR) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.DAY_OF_MONTH)
				+ "    Stock: " + stock + " unidades" + "\n  Descrição: " + descricao + "\n       PREÇO: " + preco + "€";
		return s;
	}

	/**
	 * 
	 * 
	 * Getters e Setters para os atributos de 'Livro'
	 * 
	 * 
	 */
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
}
