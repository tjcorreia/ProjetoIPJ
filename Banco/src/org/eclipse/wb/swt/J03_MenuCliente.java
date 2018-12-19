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
public class J03_MenuCliente {

	protected Shell shell;
	private Text txtAlbertoMachadobem;
	private Text txtBemVindoAo;
	private Button btnTransferenciaBancria;
	private Button btnAlterarLoginE;
	private Button button;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J03_MenuCliente window = new J03_MenuCliente();
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
		shell.setSize(450, 430);
		shell.setText("SWT Application");
		
		txtAlbertoMachadobem = new Text(shell, SWT.BORDER);
		txtAlbertoMachadobem.setText("*** ALBERTO MACHADO***");
		txtAlbertoMachadobem.setBounds(138, 10, 161, 21);
		
		txtBemVindoAo = new Text(shell, SWT.BORDER);
		txtBemVindoAo.setText("Bem Vindo ao JAVA BANCK");
		txtBemVindoAo.setBounds(138, 40, 161, 21);
		
		Button btnAlterarDadosPessoais = new Button(shell, SWT.NONE);
		btnAlterarDadosPessoais.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados Pessoais");
		btnAlterarDadosPessoais.setBounds(10, 84, 154, 25);
		
		Button btnExibirContas = new Button(shell, SWT.NONE);
		btnExibirContas.setText("Exibir Conta(s)");
		btnExibirContas.setBounds(10, 115, 154, 25);
		
		btnTransferenciaBancria = new Button(shell, SWT.NONE);
		btnTransferenciaBancria.setText("Transferencia Banc\u00E1ria");
		btnTransferenciaBancria.setBounds(10, 146, 154, 25);
		
		btnAlterarLoginE = new Button(shell, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 177, 154, 25);
		
		button = new Button(shell, SWT.NONE);
		button.setText("Log Out");
		button.setBounds(325, 21, 75, 25);

	}

}
