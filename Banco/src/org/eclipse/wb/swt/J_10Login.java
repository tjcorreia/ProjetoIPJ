package org.eclipse.wb.swt;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


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
	private Gestao gestao;
	



	



	public J_10Login(Gestao gestao) {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_10Login window = new J_10Login(new Gestao());
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
		shlLogin.setText("Java Bank. - Login");
		
		text = new Text(shlLogin, SWT.BORDER);
		text.setBounds(92, 143, 144, 26);
		
		text_1 = new Text(shlLogin, SWT.BORDER);
		text_1.setBounds(92, 80, 144, 26);
		
		Label lblEmail = new Label(shlLogin, SWT.NONE);
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(10, 83, 70, 20);
		lblEmail.setText("Login:");
		
		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setAlignment(SWT.RIGHT);
		lblPassword.setText("Password:");
		lblPassword.setBounds(10, 146, 70, 20);
		
		Label lblRedeInternaPara = new Label(shlLogin, SWT.NONE);
		lblRedeInternaPara.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblRedeInternaPara.setAlignment(SWT.CENTER);
		lblRedeInternaPara.setBounds(31, 10, 358, 49);
		lblRedeInternaPara.setText("BEM VINDO AO JAVA BANK.");
		
		Label lblMensagemDeErro = new Label(shlLogin, SWT.NONE);
		lblMensagemDeErro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErro.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemDeErro.setBounds(92, 175, 150, 20);
		lblMensagemDeErro.setText("Erro! Login Inv\u00E1lido (eventual mensagem de erro)");
		
//		String Log=text.toString();
//		String pass=text.toString();
//		getUserLog()
		//// listner Entar
		
		Button btnEntrar = new Button(shlLogin, SWT.NONE);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String Log=text.getText();
				String pass=text_1.getText();
			
				
				
				
			}
		});
		
		btnEntrar.setText("Entrar");
		btnEntrar.setBounds(273, 112, 90, 30);

	}
	
	public String getUserLog() {
        return text.getText();
    }
 
    public String getPassword() {
    	return text_1.getText();
    }
 
    public Utilizador utilizadorAprovado(Utilizador Aprova) {
        return Aprova;
    }
	
    
    public boolean fecha() {
    	return true;
    }
}
