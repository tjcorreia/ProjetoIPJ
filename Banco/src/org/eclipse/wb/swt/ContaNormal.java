package org.eclipse.wb.swt;

import java.util.ArrayList;

import org.eclipse.wb.swt.Conta.TipoC;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class ContaNormal extends Conta {
	
	private Cartao cartaodaConta;

	public ContaNormal(int contaID, double saldo, ArrayList<Transacao> transacoesC, ArrayList<Integer> clientesDaC,
			TipoC escolhaID, Cartao cartaodaConta) {
		super(contaID, saldo, transacoesC, clientesDaC, escolhaID);
		this.cartaodaConta = cartaodaConta;
	}

	public ContaNormal() {
		super();
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.escolhaID = TipoC.ABERTA;
		this.cartaodaConta = null;
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(int contaID, double saldo) {
		super(contaID, saldo);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.escolhaID = TipoC.ABERTA;
		this.cartaodaConta = null;
		// TODO Auto-generated constructor stub
	}

	public Cartao getCartaodaConta() {
		return cartaodaConta;
	}

	public void setCartaodaConta(Cartao cartaodaConta) {
		this.cartaodaConta = cartaodaConta;
	}

	
	

}
