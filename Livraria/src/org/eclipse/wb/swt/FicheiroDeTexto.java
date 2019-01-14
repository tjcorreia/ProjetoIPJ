package org.eclipse.wb.swt;

import java.io.*;

/**
 * Classe 'FicheiroDeTexto' com diversos m�todos que auxiliam a leitura e 
 * escrita de ficheiros de texto
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class FicheiroDeTexto implements Serializable {
	/**
	 * Atributos da classe
	 */
	private BufferedReader fR;
	private BufferedWriter fW;

	/**
	 * M�todo para abrir a leitura de um ficheiro
	 * @param String nome do ficheiro
	 */
	public void abreLeitura(String nomeDoFicheiro) throws IOException
	{
		fR = new BufferedReader(new FileReader(nomeDoFicheiro));
	}
	
	/**
	 * M�todo para abrir um ficheiro para escrita
	 * @param String nome do ficheiro
	 */
	public void abreEscrita(String nomeDoFicheiro) throws IOException
	{
		fW = new BufferedWriter(new FileWriter(nomeDoFicheiro));
	}

	/**
	 * M�todo para ler uma linha do ficheiro
	 * @return Devolve a linha lida em String
	 */
	public String leLinha() throws IOException 
	{
		return fR.readLine();
	}

	/**
	 * M�todo para ler um n�mero do ficheiro
	 * @return Devolve o n�mero lido
	 */
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
	
	/**
	 * M�todo para escrever uma linha no ficheiro
	 * @param Recebe a linha a escrever
	 */
	public void escreveLinha(String linha) throws IOException
	{
		fW.write(linha,0,linha.length());
		fW.newLine();
	}

	/**
	 * M�todo para escrever um n�mero inteiro no ficheiro
	 * @param Recebe o n�mero a escrever
	 */
	public void escreveNumero(int num) throws IOException
	{
		String st = "";
		st = String.valueOf(num);
		escreveLinha(st);
	}

	
	/**
	 * M�todo para fechar um ficheiro aberto em modo leitura
	 */
	public void fechaLeitura() throws IOException {
		fR.close();
	}

	/**
	 * M�todo para fechar um ficheiro aberto em modo de escrita
	 */
	public void fechaEscrita() throws IOException {
		fW.close();
	}
}
