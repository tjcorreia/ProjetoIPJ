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
	private Table tabela1;
	private Table tabela2;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	
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
		Map <Livro, Integer> livros1 = new HashMap <>();
		livros1.put(lv1, 3);
		livros1.put(lv2, 1);
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
		System.out.println(carrinho);
		
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
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(3, false));
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("New Label");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		

		
		tabela1 = new Table( sashForm, SWT.BORDER | SWT.FULL_SELECTION);
		tabela1.setHeaderVisible(true);
		tabela1.setLinesVisible(true);
		
		TableColumn colunaLivros = new TableColumn(tabela1, SWT.NONE);
		colunaLivros.setWidth(379);
		colunaLivros.setText("Livros");
		
		TableColumn colunaQuantidades = new TableColumn(tabela1, SWT.NONE);
		colunaQuantidades.setWidth(100);
		colunaQuantidades.setText("Quantidade");
		sashForm.setWeights(new int[] {1});
		
		//adicionar um a um os livros do Carrinho de livros à table
		for (Livro lv : carrinho.livrosQuant.keySet()) {
		      TableItem item = new TableItem(tabela1, SWT.NONE);
		      //primeira coluna com o título do livro e segunda coluna com a quantidade
		      item.setText( new String[] { lv.nome , "" + carrinho.livrosQuant.get(lv) } );
		}		
		new Label(shell, SWT.NONE);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton_1.setText("New Button");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton.setText("New Button");
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tabela2 = tableViewer.getTable();
		tabela2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLivros = tableViewerColumn.getColumn();
		tblclmnLivros.setWidth(379);
		tblclmnLivros.setText("Livros");
		
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnQuantidade_1 = tableViewerColumn_1.getColumn();
		
		//editor para poder mudar a quantidade de livros na própria tabela
		final TableEditor editor = new TableEditor(tabela2);
	    editor.horizontalAlignment = SWT.LEFT;
	    editor.grabHorizontal = true;
		tabela2.addListener(SWT.MouseDown, new Listener() {
		      public void handleEvent(Event event) {
		        Rectangle clientArea = tabela2.getClientArea();
		        Point pt = new Point(event.x, event.y);
		        int index = tabela2.getTopIndex();
		        while (index < tabela2.getItemCount()) {
		          boolean visible = false;
		          TableItem item = tabela2.getItem(index);
		            Rectangle rect = item.getBounds(1);
		            if (rect.contains(pt)) {
		              int column = 1;
		              Text texto = new Text(tabela2, SWT.NONE);
		              Listener textListener = new Listener() {
		                public void handleEvent(final Event e) {
		                  switch (e.type) {
		                  case SWT.FocusOut:
		                    item.setText(column, texto.getText());
		                    texto.dispose();
		                    //colocar aqui e no outro switch uma cena para actualizar o carrinho
		                    //
		                    //
		                    //
		                    //
		                    //
		                    //
		                    //
		                    
		                    System.out.println(carrinho);
		                    break;
		                  case SWT.Traverse:
		                    switch (e.detail) {
		                    case SWT.TRAVERSE_RETURN:
		                      item.setText(column, texto.getText());
		                      System.out.println(carrinho);
		                    // 
		                    case SWT.TRAVERSE_ESCAPE:
		                      texto.dispose();
		                      e.doit = false;
		                    }
		                    break;
		                  }
		                }
		              };
		              texto.addListener(SWT.FocusOut, textListener);
		              texto.addListener(SWT.Traverse, textListener);
		              editor.setEditor(texto, item, 1);
		              texto.setText(item.getText(1));
		              texto.selectAll();
		              texto.setFocus();
		              return;
		            }
		            if (!visible && rect.intersects(clientArea)) {
		              visible = true;
		            }
		          if (!visible)
		            return;
		          index++;
		        }
		      }
		    });
		
		
		
		tblclmnQuantidade_1.setWidth(100);
		tblclmnQuantidade_1.setText("Quantidade");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		//adicionar um a um os livros do Carrinho de livros à table
		for (Livro lv : carrinho.livrosQuant.keySet()) {
		      TableItem item = new TableItem(tabela2, SWT.NONE);
		      //primeira coluna com o título do livro e segunda coluna com a quantidade
		      item.setText( new String[] { lv.toString() , "" + carrinho.livrosQuant.get(lv) } );
		}	
		
		
		Label lblNewLabel_1 = new Label(shell, SWT.CENTER);
		GridData gd_lblNewLabel_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 477;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setText("TOTAL");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		

	}

}
