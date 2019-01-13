package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.IOException;
import java.io.Serializable;
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
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_12Menu_Vendedor implements Serializable{

	protected Shell shlMenuVendedor;
	protected static Livraria livraria;// atributo adicionado para poder ir buscar métodos à livraria
	protected Utilizador utilizador;
	protected Compra compraSelecionada;//atributo que nos dá a compra que está selecionada na table
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
		//listner que nos dá a compra que está selecionada na tabela
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
				//caso compra selecionada já esteja paga
				else if ( compraSelecionada.getEstadoCompra() == Compra.Estado.PAGA ) {
					lblSelecioneVenda.setVisible(false);
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("A venda selecionada", 
							"já se encontra no estado \"Paga\".");
					janela.open();
				}
				//caso compra selecionada esteja anulada
				else if ( compraSelecionada.getEstadoCompra() == Compra.Estado.ANULADA ) {
					lblSelecioneVenda.setVisible(false);
					J_21Confirmacao janela = new J_21Confirmacao("A venda selecionada encontra-se \"ANULADA\"", 
							"Pretende apagar o registo da venda?", confirmacao);
					janela.open();
					confirmacao = janela.isConfirmacao();
					//Se confirmarem que querem apagar, remover a compra da livraria
					if ( confirmacao) {
						livraria.getCompras().remove(compraSelecionada);
						preencherTabela("Todas");
					}
				}
				//caso compra selecionado do tipo cartão
				else if ( compraSelecionada instanceof CompraCartao ) {
					lblSelecioneVenda.setVisible(false);
					J_21Confirmacao janelaConfirmacao = new J_21Confirmacao("COMPRA CARTÃO", 
							"Pretende solicitar confirmação ao banco?", confirmacao);
					janelaConfirmacao.open();
					confirmacao = janelaConfirmacao.isConfirmacao();
					//Se confirmarem que querem pedir confirmação ao banco, escrever para thread do banco
					if ( confirmacao) {
//						
//						
//						01121000,100000,500010000,000,200.25
//						
						int compraID=compraSelecionada.getNumCompra();
						String cartaoID=((CompraCartao) compraSelecionada).getNumCartao();
						String pin=((CompraCartao) compraSelecionada).getPin();
						double valorCompra= ((CompraCartao) compraSelecionada).getTotal();
						
						String aEnviar=compraID+","+100000+","+cartaoID+","+pin+","+valorCompra;
//						ESCREVER PARA THREAD AO BANCO A PEDIR CONFIRMAÇÃO
						FicheiroDeTexto ficheiroPedidos = new FicheiroDeTexto();
						FicheiroDeTexto ficheiroDevolucao = new FicheiroDeTexto();
						try {
							ficheiroPedidos.abreEscrita("..\\PedidosdaLivravria.txt");
							ficheiroPedidos.escreveLinha(aEnviar);
							ficheiroPedidos.fechaEscrita();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//E LER
						String resposta="";
						do {
						try {
							ficheiroDevolucao.abreLeitura("..\\RespostadoBanco.txt");
							resposta=ficheiroDevolucao.leLinha();
							ficheiroDevolucao.fechaLeitura();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}while(resposta.equals(""));
						System.out.println(resposta);
						
						//Caso a resposta seja positiva
						String str2 = "Pagamento efetuado com sucesso.";
						if ( resposta.toLowerCase().contains(str2.toLowerCase()) ) {
							//abrir janela de mensagem de sucesso
							compraSelecionada.setEstadoCompra(Compra.Estado.PAGA);
							preencherTabela("Todas");
							J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("SUCESSO"
									+ "",str2);
							janela.open();
						}
						//Caso o valor seja superior ao limite diário
						else if ( resposta.toLowerCase().contains("VALOR superior ao LIMITE DIARIO PERMITIDO") ) {
							//abrir janela de mensagem de pagamento recusado
							J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("PAGAMENTO RECUSADO",
									"Excedeu o seu limite diário do seu banco");
							janela.open();
						}
						//Caso não tenha saldo suficiente
						else if ( resposta.toLowerCase().contains("SALDO insuficiente") ) {
							//abrir janela de mensagem de pagamento recusado
							J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("PAGAMENTO RECUSADO",
									"Saldo insuficiente");
							janela.open();
						}
						//Caso pin inválido
						else if ( resposta.toLowerCase().contains("O PIN não é Válido") ) {
							//abrir janela de mensagem de pagamento recusado
							J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("PAGAMENTO RECUSADO",
									"PIN inválido");
							janela.open();
						}
						//Caso cartão inexistente
						else if ( resposta.toLowerCase().contains("O Cartão não Existe") ) {
							//abrir janela de mensagem de pagamento recusado
							J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("PAGAMENTO RECUSADO",
									"Cartão inexistente");
							janela.open();
						}
						
						//RESPOSTAS POSSÍVEIS
						//"Pagamento efetuado com sucesso."
						//"VALOR superior ao LIMITE DIARIO PERMITIDO";
						//"SALDO insuficiente";
						//"O PIN não é Válido";
						//"O Cartão não Existe";

						
						
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
					// se confirmarem que venda está paga, marcar a venda como PAGA
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
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenuVendedor.close();
				J_00Inicial janela = new J_00Inicial(livraria);
				janela.open();
			}
		});
		btnVoltar.setText("Voltar/Logout");
		btnVoltar.setBounds(681, 459, 104, 28);

		Button btnAnularVenda = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnAnularVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Caso nenhuma compra esteja selecionada -> mostrar mensagem 
				if ( compraSelecionada == null ) {
					lblSelecioneVenda.setVisible(true);
				}
				//caso uma compra esteja selecionada
				else {
					lblSelecioneVenda.setVisible(false);
					J_21Confirmacao janelaConfirmacao = new J_21Confirmacao("ANULAR VENDA", 
							"Pretende anular a venda?", confirmacao);
					janelaConfirmacao.open();
					confirmacao = janelaConfirmacao.isConfirmacao();
					// se confirmarem que querem anular
					if ( confirmacao) {
						//repor o stock da compra para a livraria
						livraria.esvaziarCompraReporStock(compraSelecionada);
						//marcar compra como anulada
						compraSelecionada.setEstadoCompra(Compra.Estado.ANULADA);
						preencherTabela("Todas");
					}
				}
			}
		});
		btnAnularVenda.setText("Anular venda");
		btnAnularVenda.setBounds(668, 197, 117, 61);
		
		Button btnAlterarFormaPagamento = new Button(shlMenuVendedor,SWT.WRAP | SWT.NONE);
		btnAlterarFormaPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//Caso nenhuma compra esteja selecionada -> mostrar mensagem 
				if ( compraSelecionada == null ) {
					lblSelecioneVenda.setVisible(true);
				}
				//caso uma compra esteja selecionada
				else {
					lblSelecioneVenda.setVisible(false);
					//Se compra do tipo cartao, perguntar se querem mudar para dinheiro	
					if ( compraSelecionada instanceof CompraCartao ) {
						J_21Confirmacao janelaConfirmacao = new J_21Confirmacao("ALTERAR FORMA DE PAGAMENTO", 
								"Pretende alterar para pagamento a Dinheiro?", confirmacao);
						janelaConfirmacao.open();
						confirmacao = janelaConfirmacao.isConfirmacao();
						// se confirmarem que querem passar para compra a dinheiro
						if ( confirmacao) {
							Compra novaCompra = new Compra( compraSelecionada.getNumCompra(), compraSelecionada.getCarrinho(), 
									compraSelecionada.getNif(), compraSelecionada.getData(), compraSelecionada.getEstadoCompra());
							livraria.getCompras().add(novaCompra);
							livraria.getCompras().remove(compraSelecionada);
							compraSelecionada = novaCompra;
							preencherTabela("Todas");
						}
					}
					//Se compra do tipo dinheiro, perguntar se querem mudar para cartão e se sim pedir pin e num cartao
					else {
						J_21Confirmacao janelaConfirmacao = new J_21Confirmacao("ALTERAR FORMA DE PAGAMENTO", 
								"Pretende alterar para pagamento com cartão?", confirmacao);
						janelaConfirmacao.open();
						confirmacao = janelaConfirmacao.isConfirmacao();
						// se confirmarem que querem passar para compra a cartão, pedir o cartão e pin
						if ( confirmacao) {
							J_22PedirCartao janelaCartao = new J_22PedirCartao(livraria, compraSelecionada);
							janelaCartao.open();
							preencherTabela("Todas");
						}
					}
				}
					
			}
		});
		btnAlterarFormaPagamento.setText("Alterar\nforma de pagamento");
		btnAlterarFormaPagamento.setBounds(668, 310, 117, 70);

		Combo combo = new Combo(shlMenuVendedor, SWT.NONE);
		combo.setItems("Todas", "Dinheiro", "Cartão", "Submetidas", "Paga", "Anulada" );
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
					preencherTabela("Pagas");
				}
				if ( combo.getSelectionIndex() == 5) {
					preencherTabela("Anuladas");
				}
				
			}
		});
		combo.setBounds(158, 47, 122, 28);

		Label lblFiltrar = new Label(shlMenuVendedor, SWT.NONE);
		lblFiltrar.setAlignment(SWT.RIGHT);
		lblFiltrar.setBounds(27, 50, 128, 20);
		lblFiltrar.setText("Filtrar");

		
		
		
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
		else if ( filtro.equals("Pagas")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.PAGA))) {
					preencherItemsTabela( c );
				}
			}
		}		
		//Se filtro for 'Anuladas'
		else if ( filtro.equals("Anuladas")) {
			// Preencher tabela
			for (Compra c : livraria.getCompras()) {
				if ( c.estadoCompra.equals((Compra.Estado.ANULADA))) {
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
		//Caso seja venda cartão
		if ( (c instanceof CompraCartao) ) {
			item.setText(5, "Cartão");
		}
		//Caso seja venda dinheiro
		else {
			item.setText(5, "Dinheiro");
		}
		item.setText(6, "" + c.estadoCompra);
	}		
}
