package org.eclipse.wb.swt;

import java.io.Serializable;

public class Cartao implements Serializable{
	
	protected int cartaoID;
	protected int titularCartaoID;
	protected int contaCartaoID;
	protected String nome;
	protected String dataV;
	protected int codigo;
	
	
	
	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cartao(int cartaoID, int titularCartaoID, int contaCartaoID, String nome, String dataV, int codigo) {
		super();
		this.cartaoID = cartaoID;
		this.titularCartaoID = titularCartaoID;
		this.contaCartaoID = contaCartaoID;
		this.nome = nome;
		this.dataV = dataV;
		this.codigo = codigo;
	}

	
	public Cartao(int titularCartaoID, int contaCartaoID, String nome, String dataV, int codigo) {
		super();
		this.titularCartaoID = titularCartaoID;
		this.contaCartaoID = contaCartaoID;
		this.nome = nome;
		this.dataV = dataV;
		this.codigo = codigo;
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	



	

}
