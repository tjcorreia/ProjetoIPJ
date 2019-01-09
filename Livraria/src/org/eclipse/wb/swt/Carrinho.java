package org.eclipse.wb.swt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class Carrinho {
	protected ArrayList <Livro> livros;
	protected ArrayList <Integer> quantidades;
	//protected Map <Livro, Integer> livrosQuant;
	//protected int [][] isbnQuantidade;//**++testar um novo tipo de carrinho com isbn/qunatidade
	//protected List  isbnQuantidade;//**++testar um novo tipo de carrinho com isbn/qunatidade
	
	Carrinho(){
		livros = new ArrayList<>();
		quantidades = new ArrayList<>();
		//livrosQuant = new HashMap<>();
		//isbnQuantidade = new int [1][2];//**++testar um novo tipo de carrinho com isbn/qunatidade
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
	
//	Carrinho( Map <Livro, Integer> livrosQuant ){
//		this.livrosQuant = livrosQuant;
//	}
	
	//**++testar um novo tipo de carrinho com isbn/qunatidade
	//Carrinho( int [][] isbnQuantidade ){
	//	this.isbnQuantidade = isbnQuantidade;
	//}
	
//	public double totalCarrinho() {
//		//para cada um dos livros do set, percorrer o map e ver as quantidades que lhe correspondem e ir somando total
//		double total = 0;
//		int isbn;
//		for ( int i = 0 ; i < isbnQuantidade.length ; i++) {
//			isbn = isbnQuantidade[i][0];
//			int quantidadeLv = livrosQuant.get(lv);
//			total = total + quantidadeLv*lv.preco; 
//		}
//		return total;
//	}
//	
//	public String toString() {
//		//criar set de livros do mapa de livros-quantidades
//		Set <Livro> livros = livrosQuant.keySet();
//		//para cada um dos livros do set, percorrer o map e acrescentar cada livro à String
//		String s = "";
//		for ( Livro lv : livros ) {
//			s = s + "-----------------------------------\n" + 
//			lv + "\n" + 
//			"Quantidade: " + livrosQuant.get(lv) + "\n";
//		}
//		return s;
//	}
	
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
	
//	//Método para adicionar um novo (ou repetido) livro ao carrinho
//	public void adicionarLivroAoCarrinho (Livro lv) {
//		//Se livro não tem stock, não fazer nada
//		if ( lv.stock <= 0 ) {		
//		}
//		//Se livro já existe na lista, aumentar a quantidade
//		else if ( livros.contains(lv)) {
//			int indice = livros.indexOf(lv);
//			int quantidade = quantidades.get(indice);
//			quantidades.set(indice, quantidade+1);
//			lv.reduzirStock(1);
//		}
//		//se livro não existia, acrescenta-se livro a 'livros' e quantidade a 'quantidades'
//		else {
//			livros.add(lv);
//			quantidades.add(1);
//			lv.reduzirStock(1);
//		}
//	}
//	
//	//Método para remover um livro do carrinho
//	public void removerLivroDoCarrinho (Livro lv) {
//		int indice = livros.indexOf(lv);
//		int quantidade = quantidades.get(indice);
//		//se livro não vem na lista do carrinho, não fazer nada
//		if ( !livros.contains(lv) ) {
//		}
//		//Se só havia um exemplar, remover o livro
//		else if ( quantidade == 1 ) {
//			livros.remove(indice);
//			quantidades.remove(indice);
//			lv.aumentarStock(1);
//		}
//		//se há mais do que um exemplar, reduzir quantidade
//		else {
//			quantidades.set(indice, quantidade-1);
//			lv.aumentarStock(1);
//		}
//	}	
	
	//Método para remover um livro do carrinho
	public int numeroItemsDoCarrinho () {
		int items = 0;
		for ( Integer i : quantidades ){
			items = items + i;
		}
		return items;
	}	
	
	
//	public double totalCarrinho() {
//		//criar set de livros do mapa de livros-quantidades
//		Set <Livro> livros = livrosQuant.keySet();
//		//para cada um dos livros do set, percorrer o map e ver as quantidades que lhe correspondem e ir somando total
//		double total = 0;
//		for ( Livro lv : livros ) {
//			int quantidadeLv = livrosQuant.get(lv);
//			total = total + quantidadeLv*lv.preco; 
//		}
//		return total;
//	}
//	
//	public String toString() {
//		//criar set de livros do mapa de livros-quantidades
//		Set <Livro> livros = livrosQuant.keySet();
//		//para cada um dos livros do set, percorrer o map e acrescentar cada livro à String
//		String s = "";
//		for ( Livro lv : livros ) {
//			s = s + "-----------------------------------\n" + 
//			lv + "\n" + 
//			"Quantidade: " + livrosQuant.get(lv) + "\n";
//		}
//		return s;
//	}
	
	
}
