<<<<<<< HEAD
package org.eclipse.wb.swt;



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
	
	Utilizador( String nome, String email, String senha, Tipo tipo){
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
=======
package org.eclipse.wb.swt;



public class Utilizador {
	protected String nome;
	protected String email;
	protected String senha;
	protected Tipo tipo;//public para poder definir estado da compra a partir de outras classes
	public enum Tipo {ADMIN, VENDEDOR};
	

	Utilizador(){
		nome = "";
		email = "";
		senha = "";
		tipo = Tipo.VENDEDOR;
	}
	
	Utilizador( String nome, String email, String senha, Tipo tipo){
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
>>>>>>> branch 'master' of https://github.com/tjcorreia/ProjetoIPJ.git
