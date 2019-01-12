package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;

/**
 * Breve descri��o do c�digo
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_CriaCliente {

	protected Shell shellMF;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Text Funcionario;
	private Text text_PrimeiroNovoC;
	private Text text_MoradaNovoC;
	private Text text_ValorID_NovoC;
	private Text text_Email_NovoC;
	private Text text_MobileNovoC;
	private Text text_UserNovoC;
	private Text text_PassNovoC;
	private Text text_DataN_Ano;
	private Text text_DataN_mes;
	private Text text_DataN_dia;
	private Text text_UltimoNovoC;

	

	public Text getText_UltimoNovoC() {
		return text_UltimoNovoC;
	}
	public void setText_UltimoNovoC(Text text_UltimoNovoC) {
		this.text_UltimoNovoC = text_UltimoNovoC;
	}
	public Shell getShellMF() {
		return shellMF;
	}
	public void setShellMF(Shell shellMF) {
		this.shellMF = shellMF;
	}
	public Gestao getGestor() {
		return gestor;
	}
	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}
	public Utilizador getuUtilizador() {
		return uUtilizador;
	}
	public void setuUtilizador(Utilizador uUtilizador) {
		this.uUtilizador = uUtilizador;
	}
	public Text getFuncionario() {
		return Funcionario;
	}
	public void setFuncionario(Text funcionario) {
		Funcionario = funcionario;
	}

	
	public Cliente getClienteActual() {
		return clienteActual;
	}
	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}
	public Text getText_PrimeiroNovoC() {
		return text_PrimeiroNovoC;
	}
	public void setText_PrimeiroNovoC(Text text_PrimeiroNovoC) {
		this.text_PrimeiroNovoC = text_PrimeiroNovoC;
	}
	public Text getText_MoradaNovoC() {
		return text_MoradaNovoC;
	}
	public void setText_MoradaNovoC(Text text_MoradaNovoC) {
		this.text_MoradaNovoC = text_MoradaNovoC;
	}
	public Text getText_ValorID_NovoC() {
		return text_ValorID_NovoC;
	}
	public void setText_ValorID_NovoC(Text text_ValorID_NovoC) {
		this.text_ValorID_NovoC = text_ValorID_NovoC;
	}
	public Text getText_Email_NovoC() {
		return text_Email_NovoC;
	}
	public void setText_Email_NovoC(Text text_Email_NovoC) {
		this.text_Email_NovoC = text_Email_NovoC;
	}
	public Text getText_MobileNovoC() {
		return text_MobileNovoC;
	}
	public void setText_MobileNovoC(Text text_MobileNovoC) {
		this.text_MobileNovoC = text_MobileNovoC;
	}
	public Text getText_UserNovoC() {
		return text_UserNovoC;
	}
	public void setText_UserNovoC(Text text_UserNovoC) {
		this.text_UserNovoC = text_UserNovoC;
	}
	public Text getText_PassNovoC() {
		return text_PassNovoC;
	}
	public void setText_PassNovoC(Text text_PassNovoC) {
		this.text_PassNovoC = text_PassNovoC;
	}
	public Text getText_DataN_Ano() {
		return text_DataN_Ano;
	}
	public void setText_DataN_Ano(Text text_DataN_Ano) {
		this.text_DataN_Ano = text_DataN_Ano;
	}
	public Text getText_DataN_mes() {
		return text_DataN_mes;
	}
	public void setText_DataN_mes(Text text_DataN_mes) {
		this.text_DataN_mes = text_DataN_mes;
	}
	public Text getText_DataN_dia() {
		return text_DataN_dia;
	}
	public void setText_DataN_dia(Text text_DataN_dia) {
		this.text_DataN_dia = text_DataN_dia;
	}
	
	public J_02Menu_F_CriaCliente(Gestao gestor, Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		
	
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_CriaCliente() {
	
		open();
		// TODO Auto-generated constructor stub
	}
	

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shellMF.open();
		shellMF.layout();
		while (!shellMF.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellMF = new Shell();
		shellMF.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
	shellMF.setImage((Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo.png"));
		shellMF.setSize(707, 533);
		shellMF.setText("Menu Funcion\u00E1rio");
		

		Button btnNovoCliente = new Button(shellMF, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

//				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
//				alteraDados.open();
				shellMF.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnListarClientes = new Button(shellMF, SWT.NONE);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_ListaClientes listaC= new J_02Menu_F_ListaClientes(gestor, uUtilizador);
				listaC.open();
				
				
			}
		});
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 115, 192, 25);

		Button btnAlterarLoginE = new Button(shellMF, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);

		Button button = new Button(shellMF, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shellMF, SWT.BORDER);
		Funcionario.setText("Bem Vindo " + uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);

		Composite composite = new Composite(shellMF, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 301);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Identifica\u00E7ao");
		label.setBounds(10, 104, 70, 15);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Nome");
		label_1.setBounds(10, 47, 55, 15);

		text_PrimeiroNovoC = new Text(composite, SWT.BORDER);
		text_PrimeiroNovoC.setBounds(81, 44, 163, 21);

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("Morada");
		label_2.setBounds(10, 75, 55, 15);

		text_MoradaNovoC = new Text(composite, SWT.BORDER);
		text_MoradaNovoC.setBounds(81, 72, 339, 21);

		Combo combo_TipoID_NovoC = new Combo(composite, SWT.NONE);
		combo_TipoID_NovoC.setItems(new String[] { "Cartao Cidadao", "Passaporte" });
		combo_TipoID_NovoC.setBounds(81, 99, 121, 23);
		combo_TipoID_NovoC.select(0);

		text_ValorID_NovoC = new Text(composite, SWT.BORDER);
		text_ValorID_NovoC.setBounds(208, 101, 212, 21);

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("Email");
		label_3.setBounds(10, 131, 55, 15);

		text_Email_NovoC = new Text(composite, SWT.BORDER);
		text_Email_NovoC.setBounds(81, 128, 339, 21);

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("Contacto");
		label_4.setBounds(10, 165, 55, 15);

		text_MobileNovoC = new Text(composite, SWT.BORDER);
		text_MobileNovoC.setBounds(81, 162, 88, 21);

		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setText("Utilizador");
		label_5.setBounds(10, 192, 55, 15);

		text_UserNovoC = new Text(composite, SWT.BORDER);
		text_UserNovoC.setBounds(81, 189, 121, 21);

		Label label_6 = new Label(composite, SWT.NONE);
		label_6.setText("Password");
		label_6.setBounds(228, 192, 55, 15);

		text_PassNovoC = new Text(composite, SWT.BORDER);
		text_PassNovoC.setBounds(289, 189, 131, 21);

		Label lbl_Titulo_DadosDoNovo = new Label(composite, SWT.NONE);
		lbl_Titulo_DadosDoNovo.setText("Dados do Novo Cliente");
		lbl_Titulo_DadosDoNovo.setAlignment(SWT.CENTER);
		lbl_Titulo_DadosDoNovo.setBounds(81, 2, 322, 15);

		text_UltimoNovoC = new Text(composite, SWT.BORDER);
		text_UltimoNovoC.setBounds(250, 44, 170, 21);

		Label label_9 = new Label(composite, SWT.NONE);
		label_9.setText("(primeiro)");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		label_9.setBounds(125, 29, 55, 15);

		Label label_10 = new Label(composite, SWT.NONE);
		label_10.setText("(ultimo)");
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		label_10.setBounds(302, 29, 55, 15);

		Label label_11 = new Label(composite, SWT.NONE);
		label_11.setText("Data Nas.(aaaa/mm/dd)");
		label_11.setBounds(175, 165, 132, 15);

		text_DataN_Ano = new Text(composite, SWT.BORDER);
		text_DataN_Ano.setBounds(313, 164, 40, 21);

		text_DataN_mes = new Text(composite, SWT.BORDER);
		text_DataN_mes.setBounds(363, 164, 23, 21);

		Label label_12 = new Label(composite, SWT.NONE);
		label_12.setText("/");
		label_12.setBounds(355, 167, 8, 15);

		Label label_13 = new Label(composite, SWT.NONE);
		label_13.setText("/");
		label_13.setBounds(387, 167, 8, 15);

		text_DataN_dia = new Text(composite, SWT.BORDER);
		text_DataN_dia.setBounds(395, 164, 23, 21);
		
		/// PRECHE PARA FACILIAR
		
		text_PrimeiroNovoC.setText("2222");
		text_UltimoNovoC.setText("2222");
		text_ValorID_NovoC.setText("78453123");
		text_MoradaNovoC.setText("Morada");
		text_Email_NovoC.setText("mail31@gmail.com");
		text_MobileNovoC.setText("969420730");
		text_UserNovoC.setText("2222");
		text_PassNovoC.setText("6666");
		text_DataN_Ano.setText("2018");
		text_DataN_mes.setText("06");
		text_DataN_dia.setText("06");
		
		
		

		Button button_GuardaCliente = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		button_GuardaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				

			
				String mensagem = "";
				boolean naohaDadosPorPreencher = true;
				// Verifica campos vazios
				if (estaVazio(text_PrimeiroNovoC) || estaVazio(text_UltimoNovoC) || estaVazio(text_MoradaNovoC)
						|| estaVazio(text_ValorID_NovoC) || estaVazio(text_Email_NovoC) || estaVazio(text_MobileNovoC)
						|| estaVazio(text_DataN_Ano) || estaVazio(text_DataN_mes) || estaVazio(text_DataN_dia)
						|| estaVazio(text_UserNovoC) || estaVazio(text_PassNovoC)) {
					lbl_Titulo_DadosDoNovo.setText("Dados por preencher ou inv�lidos");
					lbl_Titulo_DadosDoNovo.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
					mensagem = mensagem + "Tem dados por preencher\n";

					estaVazio(text_UltimoNovoC);
					estaVazio(text_PrimeiroNovoC);
					estaVazio(text_MoradaNovoC);
					estaVazio(text_ValorID_NovoC);
					estaVazio(text_Email_NovoC);
					estaVazio(text_MobileNovoC);
					estaVazio(text_DataN_Ano);
					estaVazio(text_DataN_mes);
					estaVazio(text_DataN_dia);
					estaVazio(text_UserNovoC);
					estaVazio(text_PassNovoC);
					naohaDadosPorPreencher = false;

				}

				if (combo_TipoID_NovoC.getText().equals("Cartao Cidadao") && !estaVazio(text_ValorID_NovoC)) {
					if (eNumero(text_ValorID_NovoC) == -1) {
						lbl_Titulo_DadosDoNovo.setText("Dados por preencher ou inv�lidos");
						mensagem = mensagem + "N� CC inv�lido .\n";
						System.out.println("VERIFICACAO DE numeros CC");
						naohaDadosPorPreencher = false;
					} else if (eNumero(text_ValorID_NovoC) != 8 && eNumero(text_ValorID_NovoC) != -1) {
						lbl_Titulo_DadosDoNovo.setText("Dados por preencher ou inv�lidos");
						mensagem = mensagem + "N� Cartao Cidadao inv�lido\n";

						mensagem = mensagem + ".\n";
						System.out.println("VERIFICACAO DE CC");
						naohaDadosPorPreencher = false;
					}
				} else if (combo_TipoID_NovoC.getText().equals("Passaporte") && !estaVazio(text_ValorID_NovoC)) {
					/// falta verificar tamanho de passaporte
					if (text_ValorID_NovoC.getText().length() < 8 || text_ValorID_NovoC.getText().length() > 10) {
						combo_TipoID_NovoC.setText("Dados por preencher ou inv�lidos");
						mensagem = mensagem + "N� Passaporte inv�lido .\n";
						System.out.println("VERIFICACAO DE Passaporte");
						naohaDadosPorPreencher = false;
					}

				}

				if (!validateData2(text_DataN_Ano, text_DataN_mes, text_DataN_dia)) {
					System.out.println("VERIFICACAO DE Data" + text_MobileNovoC.getText());
					combo_TipoID_NovoC.setText("Dados por preencher ou inv�lidos");
					mensagem = mensagem + "Data de Nascimento inv�lida.\n";
					naohaDadosPorPreencher = false;

				}

				if (!validateMobileNumber(text_MobileNovoC)) {
					System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoC.getText());
					combo_TipoID_NovoC.setText("Dados por preencher ou inv�lidos");
					mensagem = mensagem + "Contacto inv�lido.\n";
					naohaDadosPorPreencher = false;

				}

				if (!validateEmail(text_Email_NovoC)) {
					System.out.println("VERIFICACAO DE Email ->" + text_Email_NovoC.getText());
					combo_TipoID_NovoC.setText("Dados por preencher ou inv�lidos");
					mensagem = mensagem + "Email inv�lido.\n";
					naohaDadosPorPreencher = false;
				}

				if (naohaDadosPorPreencher) {
					TipoID escolhadaID = Cliente.TipoID.PASSAPORTE;
					if (combo_TipoID_NovoC.getText().equals("Passaporte")) {
						escolhadaID = Cliente.TipoID.PASSAPORTE;
					} else {
						escolhadaID = Cliente.TipoID.CARTAOCIDADAO;
					}

					String verifica = gestor.verificanovoC(escolhadaID, text_ValorID_NovoC, text_Email_NovoC,
							text_UserNovoC, text_MobileNovoC);
//					

//					System.out.println(Arrays.toString(verifica));
//					for (int i = 0; i < verifica.length; i++) {
//						textofinal = textofinal + verifica[i];
//						if (!verifica[i].equals("")) {
//							verificatudo = false;
//						}
					System.out.println(("VERIFICA? --->" + verifica));

					if (verifica.equals("")) {
						Cliente f = new Cliente();

						String dataStr = text_DataN_Ano.getText() + "/" + text_DataN_mes.getText() + "/"
								+ text_DataN_dia.getText();

					
					gestor.addNovoC(text_UserNovoC.getText(),text_PassNovoC.getText(),
								text_PrimeiroNovoC.getText(),text_UltimoNovoC.getText(), dataStr,
								text_MoradaNovoC.getText(), escolhadaID,text_ValorID_NovoC.getText(),
								text_Email_NovoC.getText(),Integer.parseInt(text_MobileNovoC.getText()));
						
						MessageBox box = new MessageBox(shellMF, SWT.MULTI);
						f = (Cliente) (gestor.getMapUtilizadores().get(text_UserNovoC.getText()));
						box.setText("CONCLUS�O");
						box.setMessage(" O Cliente" + f.getNome() + " " + f.getSobrenome() + " foi adicionado\n"
								+ "Morada:" + f.getMorada() + "\n" + "" + f.escolhaID.toString() + ":" + f.getValorID()
								+ "\n" + "Email:" + f.getEmail() + "\n" + "Contacto:" + f.getMobile() + "\n"
								+ "Data Nascimento:" + f.getDataNascimento() + "\n" );
//						
						box.open();
						clienteActual=f;
						System.out.println(("verifica"));

					} else {
						System.out.println(("----> Nao verifica"));
						verifica = "Dados por  inv�lidos:/n" + verifica;
						MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage(verifica);
						box.open();
						Composite composite10 = new Composite(shellMF, SWT.NONE);
						composite10.setBounds(182, 41, 430, 301);
					}

				} else {
					MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
					box.setText("ERRO");
					box.setMessage(mensagem);
					box.open();
					Composite composite10 = new Composite(shellMF, SWT.NONE);
					composite10.setBounds(182, 41, 430, 301);
					naohaDadosPorPreencher = true;
				}
				text_PrimeiroNovoC.setText("");
				text_UltimoNovoC.setText("");
				text_ValorID_NovoC.setText("");
				text_MoradaNovoC.setText("");
				text_Email_NovoC.setText("");
				text_MobileNovoC.setText("");
				text_UserNovoC.setText("");
				text_PassNovoC.setText("");
				text_DataN_Ano.setText("");
				text_DataN_mes.setText("");
				text_DataN_dia.setText("");
				
				
			}
		});
		button_GuardaCliente.setText("Guardar\nNovo Cliente");
		button_GuardaCliente.setBounds(289, 233, 103, 58);
		
		Button button_1 = new Button(shellMF, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_DadosCl cliente=new J_02Menu_F_DadosCl(gestor,uUtilizador,clienteActual);
				cliente.open();
				
			}
		});
		button_1.setText("Dados do cliente");
		button_1.setBounds(10, 144, 192, 25);
		
		Button button_2 = new Button(shellMF, SWT.TOGGLE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_MovimentaConta editarconta= new J_02Menu_F_MovimentaConta(gestor, uUtilizador,clienteActual, null);
				editarconta.open();
				
			}
		});
		button_2.setText("Movimentar Contas");
		button_2.setBounds(10, 175, 192, 25);
		
		Button button_3 = new Button(shellMF, SWT.NONE);
		button_3.setBounds(10, 208, 192, 25);
		
		Button button_4 = new Button(shellMF, SWT.NONE);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.close();
				J_02_MenuFun_AlteraDados2 alteradados=new J_02_MenuFun_AlteraDados2(gestor, uUtilizador); 
				alteradados.open();
			}
		});
		button_4.setText("Alterar Login e Password");
		button_4.setBounds(10, 239, 192, 25);

		
	
		
		
		
	}

	// ***************metodos**************

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
//	Regex : ^[\\w!#$%&�*+/=?`{|}~^-]+(?:\\.[\\w!#$%&�*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$

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

	public boolean validateData2(Text texto1, Text texto2, Text texto3) {
//		new GregorianCalendar(2018, 10, 24);
		GregorianCalendar novoF = new GregorianCalendar();
		GregorianCalendar actual = new GregorianCalendar();
		GregorianCalendar actualMenos120 = new GregorianCalendar();
		actualMenos120 = (GregorianCalendar) GregorianCalendar.getInstance();
		actual = (GregorianCalendar) Calendar.getInstance();

		String dataStr = texto1.getText() + "/" + texto2.getText() + "/" + texto3.getText();
		System.out.println(dataStr);
		Pattern regexPattern = Pattern.compile("^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$");
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
