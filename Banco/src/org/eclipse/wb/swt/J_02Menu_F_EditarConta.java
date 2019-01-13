package org.eclipse.wb.swt;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Conta.TipoC;
import org.eclipse.wb.swt.Transacao.TipoT;

/**
 * Breve descrição do código 
 * Janela Funcionario para Editar as contas do Cliente
 *  
 * @author Alberto Jorge
 *
 */
public class J_02Menu_F_EditarConta {

	protected Shell shellMF_EditarC;
	private Gestao gestor;
	private Utilizador uUtilizador;
	private Cliente clienteActual;
	private Conta contaActual;
	private Conta contaFinal;
	private String[] listaClientes;
	private TipoT escolhaTA;
	private Text Funcionario;
	private Text txt_Indique_ID;
	private Text txtSelecioneUmaConta;
	private Text text_contaActual;
	private Combo combo_EscolhaConta;
	private Combo combo_titularesDaconta;
	private Text text_cartaoAssociado;
	private Text text_NovoTitular;
	private Button button_CriaCartao;
	private Button btnMenuadministrador;
	private Button button_EncerraConta;
	private Button btnAdicionarTitular;
	
	

	public Shell getShellMF_EditarC() {
		return shellMF_EditarC;
	}

	public void setShellMF_EditarC(Shell shellMF_EditarC) {
		this.shellMF_EditarC = shellMF_EditarC;
	}

	public String[] getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(String[] listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Text getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Text funcionario) {
		Funcionario = funcionario;
	}

	public Text getTxt_Indique_ID() {
		return txt_Indique_ID;
	}

	public void setTxt_Indique_ID(Text txt_Indique_ID) {
		this.txt_Indique_ID = txt_Indique_ID;
	}

	public Text getTxtSelecioneUmaConta() {
		return txtSelecioneUmaConta;
	}

	public void setTxtSelecioneUmaConta(Text txtSelecioneUmaConta) {
		this.txtSelecioneUmaConta = txtSelecioneUmaConta;
	}

	public Text getText_contaActual() {
		return text_contaActual;
	}

	public void setText_contaActual(Text text_contaActual) {
		this.text_contaActual = text_contaActual;
	}

	public Text getText_cartaoAssociado() {
		return text_cartaoAssociado;
	}

	public void setText_cartaoAssociado(Text text_cartaoAssociado) {
		this.text_cartaoAssociado = text_cartaoAssociado;
	}

	public Text getText_NovoTitular() {
		return text_NovoTitular;
	}

	public void setText_NovoTitular(Text text_NovoTitular) {
		this.text_NovoTitular = text_NovoTitular;
	}

	public Button getBtnMenuadministrador() {
		return btnMenuadministrador;
	}

	public void setBtnMenuadministrador(Button btnMenuadministrador) {
		this.btnMenuadministrador = btnMenuadministrador;
	}

	public Button getButton_EncerraConta() {
		return button_EncerraConta;
	}

	public void setButton_EncerraConta(Button button_EncerraConta) {
		this.button_EncerraConta = button_EncerraConta;
	}

	public Button getBtnAdicionarTitular() {
		return btnAdicionarTitular;
	}

	public void setBtnAdicionarTitular(Button btnAdicionarTitular) {
		this.btnAdicionarTitular = btnAdicionarTitular;
	}

	public Button getButton_CriaCartao() {
		return button_CriaCartao;
	}

	public void setButton_CriaCartao(Button button_CriaCartao) {
		this.button_CriaCartao = button_CriaCartao;
	}

	public Combo getCombo_titularesDaconta() {
		return combo_titularesDaconta;
	}

	public void setCombo_titularesDaconta(Combo combo_titularesDaconta) {
		this.combo_titularesDaconta = combo_titularesDaconta;
	}

	public Conta getContaFinal() {
		return contaFinal;
	}

	public void setContaFinal(Conta contaFinal) {
		this.contaFinal = contaFinal;
	}

	public TipoT getEscolhaTA() {
		return escolhaTA;
	}

	public void setEscolhaTA(TipoT escolhaTA) {
		this.escolhaTA = escolhaTA;
	}

	public Combo getCombo_EscolhaConta() {
		return combo_EscolhaConta;
	}

	public void setCombo_EscolhaConta(Combo combo_EscolhaConta) {
		this.combo_EscolhaConta = combo_EscolhaConta;
	}

	public Conta getContaActual() {
		return contaActual;
	}

	public void setContaActual(Conta contaActual) {
		this.contaActual = contaActual;
	}

	public Cliente getClienteActual() {
		return clienteActual;
	}

	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}

	public Utilizador getuUtilizador() {
		return uUtilizador;
	}

	public void setuUtilizador(Utilizador uUtilizador) {
		this.uUtilizador = uUtilizador;
	}

	public Gestao getGestor() {
		return gestor;
	}

	public void setGestor(Gestao gestor) {
		this.gestor = gestor;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public J_02Menu_F_EditarConta() {
		super();
		
		open();
	}
	public J_02Menu_F_EditarConta(Gestao gestor, Utilizador uUtilizador, Cliente clienteActual, Conta contaActual) {
		super();
		this.gestor = gestor;
		this.uUtilizador = uUtilizador;
		this.clienteActual = clienteActual;
		this.contaActual = contaActual;
		
	}

	/**
	 * Launch the application.
	 * 
	 */
//	public static void main(String[] args) {
//		try {
//			J_02Menu_F_MovimentaConta window = new J_02Menu_F_MovimentaConta(new Gestao(), new Utilizador(), new Cliente(),new Conta());
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
		shellMF_EditarC.open();
		shellMF_EditarC.layout();
		while (!shellMF_EditarC.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellMF_EditarC = new Shell();
		shellMF_EditarC.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
	
		
		shellMF_EditarC.setImage((Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo.png"));
		
		shellMF_EditarC.setSize(729, 545);
		shellMF_EditarC.setText("Menu Funcion\u00E1rio");
		
		Image image2 = (Image) SWTResourceManager.getImage(J_02Menu_F.class, "/Logo/Java-logo-png Logo13.png");
		image2.isAutoScalable();;
		Label lblimagem = new Label(shellMF_EditarC, SWT.NONE);
		lblimagem.setBounds(10, 10, 192, 68);
		lblimagem.setImage(gestor.resize(shellMF_EditarC,image2,lblimagem.getBounds().width,lblimagem.getBounds().height));

		System.out.println("<---- MENU MOVIMENTOS --->\n" + contaActual);
		System.out.println("<---- Utilizador Actual --->\n" + uUtilizador);
		System.out.println("<---- Cliente Actual --->\n" + clienteActual);
		System.out.println("<---- Conta Actual --->\n" + contaActual);

		Composite composite = new Composite(shellMF_EditarC, SWT.NONE);
		composite.setVisible(true);
		composite.setBounds(215, 84, 456, 400);

		combo_titularesDaconta = new Combo(composite, SWT.NONE);
		combo_titularesDaconta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_cartaoAssociado.setEnabled(true);
				int titularID = Integer.parseInt(combo_titularesDaconta.getText());
				if (uUtilizador instanceof Funcionario) {
				button_CriaCartao.setEnabled(true);
				}
				if (contaActual instanceof ContaPrazo) {
					text_cartaoAssociado.setText("Conta a Prazo");
				}
				else {
					System.out.println("<---- Conta actual --->\n" + contaActual);
					System.out.println("<---- ID --->\n" + titularID);
					System.out.println("<---- Cartao --->" + ((ContaNormal)contaActual).procuraCartaoCTitular(titularID)+"\n");
				if ( (((ContaNormal)contaActual).procuraCartaoCTitular(titularID))==null) {
					text_cartaoAssociado.setText("Não tem cartão associado");
				}
				else {
					System.out.println("<---- CartaoID --->\n" + ((ContaNormal)contaActual).procuraCartaoCTitular(titularID).getCartaoID());
				
					button_CriaCartao.setEnabled(false);
					text_cartaoAssociado.setText(""+((ContaNormal)contaActual).procuraCartaoCTitular(titularID).getCartaoID());
				}
				}
				text_cartaoAssociado.setEnabled(false);
			}
		});
		combo_titularesDaconta.setBounds(170, 253, 93, 23);
		combo_EscolhaConta = new Combo(composite, SWT.NONE);
		combo_EscolhaConta.setBounds(170, 85, 224, 23);
		text_contaActual = new Text(composite, SWT.BORDER | SWT.CENTER);
		text_contaActual.setText("Indique o ID");
		text_contaActual.setBounds(343, 7, 88, 21);
		txt_Indique_ID = new Text(composite, SWT.BORDER | SWT.CENTER);
		// introduz o ID do Cliente actual se vier de outra janela
		int index = 0;
		if (clienteActual == null) {
			txt_Indique_ID.setText("Indique o ID");
		} else { // preeche os dados
			txt_Indique_ID.setText("" + clienteActual.getuID());
			if (!(clienteActual.getLcontaSC().size() == 0)) {
				String[] listaContas = new String[clienteActual.getLcontaSC().size()];
				System.out.println("<---- lista de contas --->/n" + clienteActual.getLcontaSC().size());
				for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
					if (clienteActual.getLcontaSC().get(i).getAbertaFechada().equals(Conta.TipoC.ENCERADA)) {
						listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID() + ("(ENCERRADA)");
					} else {
						listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID();
					}
					if (clienteActual.getLcontaSC().get(i) == contaActual) {
						index = i;
					}
				}
				System.out.println("<---- lista de contas --->\n" + listaContas.length);
				combo_EscolhaConta.setItems(listaContas);
				combo_EscolhaConta.select(index);
				listaClientes = listaClientesActual();
				combo_titularesDaconta.setItems(listaClientes);

			} else {
				combo_EscolhaConta.setItems("Não existem contas a apresentar");
			}

		}
		// introduz o ID da Contaactual
		if (contaActual == null) {
			text_contaActual.setText("Indique o ID");
		} else {
			listaClientes = listaClientesActual();
			combo_titularesDaconta.setItems(listaClientes);

			if (clienteActual == null) {
				combo_EscolhaConta.setItems("" + contaActual.getContaID());
				combo_EscolhaConta.select(0);
			} else {
				text_contaActual.setText("" + contaActual.getContaID());
				if (index != -1) {
					combo_EscolhaConta.select(index);

				}
			}
		}

		txt_Indique_ID.setLocation(10, 7);
		txt_Indique_ID.setSize(88, 21);
		txt_Indique_ID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				txt_Indique_ID.setText("");
			}
		});

		Button btnNovoCliente = new Button(shellMF_EditarC, SWT.NONE);
		btnNovoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellMF_EditarC.dispose();
				J_02Menu_F_CriaCliente alteraDados=new J_02Menu_F_CriaCliente(gestor,uUtilizador);
				alteraDados.open();
				
			}
		});
		btnNovoCliente.setBounds(10, 84, 192, 25);
		btnNovoCliente.setText("Criar novo Cliente");

		Button btnListarClientes = new Button(shellMF_EditarC, SWT.NONE);
		btnListarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_EditarC.dispose();
				J_02Menu_F_ListaClientes listaC = new J_02Menu_F_ListaClientes(gestor, uUtilizador);
				listaC.open();
			}
		});
		btnListarClientes.setText("Listar Clientes");
		btnListarClientes.setBounds(10, 115, 192, 25);

		Button btnAlterarLoginE = new Button(shellMF_EditarC, SWT.NONE);
		btnAlterarLoginE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellMF_EditarC.close();
				J_02_MenuFun_AlteraDados2 alteradados=new J_02_MenuFun_AlteraDados2(gestor, uUtilizador); 
				alteradados.open();
			}
		});
		btnAlterarLoginE.setText("Alterar Login e Password");
		btnAlterarLoginE.setBounds(10, 239, 192, 25);

		Button button_Logout = new Button(shellMF_EditarC, SWT.NONE);
		button_Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_EditarC.dispose();
				
			}
		});
		button_Logout.setText("Log Out");
		button_Logout.setBounds(558, 10, 75, 25);

		Funcionario = new Text(shellMF_EditarC, SWT.BORDER);
		Funcionario.setText("Bem Vindo " + uUtilizador.getNome());
		Funcionario.setBounds(215, 10, 326, 25);

		button_EncerraConta = new Button(composite, SWT.NONE);
		button_EncerraConta.setText("Encerrar Conta");
		button_EncerraConta.setSelection(true);
		button_EncerraConta.setBounds(23, 157, 141, 25);
		
		btnAdicionarTitular = new Button(composite, SWT.NONE);
		btnAdicionarTitular.setText("Adicionar Titular");
		btnAdicionarTitular.setSelection(true);
		btnAdicionarTitular.setBounds(23, 201, 141, 25);
		
		button_CriaCartao = new Button(composite, SWT.NONE);
		button_CriaCartao.setText("Criar Cart\u00E3o de Credito");
		button_CriaCartao.setSelection(true);
		button_CriaCartao.setBounds(23, 251, 141, 25);
		
		btnMenuadministrador = new Button(shellMF_EditarC, SWT.NONE);
		btnMenuadministrador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_EditarC.dispose();
				J_01_Administrador admin=new J_01_Administrador(gestor,uUtilizador);
				admin.open();
			}
		});
		btnMenuadministrador.setText("MenuAdministrador");
		btnMenuadministrador.setBounds(10, 300, 192, 25);
		btnMenuadministrador.setVisible(false);
		if (uUtilizador instanceof Administrador) {
			btnMenuadministrador.setVisible(true);
			button_EncerraConta.setEnabled(false);
			btnAdicionarTitular.setEnabled(false);
			button_CriaCartao.setEnabled(false);
//			button_CriaCartao.setVisible(false);;
			
		}
		
		
		Label lblDadosDoCliente = new Label(composite, SWT.NONE);
		lblDadosDoCliente.setText("Contas do Cliente");
		lblDadosDoCliente.setAlignment(SWT.CENTER);
		lblDadosDoCliente.setBounds(104, 10, 231, 15);
		
		button_CriaCartao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (!combo_titularesDaconta.getText().equals("")) {
				int titularID = Integer.parseInt(combo_titularesDaconta.getText());
				Cliente clienteCartao=gestor.procuraCid(titularID);
				Cartao cartaoN=gestor.criaCartao(titularID,contaActual, clienteCartao.getNome()+" "+clienteCartao.getSobrenome());
				MessageBox boxCartao = new MessageBox(shellMF_EditarC, SWT.MULTI);
				boxCartao.setText("CARTAO CRIADO");
				boxCartao.setMessage(cartaoN.toString());
				boxCartao.open();
				text_cartaoAssociado.setText(""+cartaoN.getCartaoID());
				button_CriaCartao.setEnabled(false);
				}
			}
		});
		
		mudarbotaoCC ();
		
		
		Button btn_ProcuraCliente = new Button(composite, SWT.NONE);
		btn_ProcuraCliente.setGrayed(true);
		// *procura pelo cliente através da ID e devolve toda a informação
		btn_ProcuraCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {

				String mensagem = "";
				if (Util.estaVazio(txt_Indique_ID)) {
					mensagem = " Para procurar um Cliente tem de introduzir um ID";
				} else {
					if (Util.eNumero(txt_Indique_ID) == -1) {
						mensagem = " O ID do cliente tem de ser numerico";
					} else {
						if (gestor.procuraCid(Integer.parseInt(txt_Indique_ID.getText())) == null) {
							txt_Indique_ID.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						} else {
							clienteActual = gestor.procuraCid(Integer.parseInt(txt_Indique_ID.getText()));
							mensagem = "O Cliente" + clienteActual.getNome() + " " + clienteActual.getSobrenome()
									+ " foi encontrado\n" + "Morada:" + clienteActual.getMorada() + "\n" + ""
									+ clienteActual.escolhaID.toString() + ":" + clienteActual.getValorID() + "\n"
									+ "Email:" + clienteActual.getEmail() + "\n" + "Contacto:"
									+ clienteActual.getMobile() + "\n" + "Data Nascimento:"
									+ clienteActual.getDataNascimento() + "\n";

							//// colocaca dados
							txt_Indique_ID.setText("" + clienteActual.getuID());

							if (!(clienteActual.getLcontaSC().size() == 0)) {
								String[] listaContas = new String[clienteActual.getLcontaSC().size()];
								System.out.println("<---- lista de contas --->/n" + clienteActual.getLcontaSC().size());
								for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
									if (clienteActual.getLcontaSC().get(i).getAbertaFechada()
											.equals(Conta.TipoC.ENCERADA)) {
										listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID()
												+ ("(ENCERRADA)");
									} else {
										listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID();
									}

								}
								System.out.println("<---- lista de contas --->/n" + listaContas.length);
								combo_EscolhaConta.setItems(listaContas);
//								item.setText(0, ("" + clienteActual.getLcontaSC().get(i).getContaID()));
//								item.setText(1, ("" + clienteActual.getLcontaSC().get(i).getClientesDaC().size()));	
							} else {
								combo_EscolhaConta.setItems("Não existem contas a apresentar");
							}

						}
					}
				}

				MessageBox box = new MessageBox(shellMF_EditarC, SWT.MULTI);
				box.setText("DADOS DO CLIENTE");
				box.setMessage("  " + mensagem);
//				
				box.open();
			}
		});
		btn_ProcuraCliente.setLocation(10, 28);
		btn_ProcuraCliente.setSize(88, 25);
		btn_ProcuraCliente.setText("Obter Cliente");

		txtSelecioneUmaConta = new Text(composite, SWT.BORDER | SWT.CENTER);
		txtSelecioneUmaConta.setText("Selecione uma Conta");
		txtSelecioneUmaConta.setBounds(23, 86, 147, 21);

		
		button_EncerraConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (!(contaActual==null)) {
				contaActual.setAbertaFechada(TipoC.ENCERADA);
				for (Conta c : gestor.getlContas()) {
					System.out.println(c);
				}

				if (!(clienteActual.getLcontaSC().size() == 0)) {
					int index = 0;
					String[] listaContas = new String[clienteActual.getLcontaSC().size()];
					System.out.println("<---- lista de contas --->/n" + clienteActual.getLcontaSC().size());
					for (int i = 0; i < clienteActual.getLcontaSC().size(); i++) {
						if (clienteActual.getLcontaSC().get(i).getAbertaFechada().equals(Conta.TipoC.ENCERADA)) {
							listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID() + ("(ENCERRADA)");
						} else {
							listaContas[i] = "" + clienteActual.getLcontaSC().get(i).getContaID();
						}
						if (clienteActual.getLcontaSC().get(i) == contaActual) {
							index = i;
						}
					}
					System.out.println("<---- lista de contas --->\n" + listaContas.length);
					combo_EscolhaConta.setItems(listaContas);
					combo_EscolhaConta.select(index);
					gestor.saveAll();
				}
				}
			}
		});
		

		

		Label label = new Label(composite, SWT.NONE);
		label.setText("(escolha titular)");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		label.setAlignment(SWT.CENTER);
		label.setBounds(170, 242, 93, 10);

		text_cartaoAssociado = new Text(composite, SWT.BORDER);
		text_cartaoAssociado.setText("Não tem cartão associado");
		text_cartaoAssociado.setBounds(269, 255, 147, 21);

		Label lblcartaoAssociado = new Label(composite, SWT.NONE);
		lblcartaoAssociado.setText("(cartao associado)");
		lblcartaoAssociado.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		lblcartaoAssociado.setBounds(269, 242, 111, 10);

		
		btnAdicionarTitular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				boolean verifica = true;
				String textoTitulo = "";
				String mensagem = "";
				text_NovoTitular.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
				if (Util.estaVazio(text_NovoTitular)) {
					
					textoTitulo = " ERRO !!";
					mensagem = mensagem + "tem de introduzir um valor\n";
					verifica = false;
				}

				if (!Util.estaVazio(text_NovoTitular)&&Util.eNumero(text_NovoTitular) == -1) {
					textoTitulo = " ERRO !!";
					mensagem = mensagem + " O ID do cliente tem de ser numerico.\n";
					verifica = false;
				}
				
				
				if (!(Util.estaVazio(text_NovoTitular))&	!(Util.eNumero(text_NovoTitular) == -1) ){
					if (gestor.procuraCid(Integer.parseInt(text_NovoTitular.getText())) == null) {
					text_NovoTitular.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					textoTitulo = " ERRO !!";
					mensagem = mensagem + " O Cliente não existe.\n";
					verifica = false;
				}
					else if  (!(gestor.procuraCid(Integer.parseInt(text_NovoTitular.getText())) == null)&&
							 (gestor.procuraCid(Integer.parseInt(text_NovoTitular.getText())) == clienteActual)) {
						
						textoTitulo = " ERRO !!";
						mensagem = mensagem + " O Cliente que quer adicionar já é titular da conta.\n";
						verifica = false;		
						
					}
				} 
				if (contaActual==null) {
					mensagem = mensagem + " Tem de Selecionar uma Conta";
					verifica = false;
				}
				
				if (verifica) {
					Cliente clienteTitular = gestor.procuraCid(Integer.parseInt(text_NovoTitular.getText()));
					if (!(clienteTitular.procuraContaPrazo()==null)) {
						mensagem = mensagem + " O Cliente Já é titular de uma Conta a Prazo.\n";
						verifica = false;
					}
					else {
					contaActual.addClienteC(clienteTitular.getuID());
					clienteTitular.addConta(contaActual);
					textoTitulo = " **** OK ****";
					mensagem =  " Foi Adicionado o titual a Conta";
					listaClientes = listaClientesActual();
					combo_titularesDaconta.setItems(listaClientes);
					gestor.saveAll();
					}
				}
				
				
				
				MessageBox box = new MessageBox(shellMF_EditarC, SWT.MULTI);
				box.setText(textoTitulo);
				box.setMessage(mensagem);
				box.open();

			}
		});
		

		text_NovoTitular = new Text(composite, SWT.BORDER);
		text_NovoTitular.setBounds(170, 203, 93, 21);

		Label lblidDoCliente = new Label(composite, SWT.NONE);
		lblidDoCliente.setText("(ID do Cliente)");
		lblidDoCliente.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.ITALIC));
		lblidDoCliente.setAlignment(SWT.CENTER);
		lblidDoCliente.setBounds(170, 189, 93, 10);
		
		Button button = new Button(shellMF_EditarC, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_EditarC.dispose();
				J_02Menu_F_DadosCl cliente=new J_02Menu_F_DadosCl(gestor,uUtilizador,clienteActual);
				cliente.open();
				
			}
		});
		button.setText("Dados do cliente");
		button.setBounds(10, 146, 192, 25);
		
		Button button_1 = new Button(shellMF_EditarC, SWT.TOGGLE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shellMF_EditarC.dispose();
				J_02Menu_F_MovimentaConta editarconta = new J_02Menu_F_MovimentaConta(gestor, uUtilizador,
						clienteActual, null);
				editarconta.open();
			}
		});
		button_1.setText("Movimentar Contas");
		button_1.setBounds(10, 176, 192, 25);
		
		Button button_2 = new Button(shellMF_EditarC, SWT.NONE);
		button_2.setBounds(10, 208, 192, 25);
		/// seleciona uma conta
		combo_EscolhaConta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int contaID = Integer.parseInt(combo_EscolhaConta.getText().replaceAll("\\D+",""));
				contaActual = clienteActual.procuraConta(contaID);
				text_contaActual.setText("" + contaActual.getContaID());
				listaClientes = listaClientesActual();
				combo_titularesDaconta.setItems(listaClientes);
				mudarbotaoCC ();
			}
		});

	}

	// ***************metodos**************
	// Se a conta é Prazo não pode ter cartões associados
	public void mudarbotaoCC () {
		if (uUtilizador instanceof Funcionario) {
		if (!(contaActual==null)) {
		if (contaActual instanceof ContaPrazo) {
			button_CriaCartao.setText("A Conta é Prazo!!!");
			button_CriaCartao.setEnabled(false);
		}
		else {
			button_CriaCartao.setText("Criar Cart\u00E3o de Credito");
			button_CriaCartao.setEnabled(true);}
		}
		}
	}
	
	
	// cria lista de clientes da Conta Actual ( usa metodo da Conta)
	public String[] listaClientesActual() {
		listaClientes = new String[contaActual.getClientesDaC().size()];

		System.out.println("<---- lista de clientes--->\n" + listaClientes.length);
		System.out.println("<---- lista de clientes--->\n" + Arrays.toString(listaClientes));
		for (int i = 0; i < contaActual.getClientesDaC().size(); i++) {
			listaClientes[i] = "" + contaActual.getClientesDaC().get(i);
		}
		return listaClientes;
	}

	
}
