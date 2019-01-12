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
import org.eclipse.swt.layout.RowLayout;
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
import org.eclipse.wb.swt.Compra.Estado;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_02Carrinho { //criou-se janela como subclasse para poder receber variáveis da superclasse
	protected Shell shell;
	protected Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	protected Carrinho carrinho;
	protected Livro livroSelecionado;//atributo que nos dá o livro que está selecionado na table
	private Table tabela;
	private Text caixaParaNIF;
	private Text caixaParaNumCartao;
	private Text caixaParaPIN;

	
	
	//criou-se construtor que vai buscar variáveis à supercalsse
	public J_02Carrinho( Livraria livraria, Carrinho carrinho) {
		this.livraria = livraria;
		this.carrinho = carrinho;
		open();
		//super(listaLivrosDaBusca);
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
//		Map <GregorianCalendar, Double > precos1 = new HashMap<>();
//		precos1.put(new GregorianCalendar(2017,2,5), 15.0);
//		precos1.put(new GregorianCalendar(2016,6,14), 13.0);
//		precos1.put(new GregorianCalendar(2016,11,14), 14.0);
//		Map <GregorianCalendar, Double > precos2 = new HashMap<>();
//		precos2.put(new GregorianCalendar(2017,2,5), 15.0);
//		precos2.put(new GregorianCalendar(2016,6,14), 13.0);
//		precos2.put(new GregorianCalendar(2016,11,14), 14.0);
//		//criar 3 livros
//		Livro lv1 = new Livro ("O último voo do Flamingo", "1548967532745", "Mia Couto", "Plátano", 
//				"Romance. Um estranho encontro", new GregorianCalendar (2018,11,12) , 15.5, 20, precos1);
//		Livro lv2 = new Livro ("Hitchhicker's Guide to the Galaxy", "8695477532745", "Douglas Adams", "Leya", 
//				"Ficção Científica. Viagens espaciais de um inadaptado", 
//				new GregorianCalendar (2017,11,18) , 16.5, 3, precos2);
//		//Criar alguns mapas de livros-quantidade para os carrinhos de compras 
//		ArrayList <Livro> livros1 = new ArrayList <>();
//		livros1.add(lv1);
//		livros1.add(lv1);
//		livros1.add(lv1);
//		livros1.add(lv2);
//		//criar um carrinho
//		carrinho = new Carrinho(livros1);
	}



//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			J_02Carrinho window = new J_02Carrinho( );
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

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
		//listner para se fecharem a janela a meio de um carrinho, reporem o stock dos livros que estavam no carrinho
//		
//		
//		VERIFICAR SE ESTE LISTNER FICARÁ A FUNCIONAR BEM DEPOIS DE RETIRAR OS 'open()' dos construtores
//		ele agora não funciona bem
//		
		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(ShellEvent e) {
				livraria.esvaziarCarrinhoReporStock(carrinho);
			}
		});		
		
		Label lblCarrinho = new Label(shell, SWT.NONE);
		lblCarrinho.setBounds(141, 5, 229, 20);
		lblCarrinho.setText("CARRINHO");
		
		Label lblSemStock = new Label(shell, SWT.NONE);
		lblSemStock.setVisible(false);
		lblSemStock.setText("Livro Indispon\u00EDvel");
		lblSemStock.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSemStock.setBounds(548, 31, 153, 20);
		
		Label lblSelecionarLivro = new Label(shell, SWT.NONE);
		lblSelecionarLivro.setVisible(false);
		lblSelecionarLivro.setText("Selecione um livro");
		lblSelecionarLivro.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSelecionarLivro.setBounds(548, 31, 153, 20);
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tabela = tableViewer.getTable();
		//Listner que devolve o indice e o livro do livro selecionado na tabela como 'indexLivroSelecionado' e 'livroSelecionado'
		tabela.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblSemStock.setVisible(false);
				lblSelecionarLivro.setVisible(false);
				System.out.println(e.toString());
				int indexLivroSelecionado = ((Table)e.widget).indexOf((TableItem)e.item);
				System.out.println( indexLivroSelecionado );
				livroSelecionado = carrinho.livros.get(indexLivroSelecionado);
			}
		});
		tabela.setBounds(5, 31, 535, 421);
		tabela.setHeaderVisible(true);
		
			
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
				//J_01ListaLivros janelaDeProcura = new J_01ListaLivros(carrinho.livros);
				J_01ListaLivros janelaDeProcura = new J_01ListaLivros(livraria, carrinho);
				janelaDeProcura.open();
			}
		});
		botaoVoltar.setText("Voltar/Pesquisar");
		
		
		caixaParaNIF = new Text(shell, SWT.BORDER);
		caixaParaNIF.setBounds(558, 132, 127, 30);
		caixaParaNIF.setVisible(false);
		
		Label lblNIF = new Label(shell, SWT.NONE);
		lblNIF.setBounds(559, 110, 70, 20);
		lblNIF.setText("NIF:");
		lblNIF.setVisible(false);
		
		Label lblIntroduzaNIF = new Label(shell, SWT.NONE);
		lblIntroduzaNIF.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblIntroduzaNIF.setVisible(false);
		lblIntroduzaNIF.setText("Introduza NIF");
		lblIntroduzaNIF.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIntroduzaNIF.setBounds(558, 161, 127, 20);
		
		
		caixaParaNumCartao = new Text(shell, SWT.BORDER);
		caixaParaNumCartao.setVisible(false);
		caixaParaNumCartao.setBounds(558, 285, 127, 30);
		
		Label lblNumeroDoCarto = new Label(shell, SWT.NONE);
		lblNumeroDoCarto.setVisible(false);
		lblNumeroDoCarto.setText("N\u00FAmero do cart\u00E3o");
		lblNumeroDoCarto.setBounds(559, 263, 142, 20);
		
		Label lblMensagemNumCartao = new Label(shell, SWT.NONE);
		lblMensagemNumCartao.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemNumCartao.setVisible(false);
		lblMensagemNumCartao.setText("Número incorreto (9 dígitos)");
		lblMensagemNumCartao.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemNumCartao.setBounds(558, 314, 127, 20);
		
		caixaParaPIN = new Text(shell, SWT.BORDER);
		caixaParaPIN.setVisible(false);
		caixaParaPIN.setBounds(558, 362, 127, 30);
		
		Label lblPIN = new Label(shell, SWT.NONE);
		lblPIN.setVisible(false);
		lblPIN.setText("PIN:");
		lblPIN.setBounds(559, 340, 70, 20);
		
		Label lblMensagemParaPIN = new Label(shell, SWT.NONE);
		lblMensagemParaPIN.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblMensagemParaPIN.setVisible(false);
		lblMensagemParaPIN.setText("PIN incorreto (3 dígitos)");
		lblMensagemParaPIN.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblMensagemParaPIN.setBounds(558, 391, 127, 20);
		
		Label lblCarrinhoVazio = new Label(shell, SWT.NONE);
		lblCarrinhoVazio.setVisible(false);
		lblCarrinhoVazio.setText("Carrinho Vazio");
		lblCarrinhoVazio.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblCarrinhoVazio.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblCarrinhoVazio.setBounds(574, 398, 127, 20);
		
		//Grupo de butões radio para selecionar o tipo de pagamento, dinheiro ou cartão
	    Group groupoTipoDePagamento = new Group(shell, SWT.SHADOW_IN);
	    groupoTipoDePagamento.setText("Pagamento");
	    groupoTipoDePagamento.setBounds(558, 187, 127, 70);
	    groupoTipoDePagamento.setVisible(false);
		Button butaoRadioDinheiro = new Button(groupoTipoDePagamento, SWT.RADIO);
		butaoRadioDinheiro.setBounds(25, 21, 92, 19);
		butaoRadioDinheiro.setText("Dinheiro");
		butaoRadioDinheiro.setSelection(true);
		butaoRadioDinheiro.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				caixaParaNumCartao.setVisible(false);
				lblNumeroDoCarto.setVisible(false);
				caixaParaPIN.setVisible(false);
				lblPIN.setVisible(false);
			}
		});
		Button butaoRadioCartao = new Button(groupoTipoDePagamento, SWT.RADIO);
		butaoRadioCartao.setBounds(25, 42, 92, 19);
		butaoRadioCartao.setText("Cart\u00E3o");
		butaoRadioCartao.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				caixaParaNumCartao.setVisible(true);
				lblNumeroDoCarto.setVisible(true);
				caixaParaPIN.setVisible(true);
				lblPIN.setVisible(true);
			}
		});
		

		Button botaoFinalizarCarrinho = new Button(shell, SWT.NONE);
		botaoFinalizarCarrinho.setBounds(574, 422, 127, 30);
		botaoFinalizarCarrinho.setText("Finalizar Carrinho");
		botaoFinalizarCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				// se carrinho estiver vazio, não avançar e mostrar mensagem de carrinho vazio
				if ( carrinho.livros.isEmpty() ) {
					lblCarrinhoVazio.setVisible(true);
					lblSelecionarLivro.setVisible(false);
				}
				else {
					caixaParaNIF.setVisible(true);
					lblNIF.setVisible(true);
					lblIntroduzaNIF.setVisible(true);
					groupoTipoDePagamento.setVisible(true);
					lblMensagemParaPIN.setVisible(false);
					lblMensagemNumCartao.setVisible(false);
					//guardar NIF introduzido na caixa de NIF
					String nifIntroduzido = caixaParaNIF.getText();
					String pinIntroduzido = caixaParaPIN.getText();
					String numCartaoIntroduzido = caixaParaNumCartao.getText();
					//Se não tiver intoduzido nenhum texto nada na caixa de NIF, não fazer nada
					if ( nifIntroduzido.equals("")) {
					}
					//Se tiver introduzido algum texto na caixa de NIF
					else {
						//Se o texto introduzido for um NIF -> verificar se tipo de pagamento é cartão ou dinheiro
						if ( livraria.verificarSeNIFouCartao(nifIntroduzido)==true ) {
							lblIntroduzaNIF.setVisible(false);
							//caso seja pagamento em dinheiro -> criar nova compra e abrir janela/mensagem de compra submetida
							if ( butaoRadioDinheiro.isEnabled() ) {
								//criar nova compra e adicionar à livraria
								Compra novaCompra = new Compra
										(livraria.gerarNovoNumCompra(), carrinho, nifIntroduzido, new GregorianCalendar(), Compra.Estado.SUBMETIDA);
								livraria.getCompras().add(novaCompra);
//								
//								
//								IMPRESSÃO DE VERIFICAÇÃO PARA APAGAR + TARDE
//								
								System.out.println("LIVRARIA APÓS CONCLUSÃO DA COMPRA:" + livraria.getCompras());
								//fechar janela corrente
								shell.close();
								//abrir janela de mensagem de compra submetida
								J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida(""
										+ "Compra submetida com sucesso","Aguarde/solicite confirmação de um vendedor");
								janela.open();
								//voltar à janela inicial
								J_00Inicial janelaInicial = new J_00Inicial(livraria);
								janelaInicial.open();
							}
							//caso seja pagamento com cartão -> verificar pin e número de cartão
							//e se corretos criar nova compraCartao e abrir janela/mensagem de compra submetida
							else {
								//Se PIN incorreto, mostrar mensagem de erro de pin
								if ( livraria.verificarSePIN(pinIntroduzido)==false ) {
									lblMensagemParaPIN.setVisible(true);
								}
								//Se Num de cartão incorreto, mostrar mensagem de erro de número de cartão
								if ( livraria.verificarSeNIFouCartao(numCartaoIntroduzido)==false ) {
									lblMensagemNumCartao.setVisible(true);
								}
								//Se pin e num cartão corretos
								else if ( livraria.verificarSePIN(pinIntroduzido)==true && 
										livraria.verificarSeNIFouCartao(numCartaoIntroduzido)==true) {
									//criar nova compra e adicionar à livraria
									CompraCartao novaCompra2 = new CompraCartao	(livraria.gerarNovoNumCompra(), 
											carrinho, nifIntroduzido, new GregorianCalendar(), Compra.Estado.SUBMETIDA, 
											numCartaoIntroduzido, pinIntroduzido);
									livraria.getCompras().add(novaCompra2);
//									
//									
//									IMPRESSÃO DE VERIFICAÇÃO PARA APAGAR + TARDE
//									
									System.out.println("LIVRARIA APÓS CONCLUSÃO DA COMPRA:" + livraria.getCompras());
									//fechar janela corrente
									shell.close();
									//abrir janela de mensagem de compra submetida
									J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida(""
											+ "Compra submetida com sucesso","Aguarde/solicite confirmação de um vendedor");
									janela.open();
									//voltar à janela inicial
									J_00Inicial janelaInicial = new J_00Inicial(livraria);
									janelaInicial.open();
								}
								
							}
						}
						//Se o texto introduzido não for um NIF -> visualizar mensagem de NIF incorreto
						else {
							lblIntroduzaNIF.setText("NIF incorreto (9 dígitos)");
							lblIntroduzaNIF.setVisible(true);
						}
					}
				}
				
			}
		});
		
		
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
					lblSelecionarLivro.setVisible(true);
				}
				//Verificar se livro tem stock e eventualmente escrever mensagem de falta de stock
				else if (livroSelecionado.stock <= 0) {
					//tornar visivel mensagem de falta de stock
					lblSemStock.setVisible(true);
				}
				//caso em que há stock, actualiza-se carrinho e actualiza-se a tabela
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
				//Se nenhum item da tabela estiver selecionado mostrar mensagem para selecionar
				if (livroSelecionado==null ) {
					lblSelecionarLivro.setVisible(true);
				}
				// se carrinho já foi esvaziado, não fazer nada
				if ( !carrinho.livros.contains(livroSelecionado)) {
					
				}
				//reduzir quantidade de livros
				else {
					livraria.removerLivroDoCarrinho(livroSelecionado, carrinho);
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
