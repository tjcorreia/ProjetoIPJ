package org.eclipse.wb.swt;
import java.util.ArrayList;


public class Carrinho {
	protected ArrayList <Livro> livros;
	protected ArrayList <Integer> quantidades;
	
	Carrinho(){
		livros = new ArrayList<>();
		quantidades = new ArrayList<>();
	}
	
	Carrinho( ArrayList <Livro> livrosRepetidos ){
		livros = new ArrayList<>();
		quantidades = new ArrayList<>();
		for ( Livro lv : livrosRepetidos ) {
			//se livro já existe na lista 'livros', aumenta-se a quantidade
			if ( livros.contains(lv) ) {
				int indice = livros.indexOf(lv);
				int quantidade = quantidades.get(indice);
				quantidades.set(indice, quantidade+1);
			}
			//Se livro não existe, acrescenta-se à lista, com quantidade 1
			else {
				livros.add(lv);
				quantidades.add(1);
			}
		}
	}
	
	public double totalCarrinho() {
		//para cada um dos livros, percorrer a lista e ver as quantidades que lhe correspondem e ir somando total
		double total = 0;
		for ( Livro lv : livros ) {
			int indice = livros.indexOf(lv);
			int quantidade = quantidades.get(indice);
			total = total + quantidade*lv.preco; 
		}
		return total;
	}
	
	public String toString() {
		//para cada um dos livros da lista, percorrer e acrescentar cada livro à String
		String s = "";
		for ( Livro lv : livros ) {
			s = s + "-----------------------------------\n" + 
			lv + "\n" + 
			"Quantidade: " + quantidades.get( livros.indexOf(lv) ) + "\n";
		}
		return s;
	}	
	
	//Método que devolve o número de items que tem o carrinho
	public int numeroItemsDoCarrinho () {
		int items = 0;
		if ( livros.isEmpty() ) {
			return items;
		}
		else {
			for ( Integer i : quantidades ){
				items = items + i;
			}
		}
		return items;
	}	
	
	
}
