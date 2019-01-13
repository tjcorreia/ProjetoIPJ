package org.eclipse.wb.swt;

import java.time.LocalDate;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

/**
 * Breve descrição do código 
 * Janela Funcionario para Criar Cliente
 *  
 * @author Alberto Jorge
 *
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
	private Text text_UltimoNovoC;
	private DateTime dateTime_Nascimento ;
	
	public DateTime getDateTime() {
	return dateTime_Nascimento;
}

public void setDateTime(DateTime dateTime) {
	this.dateTime_Nascimento = dateTime;
}

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
		
		
		
		Image image2 = (Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo13.png");
		image2.isAutoScalable();;
		Label lblimagem = new Label(shellMF, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shellMF,image2,lblimagem.getBounds().width,lblimagem.getBounds().height));
		
		Button btnNovoCliente = new Button(shellMF, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnListarClientes = new Button(shellMF, SWT.NONE);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_ListaClientes listaC = new J_02Menu_F_ListaClientes(gestor, uUtilizador);
				listaC.open();

			}
		});
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 115, 192, 25);

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

		dateTime_Nascimento = new DateTime(composite, SWT.BORDER);
		dateTime_Nascimento.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateTime_Nascimento.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			
			}
		});
		dateTime_Nascimento.setBounds(289, 162, 131, 21);
		
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
		text_MobileNovoC.setBounds(81, 162, 99, 21);

		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setText("Utilizador");
		label_5.setBounds(10, 192, 55, 15);

		text_UserNovoC = new Text(composite, SWT.BORDER);
		text_UserNovoC.setBounds(81, 189, 99, 21);

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

		Label lblDataNas = new Label(composite, SWT.NONE);
		lblDataNas.setAlignment(SWT.RIGHT);
		lblDataNas.setText("Data Nascimento ");
		lblDataNas.setBounds(184, 165, 99, 15);

		/// PRECHE PARA FACILIAR

		text_PrimeiroNovoC.setText("Teste");
		text_UltimoNovoC.setText("Teste");
		text_ValorID_NovoC.setText("78453123");
		text_MoradaNovoC.setText("Morada");
		text_Email_NovoC.setText("mail31@gmail.com");
		text_MobileNovoC.setText("969420730");
		text_UserNovoC.setText("TesteUser");
		text_PassNovoC.setText("Teste");
		dateTime_Nascimento.setMonth(11);

		Button button_GuardaCliente = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		button_GuardaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				String mensagem = "";
				boolean naohaDadosPorPreencher = true;
				// Verifica campos vazios
				if (Util.estaVazio(text_PrimeiroNovoC,text_UltimoNovoC,text_MoradaNovoC)|| 
						Util.estaVazio(text_ValorID_NovoC,text_Email_NovoC,text_MobileNovoC)||
						Util.estaVazio(text_UserNovoC) || Util.estaVazio(text_PassNovoC)) {
					lbl_Titulo_DadosDoNovo.setText("Dados por preencher ou inválidos");
					lbl_Titulo_DadosDoNovo.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
					mensagem = mensagem + "Tem dados por preencher\n";
					naohaDadosPorPreencher = false;

				}
				System.out.println("DATA Mes: "+(dateTime_Nascimento.getMonth()+1));
				System.out.println("DATA Dia: "+dateTime_Nascimento.getDay());
				LocalDate dataNas= LocalDate.of(dateTime_Nascimento.getYear(),dateTime_Nascimento.getMonth()+1,dateTime_Nascimento.getDay());
				System.out.println("DATA"+dataNas);
				
				System.out.println("Boolean Data"+Util.verificaIdade (dataNas,17,120));
				
				if (!(Util.verificaIdade (dataNas,17,120))) {
					System.out.println("ENTROU Boolean Data"+Util.verificaIdade (dataNas,17,120));
				dateTime_Nascimento.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
				mensagem = mensagem + "Data de Nascimento Invalida .\n";
				naohaDadosPorPreencher = false;
				}
				
				
				
				if (combo_TipoID_NovoC.getText().equals("Cartao Cidadao") && !Util.estaVazio(text_ValorID_NovoC)) {
					if (Util.eNumero(text_ValorID_NovoC) == -1) {
						lbl_Titulo_DadosDoNovo.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº CC inválido .\n";
						System.out.println("VERIFICACAO DE numeros CC");
						naohaDadosPorPreencher = false;
					} else if (Util.eNumero(text_ValorID_NovoC) != 8 && Util.eNumero(text_ValorID_NovoC) != -1) {
						lbl_Titulo_DadosDoNovo.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº Cartao Cidadao inválido\n";

						mensagem = mensagem + ".\n";
						System.out.println("VERIFICACAO DE CC");
						naohaDadosPorPreencher = false;
					}
				} else if (combo_TipoID_NovoC.getText().equals("Passaporte") && !Util.estaVazio(text_ValorID_NovoC)) {
					/// falta verificar tamanho de passaporte
					if (text_ValorID_NovoC.getText().length() < 8 || text_ValorID_NovoC.getText().length() > 10) {
						combo_TipoID_NovoC.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº Passaporte inválido .\n";
						System.out.println("VERIFICACAO DE Passaporte");
						naohaDadosPorPreencher = false;
					}

				}

				if (!Util.validateMobileNumber(text_MobileNovoC)) {
					System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoC.getText());
					combo_TipoID_NovoC.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Contacto inválido.\n";
					naohaDadosPorPreencher = false;

				}

				if (!Util.validateEmail(text_Email_NovoC)) {
					System.out.println("VERIFICACAO DE Email ->" + text_Email_NovoC.getText());
					combo_TipoID_NovoC.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Email inválido.\n";
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

					System.out.println(("VERIFICA? --->" + verifica));

					if (verifica.equals("")) {
						Cliente f = new Cliente();
						String dataStr = dateTime_Nascimento.getYear() + "/" + (dateTime_Nascimento.getMonth()+1) + "/"
								+ dateTime_Nascimento.getDay();

						gestor.addNovoC(text_UserNovoC.getText(), text_PassNovoC.getText(),
								text_PrimeiroNovoC.getText(), text_UltimoNovoC.getText(), dataStr,
								text_MoradaNovoC.getText(), escolhadaID, text_ValorID_NovoC.getText(),
								text_Email_NovoC.getText(), Integer.parseInt(text_MobileNovoC.getText()));

						MessageBox box = new MessageBox(shellMF, SWT.MULTI);
						f = (Cliente) (gestor.getMapUtilizadores().get(text_UserNovoC.getText()));
						box.setText("CONCLUSÃO");
						box.setMessage(" O Cliente" + f.getNome() + " " + f.getSobrenome() + " foi adicionado\n"
								+ "Morada:" + f.getMorada() + "\n" + "" + f.escolhaID.toString() + ":" + f.getValorID()
								+ "\n" + "Email:" + f.getEmail() + "\n" + "Contacto:" + f.getMobile() + "\n"
								+ "Data Nascimento:" + f.getDataNascimento() + "\n");
//						
						box.open();
						clienteActual = f;
						gestor.saveAll();
						System.out.println(("verifica"));
						text_PrimeiroNovoC.setText("");
						text_UltimoNovoC.setText("");
						text_ValorID_NovoC.setText("");
						text_MoradaNovoC.setText("");
						text_Email_NovoC.setText("");
						text_MobileNovoC.setText("");
						text_UserNovoC.setText("");
						text_PassNovoC.setText("");
					

					} else {
						System.out.println(("----> Nao verifica"));
						verifica = "Dados por  inválidos:/n" + verifica;
						MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage(verifica);
						box.open();
					}
				} else {
					MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
					box.setText("ERRO");
					box.setMessage(mensagem);
					box.open();
					naohaDadosPorPreencher = true;
				}
			}
		});
		button_GuardaCliente.setText("Guardar\nNovo Cliente");
		button_GuardaCliente.setBounds(289, 233, 103, 58);
		
		

		Button button_1 = new Button(shellMF, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_DadosCl cliente = new J_02Menu_F_DadosCl(gestor, uUtilizador, clienteActual);
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
				J_02Menu_F_MovimentaConta editarconta = new J_02Menu_F_MovimentaConta(gestor, uUtilizador,
						clienteActual, null);
				editarconta.open();

			}
		});
		button_2.setText("Movimentar Contas");
		button_2.setBounds(10, 175, 192, 25);

		Button button_3 = new Button(shellMF, SWT.NONE);
		button_3.setBounds(10, 208, 192, 25);

		Button button_AlterarDadosPessoais = new Button(shellMF, SWT.NONE);
		button_AlterarDadosPessoais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.close();
				J_02_MenuFun_AlteraDados2 alteradados = new J_02_MenuFun_AlteraDados2(gestor, uUtilizador);
				alteradados.open();
			}
		});
		button_AlterarDadosPessoais.setText("Alterar Login e Password");
		button_AlterarDadosPessoais.setBounds(10, 239, 192, 25);

	}


	
}
