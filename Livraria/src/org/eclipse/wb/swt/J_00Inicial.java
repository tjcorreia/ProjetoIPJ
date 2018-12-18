package org.eclipse.wb.swt;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;


import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;



public class J_00Inicial {

	protected Shell shlViewComicsInc;
	private Text text;
	private Livraria livraria;
	private Livro livro;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_00Inicial window = new J_00Inicial(new Livraria(), new Livro());
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public J_00Inicial(Livraria livraria, Livro livro) {
		super();
		this.livro = livro;
		this.livraria = livraria;
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
		lblViewComicsInc.setBounds(91, 28, 267, 46);
		lblViewComicsInc.setText("View Comics Inc.");
		
		Button btnNewButton = new Button(shlViewComicsInc, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(366, 247, 72, 23);
		btnNewButton.setText("Admin");
		
		
		// a��o ao clicar no bot�o pesquisar livro
		Button btnPesquisarLivro = new Button(shlViewComicsInc, SWT.NONE);
		btnPesquisarLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String s = text.getText();
				
				System.out.println(s);
				
				ArrayList <Livro> lvProcurados = livraria.procurarLivro(s);
				J_01ListaLivros janelaListaLivros = new J_01ListaLivros(lvProcurados);
				janelaListaLivros.open();
			}
		});
		btnPesquisarLivro.setBounds(271, 89, 167, 25);
		btnPesquisarLivro.setText("Pesquisar/Comprar Livro");
		
		text = new Text(shlViewComicsInc, SWT.BORDER);
		text.setBounds(32, 89, 227, 26);
		
		Label label = new Label(shlViewComicsInc, SWT.NONE);
		label.setText("Mensagem de erro");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		label.setBounds(32, 121, 150, 20);

	}
}