package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Funcionario extends Utilizador {

	protected String  posicao;

	public Funcionario(int uID, String login, String password, String nome, String morada, TipoID escolhaID,
			int valorID, String email, int mobile, String posicao) {
		super(uID, login, password, nome, morada, escolhaID, valorID, email, mobile);
		this.posicao = posicao;
	}

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int uID, String login, String password, String nome, String morada, TipoID escolhaID,
			int valorID, String email, int mobile) {
		super(uID, login, password, nome, morada, escolhaID, valorID, email, mobile);
		// TODO Auto-generated constructor stub
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	
	
	

}
