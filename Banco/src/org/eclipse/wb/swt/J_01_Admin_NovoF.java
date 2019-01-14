package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Utilizador.TipoID;

/**
* Breve descrição do código
* Janel de Administrador Cria Novo funcionario
* @author Alberto Jorge
* @author Tiago Correia
* @param 
* @sid 2019
* @aid 1.1
*/
public class J_01_Admin_NovoF {

	protected Shell shell;
	private Text text;
	private Utilizador uAdministrador;
	private Gestao gestor;
	private Text text_PrimeiroNovoF;
	private Text text_Morada_NovoF;
	private Text text_ValorID_NovoF;
	private Text text_Email_NovoF;
	private Text text_MobileNovoF;
	private Text text_UserNovoF;
	private Text text_PassNovoF;
	private Text text_PosicaoNovoF;
	private Text text_UltimoNovoF;
	private Text text_DataN_Ano;
	private Text text_DataN_mes;
	private Text text_DataN_dia;
	private Label lblimagem2 ;
	
	public Label getLblimagem2() {
		return lblimagem2;
	}

	public void setLblimagem2(Label lblimagem2) {
		this.lblimagem2 = lblimagem2;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Text getText_PrimeiroNovoF() {
		return text_PrimeiroNovoF;
	}

	public void setText_PrimeiroNovoF(Text text_PrimeiroNovoF) {
		this.text_PrimeiroNovoF = text_PrimeiroNovoF;
	}

	public Text getText_Morada_NovoF() {
		return text_Morada_NovoF;
	}

	public void setText_Morada_NovoF(Text text_Morada_NovoF) {
		this.text_Morada_NovoF = text_Morada_NovoF;
	}

	public Text getText_ValorID_NovoF() {
		return text_ValorID_NovoF;
	}

	public void setText_ValorID_NovoF(Text text_ValorID_NovoF) {
		this.text_ValorID_NovoF = text_ValorID_NovoF;
	}

	public Text getText_Email_NovoF() {
		return text_Email_NovoF;
	}

	public void setText_Email_NovoF(Text text_Email_NovoF) {
		this.text_Email_NovoF = text_Email_NovoF;
	}

	public Text getText_MobileNovoF() {
		return text_MobileNovoF;
	}

	public void setText_MobileNovoF(Text text_MobileNovoF) {
		this.text_MobileNovoF = text_MobileNovoF;
	}

	public Text getText_UserNovoF() {
		return text_UserNovoF;
	}

	public void setText_UserNovoF(Text text_UserNovoF) {
		this.text_UserNovoF = text_UserNovoF;
	}

	public Text getText_PassNovoF() {
		return text_PassNovoF;
	}

	public void setText_PassNovoF(Text text_PassNovoF) {
		this.text_PassNovoF = text_PassNovoF;
	}

	public Text getText_PosicaoNovoF() {
		return text_PosicaoNovoF;
	}

	public void setText_PosicaoNovoF(Text text_PosicaoNovoF) {
		this.text_PosicaoNovoF = text_PosicaoNovoF;
	}

	public Text getText_UltimoNovoF() {
		return text_UltimoNovoF;
	}

	public void setText_UltimoNovoF(Text text_UltimoNovoF) {
		this.text_UltimoNovoF = text_UltimoNovoF;
	}

	public Text getText_DataN_Ano() {
		return text_DataN_Ano;
	}

	public void setText_DataN_Ano(Text text_DataN_Ano) {
		this.text_DataN_Ano = text_DataN_Ano;
	}

	public Text getText_DataN_mes() {
		return text_DataN_mes;
	}

	public void setText_DataN_mes(Text text_DataN_mes) {
		this.text_DataN_mes = text_DataN_mes;
	}

	public Text getText_DataN_dia() {
		return text_DataN_dia;
	}

	public void setText_DataN_dia(Text text_DataN_dia) {
		this.text_DataN_dia = text_DataN_dia;
	}

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}

	public Utilizador getuAdministrador() {
		return uAdministrador;
	}

	public void setuAdministrador(Utilizador uAdministrador) {
		this.uAdministrador = uAdministrador;
	}

	public J_01_Admin_NovoF(Gestao gestor, Utilizador uAdministrador) {
		this.gestor = gestor;
		this.uAdministrador = uAdministrador;

		// TODO Auto-generated constructor stub
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_01_Admin_NovoF() {
		open();
		// TODO Auto-generated constructor stub
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(705, 453);
		shell.setTouchEnabled(true);
		shell.setText("MENU ADMINISTRADOR");
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shell.setImage((Image) SWTResourceManager.getImage(J_01_Admin_NovoF.class, "/Logo/Java-logo-png Logo.png"));

		text = new Text(shell, SWT.BORDER);
		text.setText("Bem Vindo " + uAdministrador.nome);
		text.setBounds(215, 16, 362, 25);

		Image image2 = ((Image) SWTResourceManager.getImage(J_01_Admin_NovoF.class, "/Logo/Java-logo-png Logo13.png"));
		
		lblimagem2 = new Label(shell, SWT.NONE);
		lblimagem2.setBounds(10, 10, 192, 68);
		lblimagem2.setImage(gestor.resize(this.shell,image2,lblimagem2.getBounds().width,lblimagem2.getBounds().height));
		
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(217, 73, 441, 301);

		composite.setVisible(true);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(10, 104, 70, 15);
		lblNewLabel.setText("Identifica\u00E7ao");

		Label Nome_novoF = new Label(composite, SWT.NONE);
		Nome_novoF.setBounds(10, 47, 55, 15);
		Nome_novoF.setText("Nome");

		text_PrimeiroNovoF = new Text(composite, SWT.BORDER);
		text_PrimeiroNovoF.setBounds(81, 44, 163, 21);

		Label lblMoradaNovoF = new Label(composite, SWT.NONE);
		lblMoradaNovoF.setText("Morada");
		lblMoradaNovoF.setBounds(10, 75, 55, 15);

		text_Morada_NovoF = new Text(composite, SWT.BORDER);
		text_Morada_NovoF.setBounds(81, 72, 339, 21);

		String[] comboB = { "Cartao Cidadao", "Passaporte" };
		Combo TipoID_NovoF = new Combo(composite, SWT.NONE);
		TipoID_NovoF.setItems(comboB);
		TipoID_NovoF.select(0);
		TipoID_NovoF.setBounds(81, 99, 121, 23);

		text_ValorID_NovoF = new Text(composite, SWT.BORDER);
		text_ValorID_NovoF.setBounds(208, 101, 212, 21);

		Label lblEmail_novoF = new Label(composite, SWT.NONE);
		lblEmail_novoF.setText("Email");
		lblEmail_novoF.setBounds(10, 131, 55, 15);

		text_Email_NovoF = new Text(composite, SWT.BORDER);
		text_Email_NovoF.setBounds(81, 128, 339, 21);

		Label lblContacto = new Label(composite, SWT.NONE);
		lblContacto.setText("Contacto");
		lblContacto.setBounds(10, 165, 55, 15);

		text_MobileNovoF = new Text(composite, SWT.BORDER);
		text_MobileNovoF.setBounds(81, 162, 88, 21);

		Label lblNomeDeUtilizador = new Label(composite, SWT.NONE);
		lblNomeDeUtilizador.setText("Utilizador");
		lblNomeDeUtilizador.setBounds(10, 192, 55, 15);

		text_UserNovoF = new Text(composite, SWT.BORDER);
		text_UserNovoF.setBounds(81, 189, 121, 21);

		Label lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setText("Password");
		lblPassword.setBounds(228, 192, 55, 15);

		text_PassNovoF = new Text(composite, SWT.BORDER);
		text_PassNovoF.setBounds(289, 189, 131, 21);

		Label Titulo_Novo_F = new Label(composite, SWT.NONE);
		Titulo_Novo_F.setAlignment(SWT.CENTER);
		Titulo_Novo_F.setBounds(81, 2, 322, 15);
		Titulo_Novo_F.setText("Dados do Novo Funcionario");

		Label lblPosio = new Label(composite, SWT.NONE);
		lblPosio.setText("Posi\u00E7\u00E3o");
		lblPosio.setBounds(10, 226, 55, 15);

		text_PosicaoNovoF = new Text(composite, SWT.BORDER);
		text_PosicaoNovoF.setBounds(81, 223, 88, 21);

		Button criarNovoF = new Button(composite, SWT.MULTI | SWT.WRAP | SWT.NONE);

		criarNovoF.setBounds(289, 233, 103, 58);
		criarNovoF.setText("Guardar\nNovo Funcionario");

		text_UltimoNovoF = new Text(composite, SWT.BORDER);
		text_UltimoNovoF.setBounds(250, 44, 170, 21);

		Label lblprimeiro = new Label(composite, SWT.NONE);
		lblprimeiro.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblprimeiro.setText("(primeiro)");
		lblprimeiro.setBounds(125, 29, 55, 15);

		Label lblultimo = new Label(composite, SWT.NONE);
		lblultimo.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		lblultimo.setText("(ultimo)");
		lblultimo.setBounds(302, 29, 55, 15);

		Label lblDataNas = new Label(composite, SWT.NONE);
		lblDataNas.setText("Data Nas.(aaaa/mm/dd)");
		lblDataNas.setBounds(175, 165, 132, 15);

		text_DataN_Ano = new Text(composite, SWT.BORDER);
		text_DataN_Ano.setBounds(313, 164, 40, 21);

		text_DataN_mes = new Text(composite, SWT.BORDER);
		text_DataN_mes.setBounds(363, 164, 23, 21);

		Label label = new Label(composite, SWT.NONE);
		label.setText("/");
		label.setBounds(355, 167, 8, 15);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("/");
		label_1.setBounds(387, 167, 8, 15);

		text_DataN_dia = new Text(composite, SWT.BORDER);
		text_DataN_dia.setBounds(395, 164, 23, 21);

		Button btnAlterarDadosPessoais = new Button(shell, SWT.NONE);
		btnAlterarDadosPessoais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_Admin_AlteraDados alteraDados=new J_01_Admin_AlteraDados(gestor,uAdministrador);
				alteraDados.open();
				
			}
		});
		btnAlterarDadosPessoais.setText("Alterar dados pessoais");
		btnAlterarDadosPessoais.setBounds(10, 157, 192, 25);

		Button button_Logout = new Button(shell, SWT.NONE);
		button_Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();	
			}
		});
		button_Logout.setText("Log Out");
		button_Logout.setBounds(583, 16, 75, 25);;;
		
		// JA_BT1.0 Botao Criar novo Funcionario.
		criarNovoF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String mensagem = "";
				boolean naohaDadosPorPreencher = true;
				// Verifica campos vazios
				if (Util.estaVazio(text_PrimeiroNovoF,text_UltimoNovoF,text_Morada_NovoF)
						|| Util.estaVazio(text_ValorID_NovoF,text_Email_NovoF,text_MobileNovoF)
						|| Util.estaVazio(text_DataN_Ano,text_DataN_mes,text_DataN_dia)
						|| Util.estaVazio(text_UserNovoF) || Util.estaVazio(text_PassNovoF)) {
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					Titulo_Novo_F.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					System.out.println("ENTROU NA VERIFICACAO DE CAMPOS VAZIOS");
					mensagem = mensagem + "Tem dados por preencher\n";
					naohaDadosPorPreencher = false;

				}

				if (TipoID_NovoF.getText().equals("Cartao Cidadao")&& !(Util.estaVazio(text_ValorID_NovoF))) {
					if (Util.eNumero(text_ValorID_NovoF) == -1) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº CC inválido .\n";
						System.out.println("VERIFICACAO DE numeros CC");
						naohaDadosPorPreencher = false;
					} else if (Util.eNumero(text_ValorID_NovoF) != 8 && Util.eNumero(text_ValorID_NovoF) != -1) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº Cartao Cidadao inválido\n";

						mensagem = mensagem + ".\n";
						System.out.println("VERIFICACAO DE CC");
						naohaDadosPorPreencher = false;
					}
				} else if (TipoID_NovoF.getText().equals("Passaporte")) {
					/// falta verificar tamanho de passaporte
					if (text_ValorID_NovoF.getText().length() < 8 || text_ValorID_NovoF.getText().length() > 10) {
						Titulo_Novo_F.setText("Dados por preencher ou inválidos");
						mensagem = mensagem + "Nº Passaporte inválido .\n";
						System.out.println("VERIFICACAO DE Passaporte");
						naohaDadosPorPreencher = false;
					}

				}
				
				
				if (!Util.validateData2(text_DataN_Ano,text_DataN_mes,text_DataN_dia) ) {
					System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoF.getText());
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Data de Nascimento inválida.\n";
					naohaDadosPorPreencher = false;

				}
				
				
				
				
				if (!Util.validateMobileNumber(text_MobileNovoF)) {
					System.out.println("VERIFICACAO DE Telemovel" + text_MobileNovoF.getText());
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Contacto inválido.\n";
					naohaDadosPorPreencher = false;

				}

				if (!Util.validateEmail(text_Email_NovoF)) {
					System.out.println("VERIFICACAO DE Email ->" + text_Email_NovoF.getText());
					Titulo_Novo_F.setText("Dados por preencher ou inválidos");
					mensagem = mensagem + "Email inválido.\n";
					naohaDadosPorPreencher = false;
				}

				if (naohaDadosPorPreencher) {
					TipoID escolhadaID = Funcionario.TipoID.PASSAPORTE;
					if (TipoID_NovoF.getText().equals("Passaporte")) {
						escolhadaID = Funcionario.TipoID.PASSAPORTE;
					} else {
						escolhadaID = Funcionario.TipoID.PASSAPORTE;
					}
					
									String verifica = gestor.verificanovoF(
							escolhadaID,text_ValorID_NovoF,text_Email_NovoF,text_UserNovoF,text_MobileNovoF);

									System.out.println(("VERIFICA? --->"+verifica));
									
					if (verifica.equals("")) {
					Funcionario f=new Funcionario();
					
					String dataStr = text_DataN_Ano.getText()+"/"+text_DataN_mes.getText()+"/"+text_DataN_dia.getText();
					gestor.addNovoF(text_UserNovoF.getText(),text_PassNovoF.getText(),
								text_PrimeiroNovoF.getText(),text_UltimoNovoF.getText(), dataStr,
								text_Morada_NovoF.getText(), escolhadaID,text_ValorID_NovoF.getText(),
								text_Email_NovoF.getText(),Integer.parseInt(text_MobileNovoF.getText()),
								text_PosicaoNovoF.getText());
						
						MessageBox box = new MessageBox(shell, SWT.MULTI);
					f=(Funcionario)(gestor.getMapUtilizadores().get(text_UserNovoF.getText()));
						box.setText("CONCLUSÃO");
						box.setMessage(" O Funcionario"+f.getNome()+" "
									+f.getSobrenome()+" foi adicionado\n"+
										"Morada:"+f.getMorada()+"\n"+
										""+f.escolhaID.toString()+":"+f.getValorID()+"\n"+
										"Email:"+f.getEmail()+"\n"+
										"Contacto:"+f.getMobile()+"\n"+
										"Data Nascimento:"+f.getDataNascimento()+"\n"+
										"Posição:"+f.getPosicao());
						box.open();
						System.out.println(("verifica"));
						gestor.saveAll();
					}
					else {
						System.out.println(("----> Nao verifica"));
						verifica="Dados por  inválidos:/n"+verifica;
						MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
						box.setText("ERRO");
						box.setMessage(verifica);
						box.open();	
					}
				} else {
					MessageBox box = new MessageBox(shell, SWT.MULTI | SWT.ICON_ERROR);
					box.setText("ERRO");
					box.setMessage(mensagem);
					box.open();
					naohaDadosPorPreencher = true;
				}
			}
		});
		Button Novo_Funcionario = new Button(shell, SWT.NONE);

		
		Novo_Funcionario.setText("Novo Funcionario");
		Novo_Funcionario.setBounds(10, 93, 192, 25);

// *****// JA_BT2.0 Botao para ver Lista de Cliente.
		Button Lista_Clientes = new Button(shell, SWT.NONE);
		Lista_Clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_01_AdminLClientes novaLista=new J_01_AdminLClientes(gestor,uAdministrador);
				novaLista.open();
			}
		});
		
		Lista_Clientes.setText("Lista de Clientes");
		Lista_Clientes.setBounds(10, 126, 192, 25);
		
		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				J_02Menu_F menuF=new J_02Menu_F(gestor,uAdministrador) ;
				menuF.open();
			}
		});
		button.setText("Menu Funcionario");
		button.setBounds(10, 188, 192, 25);

	}
}
