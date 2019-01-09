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
	
	private  ArrayList<Cartao> listaCartoesC;// 





	public ContaNormal(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
			ArrayList<Integer> clientesDaC, TipoC escolhaID, ArrayList<Cartao> listaCartoesC) {
		super(contaID, saldo, datacria, transacoesC, clientesDaC, escolhaID);
		this.listaCartoesC = listaCartoesC;
	}

	public ContaNormal() {
		super();
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.listaCartoesC =new ArrayList<Cartao>();
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(int contaID, double saldo, String datacria) {
		super(contaID,saldo,datacria);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.listaCartoesC =new ArrayList<Cartao>();;
		// TODO Auto-generated constructor stub
	}
	

	public ContaNormal( double saldo, String datacria) {
		super(saldo,datacria);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.listaCartoesC =new ArrayList<Cartao>();;
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cartao> getListaCartoesC() {
		return listaCartoesC;
	}

	public void setListaCartoesC(ArrayList<Cartao> listaCartoesC) {
		this.listaCartoesC = listaCartoesC;
	}


	public Cartao addCartaoC(Cartao novoCartao) {
		listaCartoesC.add(novoCartao);
		 return novoCartao;
		 
	 }

	public Cartao procuraCartaoC(int cartaoID) {
		for (Cartao c:listaCartoesC ) {
			if(c.getCartaoID()==cartaoID) {
				 return c;	
			}
		}
		 return null;
	 }
	
	public Cartao procuraCartaoCTitular(int titularID) {
		for (Cartao c:listaCartoesC ) {
			System.out.println("<---- ID do Cartaoobjeto--->\n" + c.getTitularCartaoID());
			if(c.getTitularCartaoID()==titularID) {
				 return c;	
			}
		}
		 return null;
	 }
	

}
