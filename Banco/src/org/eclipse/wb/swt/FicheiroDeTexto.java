package org.eclipse.wb.swt;

import java.io.*;

/**
* Breve descri��o do c�digo
* Classe conta
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
* 
*/
public class FicheiroDeTexto {
	private BufferedReader fR;
	private BufferedWriter fW;

	public void abreLeitura(String nomeDoFicheiro) throws IOException
	{
		fR = new BufferedReader(new FileReader(nomeDoFicheiro));
	}
	
	public void abreEscrita(String nomeDoFicheiro) throws IOException
	{
		fW = new BufferedWriter(new FileWriter(nomeDoFicheiro));
	}

//M�todo para ler uma linha do ficheiro
//Devolve a linha lida
	public String leLinha() throws IOException 
	{
		return fR.readLine();
	}

	//M�todo para ler um n�mero do ficheiro
	//Devolve o n�mero lido
	public int[] leNumeroInt() throws IOException  {
		int[] result = new int[2];
		String st = fR.readLine();
		if (st != null) {
			result[0] = 0;
			result[1] = Integer.parseInt(st);
		} else {
			result[0] = -1;}
		return result;
	}
	
	//M�todo para escrever uma linha no ficheiro
	//Recebe a linha a escrever
	public void escreveLinha(String linha) throws IOException
	{
		fW.write(linha,0,linha.length());
		fW.newLine();
	}

	//M�todo para escrever um n�mero inteiro no ficheiro
	//Recebe o n�mero a escrever
	public void escreveNumero(int num) throws IOException
	{
		String st = "";
		st = st.valueOf(num);
		escreveLinha(st);
	}

	//M�todo para fechar um ficheiro aberto em modo leitura
	public void fechaLeitura() throws IOException {
		fR.close();
	}

	//M�todo para fechar um ficheiro aberto em modo escrita
	public void fechaEscrita() throws IOException {
		fW.close();
	}

}
