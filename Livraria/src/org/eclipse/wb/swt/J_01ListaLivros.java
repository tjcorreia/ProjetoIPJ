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
	private ArrayList <Livro> listaLivrosDaBusca;//adicionou-se este atributo para listar os livros na table
	protected ArrayList <Livro> listaLivrosCarrinho = new ArrayList<>();//adicionou-se este atributo para criar carrinho a partir desta lista
	protected Livro livroSelecionado;//atributo que nos dá o livro que está selecionado na table
	private Table table;
	private int indexLivroSelecionado;//adicionou-se este atributo para poder passá-lo entre métodos
	private Carrinho carrinho = new Carrinho();
	private Text text;;//adicionou-se carrinho para cria-lo e passar para outras classes
	
	
	//Criou-se construtor para poder receber a lista de livros procurados de outra classe
	public J_01ListaLivros(ArrayList<Livro> listaLivrosDaBusca) {
		super();
		this.listaLivrosDaBusca = listaLivrosDaBusca;
	}


	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Foi necessário adicionar aqui a arrayList de livros
			J_01ListaLivros window = new J_01ListaLivros(new ArrayList<Livro>());
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
		
		
		table = new Table(shlViewComicsInc, SWT.BORDER | SWT.FULL_SELECTION);
		
		//Label que dá mensagem de erro caso o livro não esteja dizponível
		Label lblMensagemDeErro = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemDeErro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErro.setBounds(511, 76, 153, 20);
		lblMensagemDeErro.setText("Livro Indispon\u00EDvel");
		lblMensagemDeErro.setVisible(false);		
		
		//listner para ação ao selecionar um dos items da table e devolve o index do item na lista de livros
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(e.toString());
				indexLivroSelecionado = ((Table)e.widget).indexOf((TableItem)e.item);
				System.out.println( indexLivroSelecionado );
				livroSelecionado = listaLivrosDaBusca.get(indexLivroSelecionado);
				//Verificar se livro tem stock e eventualmente escrever mensagem de falta de stock
				if (livroSelecionado.stock <= 0) {
					//tornar visivel mensagem de falta de stock
					lblMensagemDeErro.setVisible(true);
				}
				//caso em que há stock
				else {
					lblMensagemDeErro.setVisible(false);
				}
			}
		});
		table.setBounds(10, 75, 481, 428);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//adicionar um a um os livros da lista de livros da busca à table
		for (Livro lv : listaLivrosDaBusca) {
		      TableItem item = new TableItem(table, SWT.NONE);
		      item.setText(lv.toString());
		}
		
		//Listner para o botão de 'voltar'
		Button buttonVoltar = new Button(shlViewComicsInc, SWT.NONE);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela
				shlViewComicsInc.close();
			}
		});
		buttonVoltar.setText("Voltar");
		buttonVoltar.setBounds(632, 477, 80, 26);
		
		
		//Listner para botão de 'adicionar ao carrinho'
		Button btnAdicionarAoCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnAdicionarAoCarrinho.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAdicionarAoCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//se stock <= 0 não faz nada
				if (livroSelecionado.stock <= 0) {	
				}
				//se stock > 0 adiciona livro a lista de livros para o carrinho e reduz stock
				else {
					listaLivrosCarrinho.add(livroSelecionado);
					livroSelecionado.stock--;
					System.out.println("STock=" + livroSelecionado.stock);
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
				//remover o item selecionado
				if ( listaLivrosCarrinho.contains(livroSelecionado)) {
					listaLivrosCarrinho.remove(livroSelecionado);
					//repor stock
					livroSelecionado.stock++;
				}
				//remover o último da lista
				else {
					Livro ultimoDaLista = listaLivrosCarrinho.get(listaLivrosCarrinho.size());
					listaLivrosCarrinho.remove(ultimoDaLista);
					//repor stock
					ultimoDaLista.stock++;
				}
			}
		});
		btnRemover.setText("Remover");
		btnRemover.setBounds(610, 179, 90, 30);
		
		//texto a indicar quantos items tem o carrinho
		Label lblItmes = new Label(shlViewComicsInc, SWT.NONE);
		lblItmes.setText( listaLivrosCarrinho.size() + " itmes");
		lblItmes.setBounds(511, 144, 70, 20);
		
		Label lblCarrinho = new Label(shlViewComicsInc, SWT.NONE);
		lblCarrinho.setBounds(511, 114, 70, 20);
		lblCarrinho.setText("Carrinho");
		
		
		text = new Text(shlViewComicsInc, SWT.BORDER);
		text.setBounds(81, 23, 196, 30);
		
		Button btnPesquisar = new Button(shlViewComicsInc, SWT.NONE);
		btnPesquisar.setBounds(310, 23, 90, 30);
		btnPesquisar.setText("Pesquisar");
		
		
		
		Button btnVerfinalizarCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnVerfinalizarCarrinho.setText("Ver/Finalizar Carrinho");
		btnVerfinalizarCarrinho.setBounds(514, 225, 186, 30);
		
		
		
		// Listner que deixa definir a altura de cada linha da table
		// é preciso importar o org.eclipse.swt.widgets.Event;
		table.addListener(SWT.MeasureItem, new Listener() {
		   public void handleEvent(Event event) {
		      // definir altura aqui
		      event.height = 90;
		   }
		});

	}
}
