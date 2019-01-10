package org.eclipse.wb.swt;
/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/

import java.io.Serializable;
import java.util.ArrayList;


public class Conta implements Serializable{
	

	protected int contaID;        //
	protected double saldo;   //
	protected String datacria;
	protected ArrayList<Transacao> transacoesC;// 
	protected ArrayList<Integer> clientesDaC;// 
	public TipoC abertaFechada;
	
	protected enum TipoC {ABERTA,ENCERADA}







	public Conta(int contaID, double saldo, String datacria, ArrayList<Transacao> transacoesC,
			ArrayList<Integer> clientesDaC, TipoC escolhaID) {
		super();
		this.contaID = contaID;
		this.saldo = saldo;
		this.datacria = datacria;
		this.transacoesC = transacoesC;
		this.clientesDaC = clientesDaC;
		this.abertaFechada = escolhaID;
	}


	

	public Conta() {
		super();
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		// TODO Auto-generated constructor stub
	}
	
	public Conta(int contaID, double saldo, String datacria) {
		super();
		this.contaID = contaID;
		this.saldo = saldo;
		this.datacria = datacria;
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		// TODO Auto-generated constructor stub
	}


	public Conta(double saldo, String datacria) {
		super();
		this.saldo = saldo;
		this.datacria = datacria;
		this.transacoesC = new ArrayList<Transacao>();
		this.clientesDaC = new ArrayList<Integer>();
		this.abertaFechada = TipoC.ABERTA;
		// TODO Auto-generated constructor stub
	}


	public int getContaID() {
		return contaID;
	}




	public void setContaID(int contaID) {
		this.contaID = contaID;
	}




	public double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}




	public String getDatacria() {
		return datacria;
	}




	public void setDatacria(String datacria) {
		this.datacria = datacria;
	}




	public ArrayList<Transacao> getTransacoesC() {
		return transacoesC;
	}




	public void setTransacoesC(ArrayList<Transacao> transacoesC) {
		this.transacoesC = transacoesC;
	}




	public ArrayList<Integer> getClientesDaC() {
		return clientesDaC;
	}




	public void setClientesDaC(ArrayList<Integer> clientesDaC) {
		this.clientesDaC = clientesDaC;
	}




	public TipoC getAbertaFechada() {
		return abertaFechada;
	}




	public void setAbertaFechada(TipoC escolhaID) {
		this.abertaFechada = escolhaID;
	}




	@Override
	public String toString() {
		return "Conta [contaID=" + contaID + ", saldo=" + saldo + ", datacria=" + datacria + ", transacoesC="
				+ transacoesC + ", clientesDaC=" + clientesDaC + ", abertaFechada=" + abertaFechada + "]";
	}


	 public int addClienteC(int clienteID) { 
		 clientesDaC.add(clienteID);
		 return clienteID;
		 
	 }


	 public Transacao addTransacaoC(Transacao novaT) {
		 if (transacoesC==null) {
			 novaT.settID(1000);
			 transacoesC.add(novaT);
			 saldo=novaT.getValor();
			 return novaT;  
		 }
		 novaT.settID(transacoesC.size()+1000);
		 transacoesC.add(novaT);
		 saldo=saldo+novaT.getValor();
		 return novaT;
		 
	 }
	 public double  mensal(int anoA,int mesA) {
		double totalmensal=0;
		Transacao t=new Transacao();
		for (int i=transacoesC.size()-1;i>=0;i--) {
			String [] dataS=transacoesC.get(i).getData().split("-");
			if(anoA==Integer.parseInt(dataS[0])& mesA==Integer.parseInt(dataS[1])) {
				if (transacoesC.get(i).getValor()<0) {
					totalmensal=totalmensal+transacoesC.get(i).getValor();
				}
			}
			else  return totalmensal;
		}
		 return totalmensal;
	 }

	
	 public double  diario(String anoA,String mesA,String diaA) {
			double diario=0;
			Transacao t=new Transacao();
			for (int i=transacoesC.size()-1;i>=0;i--) {
				String [] dataS=transacoesC.get(i).getData().split("-");
				if(anoA.equals(dataS[0])& mesA.equals(dataS[1])& diaA.equals(dataS[2])) {
					if (transacoesC.get(i).getValor()<0) {
						diario=diario+transacoesC.get(i).getValor();
					}
				}
				else  return diario;
			}
			 return diario;
		 }
	
	 public Transacao  jurosMensais(String anoA,String mesA) {
		 // simplicado média (saldo final+saldo inicial)/2
			double totalInicio=saldo;
			double taxaJuro=0.05;
			
			for (int i=transacoesC.size()-1;i>=0;i--) {
				String [] dataS=transacoesC.get(i).getData().split("-");
				if(anoA.equals(dataS[0])& mesA.equals(dataS[1])) {

						totalInicio=totalInicio+transacoesC.get(i).getValor();
					
				}
				
			}
			double juros=(taxaJuro/12)*(saldo+totalInicio)/2;
			Transacao t = new Transacao(10002, anoA+"-"+mesA+"-"+"1", juros,"JUROS", 0,Transacao.TipoT.JUROS);
			addTransacaoC(t);
			  return t;
			
		 }
	 




}
