package org.eclipse.wb.swt;

import java.io.Serializable;
import java.util.ArrayList;

/**
* Breve descri��o do c�digo
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
	 * adiciona cart�o  a lista de Cart�es
	 * @param novoCartao
	 * @return Cart�o
	 */
	public Cartao addCartaoC(Cartao novoCartao) {
		listaCartoesC.add(novoCartao);
		return novoCartao;

	}
	/**
	 * Remove cart�o da Lista de Cart�es
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
	 * Procura um Cart�o por ID
	 * @param cartaoID
	 * @return Cart�o
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
	 * Verifica o Pin de um Cart�o
	 * @param cartaoID
	 * @param pin
	 * @return Cart�o
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
	 * @return Cart�o
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
