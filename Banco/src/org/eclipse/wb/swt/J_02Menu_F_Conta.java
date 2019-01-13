package org.eclipse.wb.swt;

import java.time.LocalDate;
import java.util.GregorianCalendar;

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
import org.eclipse.swt.widgets.Text;

/**
 * Breve descrição do código Menu Funcionario criar uma conta nova a um cliente
 * 
 * @author Alberto Jorge
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_Conta {

	protected Shell shellConta;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Conta contaActual;
	private Combo combo;
	private Text Funcionario;
	private Text txt_Indique_ID;
	private Text text_DepositoInicial;
	private Text text_Data;
	private Label lblDadosDoCliente;
	private Combo combo_NormalPrazo;

	public Combo getCombo_NormalPrazo() {
		return combo_NormalPrazo;
	}

	public void setCombo_NormalPrazo(Combo combo_NormalPrazo) {
		this.combo_NormalPrazo = combo_NormalPrazo;
	}

	public Label getLblDadosDoCliente() {
		return lblDadosDoCliente;
	}

	public void setLblDadosDoCliente(Label lblDadosDoCliente) {
		this.lblDadosDoCliente = lblDadosDoCliente;
	}

	public Combo getCombo_EscolhaConta() {
		return combo;
	}

	public void setCombo_EscolhaConta(Combo combo) {
		this.combo = combo;
	}

	public Conta getContaActual() {
		return contaActual;
	}

	public void setContaActual(Conta contaActual) {
		this.contaActual = contaActual;
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
	public J_02Menu_F_Conta() {
		super();
		open();
		// TODO Auto-generated constructor stub
	}

	public J_02Menu_F_Conta(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual) {
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

	public J_02Menu_F_Conta(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual, Conta contaActual) {
		super();
		this.gestor = gestor;
		this.uUtilizador = uUtilizador;
		this.clienteActual = clienteActual;
		this.contaActual = contaActual;

	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shellConta.open();
		shellConta.layout();
		while (!shellConta.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellConta = new Shell();
		shellConta.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shellConta.setSize(707, 533);
		shellConta.setText("Menu Funcion\u00E1rio");

		System.out.println("<---- Utilizador Actual --->\n" + uUtilizador);
		System.out.println("<---- Cliente Actual --->\n" + clienteActual);
		System.out.println("<---- Conta Actual --->\n" + contaActual);

		Image image2 = (Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo13.png");
		image2.isAutoScalable();
		;
		Label lblimagem = new Label(shellConta, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem
				.setImage(gestor.resize(shellConta, image2, lblimagem.getBounds().width, lblimagem.getBounds().height));

		Composite composite = new Composite(shellConta, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 371);

		txt_Indique_ID = new Text(composite, SWT.BORDER | SWT.CENTER);
		if (clienteActual == null) {
			txt_Indique_ID.setText("Indique o ID");
		} else { // preeche os dados
			txt_Indique_ID.setText("" + clienteActual.getuID());
		}
		txt_Indique_ID.setLocation(10, 7);
		txt_Indique_ID.setSize(88, 21);
		txt_Indique_ID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				txt_Indique_ID.setText("");
			}
		});

		Button btnNovoCliente = new Button(shellConta, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellConta.dispose();
				J_02Menu_F_CriaCliente alteraDados = new J_02Menu_F_CriaCliente(gestor, uUtilizador);
				alteraDados.open();

			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button button = new Button(shellConta, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellConta.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shellConta, SWT.BORDER);
		Funcionario.setText("Bem Vindo " + uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);

		lblDadosDoCliente = new Label(composite, SWT.NONE);
		String textoCliente = "";
		if (!(clienteActual == null)) {
			textoCliente = ("Cliente \n" + clienteActual.getNome() + " " + clienteActual.getSobrenome() + "Morada:"
					+ clienteActual.getMorada() + "\n" + "Email:" + clienteActual.getEmail() + "Contacto:"
					+ clienteActual.getMobile());
		} else {
			textoCliente = ("Cliente não definido \n");
		}
		lblDadosDoCliente.setText(textoCliente);
		lblDadosDoCliente.setAlignment(SWT.CENTER);
		lblDadosDoCliente.setBounds(104, 10, 231, 43);

		Button btn_ProcuraCliente = new Button(composite, SWT.NONE);
		btn_ProcuraCliente.setGrayed(true);
		// *procura pelo cliente através da ID e devolve o cliente para actual
		btn_ProcuraCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				novoClienteActual();

			}
		});
		btn_ProcuraCliente.setLocation(10, 28);
		btn_ProcuraCliente.setSize(88, 25);
		btn_ProcuraCliente.setText(" Cliente");

		combo_NormalPrazo = new Combo(composite, SWT.NONE);

		if (clienteActual == null) {
			String textoCombo[] = { "Tem de Selecionar um Cliente", "ERRO" };
			combo_NormalPrazo.setItems(textoCombo);
		} else if (!(clienteActual == null)) {
			if (!(clienteActual.procuraContaPrazo() == null)) {
				String textoCombo[] = { "Conta Normal" };
				combo_NormalPrazo.setItems(textoCombo);

			}
			if (clienteActual.procuraContaPrazo() == null) {
				String textoCombo[] = { "Conta Normal", "Conta prazo" };
				combo_NormalPrazo.setItems(textoCombo);
			}
		}

		combo_NormalPrazo.setBounds(104, 101, 103, 23);
		combo_NormalPrazo.select(0);

		Label lblDepositoInicial = new Label(composite, SWT.NONE);
		lblDepositoInicial.setAlignment(SWT.RIGHT);
		lblDepositoInicial.setText("Deposito Inicial");
		lblDepositoInicial.setBounds(10, 135, 88, 15);

		text_DepositoInicial = new Text(composite, SWT.BORDER);
		text_DepositoInicial.setBounds(104, 132, 103, 21);
//		text_DepositoInicial.setText("0");

		Label lblTipo = new Label(composite, SWT.NONE);
		lblTipo.setAlignment(SWT.RIGHT);
		lblTipo.setText(" Tipo de Conta");
		lblTipo.setBounds(10, 104, 88, 15);

		Label lblDataCriao = new Label(composite, SWT.NONE);
		lblDataCriao.setAlignment(SWT.RIGHT);
		lblDataCriao.setText("Data Cria\u00E7\u00E3o");
		lblDataCriao.setBounds(10, 161, 88, 15);
		String data = null;
		LocalDate actual = LocalDate.now();

		System.out.println("<---- DATA ACTUAL_LocalDate--->\n" + actual);

		text_Data = new Text(composite, SWT.BORDER);
		text_Data.setText("" + actual);
		text_Data.setBounds(104, 158, 103, 21);
		text_Data.setEnabled(false);
		GregorianCalendar actual2 = new GregorianCalendar();
		actual2 = (GregorianCalendar) GregorianCalendar.getInstance();
		System.out.println("<---- DATA ACTUAL Gregorian--->\n " + actual2);

//// Criar nova conta
		Button btnCriarConta = new Button(composite, SWT.NONE);
		btnCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (clienteActual == null) {
					MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
					box.setText("ERRO");
					box.setMessage("Para criar a conta tem de ter um Cliente Activo");
					box.open();
					txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				} else {
					if (Util.estaVazio(text_DepositoInicial) || !Util.eNumeroIouD(text_DepositoInicial)) {
						MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage("Valor invalido");
						box.open();
						text_DepositoInicial.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					} else {
						System.out.println("<---- NÃO E DOUBLE? --->" + Util.eNumeroIouD(text_DepositoInicial));
						// conta Normal "Conta Normal", "Conta prazo"
						if (combo_NormalPrazo.getText().equals("Conta Normal")) {
							Conta novaConta = new ContaNormal(Double.parseDouble(text_DepositoInicial.getText()),
									"" + actual);
							contaActual = gestor.criaContaNova(clienteActual, novaConta, uUtilizador.getuID());
							MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
							box.setText("CONCLUIDO");
							box.setMessage("Conta Normal:" + contaActual.getContaID() + " Criada !\n");
							box.open();
							gestor.saveAll();
							shellConta.dispose();
							J_02Menu_F_DadosCl back = new J_02Menu_F_DadosCl(gestor, uUtilizador, clienteActual);
							back.open();
							

						}
						// conta a Prazo
						else if (combo_NormalPrazo.getText().equals("Conta prazo")) {

							Conta novaConta = new ContaPrazo(Double.parseDouble(text_DepositoInicial.getText()),
									"" + actual);
							contaActual = gestor.criaContaNova(clienteActual, novaConta, uUtilizador.getuID());
							MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
							box.setText("CONCLUIDO");
							box.setMessage("Conta Prazo:" + contaActual.getContaID() + " Criada !\n");
							box.open();
							shellConta.dispose();
							gestor.saveAll();
							J_02Menu_F_DadosCl back = new J_02Menu_F_DadosCl(gestor, uUtilizador, clienteActual);
							back.open();
							
						}
					}
				}
			}
		});
		btnCriarConta.setBounds(23, 213, 184, 52);
		btnCriarConta.setText("Criar Conta Nova");

		Label lblDados = new Label(composite, SWT.NONE);
		lblDados.setAlignment(SWT.CENTER);
		lblDados.setText("Dados");
		lblDados.setBounds(105, 71, 102, 21);

		Button button_1 = new Button(shellConta, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellConta.dispose();
				J_02Menu_F_ListaClientes lclientes = new J_02Menu_F_ListaClientes(gestor, uUtilizador);
				lclientes.open();

			}
		});
		button_1.setText("Listar/Procurar Clientes");
		button_1.setBounds(10, 115, 192, 25);

		Button button_2 = new Button(shellConta, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellConta.dispose();
				J_02Menu_F_DadosCl cliente = new J_02Menu_F_DadosCl(gestor, uUtilizador, clienteActual);
				cliente.open();
				

			}
		});
		button_2.setText("Dados do cliente");
		button_2.setBounds(10, 146, 192, 25);

		Button button_3 = new Button(shellConta, SWT.TOGGLE);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellConta.dispose();
				J_02Menu_F_MovimentaConta editarconta = new J_02Menu_F_MovimentaConta(gestor, uUtilizador,
						clienteActual, null);
				editarconta.open();

			}
		});
		button_3.setText("Movimentar Contas");
		button_3.setBounds(10, 177, 192, 25);

		Button button_4 = new Button(shellConta, SWT.NONE);
		button_4.setBounds(10, 210, 192, 25);

		Button button_5 = new Button(shellConta, SWT.NONE);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellConta.close();
				J_02_MenuFun_AlteraDados2 alteradados = new J_02_MenuFun_AlteraDados2(gestor, uUtilizador);
				alteradados.open();
			}
		});
		button_5.setText("Alterar Login e Password");
		button_5.setBounds(10, 241, 192, 25);

		Label lblNewLabel = new Label(shellConta, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 192, 68);

	}


	/**
	 * método de procura de cliente cliente por ID
	 */
	public void novoClienteActual() {
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
							+ clienteActual.escolhaID.toString() + ":" + clienteActual.getValorID() + "\n" + "Email:"
							+ clienteActual.getEmail() + "\n" + "Contacto:" + clienteActual.getMobile() + "\n"
							+ "Data Nascimento:" + clienteActual.getDataNascimento() + "\n";
					//// colocaca dados
					txt_Indique_ID.setText("" + clienteActual.getuID());
					lblDadosDoCliente
							.setText("Cliente \n" + clienteActual.getNome() + " " + clienteActual.getSobrenome());
				}
			}
		}

		MessageBox box = new MessageBox(shellConta, SWT.MULTI);
		box.setText("DADOS DO CLIENTE");
		box.setMessage("  " + mensagem);
		box.open();

		if (!(clienteActual.procuraContaPrazo() == null)) {
			String textoCombo[] = { "Conta Normal" };
			combo_NormalPrazo.setItems(textoCombo);

		}
		if (clienteActual.procuraContaPrazo() == null) {
			String textoCombo[] = { "Conta Normal", "Conta prazo" };
			combo_NormalPrazo.setItems(textoCombo);
		}
	}
}
