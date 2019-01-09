package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_02Menu_F_ListaClientes {

	protected Shell shlMenuFuncionrio;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Text Funcionario;
	private Text text_nome;
	private Text text_identifica;
	private Text text_telemovel;
	private Table table;

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

	public J_02Menu_F_ListaClientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_ListaClientes(Gestao gestor, Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
	
	}

	/**
	 * Launch the application.
	 * 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_CriaCliente window = new J_02Menu_F_CriaCliente(new Gestao(),new Funcionario());
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
		shlMenuFuncionrio.open();
		shlMenuFuncionrio.layout();
		while (!shlMenuFuncionrio.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuFuncionrio = new Shell();
		shlMenuFuncionrio.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shlMenuFuncionrio.setSize(659, 522);
		shlMenuFuncionrio.setText("Menu Funcion\u00E1rio");

		Button btnNovoCliente = new Button(shlMenuFuncionrio, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				J_02Menu_F_CriaCliente alteraDados = new J_02Menu_F_CriaCliente(gestor, uUtilizador);
				alteraDados.open();
				shlMenuFuncionrio.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnExibirContasDo = new Button(shlMenuFuncionrio, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 236, 192, 25);

		Button btnFazerDepsitoEm = new Button(shlMenuFuncionrio, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 298, 192, 25);

		Button btnListarClientes = new Button(shlMenuFuncionrio, SWT.NONE);
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 112, 192, 25);

		Button btnAlterarLoginE = new Button(shlMenuFuncionrio, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);

		Button btnPedirCartaoDe = new Button(shlMenuFuncionrio, SWT.NONE);
		btnPedirCartaoDe.setSelection(true);
		btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedirCartaoDe.setText("Pedir Cartao de Debito");
		btnPedirCartaoDe.setBounds(10, 267, 192, 25);

		Button btnLevantamentoEmDinheiro = new Button(shlMenuFuncionrio, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 329, 192, 25);

		Button btnTransferncia = new Button(shlMenuFuncionrio, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 361, 192, 25);

		Button button = new Button(shlMenuFuncionrio, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenuFuncionrio.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shlMenuFuncionrio, SWT.BORDER);
		Funcionario.setText("Bem Vindo " + uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);

		String clienteActua = "Introduza Cliente ID";

		Composite composite = new Composite(shlMenuFuncionrio, SWT.NONE);
		composite.setBounds(215, 85, 420, 348);

		ScrolledComposite scrolledComposite = new ScrolledComposite(composite,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setVisible(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setBounds(10, 107, 400, 231);

		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION|SWT.SINGLE);
		
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println(e.toString());
				int indexLivroSelecionado = ((Table)e.widget).indexOf((TableItem)e.item);
				System.out.println( indexLivroSelecionado );
				
				
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDoubleClick(MouseEvent e) {
					
						Cliente actual=new Cliente();
						actual=gestor.procuraCid(Integer.parseInt((table.getItem(table.getSelectionIndex())).getText(0)));
						
						
						J_02Menu_F_DadosCl cliente=new J_02Menu_F_DadosCl(gestor,uUtilizador,actual);
						cliente.open();
						shlMenuFuncionrio.dispose();	
						
						
					}
				});
		
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(49);
		tblclmnId.setText("ID");

		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(73);
		tblclmnNewColumn.setText("ID");

		TableColumn tblclmnTelemovel = new TableColumn(table, SWT.NONE);
		tblclmnTelemovel.setWidth(65);
		tblclmnTelemovel.setText("Telemovel");

		TableColumn tblclmnLContas = new TableColumn(table, SWT.NONE);
		tblclmnLContas.setWidth(105);
		tblclmnLContas.setText("Lista de Contas");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(new Point(417, 45));
		scrolledComposite.setMinSize(new Point(85, 45));

		Label lbl_Titulo = new Label(composite, SWT.NONE);
		lbl_Titulo.setAlignment(SWT.CENTER);
		lbl_Titulo.setBounds(143, 10, 138, 15);
		lbl_Titulo.setText("Lista de Clientes");

		text_nome = new Text(composite, SWT.BORDER);
		text_nome.setBounds(20, 49, 106, 21);

		Label lblnome = new Label(composite, SWT.NONE);
		lblnome.setAlignment(SWT.CENTER);
		lblnome.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblnome.setText("(Nome)");
		lblnome.setBounds(20, 37, 106, 10);

		text_identifica = new Text(composite, SWT.BORDER);
		text_identifica.setBounds(159, 49, 106, 21);

		text_telemovel = new Text(composite, SWT.BORDER);
		text_telemovel.setBounds(304, 49, 106, 21);

		Label lblidentificao = new Label(composite, SWT.NONE);
		lblidentificao.setText("(Identifica\u00E7\u00E3o Pessoal)");
		lblidentificao.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblidentificao.setAlignment(SWT.CENTER);
		lblidentificao.setBounds(159, 37, 106, 10);

		Label lblemail = new Label(composite, SWT.NONE);
		lblemail.setText("(Telemovel)");
		lblemail.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblemail.setAlignment(SWT.CENTER);
		lblemail.setBounds(304, 37, 106, 10);

		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				table.clearAll();
				table.removeAll();

				System.out.println("  - > " + gestor.getMapUtilizadores().size());
				Utilizador u = new Utilizador();

				for (String key : gestor.getMapUtilizadores().keySet()) {
					u = gestor.getMapUtilizadores().get(key);
					System.out.println("-->" + key);
					if (u instanceof Cliente) {

						if (text_nome.getText().equals("") & text_identifica.getText().equals("")
								& text_telemovel.getText().equals("")) {

							System.out.println("GeRAL-->" + ((Cliente) u).toString());
							System.out.println("-->" + (u));
							TableItem item = new TableItem(table, SWT.NULL);

							item.setText(0, ("" + u.getuID()));
							item.setText(1, u.getNome() + " " + u.getSobrenome());
							item.setText(2, u.getValorID());
							item.setText(3, "" + u.getMobile());
							item.setText(4, "" + (((Cliente) u).listadeContasC()));
						

						} 
						else {
							String nomecompleto = u.getNome() + " " + u.getSobrenome();
							if (!text_nome.getText().equals("")
									& nomecompleto.toLowerCase().contains(text_nome.getText().toLowerCase())) {

								System.out.println("NOME -->" + ((Cliente) u).toString());
								System.out.println("-->" + (u));
								TableItem item = new TableItem(table, SWT.NULL);

								item.setText(0, ("" + u.getuID()));
								item.setText(1, u.getNome() + " " + u.getSobrenome());
								item.setText(2, u.getValorID());
								item.setText(3, "" + u.getMobile());
								item.setText(4, "" + (((Cliente) u).listadeContasC()));
						
							}
							if (!text_identifica.getText().equals("")
									& u.getValorID().equalsIgnoreCase(text_identifica.getText())) {

								System.out.println("ID-->" + ((Cliente) u).toString());
								System.out.println("-->" + (u));
								TableItem item = new TableItem(table, SWT.NULL);

								item.setText(0, ("" + u.getuID()));
								item.setText(1, u.getNome() + " " + u.getSobrenome());
								item.setText(2, u.getValorID());
								item.setText(3, "" + u.getMobile());
								item.setText(4, "" + (((Cliente) u).listadeContasC()));
							
							}
							if (!text_telemovel.getText().equals("")
									& ("" + u.mobile).equalsIgnoreCase(text_telemovel.getText())) {

								System.out.println("MOBILE-->" + ((Cliente) u).toString());
								System.out.println("-->" + (u));
								TableItem item = new TableItem(table, SWT.NULL);

								item.setText(0, ("" + u.getuID()));
								item.setText(1, u.getNome() + " " + u.getSobrenome());
								item.setText(2, u.getValorID());
								item.setText(3, "" + u.getMobile());
								item.setText(4, "" + (((Cliente) u).listadeContasC()));
							
							}

						}

					}

				}
			}
		});
		btnNewButton.setBounds(159, 76, 106, 25);
		btnNewButton.setText("Pesquisa Cliente");
		
		Button button_1 = new Button(shlMenuFuncionrio, SWT.NONE);
		button_1.setText("Dados do cliente");
		button_1.setBounds(10, 143, 192, 25);

	}
}
