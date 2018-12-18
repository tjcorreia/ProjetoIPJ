package org.eclipse.wb.swt;


public class Cartao {
	
	protected int cartaoID;       
	protected String nome;
	protected String dataV;
	protected int codigo;
	
	
	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cartao(int cartaoID, String nome, String dataV, int codigo) {
		super();
		this.cartaoID = cartaoID;
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


	@Override
	public String toString() {
		return "Cartao [cartaoID=" + cartaoID + ", nome=" + nome + ", dataV=" + dataV + ", codigo=" + codigo + "]";
	}
	
	



	

}
