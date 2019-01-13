package org.eclipse.wb.swt;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
* Breve descrição do código
* Classe Cartão
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
* 
*/
 
public class Cartao implements Serializable{
	// Atributos
	protected int cartaoID;        // ID do Cartão gerado epla gestao
	protected int titularCartaoID; // ID do Titular do Cartão
	protected int contaCartaoID;   // ID da conta associada ao Cartão
	protected String nome;  // ID do Titular a figurar no cartao
	protected LocalDate dataV; // Data de Validade gerada automaticamente
	protected String codigo;// Código do Cartao gerado automaticamente
	
	
	
	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cartao(int cartaoID, int titularCartaoID, int contaCartaoID, String nome, LocalDate dataV, String codigo) {
		super();
		this.cartaoID = cartaoID;
		this.titularCartaoID = titularCartaoID;
		this.contaCartaoID = contaCartaoID;
		this.nome = nome;
		this.dataV = dataV;
		this.codigo = codigo;
	}


	public Cartao(int cartaoID, int titularCartaoID, int contaCartaoID, String nome) {
		super();
		LocalDate data = LocalDate.now().plusYears(5);
		this.cartaoID = cartaoID;
		this.titularCartaoID = titularCartaoID;
		this.contaCartaoID = contaCartaoID;
		this.nome = nome;
		this.dataV = data;
		Random r=new Random();
		int inf=0;
		int sup=1000;
		String codigof=""+(r.nextInt(sup-inf)+inf);	
		this.codigo = codigof;
	}

	
	public Cartao(int titularCartaoID, int contaCartaoID, String nome) {
		super();
		LocalDate data = LocalDate.now().plusYears(5);
		this.titularCartaoID = titularCartaoID;
		this.contaCartaoID = contaCartaoID;
		this.nome = nome;
		this.dataV = data;
		Random r=new Random();
		int inf=0;
		int sup=1000;
		String codigof=""+(r.nextInt(sup-inf)+inf);	
		this.codigo = codigof;
	}



	/**
	 * Getter e Setters para todos os atributos
	 */
	public int getCartaoID() {
		return cartaoID;
	}


	public void setCartaoID(int cartaoID) {
		this.cartaoID = cartaoID;
	}


	public int getTitularCartaoID() {
		return titularCartaoID;
	}


	public void setTitularCartaoID(int titularCartaoID) {
		this.titularCartaoID = titularCartaoID;
	}


	public int getContaCartaoID() {
		return contaCartaoID;
	}


	public void setContaCartaoID(int contaCartaoID) {
		this.contaCartaoID = contaCartaoID;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataV() {
		return dataV;
	}


	public void setDataV(LocalDate dataV) {
		this.dataV = dataV;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "[ Novo Cartao ] \nCartaoID: " + cartaoID + "\nTitularCartaoID: " + titularCartaoID + "\nNº Conta do Cartao: "
				+ contaCartaoID + "\nNome: " + nome + "\nDataValidade:" + dataV + "\n\n, Codigo: *" + codigo + "*";
	}

	
	



	

}
