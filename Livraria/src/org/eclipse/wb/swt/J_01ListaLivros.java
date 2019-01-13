package org.eclipse.wb.swt;
import java.text.Collator;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TableColumn;
import java.util.Locale;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_01ListaLivros {

	protected Shell shlViewComicsInc;
	// protected static ArrayList <Livro> listaLivrosCarrinho = new
	// ArrayList<>();//adicionou-se este atributo para criar carrinho a partir desta
	// lista
	protected Livro livroSelecionado;// atributo que nos dá o livro que está selecionado na table
	protected Livraria livraria;// atributo adicionado para poder ir buscar métodos à livraria
	protected Carrinho carrinho;
	protected String stringProcurada;
	protected ArrayList<Livro> listaLivrosDaBusca;
	// protected int indexLivroSelecionado;//adicionou-se este atributo para poder
	// passá-lo entre métodos
	private Table table;
	private Text caixaDeBusca;// adicionou-se carrinho para cria-lo e passar para outras classes

//	
//	
//	
//	
//	VOLTAR A DISPONIBILIZAR O CONSTRUTOR EM BAIXO
//	
//	
//	
//	
//	
//	
	
	// Criou-se construtor para poder receber o carrinho da janela seguinte
	// 'J_02Carrinho'
	public J_01ListaLivros(Livraria livraria, Carrinho carrinho1) {
		this.livraria = livraria;
		carrinho = carrinho1;
		stringProcurada = "";
		open();
	}

	// Construtor para quando se vem da janela anterior 'J_00Inicial'
	public J_01ListaLivros(Livraria livraria, ArrayList<Livro> listaLivrosDaBusca, String stringProcurada) {
		this.livraria = livraria;
		this.listaLivrosDaBusca = listaLivrosDaBusca;
		carrinho = new Carrinho();
		this.stringProcurada = stringProcurada;
		open();
	}

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			//Foi necessário adicionar aqui a arrayList de livros
//			//J_01ListaLivros window = new J_01ListaLivros(new ArrayList<Livro>());
//			J_01ListaLivros window = new J_01ListaLivros();
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
		shlViewComicsInc.open();
		shlViewComicsInc.layout();
		while (!shlViewComicsInc.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * 
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlViewComicsInc = new Shell();
		shlViewComicsInc.setSize(840, 560);
		shlViewComicsInc.setText("View Comics Inc.");

		// Label que dá mensagem de erro caso o livro não esteja dizponível
		Label lblMensagemLivroIndisponivel = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemLivroIndisponivel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemLivroIndisponivel.setBounds(664, 76, 124, 20);
		lblMensagemLivroIndisponivel.setText("Livro Indispon\u00EDvel");
		lblMensagemLivroIndisponivel.setVisible(false);

		// Label que dá mensagem de erro caso o livro não esteja dizponível
		Label lblMensagemSelecioneLivro = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemSelecioneLivro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemSelecioneLivro.setBounds(664, 76, 134, 20);
		lblMensagemSelecioneLivro.setText("Selecione um livro");
		lblMensagemSelecioneLivro.setVisible(false);
		
		// Label que dá mensagem de erro caso o livro não esteja dizponível
		Label lblMensagemAdicioneLivro = new Label(shlViewComicsInc, SWT.WRAP | SWT.LEFT);
		lblMensagemAdicioneLivro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemAdicioneLivro.setBounds(664, 76, 134, 40);
		lblMensagemAdicioneLivro.setVisible(false);	
		GridData data = new GridData(SWT.HORIZONTAL, SWT.TOP, true, false, 1, 1);
		lblMensagemAdicioneLivro.setLayoutData(data);
		lblMensagemAdicioneLivro.setText("Carrinho vazio\nAdicione livro(s)");


		table = new Table(shlViewComicsInc, SWT.BORDER | SWT.UP|SWT.FULL_SELECTION );
		// listner para ação ao selecionar um dos items da table e devolve o index do
		// item na lista de livros
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblMensagemAdicioneLivro.setVisible(false);	
				lblMensagemLivroIndisponivel.setVisible(false);
				lblMensagemSelecioneLivro.setVisible(false);
				int indexLivroSelecionado = ((Table) e.widget).indexOf((TableItem) e.item);
				//caso a busca não devolva resultados, nao fazer nada
				if ( listaLivrosDaBusca.isEmpty() || listaLivrosDaBusca == null ) {
					
				}
				else {
					livroSelecionado = listaLivrosDaBusca.get(indexLivroSelecionado);
					// fazer corresponder o livro selecionado a um dos livros da livraria, para as
					// mudanças
					// de stock, se reproduzirem na livraria
					livroSelecionado = livraria.getLivro(livroSelecionado.isbn);
					// caso não haja nenhum selecionado, não acontece nada
					if (livroSelecionado == null) {
						// tornar visivel mensagem para selecionar um livro
						lblMensagemSelecioneLivro.setVisible(true);
					}
					// Verificar se livro tem stock e eventualmente escrever mensagem de falta de
					// stock
					else if (livroSelecionado.getStock() <= 0) {
						// tornar visivel mensagem de falta de stock
						lblMensagemLivroIndisponivel.setVisible(true);
					}
					// caso em que há stock
					else {
						lblMensagemLivroIndisponivel.setVisible(false);
						// tornar invisivel mensagem para selecionar um livro
						lblMensagemSelecioneLivro.setVisible(false);
					}
				}
				
			}
		});
		table.setBounds(10, 75, 648, 406);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		

		TableColumn tblclmnTtulo = new TableColumn(table, SWT.CENTER );
//		tblclmnTtulo.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				listaLivrosDaBusca = livraria.ordenarLivroTitulo( listaLivrosDaBusca);
//				preencherTabela();
//			}
//		});
		tblclmnTtulo.setWidth(170);
		tblclmnTtulo.setText("T\u00EDtulo");

		TableColumn tblclmnAutor = new TableColumn(table, SWT.CENTER );
		tblclmnAutor.setWidth(97);
		tblclmnAutor.setText("Autor");

		TableColumn tblclmnEditora = new TableColumn(table, SWT.CENTER);
		tblclmnEditora.setWidth(90);
		tblclmnEditora.setText("Editora");

		TableColumn tblclmnIsbn = new TableColumn(table, SWT.CENTER);
		tblclmnIsbn.setWidth(93);
		tblclmnIsbn.setText("ISBN");

		TableColumn tblclmnData = new TableColumn(table, SWT.CENTER);
		tblclmnData.setWidth(93);
		tblclmnData.setText("Data");

		TableColumn tblclmnStock = new TableColumn(table, SWT.CENTER);
		tblclmnStock.setWidth(48);
		tblclmnStock.setText("Stock");

		TableColumn tblclmnPreco = new TableColumn(table, SWT.CENTER);
		tblclmnPreco.setWidth(53);
		tblclmnPreco.setText("Pre\u00E7o");
		
		
		
		
		
		
//		column1.addListener(SWT.Selection, new Listener() {
//		      public void handleEvent(Event e) {
//		        // sort column 1
//		        TableItem[] items = table.getItems();
//		        Collator collator = Collator.getInstance(Locale.getDefault());
//		        for (int i = 1; i < items.length; i++) {
//		          String value1 = items[i].getText(0);
//		          for (int j = 0; j < i; j++) {
//		            String value2 = items[j].getText(0);
//		            if (collator.compare(value1, value2) < 0) {
//		              String[] values = { items[i].getText(0),
//		                  items[i].getText(1) };
//		              items[i].dispose();
//		              TableItem item = new TableItem(table, SWT.NONE, j);
//		              item.setText(values);
//		              items = table.getItems();
//		              break;
//		            }
//		          }
//		        }
//		      }
//		    });
		
		
		
		
		
		Listener sortListener = new Listener() {
		      public void handleEvent(Event e) {
		        TableItem[] items = table.getItems();
		        Collator collator = Collator.getInstance(Locale.getDefault());
		        TableColumn column = (TableColumn) e.widget;
		        int index = column == table.getColumn(0) ? 0 : 1;
		        for (int i = 1; i < items.length; i++) {
		          String value1 = items[i].getText(index);
		          for (int j = 0; j < i; j++) {
		            String value2 = items[j].getText(index);
		            if (collator.compare(value1, value2) < 0) {
		              String[] values = { items[i].getText(0), items[i].getText(1),
		            		  items[i].getText(2), items[i].getText(3),
		            		  items[i].getText(4), items[i].getText(5),
		            		  items[i].getText(6)};
		              items[i].dispose();
		              TableItem item = new TableItem(table, SWT.NONE, j);
		              item.setText(values);
		              items = table.getItems();
		              break;
		            }
		          }
		        }
		        table.setSortColumn(column);
		        
		      }
		    };
		    tblclmnTtulo.addListener(SWT.Selection, sortListener);
		    tblclmnAutor.addListener(SWT.Selection, sortListener);
		    tblclmnIsbn.addListener(SWT.Selection, sortListener);
		    tblclmnEditora.addListener(SWT.Selection, sortListener);
		    tblclmnData.addListener(SWT.Selection, sortListener);
		    tblclmnStock.addListener(SWT.Selection, sortListener);
		    tblclmnPreco.addListener(SWT.Selection, sortListener);
		    table.setSortColumn(tblclmnTtulo);
		    table.setSortDirection(SWT.TOP);
		
		
		
		
		
		
		
		
		
		
		
		
		
		//table.setSortColumn(tblclmnTtulo);
	//	table.setAutoCreateRowSorter(true);
		preencherTabela();
		
		

//		//ACRESCENTAR BUTÃO LIMPAR CARRINHO E COPIAR PARA A JANELA CARRINHO
//		***
//		
//		
//		
//		
//		
//		

		// Listner para o botão de 'voltar'
		Button buttonVoltar = new Button(shlViewComicsInc, SWT.NONE);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				// comando para fechar a janela corrente
				livraria.esvaziarCarrinhoReporStock(carrinho);
				shlViewComicsInc.close();
				// Abrir de novo a janela inicial
				J_00Inicial janelaInicial = new J_00Inicial(livraria);
				janelaInicial.open();
			}
		});
		buttonVoltar.setText("Voltar");
		buttonVoltar.setBounds(732, 477, 80, 26);

		// texto a indicar quantos items tem o carrinho
		Label lblItmes = new Label(shlViewComicsInc, SWT.NONE);
		lblItmes.setText("" + carrinho.numeroItemsDoCarrinho() + " itmes");
		lblItmes.setBounds(664, 145, 124, 20);

		// Listner para botão de 'adicionar ao carrinho'
		Button btnAdicionarAoCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnAdicionarAoCarrinho.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				lblMensagemAdicioneLivro.setVisible(false);	
				// caso não haja nenhum selecionado, não acontece nada
				if (livroSelecionado == null) {
					// tornar visivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(true);
				}
				// se stock <= 0 apenas mostra mensagem de falta de stock
				else if (livroSelecionado.stock <= 0) {
					lblMensagemLivroIndisponivel.setVisible(true);
					// tornar invisivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(false);
				}
				// se stock > 0 adiciona livro a lista de livros para o carrinho e reduz stock
				else {
					livraria.adicionarLivroAoCarrinho(livroSelecionado, carrinho);
					// actualizar o label do número de items no carrinho
					lblItmes.setText(carrinho.numeroItemsDoCarrinho() + " itmes");
					System.out.println("LIVRARIA:" + livraria);
					System.out.println("STock=" + livroSelecionado.stock);
					System.out.println("items no carrinho=" + carrinho.numeroItemsDoCarrinho());
					preencherTabela();
				}

			}
		});
		btnAdicionarAoCarrinho.setText("Adicionar");
		btnAdicionarAoCarrinho.setBounds(664, 179, 71, 30);

		// Butão remover do carrinho. Remove o item que está selecionado (caso ele faça
		// parte do carrinho) ou
		// remove o último livro adicionado, caso o livro selecionado não faça parte do
		// carrinho
		Button btnRemover = new Button(shlViewComicsInc, SWT.CENTER);
		btnRemover.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				lblMensagemSelecioneLivro.setVisible(false);
				// caso não haja nenhum selecionado, não acontece nada
				if (livroSelecionado == null) {
					lblMensagemSelecioneLivro.setVisible(true);
				}
				// remover o item selecionado
				else if (carrinho.livros.contains(livroSelecionado)) {
					livraria.removerLivroDoCarrinho(livroSelecionado, carrinho);
					preencherTabela();
				}
				// se carrinho já está vazio, não fazer nada
				else if (carrinho.livros.isEmpty()) {

				}
				// Mesmo que o livro selecionado, não esteja no carrinho,
				// ao carregar em remover, remove-se o último livro a entrar para o carrinho
				else {
					Livro ultimoDoCarrinho = carrinho.livros.get(carrinho.livros.size() - 1);
					livraria.removerLivroDoCarrinho(ultimoDoCarrinho, carrinho);
					preencherTabela();
				}
				// actualizar o label do número de items no carrinho
				lblItmes.setText(carrinho.numeroItemsDoCarrinho() + " itmes");
				System.out.println("LIVRARIA:" + livraria);
				System.out.println("items no carrinho=" + carrinho.numeroItemsDoCarrinho());
			}
		});
		btnRemover.setText("Remover");
		btnRemover.setBounds(741, 179, 71, 30);

		Label lblCarrinho = new Label(shlViewComicsInc, SWT.NONE);
		lblCarrinho.setBounds(664, 115, 124, 20);
		lblCarrinho.setText("Carrinho");

		// mensagem de erro que aparece quando não há livros para a procura
		Label lblMensagemSemCorrespondencias = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemSemCorrespondencias.setVisible(false);
		lblMensagemSemCorrespondencias.setText("N\u00E3o existem correspond\u00EAncias. Tente novamente");
		lblMensagemSemCorrespondencias.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemSemCorrespondencias.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemSemCorrespondencias.setBounds(81, 59, 236, 12);

		caixaDeBusca = new Text(shlViewComicsInc, SWT.BORDER);
		caixaDeBusca.setBounds(81, 23, 196, 30);

		Button btnPesquisar = new Button(shlViewComicsInc, SWT.NONE);
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				lblMensagemSelecioneLivro.setVisible(false);
				lblMensagemAdicioneLivro.setVisible(false);	
				// Passar para string o texto introduzido na caixa de texto
				stringProcurada = caixaDeBusca.getText();
				// Chamar método 'procurarLivro' para a string introduzida
				listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
				// Caso lista de livros não tenha resultados apresentar mensagem de procura
				// vazia
				if (listaLivrosDaBusca.isEmpty()) {
					lblMensagemSemCorrespondencias.setVisible(true);
					//anular o livro selecionado, para que não fique válido para outros botões
					livroSelecionado = null;
					preencherTabela();
				}
				// caso lista tenha livros
				else {
					lblMensagemSemCorrespondencias.setVisible(false);
					preencherTabela();
				}
			}
		});
		btnPesquisar.setBounds(310, 23, 90, 30);
		btnPesquisar.setText("Pesquisar");

		// Butão ver/finalizar carrinho
		Button btnVerCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnVerCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			// listner para ao clicar com rato abrir janela de carrinho
			public void mouseUp(MouseEvent e) {
				lblMensagemSelecioneLivro.setVisible(false);
				lblMensagemAdicioneLivro.setVisible(false);	
				// caso carrinho esteja vazio, apresentar mensagem para adicionar livros ao carrinho
				if ( carrinho.livros.isEmpty() ) {
					// tornar visivel mensagem para adicionar um livro
					lblMensagemAdicioneLivro.setVisible(true);
					//anular o livro selecionado, para que não fique válido para outros botões
					livroSelecionado = null;
				}
				else {
					// comando para fechar a janela corrente
					shlViewComicsInc.close();
					// Abrir nova janela do carrinho
					J_02Carrinho janelaCarrinho = new J_02Carrinho(livraria, carrinho);
					janelaCarrinho.open();
				}
			}
		});
		btnVerCarrinho.setText("Ver Carrinho");
		btnVerCarrinho.setBounds(664, 225, 148, 30);
		
		Button btnVerDetalhesLivro = new Button(shlViewComicsInc, SWT.CENTER);
		btnVerDetalhesLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				lblMensagemAdicioneLivro.setVisible(false);	
				lblMensagemSelecioneLivro.setVisible(false);
				// caso não haja nenhum selecionado
				if (livroSelecionado == null) {
					// tornar visivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(true);
				}
				else {
					J_03DetalhesLivro janelaDetalhes = new J_03DetalhesLivro(livraria, livroSelecionado);
					janelaDetalhes.open();
				}
				
			}
		});
		btnVerDetalhesLivro.setText("Ver Detalhes do livro");
		btnVerDetalhesLivro.setBounds(664, 363, 148, 30);

		// Listner que deixa definir a altura de cada linha da table
		// é preciso importar o org.eclipse.swt.widgets.Event;
		table.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				// definir altura aqui
				event.height = 90;
			}
		});
		
		

	}

//	// Método para limpar e preencher novamente a tabela
//	public void preencherTabela() {
//		// limpar tabela
//		table.removeAll();
//		// Chamar novamente o método 'procurarLivro' para actualizar os stocks dos
//		// livros da 'listaLivrosDaBusca'
//		listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
//		// adicionar um a um os livros da lista de livros da busca à table
//		for (Livro lv : listaLivrosDaBusca) {
//			TableItem item = new TableItem(table, SWT.NONE);
//			item.setText(lv.toString());
//		}
//		table.redraw();
//	}

	// Método para limpar e preencher novamente a tabela
	public void preencherTabela() {
		// limpar tabela
		table.removeAll();
		// Chamar novamente o método 'procurarLivro' para actualizar os stocks dos
		// livros da 'listaLivrosDaBusca'
		listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
		// Preencher tabela
		for (Livro lv : listaLivrosDaBusca) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, lv.nome);
			item.setText(1, lv.autor);
			item.setText(2, lv.editora);
			item.setText(3, lv.isbn);
			item.setText(4, "" + lv.data.get(Calendar.YEAR) + "/" + ((lv.data.get(Calendar.MONTH)) + 1) + "/"
					+ lv.data.get(Calendar.DAY_OF_MONTH));
			item.setText(5, "" + lv.stock);
			item.setText(6, "" + lv.preco + "€");
		}
		table.redraw();
	}

	

}
