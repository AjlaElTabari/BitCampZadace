package task5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 /** Creates GUI application that represents us a window with four buttons
 * and one label. Buttons allows us to insert characters (shown in label after that)
 * and to iterate through the array of characters.
 * Also, we are able to insert additional characters during iteration.
 * @author ajla
 *
 */
public class Main extends JFrame {

	// Creating buttons and label
	private static final long serialVersionUID = 3509159316291937485L;

	private static final char POSITIONER = '_';
	private JButton buttonGoLeft = new JButton("<");
	private JLabel chars = new JLabel(Character.toString(POSITIONER));
	private JButton buttonGoRight = new JButton(">");
	private JButton buttonChar = new JButton("Generate char");
	private JButton buttonInsert = new JButton("Insert");
	private String characters = "";

	/**
	 * Constructor Creates a window with belonging buttons.
	 * Adds ActionListener to the buttons.
	 */
	public Main() {

		setLayout(new BorderLayout());
		// Setting buttons
		add(buttonGoLeft, BorderLayout.WEST);
		add(chars, BorderLayout.CENTER);
		add(buttonGoRight, BorderLayout.EAST);
		add(buttonChar, BorderLayout.NORTH);
		add(buttonInsert, BorderLayout.SOUTH);

		// Adding action listener to the buttons
		buttonGoLeft.addActionListener(new Action());
		buttonGoRight.addActionListener(new Action());
		buttonChar.addActionListener(new Action());
		buttonInsert.addActionListener(new Action());

		chars.setHorizontalAlignment(JLabel.CENTER);

		// Setting the layout
		setResizable(false);
		setTitle("Task4");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Creating a class named Action that implements ActionListener interface.
	 * It allows us to create buttons behviour. 
	 * There are four buttons: 
	 * buttonChar - generates random lowercase character every time it is pressed,
	 * buttonGoRight - moves position character "_" by one place to the right,
	 * buttonGoLeft - moves position character "_" by one place to the left, and
	 * buttonInsert - inserts earlier randomly generated character to the place marked with positioner "_"
	 * @author ajla
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// randomly generate one lowercase character
			Random r = new Random();
			char newChar = (char) (r.nextInt(26) + 'a');

			// if buttonChar is pressed, early generated 
			// random character is shown as buttonChar text
			if (e.getSource() == buttonChar) {
				buttonChar.setText(Character.toString(newChar));
			}
			// if buttonInsert is pressed, earlier randomly generated
			// character will be inserted to the place marked with positioner 
			else if (e.getSource() == buttonInsert) {
				int index = chars.getText().indexOf(POSITIONER);
				characters = chars.getText().substring(0, index);
				characters += buttonChar.getText() + POSITIONER;
				characters += chars.getText().substring(index + 1,
						chars.getText().length());
				chars.setText(characters);
			} 
			// if buttonGoLeft is pressed, positioner will be moved by one place to the left
			else if (e.getSource() == buttonGoLeft) {
				String newCharacters = "";
				int index = chars.getText().indexOf(POSITIONER);

				if (index > 0) {
					index--;
					newCharacters = characters.substring(0, index);
					newCharacters += POSITIONER;
					newCharacters += characters.substring(index,
							characters.length() - 1);

					chars.setText(newCharacters);
				}
			} 
			// if buttonGoRight is pressed, positioner will be moved by one place to the right
			else if (e.getSource() == buttonGoRight) {
				String newCharacters = "";
				int index = chars.getText().indexOf(POSITIONER);
				if (index < characters.length()) {
					index++;
					newCharacters = characters.substring(0, index);
					newCharacters += POSITIONER;
					if (index != characters.length()) {
						newCharacters += characters.substring(index,
								characters.length() - 1);
						chars.setText(newCharacters);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// Creates new instance of our GUI app
		new Main();
	}

}
