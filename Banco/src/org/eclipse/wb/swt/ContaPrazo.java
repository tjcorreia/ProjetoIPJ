package org.eclipse.wb.swt;

import java.io.Serializable;
import java.util.ArrayList;

import org.eclipse.wb.swt.Conta.TipoC;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class ContaPrazo extends Conta implements Serializable{
	
private String podedarjeito	;

public ContaPrazo(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
		ArrayList<Integer> clientesDaC, TipoC escolhaID, String podedarjeito) {
	super(contaID, saldo, datacria, transacoesC, clientesDaC, escolhaID);
	this.podedarjeito = podedarjeito;
}

public ContaPrazo() {
	super();
	this.transacoesC = new ArrayList<Transacao>();
	this.clientesDaC = new ArrayList<Integer>();
	this.abertaFechada = TipoC.ABERTA;
	// TODO Auto-generated constructor stub
}

public ContaPrazo(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
		ArrayList<Integer> clientesDaC, TipoC escolhaID) {
	super(contaID, saldo, datacria, transacoesC, clientesDaC, escolhaID);
	// TODO Auto-generated constructor stub
}

public ContaPrazo(int contaID, double saldo, String datacria) {
	super(contaID, saldo, datacria);
	this.transacoesC = new ArrayList<Transacao>();
	this.clientesDaC = new ArrayList<Integer>();
	this.abertaFechada = TipoC.ABERTA;
	// TODO Auto-generated constructor stub
}
public ContaPrazo( double saldo, String datacria) {
	super(saldo, datacria);
	this.transacoesC = new ArrayList<Transacao>();
	this.clientesDaC = new ArrayList<Integer>();
	this.abertaFechada = TipoC.ABERTA;
	// TODO Auto-generated constructor stub
}

public String getPodedarjeito() {
	return podedarjeito;
}

public void setPodedarjeito(String podedarjeito) {
	this.podedarjeito = podedarjeito;
}


	
	
	
}
