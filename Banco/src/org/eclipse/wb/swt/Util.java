package org.eclipse.wb.swt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class Util {

	public Util() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static  boolean estaVazio(Text texto) {
		if (texto.getText().equals("")) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return true;
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return false;
	}
	
	public static  boolean estaVazio(String[] mensagem,Text texto1,Text texto2) {
		if (texto1.getText().equals("")) {
			texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			if (texto2.getText().equals("")) {
				texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				mensagem [0] = mensagem[0]+"tem de introduzir o valor a Conta destino.\n";
				return true;
			}
			else {
				mensagem [0] = mensagem[0]+"tem de introduzir o valor a Conta destino.\n";
			return true;
			}
		}
		
		texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return false;
	}
	

	
	public static boolean eNumeroIouD(String[] mensagem,Text texto) {
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
				mensagem [0] = mensagem[0]+"tem de introduzir um valor Numerico absoluto (positivo).\n";
				return false;// "Invalid double";
			}	
		} else
			return true;
	}

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
	
	public static boolean eNumeroI(String[] mensagem,Text texto,int tamanho) {
		if (texto.getText().length()==tamanho) {
		for (char c : texto.getText().toCharArray()) {
			if (!Character.isDigit(c)) {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				mensagem [0] = mensagem[0]+"tem de introduzir um valor Numerico Inteiro.\n";
				return false;
			}
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return true;
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		mensagem [0] = mensagem[0]+"Tem valores com numero de carateres invalidos.\n";
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
