package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J_02Menu_F {

	protected Shell shell;
	private Text txtNumeroDeCliente;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_02Menu_F window = new J_02Menu_F();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shell.setSize(581, 445);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 32, 154, 25);
		btnNewButton.setText("Criar novo Cliente");
		
		Button btnExibirContasDo = new Button(shell, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Conta do Cliente");
		btnExibirContasDo.setBounds(10, 143, 154, 25);
		
		Button btnDadosDoCliente = new Button(shell, SWT.NONE);
		btnDadosDoCliente.setText("Dados do Cliente");
		btnDadosDoCliente.setBounds(10, 112, 154, 25);
		
		Button btnFazerDepsitoEm = new Button(shell, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 205, 154, 25);
		
		Button btnListarClientes = new Button(shell, SWT.NONE);
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 327, 154, 25);
		
		Button btnAlterarLoginE = new Button(shell, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 358, 154, 25);
		
		Button btnPedirCartaoDe = new Button(shell, SWT.NONE);
		btnPedirCartaoDe.setSelection(true);
		btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedirCartaoDe.setText("Pedir Cartao de Debito");
		btnPedirCartaoDe.setBounds(10, 174, 154, 25);
		
		Button btnLevantamentoEmDinheiro = new Button(shell, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 236, 154, 25);
		
		Button btnTransferncia = new Button(shell, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 270, 154, 25);
		
		txtNumeroDeCliente = new Text(shell, SWT.BORDER | SWT.WRAP);
		txtNumeroDeCliente.setText("Numero de Cliente?");
		txtNumeroDeCliente.setBounds(10, 85, 154, 21);
		
		text = new Text(shell, SWT.BORDER);
		text.setText("*** ALBERTO MACHADO***");
		text.setBounds(210, 0, 161, 21);

	}
}
