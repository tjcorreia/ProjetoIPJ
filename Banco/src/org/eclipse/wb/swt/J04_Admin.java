package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.widgets.Text;

/**
* Breve descrição do código
*
* @sid 2019
* @aid 1.1
*/
public class J04_Admin extends Shell {
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			J04_Admin shell = new J04_Admin(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public J04_Admin(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLocation(0, 0);
		composite_1.setSize(434, 261);
		
		text = new Text(composite_1, SWT.BORDER);
		text.setText("Bem Vindo <dynamic>");
		text.setBounds(23, 10, 383, 25);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setSize(434, 261);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
