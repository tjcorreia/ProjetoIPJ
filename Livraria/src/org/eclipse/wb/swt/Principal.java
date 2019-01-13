
package org.eclipse.wb.swt;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Principal {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Livraria viewComics = new Livraria();

		J_00Inicial janelaInicial = new J_00Inicial(viewComics);
		janelaInicial.open();
	}
}

