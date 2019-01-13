package org.eclipse.wb.swt;
import org.eclipse.swt.widgets.Display;


import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;


import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Link;


/**
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_00Inicial implements Serializable {

	protected Shell shlViewComicsInc;
	protected String stringProcurada;
	protected ArrayList <Livro> listaLivrosDaBusca;
	protected Livraria livraria;//atributo adicionado para poder ir buscar métodos à livraria
	private Text caixaDeBusca;


	//Construtor que traz Livraria para esta classe
	public J_00Inicial(Livraria livraria) {
		stringProcurada="";
		this.livraria=livraria;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlViewComicsInc.open();
		shlViewComicsInc.layout();
		while (!shlViewComicsInc.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlViewComicsInc = new Shell();
		shlViewComicsInc.setSize(466, 327);
		shlViewComicsInc.setText("View Comics Inc.");
		
		Label lblViewComicsInc = new Label(shlViewComicsInc, SWT.NONE);
		lblViewComicsInc.setAlignment(SWT.CENTER);
		lblViewComicsInc.setFont(SWTResourceManager.getFont("Segoe Print", 13, SWT.NORMAL));
		lblViewComicsInc.setBounds(80, 73, 267, 46);
		lblViewComicsInc.setText("View Comics Inc.");
		
		//Label com mensagem de livro não encontrado que aparece quando procura retorna uma lista vazia de livros
		Label MensagemSemCorrespondencias = new Label(shlViewComicsInc, SWT.NONE);
		MensagemSemCorrespondencias.setText("Não existem correspondências. Tente novamente");
		MensagemSemCorrespondencias.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		MensagemSemCorrespondencias.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		MensagemSemCorrespondencias.setBounds(32, 121, 236, 20);
		MensagemSemCorrespondencias.setVisible(false);
		
		//Caixa para introdução de texto a pesquisar
		caixaDeBusca = new Text(shlViewComicsInc, SWT.BORDER);
		caixaDeBusca.setBounds(21, 134, 227, 26);
		
		//Listner para botão 'pesquisar livro'
		Button btnPesquisarLivro = new Button(shlViewComicsInc, SWT.NONE);
		btnPesquisarLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				livraria.saveAll();
				//Passar para 'stringProcurada' o texto introduzido na caixa de texto
				stringProcurada = caixaDeBusca.getText();
				//Chamar método 'procurarLivro' para a string introduzida
				listaLivrosDaBusca = livraria.procurarLivro(stringProcurada);
				//Caso lista de livros não tenha resultados apresentar mensagem de procura vazia
				if ( listaLivrosDaBusca.isEmpty() ) {
					MensagemSemCorrespondencias.setVisible(true);  
				}
				//caso lista tenha livros
				else {
					//Fechar janela de busca corrente
					shlViewComicsInc.close();
					//Abrir nova janela de ListaLivros, passando-lhe a lista de livros que correspondem à procura
					//J_01ListaLivros janelaListaLivros = new J_01ListaLivros(listaLivrosDaBusca);
					System.out.println("criou janela");
					J_01ListaLivros janelaListaLivros = new J_01ListaLivros(livraria, listaLivrosDaBusca, stringProcurada);
					System.out.println("criou janela");
					janelaListaLivros.open();
				}
				
			}
		});
		btnPesquisarLivro.setBounds(260, 134, 167, 25);
		btnPesquisarLivro.setText("Pesquisar/Comprar Livro");
		
		Link linkAdmin = new Link(shlViewComicsInc, SWT.NONE);
		linkAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				livraria.saveAll();
				//Fechar janela de busca corrente
				shlViewComicsInc.close();
				//Abrir nova janela de login
				J_10Login janelaLogin = new J_10Login(livraria);
				janelaLogin.open();
			}
		});
		linkAdmin.setBounds(10, 250, 80, 20);
		linkAdmin.setText("<a>Admin</a>");
		
		
	}
}