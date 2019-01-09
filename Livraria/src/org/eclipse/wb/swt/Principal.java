
package org.eclipse.wb.swt;


public class Principal {


	public static void main(String[] args) {
		
		Livraria viewComics = new Livraria();

		J_00Inicial janelaInicial = new J_00Inicial(viewComics);
		janelaInicial.open();
	}
	

}

