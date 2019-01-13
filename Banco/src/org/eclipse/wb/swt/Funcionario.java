package org.eclipse.wb.swt;

import java.io.Serializable;

/**
* Breve descrição do código
* Classe conta
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
* 
*/
public class Funcionario extends Utilizador implements Serializable{

	protected String  posicao;


	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		super(login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, String posicao) {
		super(uID, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.posicao = posicao;
	}
	
	public Funcionario( String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, String posicao) {
		super( login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID, email, mobile);
		this.posicao = posicao;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	
	
	

}
