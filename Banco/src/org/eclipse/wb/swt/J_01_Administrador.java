package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_01_Administrador {

	protected Shell shell;
	private Text text;
	private Utilizador uAdministrador;


	public Utilizador getuAdministrador() {
		return uAdministrador;
	}

	public void setuAdministrador(Utilizador uAdministrador) {
		this.uAdministrador = uAdministrador;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_01_Administrador(Utilizador uAdministrador) {

		this.uAdministrador = uAdministrador;
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_01_Administrador() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void maini(String[] args) {
		try {
			J_01_Administrador2 window = new J_01_Administrador2(new Utilizador());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
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
		Gestao g = new Gestao();
		shell = new Shell();
		shell.setSize(651, 408);
		shell.setText("MENU ADMINISTRADOR");

		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(10, 10, 458, 25);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setText("tba");
		button_3.setBounds(10, 205, 154, 25);

		Button button = new Button(shell, SWT.NONE);
		button.setText("Log Out");
		button.setBounds(550, 10, 75, 25);

		Button Novo_Funcionario = new Button(shell, SWT.NONE);
		Novo_Funcionario.setText("Novo Funcionario");
		Novo_Funcionario.setBounds(10, 141, 154, 25);
	
		Novo_Funcionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
//				shell.dispose();
				J_01_Admin_NovoF NovoFuncionario = new J_01_Admin_NovoF(uAdministrador);
				NovoFuncionario.open();
				
			}
		});
		

		Button Lista_Clientes = new Button(shell, SWT.NONE);
		Lista_Clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {


			}
		});
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 174, 154, 25);

	}

	

}
