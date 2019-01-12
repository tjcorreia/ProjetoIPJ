package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.Calendar;
import java.text.Collator;
import java.util.Locale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2017
 * @aid 1.1
 */

public class J_12Menu_Vendedor {

	protected Shell shlMenuVendedor;
	protected static Livraria livraria;// atributo adicionado para poder ir buscar métodos à livraria
	protected Utilizador utilizador;
	protected Compra compraSelecionada;//atributo que nos dá a compra que está selecionada na table
	private Table table;

	// Construtor para poder trazer a Livraria para esta classe
	public J_12Menu_Vendedor(Livraria livraria, Utilizador utilizador) {
		// super();
		this.utilizador = utilizador;
		this.livraria = livraria;
		open();
	}

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			J_12Menu_Vendedor window = new J_12Menu_Vendedor(livraria);
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
		shlMenuVendedor.open();
		shlMenuVendedor.layout();
		while (!shlMenuVendedor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		//display.dispose();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuVendedor = new Shell();
		shlMenuVendedor.setSize(743, 540);
		shlMenuVendedor.setText("Menu Vendedor");

		Button btnValidarVendaDinh = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnValidarVendaDinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if ( compraSelecionada instanceof CompraCartao ) {
					
				}
			}
		});
		btnValidarVendaDinh.setText("Validar\nVenda dinheiro");
		btnValidarVendaDinh.setBounds(593, 109, 117, 61);

		Label lblMenuVendedor = new Label(shlMenuVendedor, SWT.NONE);
		lblMenuVendedor.setText("VENDAS");
		lblMenuVendedor.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuVendedor.setBounds(10, 10, 229, 31);

		Label lblNomeUtilizador = new Label(shlMenuVendedor, SWT.NONE);
		lblNomeUtilizador.setText("Bem-vindo(a) " + utilizador.nome);
		lblNomeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeUtilizador.setBounds(407, 10, 303, 21);

		Button btnVoltar = new Button(shlMenuVendedor, SWT.NONE);
		btnVoltar.setText("Voltar/Logout");
		btnVoltar.setBounds(606, 459, 104, 28);

		Button btnValidarVendaCartao = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnValidarVendaCartao.setText("Pedir validação\nVenda cartão");
		btnValidarVendaCartao.setBounds(593, 234, 117, 61);

		Combo combo = new Combo(shlMenuVendedor, SWT.NONE);
		combo.setItems("Todas", "Dinheiro", "Cartão", "Submetidas", "Recusadas", "Finalizadas" );
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Se selecionado 'todas' -> preencher tabela com todas as compras
				if ( combo.getSelectionIndex() == 0) {
					preencherTabela("Todas");
				}
				//Se selecionado 'Dinheiro' -> preencher tabela com todas as compras a dinheiro
				if ( combo.getSelectionIndex() == 1) {
					preencherTabela("Dinheiro");
				}
				if ( combo.getSelectionIndex() == 2) {
					preencherTabela("Cartão");
				}
				if ( combo.getSelectionIndex() == 3) {
					preencherTabela("Submetidas");
				}
				if ( combo.getSelectionIndex() == 4) {
					preencherTabela("Recusadas");
				}
				if ( combo.getSelectionIndex() == 5) {
					preencherTabela("Finalizadas");
				}
				
			}
		});
		combo.setBounds(158, 47, 122, 28);

		Label lblFiltrar = new Label(shlMenuVendedor, SWT.NONE);
		lblFiltrar.setAlignment(SWT.RIGHT);
		lblFiltrar.setBounds(27, 50, 128, 20);
		lblFiltrar.setText("Filtrar por estado");

		table = new Table(shlMenuVendedor, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		//listner que nos dá a compra que está selecionada na tabela
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				int indexCompraSelecionada = ((Table)e.widget).indexOf((TableItem)e.item);
				TableItem itemSelecionado = table.getItem(indexCompraSelecionada);
				String numCompraStr = itemSelecionado.getText();
				System.out.println("itemSelecionado=" + numCompraStr);
				int numCompra = Integer.parseInt(numCompraStr);
				compraSelecionada = livraria.getCompra(numCompra);
			}
		});
		table.setBounds(10, 83, 567, 387);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tblclmnVenda = new TableColumn(table, SWT.CENTER);

		tblclmnVenda.setWidth(58);
		tblclmnVenda.setText("Venda");
		TableColumn tblclmnNif = new TableColumn(table, SWT.CENTER);
		tblclmnNif.setWidth(118);
		tblclmnNif.setText("NIF");
		
		TableColumn tblclmnData = new TableColumn(table, SWT.CENTER);
		tblclmnData.setWidth(116);
		tblclmnData.setText("Data");
		TableColumn tblclmnItems = new TableColumn(table, SWT.CENTER);
		tblclmnItems.setWidth(65);
		tblclmnItems.setText("Items");
		
		TableColumn tblclmnTotal = new TableColumn(table, SWT.CENTER);
		tblclmnTotal.setWidth(100);
		tblclmnTotal.setText("Total");
		TableColumn tblclmnEstado = new TableColumn(table, SWT.CENTER);
		tblclmnEstado.setWidth(105);
		tblclmnEstado.setText("Estado");
		preencherTabela("Todas");
		
		
//		
//		tblclmnItems.addListener(SWT.Selection, new Listener() {
//		      public void handleEvent(Event e) {
//				// ordenar coluna NIF
//				TableItem[] items = table.getItems();
//				Collator collator = Collator.getInstance(Locale.getDefault());
//				for (int i = 1; i < items.length; i++) {
//					String value1 = items[i].getText(0);
//					for (int j = 0; j < i; j++) {
//						String value2 = items[j].getText(0);
//						if (collator.compare(value1, value2) < 0) {
//							String[] values = { items[i].getText(0), items[i].getText(1) };
//							items[i].dispose();
//							TableItem item = new TableItem(table, SWT.NONE, j);
//							item.setText(values);
//							items = table.getItems();
//							break;
//						}
//					}
//				}
//			}
//		});
//		
//		
//		tblclmnNif.addListener(SWT.Selection, new Listener() {
//		      public void handleEvent(Event e) {
//				// ordenar coluna NIF
//				TableItem[] items = table.getItems();
//				Collator collator = Collator.getInstance(Locale.getDefault());
//				for (int i = 1; i < items.length; i++) {
//					String value1 = items[i].getText(0);
//					for (int j = 0; j < i; j++) {
//						String value2 = items[j].getText(0);
//						if (collator.compare(value1, value2) < 0) {
//							String[] values = { items[i].getText(0), items[i].getText(1) };
//							items[i].dispose();
//							TableItem item = new TableItem(table, SWT.NONE, j);
//							item.setText(values);
//							items = table.getItems();
//							break;
//						}
//					}
//				}
//			}
//		});
		
		
		

//		String[] tituloColunas = { "Número", "Items", "NIF", "Data", "Total", "Estado" };
//		for (int i = 0; i < tituloColunas.length; i++) {
//		      TableColumn column = new TableColumn(table, SWT.NONE);
//		      column.setText(tituloColunas[i]);
//		}
//		for (Compra c : livraria.getCompras()) {
//	        TableItem item = new TableItem(table, SWT.NONE);
//	        item.setText(0, "" + c.numCompra);
//	        item.setText(1, "" + c.carrinho.numeroItemsDoCarrinho() );
//	        item.setText(2, c.nif );
//	        item.setText(3, "" + c.data.get(Calendar.YEAR) + "/" + ((c.data.get(Calendar.MONTH))+1) + "/" + c.data.get(Calendar.DAY_OF_MONTH) );
//	        item.setText(4, "" + c.total + "€");
//	        item.setText(5, "" + c.estadoCompra );
//	    }  
//		for (int i = 0; i < tituloColunas.length; i++) {
//			table.getColumn(i).pack();
//		}
//		table.setSize(table.computeSize(SWT.DEFAULT, 200));
//	    shlMenuVendedor.pack();
//	    shlMenuVendedor.open();
//	    while (!shlMenuVendedor.isDisposed()) {
//	      if (!display.readAndDispatch())
//	        display.sleep();
//	    }
//	    display.dispose();    

	}
	
	//Método para limpar e preencher novamente a tabela 
	public void preencherTabela(String filtro) {
		//limpar tabela
		table.removeAll();
		//Se filtro for 'todas'
		if ( filtro.equals("Todas")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				preencherItemsTabela( c );
			}
		}
		//Se filtro for 'Dinheiro'
		else if ( filtro.equals("Dinheiro")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( !(c instanceof CompraCartao) ) {
					preencherItemsTabela( c );
				}
			}
		}
		//Se filtro for 'Cartão'
		else if ( filtro.equals("Cartão")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( (c instanceof CompraCartao) ) {
					preencherItemsTabela( c );
				}
			}
		}		
		//Se filtro for 'Submetidas'
		else if ( filtro.equals("Submetidas")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.SUBMETIDA))) {
					preencherItemsTabela( c );
				}
			}
		}	
		//Se filtro for 'Recusadas'
		else if ( filtro.equals("Recusadas")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.RECUSADA))) {
					preencherItemsTabela( c );
				}
			}
		}		
		//Se filtro for 'Finalizadas'
		else if ( filtro.equals("Finalizadas")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.FINALIZADA))) {
					preencherItemsTabela( c );
				}
			}
		}		
		table.redraw();	
	}	
	
	//Método para limpar e preencher novamente a tabela 
	public void preencherItemsTabela(Compra c) {
		// Preencher tabela
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "" + c.numCompra);
		item.setText(1, c.nif);
		item.setText(2, "" + c.data.get(Calendar.YEAR) + "/" + ((c.data.get(Calendar.MONTH)) + 1) + "/"
				+ c.data.get(Calendar.DAY_OF_MONTH));
		item.setText(3, "" + c.carrinho.numeroItemsDoCarrinho());
		item.setText(4, "" + c.total + "€");
		item.setText(5, "" + c.estadoCompra);
	}		
}
