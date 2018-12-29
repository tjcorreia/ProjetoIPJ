package org.eclipse.wb.swt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Conta.TipoC;
import org.eclipse.wb.swt.Utilizador.TipoID;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/



public class Gestao {
	
	
	private Map<String, Utilizador> mapUtilizadores; // String Username
	private ArrayList<Conta> lContas;
	private Map<Integer, Integer> mapCartaoConta; // numcartaonumconta

public Gestao() {
	super();
	this.mapUtilizadores = new HashMap<String, Utilizador>();
	this.lContas = new ArrayList<Conta>();
	this.mapCartaoConta = new HashMap<Integer, Integer>();
	
	// Administradores
//	Administrador(int uID, String login, String password, String nome, String sobrenome, String dataNascimento,
//			String morada, TipoID escolhaID, int valorID, String email, int mobile)
	Administrador MachadoU= new  Administrador(1000, "Machado", "Admin", "Alberto","Machado0",
			"1977/07/17","Rua Maria Vitoria",Administrador.TipoID.CARTAOCIDADAO,"78456123","mail@gmail.com",965420735);
	
	Administrador CorreiaU= new  Administrador(1001, "Correia", "Admin","Tiago", "Coreia",
			"1977/07/30","Rua Maria Vitoria ",Administrador.TipoID.CARTAOCIDADAO,"12345678","mail@gmail.com",965420733);
	
	mapUtilizadores.put("Machado",MachadoU);
	mapUtilizadores.put("Correia",CorreiaU);
	
	// Funcionarios
	Funcionario MachadoFU= new  Funcionario(1002, "Maria", "Fun","Maria", "Machado0",
			"1977/07/30","Rua Maria Vitoria",Utilizador.TipoID.CARTAOCIDADAO,"78456123","mail1@gmail.com",965420730);
	
	Funcionario CorreiaFU= new  Funcionario(1003, "Correia2", "Fun","Tiago", "Coreia",
			"1977/07/30","Rua Maria Vitoria ",Utilizador.TipoID.CARTAOCIDADAO,"12345678","mail2@gmail.com",965420731);
	
	mapUtilizadores.put("Maria",MachadoFU);
	mapUtilizadores.put("Correia2",CorreiaFU);
	
	
	
	
	// Clientes
	
//	Utilizador(uID,login,password,nome,morada,escolhaID,valorID,email,mobile)
	
		Cliente cl1= new  Cliente(1004, "MCliente", "Cliente", "Alberto","Machado0",
				"1977/07/30","Rua Maria Vitoria",Administrador.TipoID.CARTAOCIDADAO,"78456123","mail",965420730);
		
		Cliente cl2= new  Cliente(1005, "CCliente", "Cliente", "Tiago","Coreia",
				"1977/07/30","Rua Maria Vitoriazfgadfgadfgsdfgsdfg",Administrador.TipoID.CARTAOCIDADAO,"12345678","mail",965420730);
		mapUtilizadores.put("MCliente",cl1);
		mapUtilizadores.put("CCliente",cl2);
		
		
		
		
		
		
	
	// Contas 
	
	ContaNormal cn1= new ContaNormal(1,1500);
	cn1.getClientesDaC().add(1004);
	ContaNormal cn2= new ContaNormal(2,2500);
	cn1.getClientesDaC().add(1005);
	lContas.add(cn1);
	lContas.add(cn2);
	
	
}


public Map<String, Utilizador> getMapUtilizadores() {
	return mapUtilizadores;
}


public void setMapUtilizadores(Map<String, Utilizador> mapUtilizadores) {
	this.mapUtilizadores = mapUtilizadores;
}


public ArrayList<Conta> getlContas() {
	return lContas;
}


public void setlContas(ArrayList<Conta> lContas) {
	this.lContas = lContas;
}


public Map<Integer, Integer> getMapCartaoConta() {
	return mapCartaoConta;
}


public void setMapCartaoConta(Map<Integer, Integer> mapCartaoConta) {
	this.mapCartaoConta = mapCartaoConta;
}

public void Gerir() {
	J_10Login novoLogin = new J_10Login ();

	Utilizador aprovado=new Utilizador();
	do {
		
		novoLogin.open();
		aprovado=novoLogin.utilizadorAprovado();
	} while (aprovado==null);
	
	System.out.println("passou ->>"+novoLogin.utilizadorAprovado().nome);
	if (aprovado instanceof Administrador) {
	J_01_Administrador novaJAdmin= new J_01_Administrador(aprovado);
		novaJAdmin.open();
		
	}
}


	
 //// faz a verificação das entradas do login
 public Utilizador  verfLogin(String username, String passwordV) {
     
     if (mapUtilizadores.containsKey(username)) {
    	 if (mapUtilizadores.get(username).password.equals(passwordV)) {       	 
             return mapUtilizadores.get(username);
         }
     }
     return null;
 }
 
//faz a verificação da adicção de um do novo funcionario
public String  verificanovoF(TipoID escolhadaIDN,Text valorID_NovoF,Text email_NovoF,Text userNovoF,Text mobileNovoF) { 
	
	
	
	
	
	valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
 String  verifica ="";
 // verifica username
	if (mapUtilizadores.containsKey(userNovoF.getText())) {
		verifica =verifica +"O nome de Utilizador não é válido./n";
		userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}
	
	for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
		if (entry.getValue() instanceof Funcionario) {
			
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			Scanner sc = new Scanner(System.in);
			String  vAr = sc.nextLine();
			
			sc.close();
			 // verifica identificação
		if (entry.getValue().escolhaID.equals(escolhadaIDN) && entry.getValue().valorID.equals(valorID_NovoF)) {
			verifica = verifica+"O "+escolhadaIDN+" com o numero :"+valorID_NovoF+" já está associado a um Funcionario. /n";
			valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}
		
		else if  (!entry.getValue().escolhaID.equals(escolhadaIDN) && entry.getValue().valorID.equals(valorID_NovoF)) {
			if (escolhadaIDN.equals(TipoID.CARTAOCIDADAO)) {
			verifica =verifica+" numero :"+valorID_NovoF+" já existe e está associado ao Passaporte. /n";
		}
			else {
				verifica =verifica+" numero :"+valorID_NovoF+" já existe e está associado ao Cartão de Cidadão. /n";
			}
			valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			}
		
		// verifica email
		if (entry.getValue().email.equals(email_NovoF)) {
			verifica =verifica+"Já existe um utilizador com este email/n";
			email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}
//			// verifica telemovel
		if (entry.getValue().email.equals(mobileNovoF)) {
			verifica =verifica+"Já existe um utilizador com este contacto de telemovel /n";
			mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}
		}
	}
	System.out.println((verifica));
 return verifica;
}

 
public boolean eUmNumero(String texto)
{
    for (char c : texto.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;
} 
 

 
//*********************************************************************************
////	********** Adiciona Cliente **************
//	public Cliente addCliente(Cliente novoC) {
//		novoC.setClienteID(lClientes.get(lClientes.size() - 1).getClienteID() + 1);
//		lClientes.add(novoC);
//		return novoC;
//	}
//
////	********** Adiciona nova reserva **************
//
//	public void addReserva(Reservas novoR) {
//		novoR.setrID(lReservasgeral.get(lReservasgeral.size() - 1).getrID() + 1);
//		lReservasgeral.add(novoR);
//		
//	}
//	
////	********** Altera reserva **************
//
//	public Reservas alteraReserva(int rID,Reservas alteraR) {
//		int indice=0;
//		for (int i = 0; i < lReservasgeral.size(); i++) {
//			if ((lReservasgeral.get(i)).getrID() == (rID)) {
//				indice=i;break;
//			}
//		}
//		lReservasgeral.set(indice, alteraR);
//		return lReservasgeral.get(indice);
//	}
//
////	********** Altera reserva **************
//
//	public void apagaReserva(int rID) {
//		int indice=0;
//		for (int i = 0; i < lReservasgeral.size(); i++) {
//			if ((lReservasgeral.get(i)).getrID() == (rID)) {
//				indice=i;break;
//			}
//		}
//		lReservasgeral.remove(indice);
//		
//	}
//
////	********** Pesquisa Reserva por ID **************
//
//	public Reservas pesquisaReserva(int rID) {
//		for (int i = 0; i < lReservasgeral.size(); i++) {
//			if ((lReservasgeral.get(i)).getrID() == (rID)) {
//				return lReservasgeral.get(i);
//			}
//		}
//		return null;
//
//	}
//	
//
//
////	********** Pesquisa Cliente por ID **************
//	public Cliente pesquisaCliente(int cID) {
//
//		for (int i = 0; i < lClientes.size(); i++) {
//			if ((lClientes.get(i)).clienteID == (cID)) {
//				return lClientes.get(i);
//			}
//		}
//		return null;
//	}
//
////	********** Pesquisa Cliente por localizacao **************
//	public Cliente pesquisaClienteL(int cIL) {
//
//		return lClientes.get(cIL);
//
//	}
//
////	********** muda dados Cliente por ID **************
//	public int mudadadosCliente(int cID, Cliente c) {
//		int i = 0;
//		for (i = 0; i < lClientes.size(); i++) {
//			if ((lClientes.get(i)).clienteID == (cID)) {
//				lClientes.set(i, c);
//				return i;
//			}
//		}
//		return i = -1;
//	}
//
////	********** Pesquisa Quarto por ID **************
//
//	public Quarto pesquisaQuarto(int qID) {
//
//		for (int i = 0; i < lQuartos.size(); i++) {
//			if ((lQuartos.get(i)).getnQ() == (qID)) {
//				return lQuartos.get(i);
//			}
//		}
//		return null;
//	}
//
////	********** Verifica Quartos livres para a data **************
//	public boolean verfData(int nQ, GregorianCalendar gfc, int nD) {
//		String lqv = "Lista de Quartos vagos:";
//		int k;
//		boolean qOK = false;
//
//		for (int i = 0; i < mapQR.size(); i++) {
//			qOK = false;
//			System.out.println("verfica novo Quarto ****  " + i);
//			k = lQuartos.get(i).getnQ();
//			System.out.println(k);
//			System.out.println(mapQR.get(k).toString());
//			System.out.println(mapQR.get(k).size());
//			System.out.println("****");
//			if (mapQR.get(k).size() != 0) {
//				for (int j = 0; j < mapQR.get(k).size(); j++) {
//
//					mapQR.get(k).get(j).getrDate();
//					System.out.println("**passo ao 2nd**");
//					System.out.println("" + format(mapQR.get(k).get(j).getrDate()));
//					System.out.println("" + mapQR.get(k).get(j).getrDias());
//					System.out.println("" + format(gfc));
//					System.out.println("" + nD);
//					boolean verf = compaDt(mapQR.get(k).get(j).getrDate(), mapQR.get(k).get(j).getrDias(), gfc, nD);
//					System.out.println(verf);
//
//					if (verf) {
//						qOK = true;
//						System.out.println("**passou *" + j);
//					} else {
//						qOK = false;
//						System.out.println("** NAO passou " + j);
//						j = mapQR.get(k).size();
//					}
//				}
//				
//				if (qOK) {
//					lqv = lqv + " Q: " + k;
//				}
//
//			} 
//			else {
//				lqv = lqv + " Q: " + k;
//			}
//			System.out.println("Passou " + lqv);
//		}
//		System.out.println(lqv);
//		if (lqv.equalsIgnoreCase("Lista de Quartos vagos:")) {
//			return false;
//		}
//		return true;
//	}
//
////	********** compara idade**************	
//	public boolean compaDt(GregorianCalendar d1, int nD1, GregorianCalendar d2, int nD2) {
//		boolean verifica = false;
//		int r, r1, r2, r3;
//		r = d1.compareTo(d2);
//		GregorianCalendar d1f = (GregorianCalendar) d1.clone();
//		GregorianCalendar d2f = (GregorianCalendar) d2.clone();
//		d1f.add(Calendar.DAY_OF_MONTH, nD1);
//		d2f.add(Calendar.DAY_OF_MONTH, nD2);
//
//		r1 = (d1f).compareTo(d2);
//
//		r2 = (d1).compareTo(d2f);
//		if ((r2 == 1 || r2 == 0)) {
//			verifica = true;
//		} else if ((r1 == 0 || r1 == -1)) {
//			verifica = true;
//		}
//		return verifica;
//
//	}
//
//	public String format(GregorianCalendar calendar) {
//		SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
//		fmt.setCalendar(calendar);
//		String dateFormatted = fmt.format(calendar.getTime());
//		return dateFormatted;
//	}
// 
 
 
}
