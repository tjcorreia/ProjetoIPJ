package org.eclipse.wb.swt;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;



public class J_00Inicial {

	protected Shell shlViewComicsInc;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_00Inicial window = new J_00Inicial();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlViewComicsInc.open();
		shlViewComicsInc.layout();
		while (!shlViewComicsInc.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlViewComicsInc = new Shell();
		shlViewComicsInc.setSize(466, 327);
		shlViewComicsInc.setText("View Comics Inc.");
		
		Label lblViewComicsInc = new Label(shlViewComicsInc, SWT.NONE);
		lblViewComicsInc.setAlignment(SWT.CENTER);
		lblViewComicsInc.setFont(SWTResourceManager.getFont("Segoe Print", 13, SWT.NORMAL));
		lblViewComicsInc.setBounds(91, 28, 267, 46);
		lblViewComicsInc.setText("View Comics Inc.");
		
		Button btnNewButton = new Button(shlViewComicsInc, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(366, 247, 72, 23);
		btnNewButton.setText("Admin");
		
		Button btnPesquisarLivro = new Button(shlViewComicsInc, SWT.NONE);
		btnPesquisarLivro.setBounds(271, 89, 167, 25);
		btnPesquisarLivro.setText("Pesquisar/Comprar Livro");
		
		text = new Text(shlViewComicsInc, SWT.BORDER);
		text.setBounds(32, 89, 227, 26);
		
		Label label = new Label(shlViewComicsInc, SWT.NONE);
		label.setText("Mensagem de erro");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		label.setBounds(32, 121, 150, 20);

	}
}