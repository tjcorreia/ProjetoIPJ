package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Spinner;




public class J_01ListaLivros {

	protected Shell shlViewComicsInc;


	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J_01ListaLivros window = new J_01ListaLivros();
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
		shlViewComicsInc.setSize(450, 488);
		shlViewComicsInc.setText("View Comics Inc.");
		
		Spinner spinner = new Spinner(shlViewComicsInc, SWT.BORDER);
		spinner.setBounds(10, 10, 192, 421);
		
		
		List list = new List(shlViewComicsInc, SWT.BORDER);
		list.setBounds(208, 10, 179, 421);

	}
}
