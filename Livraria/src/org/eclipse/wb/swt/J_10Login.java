package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.Tipo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_10Login {

	protected Shell shlLogin;
	private Text text_password;
	private Text text_email;
	private Livraria livraria;//atributo adicionado para poder ir buscar o método 'verificarLogin' 

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_10Login window = new J_10Login(new Livraria());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Construtor para poder trazer a Livraria para esta classe
	public J_10Login(Livraria livraria) {
		super();
		this.livraria = livraria;
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
		shlLogin.addKeyListener(new KeyAdapter() {
			@Override
			//Listner para enter pressionado na janela (com o rato em qqr lado
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.TRAVERSE_RETURN) {
				   // mouseUp(e);
				}
			}
		});
		shlLogin.setSize(450, 300);
		shlLogin.setText("View Comics Inc. - Login");
		
		//Caixa para introdução de email
		text_email = new Text(shlLogin, SWT.BORDER);
		text_email.setBounds(92, 80, 144, 26);		
		
		//Caixa para introdução de password
		text_password = new Text(shlLogin, SWT.PASSWORD | SWT.BORDER);
		text_password.setBounds(92, 143, 144, 26);
		
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
		
		//Label com mensagem de utilizador inexistente que aparece quando não encontra correspondências 
		Label lblMensagemDeErroUtilizador = new Label(shlLogin, SWT.NONE);
		lblMensagemDeErroUtilizador.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErroUtilizador.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemDeErroUtilizador.setBounds(92, 112, 144, 20);
		lblMensagemDeErroUtilizador.setText("Utilizador inexistente");
		lblMensagemDeErroUtilizador.setVisible(false);
		
		//Label com mensagem de password incorreta que aparece quando não encontra correspondências 
		Label lblMensagemDeErroPassword = new Label(shlLogin, SWT.NONE);
		lblMensagemDeErroPassword.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErroPassword.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemDeErroPassword.setBounds(92, 175, 144, 20);
		lblMensagemDeErroPassword.setText("Password incorreta");
		lblMensagemDeErroPassword.setVisible(false);		
		
		
		
		//Listner para ação ao carregar em 'entrar'
		Button btnEntrar = new Button(shlLogin, SWT.NONE);
		btnEntrar.addKeyListener(listener);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Passar para strings os textos introduzidos na caixa de email e password
				String email = text_email.getText();
				String password = text_password.getText();
				//Chamar método 'verificarLogin' para as strings introduzidas
				String resultadoVerificacao = livraria.verificarLogin ( email, password );
				//Caso pass e mail corretos e utilizador do tipo Admin, abre janela de Admin
				if ( resultadoVerificacao.equals("okAdmin") ) {
					J_11Menu_Admin j = new J_11Menu_Admin();
					j.open();
				}
				//Caso pass e mail corretos e utilizador do tipo Vendedor, abre janela de Vendedor
				else if ( resultadoVerificacao.equals("okVendedor") ) {
					J_12Menu_Vendedor j = new J_12Menu_Vendedor();
					j.open();
				}
				//caso mail correto e password não
				else if ( resultadoVerificacao.equals("passwordErrada") ) {
					lblMensagemDeErroUtilizador.setVisible(false);
					lblMensagemDeErroPassword.setVisible(true);
				}
				//
				else  {
					lblMensagemDeErroUtilizador.setVisible(true);
					lblMensagemDeErroPassword.setVisible(false);
				}
				
			}
		});
		
		btnEntrar.setText("Entrar");
		btnEntrar.setBounds(273, 112, 90, 30);
		
		Button btnVoltar = new Button(shlLogin, SWT.NONE);
		btnVoltar.setBounds(342, 217, 80, 26);
		btnVoltar.setText("Voltar");

	}
}
