package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_01_Administrador {

	protected Shell shell;
	private Text text;
	private Utilizador uAdministrador;
	private Table table;
	private Text text_NomeNovoF;
	private Text text_Morada_NovoF;
	private Text text_ValorID_NovoF;
	private Text text_Email_NovoF;
	private Text text_MobileNovoF;
	private Text text_UserNovoF;
	private Text text_PassNovoF;
	private Text text_PosicaoNovoF;

	public Utilizador getuAdministrador() {
		return uAdministrador;
	}

	public void setuAdministrador(Utilizador uAdministrador) {
		this.uAdministrador = uAdministrador;
	}

	public J_01_Administrador(Utilizador uAdministrador) {

		this.uAdministrador = uAdministrador;
		// TODO Auto-generated constructor stub
	}

	public J_01_Administrador() {
		super();
		open();
	
		// TODO Auto-generated constructor stub
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		try {
//			J_01_Administrador window = new J_01_Administrador(new Utilizador());
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
		Gestao g = new Gestao();
		shell = new Shell();
		shell.setSize(651, 408);
		shell.setText("MENU ADMINISTRADOR");

		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(10, 10, 458, 25);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(182, 41, 430, 301);

		composite.setVisible(true);

		// *********** Cria novo Funcionario

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(10, 104, 70, 15);
		lblNewLabel.setText("Identifica\u00E7ao");

		Label Nome_novoF = new Label(composite, SWT.NONE);
		Nome_novoF.setBounds(10, 47, 55, 15);
		Nome_novoF.setText("Nome");

		text_NomeNovoF = new Text(composite, SWT.BORDER);
		text_NomeNovoF.setBounds(81, 44, 339, 21);

		Label lblMoradaNovoF = new Label(composite, SWT.NONE);
		lblMoradaNovoF.setText("Morada");
		lblMoradaNovoF.setBounds(10, 75, 55, 15);

		text_Morada_NovoF = new Text(composite, SWT.BORDER);
		text_Morada_NovoF.setBounds(81, 72, 339, 21);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };
		Combo TipoID_NovoF = new Combo(composite, SWT.NONE);
		TipoID_NovoF.setItems(comboB);
		TipoID_NovoF.select(0);
		TipoID_NovoF.setBounds(81, 99, 131, 23);

		text_ValorID_NovoF = new Text(composite, SWT.BORDER);
		text_ValorID_NovoF.setBounds(218, 100, 202, 21);

		Label lblEmail_novoF = new Label(composite, SWT.NONE);
		lblEmail_novoF.setText("Email");
		lblEmail_novoF.setBounds(10, 131, 55, 15);

		text_Email_NovoF = new Text(composite, SWT.BORDER);
		text_Email_NovoF.setBounds(81, 128, 339, 21);

		Label lblContacto = new Label(composite, SWT.NONE);
		lblContacto.setText("Contacto");
		lblContacto.setBounds(10, 165, 55, 15);

		text_MobileNovoF = new Text(composite, SWT.BORDER);
		text_MobileNovoF.setBounds(81, 162, 339, 21);

		Label lblNomeDeUtilizador = new Label(composite, SWT.NONE);
		lblNomeDeUtilizador.setText("Utilizador");
		lblNomeDeUtilizador.setBounds(10, 192, 55, 15);

		text_UserNovoF = new Text(composite, SWT.BORDER);
		text_UserNovoF.setBounds(81, 189, 121, 21);

		Label lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setText("Password");
		lblPassword.setBounds(228, 192, 55, 15);

		text_PassNovoF = new Text(composite, SWT.BORDER);
		text_PassNovoF.setBounds(289, 189, 131, 21);

		Label Titulo_Novo_F = new Label(composite, SWT.NONE);
		Titulo_Novo_F.setAlignment(SWT.CENTER);
		Titulo_Novo_F.setBounds(71, 10, 322, 15);
		Titulo_Novo_F.setText("Dados do Novo Funcionario");

		Label lblPosio = new Label(composite, SWT.NONE);
		lblPosio.setText("Posi\u00E7\u00E3o");
		lblPosio.setBounds(10, 226, 55, 15);

		text_PosicaoNovoF = new Text(composite, SWT.BORDER);
		text_PosicaoNovoF.setBounds(81, 223, 88, 21);

		Button criarNovoF = new Button(composite, SWT.MULTI | SWT.WRAP | SWT.NONE);
		criarNovoF.setBounds(289, 233, 103, 58);
		criarNovoF.setText("Guardar\nNovo Funcionario");

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setText("tba");
		button_3.setBounds(10, 205, 154, 25);

		// ************* fim do menu novo funcionario

		Composite composite1 = new Composite(shell, SWT.NONE);
		composite1.setBounds(182, 41, 443, 301);
		composite1.setVisible(false);

		Button button = new Button(shell, SWT.NONE);
		button.setText("Log Out");
		button.setBounds(550, 10, 75, 25);

		// JA_BT1.0 Botao Criar novo Funcionario.
		Button Novo_Funcionario = new Button(shell, SWT.NONE);
		Novo_Funcionario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		Novo_Funcionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				composite.setVisible(true);
				composite1.dispose();

				// *********** Cria novo Funcionario

				criarNovoF.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						boolean verificatudo = true;
						String textofinal = "";
						String NomeNovoF = text_NomeNovoF.getText();
						String Morada_NovoF = text_Morada_NovoF.getText();
						String ValorID_NovoF = text_ValorID_NovoF.getText();
						String Email_NovoF = text_Email_NovoF.getText();
						String MobileNovoF = text_MobileNovoF.getText();
						String UserNovoF = text_UserNovoF.getText();
						String PassNovoF = text_PassNovoF.getText();
						String PosicaoNovoF = text_PosicaoNovoF.getText();

						System.out.println(NomeNovoF);
						System.out.println(Morada_NovoF);
						System.out.println(ValorID_NovoF);
						System.out.println(Email_NovoF);
						System.out.println(MobileNovoF);
						System.out.println(UserNovoF);
						System.out.println(PassNovoF);
						System.out.println(PosicaoNovoF);
						System.out.println("-------->");

						String mensagem = "";
						boolean naohaDadosPorPreencher = true;
						// Verifica campos vazios colocou-se como
						if (estaVazio(text_NomeNovoF) || estaVazio(text_Morada_NovoF) || estaVazio(text_ValorID_NovoF)
								|| estaVazio(text_Email_NovoF) || estaVazio(text_MobileNovoF)
								|| estaVazio(text_UserNovoF) || estaVazio(text_PassNovoF)) {
							Titulo_Novo_F.setText("Dados por preencher ou inválidos");
							Titulo_Novo_F.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
							mensagem = mensagem + "Tem dados por preencher\n";
							estaVazio(text_NomeNovoF);
							estaVazio(text_Morada_NovoF);
							estaVazio(text_ValorID_NovoF);
							estaVazio(text_Email_NovoF);
							estaVazio(text_MobileNovoF);
							estaVazio(text_UserNovoF);
							estaVazio(text_PassNovoF);
							naohaDadosPorPreencher = false;

						}

						if (TipoID_NovoF.getText().equals("Cartao Cidadao")) {
							if (eNumero(text_ValorID_NovoF) == -1) {
								Titulo_Novo_F.setText("Dados por preencher ou inválidos");
								mensagem = mensagem + "Nº CC inválido .\n";
								System.out.println("VERIFICACAO DE numeros CC");
								naohaDadosPorPreencher = false;
							} else if (eNumero(text_ValorID_NovoF) != 8 && eNumero(text_ValorID_NovoF) != -1) {
								Titulo_Novo_F.setText("Dados por preencher ou inválidos");
								mensagem = mensagem + "Nº Cartao Cidadao inválido\n";

								mensagem = mensagem + ".\n";
								System.out.println("VERIFICACAO DE CC");
								naohaDadosPorPreencher = false;
							}
						} else if (TipoID_NovoF.getText().equals("Passaporte")) {
							/// falta verificar tamanho de passaporte
							if (text_ValorID_NovoF.getText().length() < 7
									|| text_ValorID_NovoF.getText().length() > 15) {
								Titulo_Novo_F.setText("Dados por preencher ou inválidos");
								mensagem = mensagem + "Nº Passaporte inválido .\n";
								System.out.println("VERIFICACAO DE Passaporte");
								naohaDadosPorPreencher = false;
							}

						}

						if (!validateMobileNumber(text_MobileNovoF)) {
							System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoF.getText());
							Titulo_Novo_F.setText("Dados por preencher ou inválidos");
							mensagem = mensagem + "Contacto inválido.\n";
							naohaDadosPorPreencher = false;

						}

						if (!validateEmail(text_Email_NovoF)) {
							System.out.println("VERIFICACAO DE Email ->" + text_Email_NovoF.getText());
							Titulo_Novo_F.setText("Dados por preencher ou inválidos");
							mensagem = mensagem + "Email inválido.\n";
							naohaDadosPorPreencher = false;
						}

						if (naohaDadosPorPreencher) {
//							Funcionario fNovo=new Funcionario ();
							if (TipoID_NovoF.getText().equals("Passaporte")) {
								TipoID escolhadaID=Funcionario.TipoID.PASSAPORTE;}
							else {TipoID escolhadaID=Funcionario.TipoID.PASSAPORTE;}
//							fNovo.setNome(text_NomeNovoF.getText());
//							fNovo.setMorada(text_Morada_NovoF.getText());
//							fNovo.setValorID(Integer.parseInt(text_ValorID_NovoF.getText()));
//							fNovo.setEmail(text_Email_NovoF.getText());
//							fNovo.setMobile(Integer.parseInt(text_MobileNovoF.getText()));
//							fNovo.setLogin((text_UserNovoF.getText()));
//							fNovo.setPassword(text_PassNovoF.getText());
//							fNovo.setPosicao(text_PosicaoNovoF.getText());
							
//							String verifica = g.verificanovoF(
//									text_NomeNovoF,escolhadaID,text_ValorID_NovoF,text_Email_NovoF,text_MobileNovoF,text_UserNovoF);
//							
							textofinal = "";
//							System.out.println(Arrays.toString(verifica));
//							for (int i = 0; i < verifica.length; i++) {
//								textofinal = textofinal + verifica[i];
//								if (!verifica[i].equals("")) {
//									verificatudo = false;
//								}

								if (verificatudo) {
									MessageBox box = new MessageBox(shell, SWT.MULTI );
									box.setText("CONCLUSÃO");
									box.setMessage(" O Funcionario foi adicionado");
									box.open();
									
									
									
								}

							
						} 
					else {
							MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
							box.setText("ERRO");
							box.setMessage(mensagem);
							box.open();
							Composite composite10 = new Composite(shell, SWT.NONE);
							composite10.setBounds(182, 41, 430, 301);
						}
					}
				});

				// ************* fim do menu novo funcionario

			}
		});
		Novo_Funcionario.setText("Novo Funcionario");
		Novo_Funcionario.setBounds(10, 141, 154, 25);

// *****// JA_BT2.0 Botao para ver Lista de Cliente.
		Button Lista_Clientes = new Button(shell, SWT.NONE);
		Lista_Clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				composite.setVisible(false);
				composite1.setVisible(true);

				// *********************Tabela de Clientes *************************
				ScrolledComposite scrolledComposite = new ScrolledComposite(composite1,
						SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
				scrolledComposite.setBounds(0, 0, 420, 283);
				scrolledComposite.setExpandHorizontal(true);
				scrolledComposite.setExpandVertical(true);
				scrolledComposite.setVisible(true);// apaga tabela

				table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				scrolledComposite.setContent(table);
				scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

				table.setVisible(true); // apaga tabela

				System.out.println("  - > " + g.getMapUtilizadores().size());
				Utilizador u = new Utilizador();
				String[] titulo = { "Cliente ID", "Nome", "Morada", "email", "Telefone", "nº contas" };

				for (int i = 0; i < titulo.length; i++) {
					TableColumn column = new TableColumn(table, SWT.NULL);
					column.setText(titulo[i]);
				}

				for (String key : g.getMapUtilizadores().keySet()) {
					u = g.getMapUtilizadores().get(key);

					if (u instanceof Cliente) {
						System.out.println("-->" + ((Cliente) u).toString());
						String[] ClienteI = new String[6];
						ClienteI = ((Cliente) u).toTable();
						System.out.println("-->" + (Arrays.toString(ClienteI)));
						TableItem item = new TableItem(table, SWT.NULL);

						item.setText(0, ((Cliente) u).toTable()[0]);
						item.setText(1, ((Cliente) u).toTable()[1]);
						item.setText(2, ((Cliente) u).toTable()[2]);
						item.setText(3, ((Cliente) u).toTable()[3]);
						item.setText(4, ((Cliente) u).toTable()[4]);
						item.setText(5, ((Cliente) u).toTable()[5]);

					}

					for (int i = 0; i < titulo.length; i++) {
						table.getColumn(i).pack();
					}
					table.setSize(table.computeSize(SWT.DEFAULT, 200));

				}
			}
		});
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 174, 154, 25);

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

}
