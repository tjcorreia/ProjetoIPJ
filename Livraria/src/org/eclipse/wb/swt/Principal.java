
package org.eclipse.wb.swt;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Principal {


	public static void main(String[] args) {
		
		Livraria viewComics = new Livraria();
		
//		J_01List janelaInicialteste = new J_01List(viewComics);
//		janelaInicialteste.setVisible(true);

		J_00Inicial janelaInicial = new J_00Inicial(viewComics);
		janelaInicial.open();
	}
	

}

