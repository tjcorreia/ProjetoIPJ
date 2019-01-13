package org.eclipse.wb.swt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.Transacao.TipoT;
import org.eclipse.wb.swt.Utilizador.TipoID;

/**
 * Breve descrição do código Classe Gestão : - Gere as lista das diversas
 * classes
 * 
 * @author Alberto Machado
 * @author Tiago Correia
 * @param
 * @sid 2019
 * @aid 1.1
 */

public class Gestao {
 // Atributos
	private Map<String, Utilizador> mapUtilizadores;// String Username como key
	private ArrayList<Conta> lContas; // lista de contas
	private Map<Integer, Integer> mapCartaoConta; // numcartao-numconta
	private Map<String, Integer> contadores;// criou-se um contador usar nos diversas classes
	private Utilizador uactual; // UtilizadorActual transmitido entre janelas

//	contadores.put("Utilizador", 10000); // inicializa o Contador de Utilizadores
//	contadores.put("Contas", 100000); // inicializa o Contador de Contas
//	contadores.put("Cartoes", 500010000); // inicializa o Contador de Cartoes

	public Gestao() {
		super();
		this.mapUtilizadores = new HashMap<String, Utilizador>();
		this.lContas = new ArrayList<Conta>();
		this.mapCartaoConta = new HashMap<Integer, Integer>();
		this.contadores = new HashMap<String, Integer>();

		/**
		 * load data : Na abertura carrega todos os ficheiros para o sistema
		 */

		try {
			loadAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		contadores.put("Utilizador", 10000); // inicializa o Contador de Utilizadores
//		contadores.put("Contas", 100000); // inicializa o Contador de Contas
//
//		// Administradores
//
//		Administrador MachadoU = new Administrador(contadores.get("Utilizador"), "Machado", "Admin", "Alberto",
//				"Machado0", "1977/07/17", "Rua Maria Vitoria", Administrador.TipoID.CARTAOCIDADAO, "78456123",
//				"mail@gmail.com", 965420735);
//
//		Administrador CorreiaU = new Administrador(contadores.get("Utilizador") + 1, "Correia", "Admin", "Tiago",
//				"Coreia", "1977/07/30", "Rua Maria Vitoria ", Administrador.TipoID.CARTAOCIDADAO, "12345678",
//				"mail@gmail.com", 965420733);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//		mapUtilizadores.put("Machado", MachadoU);
//		mapUtilizadores.put("Correia", CorreiaU);
//
//		// Funcionarios (NOTA:o funcionario banco (ID:10003) tem de existir sempre é o
//		// funcionario a quem são atribuidos os processos automaticos)
//		Funcionario BANCOFU = new Funcionario(contadores.get("Utilizador") + 1, "BANCO", "Fun", "BANCO", "BANCO0",
//				"1977/07/30", "BANCO", Funcionario.TipoID.CARTAOCIDADAO, "78456123", "banco@gmail.com", 960000000);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//
//		Funcionario MachadoFU = new Funcionario(contadores.get("Utilizador") + 1, "Maria", "Fun", "Maria", "Cardoso",
//				"1977/07/30", "BANCO", Funcionario.TipoID.CARTAOCIDADAO, "78456123", "banco@gmail.com", 960000000);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//
//		Funcionario CorreiaFU = new Funcionario(contadores.get("Utilizador") + 1, "Correia2", "Fun", "Tiago", "Coreia",
//				"1977/07/30", "Rua Maria Vitoria ", Funcionario.TipoID.CARTAOCIDADAO, "12345678", "mail2@gmail.com",
//				965420731);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//		mapUtilizadores.put("BANCO", BANCOFU);
//		mapUtilizadores.put("Maria", MachadoFU);
//		mapUtilizadores.put("Correia2", CorreiaFU);
//
//		// Clientes
//		// Utilizador(uID,login,password,nome,morada,escolhaID,valorID,email,mobile)
//
//		Cliente cl1 = new Cliente(contadores.get("Utilizador") + 1, "Livraria", "Cliente", "LIVRARIA", "Machado0",
//				"1977/07/30", "Rua Maria Vitoria", Utilizador.TipoID.CARTAOCIDADAO, "78456123", "mail", 965420731);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//		Cliente cl2 = new Cliente(contadores.get("Utilizador") + 1, "CorreiaCliente", "Cliente", "Tiago", "Coreia",
//				"1977/07/30", "Rua Maria Vitoriazfgadfgadfgsdfgsdfg", Utilizador.TipoID.CARTAOCIDADAO, "12345678",
//				"mail", 965420730);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//		Cliente cl3 = new Cliente(contadores.get("Utilizador") + 1, "MariaCliente", "Cliente", "Tiago2", "Coreia2",
//				"1977/07/30", "Rua Maria Vitoriazfgadfgadfgsdfgsdfg", Utilizador.TipoID.CARTAOCIDADAO, "92345678",
//				"mail2@gmail.com", 965420530);
//		contadores.replace("Utilizador", contadores.get("Utilizador") + 1);
//
//		mapUtilizadores.put("AlbertoCliente", cl1);
//		mapUtilizadores.put("CorreiaCliente", cl2);
//		mapUtilizadores.put("MariaCliente", cl3);
//
//		// Contas
//		// conta da LIvraria não apagar
//		Conta cn1 = new ContaNormal(100000, 0, "2010/06/02");
//		lContas.add(cn1);
//		cn1.addClienteC(cl1.getuID());
//		cl1.addConta(cn1);
//
//		ContaNormal cn2 = new ContaNormal(100001, 0, "2017/06/02");
//		cn2.addClienteC(cl2.getuID());
//
//		cn2.addClienteC(cl3.getuID());
//		cl2.addConta(cn2);
//
//		cl3.addConta(cn2);
//
//		lContas.add(cn2);
//
//		Conta cn3 = new ContaNormal(100002, 0, "2017/06/02");
//		lContas.add(cn3);
//		cn3.addClienteC(cl1.getuID());
//		cl1.addConta(cn3);
//
//		Conta cn4 = new ContaPrazo(100003, 0, "2017/06/02");
//		lContas.add(cn4);
//		cn4.addClienteC(cl1.getuID());
//		cn4.addClienteC(cl2.getuID());
//		cn4.addClienteC(cl3.getuID());
//
//		cl1.addConta(cn4);
//		cl3.addConta(cn4);
//
//		Conta cn5 = new ContaPrazo(100004, 0, "2017/06/02");
//		cn5.setAbertaFechada(Conta.TipoC.ENCERADA);
//		lContas.add(cn5);
//		cn5.addClienteC(cl1.getuID());
//		cl1.addConta(cn5);
//
////	transações
//
//		Transacao T0Cn1 = new Transacao(MachadoFU.getuID(), "2018-01-02", 1500, "ABERTURA", 0,
//				Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T0Cn1);
//		Transacao T1Cn1 = new Transacao(CorreiaFU.getuID(), "2018-02-02", -100, "", 0, Transacao.TipoT.LEV_CASH);
//		cn1.addTransacaoC(T1Cn1);
//		Transacao T2Cn1 = new Transacao(MachadoFU.getuID(), "2018-03-02", 2000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T2Cn1);
//		Transacao T3Cn1 = new Transacao(CorreiaFU.getuID(), "2018-04-02", 1000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T3Cn1);
//		Transacao T4Cn1 = new Transacao(MachadoFU.getuID(), "2018-05-02", 1000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T4Cn1);
//		Transacao T5Cn1 = new Transacao(CorreiaFU.getuID(), "2018-06-02", 1000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T5Cn1);
//		Transacao T6Cn1 = new Transacao(MachadoFU.getuID(), "2018-07-02", 1000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T6Cn1);
//		Transacao T7Cn1 = new Transacao(CorreiaFU.getuID(), "2018-01-02", 1000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T7Cn1);
//		Transacao T8Cn1 = new Transacao(MachadoFU.getuID(), "2019-01-08", 1000, "", 0, Transacao.TipoT.DEP_CASH);
//		cn1.addTransacaoC(T8Cn1);
//		Transacao T9Cn1 = new Transacao(MachadoFU.getuID(), "2019-01-08", -50, "", 0, Transacao.TipoT.LEV_CASH);
//		cn1.addTransacaoC(T9Cn1);
//		Transacao T10Cn1 = new Transacao(MachadoFU.getuID(), "2019-01-08", -100, "", 100002,
//				Transacao.TipoT.TRANSFERENCIA);
//		cn1.addTransacaoC(T10Cn1);
//		Transacao T0Cn2 = new Transacao(MachadoFU.getuID(), "2019-01-08", 1500, "ABERTURA", 0,
//				Transacao.TipoT.DEP_CASH);
//		cn2.addTransacaoC(T0Cn2);
//		Transacao T1Cn2 = new Transacao(MachadoFU.getuID(), "2019-01-08", 200, "", -100001,
//				Transacao.TipoT.TRANSFERENCIA);
//		cn2.addTransacaoC(T1Cn2);
//		Transacao T0Cn3 = new Transacao(MachadoFU.getuID(), 1000, "ABERTURA", 0, Transacao.TipoT.DEP_CASH);
//		cn3.addTransacaoC(T0Cn3);
//		Transacao T0Cn4 = new Transacao(MachadoFU.getuID(), 1000, "ABERTURA", 0, Transacao.TipoT.DEP_CASH);
//		cn4.addTransacaoC(T0Cn4);
//
//		// cartao
//
//		LocalDate data = LocalDate.now().plusYears(5);
//		int dia = data.getDayOfMonth();
//		int anomes = data.getMonthValue();
//		int ano = data.getYear();
//		LocalDate data1 = LocalDate.of(2023, 12, 21);
//
//		contadores.put("Cartoes", 500010000); // inicializa o Contador de Cartoes
//		System.out.println("Contador->" + contadores.get("Cartoes"));
//		Cartao ct1 = new Cartao(500010000, cl3.getuID(), cn2.getContaID(), cl3.getNome() + " " + cl3.getSobrenome(),
//				data1, "000");
//		((ContaNormal) cn2).addCartaoC(ct1);
//
//		mapCartaoConta.put(500010000, cn2.getContaID());
//		System.out.println("Contador->" + contadores.get("Cartoes"));
//		LocalDate data2 = LocalDate.of(2020, 12, 01);
//		Cartao ct2 = new Cartao(contadores.get("Cartoes") + 1, cl2.getuID(), cn2.getContaID(),
//				cl2.getNome() + " " + cl2.getSobrenome(), data2, "000");
//		((ContaNormal) cn2).addCartaoC(ct2);
//		System.out.println("Conta Cartao->" + mapCartaoConta.get(500010000));
//		mapCartaoConta.put(contadores.get("Cartoes") + 1, cn2.getContaID());
//		System.out.println("Conta Cartao->" + mapCartaoConta.get(500010001));
//		contadores.replace("Cartoes", contadores.get("Cartoes") + 1); // inicializa o Contador de Cartoes
//		System.out.println("Contador->" + contadores.get("Cartoes"));
//		// ( duvida colocar conta de origem ?)

		
		
	}
	/**
	 * Getter e Setters para todos os atributos
	 */
	public Utilizador getUactual() {
		return uactual;
	}

	public void setUactual(Utilizador uactual) {
		this.uactual = uactual;
	}

	public Map<String, Integer> getContadores() {
		return contadores;
	}

	public void setContadores(Map<String, Integer> contadores) {
		this.contadores = contadores;
	}

	public Map<String, Utilizador> getMapUtilizadores() {
		return mapUtilizadores;
	}

	public void setMapUtilizadores(Map<String, Utilizador> mapUtilizadores) {
		this.mapUtilizadores = mapUtilizadores;
	}

	public ArrayList<Conta> getlContas() {
		return lContas;
	}

	public void setlContas(ArrayList<Conta> lContas) {
		this.lContas = lContas;
	}

	public Map<Integer, Integer> getMapCartaoConta() {
		return mapCartaoConta;
	}

	public void setMapCartaoConta(Map<Integer, Integer> mapCartaoConta) {
		this.mapCartaoConta = mapCartaoConta;
	}

	public void Gerir(Gestao gestor, Utilizador uactual) {

// inicia a thread pava verificar a transação da livraria
		
		
		int counter = 10000;
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// thread a executar
				try {
					VerificaLivraria(counter);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		
		/**
		 * elimina os cartões fora de validade
		 */
		eliminaCartoesForaValidade();
		for (Entry<Integer, Integer> entry : mapCartaoConta.entrySet()) {
			System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		/**
		 * verifica data e paga juros as contas
		 */
		pagajuros();
		/**
		 * Gava todos os ficheiros
		 */
		saveAll();

		for (Entry<Integer, Integer> entry : mapCartaoConta.entrySet()) {
			System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}

		System.out.println("lOAD");
		for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
			System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());
			System.out.println(entry.getValue().toString());
		}
		// em função do login escolhe as permições de cada utilizador
		if (uactual instanceof Administrador) {
			J_01_Administrador novaJAdmin = new J_01_Administrador(gestor, uactual);
			novaJAdmin.open();
		} else if (uactual instanceof Funcionario) {
			J_02Menu_F novaJFuncionario = new J_02Menu_F(gestor, uactual);
			novaJFuncionario.open();

		} else if (uactual instanceof Cliente) {
			J_03Menu_CLIENTE novaCliente = new J_03Menu_CLIENTE(gestor, uactual);
			novaCliente.open();

		}

		System.out.println("<---------------------- Log out ---------------->");

		saveAll();
		

	}

//++++++++++++++++++++++++++++++++++++++++++++++++++ metodos++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * elimina os cartões fora de validade
	 */
	private void eliminaCartoesForaValidade() {

		Map<Conta, Cartao> mapContaCartaoaEliminar = new HashMap<Conta, Cartao>();
		for (Entry<Integer, Integer> entry : mapCartaoConta.entrySet()) {
			LocalDate dataactual = LocalDate.now();
			ContaNormal c = (ContaNormal) contaExiste(entry.getValue());
			Cartao ct = ((ContaNormal) c).procuraCartaoC(entry.getKey());
			if (!(dataactual.isAfter(ct.getDataV()))) {	
			} else if ((dataactual.isAfter(ct.getDataV()))) {
				mapContaCartaoaEliminar.put(c, ct);
			}
		}
		if (!(mapCartaoConta.size() == 0)) {
			for (Entry<Conta, Cartao> entry1 : mapContaCartaoaEliminar.entrySet()) {
				mapCartaoConta.remove(entry1.getValue().getCartaoID());
				((ContaNormal) entry1.getKey()).removeCartaoC(entry1.getValue());
			}
		}
	}

	/**
	 * @param counter contador
	 * @throws IOException Método de comunicação com a livravria
	 */
	private void VerificaLivraria(int counter) throws IOException {
		while (counter-- > 0) {
			System.out.println("esta a verificar o ficheiro");
			FicheiroDeTexto ficheiroPedidos = new FicheiroDeTexto();
			FicheiroDeTexto ficheiroDevolucao = new FicheiroDeTexto();
			try {
				ficheiroPedidos.abreLeitura("..\\PedidosdaLivravria.txt");
				System.out.println("Le ficheiro");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			int contaDeposito = 0;
			int pedidoiD = 0;
			int cartaoCliente = 0;
			String pin = "";
			double movimento = 0;

			String s = "";

			s = ficheiroPedidos.leLinha();

			if (s != null && !s.equals("")) {
				String[] sSplit = s.split(",");
				System.out.println("Cartao Cliente  - >" + cartaoCliente);
				System.out.println("Cartao PIN - >" + pin);
				pedidoiD = Integer.parseInt(sSplit[0]);
				contaDeposito = Integer.parseInt(sSplit[1]);
				cartaoCliente = Integer.parseInt(sSplit[2]);
				pin = sSplit[3];
				movimento = Double.parseDouble(sSplit[4]);
				// considera-se que so se processa um carrinho de CADA vez

				ficheiroPedidos.fechaLeitura();
				System.out.println("pedidoID  :" + pedidoiD);
				System.out.println("contaDeposito:" + contaDeposito);
				System.out.println("cartaoCliente:" + cartaoCliente);
				System.out.println("pin  :" + pin);
				System.out.println("movimento  :" + movimento);
				String mensagem = "";

				mensagem = VerificaCartaoeDevolveContaID(cartaoCliente, pin, movimento);
				System.out.println("MENSAGEM  :" + mensagem);
				if (eUmNumero(mensagem)) {
					System.out.println("MENSAGEM  :" + mensagem);
					int contaLevantamentoID = Integer.parseInt(mensagem);

					// verifica Conta destino
					if (!(contaExiste(contaDeposito) == null)) {
						ContaNormal contaFinal = (ContaNormal) contaExiste(contaDeposito);
						ContaNormal contaLevantamento = (ContaNormal) contaExiste(contaLevantamentoID);
						// verificou Tudo executa a Transaçã
						//
						Transacao novaT = new Transacao(10003, movimento * -1, "LIVRARIA", contaFinal.getContaID(),
								TipoT.TRANSFERENCIA);
						contaLevantamento.addTransacaoC(novaT);
						System.out.println("<---- Conta FINAL- Verifica Saldo ( "
								+ contaLevantamento.getTransacoesC().toArray() + ") --->\n");

						Transacao novaTcontaF = new Transacao(10003, movimento, "", contaLevantamento.getContaID(),
								TipoT.TRANSFERENCIA);
						System.out.println("<---- Conta FINAL- Verifica Saldo ( "
								+ contaFinal.getTransacoesC().toArray() + ") --->\n");
						contaFinal.addTransacaoC(novaTcontaF);
						System.out.println("<---- TRANSACÃO CONCLUIDA --->\n");
//						"..\\ProjetoIPJ\\RespostadoBanco.txt"
						ficheiroDevolucao.abreEscrita("..\\RespostadoBanco.txt");
						ficheiroDevolucao.escreveLinha(pedidoiD + ",Pagamento efetuado com sucesso.");
						ficheiroDevolucao.fechaEscrita();

						System.out.println("<---- TRANSACÃO CONCLUIDA --->\n" + pedidoiD + ",OK\n");
					} else {
						ficheiroDevolucao.abreEscrita("..\\RespostadoBanco.txt");
						ficheiroDevolucao.escreveLinha(pedidoiD + ",A CONTA DA LIVRARIA ESTA ERRADA");
						ficheiroDevolucao.fechaEscrita();
					}

				} else {
					System.out.println("<---- ERRO---->" + pedidoiD + "," + mensagem);
					ficheiroDevolucao.abreEscrita("..\\RespostadoBanco.txt");
					ficheiroDevolucao.escreveLinha(pedidoiD + "," + mensagem);
					ficheiroDevolucao.fechaEscrita();
				}

				ficheiroPedidos.abreEscrita("..\\PedidosdaLivravria.txt");
				ficheiroPedidos.escreveLinha("");
				ficheiroPedidos.fechaEscrita();

			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Para verificação de um movimento da Livraria com um cartão, pin , valor do movimento verifica todos os dados
	 * @param cartaoID identificação do cartão
	 * @param cartaoPIN pin  do cartão
	 * @param movimento valor do movimento
	 * @return
	 */
	public String VerificaCartaoeDevolveContaID(int cartaoID, String cartaoPIN, double movimento) {
	
		if (mapCartaoConta.containsKey(cartaoID)) {
			ContaNormal c = new ContaNormal();
			c = (ContaNormal) contaExiste(mapCartaoConta.get(cartaoID));
			if (!(c.verificaPINCartaoC(cartaoID, cartaoPIN) == null)) {
				if (c.getSaldo() >= movimento) {
					if (verifMovimentos(c, TipoT.TRANSFERENCIA, movimento)) {
						return "" + mapCartaoConta.get(cartaoID);
					} else {
						return "VALOR superior ao LIMITE DIARIO PERMITIDO";
					}
				} else {
					return "SALDO insuficiente";
				}
			} else {
				return "O PIN não é Válido";
			}
		}
		return "O Cartão não Existe";
	}
//	ArrayList<String> pedidos=new ArrayList<String>();
//	do {
//		s =ficheiroPedidos.leLinha();
//		if (s!=null && !s.equals("")) {
//			pedidos.add(s);
//		}
//	}while (s!=null);
//
//	for (String p:pedidos) {
//		String [] sSplit = p.split(",");
//		   System.out.println(Arrays.toString(sSplit));
//		   contaOrigem=Integer.parseInt(sSplit[0]);
//		   cartaoCliente=Integer.parseInt(sSplit[1]);
//		   pin=Integer.parseInt(sSplit[2]);
//		   movimento=Double.parseDouble(sSplit[3]);
//		System.out.println("contaOrigem"+ contaOrigem);
	// metodo

	/**
	 * Método para pagamento automatico de Juros
	 */
	public void pagajuros() {
		LocalDate data = LocalDate.now();

		if (data.getDayOfMonth() == 10) {
			for (Conta c : lContas) {
				if (c instanceof ContaPrazo) {
					if (c.getAbertaFechada().ABERTA != null) {
						c.jurosMensais("" + data.getYear(), "" + data.getMonthValue());
					}
				}
			}
		}

	}

	// metodo para transferencia fiz diferente mas ainda devia ter separado a parte
	// da verificação de dados

	/**
	 * Métod para o Cliente realizar um transferencia e altera a janela
	 * @param uUtilizador recebe o uttilizador actual
	 * @param shellactual recebe a janela actual
	 * @param contaActual recebe conta actual que vai fazer a transferencia
	 * @param texoVerificaSaldo campo com o valor da Transferencia
	 * @param texoVerContad Caixa de texto da conta destino
	 * @param contaFinal classe conta Final
	 */
	public void TransferenciaCl(Utilizador uUtilizador, Shell shellactual, Conta contaActual, Text texoVerificaSaldo,
			Text texoVerContad, Conta contaFinal) {
		int contaDestinoID = 0;
		double valoraTransferir = 0;
		String mensagem = "";
		String textoTitulo = "ATENÇÃO";
		boolean verifica = true;
		texoVerContad.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

		if (Util.estaVazio(mensagem, texoVerContad, texoVerificaSaldo)) {
			verifica = false;
		} else {
			// verifica valor a transferir
			if ((Util.eNumeroIouD(mensagem, texoVerificaSaldo))) {
				valoraTransferir = Double.parseDouble(texoVerificaSaldo.getText());

				// verifica Saldo da Conta
				if (valoraTransferir > contaActual.getSaldo()) {
					texoVerificaSaldo.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					mensagem = mensagem + "O Valaor a transaferir é superior ao Saldo da Conta.\n";
					verifica = false;
				} else {// verifica movimentos da Conta
					if (!(verifMovimentos(contaActual, TipoT.TRANSFERENCIA, valoraTransferir))) {
						texoVerificaSaldo.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						mensagem = mensagem + "Atingiu o limite maximo que pode levantar ou transaferir.\n";
						verifica = false;
					}
				}
			} else {
				verifica = false;
			}

			// verifica Conta
			if ((Util.eNumeroI(mensagem, texoVerContad, 6))) {
				contaFinal = contaExiste(Integer.parseInt(texoVerContad.getText()));
				if (contaFinal == null) {
					texoVerContad.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					mensagem = mensagem + " A conta não existe!!!!!\n";
					verifica = false;
				} else if (!(contaFinal == null) && contaFinal == contaActual) {
					texoVerContad.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					mensagem = mensagem + " A conta não pode ser igual a conta de origem!!!!!\n";
					verifica = false;
				} else {
					contaDestinoID = contaFinal.getContaID();
				}
			} else {
				verifica = false;
			}
		}
		MessageBox box = new MessageBox(shellactual, SWT.MULTI);
		// verifica Tudo executa a Transação
		if (verifica) {

			valoraTransferir = valoraTransferir * -1;
			Transacao novaT = new Transacao(uUtilizador.getuID(), valoraTransferir, "", contaDestinoID,
					TipoT.TRANSFERENCIA);
			contaActual.addTransacaoC(novaT);

			textoTitulo = "TRANSÇÃO CONCLUIDA";
			Transacao novaTcontaF = new Transacao(uUtilizador.getuID(), valoraTransferir * -1, "",
					contaActual.getContaID(), TipoT.TRANSFERENCIA);
			System.out.println("<---- Conta FINAL- Verifica Saldo ( " + contaFinal + ") --->\n");
			contaFinal.addTransacaoC(novaTcontaF);
			System.out.println("<---- Conta Actual- Verifica Saldo ( " + contaFinal + ") --->\n");
			box = new MessageBox(shellactual, SWT.MULTI | SWT.COLOR_GREEN | SWT.COLOR_TITLE_BACKGROUND);
		}

		// verifica mensagem a aparecer na janela

		box.setText(textoTitulo);
		box.setMessage(mensagem);
		box.open();
	}

	
	/**
	 * verifiva restriçoes de movimentos da conta
	 * @param contaAct conta actual a verificar
	 * @param escolhaTA tipo de movimento
	 * @param movimento vlor do movimento
	 * @return true/false
	 */
	public boolean verifMovimentos(Conta contaAct, TipoT escolhaTA, double movimento) {

		if (escolhaTA == TipoT.DEP_CASH) {
			return true;
		}

		if (contaAct instanceof ContaNormal) {
			double maxdiario = 1000; // max diario conta normal
			double maxMovimento = 500;// max movimento conta normal
			LocalDate actual = LocalDate.now();
			String[] dataS = ("" + actual).split("-");
			System.out.println("<---- Conta Actual- Verifica max diario ( " + Arrays.toString(dataS) + ") --->\n");
			System.out.println("---- > " + contaAct.diario(dataS[0], dataS[1], dataS[2]) * -1 + "< ---\n");
			if (movimento > maxMovimento) {
				return false;
			}
			// vai a conta e calcula o maximo diario
			if (contaAct.diario(dataS[0], dataS[1], dataS[2]) * -1 + movimento > maxdiario) {
				return false;
			}
			return true;
		} else if (contaAct instanceof ContaPrazo) {

			double maxmensal = 10000;// max mensal conta a prazo

			LocalDate actual = LocalDate.now();
			String[] dataS = ("" + actual).split("-");
			// vai a conta e calcula o maximo mensal
			if (contaAct.mensal(Integer.parseInt(dataS[0]), Integer.parseInt(dataS[1])) * -1 + movimento > maxmensal) {
				return false;
			}
			return true;
		}

		return false;

	}



	/**
	 *  criacartao para conta e cliente especifico	
	 * @param titularCartaoID ID do titular do Cartao
	 * @param contaC Conta a que o cartao vai estar associado
	 * @param nome Nome a apresentar no cartão
	 * @return
	 */
	public Cartao criaCartao(int titularCartaoID, Conta contaC, String nome) {

		Cartao novoC = new Cartao(contadores.get("Cartoes") + 1, titularCartaoID, contaC.getContaID(), nome);
		mapCartaoConta.put(contadores.get("Cartoes") + 1, contaC.getContaID());
		contadores.replace("Cartoes", contadores.get("Cartoes") + 1);
		((ContaNormal) contaC).addCartaoC(novoC);

		return novoC;
	}

	


	/**
	 * verifica se a conta existe, tambem usado para procurar por uma conta por ID
	 * @param contaID ID da Conta
	 * @return Conta 
	 */
	public Conta contaExiste(int contaID) {

		for (Conta c : lContas) {
			if (c.getContaID() == contaID) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Associa uma conta nova para um cliente 
	 * @param clienteActual Cliente que vai ter a conta nova
	 * @param contaNova Conta Nova já précriada
	 * @param funcionarioID funcionario que registra a opreaçao
	 * @return Conta
	 */
	public Conta criaContaNova(Cliente clienteActual, Conta contaNova, int funcionarioID) {

		contaNova.setContaID(lContas.size() + 100000);
		lContas.add(contaNova);
		contaNova.addClienteC(clienteActual.getuID());
		clienteActual.addConta(contaNova);
		Transacao tAbertura = new Transacao(funcionarioID, contaNova.getDatacria(), contaNova.getSaldo(), "ABERTURA", 0,
				Transacao.TipoT.DEP_CASH);
		contaNova.addTransacaoC(tAbertura);
		return contaNova;
	}


	/**
	 * faz a verificação das entradas do login
	 * @param username  
	 * @param passwordV
	 * @return Utilizador
	 */
	public Utilizador verfLogin(String username, String passwordV) {

		if (mapUtilizadores.containsKey(username)) {
			if (mapUtilizadores.get(username).password.equals(passwordV)) {
				return mapUtilizadores.get(username);
			}
		}
		return null;
	}

	/**
	 * faz a verificação dos dados para adicção de um do novo funcionario
	 * @param escolhadaIDN  tipo de identificação 
	 * @param valorID_NovoF numero de identificação
	 * @param email_NovoF   
	 * @param userNovoF       Username do novo funcionario
	 * @param mobileNovoF
	 * @return String devolve os erros encontrados
	 */
	public String verificanovoF(TipoID escolhadaIDN, Text valorID_NovoF, Text email_NovoF, Text userNovoF,
			Text mobileNovoF) {

		valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		String verifica = "";
		// verifica username
		if (mapUtilizadores.containsKey(userNovoF.getText())) {
			verifica = verifica + "O nome de Utilizador não é válido. \n";
			userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}

		for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
			if (entry.getValue() instanceof Funcionario) {

				System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());

				// verifica identificação
				if (entry.getValue().getEscolhaID().equals(escolhadaIDN)
						&& entry.getValue().getValorID().equals(valorID_NovoF.getText())) {
					verifica = verifica + "O " + escolhadaIDN + " com o numero :" + valorID_NovoF
							+ " já está associado a um Funcionario. \n";
					valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}

				else if (!(entry.getValue().getEscolhaID().equals(escolhadaIDN))
						&& entry.getValue().getValorID().equals(valorID_NovoF.getText())) {
					if (escolhadaIDN.equals(TipoID.CARTAOCIDADAO)) {
						verifica = verifica + "O numero :" + valorID_NovoF.getText()
								+ " já existe e está associado ao Passaporte. \n";
					} else {
						verifica = verifica + "O numero :" + valorID_NovoF.getText()
								+ " já existe e está associado ao Cartão de Cidadão. \n";
					}
					valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}

				// verifica email
				if (entry.getValue().getEmail().equals(email_NovoF.getText())) {
					verifica = verifica + "Já existe um utilizador com este email\n";
					email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
//			// verifica telemovel
				if (("" + entry.getValue().getMobile()).equals(mobileNovoF.getText())) {
					verifica = verifica + "Já existe um utilizador com este contacto de telemovel. \n";
					mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
			}
		}
		System.out.println((verifica));
		return verifica;
	}

	/**
	 * faz a adicção de um do novo funcionario
	 * @param login
	 * @param password
	 * @param nome
	 * @param sobrenome
	 * @param dataNascimento
	 * @param morada
	 * @param escolhaID
	 * @param valorID
	 * @param email
	 * @param mobile
	 * @param posicao
	 * @return Funcionario
	 */
	public Funcionario addNovoF(String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile, String posicao) {
		int iD = contadores.get("Utilizador") + 1;
		Funcionario NovoFU = new Funcionario(iD, login, password, nome, sobrenome, dataNascimento, morada, escolhaID,
				valorID, email, mobile, posicao);
		contadores.replace("Utilizador", iD);
		mapUtilizadores.put(login, NovoFU);
		return NovoFU;
	}


	/**
	 * faz a verificação da adicção de um do novo Cliente
	 * @param escolhadaIDN
	 * @param valorID_NovoF
	 * @param email_NovoF
	 * @param userNovoF
	 * @param mobileNovoF
	 * @return String com a informação dos erros
	 */
	public String verificanovoC(TipoID escolhadaIDN, Text valorID_NovoF, Text email_NovoF, Text userNovoF,
			Text mobileNovoF) {

		valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		String verifica = "";
// verifica username
		if (mapUtilizadores.containsKey(userNovoF.getText())) {
			verifica = verifica + "O nome de Utilizador não é válido. \n";
			userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}

		for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
			if (entry.getValue() instanceof Cliente) {

				System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());

				// verifica identificação ***FALTA RETIRAR A VERIFICAçÃO EM FUNÇÂO DO TIPO - o
				// passporte e sempre diferente
				if (entry.getValue().getEscolhaID().equals(escolhadaIDN)
						&& entry.getValue().getValorID().equals(valorID_NovoF.getText())) {
					verifica = verifica + "O " + escolhadaIDN + " com o numero :" + valorID_NovoF
							+ " já está associado a um Funcionario. \n";
					valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}

				else if (!(entry.getValue().getEscolhaID().equals(escolhadaIDN))
						&& entry.getValue().getValorID().equals(valorID_NovoF.getText())) {
					if (escolhadaIDN.equals(TipoID.CARTAOCIDADAO)) {
						verifica = verifica + "O numero :" + valorID_NovoF.getText()
								+ " já existe e está associado ao Passaporte. \n";
					} else {
						verifica = verifica + "O numero :" + valorID_NovoF.getText()
								+ " já existe e está associado ao Cartão de Cidadão. \n";
					}
					valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}

				// verifica email
				if (entry.getValue().getEmail().equals(email_NovoF.getText())) {
					verifica = verifica + "Já existe um utilizador com este email\n";
					email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
				// verifica telemovel
				if (("" + entry.getValue().getMobile()).equals(mobileNovoF.getText())) {
					verifica = verifica + "Já existe um utilizador com este contacto de telemovel. \n";
					mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
			}
		}
		System.out.println((verifica));
		return verifica;
	}
	/**
	 * faz a verificação da alteração dos parametros de um Cliente
	 * @param actual
	 * @param escolhadaIDN
	 * @param valorID_NovoF
	 * @param email_NovoF
	 * @param userNovoF
	 * @param mobileNovoF
	 * @return
	 */
	public String verificaAlteraCl(Cliente actual, TipoID escolhadaIDN, Text valorID_NovoF, Text email_NovoF,
			Text userNovoF, Text mobileNovoF) {

		valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		String verifica = "";
//	// verifica username (não é nessário considerando que o funcionario nao pode alerar estes dados
//			if (mapUtilizadores.containsKey(userNovoF.getText())) {
//				verifica = verifica + "O nome de Utilizador não é válido. \n";
//				userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
//			}

		for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
			if (entry.getValue() instanceof Cliente & !(entry.getValue() == actual)) {

				System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());

			
				if (entry.getValue().getEscolhaID().equals(escolhadaIDN)
						&& entry.getValue().getValorID().equals(valorID_NovoF.getText())) {
					verifica = verifica + "O " + escolhadaIDN + " com o numero :" + valorID_NovoF
							+ " já está associado a um Funcionario. \n";
					valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}

				else if (!(entry.getValue().getEscolhaID().equals(escolhadaIDN))
						&& entry.getValue().getValorID().equals(valorID_NovoF.getText())) {
					if (escolhadaIDN.equals(TipoID.CARTAOCIDADAO)) {
						verifica = verifica + "O numero :" + valorID_NovoF.getText()
								+ " já existe e está associado ao Passaporte. \n";
					} else {
						verifica = verifica + "O numero :" + valorID_NovoF.getText()
								+ " já existe e está associado ao Cartão de Cidadão. \n";
					}
					valorID_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
				// verifica email
				if (entry.getValue().getEmail().equals(email_NovoF.getText())) {
					verifica = verifica + "Já existe um utilizador com este email\n";
					email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
				// verifica telemovel
				if (("" + entry.getValue().getMobile()).equals(mobileNovoF.getText())) {
					verifica = verifica + "Já existe um utilizador com este contacto de telemovel. \n";
					mobileNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
				}
			}
		}
		System.out.println((verifica));
		return verifica;
	}

	/**
	 * faz a adicção de um do novo Cliente
	 * @param login
	 * @param password
	 * @param nome
	 * @param sobrenome
	 * @param dataNascimento
	 * @param morada
	 * @param escolhaID
	 * @param valorID
	 * @param email
	 * @param mobile
	 * @return
	 */
	public Cliente addNovoC(String login, String password, String nome, String sobrenome, String dataNascimento,
			String morada, TipoID escolhaID, String valorID, String email, int mobile) {
		int iD = contadores.get("Utilizador") + 1;
		Cliente novoCl = new Cliente(iD, login, password, nome, sobrenome, dataNascimento, morada, escolhaID, valorID,
				email, mobile);
		contadores.replace("Utilizador", iD);
		mapUtilizadores.put(login, novoCl);
		return novoCl;
	}

	/**
	 * faz a procura de um Cliente pela ID
	 * @param idCliente
	 * @return
	 */
	public Cliente procuraCid(int idCliente) {
		Cliente clienteID = null;
		for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
			if ((entry.getValue() instanceof Cliente) & (entry.getValue().getuID() == idCliente)) {
				return (Cliente) entry.getValue();
			}
		}

		return null;
	}



	/**
	 * //faz a verificação se e numero
	 * @param texto
	 * @return
	 */
	public boolean eUmNumero(String texto) {
		for (char c : texto.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}


	/**
	 * faz a verificação da alteracao de dados do Utilizador
	 * @param uUtilizador
	 * @param email_NovoF
	 * @param userNovoF
	 * @param emailA (email actual)
	 * @param userNameA (useractual)
	 * @return
	 */
	public String verificaA(Utilizador uUtilizador, Text email_NovoF, Text userNovoF, String emailA, String userNameA) {
		email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

		String verifica = "";
		// verifica username
		if (mapUtilizadores.containsKey(userNovoF.getText()) && !userNovoF.getText().equals(userNameA)) {
			verifica = verifica + "O nome de Utilizador não é válido. \n";
			userNovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}
		if (uUtilizador instanceof Administrador) {
			for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
				if (entry.getValue() instanceof Administrador) {
					System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());
					// verifica email
					if (entry.getValue().getEmail().equals(email_NovoF.getText())
							&& !email_NovoF.getText().equals(emailA)) {
						verifica = verifica + "Já existe um utilizador com este email\n";
						email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					}
				}
			}
		} else if (uUtilizador instanceof Funcionario) {
			for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
				if (entry.getValue() instanceof Funcionario) {
					System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());
					// verifica email
					if (entry.getValue().getEmail().equals(email_NovoF.getText())
							&& !email_NovoF.getText().equals(emailA)) {
						verifica = verifica + "Já existe um utilizador com este email\n";
						email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					}
				}
			}
		}

		else if (uUtilizador instanceof Cliente) {
			for (Entry<String, Utilizador> entry : mapUtilizadores.entrySet()) {
				if (entry.getValue() instanceof Cliente) {
					System.out.println("VERIFICA ---->Key = " + entry.getKey() + ", Value = " + entry.getValue());
					// verifica email
					if (entry.getValue().getEmail().equals(email_NovoF.getText())
							&& !email_NovoF.getText().equals(emailA)) {
						verifica = verifica + "Já existe um utilizador com este email\n";
						email_NovoF.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					}
				}
			}
		}
		System.out.println((verifica));
		return verifica;
	}


	/**
	 * Método para fazer autosize a um imagem
	 * @param estashell
	 * @param imageFromSource
	 * @param width
	 * @param height
	 * @return
	 */
	public Image resize(Shell estashell, Image imageFromSource, int width, int height) {
		if (width > 0 && height > 0) {
			Image scaledImage = new Image(estashell.getDisplay(), width, height);
			GC gc = new GC(scaledImage); // Graphics Capabilities(GC instance) in SWT used to draw an Image, graphics,
											// display
			gc.setAntialias(SWT.ON); // Anti aliasing is used for making the low resolution image to redraw and make
										// into a good resolution Image
			gc.setInterpolation(SWT.HIGH); // Interpolation is based in the Graphics, it may not work properly in some
											// systems
			gc.drawImage(imageFromSource, 0, 0, imageFromSource.getBounds().width, imageFromSource.getBounds().height,
					0, 0, width, height);

			/*
			 * drawImage(Image image, int srcX, int srcY, int srcWidth, int srcHeight, int
			 * destX, int destY, int destWidth, int destHeight) Copies a rectangular area
			 * from the source image into a (potentially different sized) rectangular area
			 * in the receiver.
			 */

			gc.dispose();
			return scaledImage;
		} else
			return imageFromSource;
	}

	/**
	 * Recebe a informação dos ficheiros
	 * @throws ClassNotFoundException
	 * String pathMapUtilizadores = "MapUtilizadores.ser";
	 * String pathlContas = "Lcontas.ser";
	 * String pathlCarões = "Lcartões.ser";
	 * String pathlContadores = "Contadores.ser";
	 */
	public void loadAll() throws ClassNotFoundException {
//	this.mapUtilizadores = mapUtilizadores;
//	this.lContas = lContas;
//	this.mapCartaoConta = mapCartaoConta;
//	this.contadores = contadores;
		String pathMapUtilizadores = "MapUtilizadores.ser";
		FicheiroDeObjectos ut = new FicheiroDeObjectos();
		try {
			ut.abreLeitura(pathMapUtilizadores);
			mapUtilizadores = (Map<String, Utilizador>) ut.leObjecto();
			ut.fechaLeitura();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//// -----------
		String pathlContas = "Lcontas.ser";
		FicheiroDeObjectos lc = new FicheiroDeObjectos();
		try {
			lc.abreLeitura(pathlContas);
			lContas = ((ArrayList<Conta>) lc.leObjecto());
			lc.fechaLeitura();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////----------- 
		String pathlCarões = "Lcartões.ser";

		FicheiroDeObjectos lcartoes = new FicheiroDeObjectos();
		try {
			lcartoes.abreLeitura(pathlCarões);
			mapCartaoConta = (Map<Integer, Integer>) lcartoes.leObjecto();
			lcartoes.fechaLeitura();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////----------- 
		String pathlContadores = "Contadores.ser";

		FicheiroDeObjectos contador = new FicheiroDeObjectos();
		try {
			contador.abreLeitura(pathlContadores);
			contadores = (Map<String, Integer>) contador.leObjecto();
			contador.fechaLeitura();

		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * Grava a informação nos ficheiros
	 * @throws ClassNotFoundException
	 * String pathMapUtilizadores = "MapUtilizadores.ser";
	 * String pathlContas = "Lcontas.ser";
	 * String pathlCarões = "Lcartões.ser";
	 * String pathlContadores = "Contadores.ser";
	 */
	
	public void saveAll() {

//	private Map<String, Utilizador> mapUtilizadores; // String Username

//	private ArrayList<Conta> lContas;

//	private Map<Integer, Integer> mapCartaoConta; // numcartaonumconta
//	private Map<String, Integer> contadores;

//	this.uactual = uactual;
		String pathMapUtilizadores = "MapUtilizadores.ser";
		FicheiroDeObjectos ut = new FicheiroDeObjectos();
		try {
			ut.abreEscrita(pathMapUtilizadores);
			ut.escreveObjecto(this.mapUtilizadores);
			ut.fechaEscrita();
			;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//// -----------
		String pathlContas = "Lcontas.ser";
		FicheiroDeObjectos lc = new FicheiroDeObjectos();
		try {
			lc.abreEscrita(pathlContas);
			lc.escreveObjecto(this.lContas);
			lc.fechaEscrita();
			;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////----------- 
		String pathlCarões = "Lcartões.ser";

		FicheiroDeObjectos lcartoes = new FicheiroDeObjectos();
		try {
			lcartoes.abreEscrita(pathlCarões);
			lcartoes.escreveObjecto(this.mapCartaoConta);
			lcartoes.fechaEscrita();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////----------- 
		String pathlContadores = "Contadores.ser";

		FicheiroDeObjectos contador = new FicheiroDeObjectos();
		try {
			contador.abreEscrita(pathlContadores);
			contador.escreveObjecto(this.contadores);
			contador.fechaEscrita();

		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
