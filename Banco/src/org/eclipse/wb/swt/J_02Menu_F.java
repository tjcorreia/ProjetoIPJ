package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J_02Menu_F {

	protected Shell shlMenuFuncionrio;
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
		shlMenuFuncionrio.setSize(581, 445);
		shlMenuFuncionrio.setText("Menu Funcion\u00E1rio");
		
		Button btnNewButton = new Button(shlMenuFuncionrio, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 32, 192, 25);
		btnNewButton.setText("Criar novo Cliente");
		
		Button btnExibirContasDo = new Button(shlMenuFuncionrio, SWT.NONE);
		btnExibirContasDo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExibirContasDo.setText("Exibir Conta do Cliente");
		btnExibirContasDo.setBounds(10, 143, 192, 25);
		
		Button btnDadosDoCliente = new Button(shlMenuFuncionrio, SWT.NONE);
		btnDadosDoCliente.setText("Dados do Cliente");
		btnDadosDoCliente.setBounds(10, 112, 192, 25);
		
		Button btnFazerDepsitoEm = new Button(shlMenuFuncionrio, SWT.NONE);
		btnFazerDepsitoEm.setText("Dep\u00F3sito em Dinheiro");
		btnFazerDepsitoEm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFazerDepsitoEm.setBounds(10, 205, 192, 25);
		
		Button btnListarClientes = new Button(shlMenuFuncionrio, SWT.NONE);
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 327, 192, 25);
		
		Button btnAlterarLoginE = new Button(shlMenuFuncionrio, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 358, 192, 25);
		
		Button btnPedirCartaoDe = new Button(shlMenuFuncionrio, SWT.NONE);
		btnPedirCartaoDe.setSelection(true);
		btnPedirCartaoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPedirCartaoDe.setText("Pedir Cartao de Debito");
		btnPedirCartaoDe.setBounds(10, 174, 192, 25);
		
		Button btnLevantamentoEmDinheiro = new Button(shlMenuFuncionrio, SWT.NONE);
		btnLevantamentoEmDinheiro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLevantamentoEmDinheiro.setText("Levantamento em Dinheiro");
		btnLevantamentoEmDinheiro.setBounds(10, 236, 192, 25);
		
		Button btnTransferncia = new Button(shlMenuFuncionrio, SWT.NONE);
		btnTransferncia.setText("Transfer\u00EAncia");
		btnTransferncia.setBounds(10, 270, 192, 25);
		
		Button button = new Button(shlMenuFuncionrio, SWT.NONE);
		button.setText("Log Out");
		button.setBounds(478, 10, 75, 25);
		
		Label label = new Label(shlMenuFuncionrio, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		label.setText("Nome de utilizador");
		label.setAlignment(SWT.RIGHT);
		label.setBounds(202, 10, 266, 20);
		
		text = new Text(shlMenuFuncionrio, SWT.BORDER);
		text.setBounds(10, 80, 192, 26);

	}
}
