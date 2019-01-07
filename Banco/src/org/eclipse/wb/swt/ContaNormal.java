package org.eclipse.wb.swt;

import java.io.Serializable;
import java.util.ArrayList;



/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class ContaNormal extends Conta implements Serializable{
	
	private Cartao cartaodaConta;



	public ContaNormal(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
			ArrayList<Integer> clientesDaC, TipoC escolhaID, Cartao cartaodaConta) {
		super(contaID, saldo, datacria, transacoesC, clientesDaC, escolhaID);
		this.cartaodaConta = cartaodaConta;
	}

	public ContaNormal() {
		super();
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.cartaodaConta = null;
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(int contaID, double saldo, String datacria) {
		super(contaID,saldo,datacria);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.cartaodaConta = null;
		// TODO Auto-generated constructor stub
	}
	
	public ContaNormal( double saldo, String datacria) {
		super(saldo,datacria);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.cartaodaConta = null;
		// TODO Auto-generated constructor stub
	}

	public Cartao getCartaodaConta() {
		return cartaodaConta;
	}

	public void setCartaodaConta(Cartao cartaodaConta) {
		this.cartaodaConta = cartaodaConta;
	}

	@Override
	public String toString() {
		return "ContaNormal [cartaodaConta=" + cartaodaConta + ", contaID=" + contaID + ", saldo=" + saldo
				+ ", datacria=" + datacria + ", transacoesC=" + transacoesC + ", clientesDaC=" + clientesDaC
				+ ", abertaFechada=" + abertaFechada + "]";
	}


	
	

}
