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

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_ContasCl {

	protected Shell shellMF;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Text Funcionario;
	private Text text_2;
	private Text txt_Indique_ID;
	private Text txtSelecioneUmaConta;
	private Table table;
	private Text text;

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

	public J_02Menu_F_ContasCl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_ContasCl(Gestao gestor, Utilizador uUtilizador,Cliente clienteActual) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		this.clienteActual = clienteActual;
		open();
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

		Button btnExibirContasDo = new Button(shellMF, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 177, 192, 25);

		Button btnDadosDoCliente = new Button(shellMF, SWT.NONE);
		btnDadosDoCliente.setText("Altera dados do cliente");
		btnDadosDoCliente.setBounds(10, 208, 192, 25);

		Button btnFazerDepsitoEm = new Button(shellMF, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 270, 192, 25);

		Button btnListarClientes = new Button(shellMF, SWT.NONE);
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

		Button btnLevantamentoEmDinheiro = new Button(shellMF, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 301, 192, 25);

		Button btnTransferncia = new Button(shellMF, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 333, 192, 25);

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

		text_2 = new Text(shellMF, SWT.BORDER);
		text_2.setBounds(10, 363, 192, 26);

		Composite composite = new Composite(shellMF, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 371);
		

		
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
		
		Label lblDadosDoCliente = new Label(composite, SWT.NONE);
		lblDadosDoCliente.setText("Contas do Cliente");
		lblDadosDoCliente.setAlignment(SWT.CENTER);
		lblDadosDoCliente.setBounds(104, 10, 231, 35);
		
		Label lblListaDeContas = new Label(composite, SWT.CENTER);
		lblListaDeContas.setText("Lista de Transa\u00E7\u00F5es");
		lblListaDeContas.setBounds(23, 85, 372, 15);
		
		if (!(clienteActual==null)) {
	//// colocaca dados
			txt_Indique_ID.setText(""+clienteActual.getuID());
		
		
		}
		
		
		
		
		
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setGrayed(true);
		//*procura pelo cliente através da ID e devolve toda a informação
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				String mensagem="";
				if (estaVazio(txt_Indique_ID)){

					mensagem=" Para procurar um Cliente tem de introduzir um ID"	;
				}
				else {
					if(eNumero(txt_Indique_ID)==-1) {
						mensagem=" O ID do cliente tem de ser numerico"	;
					}
					else {
						if (gestor.procuraCid(Integer.parseInt(txt_Indique_ID.getText()))==null) {
						txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));}
						else {
							clienteActual=gestor.procuraCid(Integer.parseInt(txt_Indique_ID.getText()));
							mensagem="O Cliente" + clienteActual.getNome() + " " + clienteActual.getSobrenome() + " foi encontrado\n"
							+ "Morada:" + clienteActual.getMorada() + "\n" + "" + clienteActual.escolhaID.toString() + ":" + clienteActual.getValorID()
							+ "\n" + "Email:" + clienteActual.getEmail() + "\n" + "Contacto:" + clienteActual.getMobile() + "\n"
							+ "Data Nascimento:" + clienteActual.getDataNascimento() + "\n";
							
						//// colocaca dados
								
													
						}	
					}
					}
				
				
				
				
				
				
				MessageBox box = new MessageBox(shellMF, SWT.MULTI);
//				f = (Cliente) (gestor.getMapUtilizadores().get(text_UserNovoC.getText()));
				box.setText("DADOS DO CLIENTE");
				box.setMessage("  "+ mensagem);
//				
				box.open();
			}
		});
		btnNewButton.setLocation(10, 28);
		btnNewButton.setSize(88, 25);
		btnNewButton.setText("Obter Cliente");
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(171, 59, 224, 23);
		
				Button btnPedirCartaoDe = new Button(composite, SWT.NONE);
				btnPedirCartaoDe.setBounds(23, 271, 184, 25);
				btnPedirCartaoDe.setSelection(true);
				btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					}
				});
				btnPedirCartaoDe.setText("Criar Cartao de Debito");
				
				txtSelecioneUmaConta = new Text(composite, SWT.BORDER | SWT.CENTER);
				txtSelecioneUmaConta.setText("Selecione uma Conta");
				txtSelecioneUmaConta.setBounds(24, 60, 147, 21);
				
				ScrolledComposite scrolledComposite = new ScrolledComposite(composite, SWT.V_SCROLL);
				scrolledComposite.setBounds(24, 106, 370, 159);
				scrolledComposite.setExpandHorizontal(true);
				scrolledComposite.setExpandVertical(true);
				
				table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.VIRTUAL);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn.setWidth(47);
				tblclmnNewColumn.setText("ID");
				
				TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn_1.setWidth(66);
				tblclmnNewColumn_1.setText("Data");
				
				TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn_2.setWidth(66);
				tblclmnNewColumn_2.setText("Tipo");
				
				TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn_3.setWidth(71);
				tblclmnNewColumn_3.setText("Movimento");
				
				TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn_4.setWidth(117);
				tblclmnNewColumn_4.setText("Saldo");
				scrolledComposite.setContent(table);
				scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				
				text = new Text(composite, SWT.BORDER | SWT.CENTER);
				text.setText("Indique o ID");
				text.setBounds(343, 7, 88, 21);
				
				Button btnObterConta = new Button(composite, SWT.NONE);
				btnObterConta.setText("Obter Conta");
				btnObterConta.setGrayed(true);
				btnObterConta.setBounds(343, 28, 88, 25);
				
				Button btnMovimentarConta = new Button(composite, SWT.NONE);
				btnMovimentarConta.setText("Movimentar Conta");
				btnMovimentarConta.setSelection(true);
				btnMovimentarConta.setBounds(211, 271, 184, 25);

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
