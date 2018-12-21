package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J04_MenuAdministrador {

	protected Shell shell;
	private Text txtAlbertoMachadobem;
	private Button btnTransferenciaBancria;
	private Button btnAlterarLoginE;
	private Button btnNewButton;
	private Utilizador uAdministrador;
	private Table table;
	private ScrolledComposite scrolledComposite;

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
		Gestao g=new Gestao();
		shell = new Shell();
		shell.setSize(603, 430);
		shell.setText("SWT Application");
		
		txtAlbertoMachadobem = new Text(shell, SWT.BORDER);
		txtAlbertoMachadobem.setText("Bem Vindo "+uAdministrador.nome);
		txtAlbertoMachadobem.setBounds(10, 12, 458, 25);
		
		Button btnAlterarDadosPessoais = new Button(shell, SWT.NONE);
		btnAlterarDadosPessoais.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados Pessoais");
		btnAlterarDadosPessoais.setBounds(10, 208, 154, 25);
		
		Button btnExibirContas = new Button(shell, SWT.NONE);
		
		// *********************Tabela de Clientes *************************
		scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setBounds(172, 62, 388, 305);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setVisible(false);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(false);
		table.setVisible(false);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		// *********************Tabela de Clientes *************************
		
		
		
		
		
		
		// carregar para exibir contas do banco
		btnExibirContas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				scrolledComposite.setVisible(true);
//				table.setVisible(true);
//				
//			    table.setHeaderVisible(true);
//			    String[] titles = { "Cliente ID", "Nome", "Col 3", "Col 4" };
//
//			    for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
//			      TableColumn column = new TableColumn(table, SWT.NULL);
//			      column.setText(titles[loopIndex]);
//			    }
//
//			    for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
//			      TableItem item = new TableItem(table, SWT.NULL);
//			      item.setText("Item " + loopIndex);
//			      item.setText(0, "Item " + loopIndex);
//			      item.setText(1, "Yes");
//			      item.setText(2, "No");
//			      item.setText(3, "A table item");
//			    }
//				for (Conta C:g.getlContas()) {
//					
//					
//					
//				}
				
				
				
				
			}
		});
		btnExibirContas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContas.setText("Novo funcionario");
		btnExibirContas.setBounds(10, 115, 154, 25);
		
		btnTransferenciaBancria = new Button(shell, SWT.NONE);
		btnTransferenciaBancria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		// carregar para exibir clientes do banco
		btnTransferenciaBancria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				scrolledComposite.setVisible(true);
				table.setVisible(true);
				System.out.println("  - > "+g.getMapUtilizadores().size());
				Utilizador u = new Utilizador();

			    String[] titles = { "Cliente ID", "Nome", "Morada", "Telefone" };
				for ( String key : g.getMapUtilizadores().keySet() ) {
					u=g.getMapUtilizadores().get(key);
					
					if (u instanceof Cliente) {
						System.out.println("-->"+((Cliente)u).toString());
						  
						      TableItem item = new TableItem(table, SWT.NULL);
						     
						      item.setText(0, ((Cliente)u).toString());
						      
						    
		
					}
					
				 
				}
				
				
				
			}
		});
		//*************************
		
		btnTransferenciaBancria.setText("Lista de Clientes");
		btnTransferenciaBancria.setBounds(10, 146, 154, 25);
		
		btnAlterarLoginE = new Button(shell, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 177, 154, 25);
		
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(485, 10, 75, 25);
		btnNewButton.setText("Log Out");
		
		

	}
}
