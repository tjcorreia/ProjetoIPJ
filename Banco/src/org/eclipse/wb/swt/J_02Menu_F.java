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
	private Text txtIntroduzaClienteId;

	
	
	
	public Utilizador getuUtilizador() {
		return uUtilizador;
	}

	public void setuUtilizador(Utilizador uUtilizador) {
		this.uUtilizador = uUtilizador;
	}

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	
	public J_02Menu_F() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F( Gestao gestor,Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		open();
	}

	/**
	 * Launch the application.
	 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_CriaCliente window = new J_02Menu_F_CriaCliente(new Gestao(),new Funcionario());
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
				
				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
				alteraDados.open();
				shlMenuFuncionrio.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");
		
		Button btnExibirContasDo = new Button(shlMenuFuncionrio, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 236, 192, 25);
		
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
		btnDadosDoCliente.setBounds(10, 205, 192, 25);
		
		Button btnFazerDepsitoEm = new Button(shlMenuFuncionrio, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 298, 192, 25);
		
		Button btnListarClientes = new Button(shlMenuFuncionrio, SWT.NONE);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			
				J_02Menu_F_ListaClientes lclientes=new J_02Menu_F_ListaClientes(gestor,uUtilizador);
				lclientes.open();
				shlMenuFuncionrio.dispose();
			}
		});
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 112, 192, 25);
		
		Button btnAlterarLoginE = new Button(shlMenuFuncionrio, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);
		
		Button btnPedirCartaoDe = new Button(shlMenuFuncionrio, SWT.NONE);
		btnPedirCartaoDe.setSelection(true);
		btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedirCartaoDe.setText("Pedir Cartao de Debito");
		btnPedirCartaoDe.setBounds(10, 267, 192, 25);
		
		Button btnLevantamentoEmDinheiro = new Button(shlMenuFuncionrio, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 329, 192, 25);
		
		Button btnTransferncia = new Button(shlMenuFuncionrio, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 361, 192, 25);
		
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
		
		String clienteActua="Introduza Cliente ID";
		txtIntroduzaClienteId = new Text(shlMenuFuncionrio, SWT.BORDER | SWT.CENTER | SWT.MULTI);
		txtIntroduzaClienteId.setText(clienteActua);
		txtIntroduzaClienteId.setBounds(10, 143, 192, 24);
		
		Button btnProcuraCliente = new Button(shlMenuFuncionrio, SWT.NONE);
		btnProcuraCliente.setText("Procura Cliente");
		btnProcuraCliente.setBounds(10, 174, 192, 25);

	}
}
