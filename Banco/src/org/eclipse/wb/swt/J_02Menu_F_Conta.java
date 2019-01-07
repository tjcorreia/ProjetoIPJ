package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.time.LocalDate;
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
public class J_02Menu_F_Conta {

	protected Shell shellConta;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Conta contaActual;
	private Combo combo;
	private Text Funcionario;
	private Text text_2;
	private Text txt_Indique_ID;
	private Text text_DepositoInicial;
	private Text text_Data;
	private Label lblDadosDoCliente;
	
	
	
	
	
	
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

	public J_02Menu_F_Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_Conta(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual) {
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

	public J_02Menu_F_Conta(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual, Conta contaActual) {
		super();
		this.gestor = gestor;
		this.uUtilizador = uUtilizador;
		this.clienteActual = clienteActual;
		this.contaActual = contaActual;
		open();
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

//				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
//				alteraDados.open();
				shellConta.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnExibirContasDo = new Button(shellConta, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 177, 192, 25);

		Button btnDadosDoCliente = new Button(shellConta, SWT.NONE);
		btnDadosDoCliente.setText("Altera dados do cliente");
		btnDadosDoCliente.setBounds(10, 208, 192, 25);

		Button btnFazerDepsitoEm = new Button(shellConta, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 270, 192, 25);

		Button btnListarClientes = new Button(shellConta, SWT.NONE);
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 115, 192, 25);

		Button btnAlterarLoginE = new Button(shellConta, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);

		Button btnLevantamentoEmDinheiro = new Button(shellConta, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 301, 192, 25);

		Button btnTransferncia = new Button(shellConta, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 333, 192, 25);

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

		text_2 = new Text(shellConta, SWT.BORDER);
		text_2.setBounds(10, 363, 192, 26);

		
		
		lblDadosDoCliente = new Label(composite, SWT.NONE);
		String textoCliente="";
		if(!(clienteActual==null)) {
			textoCliente=("Cliente \n"+clienteActual.getNome()+" "+clienteActual.getSobrenome());}
		else {textoCliente=("Cliente \n");}
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
		
		
		
		Combo combo_NormalPrazo = new Combo(composite, SWT.NONE);
		combo_NormalPrazo.setItems(new String[] { "Conta Normal", "Conta prazo" });
		combo_NormalPrazo.setBounds(104, 101, 103, 23);
		combo_NormalPrazo.select(0);
		
		
		Label lblDepositoInicial = new Label(composite, SWT.NONE);
		lblDepositoInicial.setText("Deposito Inicial");
		lblDepositoInicial.setBounds(10, 135, 88, 15);
		
		text_DepositoInicial = new Text(composite, SWT.BORDER);
		text_DepositoInicial.setBounds(104, 132, 103, 21);
//		text_DepositoInicial.setText("0");
		
		Label lblTipo = new Label(composite, SWT.NONE);
		lblTipo.setAlignment(SWT.RIGHT);
		lblTipo.setText("Tipo ");
		lblTipo.setBounds(10, 104, 88, 15);
		
		Label lblDataCriao = new Label(composite, SWT.NONE);
		lblDataCriao.setText("Data Cria\u00E7\u00E3o");
		lblDataCriao.setBounds(10, 161, 88, 15);
		String data = null;
		LocalDate actual=LocalDate.now();
		
				System.out.println("<---- DATA ACTUAL_LocalDate--->\n" + actual);
		
		text_Data = new Text(composite, SWT.BORDER);
		text_Data.setText(""+actual);
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
			if (clienteActual==null)	{
				MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
				box.setText("ERRO");
				box.setMessage("Para criar a conta tem de ter um Cliente Activo");
				box.open();
				txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			}
			else {
				if(estaVazio(text_DepositoInicial)||!eNumeroIouD(text_DepositoInicial)) {
					MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
					box.setText("ERRO");
					box.setMessage("Valor invalido");
					box.open();
					text_DepositoInicial.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
				else {
					System.out.println("<---- NÃO E DOUBLE? --->"+eNumeroIouD(text_DepositoInicial));
					// conta Normal "Conta Normal", "Conta prazo"
					if (combo_NormalPrazo.getText().equals("Conta Normal")) {
						Conta novaConta=  new ContaNormal(Double.parseDouble(text_DepositoInicial.getText()), ""+actual);
						contaActual=gestor.criaContaNova(clienteActual,novaConta,uUtilizador.getuID());
						MessageBox box = new MessageBox(shellConta, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("CONCLUIDO");
						box.setMessage("Conta Normal:"+contaActual.getContaID()+" Criada !\n");
						box.open();
						J_02Menu_F_DadosCl back= new J_02Menu_F_DadosCl(gestor,uUtilizador,clienteActual);
						back.open();
					shellConta.dispose();
						
					}
					// conta a Prazo
					else if (combo_NormalPrazo.getText().equals("Conta prazo")){
						
						
					}
					
					
					
					
				}
				
			}	
				
				
			}
		});
		btnCriarConta.setBounds(23, 240, 184, 25);
		btnCriarConta.setText("Criar Conta Nova");
		
		
		
	}

	// ***************metodos**************
		// *************** procura cliente por ID**************
	public void novoClienteActual() {
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
					lblDadosDoCliente.setText("Cliente \n"+clienteActual.getNome()+" "+clienteActual.getSobrenome());
				

				}
			}
		}

		MessageBox box = new MessageBox(shellConta, SWT.MULTI);
		box.setText("DADOS DO CLIENTE");
		box.setMessage("  " + mensagem);
		box.open();
	}

	// *************** verifica de cxtexto esta vazia**************
	public boolean estaVazio(Text texto) {

		if (texto.getText().equals("")) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			return true;
		}
		texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		return false;
	}
	
	
	public boolean eNumeroIouD (Text texto) {
		System.out.println("<---- NUMERO? --->\n" + texto.getText());
		if( (eNumero(texto)==-1)){
			System.out.println("<---- NÃO E NUMERO? --->\n");
		String numero = texto.getText();
//		("^\\+?\\[0-9]{0,5}?\\-?\\[0-9]{9}$"
//		Pattern regexPattern = Pattern.compile("^\\+?\\d{0,3}?\\d{9}$");
		Pattern regexPattern2 = Pattern.compile("[0-9]+(\\.){0,1}[0-9]*");
//        Matcher regMatcher   = regexPattern.matcher(mobileNumber);
		Matcher regMatcher2 = regexPattern2.matcher(numero);
		if (regMatcher2.matches()) {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			return true;// "Valid double";
		} else {
			texto.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			System.out.println("<---- NÃO E DOUBLE? FALSE --->\n");
			return false;// "Invalid double";

		}
		}
		else return true;
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
