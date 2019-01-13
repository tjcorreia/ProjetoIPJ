
package org.eclipse.wb.swt;

import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.wb.swt.Utilizador.Tipo;

/**
 * Classe
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Livraria implements Serializable {
	private ArrayList<Livro> livros;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Compra> compras;

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	// Construtor 
	Livraria() throws ClassNotFoundException {

		loadAll();
	}

	public void testar() {

		Scanner sc = new Scanner(System.in);
		System.out.println("introduza livro a pesquisar");
		String s = sc.nextLine();
		ArrayList<Livro> livrosProcurados = procurarLivro(s);
		for (Livro lv : livrosProcurados) {
			System.out.println(lv);
		}
		sc.close();
	}



	// método que recebe uma string e procura na lista de livros, todos os livros
	// que têm essa String
	// quer seja no nome, autor, editora ou ISBN
	public ArrayList<Livro> procurarLivro(String s) {
		ArrayList<Livro> livrosProcurados = new ArrayList<>();

		System.out.println(s);

		for (Livro lv : livros) {
			if (lv.autor.toUpperCase().contains(s.toUpperCase())) {
				livrosProcurados.add(lv);
			} else if (lv.nome.toUpperCase().contains(s.toUpperCase())) {
				livrosProcurados.add(lv);
			} else if (lv.editora.toUpperCase().contains(s.toUpperCase())) {
				livrosProcurados.add(lv);
			} else if (lv.isbn.toUpperCase().contains(s.toUpperCase())) {
				livrosProcurados.add(lv);
			}
		}
		return livrosProcurados;
	}

	// método que recebe um numero de compra e procura a compra na lista de compras
	public Compra getCompra(int num) {
		for (Compra c : compras) {
			if (c.numCompra == num) {
				return c;
			}
		}
		// apenas porque tem de ser devolvido algum livro no fim. Mas esta parte nunca
		// será usada
		return new Compra();
	}

	public String toString() {
		String s = "";
		for (Livro lv : livros) {
			s = s + "-----------------------------------\n" + lv + "\n" + "Stock: " + lv.stock + "\n";
		}
		return s;
	}

	// Método para obter Livro a partir do seu isbn
	public Livro getLivro(String isbn) {
		for (Livro lv : livros) {
			if (lv.isbn.equals(isbn)) {
				return lv;
			}
		}
		// apenas porque tem de ser devolvido algum livro no fim. Mas esta parte nunca
		// será usada
		return new Livro();
	}

	// método que recebe password e email de login e devolve string com ok ou
	// eventual erro
	public String verificarLogin(String email, String password) {
		for (Utilizador u : utilizadores) {
			if (u.email.equals(email) && u.senha.equals(password)) {
				return "ok";
			} else if (u.email.equals(email) && !u.senha.equals(password)) {
				return "passwordErrada";
			}
		}
		// caso não se verifique nenhuma das anteriores é porque o email é errado
		return "emailErrado";
	}

	public boolean verificarSeNIFouCartao(String s) {
		// ver se tem algum carater que não seja numero
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		// ver se tem 9 digitos
		if (s.toCharArray().length != 9) {
			return false;
		}
		return true;
	}

	public boolean verificarSePIN(String s) {
		// ver se tem algum carater que não seja numero
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		// ver se tem 9 digitos
		if (s.toCharArray().length != 3) {
			return false;
		}
		return true;
	}

	// método que atravez do email de login devolve o utilizador
	public Utilizador getUtilizadorPorEmail(String email) {
		for (Utilizador u : utilizadores) {
			if (u.email.equals(email)) {
				return u;
			}
		}
		// caso por defeito que nunca será usado
		return new Utilizador();
	}

	public void aumentarStock(Livro lv, int quantidade) {
		lv.setStock(lv.getStock() + quantidade);
	}

	public void reduzirStock(Livro lv, int quantidade) {
		lv.setStock(lv.getStock() - quantidade);
		saveAll();
	}

	// Método para adicionar um novo (ou repetido) livro ao carrinho
	public Carrinho adicionarLivroAoCarrinho(Livro lv, Carrinho carrinho) {
		// Se livro não tem stock, não fazer nada
		if (lv.stock <= 0) {
		}
		// Se livro já existe na lista, aumentar a quantidade
		else if (carrinho.livros.contains(lv)) {
			int indice = carrinho.livros.indexOf(lv);
			int quantidade = carrinho.quantidades.get(indice);
			carrinho.quantidades.set(indice, quantidade + 1);
			reduzirStock(lv, 1);
		}
		// se livro não existia, acrescenta-se livro a 'livros' e quantidade a
		// 'quantidades'
		else {
			carrinho.livros.add(lv);
			carrinho.quantidades.add(1);
			reduzirStock(lv, 1);
		}
		saveAll();
		return carrinho;
	}

	// Método para remover um livro do carrinho
	public Carrinho removerLivroDoCarrinho(Livro lv, Carrinho carrinho) {
		int indice = carrinho.livros.indexOf(lv);
		int quantidade = carrinho.quantidades.get(indice);
		// se livro não vem na lista do carrinho, não fazer nada
		if (!carrinho.livros.contains(lv)) {
		}
		// Se só havia um exemplar, remover o livro
		else if (quantidade == 1) {
			carrinho.livros.remove(indice);
			carrinho.quantidades.remove(indice);
			aumentarStock(lv, 1);
		}
		// se há mais do que um exemplar, reduzir quantidade
		else {
			carrinho.quantidades.set(indice, quantidade - 1);
			aumentarStock(lv, 1);
		}
		saveAll();
		return carrinho;
	}

	// Método para esvaziar carrinho, repondo os stocks na livraria
	public Carrinho esvaziarCarrinhoReporStock(Carrinho carrinho) {
		for (int i = 0; i < carrinho.livros.size(); i++) {
			String isbn = carrinho.livros.get(i).isbn;
			int quantidade = carrinho.quantidades.get(i);
			Livro lv = getLivro(isbn);
			// repor o stock
			lv.stock = lv.stock + quantidade;
		}
		// limpar carrinho
		carrinho.livros.clear();
		carrinho.quantidades.clear();
		saveAll();
		return carrinho;
	}

	// Método para esvaziar carrinho, repondo os stocks na livraria
	public Carrinho esvaziarCarrinhoSemReporStock(Carrinho carrinho) {
		// limpar carrinho
		carrinho.livros.clear();
		carrinho.quantidades.clear();
		saveAll();
		return carrinho;
	}

	// Método que devolve um novo número de compra (a seguir ao número de compra
	// existente maior)
	public int gerarNovoNumCompra() {
		int novoNum = 0;
		for (Compra c : compras) {
			if (c.numCompra >= novoNum) {
				novoNum = c.numCompra + 1;
			}
		}
		return novoNum;
	}

	// Método que devolve um novo número de vendedor (a seguir ao número de vendedor
	// existente maior)
	public int gerarNovoNumUtilizador() {
		int novoNum = 0;
		for (Utilizador u : utilizadores) {
			if (u.uID >= novoNum) {
				novoNum = u.uID + 1;
			}
		}
		return novoNum;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public void loadAll() throws ClassNotFoundException {
		//Ficheiro de livros
		String pathLivros = "C:\\Users\\Tiago\\Desktop\\ProjetoIPJ\\Livraria\\Livros";
		FicheiroDeObjectos ficheiroLivros = new FicheiroDeObjectos();
		try {
			ficheiroLivros.abreLeitura(pathLivros);
			livros = (ArrayList<Livro>) ficheiroLivros.leObjecto();
			ficheiroLivros.fechaLeitura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ficheiro de utilizadores
		String pathUtilizadores = "C:\\Users\\Tiago\\Desktop\\ProjetoIPJ\\Livraria\\Utilizadores";
		FicheiroDeObjectos ficheiroUtilizadores = new FicheiroDeObjectos();
		try {
			ficheiroUtilizadores.abreLeitura(pathUtilizadores);
			utilizadores = (ArrayList<Utilizador>) ficheiroUtilizadores.leObjecto();
			ficheiroUtilizadores.fechaLeitura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ficheiro de compras
		String pathCompras = "C:\\Users\\Tiago\\Desktop\\ProjetoIPJ\\Livraria\\Compras";
		FicheiroDeObjectos ficheiroCompras = new FicheiroDeObjectos();
		try {
			ficheiroCompras.abreLeitura(pathCompras);
			compras = (ArrayList<Compra>) ficheiroCompras.leObjecto();
			ficheiroCompras.fechaLeitura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void saveAll() {
		//Ficheiro de livros
		String pathLivros = "C:\\Users\\Tiago\\Desktop\\ProjetoIPJ\\Livraria\\Livros";
		FicheiroDeObjectos ficheiroLivros = new FicheiroDeObjectos();
		try {
			ficheiroLivros.abreEscrita(pathLivros);
			ficheiroLivros.escreveObjecto(this.livros);
			ficheiroLivros.fechaEscrita();
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ficheiro de utilizadores
		String pathUtilizadores = "C:\\Users\\Tiago\\Desktop\\ProjetoIPJ\\Livraria\\Utilizadores";
		FicheiroDeObjectos ficheiroUtilizadores = new FicheiroDeObjectos();
		try {
			ficheiroUtilizadores.abreEscrita(pathUtilizadores);
			ficheiroUtilizadores.escreveObjecto(this.utilizadores);
			ficheiroUtilizadores.fechaEscrita();
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ficheiro de compras
		String pathCompras = "C:\\Users\\Tiago\\Desktop\\ProjetoIPJ\\Livraria\\Compras";
		FicheiroDeObjectos ficheiroCompras = new FicheiroDeObjectos();
		try {
			ficheiroCompras.abreEscrita(pathCompras);
			ficheiroCompras.escreveObjecto(this.compras);
			ficheiroCompras.fechaEscrita();
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


}
