package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_03CompraSubmetida {

	protected Shell shell;
	
	
	//Construtor para abrir uma nova janela deste tipo
	public J_03CompraSubmetida() {
		open();
	}	

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			J_03CompraSubmetida window = new J_03CompraSubmetida();
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
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Compra submetida com sucesso");
		label.setBounds(59, 89, 326, 20);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Aguarde/solicite a finaliza\u00E7\u00E3o por um vendedor");
		label_1.setBounds(59, 115, 326, 20);
		
		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				shell.close();
			}
		});
		button.setText("Fechar");
		button.setBounds(175, 175, 90, 30);

	}

}
