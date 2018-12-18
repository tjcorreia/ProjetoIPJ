package org.eclipse.wb.swt;

import java.util.ArrayList;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class ContaNormal extends Conta {
	
	private int numcartao;

	public ContaNormal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(int contaID, double saldo, ArrayList<Transacao> transacoesC, ArrayList<String> clientesDaC,
			TipoC escolhaID, int numcartao) {
		super(contaID, saldo, transacoesC, clientesDaC, escolhaID);
		this.numcartao = numcartao;
	}

	public int getNumcartao() {
		return numcartao;
	}

	public void setNumcartao(int numcartao) {
		this.numcartao = numcartao;
	}

	@Override
	public String toString() {
		return "ContaNormal [numcartao=" + numcartao + "]";
	}
	
	

}
