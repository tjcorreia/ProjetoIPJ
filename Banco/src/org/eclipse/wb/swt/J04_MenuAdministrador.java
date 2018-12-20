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
public class J04_MenuAdministrador {

	protected Shell shlMenuAdministrador;
	private Button btnTransferenciaBancria;
	private Button btnAlterarLoginE;
	private Button btnNewButton;
	private Label lblNewLabel;
	private Label lblNomeDeUtilizador;
	private Label lblNewLabel_1;

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
		shlMenuAdministrador = new Shell();
		shlMenuAdministrador.setSize(468, 430);
		shlMenuAdministrador.setText("Menu Administrador");
		
		Button btnAlterarDadosPessoais = new Button(shlMenuAdministrador, SWT.NONE);
		btnAlterarDadosPessoais.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados Pessoais");
		btnAlterarDadosPessoais.setBounds(10, 208, 175, 25);
		
		Button btnExibirContas = new Button(shlMenuAdministrador, SWT.NONE);
		btnExibirContas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContas.setText("Novo funcionario");
		btnExibirContas.setBounds(10, 115, 175, 25);
		
		btnTransferenciaBancria = new Button(shlMenuAdministrador, SWT.NONE);
		btnTransferenciaBancria.setText("Lista de Clientes");
		btnTransferenciaBancria.setBounds(10, 146, 175, 25);
		
		btnAlterarLoginE = new Button(shlMenuAdministrador, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 177, 175, 25);
		
		btnNewButton = new Button(shlMenuAdministrador, SWT.NONE);
		btnNewButton.setBounds(356, 12, 75, 25);
		btnNewButton.setText("Log Out");
		
		lblNewLabel = new Label(shlMenuAdministrador, SWT.NONE);
		lblNewLabel.setBounds(277, 12, -62, 7);
		lblNewLabel.setText("New Label");
		
		lblNomeDeUtilizador = new Label(shlMenuAdministrador, SWT.NONE);
		lblNomeDeUtilizador.setBounds(277, 12, -83, 25);
		lblNomeDeUtilizador.setText("Nome de utilizador");
		
		lblNewLabel_1 = new Label(shlMenuAdministrador, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		lblNewLabel_1.setBounds(80, 17, 270, 20);
		lblNewLabel_1.setText("Nome de utilizador");

	}
}
