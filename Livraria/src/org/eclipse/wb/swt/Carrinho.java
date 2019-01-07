package org.eclipse.wb.swt;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class Carrinho {
	protected Map <Livro, Integer> livrosQuant;
	
	Carrinho(){
		livrosQuant = new HashMap<>();
	}
	
	Carrinho( Map <Livro, Integer> livrosQuant ){
		this.livrosQuant = livrosQuant;
	}
	
	public double totalCarrinho() {
		//criar set de livros do mapa de livros-quantidades
		Set <Livro> livros = livrosQuant.keySet();
		//para cada um dos livros do set, percorrer o map e ver as quantidades que lhe correspondem e ir somando total
		double total = 0;
		for ( Livro lv : livros ) {
			int quantidadeLv = livrosQuant.get(lv);
			total = total + quantidadeLv*lv.preco; 
		}
		return total;
	}
	
	public String toString() {
		//criar set de livros do mapa de livros-quantidades
		Set <Livro> livros = livrosQuant.keySet();
		//para cada um dos livros do set, percorrer o map e acrescentar cada livro à String
		String s = "";
		for ( Livro lv : livros ) {
			s = s + "-----------------------------------\n" + 
			lv + "\n" + 
			"Quantidade: " + livrosQuant.get(lv) + "\n";
		}
		return s;
	}
	
	
}
