package org.eclipse.wb.swt;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

/**
* Breve descrição do código
* Metodo Criado para colocar metodos utilitarios que se repentem
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
 *
 */
public class Util {

	public Util() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Devolve se a caixa de texto esta vazia
	 * @param texto
	 * @return true ou false e altera a cor de fundo para vermelho
			 */
	public static  boolean estaVazio(Text texto) {
		if (texto.getText().equals("")) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return true;
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return false;
	}
	/**
	 * Devolve se a caixa de texto esta vazia
	 * @param texto
	 * @param texto1
	 * @param texto2
	 * @param texto3
	 * @return true ou false e altera a cor de fundo para vermelho
	*/
	public static  boolean estaVazio(Text texto1,Text texto2,Text texto3) {
		if (estaVazio(texto1)|estaVazio(texto2)|estaVazio(texto3)) {
			return true;
		}
		return false;
	}
	/**
	 * Devolve se a caixa de texto esta vazia E mensagem de Erro
	 * @param String
	 * @param texto1
	 * @param texto2
	 * @return String com mensagem de erro e altera a cor de fundo para vermelho
	*/
	public static  boolean estaVazio(String mensagem,Text texto1,Text texto2) {
		if (texto1.getText().equals("")) {
			texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			if (texto2.getText().equals("")) {
				texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				mensagem  = mensagem+"tem de introduzir o valor a Conta destino.\n";
				return true;
			}
			else {
				mensagem  = mensagem+"tem de introduzir o valor a Conta destino.\n";
			return true;
			}
		}
		
		texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return false;
	}
	
	
	/**
	 * Verifica se a data esta dentro de um intrevalo em relação a data actual
	 * (entre dataactual-maximo e dataactual-minimo)
	 * @param data Data a Verificar
	 * @param idadeMinima valor minimo a retirar  
	 * @param idadeMaxima  valor maximo a retiar
	 * @return boolean verifica ou não
	*/
	
	public static  boolean verificaIdade (LocalDate data,int idadeMinima,int idadeMaxima){
		System.out.println("<---- NUMERO? --->\n" + data);
		System.out.println("<---- NUMERO? --->\n" + LocalDate.now().minusYears(idadeMinima));
		System.out.println("<---- NUMERO? --->\n" + LocalDate.now().minusYears(idadeMaxima));
		if (data.isAfter(LocalDate.now().minusYears(idadeMinima))) {
			return false;
		}
		if (data.isBefore(LocalDate.now().minusYears(idadeMaxima))) {
			return false;
		}
	return true;
	}
	
	/**
	 * Verifica se o numero é Double 
	 * @param mensagem Altera a mensagem se não verficar
	 * @param texto Elemento  verificar 
	 * @return boolean verifica ou não 
	*/
	public static boolean eNumeroIouD(String mensagem,Text texto) {
		System.out.println("<---- NUMERO? --->\n" + texto.getText());
		if ((eNumero(texto) == -1)) {
			System.out.println("<---- NÃO E NUMERO? --->\n");
			String numero = texto.getText();
//		("^\\+?\\[0-9]{0,5}?\\-?\\[0-9]{9}$"
//		Pattern regexPattern = Pattern.compile("^\\+?\\d{0,3}?\\d{9}$");
			Pattern regexPattern2 = Pattern.compile("[0-9]+(\\.){0,1}[0-9]*");
//        Matcher regMatcher   = regexPattern.matcher(mobileNumber);
			Matcher regMatcher2 = regexPattern2.matcher(numero);
			if (regMatcher2.matches()) {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				return true;// "Valid double";
			} else {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				System.out.println("<---- NÃO E DOUBLE? FALSE --->\n");
				mensagem  = mensagem+"tem de introduzir um valor Numerico absoluto (positivo).\n";
				return false;// "Invalid double";
			}	
		} else
			return true;
	}

	/**
	 * Verifica se o numero é um numero Inteiro
	 * @param texto valor minimo a retirar  
	 * @return boolean verifica ou não 
	*/
	public static int eNumero(Text texto) {
		for (char c : texto.getText().toCharArray()) {
			if (!Character.isDigit(c)) {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				return -1;
			}
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return texto.getText().length();
	}
	
	/**
	 * Verifica se o numero é um numero Inteiro e se tem um tamanho especifico
	 * @param mensagem Mensagem de retorno 
	 * @param texto 
	 * @param tamanho tamanho a verificar 
	 * @return boolean verifica ou não 
	*/
	public static boolean eNumeroI(String mensagem,Text texto,int tamanho) {
		if (texto.getText().length()==tamanho) {
		for (char c : texto.getText().toCharArray()) {
			if (!Character.isDigit(c)) {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				mensagem  = mensagem+"tem de introduzir um valor Numerico Inteiro.\n";
				return false;
			}
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return true;
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		mensagem = mensagem+"Tem valores com numero de carateres invalidos.\n";
		return false;
		
	}
	
	
	/**
	 * Verifica se o numero de Telemovel
	 * @param texto Texto com numero a validar
	 * @return boolean verifica ou não 
	*/
	public static boolean validateMobileNumber(Text texto) {
		String mobileNumber = texto.getText();
//		("^\\+?\\[0-9]{0,5}?\\-?\\[0-9]{9}$"
//		Pattern regexPattern = Pattern.compile("^\\+?\\d{0,3}?\\d{9}$");
		Pattern regexPattern2 = Pattern.compile("^\\d{0,5}?\\d{9}$");
		Matcher regMatcher2 = regexPattern2.matcher(mobileNumber);
		if (regMatcher2.matches()) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			return true;// "Valid Mobile Number";
		} else {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return false;// "Invalid Mobile Number";

		}
	}
	
	/**
	 * Verifica se o numero de Email
	 * @param texto Texto com email avalidar
	 * @return boolean verifica ou não 
	*/
	public static boolean validateEmail(Text texto) {
		String emailStr = texto.getText();
		Pattern regexPattern = Pattern.compile(
				"\\A[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z");
		Matcher regMatcher = regexPattern.matcher(emailStr);
		if (regMatcher.matches()) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			return true;// "Valid Email";
		} else {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return false;// "Invalid Email";
		}
	}
	
	/**
	 * Verifica se o numero é um numero Double e altera a cx texto
	 * @param texto 
	 * @return boolean verifica ou não 
	*/
	public static boolean eNumeroIouD(Text texto) {
		System.out.println("<---- NUMERO? --->\n" + texto.getText());
		if ((Util.eNumero(texto) == -1)) {
			System.out.println("<---- NÃO E NUMERO? --->\n");
			String numero = texto.getText();
//		("^\\+?\\[0-9]{0,5}?\\-?\\[0-9]{9}$"
//		Pattern regexPattern = Pattern.compile("^\\+?\\d{0,3}?\\d{9}$");
			Pattern regexPattern2 = Pattern.compile("[0-9]+(\\.){0,1}[0-9]*");
//        Matcher regMatcher   = regexPattern.matcher(mobileNumber);
			Matcher regMatcher2 = regexPattern2.matcher(numero);
			if (regMatcher2.matches()) {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				return true;// "Valid double";
			} else {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				System.out.println("<---- NÃO E DOUBLE? FALSE --->\n");
				return false;// "Invalid double";

			}
		} else
			return true;
	}
	
	/**
	 * Verifica Data quando é introduzida pelos campos Ano Mes Dia
	 * obs:deprecated 
	 * @param ano
	 * @param mês
	 * @param dia
	 * @return boolean verifica ou não 
	*/
	public static boolean validateData2(Text ano, Text mes, Text dia) {
//		new GregorianCalendar(2018, 10, 24);
		GregorianCalendar novoF = new GregorianCalendar();
		GregorianCalendar actual = new GregorianCalendar();
		GregorianCalendar actualMenos120 = new GregorianCalendar();
		actualMenos120 = (GregorianCalendar) GregorianCalendar.getInstance();
		actual = (GregorianCalendar) Calendar.getInstance();

		String dataStr = ano.getText() + "/" + mes.getText() + "/" + dia.getText();
		System.out.println(dataStr);
		Pattern regexPattern = Pattern.compile("^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$");
		Matcher regMatcher = regexPattern.matcher(dataStr);
		if (regMatcher.matches()) {
			
			System.out.println("Formato Correto");
			return true;// "Valid Data";
//			novoF.set(Integer.parseInt(texto1.getText()), Integer.parseInt(texto1.getText())
//					- 1, Integer.parseInt(texto1.getText()));
//			actualMenos120.add(Calendar.YEAR, -120);
//			SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
//			
//		
//			String dateFormatted = fmt.format(actual);
//			System.out.println(dateFormatted);
////			&& (novoF).compareTo(actualMenos120)==1
//			if ((novoF).compareTo(actual)==-1 ) {
//			
//			}
//			else {
//				texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
//				texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
//				texto3.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
//				return false;// "Invalid Data";
//			}
		} else {
			ano.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			mes.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			dia.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));

			return false;// "Invalid Data";
		}
	}	
	
	
	
}
