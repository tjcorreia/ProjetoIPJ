package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_12Menu_Vendedor {

	protected Shell shell;
	protected static Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	protected Utilizador utilizador;
	
	//Construtor para poder trazer a Livraria para esta classe
	public J_12Menu_Vendedor (Livraria livraria, Utilizador utilizador) {
		//super();
		this.utilizador = utilizador;
		this.livraria = livraria;
		open();
	}	

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			J_12Menu_Vendedor window = new J_12Menu_Vendedor(livraria);
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
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblMenuVendedor = new Label(shell, SWT.NONE);
		lblMenuVendedor.setText("MENU VENDEDOR");
		lblMenuVendedor.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuVendedor.setAlignment(SWT.CENTER);
		lblMenuVendedor.setBounds(35, 10, 358, 38);
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Logout");
		button.setBounds(350, 196, 72, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Utilizador: Nome do utilizador");
		label.setAlignment(SWT.RIGHT);
		label.setBounds(119, 225, 303, 21);
		
		Button btnNovaVenda = new Button(shell, SWT.NONE);
		btnNovaVenda.setText("Nova venda");
		btnNovaVenda.setBounds(10, 54, 215, 30);
		
		Button btnValidarVenda = new Button(shell, SWT.NONE);
		btnValidarVenda.setText("Validar venda");
		btnValidarVenda.setBounds(10, 96, 215, 30);

	}

}
