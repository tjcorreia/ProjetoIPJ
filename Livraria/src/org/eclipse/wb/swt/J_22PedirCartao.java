package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.GregorianCalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_22PedirCartao {

	protected Shell shlPedirCartao;
	private Text caixaNumCartao;
	private Text caixaPin;
	protected Livraria livraria;
	protected Compra compraSelecionada;

	

	//Construtor para abrir uma nova janela deste tipo
	public J_22PedirCartao(Livraria livraria, Compra compra) {
		this.livraria = livraria;
		compraSelecionada = compra;
		open();
	}	

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			J_03CompraSubmetida window = new J_03CompraSubmetida();
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
		shlPedirCartao.open();
		shlPedirCartao.layout();
		while (!shlPedirCartao.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPedirCartao = new Shell();
		shlPedirCartao.setSize(450, 300);
		shlPedirCartao.setText("Dados Cart\u00E3o");
		
		Label lblNumCartao = new Label(shlPedirCartao, SWT.NONE);
		lblNumCartao.setAlignment(SWT.RIGHT);
		lblNumCartao.setText("N\u00FAmero do cart\u00E3o");
		lblNumCartao.setBounds(32, 70, 136, 20);
		
		Label lblPIN = new Label(shlPedirCartao, SWT.NONE);
		lblPIN.setAlignment(SWT.RIGHT);
		lblPIN.setText("PIN");
		lblPIN.setBounds(32, 121, 136, 20);
		
		Label lblIntroduzaDadosDo = new Label(shlPedirCartao, SWT.NONE);
		lblIntroduzaDadosDo.setText("INTRODUZA DADOS DO CART\u00C3O");
		lblIntroduzaDadosDo.setAlignment(SWT.RIGHT);
		lblIntroduzaDadosDo.setBounds(93, 24, 232, 20);
		
		Label lblCartaoIncorreto = new Label(shlPedirCartao, SWT.NONE);
		lblCartaoIncorreto.setVisible(false);
		lblCartaoIncorreto.setText("N\u00FAmero incorreto (9 d\u00EDgitos)");
		lblCartaoIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblCartaoIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblCartaoIncorreto.setBounds(174, 97, 127, 20);
		
		Label lblPinIncorreto = new Label(shlPedirCartao, SWT.NONE);
		lblPinIncorreto.setVisible(false);
		lblPinIncorreto.setText("PIN incorreto (3 d\u00EDgitos)");
		lblPinIncorreto.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblPinIncorreto.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblPinIncorreto.setBounds(174, 149, 127, 20);
		
		caixaNumCartao = new Text(shlPedirCartao, SWT.BORDER);
		caixaNumCartao.setBounds(174, 70, 162, 26);

		caixaPin = new Text(shlPedirCartao, SWT.BORDER);
		caixaPin.setBounds(174, 121, 162, 26);

		Button btnConfirmar = new Button(shlPedirCartao, SWT.NONE);
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String numCartaoIntroduzido = caixaNumCartao.getText();
				String pinIntroduzido = caixaPin.getText();
				lblCartaoIncorreto.setVisible(false);
				lblPinIncorreto.setVisible(false);
				//verificar pin e número de cartão
				//Se Num de cartão incorreto, mostrar mensagem de erro de número de cartão
				if ( livraria.verificarSeNIFouCartao(numCartaoIntroduzido)==false ) {
					lblCartaoIncorreto.setVisible(true);
				}
				//Se PIN incorreto, mostrar mensagem de erro de pin
				if ( livraria.verificarSePIN(pinIntroduzido)==false ) {
					lblPinIncorreto.setVisible(true);
				}
				//Se pin e num cartão corretos
				if ( livraria.verificarSePIN(pinIntroduzido)==true && 
						livraria.verificarSeNIFouCartao(numCartaoIntroduzido)==true) {
					//criar nova compra cartao e adicionar à livraria
					CompraCartao novaCompra = new CompraCartao( compraSelecionada.getNumCompra(), compraSelecionada.getCarrinho(), 
							compraSelecionada.getNif(), compraSelecionada.getData(), compraSelecionada.getEstadoCompra(),
							numCartaoIntroduzido, pinIntroduzido);
					livraria.getCompras().add(novaCompra);
					livraria.getCompras().remove(compraSelecionada);
					compraSelecionada = novaCompra;
					//fechar janela actual
					shlPedirCartao.close();
					//abrir janela/mensagem de compra submetida
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("Alteração de venda a dinheiro para cartão", 
							"submetida com sucesso");
					janela.open();
					
				}
			}
		});
		btnConfirmar.setText("OK");
		btnConfirmar.setBounds(125, 175, 90, 30);
		
		Button btnCancelar = new Button(shlPedirCartao, SWT.NONE);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlPedirCartao.close();
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(235, 175, 90, 30);
		
		
		
		

	}
}
