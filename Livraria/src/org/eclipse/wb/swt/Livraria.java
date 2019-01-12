
package org.eclipse.wb.swt;
import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.wb.swt.Utilizador.Tipo;


public class Livraria {
	private ArrayList <Livro> livros;
	private ArrayList <Utilizador> utilizadores;
	private ArrayList <Compra> compras;
	
	
	public ArrayList <Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList <Livro> livros) {
		this.livros = livros;
	}

	//Construtor que cria alguns livros, utilizadores e compras pré definidos
	Livraria(){
		
		/**+++++++++++++++++++++++
		 * Só para efeito de testes, define-se agora uma livraria
		 * !!!!!!!!!!!!!!!!!!!!!!!
		 * APAGAR MAIS TARDE O RESTO DESTE CONSTRUTOR
		 * 1
		 * 1
		 * 1
		 * 
		 */
		//criar 3 pequenos historicos de preços
		HashMap <GregorianCalendar, Double > precos1 = new HashMap<>();
		precos1.put(new GregorianCalendar(2017,2,5), 15.5);
		precos1.put(new GregorianCalendar(2016,6,14), 13.0);
		precos1.put(new GregorianCalendar(2016,11,14), 14.0);
		HashMap <GregorianCalendar, Double > precos2 = new HashMap<>();
		precos2.put(new GregorianCalendar(2017,2,5), 16.5);
		precos2.put(new GregorianCalendar(2016,6,14), 13.0);
		precos2.put(new GregorianCalendar(2016,11,14), 14.0);
		HashMap <GregorianCalendar, Double > precos3 = new HashMap<>();
		precos3.put(new GregorianCalendar(2017,2,5), 23.0);
		precos3.put(new GregorianCalendar(2017,5,14), 25.0);
		precos3.put(new GregorianCalendar(2018,10,2), 25.8);
		//criar 3 livros
		Livro lv1 = new Livro ("O último voo do Flamingo", "1548967532745", "Mia Couto", "Plátano", 
				"Romance. Um estranho encontro", new GregorianCalendar (2018,11,12) , 15.5, 20, precos1);
		Livro lv2 = new Livro ("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya", 
				"Ficção Científica. Viagens espaciais de um inadaptado", 
				new GregorianCalendar (2017,11,18) , 16.5, 3, precos2);
		Livro lv3 = new Livro ("Nove Amanhãs", "1549657432745", "Isak Asimov", "Nébula", 
				"Ficção Científica. Nove pequenos contos futurísticos", 
				new GregorianCalendar (2018,11,12) , 25.8, 20, precos3);
		Livro lv4 = new Livro ("Um homem estranho numa terra estranha", "9635874432745", "Ursula K Leguin", "Nébula", 
				"Ficção Científica. Um extra-terrestre chega à terra", 
				new GregorianCalendar (2017,11,12) , 15.5, 0, precos1);
		// adicionar livros à lista de livros
		livros = new ArrayList<>();
		livros.add(lv1);
		livros.add(lv2);
		livros.add(lv3);
		livros.add(lv4);
		//Criar alguns utilizadores
		Utilizador u1 = new Utilizador( 1,"António Cunha", "tocunha@gmail.com", "tocunha2000", Utilizador.Tipo.ADMIN);
		Utilizador u2 = new Utilizador( 2,"Tiago Correia", "a", "a", Utilizador.Tipo.ADMIN);
		Utilizador u3 = new Utilizador( 3,"Márcia Campos", "mcampos.a@gmail.com", "heyd6wx", Utilizador.Tipo.VENDEDOR);
		Utilizador u4 = new Utilizador( 4,"Beatriz Costa", "v", "v", Utilizador.Tipo.VENDEDOR);
		//adicionar utilizadores à lista de utilizadores
		utilizadores = new ArrayList<>();
		utilizadores.add( u1 );
		utilizadores.add( u2 );
		utilizadores.add( u3 );
		utilizadores.add( u4 );
		//Criar alguns mapas de livros-quantidade para os carrinhos de compras 
//		Map <Livro, Integer> livros1 = new HashMap <>();
//		livros1.put(lv1, 2);
//		livros1.put(lv2, 1);
//		Map <Livro, Integer> livros2 = new HashMap <>();
//		livros2.put(lv2, 1);
//		livros2.put(lv3, 3);
//		Map <Livro, Integer> livros3 = new HashMap <>();
//		livros3.put(lv2, 1);
		//Criar alguns mapas de livros-quantidade para os carrinhos de compras 
		ArrayList <Livro> livros1 = new ArrayList <>();
		livros1.add(lv1);
		livros1.add(lv1);
		livros1.add(lv2);
		ArrayList <Livro> livros2 = new ArrayList <>();
		livros2.add(lv2);
		livros2.add(lv3);
		livros2.add(lv3);
		livros2.add(lv3);
		ArrayList <Livro> livros3 = new ArrayList <>();
		livros3.add(lv2);		
		//criar alguns carrinhos
		Carrinho c1 = new Carrinho(livros1);
		Carrinho c2 = new Carrinho(livros2);
		Carrinho c3 = new Carrinho(livros3);
		//Criar algumas compras finalizadas e adicionar à lista de compras
		setCompras(new ArrayList<>());
		compras = new ArrayList<Compra>();
		compras.add( new Compra( 1, c1, "156987569", new GregorianCalendar (2018,11,14), Compra.Estado.PAGA));
		compras.add( new Compra( 2, c2, "235648978", new GregorianCalendar (2018,11,15), Compra.Estado.ANULADA));
		compras.add( new CompraCartao( 3, c3, "225498631", new GregorianCalendar (2018,11,13), Compra.Estado.SUBMETIDA, "637482987", "435"));
	}
	
	public void testar() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("introduza livro a pesquisar");
		String s = sc.nextLine();
		ArrayList <Livro> livrosProcurados = procurarLivro(s);
		for ( Livro lv : livrosProcurados ) {
			System.out.println(lv);
		}
		sc.close();
	}
	
//	//Método para ordenar as várias arrayLists segundo vários critérios
//	public void ordenarCompras(String criterio) {
//		//if (criterio == )
//	}
	
	
	//método que recebe uma string e procura na lista de livros, todos os livros que têm essa String 
	// quer seja no nome, autor, editora ou ISBN
	public ArrayList <Livro> procurarLivro( String s){
		ArrayList <Livro> livrosProcurados = new ArrayList<>();
		
		System.out.println(s);
		
		for ( Livro lv : livros) {
			if ( lv.autor.toUpperCase().contains(s.toUpperCase()) ) {
				livrosProcurados.add(lv);
			}
			else if ( lv.nome.toUpperCase().contains(s.toUpperCase()) ) {
				livrosProcurados.add(lv);
			}
			else if ( lv.editora.toUpperCase().contains(s.toUpperCase()) ) {
				livrosProcurados.add(lv);
			}
			else if ( lv.isbn.toUpperCase().contains(s.toUpperCase()) ) {
				livrosProcurados.add(lv);
			}
		}
		return livrosProcurados;
	}
	
	//método que recebe um numero de compra e procura a compra na lista de compras
	public Compra getCompra(int num) {
		for ( Compra c : compras) {
			if ( c.numCompra == num ) {
				return c;
			}
		}
		//apenas porque tem de ser devolvido algum livro no fim. Mas esta parte nunca será usada
		return new Compra();
	}
	
	public String toString() {
		String s = "";
		for ( Livro lv : livros) {
			s = s + "-----------------------------------\n" + 
					lv + "\n" + 
					"Stock: " + lv.stock + "\n";	
		}
		return s;
	}
	
	//Método para obter Livro a partir do seu isbn
	public Livro getLivro(String isbn) {
		for ( Livro lv : livros) {
			if ( lv.isbn.equals(isbn) ) {
				return lv;
			}
		}
		//apenas porque tem de ser devolvido algum livro no fim. Mas esta parte nunca será usada
		return new Livro();
	}

	//método que recebe password e email de login e devolve string com ok ou eventual erro
	public String verificarLogin( String email, String password){
		for ( Utilizador u : utilizadores ) {
			if ( u.email.equals(email) && u.senha.equals(password) ) {
				return "ok";
			}
			else if ( u.email.equals(email) && !u.senha.equals(password)) {
				return "passwordErrada";
			}
		}
		//caso não se verifique nenhuma das anteriores é porque o email é errado
		return "emailErrado";
	}
	
	//método que atravez do email de login devolve o utilizador
	public Utilizador getUtilizadorPorEmail( String email){
		for ( Utilizador u : utilizadores ) {
			if ( u.email.equals(email) ) {
				return u;
			}
		}
		//caso por defeito que nunca será usado
		return new Utilizador();
	}	
	
//	
//	REVER BEM ESTES DOIS MÉTODOS SEGUINTES
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
		lv.setStock( lv.getStock() + quantidade );
	}
	
	public void reduzirStock(Livro lv, int quantidade) {
		lv.setStock( lv.getStock() - quantidade );
	}
	
	//Método para adicionar um novo (ou repetido) livro ao carrinho
	public Carrinho adicionarLivroAoCarrinho (Livro lv, Carrinho carrinho) {
		//Se livro não tem stock, não fazer nada
		if ( lv.stock <= 0 ) {		
		}
		//Se livro já existe na lista, aumentar a quantidade
		else if ( carrinho.livros.contains(lv)) {
			int indice = carrinho.livros.indexOf(lv);
			int quantidade = carrinho.quantidades.get(indice);
			carrinho.quantidades.set(indice, quantidade+1);
			reduzirStock( lv, 1 );
		}
		//se livro não existia, acrescenta-se livro a 'livros' e quantidade a 'quantidades'
		else {
			carrinho.livros.add(lv);
			carrinho.quantidades.add(1);
			reduzirStock(lv,1);
		}
		return carrinho;
	}
	
	//Método para remover um livro do carrinho
	public Carrinho removerLivroDoCarrinho (Livro lv, Carrinho carrinho) {
		int indice = carrinho.livros.indexOf(lv);
		int quantidade = carrinho.quantidades.get(indice);
		//se livro não vem na lista do carrinho, não fazer nada
		if ( !carrinho.livros.contains(lv) ) {
		}
		//Se só havia um exemplar, remover o livro
		else if ( quantidade == 1 ) {
			carrinho.livros.remove(indice);
			carrinho.quantidades.remove(indice);
			aumentarStock(lv,1);
		}
		//se há mais do que um exemplar, reduzir quantidade
		else {
			carrinho.quantidades.set(indice, quantidade-1);
			aumentarStock(lv,1);
		}
		return carrinho;
	}	
	
	//Método para esvaziar carrinho, repondo os stocks na livraria
	public Carrinho esvaziarCarrinhoReporStock (Carrinho carrinho) {
		for ( int i = 0; i < carrinho.livros.size(); i++ ) {
			String isbn = carrinho.livros.get(i).isbn;
			int quantidade = carrinho.quantidades.get(i);
			Livro lv = getLivro(isbn);
			//repor o stock
			lv.stock = lv.stock + quantidade;
		}
		//limpar carrinho
		carrinho.livros.clear();
		carrinho.quantidades.clear();
		return carrinho;
	}	
	
	//Método para esvaziar carrinho, repondo os stocks na livraria
	public Carrinho esvaziarCarrinhoSemReporStock (Carrinho carrinho) {
		//limpar carrinho
		carrinho.livros.clear();
		carrinho.quantidades.clear();
		return carrinho;
	}	
	
	//Método que devolve um novo número de compra (a seguir ao número de compra existente maior)
	public int gerarNovoNumCompra() {
		int novoNum = 0;
		for ( Compra c : compras) {
			if ( c.numCompra >= novoNum) {
				novoNum = c.numCompra + 1;
			}
		}
		return novoNum;
	}
	
	//Método que devolve um novo número de vendedor (a seguir ao número de vendedor existente maior)
	public int gerarNovoNumUtilizador() {
		int novoNum = 0;
		for ( Utilizador u : utilizadores) {
			if ( u.uID >= novoNum) {
				novoNum = u.uID + 1;
			}
		}
		return novoNum;
	}	

	public ArrayList <Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList <Compra> compras) {
		this.compras = compras;
	}

	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}
	
	

		
	
	
	
//	//método para transformar lista de livros em hashMap e depois em carrinho
//	public Carrinho listaToCarrinho ( ArrayList <Livro> listaLivrosCarrinho ) {
//		HashMap <Livro, Integer> novoCarrinho = new HashMap<>();
//		int i = 0;
//		int quantidade = 1;
//		for ( Livro lv : listaLivrosCarrinho) {
//			//Se livro já existe no HashMap => aumenta-se quantidade
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
