
package org.eclipse.wb.swt;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Classe
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
@SuppressWarnings("serial")
public class Livraria implements Serializable {
	/**
	 * Atributos da classe
	 */
	private ArrayList<Livro> livros;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Compra> compras;

	/**
	 * Construtor da classe 'Livraria' que corre a leitura dos ficheiros de objetos que formam a livraria
	 */
	Livraria() throws ClassNotFoundException {
		loadAll();
	}

	/**
	 * m�todo que recebe uma string e procura na lista de livros, todos os livros
	 * que t�m essa String quer seja no nome, autor, editora ou ISBN
	 * @param string s, a procurar
	 * @return devolve arrayList de livros que correspondem � string
	 */
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

	/**
	 * M�todo toString para impress�o dos livros na livraria
	 * @return String com informa��es de todos os livros da livraria
	 */
	public String toString() {
		String s = "";
		for (Livro lv : livros) {
			s = s + "-----------------------------------\n" + lv + "\n" + "Stock: " + lv.stock + "\n";
		}
		return s;
	}

	/**
	 * M�todo para obter livro a partir do seu ISBN
	 * @param string com o ISBN a comparar
	 * @return Livro que corresponde � string introduzida, ou livro 'vazio', caso n�o haja correspond�ncia
	 */
	public Livro getLivro(String isbn) {
		for (Livro lv : livros) {
			if (lv.isbn.equals(isbn)) {
				return lv;
			}
		}
		return new Livro();
	}

	/**
	 * m�todo que recebe um numero de compra e procura a compra na lista de compras
	 * @param inteiro com o n�mero da compra
	 * @return devolve compra que corresponde, ou compra 'vazia', caso n�o haja correspond�ncia
	 */
	public Compra getCompra(int num) {
		for (Compra c : compras) {
			if (c.numCompra == num) {
				return c;
			}
		}
		// apenas porque tem de ser devolvido algum livro no fim. Mas esta parte nunca
		// ser� usada
		return new Compra();
	}	

	/**
	 * M�todo para verificar se um login � v�lido
	 * @param email de login
	 * @param password de login
	 * @return string de resposta a dizer se login e password corresponderem a um utilizador registado
	 */
	public String verificarLogin(String email, String password) {
		for (Utilizador u : utilizadores) {
			if (u.email.equals(email) && u.senha.equals(password)) {
				return "ok";
			} else if (u.email.equals(email) && !u.senha.equals(password)) {
				return "passwordErrada";
			}
		}
		// caso n�o se verifique nenhuma das anteriores � porque o email � errado
		return "emailErrado";
	}

	/**
	 * M�todo para verificar se uma string � um n�mero de NIF ou de cart�o v�lido
	 * @param s, string com o n�mero
	 * @return true se for compat�vel e false se n�o
	 */
	public boolean verificarSeNIFouCartao(String s) {
		// ver se tem algum carater que n�o seja numero
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

	/**
	 * M�todo para verificar se um PIN � v�lido
	 * @param s, string com o pin
	 * @return true se for pin e false se n�o
	 */
	public boolean verificarSePIN(String s) {
		// ver se tem algum carater que n�o seja numero
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

	/**
	 * M�todo para obter um utilizador a partir do seu email
	 * @param email do utilizador
	 * @return devolve o utilizador correspondente
	 */
	public Utilizador getUtilizadorPorEmail(String email) {
		for (Utilizador u : utilizadores) {
			if (u.email.equals(email)) {
				return u;
			}
		}
		// caso por defeito que nunca ser� usado
		return new Utilizador();
	}

	public void aumentarStock(Livro lv, int quantidade) {
		lv.setStock(lv.getStock() + quantidade);
	}

	public void reduzirStock(Livro lv, int quantidade) {
		lv.setStock(lv.getStock() - quantidade);
		saveAll();
	}

	/**
	 * M�todo para adicionar um livro ao carrinho
	 * @param carrinho de onde se quer adicionar o livro
	 * @param lv, livro que se quer adicionar
	 * @return devolve o carrinho com o livro que se adicionou
	 */
	public Carrinho adicionarLivroAoCarrinho(Livro lv, Carrinho carrinho) {
		// Se livro n�o tem stock, n�o fazer nada
		if (lv.stock <= 0) {
		}
		// Se livro j� existe na lista, aumentar a quantidade
		else if (carrinho.livros.contains(lv)) {
			int indice = carrinho.livros.indexOf(lv);
			int quantidade = carrinho.quantidades.get(indice);
			carrinho.quantidades.set(indice, quantidade + 1);
			reduzirStock(lv, 1);
		}
		// se livro n�o existia, acrescenta-se livro a 'livros' e quantidade a
		// 'quantidades'
		else {
			carrinho.livros.add(lv);
			carrinho.quantidades.add(1);
			reduzirStock(lv, 1);
		}
		saveAll();
		return carrinho;
	}

	/**
	 * M�todo para remover um livro do carrinho
	 * @param carrinho de onde se quer remover o livro
	 * @param lv, livro que se quer remover
	 * @return devolve o carrinho sem o livro que se removeu
	 */
	public Carrinho removerLivroDoCarrinho(Livro lv, Carrinho carrinho) {
		int indice = carrinho.livros.indexOf(lv);
		int quantidade = carrinho.quantidades.get(indice);
		// se livro n�o vem na lista do carrinho, n�o fazer nada
		if (!carrinho.livros.contains(lv)) {
		}
		// Se s� havia um exemplar, remover o livro
		else if (quantidade == 1) {
			carrinho.livros.remove(indice);
			carrinho.quantidades.remove(indice);
			aumentarStock(lv, 1);
		}
		// se h� mais do que um exemplar, reduzir quantidade
		else {
			carrinho.quantidades.set(indice, quantidade - 1);
			aumentarStock(lv, 1);
		}
		saveAll();
		return carrinho;
	}

	/**
	 * M�todo para esvaziar carrinho, sem repor os stocks na livraria
	 * @param carrinho que se quer esvaziar
	 * @return devolve um carrinho vazio
	 */
	public Carrinho esvaziarCarrinhoSemReporStock(Carrinho carrinho) {
		// limpar carrinho
		carrinho.livros.clear();
		carrinho.quantidades.clear();
		saveAll();
		return carrinho;
	}
	
	/**
	 * M�todo para esvaziar carrinho, repondo os stocks na livraria
	 * @param carrinho que se quer esvaziar
	 * @return devolve um carrinho vazio
	 */
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
	
	/**
	 * M�todo para esvaziar uma compra, repondo os items da compra na livraria
	 * @param compra que se quer esvaziar/anular
	 */
	public void esvaziarCompraReporStock(Compra c) {
		for (int i = 0; i < c.carrinho.livros.size(); i++) {
			String isbn = c.carrinho.livros.get(i).isbn;
			int quantidade = c.carrinho.quantidades.get(i);
			Livro lv = getLivro(isbn);
			// repor o stock
			lv.setStock( lv.getStock() + quantidade); 
		}
		saveAll();
	}	

	/**
	 * M�todo que devolve um novo n�mero de compra a seguir ao n�mero de compra
	 * existente maior
	 * @return n�mero inteiro para uma nova compra
	 */
	public int gerarNovoNumCompra() {
		int novoNum = 0;
		for (Compra c : compras) {
			if (c.numCompra >= novoNum) {
				novoNum = c.numCompra + 1;
			}
		}
		return novoNum;
	}

	/**
	 * M�todo que devolve um novo n�mero de vendedor a seguir ao n�mero de vendedor
	 * existente maior
	 * @return n�mero inteiro para um novo vendedor
	 */
	public int gerarNovoNumUtilizador() {
		int novoNum = 0;
		for (Utilizador u : utilizadores) {
			if (u.uID >= novoNum) {
				novoNum = u.uID + 1;
			}
		}
		return novoNum;
	}
	
	/**
	 * M�todo ler e carregar ficheiros de objetos da livraria
	 */
	@SuppressWarnings("unchecked")
	public void loadAll() throws ClassNotFoundException {
		//Ficheiro de livros
		String pathLivros = "Livros.ser";
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
		String pathUtilizadores = "Utilizadores.ser";
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
		String pathCompras = "Compras.ser";
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

	/**
	 * M�todo gravar ficheiros de objetos da livraria
	 */
	public void saveAll() {
		//Ficheiro de livros
		String pathLivros = "Livros.ser";
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
		String pathUtilizadores = "Utilizadores.ser";
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
		String pathCompras = "Compras.ser";
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

	/**
	 * 
	 * 
	 * Getters e Setters para os atributos de 'Livraria'
	 * 
	 * 
	 */
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
	
	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
}
