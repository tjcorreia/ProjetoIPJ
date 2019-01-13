package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.Serializable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
 * Classe do tipo janela que apresenta dois labels de mensagem que podem ser recebidas no seu construtoe
 * podendo por isso esta janela ser usada em diferentes casos
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
@SuppressWarnings("serial")
public class J_20AlteracaoSubmetida implements Serializable {
	/**
	 * Atributos da classe
	 */
	protected Shell shlSucesso;
	private String mensagem1;
	private String mensagem2;
	
	
	/**
	 * Construtor
	 */
	public J_20AlteracaoSubmetida(String s1, String s2) {
		mensagem1 = s1;
		mensagem2 = s2;
	}	


	/**
	 * Abrir a janela
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSucesso.open();
		shlSucesso.layout();
		while (!shlSucesso.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Criar conteúdos da janela
	 */
	protected void createContents() {
		shlSucesso = new Shell();
		shlSucesso.setSize(450, 300);
		shlSucesso.setText("Sucesso");
		
		Label lblMensagem1 = new Label(shlSucesso, SWT.NONE);
		lblMensagem1.setAlignment(SWT.CENTER);
		lblMensagem1.setText(mensagem1);
		lblMensagem1.setBounds(59, 89, 326, 20);
		
		Label lblMensagem2 = new Label(shlSucesso, SWT.NONE);
		lblMensagem2.setAlignment(SWT.CENTER);
		lblMensagem2.setText(mensagem2);
		lblMensagem2.setBounds(59, 115, 326, 20);
		
		Button button = new Button(shlSucesso, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				shlSucesso.close();
			}
		});
		button.setText("Fechar");
		button.setBounds(175, 175, 90, 30);
	}
}
