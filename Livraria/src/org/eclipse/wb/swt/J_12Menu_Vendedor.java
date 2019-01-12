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
 * Breve descri��o do c�digo
 * 
 * @sid 2017
 * @aid 1.1
 */

public class J_12Menu_Vendedor {

	protected Shell shlMenuVendedor;
	protected static Livraria livraria;// atributo adicionado para poder ir buscar m�todos � livraria
	protected Utilizador utilizador;
	protected Compra compraSelecionada;//atributo que nos d� a compra que est� selecionada na table
	private Table table;
	protected boolean confirmacao;

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

	

	public boolean isConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(boolean confirmacao) {
		this.confirmacao = confirmacao;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuVendedor = new Shell();
		shlMenuVendedor.setSize(813, 540);
		shlMenuVendedor.setText("Menu Vendedor");
		
		Label lblSelecioneVenda = new Label(shlMenuVendedor, SWT.NONE);
		lblSelecioneVenda.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSelecioneVenda.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSelecioneVenda.setAlignment(SWT.RIGHT);
		lblSelecioneVenda.setBounds(482, 57, 168, 20);
		lblSelecioneVenda.setText("Selecione uma venda");
		lblSelecioneVenda.setVisible(false);
		
		table = new Table(shlMenuVendedor, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		//listner que nos d� a compra que est� selecionada na tabela
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int indexCompraSelecionada = ((Table)e.widget).indexOf((TableItem)e.item);
				TableItem itemSelecionado = table.getItem(indexCompraSelecionada);
				String numCompraStr = itemSelecionado.getText();
				System.out.println("itemSelecionado=" + numCompraStr);
				int numCompra = Integer.parseInt(numCompraStr);
				compraSelecionada = livraria.getCompra(numCompra);
			}
		});
		table.setBounds(10, 83, 640, 387);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tblclmnVenda = new TableColumn(table, SWT.CENTER);

		tblclmnVenda.setWidth(58);
		tblclmnVenda.setText("Venda");
		TableColumn tblclmnNif = new TableColumn(table, SWT.CENTER);
		tblclmnNif.setWidth(112);
		tblclmnNif.setText("NIF");
		
		TableColumn tblclmnData = new TableColumn(table, SWT.CENTER);
		tblclmnData.setWidth(108);
		tblclmnData.setText("Data");
		TableColumn tblclmnItems = new TableColumn(table, SWT.CENTER);
		tblclmnItems.setWidth(65);
		tblclmnItems.setText("Items");
		
		TableColumn tblclmnTotal = new TableColumn(table, SWT.CENTER);
		tblclmnTotal.setWidth(100);
		tblclmnTotal.setText("Total");
		
		TableColumn tblclmnPagamento = new TableColumn(table, SWT.NONE);
		tblclmnPagamento.setWidth(86);
		tblclmnPagamento.setText("Pagamento");
		
		TableColumn tblclmnEstado = new TableColumn(table, SWT.CENTER);
		tblclmnEstado.setWidth(105);
		tblclmnEstado.setText("Estado");
		
		preencherTabela("Todas");

		Button btnValidarVenda = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnValidarVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Caso nenhuma compra esteja selecionada -> mostrar mensagem 
				if ( compraSelecionada == null ) {
					lblSelecioneVenda.setVisible(true);
				}
				//caso compra selecionada j� esteja paga
				else if ( compraSelecionada.getEstadoCompra() == Compra.Estado.PAGA ) {
					lblSelecioneVenda.setVisible(false);
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("A venda selecionada", 
							"j� se encontra no estado \"Paga\".");
					janela.open();
				}
				//caso compra selecionada esteja anulada
				else if ( compraSelecionada.getEstadoCompra() == Compra.Estado.ANULADA ) {
					lblSelecioneVenda.setVisible(false);
					J_21Confirmacao janela = new J_21Confirmacao("A venda selecionada encontra-se \"Anulada\"", 
							"Pretende reverter o estado para \"Paga\"?", confirmacao);
					janela.open();
					confirmacao = janela.isConfirmacao();
					//Se confirmarem que querem reverter o estado, marcar como 'paga'
					if ( confirmacao) {
						compraSelecionada.setEstadoCompra(Compra.Estado.PAGA);
						preencherTabela("Todas");
					}
				}
				//caso compra selecionado do tipo cart�o
				else if ( compraSelecionada instanceof CompraCartao ) {
					lblSelecioneVenda.setVisible(false);
					J_21Confirmacao janelaConfirmacao = new J_21Confirmacao("COMPRA CART�O", 
							"Pretende solicitar confirma��o ao banco?", confirmacao);
					janelaConfirmacao.open();
					confirmacao = janelaConfirmacao.isConfirmacao();
					System.out.println(confirmacao);
					//Se confirmarem que querem pedir confirma��o ao banco, escrever para thread do banco
					if ( confirmacao) {
//						
//						
//						ESCREVER PARA THREAD AO BANCO A PEDIR CONFIRMA��O
//						
//						
//						
//						
					}
				}
				//caso compra selecionado do tipo dinheiro
				else {
					lblSelecioneVenda.setVisible(false);
					J_21Confirmacao janelaConfirmacao = new J_21Confirmacao("COMPRA DINHEIRO", 
							"Pretende registar a venda como paga?", confirmacao);
					janelaConfirmacao.open();
					confirmacao = janelaConfirmacao.isConfirmacao();
					System.out.println(confirmacao);
					// se confirmarem que venda est� paga, marcar a venda como PAGA
					if ( confirmacao) {
						compraSelecionada.setEstadoCompra(Compra.Estado.PAGA);
						preencherTabela("Todas");
					}
				}
			}
		});
		btnValidarVenda.setText("Validar\r\nVenda");
		btnValidarVenda.setBounds(668, 83, 117, 61);

		Label lblMenuVendedor = new Label(shlMenuVendedor, SWT.NONE);
		lblMenuVendedor.setText("VENDAS");
		lblMenuVendedor.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuVendedor.setBounds(10, 10, 229, 31);

		Label lblNomeUtilizador = new Label(shlMenuVendedor, SWT.NONE);
		lblNomeUtilizador.setText("Bem-vindo(a) " + utilizador.nome);
		lblNomeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeUtilizador.setBounds(482, 10, 303, 21);

		Button btnVoltar = new Button(shlMenuVendedor, SWT.NONE);
		btnVoltar.setText("Voltar/Logout");
		btnVoltar.setBounds(681, 459, 104, 28);

		Button btnAnularVenda = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnAnularVenda.setText("Anular venda");
		btnAnularVenda.setBounds(668, 197, 117, 61);
		
		Button btnAlterarFormaPagamento = new Button(shlMenuVendedor,SWT.WRAP | SWT.NONE);
		btnAlterarFormaPagamento.setText("Alterar\nforma de pagamento");
		btnAlterarFormaPagamento.setBounds(668, 310, 117, 70);

		Combo combo = new Combo(shlMenuVendedor, SWT.NONE);
		combo.setItems("Todas", "Dinheiro", "Cart�o", "Submetidas", "Paga", "Anulada" );
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
					preencherTabela("Cart�o");
				}
				if ( combo.getSelectionIndex() == 3) {
					preencherTabela("Submetidas");
				}
				if ( combo.getSelectionIndex() == 4) {
					preencherTabela("Paga");
				}
				if ( combo.getSelectionIndex() == 5) {
					preencherTabela("Anulada");
				}
				
			}
		});
		combo.setBounds(158, 47, 122, 28);

		Label lblFiltrar = new Label(shlMenuVendedor, SWT.NONE);
		lblFiltrar.setAlignment(SWT.RIGHT);
		lblFiltrar.setBounds(27, 50, 128, 20);
		lblFiltrar.setText("Filtrar por estado");

		
		
		
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
		
		
		

//		String[] tituloColunas = { "N�mero", "Items", "NIF", "Data", "Total", "Estado" };
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
//	        item.setText(4, "" + c.total + "�");
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
	
	//M�todo para limpar e preencher novamente a tabela 
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
		//Se filtro for 'Cart�o'
		else if ( filtro.equals("Cart�o")) {
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
		else if ( filtro.equals("Paga")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.PAGA))) {
					preencherItemsTabela( c );
				}
			}
		}		
		//Se filtro for 'Finalizadas'
		else if ( filtro.equals("Anulada")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.ANULADA))) {
					preencherItemsTabela( c );
				}
			}
		}		
		table.redraw();	
	}	
	
	//M�todo para limpar e preencher novamente a tabela 
	public void preencherItemsTabela(Compra c) {
		// Preencher tabela
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "" + c.numCompra);
		item.setText(1, c.nif);
		item.setText(2, "" + c.data.get(Calendar.YEAR) + "/" + ((c.data.get(Calendar.MONTH)) + 1) + "/"
				+ c.data.get(Calendar.DAY_OF_MONTH));
		item.setText(3, "" + c.carrinho.numeroItemsDoCarrinho());
		item.setText(4, "" + c.total + "�");
		//Caso seja venda a dinheiro
		if ( !(c instanceof CompraCartao) ) {
			item.setText(5, "Dinheiro");
		}
		//Caso seja venda cart�o
		else {
			item.setText(5, "Cart�o");
		}
		item.setText(6, "" + c.estadoCompra);
	}		
}
