package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
@SuppressWarnings("serial")
public class J_11Menu_Admin implements Serializable {
	/**
	 * Atributos da classe
	 */
	protected Shell shlMenuAdmin;
	protected Livraria livraria;
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
	private Button btnSubmeterNovoLivro;
	private Text caixaTitulo;
	private Text caixaIsbn;
	private Text caixaAutor;
	private Text caixaEditora;
	private Text caixaDescricao;
	private Text caixaPreco;
	
	private Spinner caixaStock;
	private DateTime caixaData;
	
	private Label lblIntroduzaTitulo;
	private Label lblIsbIncorreto;
	private Label lblIntroduzaAutor;
	private Label lblIntroduzaEditora;
	private Label lblPrecoIncorreto;
	private Label lblIntroduzaDescricao;
	private Label lblDataIncorreta;
	private Label lblNomeVendedor;
	private Label lblEmail;
	private Label lblSenha;
	private Label lblIntroduzaNome;
	private Label lblEmailIncorreto;
	private Label lblSenhaIncorreta;
	private Button btbSubmeterVendedor;
	private TableColumn tblclmnLivros;
	private Button btnVerHistrico;
	
	/**
	 * Construtor que traz Livraria e utilizador para esta classe da janela anterior J_01
	 */
	public J_11Menu_Admin(Livraria livraria, Utilizador utilizador) {
		//super();
		this.utilizador = utilizador;
		this.livraria = livraria;
		listaLivrosDaBusca =  livraria.getLivros();
		stringProcurada = "";
		livroSelecionado = new Livro();
	}	
	
	/**
	 * Abrir a janela
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
	 * Criar conteúdos da janela
	 */
	protected void createContents() {
		shlMenuAdmin = new Shell();
		shlMenuAdmin.setSize(846, 542);
		shlMenuAdmin.setText("Menu Administrador");
		
		/**
		 *
		 * elementos sempre visíveis
		 * 
		 */
		Label lblMenuAdministrador = new Label(shlMenuAdmin, SWT.NONE);
		lblMenuAdministrador.setText("MENU ADMINISTRADOR");
		lblMenuAdministrador.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuAdministrador.setBounds(10, 10, 229, 38);
		
		Label lblNomeUtilizador = new Label(shlMenuAdmin, SWT.NONE);
		lblNomeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeUtilizador.setBounds(515, 10, 303, 21);
		lblNomeUtilizador.setText("Bem-vindo(a) " + utilizador.nome);
		
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
		btnAdicionarLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				limparCaixasLivro();
				visibilidadesBtnAdicionarLivro();
			}
		});
		
		Button btnRegistarVendedor = new Button(shlMenuAdmin, SWT.NONE);
		btnRegistarVendedor.setText("Registar vendedor");
		btnRegistarVendedor.setBounds(10, 234, 133, 30);
		btnRegistarVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				visibilidadesBtnRegistarVendedor();
			}
		});

		Button btnVoltar = new Button(shlMenuAdmin, SWT.NONE);
		btnVoltar.setText("Voltar/Logout");
		btnVoltar.setBounds(714, 457, 104, 28);
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
		
		tabelaLivros = new Table(shlMenuAdmin, SWT.BORDER | SWT.UP|SWT.FULL_SELECTION);
		tabelaLivros.setVisible(false);
		tabelaLivros.setLinesVisible(true);
		//tabelaLivros.setHeaderVisible(true);
		tabelaLivros.setBounds(157, 146, 550, 339);
		
		tblclmnLivros = new TableColumn(tabelaLivros, SWT.NONE);
		tblclmnLivros.setWidth(525);
		tblclmnLivros.setText("Livros");
		//tabelaLivros.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		
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
		 * elementos visiveis para 'alterar livro' e 'adicionar livro'
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
		caixaPreco.setBounds(261, 265, 78, 30);
		
		btnVerHistrico = new Button(shlMenuAdmin, SWT.NONE);
		btnVerHistrico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				J_04HistoricoPrecos janelaPrecos = new J_04HistoricoPrecos(livraria, livroSelecionado);
				janelaPrecos.open();
			}
		});
		btnVerHistrico.setVisible(false);
		btnVerHistrico.setBounds(356, 265, 90, 30);
		btnVerHistrico.setText("Ver hist\u00F3rico");
		
		caixaStock = new Spinner(shlMenuAdmin, SWT.BORDER);
		caixaStock.setVisible(false);
		caixaStock.setBounds(261, 315, 114, 26);
		
		caixaData = new DateTime(shlMenuAdmin, SWT.BORDER);
		caixaData.setVisible(false);
		caixaData.setBounds(261, 365, 114, 28);
		
		caixaDescricao = new Text(shlMenuAdmin, SWT.BORDER | SWT.WRAP);
		caixaDescricao.setVisible(false);
		caixaDescricao.setBounds(260, 415, 266, 70);
		
		lblIntroduzaTitulo = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaTitulo.setVisible(false);
		lblIntroduzaTitulo.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaTitulo.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaTitulo.setText("Introduza t\u00EDtulo");
		lblIntroduzaTitulo.setBounds(261, 94, 196, 18);
		
		lblIsbIncorreto = new Label(shlMenuAdmin, SWT.NONE);
		lblIsbIncorreto.setVisible(false);
		lblIsbIncorreto.setText("ISBN incorreto (13 d\u00EDgitos)");
		lblIsbIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIsbIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIsbIncorreto.setBounds(261, 146, 196, 18);
		
		lblIntroduzaAutor = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaAutor.setVisible(false);
		lblIntroduzaAutor.setText("Introduza autor");
		lblIntroduzaAutor.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaAutor.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaAutor.setBounds(261, 196, 196, 18);
		
		lblIntroduzaEditora = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaEditora.setVisible(false);
		lblIntroduzaEditora.setText("Introduza editora");
		lblIntroduzaEditora.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaEditora.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaEditora.setBounds(261, 245, 196, 18);
		
		lblPrecoIncorreto = new Label(shlMenuAdmin, SWT.NONE);
		lblPrecoIncorreto.setVisible(false);
		lblPrecoIncorreto.setText("Pre\u00E7o incorreto");
		lblPrecoIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblPrecoIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblPrecoIncorreto.setBounds(261, 295, 196, 18);
		
		lblDataIncorreta = new Label(shlMenuAdmin, SWT.NONE);
		lblDataIncorreta.setVisible(false);
		lblDataIncorreta.setText("Data posterior \u00E0 atual");
		lblDataIncorreta.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblDataIncorreta.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblDataIncorreta.setBounds(261, 395, 196, 18);
		
		lblIntroduzaDescricao = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaDescricao.setVisible(false);
		lblIntroduzaDescricao.setText("Introduza descri\u00E7\u00E3o");
		lblIntroduzaDescricao.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaDescricao.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaDescricao.setBounds(532, 417, 150, 18);
		
		btnSubmeterAlteracoes = new Button(shlMenuAdmin, SWT.NONE);
		btnSubmeterAlteracoes.setVisible(false);
		btnSubmeterAlteracoes.setBounds(520, 234, 150, 78);
		btnSubmeterAlteracoes.setText("Submeter Altera\u00E7\u00F5es");
		btnSubmeterAlteracoes.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//se dados introduzidos forem válidos para um livro
				if ( verificarSeLivroValido() ) {
					//registar alterações no livro
					registarAlteracoesNoLivroSelecionado();
					//abrir janela de mensagem de livro alterado
					visibilidadesInicio();
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("Livro alterado com sucesso","");
					janela.open();
				}
				//caso os dados não sejam válidos, não fazer nada, porque o método 'verificarSeValido' 
				//vai fazer mostrar os alertas de erros
				else {
				}
				livraria.saveAll();
			}
		});
		
		btnSubmeterNovoLivro = new Button(shlMenuAdmin, SWT.NONE);
		btnSubmeterNovoLivro.setVisible(false);
		btnSubmeterNovoLivro.setBounds(520, 234, 150, 78);
		btnSubmeterNovoLivro.setText("Submeter novo livro");
		btnSubmeterNovoLivro.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//se dados introduzidos forem válidos para um livro
				if ( verificarSeLivroValido() ) {
					//criar novo livro a partir dos dados inseridos e adicionar novo livro à livraria
					livraria.getLivros().add( recolherDadosNovoLivro() );
					//abrir janela de mensagem de novo livro registado
					visibilidadesInicio();
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("Livro registado com sucesso","");
					janela.open();
				}
				//caso os dados não sejam válidos, não fazer nada, porque o método 'verificarSeValido' 
				//vai fazer mostrar os alertas de erros
				else {
				}
				livraria.saveAll();
			}
		});
		
		/**
		 *
		 * elementos visiveis para 'registar vendedor'
		 * 
		 */
		lblNomeVendedor = new Label(shlMenuAdmin, SWT.NONE);
		lblNomeVendedor.setVisible(false);
		lblNomeVendedor.setText("Nome do vendedor");
		lblNomeVendedor.setAlignment(SWT.RIGHT);
		lblNomeVendedor.setBounds(96, 65, 158, 20);
		
		lblEmail = new Label(shlMenuAdmin, SWT.NONE);
		lblEmail.setVisible(false);
		lblEmail.setText("e-mail");
		lblEmail.setAlignment(SWT.RIGHT);
		lblEmail.setBounds(184, 115, 70, 20);
		
		lblSenha = new Label(shlMenuAdmin, SWT.NONE);
		lblSenha.setVisible(false);
		lblSenha.setText("Senha");
		lblSenha.setAlignment(SWT.RIGHT);
		lblSenha.setBounds(184, 165, 70, 20);
		
		lblIntroduzaNome = new Label(shlMenuAdmin, SWT.NONE);
		lblIntroduzaNome.setVisible(false);
		lblIntroduzaNome.setText("Introduza nome");
		lblIntroduzaNome.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaNome.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblIntroduzaNome.setBounds(261, 94, 196, 18);
		
		lblEmailIncorreto = new Label(shlMenuAdmin, SWT.NONE);
		lblEmailIncorreto.setVisible(false);
		lblEmailIncorreto.setText("e-mail incorreto");
		lblEmailIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblEmailIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblEmailIncorreto.setBounds(261, 146, 196, 18);
		
		lblSenhaIncorreta = new Label(shlMenuAdmin, SWT.NONE);
		lblSenhaIncorreta.setVisible(false);
		lblSenhaIncorreta.setText("Senha incorreta (minimo 3 carateres)");
		lblSenhaIncorreta.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSenhaIncorreta.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblSenhaIncorreta.setBounds(261, 196, 196, 18);
		
		btbSubmeterVendedor = new Button(shlMenuAdmin, SWT.NONE);
		btbSubmeterVendedor.setVisible(false);
		btbSubmeterVendedor.setText("Submeter novo vendedor");
		btbSubmeterVendedor.setBounds(260, 286, 207, 78);
		btbSubmeterVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//se dados introduzidos forem válidos para um vendedor
				if ( verificarSeUtilizadorValido() ) {
					//criar novo livro a partir dos dados inseridos e adicionar novo livro à livraria
					livraria.getUtilizadores().add( recolherDadosNovoUtilizador() );
					//abrir janela de mensagem de novo vendedor registado
					visibilidadesInicio();
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("Vendedor registado com sucesso","");
					janela.open();
				}
				//caso os dados não sejam válidos, não fazer nada, porque o método 'verificarSeUtilizadorValido' 
				//vai fazer mostrar os alertas de erros
				else {
				}
				livraria.saveAll();
			}
		});
		
		// Listner que deixa definir a altura de cada linha da table
		// é preciso importar o org.eclipse.swt.widgets.Event;
		tabelaLivros.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				// definir altura aqui
				event.height = 120;
			}
		});		

	}
	
	/**
	 *
	 * Métodos fora do 'createContents()'
	 * 
	 */
	
	
	
	
	/**
	 * Método para limpar e preencher a tabela
	 */
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
	
	/**
	 * Método para preencher as caixas de alteração de dados de livro, com os dados do livro selecionado
	 */
	public void preencherCaixasLivro() {
		caixaTitulo.setText(livroSelecionado.nome);
		caixaIsbn.setText(livroSelecionado.isbn);
		caixaAutor.setText(livroSelecionado.autor);
		caixaEditora.setText(livroSelecionado.editora);
		caixaPreco.setText(String.valueOf(livroSelecionado.preco));
		caixaStock.setSelection(livroSelecionado.stock);
		caixaData.setYear(livroSelecionado.getData().get(Calendar.YEAR));
		caixaData.setMonth( (livroSelecionado.getData().get(Calendar.MONTH)-1) );
		caixaData.setDay(livroSelecionado.getData().get(Calendar.DAY_OF_MONTH));
		caixaDescricao.setText(livroSelecionado.descricao);
	}	
	
	/**
	 * Método para preencher as caixas de alteração de dados de livro, com os dados do livro selecionado
	 */
	public void limparCaixasLivro() {
		caixaTitulo.setText("");
		caixaIsbn.setText("");
		caixaAutor.setText("");
		caixaEditora.setText("");
		caixaPreco.setText("");
		caixaStock.setSelection(0);
		GregorianCalendar data = new GregorianCalendar();
		caixaData.setYear(data.get(Calendar.YEAR));
		caixaData.setMonth( (data.get(Calendar.MONTH)));
		caixaData.setDay(data.get(Calendar.DAY_OF_MONTH));
		caixaDescricao.setText("");
	}	
	
	/**
	 * Método para recolher dados das caixas de alteração de dados de livro
	 */
	public boolean verificarSeLivroValido() {
		//verificar se título não está em branco
		String novoTitulo = caixaTitulo.getText();
		if ( novoTitulo.equals("") ) {
			lblIntroduzaTitulo.setVisible(true);
			return false;
		}
		else {
			lblIntroduzaTitulo.setVisible(false);
		}
		//verificar se é um ISBN válido
		String novoIsbn = caixaIsbn.getText();
		if ( !verificarISBN(novoIsbn) ) {
			lblIsbIncorreto.setVisible(true);
			return false;
		}
		else {
			lblIsbIncorreto.setVisible(false);
		}
		//verificar se autor não está em branco
		String novoAutor = caixaAutor.getText();
		if ( novoAutor.equals("") ) {
			lblIntroduzaAutor.setVisible(true);
			return false;
		}
		else {
			lblIntroduzaAutor.setVisible(false);
		}
		//verificar se editora não está em branco
		String novaEditora = caixaEditora.getText();
		if ( novaEditora.equals("") ) {
			lblIntroduzaEditora.setVisible(true);
			return false;
		}
		else {
			lblIntroduzaEditora.setVisible(false);
		}
		//verificar se preço é válido
		String novoPreco = caixaPreco.getText();
		if ( novoPreco.equals("") ) {
			lblPrecoIncorreto.setVisible(true);
			return false;
		}
		else if ( !verificarSeDouble(novoPreco) ){
			lblPrecoIncorreto.setVisible(true);
		}
		else {
			lblPrecoIncorreto.setVisible(false);
		}
		//verificar se data posterior à atual
		GregorianCalendar novaData = new GregorianCalendar(caixaData.getYear(), caixaData.getMonth()-1, caixaData.getDay());
		GregorianCalendar agora = new GregorianCalendar();
		//adicionar um dia mais a agora, para evitar conflitos com o dia atual
		agora.add(Calendar.DATE, 1);
		if ( novaData.after(agora) ){
			lblDataIncorreta.setVisible(true);
			return false;
		}
		else {
			lblDataIncorreta.setVisible(false);
		}
		//verificar se descrição não está em branco
		String novaDescricao = caixaDescricao.getText();
		if ( novaDescricao.equals("") ) {
			lblIntroduzaDescricao.setVisible(true);
			return false;
		}
		else {
			lblIntroduzaDescricao.setVisible(false);
		}
		return true;
	}	
	
	/**
	 * Método para recolher dados das caixas de alteração de dados de livro
	 */
	public boolean verificarSeUtilizadorValido() {
		//verificar se nome não está em branco
		String nome = caixaTitulo.getText();
		if ( nome.equals("") ) {
			lblIntroduzaNome.setVisible(true);
			return false;
		}
		else {
			lblIntroduzaNome.setVisible(false);
		}
		//verificar se é um email válido
		String email = caixaIsbn.getText();
		if ( !verificarSeEmail( email) ) {
			lblEmailIncorreto.setVisible(true);
			return false;
		}
		else {
			lblEmailIncorreto.setVisible(false);
		}
		//verificar se senha tem mais de 3 carateres
		String senha = caixaAutor.getText();
		if ( senha.toCharArray().length < 3 ) {
			lblSenhaIncorreta.setVisible(true);
			return false;
		}		
		else {
			lblSenhaIncorreta.setVisible(false);
		}
		return true;
	}		
	
	/**
	 * Método para verificar se ISBN é válido
	 */
	public boolean verificarISBN(String s) {
		//ver se tem algum carater que não seja numero
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		//ver se tem 13 digitos
		if ( s.toCharArray().length!=13 ) {
			return false;
		}
		return true;
	}
	
	/**
	 * Método para verificar se preço é um double
	 */
	public boolean verificarSeDouble(String s) {
		try {
	        @SuppressWarnings("unused")
			double d = Double.parseDouble(s);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}	
	
	/**
	 * Método para verificar se email é válido
	 */
	public boolean verificarSeEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	/**
	 * Método para recolher dados das caixas de alteração de dados de livro e registar no livro selecionado
	 */
	public void registarAlteracoesNoLivroSelecionado() {
		livroSelecionado.setNome( caixaTitulo.getText());
		livroSelecionado.setIsbn(caixaIsbn.getText());
		livroSelecionado.setAutor( caixaAutor.getText());
		livroSelecionado.setEditora(caixaEditora.getText());
		double novoPreco = Double.parseDouble(caixaPreco.getText());
		//Se preço foi alterado -> actualizar o novo preço e actualizar o HashMap de datas/preços
		if ( novoPreco != livroSelecionado.preco ) {
			livroSelecionado.precosAnteriores.put(new GregorianCalendar(), novoPreco);
			livroSelecionado.setPreco( novoPreco );
		}
		livroSelecionado.setStock(Integer.parseInt(caixaStock.getText()));
		livroSelecionado.setData( new GregorianCalendar(caixaData.getYear(), caixaData.getMonth()-1, caixaData.getDay()) ); 
		livroSelecionado.setDescricao( caixaDescricao.getText() );
	}	
	
	/**
	 * Método para recolher dados das caixas para novo livro e devolver esse livro
	 */
	public Livro recolherDadosNovoLivro() {
		String titulo = caixaTitulo.getText();
		String isbn = caixaIsbn.getText();
		String autor = caixaAutor.getText();
		String editora = caixaEditora.getText();
		int stock = Integer.parseInt(caixaStock.getText());
		GregorianCalendar data = new GregorianCalendar(caixaData.getYear(), caixaData.getMonth()-1, caixaData.getDay() ); 
		String descricao = caixaDescricao.getText();
		double preco = Double.parseDouble(caixaPreco.getText());
		//Criar novo hashmap de datas/preços com o novo preço, para a data atual
		HashMap <GregorianCalendar, Double > precos = new HashMap<>();
		precos.put(new GregorianCalendar(), preco);
		return new Livro(titulo, isbn, autor, editora, descricao, data, preco, stock, precos);	
	}	
	
	
	/**
	 * Método para recolher dados das caixas para novo utilizador e devolver novo utilizador
	 */
	public Utilizador recolherDadosNovoUtilizador() {
		String nome = caixaTitulo.getText();
		String email = caixaIsbn.getText();
		String senha = caixaAutor.getText();
		int uID = livraria.gerarNovoNumUtilizador();
		//como queremos um vendedor o utilizador é do tipo vendedor
		return new Utilizador(uID, nome, email, senha, Utilizador.Tipo.VENDEDOR );	
	}	
	
	
	/**
	 * Métodos para ativar ou desativar a visibilidade de vários componentes da janela
	 * 
	 * 
	 * 
	 * 
	 */
	public void visibilidadesInicio() {
		lblMensagemSemCorrespondencias.setVisible(false);
		lblSelecioneLivro.setVisible(false);
		CaixaDePesquisa.setVisible(false);
		btnPesquisar.setVisible(false);
		tabelaLivros.setVisible(false);
		
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
		btnVerHistrico.setVisible(false);
		caixaStock.setVisible(false);
		caixaData.setVisible(false);
		caixaDescricao.setVisible(false);
		
		btnSubmeterAlteracoes.setVisible(false);
		btnSubmeterNovoLivro.setVisible(false);
		
		lblIntroduzaTitulo.setVisible(false);
		lblIntroduzaAutor.setVisible(false);
		lblIntroduzaEditora.setVisible(false);
		lblIntroduzaDescricao.setVisible(false);
		lblDataIncorreta.setVisible(false);
		
		lblNomeVendedor.setVisible(false);
		lblEmail.setVisible(false);
		lblSenha.setVisible(false);
		lblIntroduzaNome.setVisible(false);
		lblEmailIncorreto.setVisible(false);
		lblSenhaIncorreta.setVisible(false);
		btbSubmeterVendedor.setVisible(false);
	}
	
	public void visibilidadesBtnAlterarLivro() {
		preencherTabela();
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
		btnVerHistrico.setVisible(false);
		caixaStock.setVisible(false);
		caixaData.setVisible(false);
		caixaDescricao.setVisible(false);
		
		btnSubmeterAlteracoes.setVisible(false);
		btnSubmeterNovoLivro.setVisible(false);
		
		lblIntroduzaTitulo.setVisible(false);
		lblIntroduzaAutor.setVisible(false);
		lblIntroduzaEditora.setVisible(false);
		lblIntroduzaDescricao.setVisible(false);
		lblDataIncorreta.setVisible(false);
		
		lblNomeVendedor.setVisible(false);
		lblEmail.setVisible(false);
		lblSenha.setVisible(false);
		lblIntroduzaNome.setVisible(false);
		lblEmailIncorreto.setVisible(false);
		lblSenhaIncorreta.setVisible(false);
		btbSubmeterVendedor.setVisible(false);
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
		btnVerHistrico.setVisible(true);
		caixaStock.setVisible(true);
		caixaData.setVisible(true);
		caixaDescricao.setVisible(true);
		
		btnSubmeterAlteracoes.setVisible(true);
		btnSubmeterNovoLivro.setVisible(false);
		
		lblNomeVendedor.setVisible(false);
		lblEmail.setVisible(false);
		lblSenha.setVisible(false);
		lblIntroduzaNome.setVisible(false);
		lblEmailIncorreto.setVisible(false);
		lblSenhaIncorreta.setVisible(false);
		btbSubmeterVendedor.setVisible(false);
	}
	
	public void visibilidadesBtnAdicionarLivro() {
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
		btnVerHistrico.setVisible(false);
		caixaStock.setVisible(true);
		caixaData.setVisible(true);
		caixaDescricao.setVisible(true);
		
		btnSubmeterAlteracoes.setVisible(false);
		btnSubmeterNovoLivro.setVisible(true);
		
		lblIntroduzaTitulo.setVisible(false);
		lblIntroduzaAutor.setVisible(false);
		lblIntroduzaEditora.setVisible(false);
		lblIntroduzaDescricao.setVisible(false);
		lblDataIncorreta.setVisible(false);
		
		lblNomeVendedor.setVisible(false);
		lblEmail.setVisible(false);
		lblSenha.setVisible(false);
		lblIntroduzaNome.setVisible(false);
		lblEmailIncorreto.setVisible(false);
		lblSenhaIncorreta.setVisible(false);
		btbSubmeterVendedor.setVisible(false);
	}
	
	public void visibilidadesBtnRegistarVendedor() {
		limparCaixasLivro();
		lblMensagemSemCorrespondencias.setVisible(false);
		lblSelecioneLivro.setVisible(false);
		CaixaDePesquisa.setVisible(false);
		btnPesquisar.setVisible(false);
		tabelaLivros.setVisible(false);
		
		lblTitulo.setVisible(false);
		lblIsbn.setVisible(false);
		lblAutor.setVisible(false);
		lblEditora.setVisible(false);
		lblDescricao.setVisible(false);
		lblData.setVisible(false);
		lblPreco.setVisible(false);
		lblStock.setVisible(false);
		
		caixaTitulo.setVisible(true);
		caixaIsbn.setVisible(true);
		caixaAutor.setVisible(true);
		caixaEditora.setVisible(false);
		caixaPreco.setVisible(false);
		btnVerHistrico.setVisible(false);
		caixaStock.setVisible(false);
		caixaData.setVisible(false);
		caixaDescricao.setVisible(false);
		
		btnSubmeterAlteracoes.setVisible(false);
		btnSubmeterNovoLivro.setVisible(false);
		
		lblIntroduzaTitulo.setVisible(false);
		lblIntroduzaAutor.setVisible(false);
		lblIntroduzaEditora.setVisible(false);
		lblIntroduzaDescricao.setVisible(false);
		lblDataIncorreta.setVisible(false);
		
		lblNomeVendedor.setVisible(true);
		lblEmail.setVisible(true);
		lblSenha.setVisible(true);
		lblIntroduzaNome.setVisible(false);
		lblEmailIncorreto.setVisible(false);
		lblSenhaIncorreta.setVisible(false);
		btbSubmeterVendedor.setVisible(true);
	}
}
