package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.Serializable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

/**
 * Classe do tipo janela, para pedir dados de cartao de d�bito
 * 
 * @author Tiago Correia
 * @author Alberto Machado
 * @sid 2019
 */
public class J_22PedirCartao  implements Serializable{
	/**
	 * Atributos da classe
	 */
	protected Shell shlPedirCartao;
	private Text caixaNumCartao;
	private Text caixaPin;
	protected Livraria livraria;
	protected Compra compraSelecionada;

	/**
	 * Construtor que traz Livraria e a compra que se encontrava selecionada na tabela anterior para esta classe
	 */
	public J_22PedirCartao(Livraria livraria, Compra compra) {
		this.livraria = livraria;
		compraSelecionada = compra;
	}	

	/**
	 * Abrir a janela
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
	 * Criar conte�dos da janela
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
				//verificar pin e n�mero de cart�o
				//Se Num de cart�o incorreto, mostrar mensagem de erro de n�mero de cart�o
				if ( livraria.verificarSeNIFouCartao(numCartaoIntroduzido)==false ) {
					lblCartaoIncorreto.setVisible(true);
				}
				//Se PIN incorreto, mostrar mensagem de erro de pin
				if ( livraria.verificarSePIN(pinIntroduzido)==false ) {
					lblPinIncorreto.setVisible(true);
				}
				//Se pin e num cart�o corretos
				if ( livraria.verificarSePIN(pinIntroduzido)==true && 
						livraria.verificarSeNIFouCartao(numCartaoIntroduzido)==true) {
					//criar nova compra cartao e adicionar � livraria
					CompraCartao novaCompra = new CompraCartao( compraSelecionada.getNumCompra(), compraSelecionada.getCarrinho(), 
							compraSelecionada.getNif(), compraSelecionada.getData(), compraSelecionada.getEstadoCompra(),
							numCartaoIntroduzido, pinIntroduzido);
					livraria.getCompras().add(novaCompra);
					livraria.getCompras().remove(compraSelecionada);
					livraria.saveAll();
					compraSelecionada = novaCompra;
					//fechar janela actual
					shlPedirCartao.close();
					//abrir janela/mensagem de compra submetida
					J_20AlteracaoSubmetida janela = new J_20AlteracaoSubmetida("Altera��o de venda a dinheiro para cart�o", 
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
