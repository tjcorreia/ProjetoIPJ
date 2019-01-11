package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_01_Admin_NovoF {

	protected Shell shell;
	private Text text;
	private Utilizador uAdministrador;
	private Gestao gestor;
	private Text text_PrimeiroNovoF;
	private Text text_Morada_NovoF;
	private Text text_ValorID_NovoF;
	private Text text_Email_NovoF;
	private Text text_MobileNovoF;
	private Text text_UserNovoF;
	private Text text_PassNovoF;
	private Text text_PosicaoNovoF;
	private Text text_UltimoNovoF;
	private Text text_DataN_Ano;
	private Text text_DataN_mes;
	private Text text_DataN_dia;

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	public Utilizador getuAdministrador() {
		return uAdministrador;
	}

	public void setuAdministrador(Utilizador uAdministrador) {
		this.uAdministrador = uAdministrador;
	}

	public J_01_Admin_NovoF(Gestao gestor, Utilizador uAdministrador) {

		this.uAdministrador = uAdministrador;

		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_01_Admin_NovoF window = new J_01_Admin_NovoF(new Gestao(),new Utilizador());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(651, 408);
		shell.setText("MENU ADMINISTRADOR");
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shell.setImage((Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo.png"));

		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(182, 10, 362, 25);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(182, 41, 430, 301);

		composite.setVisible(true);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(10, 104, 70, 15);
		lblNewLabel.setText("Identifica\u00E7ao");

		Label Nome_novoF = new Label(composite, SWT.NONE);
		Nome_novoF.setBounds(10, 47, 55, 15);
		Nome_novoF.setText("Nome");

		text_PrimeiroNovoF = new Text(composite, SWT.BORDER);
		text_PrimeiroNovoF.setBounds(81, 44, 163, 21);

		Label lblMoradaNovoF = new Label(composite, SWT.NONE);
		lblMoradaNovoF.setText("Morada");
		lblMoradaNovoF.setBounds(10, 75, 55, 15);

		text_Morada_NovoF = new Text(composite, SWT.BORDER);
		text_Morada_NovoF.setBounds(81, 72, 339, 21);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };
		Combo TipoID_NovoF = new Combo(composite, SWT.NONE);
		TipoID_NovoF.setItems(comboB);
		TipoID_NovoF.select(0);
		TipoID_NovoF.setBounds(81, 99, 121, 23);

		text_ValorID_NovoF = new Text(composite, SWT.BORDER);
		text_ValorID_NovoF.setBounds(208, 101, 212, 21);

		Label lblEmail_novoF = new Label(composite, SWT.NONE);
		lblEmail_novoF.setText("Email");
		lblEmail_novoF.setBounds(10, 131, 55, 15);

		text_Email_NovoF = new Text(composite, SWT.BORDER);
		text_Email_NovoF.setBounds(81, 128, 339, 21);

		Label lblContacto = new Label(composite, SWT.NONE);
		lblContacto.setText("Contacto");
		lblContacto.setBounds(10, 165, 55, 15);

		text_MobileNovoF = new Text(composite, SWT.BORDER);
		text_MobileNovoF.setBounds(81, 162, 88, 21);

		Label lblNomeDeUtilizador = new Label(composite, SWT.NONE);
		lblNomeDeUtilizador.setText("Utilizador");
		lblNomeDeUtilizador.setBounds(10, 192, 55, 15);

		text_UserNovoF = new Text(composite, SWT.BORDER);
		text_UserNovoF.setBounds(81, 189, 121, 21);

		Label lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setText("Password");
		lblPassword.setBounds(228, 192, 55, 15);

		text_PassNovoF = new Text(composite, SWT.BORDER);
		text_PassNovoF.setBounds(289, 189, 131, 21);

		Label Titulo_Novo_F = new Label(composite, SWT.NONE);
		Titulo_Novo_F.setAlignment(SWT.CENTER);
		Titulo_Novo_F.setBounds(81, 2, 322, 15);
		Titulo_Novo_F.setText("Dados do Novo Funcionario");

		Label lblPosio = new Label(composite, SWT.NONE);
		lblPosio.setText("Posi\u00E7\u00E3o");
		lblPosio.setBounds(10, 226, 55, 15);

		text_PosicaoNovoF = new Text(composite, SWT.BORDER);
		text_PosicaoNovoF.setBounds(81, 223, 88, 21);

		Button criarNovoF = new Button(composite, SWT.MULTI | SWT.WRAP | SWT.NONE);

		criarNovoF.setBounds(289, 233, 103, 58);
		criarNovoF.setText("Guardar\nNovo Funcionario");

		text_UltimoNovoF = new Text(composite, SWT.BORDER);
		text_UltimoNovoF.setBounds(250, 44, 170, 21);

		Label lblprimeiro = new Label(composite, SWT.NONE);
		lblprimeiro.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblprimeiro.setText("(primeiro)");
		lblprimeiro.setBounds(125, 29, 55, 15);

		Label lblultimo = new Label(composite, SWT.NONE);
		lblultimo.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblultimo.setText("(ultimo)");
		lblultimo.setBounds(302, 29, 55, 15);

		Label lblDataNas = new Label(composite, SWT.NONE);
		lblDataNas.setText("Data Nas.(aaaa/mm/dd)");
		lblDataNas.setBounds(175, 165, 132, 15);

		text_DataN_Ano = new Text(composite, SWT.BORDER);
		text_DataN_Ano.setBounds(313, 164, 40, 21);

		text_DataN_mes = new Text(composite, SWT.BORDER);
		text_DataN_mes.setBounds(363, 164, 23, 21);

		Label label = new Label(composite, SWT.NONE);
		label.setText("/");
		label.setBounds(355, 167, 8, 15);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("/");
		label_1.setBounds(387, 167, 8, 15);

		text_DataN_dia = new Text(composite, SWT.BORDER);
		text_DataN_dia.setBounds(395, 164, 23, 21);

		Button btnAlterarDadosPessoais = new Button(shell, SWT.NONE);
		btnAlterarDadosPessoais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_Admin_AlteraDados alteraDados=new J_01_Admin_AlteraDados(gestor,uAdministrador);
				alteraDados.open();
				
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados pessoais");
		btnAlterarDadosPessoais.setBounds(10, 205, 154, 25);

		Button button_Logout = new Button(shell, SWT.NONE);
		button_Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();	
			}
		});
		button_Logout.setText("Log Out");
		button_Logout.setBounds(550, 10, 75, 25);;;
		
		// JA_BT1.0 Botao Criar novo Funcionario.
		criarNovoF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				boolean verificatudo = true;
				
				String NomeNovoF = text_PrimeiroNovoF.getText();
				String Morada_NovoF = text_Morada_NovoF.getText();
				String ValorID_NovoF = text_ValorID_NovoF.getText();
				String Email_NovoF = text_Email_NovoF.getText();
				String MobileNovoF = text_MobileNovoF.getText();
				String UserNovoF = text_UserNovoF.getText();
				String PassNovoF = text_PassNovoF.getText();
				String PosicaoNovoF = text_PosicaoNovoF.getText();

				System.out.println(NomeNovoF);
				System.out.println(Morada_NovoF);
				System.out.println(ValorID_NovoF);
				System.out.println(Email_NovoF);
				System.out.println(MobileNovoF);
				System.out.println(UserNovoF);
				System.out.println(PassNovoF);
				System.out.println(PosicaoNovoF);
				System.out.println("-------->");

				String mensagem = "";
				boolean naohaDadosPorPreencher = true;
				// Verifica campos vazios
				if (estaVazio(text_PrimeiroNovoF) || estaVazio(text_UltimoNovoF) || estaVazio(text_Morada_NovoF)
						|| estaVazio(text_ValorID_NovoF) || estaVazio(text_Email_NovoF) || estaVazio(text_MobileNovoF)
						|| estaVazio(text_DataN_Ano) || estaVazio(text_DataN_mes) || estaVazio(text_DataN_dia)
						|| estaVazio(text_UserNovoF) || estaVazio(text_PassNovoF)) {
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					Titulo_Novo_F.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
					mensagem = mensagem + "Tem dados por preencher\n";

					estaVazio(text_UltimoNovoF);
					estaVazio(text_PrimeiroNovoF);
					estaVazio(text_Morada_NovoF);
					estaVazio(text_ValorID_NovoF);
					estaVazio(text_Email_NovoF);
					estaVazio(text_MobileNovoF);
					estaVazio(text_DataN_Ano);
					estaVazio(text_DataN_mes);
					estaVazio(text_DataN_dia);
					estaVazio(text_UserNovoF);
					estaVazio(text_PassNovoF);
					naohaDadosPorPreencher = false;

				}

				if (TipoID_NovoF.getText().equals("Cartao Cidadao")&& !estaVazio(text_ValorID_NovoF)) {
					if (eNumero(text_ValorID_NovoF) == -1) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº CC inválido .\n";
						System.out.println("VERIFICACAO DE numeros CC");
						naohaDadosPorPreencher = false;
					} else if (eNumero(text_ValorID_NovoF) != 8 && eNumero(text_ValorID_NovoF) != -1) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº Cartao Cidadao inválido\n";

						mensagem = mensagem + ".\n";
						System.out.println("VERIFICACAO DE CC");
						naohaDadosPorPreencher = false;
					}
				} else if (TipoID_NovoF.getText().equals("Passaporte")) {
					/// falta verificar tamanho de passaporte
					if (text_ValorID_NovoF.getText().length() < 8 || text_ValorID_NovoF.getText().length() > 10) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº Passaporte inválido .\n";
						System.out.println("VERIFICACAO DE Passaporte");
						naohaDadosPorPreencher = false;
					}

				}
				
				
				if (!validateData2(text_DataN_Ano,text_DataN_mes,text_DataN_dia) ) {
					System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoF.getText());
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Data de Nascimento inválida.\n";
					naohaDadosPorPreencher = false;

				}
				
				
				
				
				if (!validateMobileNumber(text_MobileNovoF)) {
					System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoF.getText());
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Contacto inválido.\n";
					naohaDadosPorPreencher = false;

				}

				if (!validateEmail(text_Email_NovoF)) {
					System.out.println("VERIFICACAO DE Email ->" + text_Email_NovoF.getText());
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Email inválido.\n";
					naohaDadosPorPreencher = false;
				}

				if (naohaDadosPorPreencher) {
					TipoID escolhadaID = Funcionario.TipoID.PASSAPORTE;
					if (TipoID_NovoF.getText().equals("Passaporte")) {
						escolhadaID = Funcionario.TipoID.PASSAPORTE;
					} else {
						escolhadaID = Funcionario.TipoID.PASSAPORTE;
					}
					
									String verifica = gestor.verificanovoF(
							escolhadaID,text_ValorID_NovoF,text_Email_NovoF,text_UserNovoF,text_MobileNovoF);
//					
					
//					System.out.println(Arrays.toString(verifica));
//					for (int i = 0; i < verifica.length; i++) {
//						textofinal = textofinal + verifica[i];
//						if (!verifica[i].equals("")) {
//							verificatudo = false;
//						}
									System.out.println(("VERIFICA? --->"+verifica));
									
					if (verifica.equals("")) {
					Funcionario f=new Funcionario();
					
					String dataStr = text_DataN_Ano.getText()+"/"+text_DataN_mes.getText()+"/"+text_DataN_dia.getText();
					gestor.addNovoF(text_UserNovoF.getText(),text_PassNovoF.getText(),
								text_PrimeiroNovoF.getText(),text_UltimoNovoF.getText(), dataStr,
								text_Morada_NovoF.getText(), escolhadaID,text_ValorID_NovoF.getText(),
								text_Email_NovoF.getText(),Integer.parseInt(text_MobileNovoF.getText()),
								text_PosicaoNovoF.getText());
						
						MessageBox box = new MessageBox(shell, SWT.MULTI);
					f=(Funcionario)(gestor.getMapUtilizadores().get(text_UserNovoF.getText()));
						box.setText("CONCLUSÃO");
						box.setMessage(" O Funcionario"+f.getNome()+" "
									+f.getSobrenome()+" foi adicionado\n"+
										"Morada:"+f.getMorada()+"\n"+
										""+f.escolhaID.toString()+":"+f.getValorID()+"\n"+
										"Email:"+f.getEmail()+"\n"+
										"Contacto:"+f.getMobile()+"\n"+
										"Data Nascimento:"+f.getDataNascimento()+"\n"+
										"Posição:"+f.getPosicao());
//						
						box.open();
						System.out.println(("verifica"));
						
					}
					else {
						System.out.println(("----> Nao verifica"));
						verifica="Dados por  inválidos:/n"+verifica;
						MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage(verifica);
						box.open();
						Composite composite10 = new Composite(shell, SWT.NONE);
						composite10.setBounds(182, 41, 430, 301);
					}
					
					
					

				} else {
					MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
					box.setText("ERRO");
					box.setMessage(mensagem);
					box.open();
					Composite composite10 = new Composite(shell, SWT.NONE);
					composite10.setBounds(182, 41, 430, 301);
					naohaDadosPorPreencher = true;
				}

			}
		});
		Button Novo_Funcionario = new Button(shell, SWT.NONE);

		
		Novo_Funcionario.setText("Novo Funcionario");
		Novo_Funcionario.setBounds(10, 141, 154, 25);

// *****// JA_BT2.0 Botao para ver Lista de Cliente.
		Button Lista_Clientes = new Button(shell, SWT.NONE);
		Lista_Clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				shell.dispose();
				J_01_AdminLClientes novaLista=new J_01_AdminLClientes(gestor,uAdministrador);
				novaLista.open();
				
				
			}
		});
		
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 174, 154, 25);

	}

	public boolean estaVazio(Text texto) {

		if (texto.getText().equals("")) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return true;
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return false;
	}

	public int eNumero(Text texto) {
		for (char c : texto.getText().toCharArray()) {
			if (!Character.isDigit(c)) {
				texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				return -1;
			}
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return texto.getText().length();
	}

	public boolean validateMobileNumber(Text texto) {
		String mobileNumber = texto.getText();
//		("^\\+?\\[0-9]{0,5}?\\-?\\[0-9]{9}$"
//		Pattern regexPattern = Pattern.compile("^\\+?\\d{0,3}?\\d{9}$");
		Pattern regexPattern2 = Pattern.compile("^\\d{0,5}?\\d{9}$");
//        Matcher regMatcher   = regexPattern.matcher(mobileNumber);
		Matcher regMatcher2 = regexPattern2.matcher(mobileNumber);
		if (regMatcher2.matches()) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			return true;// "Valid Mobile Number";
		} else {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return false;// "Invalid Mobile Number";

		}
	}

//	\A[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\z
//	Regex : ^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$

	public boolean validateEmail(Text texto) {
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

	public boolean validateData2(Text texto1,Text texto2,Text texto3) {
//		new GregorianCalendar(2018, 10, 24);
		GregorianCalendar novoF= new GregorianCalendar();
		GregorianCalendar actual= new GregorianCalendar();
		GregorianCalendar actualMenos120= new GregorianCalendar();
		actualMenos120=(GregorianCalendar) GregorianCalendar.getInstance();
		actual=(GregorianCalendar) Calendar.getInstance();
		
		
		String dataStr = texto1.getText()+"/"+texto2.getText()+"/"+texto3.getText();
		System.out.println(dataStr);
		Pattern regexPattern = Pattern.compile(
				"^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$");
		Matcher regMatcher = regexPattern.matcher(dataStr);
		if (regMatcher.matches()) {
			texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			texto3.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
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
			texto1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			texto2.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			texto3.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			
			return false;// "Invalid Data";
		}
	}
	
	

}
