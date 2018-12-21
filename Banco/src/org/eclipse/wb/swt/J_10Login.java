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
	private Text text_NUtilizador;
	private Text text_Password;
	private Utilizador devolveU;
	

	public Utilizador getDevolveU() {
		return devolveU;
	}



	public void setDevolveU(Utilizador devolveU) {
		this.devolveU = devolveU;
	}



	public J_10Login() {
		super();
		this.devolveU = null;
	}

	

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
		shlLogin.setText("Java Bank. - Login");
		
		text_NUtilizador = new Text(shlLogin, SWT.BORDER);
		
		text_NUtilizador.setBounds(92, 80, 144, 26);
		
		text_Password = new Text(shlLogin, SWT.BORDER);
		text_Password.setBounds(92, 143, 144, 26);
		
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
		lblMensagemDeErro.setText("Erro! Login inválido");
		lblMensagemDeErro.setVisible(false);
		
//		String Log=text.toString();
//		String pass=text.toString();
//		getUserLog()
		//// listner Entar
		
		Button btnEntrar = new Button(shlLogin, SWT.NONE);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Passar para strings os textos introduzidos na caixa de email e password
				String username=text_NUtilizador.getText();
				String password=text_Password.getText();
				
				//Usa método verfLogin(username, password) para verificar as strings introduzidas
//				e devolve utilizador 
		
				System.out.print(username);
				System.out.print(password);
				Gestao g=new Gestao();
				
				devolveU=g.verfLogin(username, password);
				
				
				if (devolveU!=null) {
					System.out.print("  - > OK utilizador");
					utilizadorAprovado();
					shlLogin.dispose();
				}
				else {System.out.print("não verifica");
				lblMensagemDeErro.setVisible(true);
				text_NUtilizador.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						shlLogin.dispose();
					}
				});
				
				}

				
			}
		});
		
		btnEntrar.setText("Entrar");
		btnEntrar.setBounds(273, 112, 90, 30);

	}
	
	
 
    public Utilizador utilizadorAprovado() {
        return devolveU;
    }
	
    
  
}
