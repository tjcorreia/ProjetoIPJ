package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

/**
 * Breve descri��o do c�digo Janela Funcionario _Apresenta��o de dados do
 * Janela de Funcionario para visualizar dados de um cliente
 * 
* @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
* 
*/
public class J_02Menu_F_DadosCl {

	protected Shell shellMF;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Text Funcionario;
	private Text text_PrimeiroNovoC;
	private Text text_UltimoNovoC;
	private Text text_MoradaNovoC;
	private Text text_ValorID_NovoC;
	private Text text_Email_NovoC;
	private Text text_MobileNovoC;
	private Text text_UserNovoC;
	private Text text_PassNovoC;
	private Text text_DataN_Ano;
	private Text text_DataN_mes;
	private Text text_DataN_dia;
	private Text txt_Indique_ID;
	private Combo combo_TipoID_NovoC;
	private Table table_ListadeContas;
	private Button btnAlterarDados;
	private Button btn_ProcuraCliente;
	private Button btnMenuadministrador;

	public Shell getShellMF() {
		return shellMF;
	}

	public void setShellMF(Shell shellMF) {
		this.shellMF = shellMF;
	}

	public Text getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Text funcionario) {
		Funcionario = funcionario;
	}

	public Text getText_PrimeiroNovoC() {
		return text_PrimeiroNovoC;
	}

	public void setText_PrimeiroNovoC(Text text_PrimeiroNovoC) {
		this.text_PrimeiroNovoC = text_PrimeiroNovoC;
	}

	public Text getText_UltimoNovoC() {
		return text_UltimoNovoC;
	}

	public void setText_UltimoNovoC(Text text_UltimoNovoC) {
		this.text_UltimoNovoC = text_UltimoNovoC;
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

	public Text getTxt_Indique_ID() {
		return txt_Indique_ID;
	}

	public void setTxt_Indique_ID(Text txt_Indique_ID) {
		this.txt_Indique_ID = txt_Indique_ID;
	}

	public Combo getCombo_TipoID_NovoC() {
		return combo_TipoID_NovoC;
	}

	public void setCombo_TipoID_NovoC(Combo combo_TipoID_NovoC) {
		this.combo_TipoID_NovoC = combo_TipoID_NovoC;
	}

	public Table getTable_ListadeContas() {
		return table_ListadeContas;
	}

	public void setTable_ListadeContas(Table table_ListadeContas) {
		this.table_ListadeContas = table_ListadeContas;
	}

	public Button getBtnAlterarDados() {
		return btnAlterarDados;
	}

	public void setBtnAlterarDados(Button btnAlterarDados) {
		this.btnAlterarDados = btnAlterarDados;
	}

	public Button getBtn_ProcuraCliente() {
		return btn_ProcuraCliente;
	}

	public void setBtn_ProcuraCliente(Button btn_ProcuraCliente) {
		this.btn_ProcuraCliente = btn_ProcuraCliente;
	}

	public Button getBtnMenuadministrador() {
		return btnMenuadministrador;
	}

	public void setBtnMenuadministrador(Button btnMenuadministrador) {
		this.btnMenuadministrador = btnMenuadministrador;
	}

	public Cliente getClienteActual() {
		return clienteActual;
	}

	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}

	public Utilizador getuUtilizador() {
		return uUtilizador;
	}

	public void setuUtilizador(Utilizador uUtilizador) {
		this.uUtilizador = uUtilizador;
	}

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_DadosCl() {
		super();
		open();
		// TODO Auto-generated constructor stub
	}

	public J_02Menu_F_DadosCl(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		this.clienteActual = clienteActual;

	}

	/**
	 * Launch the application.
	 * 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_DadosCl window = new J_02Menu_F_DadosCl(new Gestao(), new Funcionario(), new cliente());
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Open the window.
	 */
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
		image2.isAutoScalable();
		;
		Label lblimagem = new Label(shellMF, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shellMF, image2, lblimagem.getBounds().width, lblimagem.getBounds().height));

		
		
		Button btnNovoCliente = new Button(shellMF, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellMF.dispose();
				J_02Menu_F_CriaCliente criaCliente = new J_02Menu_F_CriaCliente(gestor, uUtilizador);
				criaCliente.open();

			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnTBD = new Button(shellMF, SWT.NONE);
		btnTBD.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnTBD.setBounds(10, 209, 192, 25);

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

		Button btnAlterarLoginE = new Button(shellMF, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellMF.close();
				J_02_MenuFun_AlteraDados2 alteradados = new J_02_MenuFun_AlteraDados2(gestor, uUtilizador);
				alteradados.open();
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 240, 192, 25);

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
		composite.setBounds(215, 84, 441, 384);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Identifica\u00E7ao");
		label.setBounds(10, 122, 70, 15);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Nome");
		label_1.setBounds(10, 65, 55, 15);

		text_PrimeiroNovoC = new Text(composite, SWT.BORDER);
		text_PrimeiroNovoC.setBounds(81, 62, 163, 21);

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("Morada");
		label_2.setBounds(10, 93, 55, 15);

		text_MoradaNovoC = new Text(composite, SWT.BORDER);
		text_MoradaNovoC.setBounds(81, 90, 339, 21);

		combo_TipoID_NovoC = new Combo(composite, SWT.NONE);
		combo_TipoID_NovoC.setItems(new String[] { "Cartao Cidadao", "Passaporte" });
		combo_TipoID_NovoC.setBounds(81, 117, 121, 23);
		combo_TipoID_NovoC.select(0);

		text_ValorID_NovoC = new Text(composite, SWT.BORDER);
		text_ValorID_NovoC.setTouchEnabled(true);
		text_ValorID_NovoC.setText("");
		text_ValorID_NovoC.setBounds(208, 119, 212, 21);

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("Email");
		label_3.setBounds(10, 149, 55, 15);

		text_Email_NovoC = new Text(composite, SWT.BORDER);
		text_Email_NovoC.setText("");
		text_Email_NovoC.setBounds(81, 146, 339, 21);

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("Contacto");
		label_4.setBounds(10, 183, 55, 15);

		text_MobileNovoC = new Text(composite, SWT.BORDER);
		text_MobileNovoC.setText("");
		text_MobileNovoC.setBounds(81, 180, 88, 21);

		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setText("Utilizador");
		label_5.setBounds(10, 210, 55, 15);

		text_UserNovoC = new Text(composite, SWT.BORDER);
		text_UserNovoC.setText("*********");
		text_UserNovoC.setBounds(81, 207, 121, 21);

		Label label_6 = new Label(composite, SWT.NONE);
		label_6.setText("Password");
		label_6.setBounds(228, 210, 55, 15);

		text_PassNovoC = new Text(composite, SWT.BORDER);
		text_PassNovoC.setText("*********");
		text_PassNovoC.setBounds(289, 207, 131, 21);

		text_UltimoNovoC = new Text(composite, SWT.BORDER);
		text_UltimoNovoC.setBounds(250, 62, 170, 21);

		Label label_9 = new Label(composite, SWT.NONE);
		label_9.setText("(primeiro)");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		label_9.setBounds(125, 47, 55, 15);

		Label label_10 = new Label(composite, SWT.NONE);
		label_10.setText("(ultimo)");
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		label_10.setBounds(302, 47, 55, 15);

		Label label_11 = new Label(composite, SWT.NONE);
		label_11.setText("Data Nas.(aaaa/mm/dd)");
		label_11.setBounds(175, 183, 132, 15);

		text_DataN_Ano = new Text(composite, SWT.BORDER);
		text_DataN_Ano.setBounds(313, 182, 40, 21);

		text_DataN_mes = new Text(composite, SWT.BORDER);
		text_DataN_mes.setBounds(363, 182, 23, 21);

		Label label_12 = new Label(composite, SWT.NONE);
		label_12.setText("/");
		label_12.setBounds(355, 185, 8, 15);

		btnAlterarDados = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		btnAlterarDados.setBounds(228, 263, 181, 25);
		
		btnMenuadministrador = new Button(shellMF, SWT.NONE);
		btnMenuadministrador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_01_Administrador admin=new J_01_Administrador(gestor,uUtilizador);
				admin.open();
			}
		});
		btnMenuadministrador.setText("MenuAdministrador");
		btnMenuadministrador.setBounds(10, 300, 192, 25);
		btnMenuadministrador.setVisible(false);
		if (uUtilizador instanceof Administrador) {
			btnMenuadministrador.setVisible(true);
			btnAlterarDados.setEnabled(false);
			
		}
		
		
		txt_Indique_ID = new Text(composite, SWT.BORDER | SWT.CENTER);
		txt_Indique_ID.setText("Indique o ID");
		txt_Indique_ID.setLocation(10, 7);
		txt_Indique_ID.setSize(88, 21);
		txt_Indique_ID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				txt_Indique_ID.setText("");
			}
		});

		Label label_13 = new Label(composite, SWT.NONE);
		label_13.setText("/");
		label_13.setBounds(387, 185, 8, 15);

		text_DataN_dia = new Text(composite, SWT.BORDER);
		text_DataN_dia.setBounds(395, 182, 23, 21);

		Label lblDadosDoCliente = new Label(composite, SWT.NONE);
		lblDadosDoCliente.setText("Dados do Cliente");
		lblDadosDoCliente.setAlignment(SWT.CENTER);
		lblDadosDoCliente.setBounds(104, 10, 291, 15);

		Button btnMovimentarConta = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		btnMovimentarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_MovimentaConta editarconta = new J_02Menu_F_MovimentaConta(gestor, uUtilizador,
						clienteActual, null);
				editarconta.open();

			}
		});
		btnMovimentarConta.setText("Movimentar Contas");
		btnMovimentarConta.setBounds(228, 323, 181, 25);

		
		btnAlterarDados.setText("Alterar dados Cliente");
		String alterarDadosC = "Alterar dados Cliente";
		btnAlterarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (btnAlterarDados.getText().equals("Alterar dados Cliente")
						&& (!(txt_Indique_ID.getText().equals("Indique o ID"))
								||!(clienteActual==null))) {
					String alterarDadosC = "Pode alterar Dados";
					btnAlterarDados.setText(alterarDadosC);
					btnAlterarDados.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
					// desbolqueia campos n�o alteraveis
					text_PrimeiroNovoC.setEnabled(true);
					text_UltimoNovoC.setEnabled(true);
					text_MoradaNovoC.setEnabled(true);
					text_UserNovoC.setEnabled(true);
					text_PassNovoC.setEnabled(true);
					text_ValorID_NovoC.setEnabled(true);
					text_Email_NovoC.setEnabled(true);
					text_MobileNovoC.setEnabled(true);
					text_DataN_Ano.setEnabled(true);
					text_DataN_mes.setEnabled(true);
					text_DataN_dia.setEnabled(true);
					combo_TipoID_NovoC.setEnabled(true);
					btn_ProcuraCliente.setEnabled(false);

				} else if (btnAlterarDados.getText().equals("Pode alterar Dados")) {
					// falta ver
					String mensagem = "";
					boolean naohaDadosPorPreencher = true;
					// Verifica campos vazios
					if (Util.estaVazio(text_PrimeiroNovoC,text_UltimoNovoC,text_MoradaNovoC)
							|| Util.estaVazio(text_ValorID_NovoC,text_Email_NovoC,text_MobileNovoC) ||
							Util.estaVazio(text_DataN_Ano,text_DataN_mes,text_DataN_dia)) {				
						System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
						mensagem = mensagem + "Tem dados por preencher\n";
						naohaDadosPorPreencher = false;

					}

					if (!Util.validateEmail(text_Email_NovoC)) {
						System.out.println("VERIFICACAO DE Email ->" + text_Email_NovoC.getText());
//						Titulo_Novo_F.setText("Dados por preencher ou inv�lidos");
						mensagem = mensagem + "Email inv�lido.\n";
						naohaDadosPorPreencher = false;
					}
					if (!Util.validateData2(text_DataN_Ano,text_DataN_mes,text_DataN_dia) ) {
						
						mensagem = mensagem + "Data de Nascimento inv�lida.\n";
						naohaDadosPorPreencher = false;

					}
					if (naohaDadosPorPreencher) {
						System.out.println(text_Email_NovoC.getText());
						System.out.println(text_UserNovoC.getText());
						System.out.println(clienteActual.getEmail());
						System.out.println(clienteActual.getLogin());
//						verificanovoC(TipoID escolhadaIDN, Text valorID_NovoF, Text email_NovoF, Text userNovoF,
//								Text mobileNovoF)

						TipoID escolhadaID = Cliente.TipoID.PASSAPORTE;
						if (combo_TipoID_NovoC.getText().equals("Passaporte")) {
							escolhadaID = Cliente.TipoID.PASSAPORTE;
						} else {
							escolhadaID = Cliente.TipoID.CARTAOCIDADAO;
						}

						// nota esta a usar como UserLogin=**** o que vai verificar , podendo no futuro
						// ser alterado para
						// o funcionario poder alterar este parametro
						String verifica = gestor.verificaAlteraCl(clienteActual, escolhadaID, text_ValorID_NovoC,
								text_Email_NovoC, text_UserNovoC, text_MobileNovoC);
//								

						System.out.println(("VERIFICA? --->" + verifica));
//						
						if (verifica.equals("")) {
							clienteActual.setDataNascimento(text_DataN_Ano.getText() + "/" + text_DataN_mes.getText()
									+ "/" + text_DataN_dia.getText());
							clienteActual.setEmail(text_Email_NovoC.getText());
							clienteActual.setEscolhaID(escolhadaID);
							clienteActual.setMobile(Integer.parseInt(text_MobileNovoC.getText()));
							clienteActual.setNome(text_PrimeiroNovoC.getText());
							clienteActual.setSobrenome(text_UltimoNovoC.getText());

							gestor.getMapUtilizadores().replace(clienteActual.getLogin(), clienteActual);
							Cliente f = new Cliente();
							MessageBox box = new MessageBox(shellMF, SWT.MULTI);
							System.out.println(("ERRO 1? --->" + verifica));
							f = (Cliente) (gestor.getMapUtilizadores().get(clienteActual.getLogin()));

							box.setText("CONCLUS�O");
							box.setMessage("Os  dados de" + f.getNome() + " " + f.getSobrenome()
									+ "\n  foram Actualizados .\n");
//							
							box.open();

							System.out.println(("verifica"));
							gestor.saveAll();
							btn_ProcuraCliente.setEnabled(true);
							btnAlterarDados.setText("Alterar dados Cliente");
							btnAlterarDados.setText(alterarDadosC);
							btnAlterarDados.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GRAY));
							shellMF.redraw();

						} else {
							System.out.println(("----> Nao verifica"));
							verifica = "Dados por  inv�lidos:\n" + verifica;
							MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
							box.setText("ERRO");
							box.setMessage(verifica);
							box.open();
//							Composite composite10 = new Composite(shellMF, SWT.NONE);
//							composite10.setBounds(182, 41, 430, 301);
						}

					} else {
						MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage(mensagem);
						box.open();
//						Composite composite10 = new Composite(shellMF, SWT.NONE);
//						composite10.setBounds(182, 41, 430, 301);
						naohaDadosPorPreencher = true;
					}

				}

			}
		});

		

		Label lblListaDeContas = new Label(composite, SWT.NONE);
		lblListaDeContas.setText("Lista de Contas");
		lblListaDeContas.setBounds(81, 234, 88, 15);

		table_ListadeContas = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_ListadeContas.setBounds(81, 255, 131, 106);
		table_ListadeContas.setHeaderVisible(true);
		table_ListadeContas.setLinesVisible(true);
		table_ListadeContas.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		table_ListadeContas.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));

		TableColumn tblclmnId = new TableColumn(table_ListadeContas, SWT.CENTER);
		tblclmnId.setWidth(67);
		tblclmnId.setText("ID");

		TableColumn tblclmnTitulares = new TableColumn(table_ListadeContas, SWT.CENTER);
		tblclmnTitulares.setWidth(57);
		tblclmnTitulares.setText("Titulares");

		if (!(clienteActual == null)) {
			//// colocaca dados
			txt_Indique_ID.setText("" + clienteActual.getuID());
			preecheTabela(clienteActual);

		}

		btn_ProcuraCliente = new Button(composite, SWT.NONE);
		btn_ProcuraCliente.setGrayed(true);
		// *procura pelo cliente atrav�s da ID e devolve toda a informa��o
		btn_ProcuraCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				String mensagem = "";
				if (Util.estaVazio(txt_Indique_ID)) {

					mensagem = " Para procurar um Cliente tem de introduzir um ID";
				} else {
					if (Util.eNumero(txt_Indique_ID) == -1) {
						mensagem = " O ID do cliente tem de ser numerico";
					} else {
						if (gestor.procuraCid(Integer.parseInt(txt_Indique_ID.getText())) == null) {
							txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						} else {
							clienteActual = gestor.procuraCid(Integer.parseInt(txt_Indique_ID.getText()));
							mensagem = "O Cliente" + clienteActual.getNome() + " " + clienteActual.getSobrenome()
									+ " foi encontrado\n" + "Morada:" + clienteActual.getMorada() + "\n" + ""
									+ clienteActual.escolhaID.toString() + ":" + clienteActual.getValorID() + "\n"
									+ "Email:" + clienteActual.getEmail() + "\n" + "Contacto:"
									+ clienteActual.getMobile() + "\n" + "Data Nascimento:"
									+ clienteActual.getDataNascimento() + "\n";

							//// colocaca dados
							preecheTabela(clienteActual);

						}
					}
				}

				MessageBox box = new MessageBox(shellMF, SWT.MULTI);
//				f = (Cliente) (gestor.getMapUtilizadores().get(text_UserNovoC.getText()));
				box.setText("DADOS DO CLIENTE");
				box.setMessage("  " + mensagem);
//				
				box.open();
			}
		});
		btn_ProcuraCliente.setLocation(10, 28);
		btn_ProcuraCliente.setSize(88, 25);
		btn_ProcuraCliente.setText("Obter Cliente");

		Button btnCriarConta = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		btnCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_Conta criaConta = new J_02Menu_F_Conta(gestor, uUtilizador, clienteActual);
				criaConta.open();

			}
		});
		btnCriarConta.setText("Criar Conta");
		btnCriarConta.setBounds(228, 233, 181, 25);

		Button btnListaDeMovimentos = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		btnListaDeMovimentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_ContasCl contasDoCliente = new J_02Menu_F_ContasCl(gestor, uUtilizador, clienteActual);
				contasDoCliente.open();
			}
		});
		btnListaDeMovimentos.setText("Lista de Movimentos da Contas");
		btnListaDeMovimentos.setBounds(228, 292, 181, 25);

		Button btnEditarContas = new Button(composite, SWT.TOGGLE);
		btnEditarContas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_EditarConta editarconta = new J_02Menu_F_EditarConta(gestor, uUtilizador, clienteActual,
						null);
				editarconta.open();

				
			}
		});
		btnEditarContas.setText("Editar Contas");
		btnEditarContas.setBounds(228, 354, 181, 25);

		Button button_DadosCliente = new Button(shellMF, SWT.NONE);
		button_DadosCliente.setEnabled(false);
		button_DadosCliente.setText("Dados do cliente");
		button_DadosCliente.setBounds(10, 146, 192, 25);

		Button button_1 = new Button(shellMF, SWT.TOGGLE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
				J_02Menu_F_MovimentaConta editarconta = new J_02Menu_F_MovimentaConta(gestor, uUtilizador,
						clienteActual, null);
				editarconta.open();

			}
		});
		button_1.setText("Movimentar Contas");
		button_1.setBounds(10, 177, 192, 25);

	}

	// preenche tabela de dados do cliente

	public void preecheTabela(Cliente clienteActual) {
		text_PrimeiroNovoC.setText(clienteActual.getNome());
		text_UltimoNovoC.setText(clienteActual.getSobrenome());
		text_MoradaNovoC.setText(clienteActual.getMorada());
		text_UserNovoC.setText("********");
		text_PassNovoC.setText("********");
		;
		text_ValorID_NovoC.setText(clienteActual.getValorID());
		text_Email_NovoC.setText(clienteActual.getEmail());
		text_MobileNovoC.setText("" + clienteActual.getMobile());
		String[] data = clienteActual.getDataNascimento().split("/");
		text_DataN_Ano.setText(data[0]);
		;
		text_DataN_mes.setText(data[1]);
		;
		text_DataN_dia.setText(data[2]);
		;
		combo_TipoID_NovoC.setText(clienteActual.getEscolhaID().toString());
		// bolqueia campos n�o alteraveis
		text_PrimeiroNovoC.setEnabled(false);
		text_UltimoNovoC.setEnabled(false);
		text_MoradaNovoC.setEnabled(false);
		text_UserNovoC.setEnabled(false);
		text_PassNovoC.setEnabled(false);
		text_ValorID_NovoC.setEnabled(false);
		text_Email_NovoC.setEnabled(false);
		text_MobileNovoC.setEnabled(false);
		text_DataN_Ano.setEnabled(false);
		text_DataN_mes.setEnabled(false);
		text_DataN_dia.setEnabled(false);
		combo_TipoID_NovoC.setEnabled(false);

		this.table_ListadeContas.clearAll();
		this.table_ListadeContas.removeAll();

		if (!(clienteActual.getLcontaSC() == null)) {
			for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
				TableItem item = new TableItem(this.table_ListadeContas, SWT.NULL);
				item.setText(0, ("" + clienteActual.getLcontaSC().get(i).getContaID()));
				item.setText(1, ("" + clienteActual.getLcontaSC().get(i).getClientesDaC().size()));
			}
		}

	}

	
}
