package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Transacao.TipoT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Breve descrição do código
 *
 * @sid 2019
 * @aid 1.1
 */
public class J_03Menu_CLIENTE_contas {

	protected Shell shlMenu;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Conta contaActual;
	private Text Funcionario;
	private Label lbl_Imagem;
	private Text text_IDconta;
	private Text text_2;
	private Table table;
	private Combo combo_EscolhaConta;
	private Text text_valordaTransferencia;
	private Text text_Contadestino;
	private Button Fazer;
	private Button Button_FazerTransferencia;

	public Button getButton_FazerTransferencia() {
		return Button_FazerTransferencia;
	}

	public void setButton_FazerTransferencia(Button button_FazerTransferencia) {
		Button_FazerTransferencia = button_FazerTransferencia;
	}

	public Conta getContaActual() {
		return contaActual;
	}

	public void setContaActual(Conta contaActual) {
		this.contaActual = contaActual;
	}

	public Button getFazer() {
		return Fazer;
	}

	public void setFazer(Button fazer) {
		Fazer = fazer;
	}

	public Label getLbl_Imagem() {
		return getLbl_Imagem();
	}

	public void setLbl_Imagem(Label lbl_Imagem) {
		this.lbl_Imagem = lbl_Imagem;
	}

	public Shell getShlMenuFuncionrio() {
		return shlMenu;
	}

	public void setShlMenuFuncionrio(Shell shlMenuFuncionrio) {
		this.shlMenu = shlMenuFuncionrio;
	}

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	public Utilizador getuUtilizador() {
		return uUtilizador;
	}

	public void setuUtilizador(Utilizador uUtilizador) {
		this.uUtilizador = uUtilizador;
	}

	public Text getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Text funcionario) {
		Funcionario = funcionario;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public J_03Menu_CLIENTE_contas() {
		super();
		open();
	}

	public J_03Menu_CLIENTE_contas(Gestao gestor, Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		clienteActual = (Cliente) uUtilizador;

	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMenu.open();
		shlMenu.layout();
		while (!shlMenu.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenu = new Shell();
		shlMenu.setTouchEnabled(true);
		shlMenu.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shlMenu.setImage(
				(Image) SWTResourceManager.getImage(J_03Menu_CLIENTE_contas.class, "/Logo/Java-logo-png Logo.png"));
		shlMenu.setSize(709, 530);
		shlMenu.setText("Menu Funcion\u00E1rio");

		Button btnAlterarDadosPessoais = new Button(shlMenu, SWT.NONE);
		btnAlterarDadosPessoais.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				shlMenu.dispose();
				J_03_Menu_CLIENTE_AlteraDados3 alteraDados = new J_03_Menu_CLIENTE_AlteraDados3(gestor, uUtilizador);
				alteraDados.open();

			}
		});
		btnAlterarDadosPessoais.setBounds(10, 84, 192, 25);
		btnAlterarDadosPessoais.setText("Dados Pessoais");

		Button btnExibirContas = new Button(shlMenu, SWT.NONE);
		btnExibirContas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

			}
		});
		btnExibirContas.setText(" Contas");
		btnExibirContas.setBounds(10, 112, 192, 25);

		Button button = new Button(shlMenu, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenu.dispose();

			}
		});
		button.setText("Log Out");
		button.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shlMenu, SWT.BORDER);
		Funcionario.setText("Bem Vindo " + uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);

		Button btnCartesDaConta = new Button(shlMenu, SWT.TOGGLE);
		btnCartesDaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlMenu.dispose();
				J_03Menu_CLIENTE_Cartoes editarconta = new J_03Menu_CLIENTE_Cartoes(gestor, uUtilizador);
				editarconta.open();

			}
		});
		btnCartesDaConta.setText("Cart\u00F5es da Conta");
		btnCartesDaConta.setBounds(10, 143, 192, 25);

		Image image2 = (Image) SWTResourceManager.getImage(J_03Menu_CLIENTE_contas.class,
				"/Logo/Java-logo-png Logo13.png");

		Label lblimagem = new Label(shlMenu, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shlMenu, image2, lblimagem.getBounds().width, lblimagem.getBounds().height));

		Composite composite = new Composite(shlMenu, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 371);

		ScrolledComposite scrolledComposite = new ScrolledComposite(composite, SWT.V_SCROLL);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setBounds(24, 106, 370, 141);

		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		table.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));

		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(43);
		tableColumn.setText("ID");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(73);
		tableColumn_1.setText("Data");

		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(105);
		tableColumn_2.setText("Tipo");

		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(70);
		tableColumn_3.setText("Movimento");

		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(73);
		tableColumn_4.setText("Saldo");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setMinSize(new Point(385, 45));

		combo_EscolhaConta = new Combo(composite, SWT.NONE);

		combo_EscolhaConta.setBounds(171, 59, 224, 23);

		text_IDconta = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_IDconta.setText("Indique o ID");
		text_IDconta.setBounds(343, 7, 88, 21);
		text_IDconta.setEditable(false);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Contas do Cliente");
		label.setAlignment(SWT.CENTER);
		label.setBounds(104, 10, 231, 15);

		Label label_1 = new Label(composite, SWT.CENTER);
		label_1.setText("Lista de Transa\u00E7\u00F5es");
		label_1.setBounds(23, 85, 372, 15);

		text_2 = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_2.setText("Selecione uma Conta");
		text_2.setBounds(24, 60, 147, 21);

		Button_FazerTransferencia = new Button(composite, SWT.NONE);

		Button_FazerTransferencia.setText("Transaferencia");
		Button_FazerTransferencia.setSelection(true);
		Button_FazerTransferencia.setEnabled(true);
		Button_FazerTransferencia.setBounds(24, 287, 142, 25);

		text_valordaTransferencia = new Text(composite, SWT.BORDER);
		text_valordaTransferencia.setBounds(172, 287, 93, 25);

		text_Contadestino = new Text(composite, SWT.BORDER);
		text_Contadestino.setBounds(271, 287, 123, 25);

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("ID Conta Destino");
		label_2.setAlignment(SWT.CENTER);
		label_2.setBounds(271, 271, 123, 15);

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("(valor)");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		label_3.setAlignment(SWT.CENTER);
		label_3.setBounds(172, 275, 93, 10);

		// cria lista de contas e associa ao Combobox
		if (!(clienteActual.getLcontaSC().size() == 0)) {
			String[] listaContas = new String[clienteActual.getLcontaSC().size()];
			System.out.println("<---- lista de contas --->/n" + clienteActual.getLcontaSC().size());
			for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
				if (clienteActual.getLcontaSC().get(i).getAbertaFechada().equals(Conta.TipoC.ENCERADA)) {
					listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID() + ("(ENCERRADA)");
				} else {
					if (clienteActual.getLcontaSC().get(i) instanceof ContaPrazo) {
						listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID() + ("(CONTA PRAZO)");
					} else {
						listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID();
					}
				}
			}
			System.out.println("<---- lista de contas --->/n" + listaContas.length);
			combo_EscolhaConta.setItems(listaContas);

		} else {
			combo_EscolhaConta.setItems("Não existem contas a apresentar");
		}

		// escolhe entre contas
		combo_EscolhaConta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				preencheTabela();
			}
		});

		Button_FazerTransferencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text_valordaTransferencia.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

				Conta contaFinal = null;

				gestor.TransferenciaCl(uUtilizador, shlMenu, contaActual, text_valordaTransferencia, text_Contadestino,
						contaFinal);
				preencheTabela();
				text_valordaTransferencia.setText("");

			}
		});

	}

	// metodo para preencher a tabela
	public void preencheTabela() {
		table.setEnabled(true);
		table.clearAll();
		table.removeAll();
		text_valordaTransferencia.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		int contaID = 0;
		if (combo_EscolhaConta.getText().contains("(ENCERRADA)")) {
			String textoConta = combo_EscolhaConta.getText();
			textoConta = textoConta.replace("(ENCERRADA)", "");
			System.out.println("<---- texto : " + textoConta);
			contaID = Integer.parseInt(textoConta);
		} else if (combo_EscolhaConta.getText().contains("(CONTA PRAZO)")) {
			String textoConta = combo_EscolhaConta.getText();
			textoConta = textoConta.replace("(CONTA PRAZO)", "");
			System.out.println("<---- texto : " + textoConta);
			contaID = Integer.parseInt(textoConta);
		} else {
			contaID = Integer.parseInt(combo_EscolhaConta.getText());
		}

		contaActual = clienteActual.procuraConta(contaID);
		text_IDconta.setText("" + contaActual.getContaID());
		System.out.println("<---- Conta Actual-Transaçoes ( " + contaActual.getTransacoesC().size() + ") --->\n");
		// saldo e calculado para cada transação
		double saldoI = contaActual.getSaldo();
		for (int i = contaActual.getTransacoesC().size() - 1; i >= 0; i--) {
			TableItem item = new TableItem(table, SWT.NULL);
			item.setText(0, ("" + contaActual.getTransacoesC().get(i).gettID()));
			item.setText(1, ("" + contaActual.getTransacoesC().get(i).getData()));
			// se for uma transferencia coloca o ID
			if (contaActual.getTransacoesC().get(i).getEscolhaT().equals(TipoT.TRANSFERENCIA)) {
				item.setText(2, ("TRF<" + contaActual.getTransacoesC().get(i).getContadestino()) + ">");
			} else {
				item.setText(2, ("" + contaActual.getTransacoesC().get(i).getEscolhaT()));
			}
			item.setText(3, ("" + contaActual.getTransacoesC().get(i).getValor()));
			item.setText(4, ("" + (saldoI)));
			saldoI = saldoI - contaActual.getTransacoesC().get(i).getValor();
		}
		if (combo_EscolhaConta.getText().contains("(ENCERRADA)")) {
			System.out.println("<---- ?????????? Bloqueia Botao");
			table.setEnabled(false);
		}
	}

}
