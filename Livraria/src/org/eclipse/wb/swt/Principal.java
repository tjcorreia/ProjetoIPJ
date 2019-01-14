
package org.eclipse.wb.swt;

import java.io.Serializable;

/**
 * Classe principal que tem o m�todo main do presente projecto
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Principal  implements Serializable{
	/**
	 * M�todo MAIN
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		//Cria��o de nova Livraria, atrav�s do seu construtor, onde far� a leitura dos ficheiros de objetos
		Livraria viewComics = new Livraria();
		J_00Inicial janelaInicial = new J_00Inicial(viewComics);
		janelaInicial.open();
	}
}

