package task3;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Creates GUI application that us a window with two rows of buttons, 
 * named with numbers from 0 to 9. User is allowed to pick up (by pressing buttons)
 * only one number from one column. After that, to user will be presented another 
 * window with printed out selected numbers as array.
 * @author ajla
 *
 */
public class Main extends JFrame {
	
	private static final long serialVersionUID = 2879467318564949375L;
	private static final int INDEX_DIFF = 5;
	private static final int RESULT_ARRAY_LENGTH = 5;
	private static final int NUMBER_OF_BUTTONS = 5;
	
	private JButton[] buttons = new JButton[NUMBER_OF_BUTTONS];
	private String[] arr = new String[RESULT_ARRAY_LENGTH];
	private int counter = 0;

	/**
	 * Constructor Creates a window with belonging buttons.
	 * Adds ActionListener to the buttons.
	 */
	public Main() {
		setLayout(new GridLayout(2, 5));
		// Setting buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton((i) + "");
			buttons[i].setFont(new Font("Cambria", Font.PLAIN, 30));
			// Adding action listener to the button
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}

		setResizable(false);
		setTitle("Task3");
		setSize(500, 100);
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
	 * When user picks up one number from the column, both numbers from that column are disabled.
	 * This is because user is allowed to pick only one number from one column.
	 * @author ajla
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					arr[counter] = buttons[i].getText();
						buttons[i].setEnabled(false);
						if (i < RESULT_ARRAY_LENGTH) {
							buttons[i + INDEX_DIFF].setEnabled(false);
							counter++;
						} else {
							buttons[i - INDEX_DIFF].setEnabled(false);
							counter++;
						}
					} 
				}
			if (counter == INDEX_DIFF) {
				JOptionPane.showMessageDialog(null, Arrays.toString(arr));
				System.exit(EXIT_ON_CLOSE);
			}
		}
	}
}

