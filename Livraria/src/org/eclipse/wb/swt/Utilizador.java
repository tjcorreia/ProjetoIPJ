
package org.eclipse.wb.swt;


/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class Utilizador {
	protected int uID;
	protected String nome;
	protected String email;
	protected String senha;
	protected Tipo tipo;//public para poder definir estado da compra a partir de outras classes
	public enum Tipo {ADMIN, VENDEDOR};
	

	Utilizador(){
		uID = -1;
		nome = "";
		email = "";
		senha = "";
		tipo = Tipo.VENDEDOR;
	}
	
	Utilizador( int uID, String nome, String email, String senha, Tipo tipo){
		this.uID = uID;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}

