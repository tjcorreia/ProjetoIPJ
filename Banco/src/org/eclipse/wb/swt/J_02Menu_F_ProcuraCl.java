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
public class J_02Menu_F_ProcuraCl {

	protected Shell shellMF;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private String clienteAID;
	private Text Funcionario;
	private Text text_2;
	private Text text;
	private Button btnProcuraCliente;

	
	
	
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

	
	public String getClienteAID() {
		return clienteAID;
	}

	public void setClienteAID(String clienteAID) {
		this.clienteAID = clienteAID;
	}

	public J_02Menu_F_ProcuraCl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_ProcuraCl( Gestao gestor,Utilizador uUtilizador,String clienteAID) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		this.clienteAID = "";
		open();
	}

	/**
	 * Launch the application.
	 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_ProcuraCl window = new J_02Menu_F_ProcuraCl(new Gestao(),new Funcionario());
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
		shellMF.open();
		shellMF.layout();
		while (!shellMF.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellMF = new Shell();
		shellMF.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shellMF.setSize(659, 522);
		shellMF.setText("Menu Funcion\u00E1rio");
		
		Button btnNovoCliente = new Button(shellMF, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				J_02Menu_F_CriaCliente novoCliente=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
				novoCliente.open();
				shellMF.dispose();
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");
		
		Button btnExibirContasDo = new Button(shellMF, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 208, 192, 25);
		
		Button btnDadosDoCliente = new Button(shellMF, SWT.NONE);
		btnDadosDoCliente.setText("Altera dados do cliente");
		btnDadosDoCliente.setBounds(10, 177, 192, 25);
		
		Button btnFazerDepsitoEm = new Button(shellMF, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 270, 192, 25);
		
		Button btnListarClientes = new Button(shellMF, SWT.NONE);
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 392, 192, 25);
		
		Button btnAlterarLoginE = new Button(shellMF, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 423, 192, 25);
		
		Button btnPedirCartaoDe = new Button(shellMF, SWT.NONE);
		btnPedirCartaoDe.setSelection(true);
		btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedirCartaoDe.setText("Pedir Cartao de Debito");
		btnPedirCartaoDe.setBounds(10, 239, 192, 25);
		
		Button btnLevantamentoEmDinheiro = new Button(shellMF, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 301, 192, 25);
		
		Button btnTransferncia = new Button(shellMF, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 333, 192, 25);
		
		Button button = new Button(shellMF, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF.dispose();
			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);
		
		Funcionario = new Text(shellMF, SWT.BORDER);
		Funcionario.setText("Bem Vindo "+uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);
		
		text_2 = new Text(shellMF, SWT.BORDER);
		text_2.setBounds(10, 363, 192, 26);
		
		text = new Text(shellMF, SWT.BORDER | SWT.CENTER | SWT.MULTI);
		text.setText("Introduza Cliente ID");
		text.setBounds(10, 115, 192, 24);
		
		btnProcuraCliente = new Button(shellMF, SWT.NONE);
		btnProcuraCliente.setText("Procura Cliente");
		btnProcuraCliente.setBounds(10, 146, 192, 25);

	}
}
