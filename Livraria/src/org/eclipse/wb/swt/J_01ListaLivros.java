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


public class J_01ListaLivros extends J_00Inicial {

	protected Shell shlViewComicsInc;
	protected ArrayList <Livro> listaLivrosDaBusca;//adicionou-se este atributo para listar os livros na table
	protected static ArrayList <Livro> listaLivrosCarrinho = new ArrayList<>();//adicionou-se este atributo para criar carrinho a partir desta lista
	protected Livro livroSelecionado;//atributo que nos d� o livro que est� selecionado na table
	protected static Carrinho carrinho = new Carrinho();
	private Table table;
	private int indexLivroSelecionado;//adicionou-se este atributo para poder pass�-lo entre m�todos
	private Text text;;//adicionou-se carrinho para cria-lo e passar para outras classes
	
	
	//Criou-se construtor para poder receber a lista de livros procurados da janela anterior
	public J_01ListaLivros(ArrayList <Livro> listaLivrosDaBusca) {
		super(livraria);
		this.listaLivrosDaBusca = listaLivrosDaBusca;
	}

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Foi necess�rio adicionar aqui a arrayList de livros
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
		
		//Label que d� mensagem de erro caso o livro n�o esteja dizpon�vel
		Label lblMensagemDeErro = new Label(shlViewComicsInc, SWT.NONE);
		lblMensagemDeErro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemDeErro.setBounds(511, 76, 153, 20);
		lblMensagemDeErro.setText("Livro Indispon\u00EDvel");
		lblMensagemDeErro.setVisible(false);		
		
		
		table = new Table(shlViewComicsInc, SWT.BORDER | SWT.FULL_SELECTION);
		
		//listner para a��o ao selecionar um dos items da table e devolve o index do item na lista de livros
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
				//caso em que h� stock
				else {
					lblMensagemDeErro.setVisible(false);
				}
			}
		});
		table.setBounds(10, 75, 481, 428);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		//adicionar um a um os livros da lista de livros da busca � table
		for (Livro lv : listaLivrosDaBusca) {
		      TableItem item = new TableItem(table, SWT.NONE);
		      item.setText(lv.toString());
		}
		table.redraw();
		
		//Listner para o bot�o de 'voltar'
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
		
		
		//texto a indicar quantos items tem o carrinho
		Label lblItmes = new Label(shlViewComicsInc, SWT.NONE);
		lblItmes.setText( listaLivrosCarrinho.size() + " itmes");
		lblItmes.setBounds(511, 144, 70, 20);		
		
		//Listner para bot�o de 'adicionar ao carrinho'
		Button btnAdicionarAoCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnAdicionarAoCarrinho.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAdicionarAoCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//se stock <= 0 n�o faz nada
				if (livroSelecionado.stock <= 0) {	
					//colocar label a dizer livro sem stock
				}
				//se stock > 0 adiciona livro a lista de livros para o carrinho e reduz stock
				else {
					listaLivrosCarrinho.add(livroSelecionado);
					livroSelecionado.stock--;
					//actualizar o label do n�mero de items no carrinho
					lblItmes.setText( listaLivrosCarrinho.size() + " itmes");
					System.out.println("STock=" + livroSelecionado.stock);
					System.out.println("items no carrinho=" + listaLivrosCarrinho.size() );
				}
				
			}
		});
		btnAdicionarAoCarrinho.setText("Adicionar");
		btnAdicionarAoCarrinho.setBounds(514, 179, 90, 30);
		
		//But�o remover do carrinho. Remove o item que est� selecionado (caso ele fa�a parte do carrinho) ou 
		//remove o �ltimo livro adicionado, caso o livro selecionado n�o fa�a parte do carrinho
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
				//se carrinho j� est� vazio, n�o fazer nada
				else if ( listaLivrosCarrinho.isEmpty() ){
					
				}
				//remover o �ltimo da lista
				else {
					Livro ultimoDaLista = listaLivrosCarrinho.get(listaLivrosCarrinho.size());
					listaLivrosCarrinho.remove(listaLivrosCarrinho.size());
					//repor stock
					ultimoDaLista.stock++;
				}
				//actualizar o label do n�mero de items no carrinho
				lblItmes.setText( listaLivrosCarrinho.size() + " itmes");
				System.out.println("items no carrinho=" + listaLivrosCarrinho.size() );
			}
		});
		btnRemover.setText("Remover");
		btnRemover.setBounds(610, 179, 90, 30);
		
		
		
		Label lblCarrinho = new Label(shlViewComicsInc, SWT.NONE);
		lblCarrinho.setBounds(511, 114, 70, 20);
		lblCarrinho.setText("Carrinho");
		
		//mensagem de erro que aparece quando n�o h� livros para a procura
		Label label = new Label(shlViewComicsInc, SWT.NONE);
		label.setVisible(false);
		label.setText("N\u00E3o existem correspond\u00EAncias. Tente novamente");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		label.setBounds(81, 59, 236, 12);		
		
		text = new Text(shlViewComicsInc, SWT.BORDER);
		text.setBounds(81, 23, 196, 30);
		
		Button btnPesquisar = new Button(shlViewComicsInc, SWT.NONE);
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Passar para string o texto introduzido na caixa de texto
				String s = text.getText();
				//Chamar m�todo 'procurarLivro' para a string introduzida
				ArrayList <Livro> lvProcurados = livraria.procurarLivro(s);
				//Caso lista de livros n�o tenha resultados apresentar mensagem de procura vazia
				if ( lvProcurados.isEmpty() ) {
					label.setVisible(true);  
				}
				//caso lista tenha livros
				else {
					label.setVisible(false);  
					//passar a nova procura para a 'listaLivrosDaBusca'
					listaLivrosDaBusca = lvProcurados;
					//limpar todos os resultados anteriores da tabela impressa
					table.clearAll();
					//adicionar um a um os livros da lista de livros da busca � table
					int i = 0;
					for (Livro lv : listaLivrosDaBusca) {
					      TableItem item = new TableItem(table, SWT.NONE, i);
					      i++;
					      item.setText(lv.toString());
					}
				}
			}
		});
		btnPesquisar.setBounds(310, 23, 90, 30);
		btnPesquisar.setText("Pesquisar");
		
		
		//But�o ver/finalizar carrinho
		Button btnVerfinalizarCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnVerfinalizarCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			//listner para ao clicar com rato abrir janela de carrinho
			public void mouseUp(MouseEvent e) {
				//chamar m�todo para transformar lista de livros em carrinho
				carrinho = livraria.listaToCarrinho(listaLivrosCarrinho);
				J_02Carrinho janelaCarrinho = new J_02Carrinho();
				janelaCarrinho.open();
			}
		});
		btnVerfinalizarCarrinho.setText("Ver/Finalizar Carrinho");
		btnVerfinalizarCarrinho.setBounds(514, 225, 186, 30);
		

		// Listner que deixa definir a altura de cada linha da table
		// � preciso importar o org.eclipse.swt.widgets.Event;
		table.addListener(SWT.MeasureItem, new Listener() {
		   public void handleEvent(Event event) {
		      // definir altura aqui
		      event.height = 90;
		   }
		});

	}
}
