
package org.eclipse.wb.swt;

import java.io.Serializable;

/**
 * Classe Utilizador que define cada utilizador a partir de um número único 'uID',
 * a partir do nome, endereço de email e senha de acesso ao sistema, bem como o 
 * enum 'tipo', que distingue os utilizadores do tipo administrador dos vendedores
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Utilizador implements Serializable {
	/**
	 * Atributos da classe
	 */
	protected int uID;
	protected String nome;
	protected String email;
	protected String senha;
	protected Tipo tipo;//public para poder definir estado da compra a partir de outras classes
	public enum Tipo {ADMIN, VENDEDOR};
	
	/**
	 * Construtor da classe por defeito
	 */
	Utilizador(){
		uID = -1;
		nome = "";
		email = "";
		senha = "";
		tipo = Tipo.VENDEDOR;
	}
	
	/**
	 * Construtor da classe a partir de todos os seus atributos
	 */
	Utilizador( int uID, String nome, String email, String senha, Tipo tipo){
		this.uID = uID;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
}

