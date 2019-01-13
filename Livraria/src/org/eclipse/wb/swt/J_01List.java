package org.eclipse.wb.swt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**  
 * Breve descrição do código   
 *    
 * @sid 2017
 * @aid 1.1  
 */

public class J_01List extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField caixaDeBusca;
	

	protected Livro livroSelecionado;// atributo que nos dá o livro que está selecionado na table
	protected Livraria livraria;// atributo adicionado para poder ir buscar métodos à livraria
	protected Carrinho carrinho;
	protected String stringProcurada;
	protected ArrayList<Livro> listaLivrosDaBusca;
	private JScrollPane scrollPane;
	private JLabel lblSelecioneLivro;
	private JLabel lblCarrinho;
	private JLabel lblItems;
	private JButton btnAdicionar;
	private JButton btnRemover;
	private JButton btnVerCarrinho;
	private JButton btnVoltar;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					J_01List frame = new J_01List();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public J_01List(Livraria livraria) {
		this.livraria = livraria;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[151.00px][118.00,grow][][][][]", "[][55.00px][][][][][][][][39.00][68.00][63.00][70.00][]"));
		
		JLabel lblNewLabel = new JLabel("Procurar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel, "cell 0 0,grow");
		
		
		//Criar colunas da tabela
		scrollPane = new JScrollPane();
		String [] colunas = { "Título", "Autor"};
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas,0);
		table = new JTable(modeloTabela);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		
		for (Livro l : livraria.getLivros()) {
			String titulo = l.getNome();
			String autor = l.getAutor();
			Object []livro = { titulo, autor};
			modeloTabela.addRow(livro);
		}
		
		caixaDeBusca = new JTextField();
		contentPane.add(caixaDeBusca, "cell 1 0,growx");
		caixaDeBusca.setColumns(10);
		scrollPane.setViewportView(table);
		
		contentPane.add(scrollPane, "cell 0 1 4 12,grow");
		//table = new JTable(linhas, colunas);

		table.setAutoCreateRowSorter(true);
		//		table.convertRowIndexToModel(table.getSelectedRow());
		
		lblSelecioneLivro = new JLabel("Selecione livro");
		contentPane.add(lblSelecioneLivro, "cell 4 1");
		
		lblCarrinho = new JLabel("Carrinho");
		contentPane.add(lblCarrinho, "cell 4 5");
		
		lblItems = new JLabel("items");
		contentPane.add(lblItems, "cell 4 6");
		
		btnAdicionar = new JButton("Adicionar");
		contentPane.add(btnAdicionar, "cell 4 8");
		
		btnRemover = new JButton("Remover");
		contentPane.add(btnRemover, "cell 5 8");
		
		btnVerCarrinho = new JButton("Ver carrinho");
		contentPane.add(btnVerCarrinho, "cell 4 9 2 1,growx");
		
		btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 5 13,alignx right");

		
	}

}
