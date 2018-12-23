package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import java.util.Arrays;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.ScrolledComposite;

public class J04_MenuAdministrador {


	protected Shell shlMenuAdministrador;
	protected Shell shell;
	private Text txtBoasVindas;
	private Button btnListaClientes;
	private Button btnLogout;
	private Utilizador uAdministrador;
	private Table table;
	private ScrolledComposite scrolledComposite;
	private Button btnNovoFuncionario;

	public Utilizador getuAdministrador() {
		return uAdministrador;
	}

	public void setuAdministrador(Utilizador uAdministrador) {
		this.uAdministrador = uAdministrador;
	}

	public J04_MenuAdministrador(Utilizador uAdministrador) {
		super();
		this.uAdministrador = uAdministrador;
	}

	public J04_MenuAdministrador() {
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
			J04_MenuAdministrador window = new J04_MenuAdministrador();
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
		shlMenuAdministrador.open();
		shlMenuAdministrador.layout();
		while (!shlMenuAdministrador.isDisposed()) {
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
		shell.setSize(604, 429);
		shell.setText("SWT Application");

		txtBoasVindas = new Text(shell, SWT.BORDER);
		txtBoasVindas.setText("Bem Vindo " + uAdministrador.nome);
		txtBoasVindas.setBounds(10, 12, 458, 25);

		// *********************Tabela de Clientes *************************
		scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setBounds(172, 62, 388, 305);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setVisible(true);

		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setVisible(true);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		// ********************* *************************
		btnListaClientes = new Button(shell, SWT.NONE);
		btnListaClientes.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

	
		// carregar para exibir clientes do banco
		btnListaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				scrolledComposite.setVisible(true);
				table.setVisible(true);
				table.setHeaderVisible(true);
				   
				System.out.println("  - > " + g.getMapUtilizadores().size());
				Utilizador u = new Utilizador();
				String[] titulo = { "Cliente ID", "Nome", "Morada","email", "Telefone","nº contas"  };
				
				for (int i = 0; i < titulo.length; i++) {
				      TableColumn column = new TableColumn(table, SWT.NULL);
				      column.setText(titulo[i]);
				    }
				
				for (String key : g.getMapUtilizadores().keySet()) {
					u = g.getMapUtilizadores().get(key);

					if (u instanceof Cliente) {
						System.out.println("-->" + ((Cliente) u).toString());
						String [] ClienteI= new String [6] ;
						ClienteI=((Cliente) u).toTable();
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
		// *************************

		btnListaClientes.setText("Lista de Clientes");
		btnListaClientes.setBounds(10, 146, 154, 25);

		btnLogout = new Button(shell, SWT.NONE);
		btnLogout.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});



		btnLogout.setBounds(485, 10, 75, 25);
		btnLogout.setText("Log Out");



		btnNovoFuncionario = new Button(shell, SWT.NONE);
		btnNovoFuncionario.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});



		btnNovoFuncionario.setText("Novo Funcionario");
		btnNovoFuncionario.setBounds(10, 113, 154, 25);
	}
}
