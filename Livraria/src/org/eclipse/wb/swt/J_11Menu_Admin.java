package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_11Menu_Admin {

	protected Shell shlMenuAdmin;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_11Menu_Admin window = new J_11Menu_Admin();
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
		shlMenuAdmin.open();
		shlMenuAdmin.layout();
		while (!shlMenuAdmin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuAdmin = new Shell();
		shlMenuAdmin.setSize(450, 300);
		shlMenuAdmin.setText("Menu Administrador");
		
		Button btnLogout = new Button(shlMenuAdmin, SWT.NONE);
		btnLogout.setText("Logout");
		btnLogout.setBounds(350, 194, 72, 23);
		
		Label lblMenuAdministrador = new Label(shlMenuAdmin, SWT.NONE);
		lblMenuAdministrador.setText("MENU ADMINISTRADOR");
		lblMenuAdministrador.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuAdministrador.setAlignment(SWT.CENTER);
		lblMenuAdministrador.setBounds(38, 10, 358, 38);
		
		Label lblUtilizadorNomeDo = new Label(shlMenuAdmin, SWT.NONE);
		lblUtilizadorNomeDo.setAlignment(SWT.RIGHT);
		lblUtilizadorNomeDo.setBounds(119, 222, 303, 21);
		lblUtilizadorNomeDo.setText("Utilizador: Nome do utilizador");
		
		Button btnAlterarDadosDe = new Button(shlMenuAdmin, SWT.NONE);
		btnAlterarDadosDe.setBounds(23, 54, 215, 30);
		btnAlterarDadosDe.setText("Alterar dados de um livro");
		
		Button btnAlterarStockDe = new Button(shlMenuAdmin, SWT.NONE);
		btnAlterarStockDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarStockDe.setText("Adicionar livro");
		btnAlterarStockDe.setBounds(23, 98, 215, 30);
		
		Button button = new Button(shlMenuAdmin, SWT.NONE);
		button.setText("Atualizar stock");
		button.setBounds(23, 142, 215, 30);
		
		Button btnRegistarVendedor = new Button(shlMenuAdmin, SWT.NONE);
		btnRegistarVendedor.setText("Registar vendedor");
		btnRegistarVendedor.setBounds(23, 186, 215, 30);

	}
}
