package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import swing2swt.layout.FlowLayout;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;

import java.util.ArrayList;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.SashForm;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_02Carrinho extends J_01ListaLivros{ //criou-se janela como subclasse para poder receber variáveis da superclasse
	protected Shell shell;
	private Table table;
	private Table table_1;
	
	
	//criou-se construtor que vai buscar variáveis à supercalsse
	public J_02Carrinho( ) {
		super(listaLivrosCarrinho);
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
		//impressão para ver se passa o carrinho corretamente
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
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(379);
		tblclmnNewColumn.setText("Livros");
		
		TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {1});
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton_1.setText("New Button");
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer.getTable();
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLivros = tableViewerColumn.getColumn();
		tblclmnLivros.setWidth(100);
		tblclmnLivros.setText("Livros");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnQuantidade_1 = tableViewerColumn_1.getColumn();
		tblclmnQuantidade_1.setWidth(100);
		tblclmnQuantidade_1.setText("Quantidade");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(shell, SWT.CENTER);
		GridData gd_lblNewLabel_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 477;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setText("TOTAL");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		//adicionar um a um os livros da listaCarrinho de livros à table
				for (Livro lv : listaLivrosCarrinho) {
				      TableItem item = new TableItem(table, SWT.NONE);
				      item.setText(lv.toString());
				}

	}

}
