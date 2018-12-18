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




public class J_01ListaLivros {

	protected Shell shlViewComicsInc;
	//adicionou-se o atributo listaLivros
	private ArrayList<Livro> listaLivros;
	private Table table;
	
	//Criou-se construtor para poder receber a lista de livros procurados de outra classe
	public J_01ListaLivros(ArrayList<Livro> listaLivros) {
		super();
		this.listaLivros = listaLivros;
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
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlViewComicsInc = new Shell();
		shlViewComicsInc.setSize(663, 498);
		shlViewComicsInc.setText("View Comics Inc.");
		
		
		table = new Table(shlViewComicsInc, SWT.BORDER | SWT.FULL_SELECTION);
		
		//listner para ação ao selecionar um dos items da table
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(e.toString());
				System.out.println( ((Table)e.widget).indexOf((TableItem)e.item)  );
			}
		});
		table.setBounds(10, 10, 456, 428);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//Listner para o botão de 'voltar'
		Button button = new Button(shlViewComicsInc, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			}
		});
		button.setText("Voltar");
		button.setBounds(555, 412, 80, 26);
		
		Button btnAdicionarAoCarrinho = new Button(shlViewComicsInc, SWT.CENTER);
		btnAdicionarAoCarrinho.setText("Adicionar ao Carrinho");
		btnAdicionarAoCarrinho.setBounds(472, 28, 163, 49);
		
		Label lblCarrinho = new Label(shlViewComicsInc, SWT.NONE);
		lblCarrinho.setBounds(482, 83, 70, 20);
		lblCarrinho.setText("Carrinho");
		
		
		
		//Caso lista de livros não tenha resultados listar mensagem de procura vazia
		if ( listaLivros.isEmpty() ) {
			TableItem item = new TableItem(table, SWT.NONE);
		      item.setText("Não foram encontradas correspondências com a sua procura");
		}
		//caso lista tenha livros
		else {
			//adicionar aqui um a um os livros da lista de livros procurados à table
			for (Livro lv : listaLivros) {
			      TableItem item = new TableItem(table, SWT.NONE);
			      item.setText(lv.toString());
			}
		}
		
		
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
