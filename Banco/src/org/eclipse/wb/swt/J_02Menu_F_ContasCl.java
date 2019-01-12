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
import org.eclipse.wb.swt.Transacao.TipoT;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_ContasCl {

	protected Shell shellMF_Contas;
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
	private Button btnMovimentarConta;

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

	

	/**
	 * @wbp.parser.entryPoint
	 */
	
	public J_02Menu_F_ContasCl() {
		super();
		open();
		// TODO Auto-generated constructor stub
	}
	
	public J_02Menu_F_ContasCl(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		this.clienteActual = clienteActual;
		if (!(clienteActual == null)) {
			this.contaActual = clienteActual.getLcontaSC().get(0);
		} else {
			contaActual = null;
		}
		
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

	public J_02Menu_F_ContasCl(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual, Conta contaActual) {
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
		shellMF_Contas.open();
		shellMF_Contas.layout();
		while (!shellMF_Contas.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellMF_Contas = new Shell();
		shellMF_Contas.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
	
		shellMF_Contas.setImage((Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo.png"));
		shellMF_Contas.setSize(707, 533);
		shellMF_Contas.setText("Menu Funcion\u00E1rio");

		System.out.println("<---- Utilizador Actual --->/n" + uUtilizador);
		System.out.println("<---- Cliente Actual --->/n" + clienteActual);
		System.out.println("<---- Conta Actual --->/n" + contaActual);

		Composite composite = new Composite(shellMF_Contas, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 371);

		ScrolledComposite scrolledComposite_Tabela = new ScrolledComposite(composite, SWT.V_SCROLL);
		scrolledComposite_Tabela.setBounds(24, 106, 370, 159);
		scrolledComposite_Tabela.setExpandHorizontal(true);
		scrolledComposite_Tabela.setExpandVertical(true);

		table = new Table(scrolledComposite_Tabela, SWT.BORDER | SWT.FULL_SELECTION | SWT.VIRTUAL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmn_ID = new TableColumn(table, SWT.NONE);
		tblclmn_ID.setWidth(43);
		tblclmn_ID.setText("ID");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(73);
		tblclmnNewColumn_1.setText("Data");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(105);
		tblclmnNewColumn_2.setText("Tipo");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(70);
		tblclmnNewColumn_3.setText("Movimento");

		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(73);
		tblclmnNewColumn_4.setText("Saldo");
		scrolledComposite_Tabela.setContent(table);
		scrolledComposite_Tabela.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		combo_EscolhaConta = new Combo(composite, SWT.NONE);
		combo_EscolhaConta.setBounds(171, 59, 224, 23);

		btnMovimentarConta = new Button(composite, SWT.NONE);
		btnMovimentarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				J_02Menu_F_MovimentaConta movimentar= new	J_02Menu_F_MovimentaConta(gestor, uUtilizador,clienteActual,contaActual);
				movimentar.open();
				shellMF_Contas.dispose();
			}
		});
		btnMovimentarConta.setText("Movimentar Conta");
		btnMovimentarConta.setSelection(true);
		btnMovimentarConta.setBounds(24, 287, 184, 25);

		text_contaActual = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_contaActual.setText("Indique o ID");
		// introduz o ID da Contaactual
		if (contaActual == null) {
			text_contaActual.setText("Indique o ID");
		}
		else {
			text_contaActual.setText(""+contaActual.getContaID());	
		}
		text_contaActual.setBounds(343, 7, 88, 21);

		txt_Indique_ID = new Text(composite, SWT.BORDER | SWT.CENTER);
		// introduz o ID do Cliente actual se vier de outra janela
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
				}
				System.out.println("<---- lista de contas --->/n" + listaContas.length);
				combo_EscolhaConta.setItems(listaContas);
				
			} else {
				combo_EscolhaConta.setItems("Não existem contas a apresentar");
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

		Button btnNovoCliente = new Button(shellMF_Contas, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

//				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
//				alteraDados.open();
				shellMF_Contas.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnAlterarLoginE = new Button(shellMF_Contas, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);

		Button button = new Button(shellMF_Contas, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_Contas.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shellMF_Contas, SWT.BORDER);
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

				MessageBox box = new MessageBox(shellMF_Contas, SWT.MULTI);
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
		
		Button button_1 = new Button(shellMF_Contas, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				J_02Menu_F_ListaClientes listaC = new J_02Menu_F_ListaClientes(gestor, uUtilizador);
				listaC.open();
				shellMF_Contas.dispose();
			}
			
		});
		button_1.setText("Listar/Procurar Clientes");
		button_1.setBounds(10, 115, 192, 25);
		
		Button button_2 = new Button(shellMF_Contas, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				J_02Menu_F_DadosCl cliente=new J_02Menu_F_DadosCl(gestor,uUtilizador,clienteActual);
				cliente.open();
				shellMF_Contas.dispose();
			}
		});
		button_2.setText("Dados do cliente");
		button_2.setBounds(10, 146, 192, 25);
		
		Button button_3 = new Button(shellMF_Contas, SWT.TOGGLE);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				J_02Menu_F_MovimentaConta editarconta = new J_02Menu_F_MovimentaConta(gestor, uUtilizador,
						clienteActual, null);
				editarconta.open();
				shellMF_Contas.dispose();
			}
		});
		button_3.setText("Movimentar Contas");
		button_3.setBounds(10, 177, 192, 25);
		
		Button button_4 = new Button(shellMF_Contas, SWT.NONE);
		button_4.setBounds(10, 210, 192, 25);
		
		Button button_5 = new Button(shellMF_Contas, SWT.NONE);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_Contas.close();
				J_02_MenuFun_AlteraDados2 alteradados=new J_02_MenuFun_AlteraDados2(gestor, uUtilizador); 
				alteradados.open();
			}
		});
		button_5.setText("Alterar Login e Password");
		button_5.setBounds(10, 241, 192, 25);

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
		if (contaActual.getTransacoesC().get(i).getEscolhaT().equals(TipoT.TRANSFERENCIA)) {
			item.setText(2, ("TRF<" + contaActual.getTransacoesC().get(i).getContadestino())+">");
		}
		else {item.setText(2, ("" + contaActual.getTransacoesC().get(i).getEscolhaT()));}
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





	
	}

