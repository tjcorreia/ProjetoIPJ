package org.eclipse.wb.swt;

import java.io.*;

/**
 * Classe 'FicheiroDeObjectos' com diversos métodos que auxiliam a leitura e 
 * escrita de ficheiros de objetos
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
@SuppressWarnings("serial")
public class FicheiroDeObjectos implements Serializable {
	/**
	 * Atributos da classe
	 */
	private ObjectInputStream iS;
	private ObjectOutputStream oS;


	/**
	 * Método para abrir a leitura de um ficheiro
	 * @param String nome do ficheiro
	 * @return boolean true se o ficheiro já existir, false no caso contrário
	 */
	public boolean abreLeitura(String nomeDoFicheiro) {
		try {
			iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
			return true;
		} catch (IOException e) {
			return false;
		}
	}


	/**
	 * Método para abrir um ficheiro para escrita
	 * @param String nome do ficheiro
	 */
	public void abreEscrita(String nomeDoFicheiro) throws IOException {
		oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
	}


	/**
	 * Método para ler um objecto de um ficheiro
	 * @param String nome do ficheiro
	 * @return Devolve objeto lido
	 */
	public Object leObjecto() throws IOException, ClassNotFoundException {
		return iS.readObject();
	}

	/**
	 * Método para escrever um objecto num ficheiro
	 * @param Recebe o objeto a escrever
	 * @return Devolve objeto lido
	 */
	public void escreveObjecto(Object o) throws IOException {
		oS.writeObject(o);
	}

	/**
	 * Método para fechar um ficheiro aberto em modo leitura
	 */
	public void fechaLeitura() throws IOException {
		System.out.printf("Serialized data esta Lida \n");
		iS.close();
	}

	/**
	 * Método para fechar um ficheiro aberto em modo escrita
	 */
	public void fechaEscrita() throws IOException {
		System.out.printf("Serialized data foi gravada \n");
		oS.close();
	}

}