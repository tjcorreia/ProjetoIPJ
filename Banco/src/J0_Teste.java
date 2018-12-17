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

	protected Shell shell;
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.setBounds(215, 65, 75, 25);
		btnLogin.setText("Login");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(46, 64, 82, 21);
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(46, 43, 55, 15);
		lblLogin.setText("Login ");

	}
}
