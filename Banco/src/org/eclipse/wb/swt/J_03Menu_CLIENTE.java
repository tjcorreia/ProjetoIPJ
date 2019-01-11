package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
* Breve descri��o do c�digo
*
* @sid 2019
* @aid 1.1
*/
public class J_03Menu_CLIENTE {

	protected Shell shlMenuFuncionrio;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Text Funcionario;
	private Label lbl_Imagem ;

	public Label getLbl_Imagem() {
		return lbl_Imagem;
	}

	public void setLbl_Imagem(Label lbl_Imagem) {
		this.lbl_Imagem = lbl_Imagem;
	}

	public Shell getShlMenuFuncionrio() {
		return shlMenuFuncionrio;
	}

	public void setShlMenuFuncionrio(Shell shlMenuFuncionrio) {
		this.shlMenuFuncionrio = shlMenuFuncionrio;
	}

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	public Utilizador getuUtilizador() {
		return uUtilizador;
	}

	public void setuUtilizador(Utilizador uUtilizador) {
		this.uUtilizador = uUtilizador;
	}

	public Text getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Text funcionario) {
		Funcionario = funcionario;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_03Menu_CLIENTE() {
		super();
    open();
	}
	
	public J_03Menu_CLIENTE( Gestao gestor,Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;

	}

	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMenuFuncionrio.open();
		shlMenuFuncionrio.layout();
		while (!shlMenuFuncionrio.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuFuncionrio = new Shell();
		shlMenuFuncionrio.setTouchEnabled(true);
		shlMenuFuncionrio.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shlMenuFuncionrio.setImage((Image) SWTResourceManager.getImage(J_03Menu_CLIENTE.class, "/Logo/Java-logo-png Logo.png"));
		shlMenuFuncionrio.setSize(659, 522);
		shlMenuFuncionrio.setText("Menu Funcion\u00E1rio");
		
		Button btnAlterarDadosPessoais = new Button(shlMenuFuncionrio, SWT.NONE);
		btnAlterarDadosPessoais.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlMenuFuncionrio.dispose();
				J_03_Menu_CLIENTE_AlteraDados3 alteraDados=new J_03_Menu_CLIENTE_AlteraDados3(gestor,uUtilizador);
				alteraDados.open();
				
				
			}
		});
		btnAlterarDadosPessoais.setBounds(10, 84, 192, 25);
		btnAlterarDadosPessoais.setText("Dados Pessoais");
		
		Button btnListarClientes = new Button(shlMenuFuncionrio, SWT.NONE);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenuFuncionrio.dispose();
				J_02Menu_F_ListaClientes lclientes=new J_02Menu_F_ListaClientes(gestor,uUtilizador);
				lclientes.open();
				
			}
		});
		btnListarClientes.setText("Exibir Contas");
		btnListarClientes.setBounds(10, 112, 192, 25);
		
		Button button = new Button(shlMenuFuncionrio, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenuFuncionrio.dispose();
				
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);
		
		Funcionario = new Text(shlMenuFuncionrio, SWT.BORDER);
		Funcionario.setText("Bem Vindo "+uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);
		
		Button button_1 = new Button(shlMenuFuncionrio, SWT.TOGGLE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenuFuncionrio.dispose();
				J_02Menu_F_MovimentaConta editarconta= new J_02Menu_F_MovimentaConta(gestor, uUtilizador, null, null);
				editarconta.open();
				
			}
		});
		button_1.setText("Movimentar Contas");
		button_1.setBounds(10, 143, 192, 25);
		
		Button button_2 = new Button(shlMenuFuncionrio, SWT.NONE);
		button_2.setBounds(10, 176, 192, 25);
		
		Image image = (Image) SWTResourceManager.getImage(J_03Menu_CLIENTE.class, "/Logo/Java-logo-png Logo14.png");
		image.isAutoScalable();;
		
		

		lbl_Imagem = new Label(shlMenuFuncionrio,SWT.NONE);
		lbl_Imagem.setBounds(215, 84, 385, 296);
		lbl_Imagem.setImage(gestor.resize(shlMenuFuncionrio,image,lbl_Imagem.getBounds().width,lbl_Imagem.getBounds().height));
		
		Image image2 = (Image) SWTResourceManager.getImage(J_03Menu_CLIENTE.class, "/Logo/Java-logo-png Logo13.png");
		image.isAutoScalable();;
		Label lblimagem = new Label(shlMenuFuncionrio, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shlMenuFuncionrio,image2,lblimagem.getBounds().width,lblimagem.getBounds().height));
		String clienteActua="Introduza Cliente ID";

	}
	
	
}
