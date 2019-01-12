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
public class J_03_Menu_CLIENTE_AlteraDados3 {

	protected Shell shell;
	private Text text;
	private Utilizador uUtilizador;
	private Gestao gestor;
	private Text text_PrimeiroNA;
	private Text text_Morada_NA;
	private Text text_ValorID_NA;
	private Text text_Email_NA;
	private Text text_MobileA;
	private Text text_UserA;
	private Text text_PassNovoF;
	private Text text_UltimoNA;
	private Text text_DataA_Ano;
	private Text text_DataA_mes;
	private Text text_DataA_dia;
	private Button Buton_AlteraDados;
	private Composite composite_BOX;
	private Text text_ID;

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
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

	public Text getText_PrimeiroNA() {
		return text_PrimeiroNA;
	}

	public void setText_PrimeiroNA(Text text_PrimeiroNA) {
		this.text_PrimeiroNA = text_PrimeiroNA;
	}

	public Text getText_Morada_NA() {
		return text_Morada_NA;
	}

	public void setText_Morada_NA(Text text_Morada_NA) {
		this.text_Morada_NA = text_Morada_NA;
	}

	public Text getText_ValorID_NA() {
		return text_ValorID_NA;
	}

	public void setText_ValorID_NA(Text text_ValorID_NA) {
		this.text_ValorID_NA = text_ValorID_NA;
	}

	public Text getText_Email_NA() {
		return text_Email_NA;
	}

	public void setText_Email_NA(Text text_Email_NA) {
		this.text_Email_NA = text_Email_NA;
	}

	public Text getText_MobileA() {
		return text_MobileA;
	}

	public void setText_MobileA(Text text_MobileA) {
		this.text_MobileA = text_MobileA;
	}

	public Text getText_UserA() {
		return text_UserA;
	}

	public void setText_UserA(Text text_UserA) {
		this.text_UserA = text_UserA;
	}

	public Text getText_PassNovoF() {
		return text_PassNovoF;
	}

	public void setText_PassNovoF(Text text_PassNovoF) {
		this.text_PassNovoF = text_PassNovoF;
	}

	public Text getText_UltimoNA() {
		return text_UltimoNA;
	}

	public void setText_UltimoNA(Text text_UltimoNA) {
		this.text_UltimoNA = text_UltimoNA;
	}

	public Text getText_DataA_Ano() {
		return text_DataA_Ano;
	}

	public void setText_DataA_Ano(Text text_DataA_Ano) {
		this.text_DataA_Ano = text_DataA_Ano;
	}

	public Text getText_DataA_mes() {
		return text_DataA_mes;
	}

	public void setText_DataA_mes(Text text_DataA_mes) {
		this.text_DataA_mes = text_DataA_mes;
	}

	public Text getText_DataA_dia() {
		return text_DataA_dia;
	}

	public void setText_DataA_dia(Text text_DataA_dia) {
		this.text_DataA_dia = text_DataA_dia;
	}

	public J_03_Menu_CLIENTE_AlteraDados3(Gestao gestor, Utilizador uUtilizador) {

		this.uUtilizador = uUtilizador;
		this.gestor = gestor;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_03_Menu_CLIENTE_AlteraDados3() {

		open();
		// TODO Auto-generated constructor stub
	}

//	public static void main(String[] args) {
//		try {
//			J_02_MenuFun_AlteraDados2 window = new J_02_MenuFun_AlteraDados2();
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
		shell.setSize(743, 450);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shell.setImage((Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo.png"));
		shell.setText("MENU ADMINISTRADOR");

		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uUtilizador.nome);
		text.setBounds(236, 12, 288, 25);

		composite_BOX = new Composite(shell, SWT.NONE);
		composite_BOX.setBounds(236, 84, 430, 301);

		

		Label lblNewLabel = new Label(composite_BOX, SWT.NONE);
		lblNewLabel.setBounds(10, 104, 70, 15);
		lblNewLabel.setText("Identifica\u00E7ao");

		Label Nome_novoF = new Label(composite_BOX, SWT.NONE);
		Nome_novoF.setBounds(10, 47, 55, 15);
		Nome_novoF.setText("Nome");

		text_PrimeiroNA = new Text(composite_BOX, SWT.BORDER);
		text_PrimeiroNA.setBounds(81, 44, 163, 21);

		Label lblMoradaNovoF = new Label(composite_BOX, SWT.NONE);
		lblMoradaNovoF.setText("Morada");
		lblMoradaNovoF.setBounds(10, 75, 55, 15);

		text_Morada_NA = new Text(composite_BOX, SWT.BORDER);
		text_Morada_NA.setBounds(81, 72, 339, 21);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };
		Combo TipoID_NovoF = new Combo(composite_BOX, SWT.NONE);
		TipoID_NovoF.setItems(comboB);
		TipoID_NovoF.select(0);
		TipoID_NovoF.setBounds(81, 99, 121, 23);

		text_ValorID_NA = new Text(composite_BOX, SWT.BORDER);
		text_ValorID_NA.setBounds(208, 101, 212, 21);

		Label lblEmail_novoF = new Label(composite_BOX, SWT.NONE);
		lblEmail_novoF.setText("Email");
		lblEmail_novoF.setBounds(10, 131, 55, 15);

		text_Email_NA = new Text(composite_BOX, SWT.BORDER);
		text_Email_NA.setBounds(81, 128, 339, 21);

		Label lblContacto = new Label(composite_BOX, SWT.NONE);
		lblContacto.setText("Contacto");
		lblContacto.setBounds(10, 165, 55, 15);

		text_MobileA = new Text(composite_BOX, SWT.BORDER);
		text_MobileA.setBounds(81, 162, 88, 21);

		Label lblNomeDeUtilizador = new Label(composite_BOX, SWT.NONE);
		lblNomeDeUtilizador.setText("Utilizador");
		lblNomeDeUtilizador.setBounds(10, 192, 55, 15);

		text_UserA = new Text(composite_BOX, SWT.BORDER);
		text_UserA.setBounds(81, 189, 121, 21);

		Label lblPassword = new Label(composite_BOX, SWT.NONE);
		lblPassword.setText("Password");
		lblPassword.setBounds(228, 192, 55, 15);

		text_PassNovoF = new Text(composite_BOX, SWT.BORDER);
		text_PassNovoF.setBounds(289, 189, 131, 21);

		Label Titulo_Novo_F = new Label(composite_BOX, SWT.NONE);
		Titulo_Novo_F.setAlignment(SWT.CENTER);
		Titulo_Novo_F.setBounds(93, 2, 310, 15);
		Titulo_Novo_F.setText("Dados Pessoais");

		Buton_AlteraDados = new Button(composite_BOX, SWT.MULTI | SWT.WRAP | SWT.NONE);

		Buton_AlteraDados.setBounds(289, 233, 103, 58);
		Buton_AlteraDados.setText("Alterar os seus dados pessoais");

		text_UltimoNA = new Text(composite_BOX, SWT.BORDER);
		text_UltimoNA.setBounds(250, 44, 170, 21);

		Label lblprimeiro = new Label(composite_BOX, SWT.NONE);
		lblprimeiro.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblprimeiro.setText("(primeiro)");
		lblprimeiro.setBounds(125, 29, 55, 15);

		Label lblultimo = new Label(composite_BOX, SWT.NONE);
		lblultimo.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblultimo.setText("(ultimo)");
		lblultimo.setBounds(302, 29, 55, 15);

		Label lblDataNas = new Label(composite_BOX, SWT.NONE);
		lblDataNas.setText("Data Nas.(aaaa/mm/dd)");
		lblDataNas.setBounds(175, 165, 132, 15);

		text_DataA_Ano = new Text(composite_BOX, SWT.BORDER);
		text_DataA_Ano.setBounds(313, 164, 40, 21);

		text_DataA_mes = new Text(composite_BOX, SWT.BORDER);
		text_DataA_mes.setBounds(363, 164, 23, 21);
		Image image2 = (Image) SWTResourceManager.getImage(J_03Menu_CLIENTE_contas.class,
				"/Logo/Java-logo-png Logo13.png");

		Label lblimagem = new Label(shell, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shell, image2, lblimagem.getBounds().width, lblimagem.getBounds().height));

		Label label = new Label(composite_BOX, SWT.NONE);
		label.setText("/");
		label.setBounds(355, 167, 8, 15);

		Label label_1 = new Label(composite_BOX, SWT.NONE);
		label_1.setText("/");
		label_1.setBounds(387, 167, 8, 15);

		text_DataA_dia = new Text(composite_BOX, SWT.BORDER);
		text_DataA_dia.setBounds(395, 164, 23, 21);

		Button button_Logout = new Button(shell, SWT.NONE);
		button_Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				shell.dispose();

			}
		});
		button_Logout.setText("Log Out");
		button_Logout.setBounds(591, 10, 75, 25);

		//// colocaca dados
		text_PrimeiroNA.setText(uUtilizador.getNome());
		text_UltimoNA.setText(uUtilizador.getSobrenome());
		text_Morada_NA.setText(uUtilizador.getMorada());
		text_UserA.setText(uUtilizador.getLogin());
		text_PassNovoF.setText(uUtilizador.getPassword());
		;
		text_ValorID_NA.setText(uUtilizador.getValorID());
		text_Email_NA.setText(uUtilizador.getEmail());
		text_MobileA.setText("" + uUtilizador.getMobile());
		String[] data = uUtilizador.getDataNascimento().split("/");
		text_DataA_Ano.setText(data[0]);
		;
		text_DataA_mes.setText(data[1]);
		;
		text_DataA_dia.setText(data[2]);
		;
		TipoID_NovoF.setText(uUtilizador.getEscolhaID().toString());
		// bolqueia campos não alteraveis
		text_PrimeiroNA.setEnabled(false);

		text_UltimoNA.setEnabled(false);
		text_Morada_NA.setEnabled(false);
		text_UserA.setEnabled(false);
		text_PassNovoF.setEnabled(false);
		;
		text_ValorID_NA.setEnabled(false);
		text_Email_NA.setEnabled(false);
		text_MobileA.setEnabled(false);
		text_DataA_Ano.setEnabled(false);
		text_DataA_mes.setEnabled(false);
		text_DataA_dia.setEnabled(false);
		TipoID_NovoF.setEnabled(false);
		
		text_ID = new Text(composite_BOX, SWT.BORDER | SWT.CENTER);
		text_ID.setBounds(0, 2, 88, 21);
		text_ID.setText(""+uUtilizador.getuID());
		text_ID.setEnabled(false);

		Button button = new Button(shell, SWT.NONE);
		button.setText("Dados Pessoais");
		button.setBounds(10, 84, 192, 25);

		Button btnContas = new Button(shell, SWT.NONE);
		btnContas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_03Menu_CLIENTE_contas lclientes=new J_03Menu_CLIENTE_contas(gestor,uUtilizador);
				lclientes.open();
				
			}
		});
		btnContas.setText("Contas");
		btnContas.setBounds(10, 112, 192, 25);

		Button btnCartesDaConta = new Button(shell, SWT.TOGGLE);
		btnCartesDaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_03Menu_CLIENTE_Cartoes editarconta= new J_03Menu_CLIENTE_Cartoes( gestor, uUtilizador);
				editarconta.open();
			}
		});
		btnCartesDaConta.setText("Cart\u00F5es da Conta");
		btnCartesDaConta.setBounds(10, 143, 192, 25);

		// Botao Altera dados.
		Buton_AlteraDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				if (Buton_AlteraDados.getText().equals("Altere Os DadoS")) {
					// altera dados do Cliente
					boolean verificatudo = true;
					String mensagem = "";
					boolean naohaDadosPorPreencher = true;
					// Verifica campos vazios
					if (estaVazio(text_Email_NA) || estaVazio(text_UserA) || estaVazio(text_PassNovoF)) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						Titulo_Novo_F.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
						System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
						mensagem = mensagem + "Tem dados por preencher\n";
						estaVazio(text_Email_NA);
						estaVazio(text_UserA);
						estaVazio(text_PassNovoF);
						naohaDadosPorPreencher = false;

					}

					if (!validateEmail(text_Email_NA)) {
						System.out.println("VERIFICACAO DE Email ->" + text_Email_NA.getText());
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Email inválido.\n";
						naohaDadosPorPreencher = false;
					}

					if (naohaDadosPorPreencher) {
						System.out.println(text_Email_NA.getText());
						System.out.println(text_UserA.getText());
						System.out.println(uUtilizador.getEmail());
						System.out.println(uUtilizador.getLogin());

						String verifica = gestor.verificaA(uUtilizador, text_Email_NA, text_UserA,
								uUtilizador.getEmail(), uUtilizador.getLogin());

						System.out.println(("VERIFICA? --->" + verifica));
	
						if (verifica.equals("")) {
							String oldkey = uUtilizador.getLogin();
							uUtilizador.setLogin(text_UserA.getText());
							uUtilizador.setPassword(text_PassNovoF.getText());
							uUtilizador.setEmail(text_Email_NA.getText());
							gestor.getMapUtilizadores().remove(oldkey);
							gestor.getMapUtilizadores().put(uUtilizador.getLogin(), uUtilizador);
							
							// fui buscar ao Utilizadores para confirmar que esta lá
							Cliente f = new Cliente();
							MessageBox box = new MessageBox(shell, SWT.MULTI);
							System.out.println(("ERRO 1? --->" + verifica));
							f = (Cliente) (gestor.getMapUtilizadores().get(text_UserA.getText()));

							box.setText("CONCLUSÃO");
							box.setMessage("" + f.getNome() + "  " + f.getSobrenome()
									+ " os seu dados foram Actualizados\n" + "\n" + "Email:" + f.getEmail()
									+ "\nLogin: " + f.getLogin() + " \nPassword: " + f.getPassword());
//						
							box.open();

							System.out.println(("verifica"));
							Buton_AlteraDados.setText("Alteração de Dados");
							text_PassNovoF.setEnabled(false);
							text_UserA.setEnabled(false);
							text_Email_NA.setEnabled(false);
							Buton_AlteraDados.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GRAY));

						} else {
							System.out.println(("----> Nao verifica"));
							verifica = "Dados por  inválidos:\n" + verifica;
							MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
							box.setText("ERRO");
							box.setMessage(verifica);
							box.open();
//							
						}

					} else {
						MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage(mensagem);
						box.open();
						
						naohaDadosPorPreencher = true;
					}
					
				} else {// liberta dados que podem ser alterados
					text_PassNovoF.setEnabled(true);
					text_UserA.setEnabled(true);
					text_Email_NA.setEnabled(true);
					Buton_AlteraDados.setText("Altere Os DadoS");
					Buton_AlteraDados.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
					
				}

			}
		});

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

	public Button getButon_AlteraDados() {
		return Buton_AlteraDados;
	}

	public void setButon_AlteraDados(Button buton_AlteraDados) {
		Buton_AlteraDados = buton_AlteraDados;
	}

	public Composite getComposite() {
		return composite_BOX;
	}

	public void setComposite(Composite composite) {
		this.composite_BOX = composite;
	}

}
