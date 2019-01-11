package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;
import java.util.Calendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_11Menu_Admin {

	protected Shell shlMenuAdmin;
	protected Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	private Text CaixaDePesquisa;
	private Table tabelaLivros;
	protected Utilizador utilizador;
	protected String stringProcurada;
	protected Livro livroSelecionado;//atributo que nos dá o livro que está selecionado na table
	protected ArrayList <Livro> listaLivrosDaBusca;
	
	private Label lblMensagemSemCorrespondencias;
	private Label lblSelecioneLivro;
	private Label lblTitulo;
	private Label lblIsbn;
	private Label lblAutor;
	private Label lblEditora;
	private Label lblDescricao;
	private Label lblData;
	private Label lblPreco;
	private Label lblStock;
	private Button btnPesquisar;
	private Button btnSubmeterAlteracoes;
	private Text caixaTitulo;
	private Text caixaIsbn;
	private Text caixaAutor;
	private Text caixaEditora;
	private Text caixaDescricao;
	private Text caixaPreco;
	
	private Spinner caixaStock;
	private DateTime caixaData;
	
	
	//Construtor para poder trazer a Livraria para esta classe
		public J_11Menu_Admin(Livraria livraria, Utilizador utilizador) {
			//super();
			this.utilizador = utilizador;
			this.livraria = livraria;
			listaLivrosDaBusca =  livraria.getLivros();
			stringProcurada = "";
			livroSelecionado = new Livro();
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
		
		
		
		/**
		 *
		 * elementos sempre visíveis
		 * 
		 */
		Label lblMenuAdministrador = new Label(shlMenuAdmin, SWT.NONE);
		lblMenuAdministrador.setText("MENU ADMINISTRADOR");
		lblMenuAdministrador.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuAdministrador.setAlignment(SWT.CENTER);
		lblMenuAdministrador.setBounds(10, 10, 358, 38);
		
		Label lblNomeUtilizador = new Label(shlMenuAdmin, SWT.NONE);
		lblNomeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeUtilizador.setBounds(399, 10, 303, 21);
		lblNomeUtilizador.setText("Bem-vindo " + utilizador.nome);
		
		Label barraVertical = new Label(shlMenuAdmin, SWT.SEPARATOR | SWT.VERTICAL);
		barraVertical.setBounds(149, 101, 2, 165);
		
		Button btnAlterarLivro = new Button(shlMenuAdmin, SWT.NONE);
		btnAlterarLivro.setBounds(10, 102, 133, 30);
		btnAlterarLivro.setText("Alterar livro");
		btnAlterarLivro.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				visibilidadesBtnAlterarLivro();
			}
		});
		
		Button btnAdicionarLivro = new Button(shlMenuAdmin, SWT.NONE);
		btnAdicionarLivro.setText("Adicionar livro");
		btnAdicionarLivro.setBounds(10, 146, 133, 30);
		btnAdicionarLivro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		Button btnRegistarVendedor = new Button(shlMenuAdmin, SWT.NONE);
		btnRegistarVendedor.setText("Registar vendedor");
		btnRegistarVendedor.setBounds(10, 234, 133, 30);
		

		Button btnVoltar = new Button(shlMenuAdmin, SWT.NONE);
		btnVoltar.setText("Voltar/Logout");
		btnVoltar.setBounds(598, 457, 104, 28);
		btnVoltar.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela atual
				shlMenuAdmin.close();
				//Abrir de novo a janela inicial
				J_00Inicial janelaInicial = new J_00Inicial(livraria);
				janelaInicial.open();
			}
		});
		
		
		
		
		
		
		/**
		 *
		 * elementos visiveis para 'procurar livro'
		 * 
		 */
		lblSelecioneLivro = new Label(shlMenuAdmin, SWT.NONE);
		lblSelecioneLivro.setVisible(false);
		lblSelecioneLivro.setBounds(157, 120, 259, 20);
		lblSelecioneLivro.setText("Selecione o livro que pretende alterar");
		
		//mensagem de erro que aparece quando não há livros para a procura
		lblMensagemSemCorrespondencias = new Label(shlMenuAdmin, SWT.NONE);
		lblMensagemSemCorrespondencias.setVisible(false);
		lblMensagemSemCorrespondencias.setText("N\u00E3o existem correspond\u00EAncias. Tente novamente");
		lblMensagemSemCorrespondencias.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemSemCorrespondencias.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemSemCorrespondencias.setBounds(221, 102, 236, 12);		
		
		CaixaDePesquisa = new Text(shlMenuAdmin, SWT.BORDER);
		CaixaDePesquisa.setBounds(221, 65, 196, 30);
		CaixaDePesquisa.setVisible(false);
		
		btnPesquisar = new Button(shlMenuAdmin, SWT.NONE);
		btnPesquisar.setVisible(false);
		btnPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//Passar para string o texto introduzido na caixa de texto
				stringProcurada = CaixaDePesquisa.getText();
				//Chamar método 'procurarLivro' para a string introduzida
				listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
				//Caso lista de livros não tenha resultados apresentar mensagem de procura vazia
				if ( listaLivrosDaBusca.isEmpty() ) {
					lblMensagemSemCorrespondencias.setVisible(true);  
				}
				//caso lista tenha livros
				else {
					lblMensagemSemCorrespondencias.setVisible(false);  
					preencherTabela();
				}
			}
		});
		btnPesquisar.setText("Pesquisar");
		btnPesquisar.setBounds(449, 65, 90, 30);
		
		tabelaLivros = new Table(shlMenuAdmin, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaLivros.setVisible(false);
		tabelaLivros.setLinesVisible(true);
		tabelaLivros.setHeaderVisible(true);
		tabelaLivros.setBounds(157, 146, 495, 305);
		tabelaLivros.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println(e.toString());
				int indexLivroSelecionado = ((Table)e.widget).indexOf((TableItem)e.item);
				System.out.println( indexLivroSelecionado );
				livroSelecionado = listaLivrosDaBusca.get(indexLivroSelecionado);
				//fazer corresponder o livro selecionado a um dos livros da livraria, para as mudanças
				//de stock, se reproduzirem na livraria
				livroSelecionado = livraria.getLivro(livroSelecionado.isbn);
				//caso não haja nenhum selecionado, não acontece nada
				if (livroSelecionado==null) {
				}
				//caso se selecione um dos livros -> passam a estar disponíveis as caixas para alterar dados do livro
				else {
					visibilidadesSelecionadoLivroAlterar();
					preencherCaixasLivro();
				}
			}
		});
		preencherTabela();
		
		
		/**
		 *
		 * elementos visiveis para 'alterar livro'
		 * 
		 */
		lblTitulo = new Label(shlMenuAdmin, SWT.NONE);
		lblTitulo.setVisible(false);
		lblTitulo.setAlignment(SWT.RIGHT);
		lblTitulo.setBounds(184, 65, 70, 20);
		lblTitulo.setText("T\u00EDtulo");
		
		lblIsbn = new Label(shlMenuAdmin, SWT.NONE);
		lblIsbn.setVisible(false);
		lblIsbn.setAlignment(SWT.RIGHT);
		lblIsbn.setText("ISBN");
		lblIsbn.setBounds(184, 115, 70, 20);
		
		lblAutor = new Label(shlMenuAdmin, SWT.NONE);
		lblAutor.setVisible(false);
		lblAutor.setText("Autor");
		lblAutor.setAlignment(SWT.RIGHT);
		lblAutor.setBounds(184, 165, 70, 20);
		
		lblEditora = new Label(shlMenuAdmin, SWT.NONE);
		lblEditora.setVisible(false);
		lblEditora.setText("Editora");
		lblEditora.setAlignment(SWT.RIGHT);
		lblEditora.setBounds(184, 215, 70, 20);
		
		lblPreco = new Label(shlMenuAdmin, SWT.NONE);
		lblPreco.setVisible(false);
		lblPreco.setText("Pre\u00E7o (\u20AC)");
		lblPreco.setAlignment(SWT.RIGHT);
		lblPreco.setBounds(184, 265, 70, 20);
		
		lblStock = new Label(shlMenuAdmin, SWT.NONE);
		lblStock.setVisible(false);
		lblStock.setText("Stock");
		lblStock.setAlignment(SWT.RIGHT);
		lblStock.setBounds(184, 315, 70, 20);
		
		lblData = new Label(shlMenuAdmin, SWT.NONE);
		lblData.setVisible(false);
		lblData.setText("Data");
		lblData.setAlignment(SWT.RIGHT);
		lblData.setBounds(184, 365, 70, 20);
		
		lblDescricao = new Label(shlMenuAdmin, SWT.NONE);
		lblDescricao.setVisible(false);
		lblDescricao.setText("Descri\u00E7\u00E3o");
		lblDescricao.setAlignment(SWT.RIGHT);
		lblDescricao.setBounds(184, 415, 70, 20);
		
		caixaTitulo = new Text(shlMenuAdmin, SWT.BORDER);
		System.out.println("texto para caixa de titulo");
		System.out.println(livroSelecionado.getNome());
		caixaTitulo.setText(livroSelecionado.getNome());
		caixaTitulo.setVisible(false);
		caixaTitulo.setBounds(261, 65, 196, 30);
		
		caixaIsbn = new Text(shlMenuAdmin, SWT.BORDER);
		caixaIsbn.setVisible(false);
		caixaIsbn.setBounds(261, 115, 196, 30);
		
		caixaAutor = new Text(shlMenuAdmin, SWT.BORDER);
		caixaAutor.setVisible(false);
		caixaAutor.setBounds(261, 165, 196, 30);
		
		caixaEditora = new Text(shlMenuAdmin, SWT.BORDER);
		caixaEditora.setVisible(false);
		caixaEditora.setBounds(261, 215, 196, 30);
		
		caixaPreco = new Text(shlMenuAdmin, SWT.BORDER);
		caixaPreco.setVisible(false);
		caixaPreco.setBounds(261, 265, 196, 30);
		
		caixaStock = new Spinner(shlMenuAdmin, SWT.BORDER);
		caixaStock.setVisible(false);
		caixaStock.setBounds(261, 315, 114, 26);
		
		caixaData = new DateTime(shlMenuAdmin, SWT.BORDER);
		caixaData.setVisible(false);
		caixaData.setBounds(261, 365, 114, 28);
		
		caixaDescricao = new Text(shlMenuAdmin, SWT.BORDER | SWT.WRAP);
		caixaDescricao.setVisible(false);
		caixaDescricao.setBounds(260, 415, 266, 70);
		
		Label lblIntroduzaTitulo = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaTitulo.setVisible(false);
		lblIntroduzaTitulo.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaTitulo.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaTitulo.setText("Introduza t\u00EDtulo");
		lblIntroduzaTitulo.setBounds(261, 94, 196, 18);
		
		Label lblIsbIncorreto = new Label(shlMenuAdmin, SWT.NONE);
		lblIsbIncorreto.setVisible(false);
		lblIsbIncorreto.setText("ISBN incorreto (13 d\u00EDgitos)");
		lblIsbIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIsbIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIsbIncorreto.setBounds(261, 146, 196, 18);
		
		Label lblIntroduzaAutor = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaAutor.setVisible(false);
		lblIntroduzaAutor.setText("Introduza autor");
		lblIntroduzaAutor.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaAutor.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaAutor.setBounds(261, 196, 196, 18);
		
		Label lblIntroduzaEditora = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaEditora.setVisible(false);
		lblIntroduzaEditora.setText("Introduza editora");
		lblIntroduzaEditora.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaEditora.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaEditora.setBounds(261, 245, 196, 18);
		
		Label lblPrecoIncorreto = new Label(shlMenuAdmin, SWT.NONE);
		lblPrecoIncorreto.setVisible(false);
		lblPrecoIncorreto.setText("Pre\u00E7o incorreto");
		lblPrecoIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblPrecoIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblPrecoIncorreto.setBounds(261, 295, 196, 18);
		
		Label lblIntroduzaDescricao = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaDescricao.setVisible(false);
		lblIntroduzaDescricao.setText("Introduza descri\u00E7\u00E3o");
		lblIntroduzaDescricao.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaDescricao.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaDescricao.setBounds(532, 417, 150, 18);
		
		btnSubmeterAlteracoes = new Button(shlMenuAdmin, SWT.NONE);
		btnSubmeterAlteracoes.setVisible(false);
		btnSubmeterAlteracoes.setBounds(520, 234, 150, 78);
		btnSubmeterAlteracoes.setText("Submeter Altera\u00E7\u00F5es");
		
		
		
		
		
		
		

	}
	
	
	
	public void visibilidadesBtnAlterarLivro() {
		lblMensagemSemCorrespondencias.setVisible(false);
		lblSelecioneLivro.setVisible(true);
		CaixaDePesquisa.setVisible(true);
		btnPesquisar.setVisible(true);
		tabelaLivros.setVisible(true);
		
		lblTitulo.setVisible(false);
		lblIsbn.setVisible(false);
		lblAutor.setVisible(false);
		lblEditora.setVisible(false);
		lblDescricao.setVisible(false);
		lblData.setVisible(false);
		lblPreco.setVisible(false);
		lblStock.setVisible(false);
		
		caixaTitulo.setVisible(false);
		caixaIsbn.setVisible(false);
		caixaAutor.setVisible(false);
		caixaEditora.setVisible(false);
		caixaPreco.setVisible(false);
		caixaStock.setVisible(false);
		caixaData.setVisible(false);
		caixaDescricao.setVisible(false);
		
		btnSubmeterAlteracoes.setVisible(false);
	}
	
	public void visibilidadesSelecionadoLivroAlterar() {
		lblMensagemSemCorrespondencias.setVisible(false);
		lblSelecioneLivro.setVisible(false);
		CaixaDePesquisa.setVisible(false);
		btnPesquisar.setVisible(false);
		tabelaLivros.setVisible(false);
		
		lblTitulo.setVisible(true);
		lblIsbn.setVisible(true);
		lblAutor.setVisible(true);
		lblEditora.setVisible(true);
		lblDescricao.setVisible(true);
		lblData.setVisible(true);
		lblPreco.setVisible(true);
		lblStock.setVisible(true);
		
		caixaTitulo.setVisible(true);
		caixaIsbn.setVisible(true);
		caixaAutor.setVisible(true);
		caixaEditora.setVisible(true);
		caixaPreco.setVisible(true);
		caixaStock.setVisible(true);
		caixaData.setVisible(true);
		caixaDescricao.setVisible(true);
		
		btnSubmeterAlteracoes.setVisible(true);
	}
	
	//Método para limpar e preencher novamente a tabela 
	public void preencherTabela() {
		//limpar tabela
		tabelaLivros.removeAll();
		//Chamar novamente o método 'procurarLivro' para actualizar os stocks dos livros da 'listaLivrosDaBusca'
		listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
		//adicionar um a um os livros da lista de livros da busca à table
		for (Livro lv : listaLivrosDaBusca) {
		      TableItem item = new TableItem(tabelaLivros, SWT.NONE);
		      item.setText(lv.toString());
		}
		tabelaLivros.redraw();	
	}	
	
	//
	//Método para preencher as caixas de alteração de dados de livro, com os dados do livro selecionado
	public void preencherCaixasLivro() {
		caixaTitulo.setText(livroSelecionado.nome);
		caixaIsbn.setText(livroSelecionado.isbn);
		caixaAutor.setText(livroSelecionado.autor);
		caixaEditora.setText(livroSelecionado.editora);
		caixaPreco.setText(String.valueOf(livroSelecionado.preco));
		caixaStock.setSelection(livroSelecionado.stock);
		System.out.println(livroSelecionado.getData());
		System.out.println(livroSelecionado.data);
		System.out.println("" + livroSelecionado.getData().get(Calendar.YEAR)+"/" +(livroSelecionado.getData().get(Calendar.MONTH) + 1) 
				+ "/" + livroSelecionado.getData().get(Calendar.DAY_OF_MONTH));
		int ano = livroSelecionado.getData().get(Calendar.YEAR);
		int mes = livroSelecionado.getData().get(Calendar.MONTH) + 1;
		int dia =  livroSelecionado.getData().get(Calendar.DAY_OF_MONTH) ;
		caixaData.setDate(dia,mes,ano);
		//caixaData.setDate(livroSelecionado.getData().get(Calendar.YEAR), (livroSelecionado.getData().get(Calendar.MONTH) + 1), 
		//		livroSelecionado.getData().get(Calendar.DAY_OF_MONTH));
		caixaDescricao.setText(livroSelecionado.descricao);
	}	
}
