package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_01_AdminLClientes {

	protected Shell shell;
	private Text text;
	private Gestao gestor;
	private Utilizador uAdministrador;
	private Table table;


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

	public J_01_AdminLClientes(Gestao gestor,Utilizador uAdministrador) {
		super();
		this.uAdministrador = uAdministrador;
		this.gestor = gestor;
		open();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_01_AdminLClientes window = new J_01_AdminLClientes(new Gestao(),new Utilizador());
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
		Gestao g = new Gestao();
		shell = new Shell();
		shell.setSize(651, 408);
		shell.setText("MENU ADMINISTRADOR");

		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(182, 10, 286, 25);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(182, 83, 420, 262);

		// *********************Tabela de Clientes *************************
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(0, 10, 420, 252);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setVisible(true);// apaga tabela

		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		table.setVisible(true); // apaga tabela

		System.out.println("  - > " + g.getMapUtilizadores().size());
		Utilizador u = new Utilizador();
		String[] titulo = { "Cliente ID", "Nome", "nº contas" };

		for (int i = 0; i < titulo.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setText(titulo[i]);
		}

		for (String key : g.getMapUtilizadores().keySet()) {
			u = g.getMapUtilizadores().get(key);

			if (u instanceof Cliente) {
				System.out.println("-->" + ((Cliente) u).toString());
				String[] ClienteI = new String[6];
				ClienteI = ((Cliente) u).toTable();
				System.out.println("-->" + (Arrays.toString(ClienteI)));
				TableItem item = new TableItem(table, SWT.NULL);

				item.setText(0, ((Cliente) u).toTable()[0]);
				item.setText(1, ((Cliente) u).toTable()[1]);
				item.setText(2, ((Cliente) u).toTable()[2]);
				

			}

			for (int i = 0; i < titulo.length; i++) {
				table.getColumn(i).pack();
			}
			table.setSize(table.computeSize(SWT.DEFAULT, 200));

		}

		Button btnAlterarDadosPessoais = new Button(shell, SWT.NONE);
		btnAlterarDadosPessoais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_Admin_AlteraDados alteraDados=new J_01_Admin_AlteraDados(gestor,uAdministrador);
				alteraDados.open();
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados pessoais");
		btnAlterarDadosPessoais.setBounds(10, 205, 154, 25);

		Button button_LogOut = new Button(shell, SWT.NONE);
		button_LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			shell.dispose();
			
			}
		});
		
		button_LogOut.setText("Log Out");
		button_LogOut.setBounds(550, 10, 75, 25);

		// JA_BT1.0 Botao Criar novo Funcionario.
		Button Novo_Funcionario = new Button(shell, SWT.NONE);
		Novo_Funcionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_Admin_NovoF n=new J_01_Admin_NovoF(gestor, uAdministrador);
				n.open();
				
				
			}
		});
	
		Novo_Funcionario.setText("Novo Funcionario");
		Novo_Funcionario.setBounds(10, 141, 154, 25);


		Button Lista_Clientes = new Button(shell, SWT.NONE);
		
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 174, 154, 25);
		
		Label lblListaDeClientes = new Label(shell, SWT.NONE);
		lblListaDeClientes.setText("Lista de Clientes");
		lblListaDeClientes.setAlignment(SWT.CENTER);
		lblListaDeClientes.setBounds(226, 62, 322, 15);

	}

}
