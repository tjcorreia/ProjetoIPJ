package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_10Login {

	protected Shell shlLogin;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_10Login window = new J_10Login();
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
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setSize(450, 300);
		shlLogin.setText("View Comics Inc. - Login");
		
		text = new Text(shlLogin, SWT.BORDER);
		text.setBounds(92, 143, 144, 26);
		
		text_1 = new Text(shlLogin, SWT.BORDER);
		text_1.setBounds(92, 80, 144, 26);
		
		Label lblEmail = new Label(shlLogin, SWT.NONE);
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(10, 83, 70, 20);
		lblEmail.setText("E-mail:");
		
		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setAlignment(SWT.RIGHT);
		lblPassword.setText("Password:");
		lblPassword.setBounds(10, 146, 70, 20);
		
		Label lblRedeInternaPara = new Label(shlLogin, SWT.NONE);
		lblRedeInternaPara.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblRedeInternaPara.setAlignment(SWT.CENTER);
		lblRedeInternaPara.setBounds(31, 10, 358, 49);
		lblRedeInternaPara.setText("Rede Interna para funcion\u00E1rios - LOGIN");
		
		Label lblMensagemDeErro = new Label(shlLogin, SWT.NONE);
		lblMensagemDeErro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErro.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemDeErro.setBounds(92, 175, 150, 20);
		lblMensagemDeErro.setText("Mensagem de erro");
		
		Label label = new Label(shlLogin, SWT.NONE);
		label.setText("Mensagem de erro");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		label.setBounds(92, 112, 150, 20);
		
		Button btnVoltar = new Button(shlLogin, SWT.NONE);
		btnVoltar.setBounds(342, 217, 80, 26);
		btnVoltar.setText("Voltar");
		
		Button btnEntrar = new Button(shlLogin, SWT.NONE);
		btnEntrar.setText("Entrar");
		btnEntrar.setBounds(273, 112, 90, 30);

	}
}
