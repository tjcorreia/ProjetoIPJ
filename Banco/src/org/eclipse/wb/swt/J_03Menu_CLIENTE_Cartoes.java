package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.widgets.DateTime;
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
public class J_03Menu_CLIENTE_Cartoes {

	protected Shell shlMenu;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Conta contaActual;
	private Text Funcionario;
	private Label lbl_Imagem;
	private Button Fazer;
	private Table table;

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
	public J_03Menu_CLIENTE_Cartoes() {
		super();
		open();
	}

	public J_03Menu_CLIENTE_Cartoes(Gestao gestor, Utilizador uUtilizador) {
		super();
		this.uUtilizador = uUtilizador;
		this.gestor = gestor;
		this.clienteActual = (Cliente) uUtilizador;

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
				(Image) SWTResourceManager.getImage(J_03Menu_CLIENTE_Cartoes.class, "/Logo/Java-logo-png Logo.png"));
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
				shlMenu.dispose();
				J_03Menu_CLIENTE_contas lclientes=new J_03Menu_CLIENTE_contas(gestor,uUtilizador);
				lclientes.open();

			}
		});
		btnExibirContas.setText("Exibir Contas");
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
		
		btnCartesDaConta.setText("Cart\u00F5es da Conta");
		btnCartesDaConta.setBounds(10, 143, 192, 25);

		Image image2 = (Image) SWTResourceManager.getImage(J_03Menu_CLIENTE_Cartoes.class,
				"/Logo/Java-logo-png Logo13.png");

		Label lblimagem = new Label(shlMenu, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shlMenu, image2, lblimagem.getBounds().width, lblimagem.getBounds().height));

		Composite composite = new Composite(shlMenu, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 441, 371);

		ScrolledComposite scrolledComposite = new ScrolledComposite(composite, SWT.NONE);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setBounds(23, 69, 392, 141);

		table = new Table(scrolledComposite, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		table.setHeaderBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));

		TableColumn tblclmnConta = new TableColumn(table, SWT.CENTER);
		tblclmnConta.setWidth(100);
		tblclmnConta.setText("Conta");

		TableColumn tblclmnCartaoid = new TableColumn(table, SWT.CENTER);
		tblclmnCartaoid.setWidth(89);
		tblclmnCartaoid.setText("CartaoID");

		TableColumn tblclmnValidade = new TableColumn(table, SWT.CENTER);
		tblclmnValidade.setWidth(100);
		tblclmnValidade.setText("Validade");

		TableColumn tblclmnPin = new TableColumn(table, SWT.CENTER);
		tblclmnPin.setWidth(97);
		tblclmnPin.setText("PIN");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		Label lblCartes = new Label(composite, SWT.NONE);
		lblCartes.setText("Cart\u00F5es");
		lblCartes.setAlignment(SWT.CENTER);
		lblCartes.setBounds(0, 10, 441, 15);

		Label lblListaDeCartes = new Label(composite, SWT.CENTER);
		lblListaDeCartes.setText("Lista de Cart\u00F5es");
		lblListaDeCartes.setBounds(0, 48, 441, 15);

		// cria lista de contas e associa ao Combobox
		if (!(clienteActual.getLcontaSC().size() == 0)) {
			String[] listaContas = new String[clienteActual.getLcontaSC().size()];
			System.out.println("<---- lista de contas --->\n" + clienteActual.getLcontaSC().size());
			for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
				System.out.println("<---- ontas --->/n" + i);
				TableItem item = new TableItem(table, SWT.NULL);
				if (clienteActual.getLcontaSC().get(i) instanceof ContaPrazo) {
					// não faz nada
					System.out.println("<---- Contas Prazo--->" + i);
				} else {
					ContaNormal contaaVer=(ContaNormal) clienteActual.getLcontaSC().get(i);
					if (contaaVer.getAbertaFechada().equals(Conta.TipoC.ENCERADA)) {
						System.out.println("<---- Contas ENCERRADA--->" + i);
					} else {
						System.out.println("<---- Contas Normal--->" + i);
						item.setText(0, ("" + contaaVer.getContaID()));

						if (contaaVer.getListaCartoesC().size()==0) {
							System.out.println("<---- Contas Normal s/cartões--->" + i);
//								text_cartaoAssociado.setText("Não tem cartão associado");
							item.setText(1, (""));
							item.setText(2, (""));
							item.setText(3, (""));

						} else {
							if (!(contaaVer.procuraCartaoCTitular(uUtilizador.getuID())==null)){
							String texoID = "" + (contaaVer.procuraCartaoCTitular(uUtilizador.getuID())
									.getCartaoID());
							String texoValidade = "" + (contaaVer.procuraCartaoCTitular(uUtilizador.getuID())
									.getDataV());
							String texoPin = "" + (contaaVer.procuraCartaoCTitular(uUtilizador.getuID())
									.getCodigo());
							item.setText(1, (texoID ));
							item.setText(2, (texoValidade));
							item.setText(3, (texoPin));
							}

						}

					}

					

				}
			}

		}

	}

}
