package org.eclipse.wb.swt;
import java.io.Serializable;

import java.util.ArrayList;



/**
 * Classe 'Carrinho', que agrupa uma lista de livros e respetivas quantidades
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Carrinho implements Serializable{
	/**
	 * Atributos da classe
	 */
	protected ArrayList <Livro> livros;
	protected ArrayList <Integer> quantidades;
	
	/**
	 * Construtor da classe Carrinho sem atributos introduzidos
	 */
	Carrinho(){
		livros = new ArrayList<>();
		quantidades = new ArrayList<>();
	}

	
	/**
	 * Construtor da classe 'Carrinho'
	 * 
	 * @param ArrayList de 'Livro', que podem ou n�o estar repetidos
	 */
	Carrinho( ArrayList <Livro> livrosRepetidos ){
		livros = new ArrayList<>();
		quantidades = new ArrayList<>();
		for ( Livro lv : livrosRepetidos ) {
			//se livro j� existe na lista 'livros', aumenta-se a quantidade
			if ( livros.contains(lv) ) {
				int indice = livros.indexOf(lv);
				int quantidade = quantidades.get(indice);
				quantidades.set(indice, quantidade+1);
			}
			//Se livro n�o existe, acrescenta-se � lista, com quantidade 1
			else {
				livros.add(lv);
				quantidades.add(1);
			}
		}
	}
	
	/**
	 * M�todo que calcula o custo total do carrinho
	 * 
	 * @return double custo total do carrinho
	 */
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
	
	/**
	 * M�todo toString para impress�o de carrinho
	 * 
	 * @return String com informa��es do carrinho
	 */
	public String toString() {
		//para cada um dos livros da lista, percorrer e acrescentar cada livro � String
		String s = "";
		for ( Livro lv : livros ) {
			s = s + "-----------------------------------\n" + 
			lv + "\n" + 
			"Quantidade: " + quantidades.get( livros.indexOf(lv) ) + "\n";
		}
		return s;
	}	
	
	/**
	 * M�todo que devolve o n�mero de items (livros) que tem o carrinho
	 * 
	 * @return int n�mero de livros que tem o carrinho
	 */
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
