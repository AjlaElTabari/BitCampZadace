package task1;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Creates GUI application that us a window with a row of buttons, 
 * named with numbers from 0 to 9. User is allowed to pick up (by pressing buttons)
 * three numbers. After that, to user will be presented another window with printed 
 * out three digits number formed from selected numbers.
 * @author ajla
 *
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 993668091274336134L;
	private static final int PICKED_NUMBERS_COUNTER = 1;
	private static final int MAX_NUMBERS = 3;
	private static final int NUMBER_OF_BUTTONS = 10;
	private JButton[] buttons = new JButton[NUMBER_OF_BUTTONS];
	private String res = "";
	private int counter = 1;

	public Main() {
		setLayout(new GridLayout(10, 1));
		// Creating buttons and label
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton((i) + "");
			buttons[i].setFont(new Font("Cambria", Font.BOLD, 30));
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}

		// Setting the layout
		setResizable(false);
		setTitle("Task1");
		setSize(200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Creates new instance of our GUI app
	public static void main(String[] args) {
		new Main();
	}

	/**
	 * Creating a class named Action that implements ActionListener interface.
	 * It allows us to create buttons behviour. 
	 * There is an array of 10 buttons. User is allowed to pick up three numbers
	 * (by pressing buttons). After that, another window will be opened, presenting to the user
	 * three digits number, formed from picked numbers
	 * @author ajla
	 *
	 */	
	private class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					if (counter == MAX_NUMBERS) {
						res += buttons[i].getText();
						JOptionPane.showMessageDialog(null, "Number " + res);
						System.exit(EXIT_ON_CLOSE);
						counter = PICKED_NUMBERS_COUNTER;
						res = "";
						buttons[i].setEnabled(false);
					} else {
						res += buttons[i].getText();
						counter++;
						buttons[i].setEnabled(false);
					}

				}
			}
		}

	}

}
