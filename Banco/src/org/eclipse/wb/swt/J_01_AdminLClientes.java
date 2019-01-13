package org.eclipse.wb.swt;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

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


	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

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
		// TODO Auto-generated constructor stub
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public J_01_AdminLClientes() {
		open();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Launch the application.
	 * 
	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			J_01_AdminLClientes window = new J_01_AdminLClientes(new Gestao(),new Utilizador());
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
////	/**
//	 * Open the window.
//	 */
//	
	
	
	
	
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
		shell.setSize(668, 408);
		shell.setText("MENU ADMINISTRADOR");
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shell.setImage((Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo.png"));
		
		Image image2 = (Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo13.png");
		image2.isAutoScalable();;
		Label lblimagem = new Label(shell, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shell,image2,lblimagem.getBounds().width,lblimagem.getBounds().height));
		
		
		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(226, 10, 286, 25);

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(222, 91, 420, 255);

		// *********************Tabela de Clientes *************************
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(0, 0, 420, 245);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setVisible(true);// apaga tabela

		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		table.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		table.setVisible(true); // apaga tabela

		System.out.println("  - > " + gestor.getMapUtilizadores().size());
		Utilizador u = new Utilizador();
		String[] titulo = { "Cliente ID", "Nome", "contas" };

		for (int i = 0; i < titulo.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setText(titulo[i]);
		}

		for (String key : gestor.getMapUtilizadores().keySet()) {
			u = gestor.getMapUtilizadores().get(key);

			if (u instanceof Cliente) {
				System.out.println("-->" + ((Cliente) u).toString());
				String[] ClienteI = new String[3];
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
		btnAlterarDadosPessoais.setBounds(10, 153, 192, 25);

		Button button_LogOut = new Button(shell, SWT.NONE);
		button_LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			shell.dispose();
			
			}
		});
		
		button_LogOut.setText("Log Out");
		button_LogOut.setBounds(531, 10, 75, 25);

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
		Novo_Funcionario.setBounds(10, 91, 192, 25);


		Button Lista_Clientes = new Button(shell, SWT.NONE);
		
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 122, 192, 25);
		
		Label lblListaDeClientes = new Label(shell, SWT.NONE);
		lblListaDeClientes.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblListaDeClientes.setText("Lista de Clientes");
		lblListaDeClientes.setAlignment(SWT.CENTER);
		lblListaDeClientes.setBounds(226, 56, 416, 25);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				J_02Menu_F menuF=new J_02Menu_F(gestor,uAdministrador) ;
				menuF.open();
			}
		});
		button.setText("Menu Funcionario");
		button.setBounds(10, 191, 192, 25);

	}
}
