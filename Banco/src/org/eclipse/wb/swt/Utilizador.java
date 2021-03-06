package org.eclipse.wb.swt;

import java.io.Serializable;

/**
* Breve descri��o do c�digo
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
* @sid 2019
* @aid 1.1
*/
@SuppressWarnings("serial")
public class Utilizador implements Serializable{
	
	
	protected int uID;        //
	protected String login;   // 
	protected String password;// 
	protected String  nome;   //
	protected String  sobrenome;   //
	protected String  dataNascimento;   // 
	protected String  morada; //
	public TipoID escolhaID;
	protected String valorID;     //numero do Passporte ou CC
	protected String  email;  //
	protected int mobile;     //
	
	protected enum TipoID {CARTAOCIDADAO,PASSAPORTE}

	public Utilizador(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		super();
		this.uID = uID;
		this.login = login;
		this.password = password;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.morada = morada;
		this.escolhaID = escolhaID;
		this.valorID = valorID;
		this.email = email;
		this.mobile = mobile;
	}

	public Utilizador( String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		super();
		
		this.login = login;
		this.password = password;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.morada = morada;
		this.escolhaID = escolhaID;
		this.valorID = valorID;
		this.email = email;
		this.mobile = mobile;
	}
	/**
	 * Getter e Setters para todos os atributos
	 */
	public Utilizador() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getValorID() {
		return valorID;
	}

	public void setValorID(String valorID) {
		this.valorID = valorID;
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
		return "Utilizador [uID=" + uID + ", login=" + login + ", password=" + password + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento + ", morada=" + morada
				+ ", escolhaID=" + escolhaID + ", valorID=" + valorID + ", email=" + email + ", mobile=" + mobile + "]";
	}

	





	
	
	

}
