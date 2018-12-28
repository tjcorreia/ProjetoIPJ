package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Administrador extends Utilizador {

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, int valorID, String email, int mobile) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
	}

	public Administrador( String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, int valorID, String email, int mobile) {
		super(login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
	}
	

}
