package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_20AlteracaoSubmetida {

	protected Shell shlSucesso;
	private String mensagem1;
	private String mensagem2;
	
	
	//Construtor para abrir uma nova janela deste tipo
	public J_20AlteracaoSubmetida(String s1, String s2) {
		mensagem1 = s1;
		mensagem2 = s2;
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
		shlSucesso.open();
		shlSucesso.layout();
		while (!shlSucesso.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSucesso = new Shell();
		shlSucesso.setSize(450, 300);
		shlSucesso.setText("Sucesso");
		
		Label lblMensagem1 = new Label(shlSucesso, SWT.NONE);
		lblMensagem1.setAlignment(SWT.CENTER);
		lblMensagem1.setText(mensagem1);
		lblMensagem1.setBounds(59, 89, 326, 20);
		
		Label lblMensagem2 = new Label(shlSucesso, SWT.NONE);
		lblMensagem2.setAlignment(SWT.CENTER);
		lblMensagem2.setText(mensagem2);
		lblMensagem2.setBounds(59, 115, 326, 20);
		
		Button button = new Button(shlSucesso, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				shlSucesso.close();
			}
		});
		button.setText("Fechar");
		button.setBounds(175, 175, 90, 30);

	}
	

}
