package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
		btnExibirContas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContas.setText("Novo funcionario");
		btnExibirContas.setBounds(10, 115, 154, 25);
		
		btnTransferenciaBancria = new Button(shell, SWT.NONE);
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
