package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_11Menu_Admin {

	protected Shell shlMenuAdmin;
	protected static Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	private Text CaixaDePesquisa;
	private Table tabelaLivros;
	
	//Construtor para poder trazer a Livraria para esta classe
		public J_11Menu_Admin(Livraria livraria) {
			//super();
			this.livraria = livraria;
			open();
		}
	


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMenuAdmin.open();
		shlMenuAdmin.layout();
		while (!shlMenuAdmin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuAdmin = new Shell();
		shlMenuAdmin.setSize(730, 542);
		shlMenuAdmin.setText("Menu Administrador");
		
		Button btnLogout = new Button(shlMenuAdmin, SWT.NONE);
		btnLogout.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela atual
				shlMenuAdmin.close();
				//Abrir de novo a janela inicial
				J_00Inicial janelaInicial = new J_00Inicial(livraria);
				janelaInicial.open();
			}
		});
		btnLogout.setText("Logout");
		btnLogout.setBounds(630, 37, 72, 23);
		
		Label lblMenuAdministrador = new Label(shlMenuAdmin, SWT.NONE);
		lblMenuAdministrador.setText("MENU ADMINISTRADOR");
		lblMenuAdministrador.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuAdministrador.setAlignment(SWT.CENTER);
		lblMenuAdministrador.setBounds(10, 10, 358, 38);
		
		Label lblNomeUtilizador = new Label(shlMenuAdmin, SWT.NONE);
		lblNomeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeUtilizador.setBounds(399, 10, 303, 21);
		lblNomeUtilizador.setText("Utilizador: Nome do utilizador");
		
		Button btnAlterarLivro = new Button(shlMenuAdmin, SWT.NONE);
		btnAlterarLivro.setBounds(10, 102, 133, 30);
		btnAlterarLivro.setText("Alterar livro");
		
		Button btnAdicionarLivro = new Button(shlMenuAdmin, SWT.NONE);
		btnAdicionarLivro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAdicionarLivro.setText("Adicionar livro");
		btnAdicionarLivro.setBounds(10, 146, 133, 30);
		
		Button btnAtuclizarStock = new Button(shlMenuAdmin, SWT.NONE);
		btnAtuclizarStock.setText("Atualizar stock");
		btnAtuclizarStock.setBounds(10, 190, 133, 30);
		
		Button btnRegistarVendedor = new Button(shlMenuAdmin, SWT.NONE);
		btnRegistarVendedor.setText("Registar vendedor");
		btnRegistarVendedor.setBounds(10, 234, 133, 30);
		
		Button btnVoltar = new Button(shlMenuAdmin, SWT.NONE);
		btnVoltar.setText("Voltar");
		btnVoltar.setBounds(630, 462, 72, 23);
		
		CaixaDePesquisa = new Text(shlMenuAdmin, SWT.BORDER);
		CaixaDePesquisa.setBounds(221, 65, 196, 30);
		
		Button btnPesquisar = new Button(shlMenuAdmin, SWT.NONE);
		btnPesquisar.setText("Pesquisar");
		btnPesquisar.setBounds(449, 65, 90, 30);
		
		tabelaLivros = new Table(shlMenuAdmin, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaLivros.setLinesVisible(true);
		tabelaLivros.setHeaderVisible(true);
		tabelaLivros.setBounds(157, 146, 495, 305);
		
		Label label = new Label(shlMenuAdmin, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(149, 101, 2, 165);
		
		Label lblSelecioneLivro = new Label(shlMenuAdmin, SWT.NONE);
		lblSelecioneLivro.setBounds(157, 120, 259, 20);
		lblSelecioneLivro.setText("Selecione o livro que pretende alterar");

	}
}
