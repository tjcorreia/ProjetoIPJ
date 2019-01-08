package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import swing2swt.layout.FlowLayout;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_02Carrinho extends J_01ListaLivros{ //criou-se janela como subclasse para poder receber variáveis da superclasse
	protected Shell shell;
	private Table tabela;

	
	
	//criou-se construtor que vai buscar variáveis à supercalsse
	public J_02Carrinho( ) {
		super(listaLivrosCarrinho);
		/**+++++++++++++++++++++++
		 * Só para efeito de testes, define-se agora um carrinho
		 * !!!!!!!!!!!!!!!!!!!!!!!
		 * APAGAR MAIS TARDE O RESTO DESTE CONSTRUTOR
		 * 1
		 * 1
		 * 1
		 * 
		 */
		//criar 3 pequenos historicos de preços
		Map <GregorianCalendar, Double > precos1 = new HashMap<>();
		precos1.put(new GregorianCalendar(2017,2,5), 15.0);
		precos1.put(new GregorianCalendar(2016,6,14), 13.0);
		precos1.put(new GregorianCalendar(2016,11,14), 14.0);
		Map <GregorianCalendar, Double > precos2 = new HashMap<>();
		precos2.put(new GregorianCalendar(2017,2,5), 15.0);
		precos2.put(new GregorianCalendar(2016,6,14), 13.0);
		precos2.put(new GregorianCalendar(2016,11,14), 14.0);
		//criar 3 livros
		Livro lv1 = new Livro ("O último voo do Flamingo", "1548967532745", "Mia Couto", "Plátano", 
				"Romance. Um estranho encontro", new GregorianCalendar (2018,11,12) , 15.5, 20, precos1);
		Livro lv2 = new Livro ("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya", 
				"Ficção Científica. Viagens espaciais de um inadaptado", 
				new GregorianCalendar (2017,11,18) , 16.5, 3, precos2);
		//Criar alguns mapas de livros-quantidade para os carrinhos de compras 
		ArrayList <Livro> livros1 = new ArrayList <>();
		livros1.add(lv1);
		livros1.add(lv1);
		livros1.add(lv1);
		livros1.add(lv2);
		//criar um carrinho
		carrinho = new Carrinho(livros1);
	}



	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_02Carrinho window = new J_02Carrinho( );
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		//System.out.println(carrinho);
		
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
		shell.setSize(724, 561);
		shell.setText("ViewComics-Carrinho");
		shell.setLayout(null);
		
		Label lblCarrinho = new Label(shell, SWT.NONE);
		lblCarrinho.setBounds(141, 5, 229, 20);
		lblCarrinho.setText("CARRINHO");
		
		Label lblSemStock = new Label(shell, SWT.NONE);
		lblSemStock.setVisible(false);
		lblSemStock.setText("Sem Stock");
		lblSemStock.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSemStock.setBounds(548, 31, 153, 20);
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tabela = tableViewer.getTable();
		//Listner que devolve o indice e o livro do livro selecionado na tabela como 'indexLivroSelecionado' e 'livroSelecionado'
		tabela.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblSemStock.setVisible(false);
				System.out.println(e.toString());
				indexLivroSelecionado = ((Table)e.widget).indexOf((TableItem)e.item);
				System.out.println( indexLivroSelecionado );
				livroSelecionado = carrinho.livros.get(indexLivroSelecionado);
			}
		});
		tabela.setBounds(5, 31, 535, 421);
		tabela.setHeaderVisible(true);
		//
			
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLivros = tableViewerColumn.getColumn();
		tblclmnLivros.setWidth(379);
		tblclmnLivros.setText("Livros");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnQuantidades = tableViewerColumn_1.getColumn();
		tblclmnQuantidades.setWidth(151);
		tblclmnQuantidades.setText("Quantidade");
		//Chamar método para preencher tabela
		preencherTabela();
				
		

		//Botão para voltar à janela anterior de procura de livros
		Button botaoVoltar = new Button(shell, SWT.NONE);
		botaoVoltar.setBounds(574, 474, 127, 30);
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//fechar janela corrente
				shell.close();
				//abrir janela de busca de livros, com o carrinho atual
				J_01ListaLivros janelaDeProcura = new J_01ListaLivros(carrinho.livros);
				janelaDeProcura.open();
			}
		});
		botaoVoltar.setText("Voltar/Pesquisar");
		

		Button botaoFinalizarCarrinho = new Button(shell, SWT.NONE);
		botaoFinalizarCarrinho.setBounds(574, 422, 127, 30);
		botaoFinalizarCarrinho.setText("Finalizar Carrinho");
		
		
		Label lblTotal = new Label(shell, SWT.CENTER);
		lblTotal.setBounds(394, 466, 133, 20);
		lblTotal.setText("TOTAL: " + carrinho.totalCarrinho() + "€");
		
		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(558, 65, 84, 20);
		lblQuantidade.setText("Quantidade");
		
		
		
		Button butaoAumentarQuantidade = new Button(shell, SWT.NONE);
		butaoAumentarQuantidade.setBounds(645, 54, 22, 22);
		butaoAumentarQuantidade.setText("+");
		butaoAumentarQuantidade.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//Se nenhum item da tabela estiver selecionado, não fazer nada
				if (livroSelecionado==null) {
				}
				//Verificar se livro tem stock e eventualmente escrever mensagem de falta de stock
				else if (livroSelecionado.stock <= 0) {
					//tornar visivel mensagem de falta de stock
					lblSemStock.setVisible(true);
				}
				//caso em que há stock, actualiza-se carrinho e actualiza-se a tabela
				else {
					carrinho.adicionarLivroAoCarrinho(livroSelecionado);
					System.out.println(carrinho);
					//limpar tabela
					tabela.removeAll();
					preencherTabela();
					lblSemStock.setVisible(false);
					lblTotal.setText("TOTAL: " + carrinho.totalCarrinho() + "€");
					//lblTotal.redraw();
				}
			}
		});
		
		
		Button butaoDiminuirQuantidade = new Button(shell, SWT.NONE);
		butaoDiminuirQuantidade.setText("-");
		butaoDiminuirQuantidade.setBounds(645, 82, 22, 22);
		butaoDiminuirQuantidade.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				lblSemStock.setVisible(false);
				//Se nenhum item da tabela estiver selecionado (ou se carrinho já foi esvaziado), não fazer nada
				if (livroSelecionado==null || !carrinho.livros.contains(livroSelecionado)) {
				}
				//reduzir quantidade de livros
				else {
					carrinho.removerLivroDoCarrinho(livroSelecionado);
					System.out.println(carrinho);
					//limpar tabela
					tabela.removeAll();
					preencherTabela();
					lblTotal.setText("TOTAL: " + carrinho.totalCarrinho() + "€");
					//lblTotal.redraw();
				}
			}
		});
	}
	
	public void preencherTabela() {
		//adicionar um a um os livros e quantidades do Carrinho à tabela2
		for (Livro lv : carrinho.livros ) {
		      TableItem item = new TableItem(tabela, SWT.NONE);
		      int indice = carrinho.livros.indexOf(lv);
		      //primeira coluna com o título do livro e segunda coluna com a quantidade
		      item.setText( new String[] { lv.nome , "" + carrinho.quantidades.get(indice) } );
		}
	}
	
}
