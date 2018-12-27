package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.Arrays;

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
		// TODO Auto-generated constructor stub
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_01_Administrador window = new J_01_Administrador(new Utilizador());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

		Composite composite1 = new Composite(shell, SWT.NONE);
		composite1.setBounds(182, 41, 430, 301);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(182, 41, 430, 301);

		composite.setVisible(true);
		composite1.setVisible(false);

		// *********** Cria novo Funcionario
		Label Nome_novoF = new Label(composite, SWT.NONE);
		Nome_novoF.setBounds(10, 47, 55, 15);
		Nome_novoF.setText("Nome");

		text_NomeNovoF = new Text(composite, SWT.BORDER);
		text_NomeNovoF.setBounds(71, 44, 349, 21);

		Label lblMoradaNovoF = new Label(composite, SWT.NONE);
		lblMoradaNovoF.setText("Morada");
		lblMoradaNovoF.setBounds(10, 75, 55, 15);

		text_Morada_NovoF = new Text(composite, SWT.BORDER);
		text_Morada_NovoF.setBounds(71, 72, 349, 21);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };
		Combo TipoID_NovoF = new Combo(composite, SWT.NONE);
		TipoID_NovoF.setItems(comboB);
		TipoID_NovoF.setBounds(71, 99, 91, 23);

		text_ValorID_NovoF = new Text(composite, SWT.BORDER);
		text_ValorID_NovoF.setBounds(168, 100, 252, 21);

		Label lblEmail_novoF = new Label(composite, SWT.NONE);
		lblEmail_novoF.setText("Email");
		lblEmail_novoF.setBounds(10, 131, 55, 15);

		text_Email_NovoF = new Text(composite, SWT.BORDER);
		text_Email_NovoF.setBounds(71, 128, 349, 21);

		Label lblContacto = new Label(composite, SWT.NONE);
		lblContacto.setText("Contacto");
		lblContacto.setBounds(10, 165, 55, 15);

		text_MobileNovoF = new Text(composite, SWT.BORDER);
		text_MobileNovoF.setBounds(71, 162, 349, 21);

		Label lblNomeDeUtilizador = new Label(composite, SWT.NONE);
		lblNomeDeUtilizador.setText("Utilizador");
		lblNomeDeUtilizador.setBounds(10, 192, 55, 15);

		text_UserNovoF = new Text(composite, SWT.BORDER);
		text_UserNovoF.setBounds(71, 189, 131, 21);

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
		text_PosicaoNovoF.setBounds(71, 223, 98, 21);

		Button criarNovoF = new Button(composite, SWT.CENTER);

		criarNovoF.setBounds(294, 233, 98, 40);
		criarNovoF.setText("Guardar Novo Funcionario");

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setText("tba");
		button_3.setBounds(10, 205, 154, 25);

		// ************* fim do menu novo funcionario

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
				composite1.setVisible(false);

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
						if (estaVazio(text_NomeNovoF) || estaVazio(text_Morada_NovoF) || estaVazio(text_ValorID_NovoF)
								|| estaVazio(text_Email_NovoF) || estaVazio(text_MobileNovoF)
								|| estaVazio(text_UserNovoF) || estaVazio(text_PassNovoF)) {
							Titulo_Novo_F.setText("Dados Obrigatorios por preencher");
							Titulo_Novo_F.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
							System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");

							estaVazio(text_NomeNovoF);
							estaVazio(text_Morada_NovoF);
							estaVazio(text_ValorID_NovoF);
							estaVazio(text_Email_NovoF); 
							estaVazio(text_MobileNovoF);
							estaVazio(text_UserNovoF);
							estaVazio(text_PassNovoF);

						} else {

							String[] verifica = g.verificanovoF(NomeNovoF, Integer.parseInt(ValorID_NovoF), Email_NovoF,
									UserNovoF);
							textofinal = "";
							System.out.println(Arrays.toString(verifica));
							for (int i = 0; i < verifica.length; i++) {
								textofinal = textofinal + verifica[i];
								if (!verifica[i].equals("")) {
									verificatudo = false;
								}

//								Label lblNewLabel = new Label(composite, SWT.NONE);
//								lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
//								lblNewLabel.setBounds(95, 23, 265, 174);
//								lblNewLabel.setText(textofinal);
//								lblNewLabel.setVisible(!verificatudo);

							composite.dispose();

							}
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

}
