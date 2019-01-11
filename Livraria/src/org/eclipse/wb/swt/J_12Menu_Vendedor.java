package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_12Menu_Vendedor {

	protected Shell shlMenuVendedor;
	protected static Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	protected Utilizador utilizador;
	private Table table;
	
	//Construtor para poder trazer a Livraria para esta classe
	public J_12Menu_Vendedor (Livraria livraria, Utilizador utilizador) {
		//super();
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
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenuVendedor = new Shell();
		shlMenuVendedor.setSize(738, 544);
		shlMenuVendedor.setText("Menu Vendedor");
		
		Button btnValidarVenda = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnValidarVenda.setText("Validar\nVenda dinheiro");
		btnValidarVenda.setBounds(593, 109, 117, 61);
		
		
		Label lblMenuVendedor = new Label(shlMenuVendedor, SWT.NONE);
		lblMenuVendedor.setText("VENDAS");
		lblMenuVendedor.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuVendedor.setBounds(10, 10, 229, 31);
		
		Label lblNomeUtilizador = new Label(shlMenuVendedor, SWT.NONE);
		lblNomeUtilizador.setText("Bem-vindo " + utilizador.nome );
		lblNomeUtilizador.setAlignment(SWT.RIGHT);
		lblNomeUtilizador.setBounds(407, 10, 303, 21);
		
		Button btnVoltar = new Button(shlMenuVendedor, SWT.NONE);
		btnVoltar.setText("Voltar/Logout");
		btnVoltar.setBounds(606, 459, 104, 28);
		
		Button btnValidarVendaCartao = new Button(shlMenuVendedor, SWT.WRAP | SWT.NONE);
		btnValidarVendaCartao.setText("Pedir validação\nVenda cartão");
		btnValidarVendaCartao.setBounds(593, 234, 117, 61);
		
		Combo combo = new Combo(shlMenuVendedor, SWT.NONE);
		combo.setBounds(103, 47, 97, 28);
		
		Label lblFiltrar = new Label(shlMenuVendedor, SWT.NONE);
		lblFiltrar.setAlignment(SWT.RIGHT);
		lblFiltrar.setBounds(27, 50, 70, 20);
		lblFiltrar.setText("Filtrar");
		
		table = new Table(shlMenuVendedor, SWT.BORDER | SWT.FULL_SELECTION);
		
		table.setBounds(10, 83, 567, 387);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		String[] tituloColunas = { "Número", "Items", "NIF", "Data", "Total", "Estado" };
		for (int i = 0; i < tituloColunas.length; i++) {
		      TableColumn column = new TableColumn(table, SWT.NONE);
		      column.setText(tituloColunas[i]);
		}
		for (int i = 0; i < livraria.getCompras().size() ; i++) {
	        TableItem item = new TableItem(table, SWT.NONE);
	        item.setText(0, "x");
	        item.setText(1, "y");
	        item.setText(2, "!");
	        item.setText(3, "this stuff behaves the way I expect");
	        item.setText(4, "almost everywhere");
	        item.setText(5, "some.folder");
	    }  


	}
}
