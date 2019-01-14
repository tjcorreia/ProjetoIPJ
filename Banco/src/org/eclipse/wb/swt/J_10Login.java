package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * Menu de Login 
 * 
 * * @author Alberto Jorge
* @author Tiago Correia
* 
* @sid 2019
 * @sid 2017
 * @aid 1.1
 */

public class J_10Login {

	protected Shell shlLogin;
	private Text text_NUtilizador;
	private Text text_Password;
	private Utilizador devolveU;
	private Gestao gestor;
	private Label lblMensagemDeErro;

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	public Utilizador getDevolveU() {
		return devolveU;
	}

	public void setDevolveU(Utilizador devolveU) {
		this.devolveU = devolveU;
	}

	public J_10Login(Gestao gestor) {
		this.gestor = gestor;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_10Login() {
		super();
		open();
		// TODO Auto-generated constructor stub
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
		Gestao g = this.gestor;
		shlLogin = new Shell();
		shlLogin.setSize(450, 300);
		shlLogin.setText("Java Bank - Login");
		shlLogin.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shlLogin.setImage((Image) SWTResourceManager.getImage(J_10Login.class, "/Logo/Java-logo-png Logo.png"));
//		Image image = (Image) SWTResourceManager.getImage(J_10Login.class, "/Logo/Java-logo-png Logo14.png");
//		image.isAutoScalable();;
//		shlLogin.setBackgroundImage(gestor.resize(shlLogin,image,450,290));
		
//		Image imagem=new Image(Display.getDefault());
//		shlLogin.setImage(imagem);

		lblMensagemDeErro = new Label(shlLogin, SWT.NONE);
		lblMensagemDeErro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErro.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemDeErro.setBounds(92, 175, 150, 20);
		lblMensagemDeErro.setText("Erro! Login inválido");
		lblMensagemDeErro.setVisible(false);

		text_NUtilizador = new Text(shlLogin, SWT.BORDER);

		text_NUtilizador.setBounds(92, 80, 144, 26);

		text_Password = new Text(shlLogin, SWT.PASSWORD | SWT.BORDER);
		text_Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode==13) {
					// Passar para strings os textos introduzidos na caixa de email e password
					String username = text_NUtilizador.getText();
					String password = text_Password.getText();

					// Usa método verfLogin(username, password) para verificar as strings
					// introduzidas
//					e devolve utilizador 

					System.out.print(username);
					System.out.print(password);

					devolveU = g.verfLogin(username, password);

					if (devolveU != null) {
						System.out.print("  - > OK utilizador");
						utilizadorAprovado();
						shlLogin.dispose();
					} else {
						System.out.print("não verifica");
						lblMensagemDeErro.setVisible(true);
						text_NUtilizador.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseDown(MouseEvent e) {
								shlLogin.dispose();
							}
						});

					}
				}
			}
		});
		text_Password.setBounds(92, 143, 144, 26);

		/// -- So para nao ter de repetir o Login----
		text_NUtilizador.setText("Machado");
		;
		text_Password.setText("Admin");
		// -----------------------------------------

		Label lblEmail = new Label(shlLogin, SWT.NONE);
		lblEmail.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(10, 83, 70, 20);
		lblEmail.setText("Login :   ");

		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPassword.setAlignment(SWT.RIGHT);
		lblPassword.setText("Password :   ");
		lblPassword.setBounds(10, 146, 70, 20);

		Label lblRedeInternaPara = new Label(shlLogin, SWT.NONE);
		lblRedeInternaPara.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblRedeInternaPara.setAlignment(SWT.CENTER);
		lblRedeInternaPara.setBounds(98, 21, 237, 26);
		lblRedeInternaPara.setText("BEM VINDO AO JAVA BANK.");

//		String Log=text.toString();
//		String pass=text.toString();
//		getUserLog()
		//// listner Entar

		Button btnEntrar = new Button(shlLogin, SWT.NONE);
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		btnEntrar.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				// Passar para strings os textos introduzidos na caixa de email e password
				String username = text_NUtilizador.getText();
				String password = text_Password.getText();

				// Usa método verfLogin(username, password) para verificar as strings
				// introduzidas
//				e devolve utilizador 

				System.out.print(username);
				System.out.print(password);

				devolveU = g.verfLogin(username, password);

				if (devolveU != null) {
					System.out.print("  - > OK utilizador");
					utilizadorAprovado();
					shlLogin.dispose();
				} else {
					System.out.print("não verifica");
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
		btnEntrar.setBounds(273, 112, 105, 30);

//		Label lblNewLabel = new Label(shlLogin, SWT.NONE);
//		Image imagem=new Image(null, "/Logo/javaBank _Withe_48.png" );
//		ImageData img=imagem.getImageData();
//		img.scaledTo(lblNewLabel.getBounds().width, lblNewLabel.getBounds().height);
//		Image imagem2= new Image(null,img);
//		
//		lblNewLabel.setImage(SWTResourceManager.g);
//		lblNewLabel.setAlignment(SWT.CENTER);
//		lblNewLabel.setBounds(38, 10, 54, 47);

	}

	public Utilizador utilizadorAprovado() {
		return devolveU;
	}
}
