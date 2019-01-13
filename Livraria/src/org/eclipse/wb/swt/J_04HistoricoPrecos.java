package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;


import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
@SuppressWarnings("serial")
public class J_04HistoricoPrecos implements Serializable {
	/**
	 * Atributos da classe
	 */
	protected Shell shlDetalhesLivro;
	protected Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	protected Livro livroSelecionado;//atributo que nos dá o livro que está selecionado na table
	private Label lblTitulo;
	private Label lblAutor;
	private Label lblEditora;
	private Label lblPreco;
	private Label lblTitulo2;
	private Label lblAutor2;
	private Label lblEditora2;
	private Label lblPreco2;
	private Table table;
	private TableColumn tblclmnData;
	private TableColumn tblclmnPreco;
	private Label lblHistoricoPrecos;
	
	/**
	 * Construtor que traz Livraria e o livro selecionado
	 */
	public J_04HistoricoPrecos(Livraria livraria, Livro livroSelecionado) {
		//super();
		this.livraria = livraria;
		this.livroSelecionado = livroSelecionado;
	}	

	/**
	 * Abrir a janela
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDetalhesLivro.open();
		shlDetalhesLivro.layout();
		while (!shlDetalhesLivro.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Criar conteúdos da janela
	 */
	protected void createContents() {
		shlDetalhesLivro = new Shell();
		shlDetalhesLivro.setSize(730, 542);
		shlDetalhesLivro.setText("View Comics - Hist\u00F3rico de pre\u00E7os");
		
		Label lblTituloHistoricoPrecos = new Label(shlDetalhesLivro, SWT.NONE);
		lblTituloHistoricoPrecos.setText("HIST\u00D3RICO DE PRE\u00C7OS");
		lblTituloHistoricoPrecos.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTituloHistoricoPrecos.setBounds(10, 10, 229, 38);
		
		Button btnFechar = new Button(shlDetalhesLivro, SWT.NONE);
		btnFechar.setText("Fechar");
		btnFechar.setBounds(598, 457, 104, 28);
		btnFechar.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela atual
				shlDetalhesLivro.close();
			}
		});

		lblTitulo = new Label(shlDetalhesLivro, SWT.NONE);
		lblTitulo.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblTitulo.setAlignment(SWT.RIGHT);
		lblTitulo.setBounds(184, 65, 70, 20);
		lblTitulo.setText("T\u00EDtulo:");
		
		lblAutor = new Label(shlDetalhesLivro, SWT.NONE);
		lblAutor.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblAutor.setText("Autor:");
		lblAutor.setAlignment(SWT.RIGHT);
		lblAutor.setBounds(184, 115, 70, 20);
		
		lblEditora = new Label(shlDetalhesLivro, SWT.NONE);
		lblEditora.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblEditora.setText("Editora:");
		lblEditora.setAlignment(SWT.RIGHT);
		lblEditora.setBounds(184, 165, 70, 20);
		
		lblPreco = new Label(shlDetalhesLivro, SWT.NONE);
		lblPreco.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPreco.setText("Pre\u00E7o (\u20AC):");
		lblPreco.setAlignment(SWT.RIGHT);
		lblPreco.setBounds(184, 215, 70, 20);
		
		lblTitulo2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblTitulo2.setBounds(273, 65, 429, 44);
		
		lblAutor2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblAutor2.setBounds(273, 115, 429, 44);
		
		lblEditora2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblEditora2.setBounds(273, 165, 429, 44);
		
		lblPreco2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblPreco2.setBounds(273, 215, 429, 44);
		
		table = new Table(shlDetalhesLivro, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(184, 282, 235, 150);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnData = new TableColumn(table, SWT.CENTER);
		tblclmnData.setWidth(130);
		tblclmnData.setText("Data");
		
		tblclmnPreco = new TableColumn(table, SWT.CENTER);
		tblclmnPreco.setWidth(100);
		tblclmnPreco.setText("Pre\u00E7o");
		
		lblHistoricoPrecos = new Label(shlDetalhesLivro, SWT.NONE);
		lblHistoricoPrecos.setAlignment(SWT.CENTER);
		lblHistoricoPrecos.setText("Hist\u00F3tico de pre\u00E7os");
		lblHistoricoPrecos.setBounds(184, 256, 235, 20);
		
		preencherDadosLivro();
		preencherTabela();
	}
	
	/**
	 * Método para limpar e preencher novamente a tabela
	 */
	public void preencherTabela() {
		//limpar tabela
		table.removeAll();
		//adicionar um a um os preços do livro à table
		for (GregorianCalendar gc : livroSelecionado.precosAnteriores.keySet() ) {
		      TableItem item = new TableItem(table, SWT.NONE);
		      item.setText(0, ""+ gc.get(Calendar.YEAR) + "/" + ((gc.get(Calendar.MONTH)) + 1) + "/"
						+ gc.get(Calendar.DAY_OF_MONTH));
		      item.setText(1, "" + livroSelecionado.getPrecosAnteriores().get(gc) + "€" );
		}
		table.redraw();	
	}	

	/**
	 * Método para preencher as caixas de alteração de dados de livro, com os dados do livro selecionado
	 */
	public void preencherDadosLivro() {
		lblTitulo2.setText(livroSelecionado.nome);
		lblAutor2.setText(livroSelecionado.autor);
		lblEditora2.setText(livroSelecionado.editora);
		lblPreco2.setText(String.valueOf(livroSelecionado.preco) + "€");
	}	
}
