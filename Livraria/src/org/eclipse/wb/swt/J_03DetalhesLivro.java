package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.CCombo;

/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_03DetalhesLivro {

	protected Shell shlDetalhesLivro;
	protected Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	protected Livro livroSelecionado;//atributo que nos dá o livro que está selecionado na table
	private Label lblTitulo;
	private Label lblIsbn;
	private Label lblAutor;
	private Label lblEditora;
	private Label lblDescricao;
	private Label lblData;
	private Label lblPreco;
	private Label lblStock;
	private Label lblTitulo2;
	private Label lblIsbn2;
	private Label lblAutor2;
	private Label lblEditora2;
	private Label lblPreco2;
	private Label lblStock2;
	private Label lblData2;
	private Label lblDescricao2;
	
	
	
	
	//Construtor para poder trazer a Livraria e o utilizador para esta classe
	public J_03DetalhesLivro(Livraria livraria, Livro livroSelecionado) {
		//super();
		this.livraria = livraria;
		this.livroSelecionado = livroSelecionado;
		open();
	}	
	


	/**
	 * Open the window.
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
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDetalhesLivro = new Shell();
		shlDetalhesLivro.setSize(730, 542);
		shlDetalhesLivro.setText("View Comics - Detalhes Livro");
		
		
		
		/**
		 *
		 * 
		 * 
		 */
		Label lblMenuAdministrador = new Label(shlDetalhesLivro, SWT.NONE);
		lblMenuAdministrador.setText("DETALHES DO LIVRO");
		lblMenuAdministrador.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblMenuAdministrador.setBounds(10, 10, 229, 38);
		

		Button btnFechar = new Button(shlDetalhesLivro, SWT.NONE);
		btnFechar.setText("Fechar");
		btnFechar.setBounds(598, 457, 104, 28);
		btnFechar.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				//comando para fechar a janela atual
				shlDetalhesLivro.close();
			}
		});

		
		
		/**
		 *
		 * 
		 * 
		 */
		lblTitulo = new Label(shlDetalhesLivro, SWT.NONE);
		lblTitulo.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblTitulo.setAlignment(SWT.RIGHT);
		lblTitulo.setBounds(184, 65, 70, 20);
		lblTitulo.setText("T\u00EDtulo:");
		
		lblIsbn = new Label(shlDetalhesLivro, SWT.NONE);
		lblIsbn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblIsbn.setAlignment(SWT.RIGHT);
		lblIsbn.setText("ISBN:");
		lblIsbn.setBounds(184, 115, 70, 20);
		
		lblAutor = new Label(shlDetalhesLivro, SWT.NONE);
		lblAutor.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblAutor.setText("Autor:");
		lblAutor.setAlignment(SWT.RIGHT);
		lblAutor.setBounds(184, 165, 70, 20);
		
		lblEditora = new Label(shlDetalhesLivro, SWT.NONE);
		lblEditora.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblEditora.setText("Editora:");
		lblEditora.setAlignment(SWT.RIGHT);
		lblEditora.setBounds(184, 215, 70, 20);
		
		lblPreco = new Label(shlDetalhesLivro, SWT.NONE);
		lblPreco.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPreco.setText("Pre\u00E7o (\u20AC):");
		lblPreco.setAlignment(SWT.RIGHT);
		lblPreco.setBounds(184, 265, 70, 20);
		
		lblStock = new Label(shlDetalhesLivro, SWT.NONE);
		lblStock.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblStock.setText("Stock:");
		lblStock.setAlignment(SWT.RIGHT);
		lblStock.setBounds(184, 315, 70, 20);
		
		lblData = new Label(shlDetalhesLivro, SWT.NONE);
		lblData.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblData.setText("Data:");
		lblData.setAlignment(SWT.RIGHT);
		lblData.setBounds(184, 365, 70, 20);
		
		lblDescricao = new Label(shlDetalhesLivro, SWT.NONE);
		lblDescricao.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblDescricao.setText("Descri\u00E7\u00E3o:");
		lblDescricao.setAlignment(SWT.RIGHT);
		lblDescricao.setBounds(184, 415, 70, 20);
		
		lblTitulo2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblTitulo2.setBounds(273, 65, 429, 44);
		
		lblIsbn2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblIsbn2.setBounds(273, 115, 429, 44);
		
		lblAutor2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblAutor2.setBounds(273, 165, 429, 44);
		
		lblEditora2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblEditora2.setBounds(273, 215, 429, 44);
		
		lblPreco2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblPreco2.setBounds(273, 265, 429, 44);
		
		lblStock2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblStock2.setBounds(273, 315, 429, 44);
		
		lblData2 = new Label(shlDetalhesLivro, SWT.NONE);
		lblData2.setBounds(273, 365, 429, 44);
		
		lblDescricao2 = new Label(shlDetalhesLivro, SWT.WRAP | SWT.LEFT);
		lblDescricao2.setBounds(273, 415, 261, 70);
		
		
		preencherDadosLivro();

	}

	
	/**
	 *
	 * Métodos fora do 'createContents()'
	 * 
	 */
	
	
	

	
	//Método para preencher as caixas de alteração de dados de livro, com os dados do livro selecionado
	public void preencherDadosLivro() {
		lblTitulo2.setText(livroSelecionado.nome);
		lblIsbn2.setText(livroSelecionado.isbn);
		lblAutor2.setText(livroSelecionado.autor);
		lblEditora2.setText(livroSelecionado.editora);
		lblPreco2.setText(String.valueOf(livroSelecionado.preco) + "€");
		lblStock2.setText( "" + livroSelecionado.stock);
		
		lblData2.setText("" + livroSelecionado.getData().get(Calendar.DAY_OF_MONTH) + "/" +
				(livroSelecionado.getData().get(Calendar.MONTH)-1) + "/" + livroSelecionado.getData().get(Calendar.YEAR));
		
		
		GridData data = new GridData(SWT.HORIZONTAL, SWT.TOP, true, false, 1, 1);
		lblDescricao2.setLayoutData(data);
		lblDescricao2.setText(livroSelecionado.descricao);
	}	

	
}
