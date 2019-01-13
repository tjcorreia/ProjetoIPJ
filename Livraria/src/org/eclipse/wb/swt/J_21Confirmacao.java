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
 * Classe 
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_21Confirmacao implements Serializable {

	protected Shell shlConfirmacao;
	private boolean confirmacao;
	private String mensagem1;
	private String mensagem2;

	
	
	public boolean isConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(boolean confirmacao) {
		this.confirmacao = confirmacao;
	}

	//Construtor para abrir uma nova janela deste tipo
	public J_21Confirmacao(String s1, String s2, boolean conf) {
		mensagem1= s1;
		mensagem2 = s2;
		this.confirmacao = confirmacao;
	}	



	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlConfirmacao.open();
		shlConfirmacao.layout();
		while (!shlConfirmacao.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConfirmacao = new Shell();
		shlConfirmacao.setSize(450, 300);
		shlConfirmacao.setText("Confirma\u00E7\u00E3o");
		
		Label lblMensagem1 = new Label(shlConfirmacao, SWT.NONE);
		lblMensagem1.setAlignment(SWT.CENTER);
		lblMensagem1.setText(mensagem1);
		lblMensagem1.setBounds(59, 89, 326, 20);
		
		Label lblMensagem2 = new Label(shlConfirmacao, SWT.NONE);
		lblMensagem2.setAlignment(SWT.CENTER);
		lblMensagem2.setText(mensagem2);
		lblMensagem2.setBounds(59, 115, 326, 20);
		
		Button btnConfirmar = new Button(shlConfirmacao, SWT.NONE);
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				confirmacao = true;
				shlConfirmacao.close();
			}
		});
		btnConfirmar.setText("OK");
		btnConfirmar.setBounds(125, 175, 90, 30);
		
		Button btnCancelar = new Button(shlConfirmacao, SWT.NONE);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				confirmacao = false;
				shlConfirmacao.close();
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(235, 175, 90, 30);

	}
	

}
