package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
*  Breve descrição do código
* Janela Administrador Menu Inicial
* @author Alberto Jorge
* @author Tiago Correia
 * @sid 2019
 * @aid 1.1
 */
public class J_01_Administrador {

	protected Shell shell;
	private Text text;
	private Utilizador uAdministrador;
	private Gestao gestor;

	
	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	public Utilizador getuAdministrador() {
		return uAdministrador;
	}

	public void setuAdministrador(Utilizador uAdministrador) {
		this.uAdministrador = uAdministrador;
	}

	
	public J_01_Administrador(Gestao gestor,Utilizador uAdministrador) {

		this.uAdministrador = uAdministrador;
		this.gestor = gestor;
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * 
	 */
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_01_Administrador() {
		super();
		open();
		// TODO Auto-generated constructor stub
	}


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

	
	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(659, 453);
	
		shell.setText("MENU ADMINISTRADOR");
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shell.setImage((Image) SWTResourceManager.getImage(J_01_Administrador.class, "/Logo/Java-logo-png Logo.png"));

		Label lbl_Imagem = new Label(shell,SWT.NONE);
		lbl_Imagem.setBounds(215, 84, 385, 296);
		Image image2 = (Image) SWTResourceManager.getImage(J_01_Administrador.class, "/Logo/Java-logo-png Logo14.png");
		image2.isAutoScalable();;
		lbl_Imagem.setImage(gestor.resize(shell,image2,lbl_Imagem.getBounds().width,lbl_Imagem.getBounds().height));
		
		
		
		
		
		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(235, 10, 301, 25);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };

		Button btnAlterarDadosPessoais = new Button(shell, SWT.NONE);
		btnAlterarDadosPessoais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_Admin_AlteraDados j=new J_01_Admin_AlteraDados(gestor,uAdministrador);
				j.open();
				
				
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados pessoais");
		btnAlterarDadosPessoais.setBounds(10, 153, 192, 25);

		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(550, 10, 75, 25);

		Button Novo_Funcionario = new Button(shell, SWT.NONE);
		Novo_Funcionario.setText("Novo Funcionario");
		Novo_Funcionario.setBounds(10, 89, 192, 25);
	
		Novo_Funcionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_Admin_NovoF NovoFuncionario = new J_01_Admin_NovoF(gestor, uAdministrador);
				NovoFuncionario.open();
				
			}
		});
		

		Button Lista_Clientes = new Button(shell, SWT.NONE);
		Lista_Clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_AdminLClientes novaLClientes=new J_01_AdminLClientes(gestor,uAdministrador);
				novaLClientes.open();
			}
		});
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 122, 192, 25);
		
		Button btnMenuFuncionario = new Button(shell, SWT.NONE);
		btnMenuFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_02Menu_F menuF=new J_02Menu_F(gestor,uAdministrador) ;
				menuF.open();
		
			}
		});
		btnMenuFuncionario.setText("Menu Funcionario");
		btnMenuFuncionario.setBounds(10, 184, 192, 25);

	}

	

}
