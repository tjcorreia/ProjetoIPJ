package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Utilizador {
	
	
	protected int uID;        //
	protected String login;   // 
	protected String password;// 
	protected String  nome;   // 
	protected String  morada; //
	public TipoID escolhaID;
	protected String  email;  //
	protected int mobile;     //
	
	protected enum TipoID {CARTAOCIDADAO,PASSAPORTE}

	public Utilizador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilizador(int uID, String login, String password, String nome, String morada, TipoID escolhaID,
			String email, int mobile) {
		super();
		this.uID = uID;
		this.login = login;
		this.password = password;
		this.nome = nome;
		this.morada = morada;
		this.escolhaID = escolhaID;
		this.email = email;
		this.mobile = mobile;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public TipoID getEscolhaID() {
		return escolhaID;
	}

	public void setEscolhaID(TipoID escolhaID) {
		this.escolhaID = escolhaID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Utilizador [uID=" + uID + ", login=" + login + ", password=" + password + ", nome=" + nome + ", morada="
				+ morada + ", escolhaID=" + escolhaID + ", email=" + email + ", mobile=" + mobile + "]";
	};
	
	

}
