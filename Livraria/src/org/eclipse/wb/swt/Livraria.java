
package org.eclipse.wb.swt;

import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
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
public class Livraria {
	private ArrayList<Livro> livros;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Compra> compras;

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	// Construtor que cria alguns livros, utilizadores e compras pr� definidos
	Livraria() {

		/**
		 * +++++++++++++++++++++++ S� para efeito de testes, define-se agora uma
		 * livraria !!!!!!!!!!!!!!!!!!!!!!! APAGAR MAIS TARDE O RESTO DESTE CONSTRUTOR 1
		 * 1 1
		 * 
		 */
		// criar 3 pequenos historicos de pre�os
		HashMap<GregorianCalendar, Double> precos1 = new HashMap<>();
		precos1.put(new GregorianCalendar(2017, 2, 5), 15.5);
		precos1.put(new GregorianCalendar(2016, 6, 14), 13.0);
		precos1.put(new GregorianCalendar(2016, 11, 14), 14.0);
		HashMap<GregorianCalendar, Double> precos2 = new HashMap<>();
		precos2.put(new GregorianCalendar(2017, 2, 5), 16.5);
		precos2.put(new GregorianCalendar(2016, 6, 14), 13.0);
		precos2.put(new GregorianCalendar(2016, 11, 14), 14.0);
		HashMap<GregorianCalendar, Double> precos3 = new HashMap<>();
		precos3.put(new GregorianCalendar(2017, 2, 5), 23.0);
		precos3.put(new GregorianCalendar(2017, 5, 14), 25.0);
		precos3.put(new GregorianCalendar(2018, 10, 2), 25.8);
		// criar 3 livros
		Livro lv2 = new Livro("Alto voo do Flamingo", "1548967532745", "Mia Couto", "Pl�tano",
				"Romance. Um estranho encontro", new GregorianCalendar(2018, 11, 12), 15.5, 20, precos1);
		Livro lv1 = new Livro("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya",
				"Fic��o Cient�fica. Viagens espaciais de um inadaptado", new GregorianCalendar(2017, 11, 18), 16.5, 3,
				precos2);
		Livro lv3 = new Livro("Nove Amanh�s", "1549657432745", "Isak Asimov", "N�bula",
				"Fic��o Cient�fica. Nove pequenos contos futur�sticos", new GregorianCalendar(2018, 11, 12), 25.8, 20,
				precos3);
		Livro lv4 = new Livro("Um homem estranho numa terra estranha", "9635874432745", "Ursula K Leguin", "N�bula",
				"Fic��o Cient�fica. Um extra-terrestre chega � terra", new GregorianCalendar(2017, 11, 12), 15.5, 0,
				precos1);
		// adicionar livros � lista de livros
		livros = new ArrayList<>();
		livros.add(lv1);
		livros.add(lv2);
		livros.add(lv3);
		livros.add(lv4);
		// Criar alguns utilizadores
		Utilizador u1 = new Utilizador(1, "Ant�nio Cunha", "tocunha@gmail.com", "tocunha2000", Utilizador.Tipo.ADMIN);
		Utilizador u2 = new Utilizador(2, "Tiago Correia", "a", "a", Utilizador.Tipo.ADMIN);
		Utilizador u3 = new Utilizador(3, "M�rcia Campos", "mcampos.a@gmail.com", "heyd6wx", Utilizador.Tipo.VENDEDOR);
		Utilizador u4 = new Utilizador(4, "Alberto Machado", "v", "v", Utilizador.Tipo.VENDEDOR);
		// adicionar utilizadores � lista de utilizadores
		utilizadores = new ArrayList<>();
		utilizadores.add(u1);
		utilizadores.add(u2);
		utilizadores.add(u3);
		utilizadores.add(u4);
		// Criar alguns mapas de livros-quantidade para os carrinhos de compras
//		Map <Livro, Integer> livros1 = new HashMap <>();
//		livros1.put(lv1, 2);
//		livros1.put(lv2, 1);
//		Map <Livro, Integer> livros2 = new HashMap <>();
//		livros2.put(lv2, 1);
//		livros2.put(lv3, 3);
//		Map <Livro, Integer> livros3 = new HashMap <>();
//		livros3.put(lv2, 1);
		// Criar alguns mapas de livros-quantidade para os carrinhos de compras
		ArrayList<Livro> livros1 = new ArrayList<>();
		livros1.add(lv1);
		livros1.add(lv1);
		livros1.add(lv2);
		ArrayList<Livro> livros2 = new ArrayList<>();
		livros2.add(lv2);
		livros2.add(lv3);
		livros2.add(lv3);
		livros2.add(lv3);
		ArrayList<Livro> livros3 = new ArrayList<>();
		livros3.add(lv2);
		// criar alguns carrinhos
		Carrinho c1 = new Carrinho(livros1);
		Carrinho c2 = new Carrinho(livros2);
		Carrinho c3 = new Carrinho(livros3);
		// Criar algumas compras finalizadas e adicionar � lista de compras
		setCompras(new ArrayList<>());
		compras = new ArrayList<Compra>();
		compras.add(new Compra(1, c1, "156987569", new GregorianCalendar(2018, 11, 14), Compra.Estado.PAGA));
		compras.add(new Compra(2, c2, "235648978", new GregorianCalendar(2018, 11, 15), Compra.Estado.ANULADA));
		compras.add(new CompraCartao(3, c3, "225498631", new GregorianCalendar(2018, 11, 13), Compra.Estado.SUBMETIDA,
				"637482987", "435"));
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

//	//M�todo para ordenar as v�rias arrayLists segundo v�rios crit�rios
//	public void ordenarCompras(String criterio) {
//		//if (criterio == )
//	}

	// m�todo que recebe uma string e procura na lista de livros, todos os livros
	// que t�m essa String
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

	// m�todo que recebe um numero de compra e procura a compra na lista de compras
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

	public String toString() {
		String s = "";
		for (Livro lv : livros) {
			s = s + "-----------------------------------\n" + lv + "\n" + "Stock: " + lv.stock + "\n";
		}
		return s;
	}

	// M�todo para obter Livro a partir do seu isbn
	public Livro getLivro(String isbn) {
		for (Livro lv : livros) {
			if (lv.isbn.equals(isbn)) {
				return lv;
			}
		}
		// apenas porque tem de ser devolvido algum livro no fim. Mas esta parte nunca
		// ser� usada
		return new Livro();
	}

	// m�todo que recebe password e email de login e devolve string com ok ou
	// eventual erro
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

	// m�todo que atravez do email de login devolve o utilizador
	public Utilizador getUtilizadorPorEmail(String email) {
		for (Utilizador u : utilizadores) {
			if (u.email.equals(email)) {
				return u;
			}
		}
		// caso por defeito que nunca ser� usado
		return new Utilizador();
	}

//	//m�todo para ordenar lista de livros por t�tulo
//	public ArrayList <Livro> ordenarLivroTitulo( ArrayList <Livro> lvs){
//		Collections.sort(lvs, Comparator.comparing(Livro::getNome));
////		for (int i = 0 ; i < lvs.size()-1; i++) {
////			for(int j = i+1; j < lvs.size(); j++){
////				if (lvs.get(i).getNome().compareToIgnoreCase(lvs.get(j).getNome()) >= 0) {
////					Livro lvAux = new Livro();
////					
////				}
////		   }
////		}
//		
//		
//		
//		
////		Collections.sort(lvs, Livro.ordenarPorTitulo);
//		   for(Livro lv: lvs){
//				System.out.println(lv);
//		   }
//		return lvs;
//	}	
//	
//	//m�todo para ordenar lista de livros por t�tulo
//	public ArrayList <Livro> ordenarLivroAutor( ArrayList <Livro> lvs){
//		Collections.sort(lvs, Comparator.comparing(Livro::getNome));
//		//Collections.sort(lvs, Livro.ordenarPorAutor);
//		   for(Livro lv: lvs){
//				System.out.println(lv);
//		   }
//		return lvs;
//		
//	}	

//	listaLivrosDaBusca.sort(null);
//	Collections.sort(listaLivrosDaBusca, Comparator.comparingDouble(Livro::getPreco));
//	
//	Collections.sort(listaLivrosDaBusca, new Comparator<Livro>(){
//	     public int compare(Livro l1, Livro l2){
//	         if(l1.preco == l2.preco)
//	             return 0;
//	         return l1.preco < l2.preco ? -1 : 1;
//	     }
//	});

//	
//	REVER BEM ESTES DOIS M�TODOS SEGUINTES
//	
//	
//	
//	
//	
//	public void aumentarStock(Livro lv, int quantidade) {
//		lv.setStock( lv.getStock() + quantidade );
//	}
//	
//	public void reduzirStock(Livro lv, int quantidade) {
//		lv.setStock( lv.getStock() - quantidade );
//	}

	public void aumentarStock(Livro lv, int quantidade) {
		lv.setStock(lv.getStock() + quantidade);
	}

	public void reduzirStock(Livro lv, int quantidade) {
		lv.setStock(lv.getStock() - quantidade);
	}

	// M�todo para adicionar um novo (ou repetido) livro ao carrinho
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
		return carrinho;
	}

	// M�todo para remover um livro do carrinho
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
		return carrinho;
	}

	// M�todo para esvaziar carrinho, repondo os stocks na livraria
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
		return carrinho;
	}

	// M�todo para esvaziar carrinho, repondo os stocks na livraria
	public Carrinho esvaziarCarrinhoSemReporStock(Carrinho carrinho) {
		// limpar carrinho
		carrinho.livros.clear();
		carrinho.quantidades.clear();
		return carrinho;
	}

	// M�todo que devolve um novo n�mero de compra (a seguir ao n�mero de compra
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

	// M�todo que devolve um novo n�mero de vendedor (a seguir ao n�mero de vendedor
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
		String pathLivros = "\\Livros";
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
		String pathUtilizadores = "\\Utilizadores";
		FicheiroDeObjectos ficheiroUtilizadores = new FicheiroDeObjectos();
		try {
			ficheiroUtilizadores.abreLeitura(pathUtilizadores);
			utilizadores = (ArrayList<Utilizador>) ficheiroUtilizadores.leObjecto();
			ficheiroUtilizadores.fechaLeitura();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ficheiro de utilizadores
		String pathCompras = "\\Utilizadores";
		FicheiroDeObjectos ficheiroCompras = new FicheiroDeObjectos();
		try {
			ficheiroUtilizadores.abreLeitura(pathCompras);
			utilizadores = (ArrayList<Utilizador>) ficheiroUtilizadores.leObjecto();
			ficheiroUtilizadores.fechaLeitura();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	public void saveAll() {

//		private Map<String, Utilizador> mapUtilizadores; // String Username

//		private ArrayList<Conta> lContas;

//		private Map<Integer, Integer> mapCartaoConta; // numcartaonumconta
//		private Map<String, Integer> contadores;

//		this.uactual = uactual;
		String pathMapUtilizadores = "\\MapUtilizadores";
		FicheiroDeObjectos ut = new FicheiroDeObjectos();
		try {
			ut.abreEscrita(pathMapUtilizadores);
			ut.escreveObjecto(this.mapUtilizadores);
			ut.fechaEscrita();
			;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	//m�todo para transformar lista de livros em hashMap e depois em carrinho
//	public Carrinho listaToCarrinho ( ArrayList <Livro> listaLivrosCarrinho ) {
//		HashMap <Livro, Integer> novoCarrinho = new HashMap<>();
//		int i = 0;
//		int quantidade = 1;
//		for ( Livro lv : listaLivrosCarrinho) {
//			//Se livro j� existe no HashMap => aumenta-se quantidade
//			if ( novoCarrinho.containsKey(lv)) {
//				quantidade = novoCarrinho.get(lv)+1;
//			}
//			//acrrescentar livros ao HashMap
//			novoCarrinho.put( lv , quantidade);	
//		}
//		Carrinho cr = new Carrinho(novoCarrinho);
//		return cr;
//	}

}
