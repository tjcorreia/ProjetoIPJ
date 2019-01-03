package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J_02Menu_F_AlteraCl {

	protected Shell shellMF;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private String clienteAID;
	private Text Funcionario;
	private Text text_2;
	private Text text_NumeroCliente;
	
	

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

	
	
	public J_02Menu_F_AlteraCl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_AlteraCl( Gestao gestor,Utilizador uUtilizador,String clienteAID) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		this.clienteAID = clienteAID;
		open();
	}

	/**
	 * Launch the application.
	 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_AlteraCl window = new J_02Menu_F_AlteraCl(new Gestao(),new Funcionario());
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
				
//				clienteAID=text_NumeroCliente.getText();
//				J_02Menu_F_ContasCliente novosDados = new J_02Menu_F_ContasCliente(gestor,uUtilizador, clienteAID);	
//				novosDados.open();
//				shellMF.dispose();
			}
		});
		btnExibirContasDo.setText("Exibir Contas do Cliente");
		btnExibirContasDo.setBounds(10, 208, 192, 25);
		
		Button btnDadosDoCliente = new Button(shellMF, SWT.NONE);
		btnDadosDoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				
				clienteAID=text_NumeroCliente.getText();
				J_02Menu_F_AlteraCl novosDados = new J_02Menu_F_AlteraCl(gestor,uUtilizador, clienteAID);	
				novosDados.open();
				shellMF.dispose();
				
			}
		});
		btnDadosDoCliente.setText("Altera dados do cliente");
		btnDadosDoCliente.setBounds(10, 177, 192, 25);
		
		Button btnFazerDepsitoEm = new Button(shellMF, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				clienteAID=text_NumeroCliente.getText();
//				J_02Menu_F_ContasCliente novosDados = new J_02Menu_F_ContasCliente(gestor,uUtilizador, clienteAID);	
//				novosDados.open();
//				shellMF.dispose();
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
				
//				clienteAID=text_NumeroCliente.getText();
//				J_02Menu_F_PedeCartao novosDados = new J_02Menu_F_PedeCartao(gestor,uUtilizador, clienteAID);	
//				novosDados.open();
//				shellMF.dispose();
				
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
		
		text_NumeroCliente = new Text(shellMF, SWT.BORDER | SWT.CENTER | SWT.MULTI);
		text_NumeroCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				text_NumeroCliente.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			}
		});
		if (clienteAID.equals("") ||clienteAID.equals("Introduza Cliente ID")) {
			text_NumeroCliente.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			MessageBox box = new MessageBox(shellMF, SWT.MULTI | SWT.ICON_ERROR);
			box.setText("ERRO");
			box.setMessage("Introduza o Numero de Cliente");
			box.open();
			
		}
		else {
			text_NumeroCliente.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		}
		text_NumeroCliente.setText(clienteAID);
		text_NumeroCliente.setBounds(10, 115, 192, 24);
		
		Button button_1 = new Button(shellMF, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				clienteAID="*** Procura de Cliente";
//				J_02Menu_F_ProcuraCl novaProcura = new J_02Menu_F_ProcuraCl( gestor,uUtilizador, clienteAID);	
//				novaProcura.open();
//				shellMF.dispose();
				
			}
		});
		button_1.setText("Procura Cliente");
		button_1.setBounds(10, 146, 192, 25);

	}
}
