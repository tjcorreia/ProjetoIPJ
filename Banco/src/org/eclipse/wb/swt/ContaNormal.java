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

	public ContaNormal(int contaID, double saldo, ArrayList<Transacao> transacoesC, ArrayList<String> clientesDaC,
			TipoC escolhaID, Cartao cartaodaConta) {
		super(contaID, saldo, transacoesC, clientesDaC, escolhaID);
		this.cartaodaConta = cartaodaConta;
	}

	public ContaNormal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(int contaID, double saldo) {
		super(contaID, saldo);
		this.cartaodaConta = null;
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<String>();
		this.escolhaID = TipoC.ABERTA;;
		// TODO Auto-generated constructor stub
	}

	
	

}
