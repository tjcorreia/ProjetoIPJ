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

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_DadosCl {

	protected Shell shellMF;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Text Funcionario;
	private Text text_2;
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
	private Text txt_Indique_ID;
	private Table table_ListadeContas;

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

	public J_02Menu_F_DadosCl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_DadosCl(Gestao gestor, Utilizador uUtilizador,Cliente clienteActual) {
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

		Button btnPedirCartaoDe = new Button(shellMF, SWT.NONE);
		btnPedirCartaoDe.setSelection(true);
		btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedirCartaoDe.setText("Pedir Cartao de Debito");
		btnPedirCartaoDe.setBounds(10, 239, 192, 25);

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

		Combo combo_TipoID_NovoC = new Combo(composite, SWT.NONE);
		combo_TipoID_NovoC.setItems(new String[] { "Cartao Cidadao", "Passaporte" });
		combo_TipoID_NovoC.setBounds(81, 117, 121, 23);
		combo_TipoID_NovoC.select(0);

		text_ValorID_NovoC = new Text(composite, SWT.BORDER);
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

		Text text_UltimoNovoC = new Text(composite, SWT.BORDER);
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
		

		
		txt_Indique_ID = new Text(composite, SWT.BORDER | SWT.CENTER);
		txt_Indique_ID.setText("Indique o ID");
		txt_Indique_ID.setLocation(10, 7);
		txt_Indique_ID.setSize(88, 21);
		txt_Indique_ID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
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
		btnMovimentarConta.setText("Movimentar Contas");
		btnMovimentarConta.setBounds(245, 267, 88, 58);
		
		Button button_1 = new Button(composite, SWT.TOGGLE | SWT.MULTI | SWT.WRAP | SWT.NONE);
		button_1.setText("Alterar\r\nNovo Cliente");
		button_1.setBounds(339, 267, 81, 58);
		
		Label lblListaDeContas = new Label(composite, SWT.NONE);
		lblListaDeContas.setText("Lista de Contas");
		lblListaDeContas.setBounds(81, 234, 88, 15);
		
		table_ListadeContas = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_ListadeContas.setBounds(81, 255, 131, 82);
		table_ListadeContas.setHeaderVisible(true);
		table_ListadeContas.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table_ListadeContas, SWT.NONE);
		tblclmnId.setWidth(67);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnTitulares = new TableColumn(table_ListadeContas, SWT.NONE);
		tblclmnTitulares.setWidth(57);
		tblclmnTitulares.setText("Titulares");
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		//*procura pelo cliente através da ID e devolve toda a informação
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				String mensagem="";
				if (estaVazio(txt_Indique_ID)){
//					O Cliente" + f.getNome() + " " + f.getSobrenome() + " foi adicionado\n"
//							+ "Morada:" + f.getMorada() + "\n" + "" + f.escolhaID.toString() + ":" + f.getValorID()
//							+ "\n" + "Email:" + f.getEmail() + "\n" + "Contacto:" + f.getMobile() + "\n"
//							+ "Data Nascimento:" + f.getDataNascimento() + "\n"
					
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
							// bolqueia campos não alteraveis
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
							

							table_ListadeContas.clearAll();
							table_ListadeContas.removeAll();
							
							if(!(clienteActual.getLcontaSC()==null)){
							for (int i=0;i<clienteActual.getLcontaSC().size();i++) {
								TableItem item = new TableItem(table_ListadeContas, SWT.NULL);
								item.setText(0, ("" + clienteActual.getLcontaSC().get(i).getContaID()));
								item.setText(1, ("" + clienteActual.getLcontaSC().get(i).getClientesDaC().size()));
//								
							}
							
							
							
							}
							
							
						}	
					}
					}
				
				
				
				
				
				
				MessageBox box = new MessageBox(shellMF, SWT.MULTI);
//				f = (Cliente) (gestor.getMapUtilizadores().get(text_UserNovoC.getText()));
				box.setText("DADOS DO CLIENTE");
				box.setMessage("  ");
//				
				box.open();
			}
		});
		btnNewButton.setLocation(10, 28);
		btnNewButton.setSize(88, 25);
		btnNewButton.setText("Obter Cliente");

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
