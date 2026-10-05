package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * buttons/Button.java: Common product interface
 */
/**
 * Common interface for all buttons.
 */
interface Button1 {
	void render();
	void onClick();
}

/**
 * buttons/HtmlButton.java: Concrete product
 * HTML button implementation.
 */
class HtmlButton implements Button1 {

	public void render() {
		System.out.println("<button>Test Button</button>");
		onClick();
	}

    public void onClick() {
    	System.out.println("Click! Button says - 'Hello World!'");
    }
}

/**
 * buttons/WindowsButton.java: One more concrete product
 * Windows button implementation.
 */
class WindowsButton1 implements Button1 {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton button;

	public void render() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello World!");
		label.setOpaque(true);
		label.setBackground(new Color(235, 233, 126));
		label.setFont(new Font("Dialog", Font.BOLD, 44));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.getContentPane().add(panel);
		panel.add(label);
		onClick();
		panel.add(button);
		        
		frame.setSize(320, 200);
		frame.setVisible(true);
		onClick();
	}

	public void onClick() {
		button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
		});
	}
}

/**
 * factory/Dialog.java: Base creator
 * 
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
abstract class Dialog {

	public void renderWindow() {
		// ... other code ...

		Button1 okButton = createButton();
		okButton.render();
	}
	
	/**
	 * Subclasses will override this method in order to create specific button
     * objects.
     */
	public abstract Button1 createButton();
}

/**
 * factory/HtmlDialog.java: Concrete creator
 * 
 * HTML Dialog will produce HTML buttons.
 */
class HtmlDialog extends Dialog {

    @Override
    public Button1 createButton() {
    	return new HtmlButton();
    }
}

/**
 *  factory/WindowsDialog.java: One more concrete creator
 * Windows Dialog will produce Windows buttons.
 */
class WindowsDialog extends Dialog {

    @Override
    public Button1 createButton() {
        return new WindowsButton1();
    }
}

/**
 * Demo class. Everything comes together here.
 */
public class Design_Pattern_Factory {

	private static Dialog dialog;
	public static void main(String[] args) {
		configure();
        runBusinessLogic();
	}
	/**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
	static void configure() {
		if (System.getProperty("os.name").equals("Windows 11")) {
			dialog = new WindowsDialog();
		} else {
			dialog = new HtmlDialog();
		}
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
	static void runBusinessLogic() {
		dialog.renderWindow();
	}

}
