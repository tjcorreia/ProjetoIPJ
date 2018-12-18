package org.eclipse.wb.swt;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Livraria {
	protected List <Livro> livros;
	protected List <Utilizador> utilizadores;
	protected List <Compra> compras;
	
	//Construtor que cria alguns livros, utilizadores e compras pré definidos
	Livraria(){
		//criar 3 pequenos historicos de preços
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
		Livro lv1 = new Livro ("O último voo do Flamingo", "1548967532745", "Mia Couto", "Plátano", 
				"Romance. Um estranho encontro", new GregorianCalendar (2018,11,12) , 15.5, 20, precos1);
		Livro lv2 = new Livro ("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya", 
				"Ficção Científica. Viagens espaciais de um inadaptado", 
				new GregorianCalendar (2017,11,18) , 16.5, 3, precos2);
		Livro lv3 = new Livro ("Nove Amanhãs", "1549657432745", "Isak Asimov", "Nébula", 
				"Ficção Científica. Nove pequenos contos futurísticos", 
				new GregorianCalendar (2018,11,12) , 15.5, 20, precos3);
		Livro lv4 = new Livro ("Um homem estranho numa terra estranha", "9635874432745", "Ursula K Leguin", "Nébula", 
				"Ficção Científica. Um extra-terrestre chega à terra", 
				new GregorianCalendar (2017,11,12) , 11, 0, precos1);
		// adicionar livros à lista de livros
		livros = new ArrayList<>();
		livros.add(lv1);
		livros.add(lv2);
		livros.add(lv3);
		livros.add(lv4);
		//Criar alguns utilizadores
		Utilizador u1 = new Utilizador( "António Cunha", "tocunha@gmail.com", "tocunha2000", Utilizador.Tipo.ADMIN);
		Utilizador u2 = new Utilizador( "Tiago Correia", "admin", "admin", Utilizador.Tipo.ADMIN);
		Utilizador u3 = new Utilizador( "Márcia Campos", "mcampos.a@gmail.com", "heyd6wx", Utilizador.Tipo.VENDEDOR);
		Utilizador u4 = new Utilizador( "Beatriz Costa", "vende", "vende", Utilizador.Tipo.VENDEDOR);
		//adicionar utilizadores à lista de utilizadores
		utilizadores = new ArrayList<>();
		utilizadores.add( u1 );
		utilizadores.add( u2 );
		utilizadores.add( u3 );
		utilizadores.add( u4 );
		//Criar alguns mapas de livros-quantidade para os carrinhos de compras 
		Map <Livro, Integer> livros1 = new HashMap <>();
		livros1.put(lv1, 2);
		livros1.put(lv2, 1);
		Map <Livro, Integer> livros2 = new HashMap <>();
		livros2.put(lv2, 1);
		livros2.put(lv3, 3);
		Map <Livro, Integer> livros3 = new HashMap <>();
		livros3.put(lv2, 1);
		//criar alguns carrinhos
		Carrinho c1 = new Carrinho(livros1);
		Carrinho c2 = new Carrinho(livros2);
		Carrinho c3 = new Carrinho(livros3);
		//Criar algumas compras finalizadas e adicionar à lista de compras
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
}
