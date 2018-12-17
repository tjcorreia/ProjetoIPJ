import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Livraria {
	protected List <Livro> livros;
	protected List <Utilizador> utilizadores;
	protected List <Compra> compras;
	
	//Construtor que cria alguns livros, utilizadores e compras pr� definidos
	Livraria(){
		livros = new ArrayList<>();
		//criar pequeno historico de pre�os
		Map <GregorianCalendar, Double > precos1 = new HashMap<>();
		precos1.put(new GregorianCalendar(2017,2,5), 15.0);
		precos1.put(new GregorianCalendar(2016,6,14), 13.0);
		precos1.put(new GregorianCalendar(2016,12,14), 14.0);
		//criar livro e adicionar � lista de livros
		livros.add(new Livro ("O �ltimo voo do Flamingo", "1548967532745", "Mia Couto", "Pl�tano", 
				"Romance. Um estranho encontro", new GregorianCalendar (2018,11,12) , 15.5, 20, precos1));
		Map <GregorianCalendar, Double > precos2 = new HashMap<>();
		precos2.put(new GregorianCalendar(2017,2,5), 15.0);
		precos2.put(new GregorianCalendar(2016,6,14), 13.0);
		precos2.put(new GregorianCalendar(2016,11,14), 14.0);
		livros.add(new Livro ("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya", 
				"Fic��o Cient�fica. Viagens espaciais de um inadaptado", new GregorianCalendar (2017,11,18) , 16.5, 3, precos2));
		Map <GregorianCalendar, Double > precos3 = new HashMap<>();
		precos3.put(new GregorianCalendar(2017,2,5), 23.0);
		precos3.put(new GregorianCalendar(2017,5,14), 25.0);
		precos3.put(new GregorianCalendar(2018,10,2), 25.8);
		livros.add(new Livro ("Nove Amanh�s", "1549657432745", "Isak Asimov", "N�bula", 
				"Fic��o Cient�fica. Nove pequenos contos futur�sticos", new GregorianCalendar (2018,11,12) , 15.5, 20, precos3));
		//Criar alguns utilizadores e adicionar � lista de utilizadores
		utilizadores = new ArrayList<>();
		utilizadores.add( new Utilizador( "Ant�nio Cunha", "tocunha@gmail.com", "tocunha2000", Utilizador.Tipo.ADMIN));
		utilizadores.add( new Utilizador( "Tiago Correia", "admin", "admin", Utilizador.Tipo.ADMIN));
		utilizadores.add( new Utilizador( "M�rcia Campos", "mcampos.a@gmail.com", "heyd6wx", Utilizador.Tipo.VENDEDOR));
		utilizadores.add( new Utilizador( "Beatriz Costa", "vende", "vende", Utilizador.Tipo.VENDEDOR));
	
		//Criar algumas compras finalizadas e adicionar � lista de compras
		compras = new ArrayList<>();
		
		
	}
}
