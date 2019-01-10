package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

import java.awt.Point;
import java.util.ArrayList;

import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;


public class J_01ListaLivros {

	protected Shell shlViewComicsInc;
	
	//protected static ArrayList <Livro> listaLivrosCarrinho = new ArrayList<>();//adicionou-se este atributo para criar carrinho a partir desta lista
	protected Livro livroSelecionado;//atributo que nos dá o livro que está selecionado na table
	protected Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	protected Carrinho carrinho;
	protected String stringProcurada;
	protected static ArrayList <Livro> listaLivrosDaBusca;
	//protected int indexLivroSelecionado;//adicionou-se este atributo para poder passá-lo entre métodos
	private Table table;
	private Text caixaDeBusca;//adicionou-se carrinho para cria-lo e passar para outras classes
	
	
	//Criou-se construtor para poder receber o carrinho da janela seguinte 'J_02Carrinho'
	public J_01ListaLivros(Livraria livraria, Carrinho carrinho1) {
		this.livraria = livraria;
		carrinho = carrinho1;
		stringProcurada = "";
		open();
	}
	
	//Construtor para quando se vem da janela anterior 'J_00Inicial'
	public J_01ListaLivros(Livraria livraria, ArrayList <Livro> listaLivrosDaBusca, String stringProcurada) {
		this.livraria = livraria;
		System.out.println("criar carrinho");
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
		shlViewComicsInc.setSize(740, 560);
		shlViewComicsInc.setText("View Comics Inc.");
		
		//Label que dá mensagem de erro caso o livro não esteja dizponível
		Label lblMensagemLivroIndisponivel = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemLivroIndisponivel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemLivroIndisponivel.setBounds(511, 76, 153, 20);
		lblMensagemLivroIndisponivel.setText("Livro Indispon\u00EDvel");
		lblMensagemLivroIndisponivel.setVisible(false);	
		
		//Label que dá mensagem de erro caso o livro não esteja dizponível
		Label lblMensagemSelecioneLivro = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemSelecioneLivro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemSelecioneLivro.setBounds(511, 76, 153, 20);
		lblMensagemSelecioneLivro.setText("Selecione um livro");
		lblMensagemSelecioneLivro.setVisible(false);			
		
		
		table = new Table(shlViewComicsInc, SWT.BORDER | SWT.FULL_SELECTION);
		//listner para ação ao selecionar um dos items da table e devolve o index do item na lista de livros
		table.addSelectionListener(new SelectionAdapter() {
			@Override
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
					lblMensagemLivroIndisponivel.setVisible(false);
					//tornar visivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(true);
				}
				//Verificar se livro tem stock e eventualmente escrever mensagem de falta de stock
				else if (livroSelecionado.getStock() <= 0) {
					//tornar visivel mensagem de falta de stock
					lblMensagemLivroIndisponivel.setVisible(true);
					//tornar invisivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(false);
				}
				//caso em que há stock
				else {
					lblMensagemLivroIndisponivel.setVisible(false);
					//tornar invisivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(false);
				}
			}
		});
		table.setBounds(10, 75, 495, 367);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		preencherTabela();
		
		
//		//ACRESCENTAR BUTÃO LIMPAR CARRINHO E COPIAR PARA A JANELA CARRINHO
//		***
//		
//		
//		
//		
//		
//		
		
		
		//Listner para o botão de 'voltar'
		Button buttonVoltar = new Button(shlViewComicsInc, SWT.NONE);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela corrente
				shlViewComicsInc.close();
				//Abrir de novo a janela inicial
				J_00Inicial janelaInicial = new J_00Inicial(livraria);
				janelaInicial.open();
			}
		});
		buttonVoltar.setText("Voltar");
		buttonVoltar.setBounds(632, 477, 80, 26);
		
		
		//texto a indicar quantos items tem o carrinho
		Label lblItmes = new Label(shlViewComicsInc, SWT.NONE);
		lblItmes.setText( "" + carrinho.numeroItemsDoCarrinho() + " itmes");
		lblItmes.setBounds(511, 144, 70, 20);		
		
		//Listner para botão de 'adicionar ao carrinho'
		Button btnAdicionarAoCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
//		btnAdicionarAoCarrinho.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//			}
//		});
		btnAdicionarAoCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//caso não haja nenhum selecionado, não acontece nada
				if (livroSelecionado==null) {
					//tornar visivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(true);
				}
				//se stock <= 0 apenas mostra mensagem de falta de stock
				else if (livroSelecionado.stock <= 0) {	
					lblMensagemLivroIndisponivel.setVisible(true);
					//tornar invisivel mensagem para selecionar um livro
					lblMensagemSelecioneLivro.setVisible(false);
				}
				//se stock > 0 adiciona livro a lista de livros para o carrinho e reduz stock
				else {
					livraria.adicionarLivroAoCarrinho(livroSelecionado, carrinho);
//					VER SE BASTA O QUE ESTÁ EM CIMA OU SE É PRECISO SER:
//					carrinho = livraria.adicionarLivroAoCarrinho(livroSelecionado, carrinho);
//					
//					
//					
//					
//					
//					
					//livroSelecionado.stock--;
					//actualizar o label do número de items no carrinho
					lblItmes.setText( carrinho.numeroItemsDoCarrinho() + " itmes");
					System.out.println("LIVRARIA:" + livraria);
					System.out.println("STock=" + livroSelecionado.stock);
					System.out.println("items no carrinho=" + carrinho.numeroItemsDoCarrinho() );
					preencherTabela();
				}
				
			}
		});
		btnAdicionarAoCarrinho.setText("Adicionar");
		btnAdicionarAoCarrinho.setBounds(514, 179, 90, 30);
		
		//Butão remover do carrinho. Remove o item que está selecionado (caso ele faça parte do carrinho) ou 
		//remove o último livro adicionado, caso o livro selecionado não faça parte do carrinho
		Button btnRemover = new Button(shlViewComicsInc, SWT.CENTER);
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//caso não haja nenhum selecionado, não acontece nada
				if (livroSelecionado==null) {
				}
				//remover o item selecionado
				else if ( carrinho.livros.contains(livroSelecionado)) {
					livraria.removerLivroDoCarrinho(livroSelecionado, carrinho);
//					VER SE BASTA O QUE ESTÁ EM CIMA OU SE É PRECISO SER:
//					carrinho = livraria.removerLivroDoCarrinho(livroSelecionado, carrinho);
//					
//					
//					
//					
//					
//
					preencherTabela();
					//repor stock
					//livroSelecionado.stock++; //passei isto para o método 'removerLivroDoCarrinho'
				}
				//se carrinho já está vazio, não fazer nada
				else if ( carrinho.livros.isEmpty() ){
				
				}
				//Mesmo que o livro selecionado, não esteja no carrinho, 
				// ao carregar em remover, remove-se o último livro a entrar para o carrinho
				else {
					Livro ultimoDoCarrinho = carrinho.livros.get( carrinho.livros.size()-1 );
					livraria.removerLivroDoCarrinho( ultimoDoCarrinho, carrinho );
				
//					VER SE BASTA O QUE ESTÁ EM CIMA OU SE É PRECISO SER:
//					carrinho = livraria.removerLivroDoCarrinho( ultimoDoCarrinho, carrinho );
//					
//					
//					
//					
//					
//
					
					preencherTabela();
					//repor stock
					//ultimoDaLista.stock++;
				}
				//actualizar o label do número de items no carrinho
				lblItmes.setText( carrinho.numeroItemsDoCarrinho() + " itmes" );
				System.out.println("LIVRARIA:" + livraria);
				System.out.println("items no carrinho=" + carrinho.numeroItemsDoCarrinho() );
			}
		});
		btnRemover.setText("Remover");
		btnRemover.setBounds(610, 179, 90, 30);
		
		
		
		Label lblCarrinho = new Label(shlViewComicsInc, SWT.NONE);
		lblCarrinho.setBounds(511, 114, 70, 20);
		lblCarrinho.setText("Carrinho");
		
		//mensagem de erro que aparece quando não há livros para a procura
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
				//Passar para string o texto introduzido na caixa de texto
				stringProcurada = caixaDeBusca.getText();
				//Chamar método 'procurarLivro' para a string introduzida
				listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
				//Caso lista de livros não tenha resultados apresentar mensagem de procura vazia
				if ( listaLivrosDaBusca.isEmpty() ) {
					lblMensagemSemCorrespondencias.setVisible(true);  
				}
				//caso lista tenha livros
				else {
					lblMensagemSemCorrespondencias.setVisible(false);  
					//limpar todos os resultados anteriores da tabela impressa
					
					preencherTabela();
					//adicionar um a um os livros da lista de livros da busca à table
//					int i = 0;
//					for (Livro lv : listaLivrosDaBusca) {
//					      TableItem item = new TableItem(table, SWT.NONE, i);
//					      i++;
//					      item.setText(lv.toString());
//					}
				}
			}
		});
		btnPesquisar.setBounds(310, 23, 90, 30);
		btnPesquisar.setText("Pesquisar");
		
		
		//Butão ver/finalizar carrinho
		Button btnVerCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnVerCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			//listner para ao clicar com rato abrir janela de carrinho
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela corrente
				shlViewComicsInc.close();
				//Abrir nova janela do carrinho
				J_02Carrinho janelaCarrinho = new J_02Carrinho(livraria, carrinho);
				janelaCarrinho.open();
				
			}
		});
		btnVerCarrinho.setText("Ver Carrinho");
		btnVerCarrinho.setBounds(514, 225, 186, 30);
		

		// Listner que deixa definir a altura de cada linha da table
		// é preciso importar o org.eclipse.swt.widgets.Event;
		table.addListener(SWT.MeasureItem, new Listener() {
		   public void handleEvent(Event event) {
		      // definir altura aqui
		      event.height = 90;
		   }
		});

	}
	
	//Método para limpar e preencher novamente a tabela 
	public void preencherTabela() {
		//limpar tabela
		table.removeAll();
		//Chamar novamente o método 'procurarLivro' para actualizar os stocks dos livros da 'listaLivrosDaBusca'
		listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
		//adicionar um a um os livros da lista de livros da busca à table
		for (Livro lv : listaLivrosDaBusca) {
		      TableItem item = new TableItem(table, SWT.NONE);
		      item.setText(lv.toString());
		}
		table.redraw();	
	}
	
	
}
