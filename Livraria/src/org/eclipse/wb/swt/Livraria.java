
package org.eclipse.wb.swt;
import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.wb.swt.Utilizador.Tipo;


public class Livraria {
	protected List <Livro> livros;
	protected List <Utilizador> utilizadores;
	protected List <Compra> compras;
	
	
	//Construtor que cria alguns livros, utilizadores e compras pr� definidos
	Livraria(){
		/**+++++++++++++++++++++++
		 * S� para efeito de testes, define-se agora uma livraria
		 * !!!!!!!!!!!!!!!!!!!!!!!
		 * APAGAR MAIS TARDE O RESTO DESTE CONSTRUTOR
		 * 1
		 * 1
		 * 1
		 * 
		 */
		//criar 3 pequenos historicos de pre�os
		Map <GregorianCalendar, Double > precos1 = new HashMap<>();
		precos1.put(new GregorianCalendar(2017,2,5), 15.0);
		precos1.put(new GregorianCalendar(2016,6,14), 13.0);
		precos1.put(new GregorianCalendar(2016,11,14), 14.0);
		Map <GregorianCalendar, Double > precos2 = new HashMap<>();
		precos2.put(new GregorianCalendar(2017,2,5), 15.0);
		precos2.put(new GregorianCalendar(2016,6,14), 13.0);
		precos2.put(new GregorianCalendar(2016,11,14), 14.0);
		Map <GregorianCalendar, Double > precos3 = new HashMap<>();
		precos3.put(new GregorianCalendar(2017,2,5), 23.0);
		precos3.put(new GregorianCalendar(2017,5,14), 25.0);
		precos3.put(new GregorianCalendar(2018,10,2), 25.8);
		//criar 3 livros
		Livro lv1 = new Livro ("O �ltimo voo do Flamingo", "1548967532745", "Mia Couto", "Pl�tano", 
				"Romance. Um estranho encontro", new GregorianCalendar (2018,11,12) , 15.5, 20, precos1);
		Livro lv2 = new Livro ("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya", 
				"Fic��o Cient�fica. Viagens espaciais de um inadaptado", 
				new GregorianCalendar (2017,11,18) , 16.5, 3, precos2);
		Livro lv3 = new Livro ("Nove Amanh�s", "1549657432745", "Isak Asimov", "N�bula", 
				"Fic��o Cient�fica. Nove pequenos contos futur�sticos", 
				new GregorianCalendar (2018,11,12) , 15.5, 20, precos3);
		Livro lv4 = new Livro ("Um homem estranho numa terra estranha", "9635874432745", "Ursula K Leguin", "N�bula", 
				"Fic��o Cient�fica. Um extra-terrestre chega � terra", 
				new GregorianCalendar (2017,11,12) , 11, 0, precos1);
		// adicionar livros � lista de livros
		livros = new ArrayList<>();
		livros.add(lv1);
		livros.add(lv2);
		livros.add(lv3);
		livros.add(lv4);
		//Criar alguns utilizadores
		Utilizador u1 = new Utilizador( "Ant�nio Cunha", "tocunha@gmail.com", "tocunha2000", Utilizador.Tipo.ADMIN);
		Utilizador u2 = new Utilizador( "Tiago Correia", "admin", "admin", Utilizador.Tipo.ADMIN);
		Utilizador u3 = new Utilizador( "M�rcia Campos", "mcampos.a@gmail.com", "heyd6wx", Utilizador.Tipo.VENDEDOR);
		Utilizador u4 = new Utilizador( "Beatriz Costa", "vende", "vende", Utilizador.Tipo.VENDEDOR);
		//adicionar utilizadores � lista de utilizadores
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
		//Criar algumas compras finalizadas e adicionar � lista de compras
		compras = new ArrayList<>();
		compras.add( new Compra( 1, c1, 156987569, new GregorianCalendar (2018,11,14), Compra.Estado.FINALIZADA));
		compras.add( new Compra( 1, c2, 235648978, new GregorianCalendar (2018,11,15), Compra.Estado.FINALIZADA));
		compras.add( new Compra( 1, c3, 225498631, new GregorianCalendar (2018,11,13), Compra.Estado.FINALIZADA));
	}
	
	public void testar() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("introduza livro a pesquisar");
		String s = sc.nextLine();
		List <Livro> livrosProcurados = procurarLivro(s);
		for ( Livro lv : livrosProcurados ) {
			System.out.println(lv);
		}
		sc.close();
	}
	
	//m�todo que recebe uma string e procura na lista de livros, todos os livros que t�m essa String 
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
	
	
	
	//M�todo para obter Livro a partir do seu isbn
	public Livro getLivro(String isbn) {
		for ( Livro lv : livros) {
			if ( lv.isbn.equals(isbn) ) {
				return lv;
			}
		}
		return new Livro();
	}

	//m�todo que recebe password e email de login e devolve string com ok ou eventual erro
	public String verificarLogin( String email, String password){
		for ( Utilizador u : utilizadores ) {
			if ( u.email.equals(email) && u.senha.equals(password) && u.tipo==Tipo.ADMIN) {
				return "okAdmin";
			}
			else if ( u.email.equals(email) && u.senha.equals(password) && u.tipo==Tipo.VENDEDOR) {
				return "okVendedor";
			}
			else if ( u.email.equals(email) && !u.senha.equals(password)) {
				return "passwordErrada";
			}
		}
		//caso n�o se verifique nenhuma das anteriores � porque o email � errado
		return "emailErrado";
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
