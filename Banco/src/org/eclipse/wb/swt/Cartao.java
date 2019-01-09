package org.eclipse.wb.swt;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Cartao implements Serializable{
	
	protected int cartaoID;
	protected int titularCartaoID;
	protected int contaCartaoID;
	protected String nome;
	protected String dataV;
	protected String codigo;
	
	
	
	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cartao(int cartaoID, int titularCartaoID, int contaCartaoID, String nome, String dataV, String codigo) {
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
		this.dataV = ""+data;
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
		this.dataV = ""+data;
		Random r=new Random();
		int inf=0;
		int sup=1000;
		String codigof=""+(r.nextInt(sup-inf)+inf);	
		this.codigo = codigof;
	}


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


	public String getDataV() {
		return dataV;
	}


	public void setDataV(String dataV) {
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
		return "Cartao [cartaoID=" + cartaoID + "\n, titularCartaoID=" + titularCartaoID + "\n, contaCartaoID="
				+ contaCartaoID + "\n, nome=" + nome + "\n, dataV=" + dataV + "\n\n, codigo=" + codigo + "]";
	}

	
	
	



	

}
