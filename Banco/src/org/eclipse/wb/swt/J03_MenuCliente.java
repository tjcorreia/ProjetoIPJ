package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J03_MenuCliente {

	protected Shell shlMenuCliente;
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
		shlMenuCliente.open();
		shlMenuCliente.layout();
		while (!shlMenuCliente.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuCliente = new Shell();
		shlMenuCliente.setSize(450, 430);
		shlMenuCliente.setText("Menu Cliente");
		
		Button btnAlterarDadosPessoais = new Button(shlMenuCliente, SWT.NONE);
		btnAlterarDadosPessoais.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados Pessoais");
		btnAlterarDadosPessoais.setBounds(10, 84, 169, 25);
		
		Button btnExibirContas = new Button(shlMenuCliente, SWT.NONE);
		btnExibirContas.setText("Exibir Conta(s)");
		btnExibirContas.setBounds(10, 115, 169, 25);
		
		btnTransferenciaBancria = new Button(shlMenuCliente, SWT.NONE);
		btnTransferenciaBancria.setText("Transferencia Banc\u00E1ria");
		btnTransferenciaBancria.setBounds(10, 146, 169, 25);
		
		btnAlterarLoginE = new Button(shlMenuCliente, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 177, 169, 25);
		
		button = new Button(shlMenuCliente, SWT.NONE);
		button.setText("Log Out");
		button.setBounds(347, 19, 75, 25);
		
		Label lblNomeDeUtilizador = new Label(shlMenuCliente, SWT.NONE);
		lblNomeDeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeDeUtilizador.setBounds(141, 19, 200, 20);
		lblNomeDeUtilizador.setText("Nome de utilizador");

	}
}
