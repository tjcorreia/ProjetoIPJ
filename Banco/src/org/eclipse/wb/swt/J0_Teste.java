package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J0_Teste {

	protected Shell shlJavaBankApp;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			J0_Teste window = new J0_Teste();
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
		shlJavaBankApp.open();
		shlJavaBankApp.layout();
		while (!shlJavaBankApp.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlJavaBankApp = new Shell();
		shlJavaBankApp.setSize(450, 300);
		shlJavaBankApp.setText("JAVA BANK App");
		shlJavaBankApp.setLayout(null);
		
		Button btnLogin = new Button(shlJavaBankApp, SWT.NONE);
		btnLogin.setBounds(157, 64, 75, 25);
		btnLogin.setText("Login");
		
		text = new Text(shlJavaBankApp, SWT.BORDER);
		text.setBounds(46, 64, 82, 21);
		
		Label lblLogin = new Label(shlJavaBankApp, SWT.NONE);
		lblLogin.setBounds(46, 43, 55, 15);
		lblLogin.setText("Login ");

	}
}
