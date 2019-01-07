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
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_MovimentaConta {

	protected Shell shellMF_ModificaContas;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Conta contaActual;
	private Text Funcionario;
	private Text txt_Indique_ID;
	private Text txtSelecioneUmaConta;
	private Table table;
	private Text text_contaActual;
	private Combo combo_EscolhaConta;
	private Text text;
	private Text text_1;
	private Text text_3;
	private Text text_4;
	private Text text_2;
	private Text text_5;

	public Combo getCombo_EscolhaConta() {
		return combo_EscolhaConta;
	}

	public void setCombo_EscolhaConta(Combo combo_EscolhaConta) {
		this.combo_EscolhaConta = combo_EscolhaConta;
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

	

	public J_02Menu_F_MovimentaConta(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual, Conta contaActual) {
		super();
		this.gestor = gestor;
		this.uUtilizador = uUtilizador;
		this.clienteActual = clienteActual;
		this.contaActual = contaActual;
		open();
	}	
	

	/**
	 * Launch the application.
	 * 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_MovimentaConta window = new J_02Menu_F_MovimentaConta(new Gestao(), new Utilizador(), new Cliente(),new Conta());
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
		shellMF_ModificaContas.open();
		shellMF_ModificaContas.layout();
		while (!shellMF_ModificaContas.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellMF_ModificaContas = new Shell();
		shellMF_ModificaContas.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shellMF_ModificaContas.setSize(707, 545);
		shellMF_ModificaContas.setText("Menu Funcion\u00E1rio");
		
		
		System.out.println("<---- MENU MOVIMENTOS --->/n" + contaActual);
		System.out.println("<---- Utilizador Actual --->/n" + uUtilizador);
		System.out.println("<---- Cliente Actual --->/n" + clienteActual);
		System.out.println("<---- Conta Actual --->/n" + contaActual);

		Composite composite = new Composite(shellMF_ModificaContas, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 400);

		ScrolledComposite scrolledComposite_Tabela = new ScrolledComposite(composite, SWT.V_SCROLL);
		scrolledComposite_Tabela.setBounds(24, 106, 395, 67);
		scrolledComposite_Tabela.setExpandHorizontal(true);
		scrolledComposite_Tabela.setExpandVertical(true);

		table = new Table(scrolledComposite_Tabela, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION | SWT.VIRTUAL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmn_ID = new TableColumn(table, SWT.CENTER);
		tblclmn_ID.setWidth(43);
		tblclmn_ID.setText("ID");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(73);
		tblclmnNewColumn_1.setText("Data");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(105);
		tblclmnNewColumn_2.setText("Tipo");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(70);
		tblclmnNewColumn_3.setText("Movimento");

		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(84);
		tblclmnNewColumn_4.setText("Saldo");
		scrolledComposite_Tabela.setContent(table);
		scrolledComposite_Tabela.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		combo_EscolhaConta = new Combo(composite, SWT.NONE);
		combo_EscolhaConta.setBounds(171, 59, 224, 23);

		text_contaActual = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_contaActual.setText("Indique o ID");
		
		text_contaActual.setBounds(343, 7, 88, 21);

		txt_Indique_ID = new Text(composite, SWT.BORDER | SWT.CENTER);
		// introduz o ID do Cliente actual se vier de outra janela
		int index=-1;
		if (clienteActual == null) {
			txt_Indique_ID.setText("Indique o ID");
		} else { // preeche os dados
			txt_Indique_ID.setText("" + clienteActual.getuID());
			
			
			if (!(clienteActual.getLcontaSC().size() == 0)) {
				String[] listaContas = new String[clienteActual.getLcontaSC().size()];
				System.out.println("<---- lista de contas --->/n" + clienteActual.getLcontaSC().size());
				for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
					if (clienteActual.getLcontaSC().get(i).getAbertaFechada().equals(Conta.TipoC.ENCERADA)) {
						listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID() + ("(ENCERRADA)");
					} else {
						listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID();
					}
					if (clienteActual.getLcontaSC().get(i)==contaActual) {index=i;}
				}
				System.out.println("<---- lista de contas --->/n" + listaContas.length);
				combo_EscolhaConta.setItems(listaContas);
				combo_EscolhaConta.select(index);
				
			} else {
				combo_EscolhaConta.setItems("Não existem contas a apresentar");
			}
			
		}
		// introduz o ID da Contaactual
				if (contaActual == null) {
					text_contaActual.setText("Indique o ID");
				}
				else {
					if (clienteActual == null) {
						combo_EscolhaConta.setItems(""+contaActual.getContaID());
						combo_EscolhaConta.select(0);
					}
					else {
					text_contaActual.setText(""+contaActual.getContaID());
					if (index!=-1) {combo_EscolhaConta.select(index);preencheTabela();}
					}
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

		// seleção da conta a presentar
		combo_EscolhaConta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				preencheTabela();

			}
		});

		Button btnNovoCliente = new Button(shellMF_ModificaContas, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

//				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
//				alteraDados.open();
				shellMF_ModificaContas.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnExibirContasDo = new Button(shellMF_ModificaContas, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 177, 192, 25);

		Button btnDadosDoCliente = new Button(shellMF_ModificaContas, SWT.NONE);
		btnDadosDoCliente.setText("Altera dados do cliente");
		btnDadosDoCliente.setBounds(10, 208, 192, 25);

		Button btnListarClientes = new Button(shellMF_ModificaContas, SWT.NONE);
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 115, 192, 25);

		Button btnAlterarLoginE = new Button(shellMF_ModificaContas, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);

		Button button = new Button(shellMF_ModificaContas, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_ModificaContas.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shellMF_ModificaContas, SWT.BORDER);
		Funcionario.setText("Bem Vindo " + uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);

		Label lblDadosDoCliente = new Label(composite, SWT.NONE);
		lblDadosDoCliente.setText("Contas do Cliente");
		lblDadosDoCliente.setAlignment(SWT.CENTER);
		lblDadosDoCliente.setBounds(104, 10, 231, 15);

		Label lblListaDeContas = new Label(composite, SWT.CENTER);
		lblListaDeContas.setText("Lista de Transa\u00E7\u00F5es");
		lblListaDeContas.setBounds(23, 85, 372, 15);

		Button btn_ProcuraCliente = new Button(composite, SWT.NONE);
		btn_ProcuraCliente.setGrayed(true);
		// *procura pelo cliente através da ID e devolve toda a informação
		btn_ProcuraCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				String mensagem = "";
				if (estaVazio(txt_Indique_ID)) {
					mensagem = " Para procurar um Cliente tem de introduzir um ID";
				} else {
					if (eNumero(txt_Indique_ID) == -1) {
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
							txt_Indique_ID.setText("" + clienteActual.getuID());

							if (!(clienteActual.getLcontaSC().size() == 0)) {
								String[] listaContas = new String[clienteActual.getLcontaSC().size()];
								System.out.println("<---- lista de contas --->/n" + clienteActual.getLcontaSC().size());
								for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
									if (clienteActual.getLcontaSC().get(i).getAbertaFechada()
											.equals(Conta.TipoC.ENCERADA)) {
										listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID()
												+ ("(ENCERRADA)");
									} else {
										listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID();
									}

								}
								System.out.println("<---- lista de contas --->/n" + listaContas.length);
								combo_EscolhaConta.setItems(listaContas);
//								item.setText(0, ("" + clienteActual.getLcontaSC().get(i).getContaID()));
//								item.setText(1, ("" + clienteActual.getLcontaSC().get(i).getClientesDaC().size()));	
							} else {
								combo_EscolhaConta.setItems("Não existem contas a apresentar");
							}

						}
					}
				}

				MessageBox box = new MessageBox(shellMF_ModificaContas, SWT.MULTI);
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

		txtSelecioneUmaConta = new Text(composite, SWT.BORDER | SWT.CENTER);
		txtSelecioneUmaConta.setText("Selecione uma Conta");
		txtSelecioneUmaConta.setBounds(24, 60, 147, 21);

		Button btnObterConta = new Button(composite, SWT.NONE);
		btnObterConta.setText("Obter Conta");
		btnObterConta.setGrayed(true);
		btnObterConta.setBounds(343, 28, 88, 25);
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Encerrar Conta");
		button_1.setSelection(true);
		button_1.setBounds(25, 318, 141, 25);
		
		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setText("Criar Cart\u00E3o de Credito");
		button_2.setSelection(true);
		button_2.setBounds(25, 287, 141, 25);
		
		Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setBounds(172, 289, 93, 23);
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("(escolha titular)");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		label.setAlignment(SWT.CENTER);
		label.setBounds(172, 278, 93, 10);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Transaferencia");
		button_3.setSelection(true);
		button_3.setBounds(24, 256, 142, 25);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(172, 256, 93, 21);
		
		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setText("Levantar Valor");
		button_4.setSelection(true);
		button_4.setBounds(24, 223, 142, 25);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(172, 224, 93, 21);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("(valor)");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(172, 244, 93, 10);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("(valor)");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		label_2.setAlignment(SWT.CENTER);
		label_2.setBounds(172, 212, 93, 10);
		
		Button button_5 = new Button(composite, SWT.NONE);
		button_5.setText("Depositar Valor");
		button_5.setSelection(true);
		button_5.setBounds(24, 190, 142, 25);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(172, 192, 93, 21);
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("(valor)");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		label_3.setAlignment(SWT.CENTER);
		label_3.setBounds(172, 179, 93, 10);
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("ID Conta Destino");
		label_4.setAlignment(SWT.CENTER);
		label_4.setBounds(271, 240, 111, 15);
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setBounds(271, 256, 111, 21);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(271, 291, 111, 21);
		
		Label lblcartaoAssociado = new Label(composite, SWT.NONE);
		lblcartaoAssociado.setText("(cartao associado)");
		lblcartaoAssociado.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		lblcartaoAssociado.setAlignment(SWT.CENTER);
		lblcartaoAssociado.setBounds(271, 278, 111, 10);
		
		Button btnAdicionarTitular = new Button(composite, SWT.NONE);
		btnAdicionarTitular.setText("Adicionar Titular");
		btnAdicionarTitular.setSelection(true);
		btnAdicionarTitular.setBounds(24, 346, 141, 25);
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setBounds(171, 348, 93, 21);
		
		Label lblidDoCliente = new Label(composite, SWT.NONE);
		lblidDoCliente.setText("(ID do Cliente)");
		lblidDoCliente.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		lblidDoCliente.setAlignment(SWT.CENTER);
		lblidDoCliente.setBounds(171, 334, 93, 10);
		
		Button button_6 = new Button(composite, SWT.NONE);
		button_6.setText("Obter Cliente");
		button_6.setGrayed(true);
		button_6.setBounds(270, 346, 88, 25);

	}

	// ***************metodos**************
public void preencheTabela() {
	table.setEnabled(true);
	table.clearAll();
	table.removeAll();
	int contaID = 0;
	if (combo_EscolhaConta.getText().contains("(ENCERRADA)")) {
		String textoConta = combo_EscolhaConta.getText();
		textoConta = textoConta.replace("(ENCERRADA)", "");
		System.out.println("<---- texto : " + textoConta);
		contaID = Integer.parseInt(textoConta);
	} else {
		contaID = Integer.parseInt(combo_EscolhaConta.getText());
	}

	contaActual = clienteActual.procuraConta(contaID);
	text_contaActual.setText(""+contaActual.getContaID());
	System.out.println("<---- Conta Actual-Transaçoes ( " + contaActual.getTransacoesC().size() + ") --->\n");
	// saldo e calculado para cada transação
	double saldoI = contaActual.getSaldo();
	for (int i = contaActual.getTransacoesC().size() - 1; i >= 0; i--) {
		TableItem item = new TableItem(table, SWT.NULL);
		item.setText(0, ("" + contaActual.getTransacoesC().get(i).gettID()));
		item.setText(1, ("" + contaActual.getTransacoesC().get(i).getData()));
		item.setText(2, ("" + contaActual.getTransacoesC().get(i).getEscolhaT()));
		item.setText(3, ("" + contaActual.getTransacoesC().get(i).getValor()));
		item.setText(4, ("" + (saldoI)));
		saldoI = saldoI - contaActual.getTransacoesC().get(i).getValor();
	}
	if (combo_EscolhaConta.getText().contains("(ENCERRADA)")) {

//		btnMovimentarConta.setVisible(false);
		System.out.println("<---- ?????????? Bloqueia Botao");
		table.setEnabled(false);
	}
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
