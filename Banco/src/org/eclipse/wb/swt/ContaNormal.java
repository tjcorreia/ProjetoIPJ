package org.eclipse.wb.swt;

import java.io.Serializable;
import java.util.ArrayList;

/**
* Breve descrição do código
* Classe conta
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
* 
*/
public class ContaNormal extends Conta implements Serializable {

	private ArrayList<Cartao> listaCartoesC;//
  
	
	
	public ContaNormal(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
			ArrayList<Integer> clientesDaC, TipoC escolhaID, ArrayList<Cartao> listaCartoesC) {
		super(contaID, saldo, datacria, transacoesC, clientesDaC, escolhaID);
		this.listaCartoesC = new ArrayList<Cartao>();
	}

	public ContaNormal() {
		super();
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.listaCartoesC = new ArrayList<Cartao>();
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(int contaID, double saldo, String datacria) {
		super(contaID, saldo, datacria);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.listaCartoesC = new ArrayList<Cartao>();
		;
		// TODO Auto-generated constructor stub
	}

	public ContaNormal(double saldo, String datacria) {
		super(saldo, datacria);
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		this.listaCartoesC = new ArrayList<Cartao>();
		;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter e Setters para todos os atributos
	 */
	public ArrayList<Cartao> getListaCartoesC() {
		return listaCartoesC;
	}

	public void setListaCartoesC(ArrayList<Cartao> listaCartoesC) {
		this.listaCartoesC = listaCartoesC;
	}

	/**
	 * adiciona cartão  a lista de Cartões
	 * @param novoCartao
	 * @return Cartão
	 */
	public Cartao addCartaoC(Cartao novoCartao) {
		listaCartoesC.add(novoCartao);
		return novoCartao;

	}
	/**
	 * Remove cartão da Lista de Cartões
	 * @param Cartao
	 * @return boolean
	 */
	public boolean removeCartaoC(Cartao Cartao) {
		if (!(listaCartoesC.size() == 0)) {
		for(Cartao c:listaCartoesC) {
			if (c==Cartao) {
		listaCartoesC.remove(c);
		return true;
			}
	}
		}
		return false;

	}

	/**
	 * Procura um Cartão por ID
	 * @param cartaoID
	 * @return Cartão
	 */
	public Cartao procuraCartaoC(int cartaoID) {
		
		if (!(listaCartoesC.size() == 0)) {
			for (Cartao c : listaCartoesC) {
				if (c.getCartaoID() == cartaoID) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * Verifica o Pin de um Cartão
	 * @param cartaoID
	 * @param pin
	 * @return Cartão
	 */
	public Cartao verificaPINCartaoC(int cartaoID,String pin) {
		if (!(listaCartoesC.size() == 0)) {
			for (Cartao c : listaCartoesC) {
				if (c.getCartaoID() == cartaoID) {
					if (c.getCodigo().equals(pin)) {
						return c;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * @param titularID
	 * @return Cartão
	 */
	public Cartao procuraCartaoCTitular(int titularID) {
		if (!(listaCartoesC.size() == 0)) {
			for (Cartao c : listaCartoesC) {
				System.out.println("<---- ID --->" + c.getTitularCartaoID());
				if (c.getTitularCartaoID() == titularID) {
					System.out.println("<---- ID do OKOKOK---> " + c.getTitularCartaoID());
					return c;
				}
			}
		}
		return null;
	}

}
