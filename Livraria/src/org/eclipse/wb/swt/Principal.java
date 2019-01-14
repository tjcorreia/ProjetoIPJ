
package org.eclipse.wb.swt;

import java.io.Serializable;

/**
 * Classe principal que tem o método main do presente projecto
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Principal  implements Serializable{
	/**
	 * Método MAIN
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		//Criação de nova Livraria, através do seu construtor, onde fará a leitura dos ficheiros de objetos
		Livraria viewComics = new Livraria();
		J_00Inicial janelaInicial = new J_00Inicial(viewComics);
		janelaInicial.open();
	}
}

