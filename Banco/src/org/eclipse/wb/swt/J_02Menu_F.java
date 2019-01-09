package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J_02Menu_F {

	protected Shell shlMenuFuncionrio;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Text Funcionario;

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

	
	
	public J_02Menu_F( Gestao gestor,Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		open();
	
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
		shlMenuFuncionrio.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shlMenuFuncionrio.setSize(659, 522);
		shlMenuFuncionrio.setText("Menu Funcion\u00E1rio");
		
		Button btnNovoCliente = new Button(shlMenuFuncionrio, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlMenuFuncionrio.dispose();
				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
				alteraDados.open();
				
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");
		
		Button btnDadosDoCliente = new Button(shlMenuFuncionrio, SWT.NONE);
		btnDadosDoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				J_02Menu_F_DadosCl cliente=new J_02Menu_F_DadosCl(gestor,uUtilizador,null);
				cliente.open();
				shlMenuFuncionrio.dispose();
				
			}
		});
		btnDadosDoCliente.setText("Dados do cliente");
		btnDadosDoCliente.setBounds(10, 143, 192, 25);
		
		Button btnListarClientes = new Button(shlMenuFuncionrio, SWT.NONE);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			
				J_02Menu_F_ListaClientes lclientes=new J_02Menu_F_ListaClientes(gestor,uUtilizador);
				lclientes.open();
				shlMenuFuncionrio.dispose();
			}
		});
		btnListarClientes.setText("Listar/Procurar Clientes");
		btnListarClientes.setBounds(10, 112, 192, 25);
		
		Button btnAlterarLoginE = new Button(shlMenuFuncionrio, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 238, 192, 25);
		
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
				J_02Menu_F_MovimentaConta editarconta= new J_02Menu_F_MovimentaConta(gestor, uUtilizador, null, null);
				editarconta.open();
				shlMenuFuncionrio.dispose();
			}
		});
		button_1.setText("Movimentar Contas");
		button_1.setBounds(10, 174, 192, 25);
		
		Button button_2 = new Button(shlMenuFuncionrio, SWT.NONE);
		button_2.setBounds(10, 207, 192, 25);
		
		Label lblNewLabel = new Label(shlMenuFuncionrio, SWT.NONE);
		lblNewLabel.setBounds(215, 84, 407, 296);
		lblNewLabel.setText("Java BANK INAGE");
		
		String clienteActua="Introduza Cliente ID";

	}
}
