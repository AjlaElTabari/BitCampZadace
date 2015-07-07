package task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** Creates GUI application that represents us a window with two buttons
* and one label. Buttons allows us to insert randomly picked names and surnames,
* making different combinations, and showing them in the label.
* Contains two inner classes that contain names and surnames. 
* @author ajla
*
*/
public class Main extends JFrame {

	private static final long serialVersionUID = 4144316998591105774L;
	
	// Creating buttons and label
	private JButton buttonName = new JButton("FirstName");
	private JLabel fullName = new JLabel("");
	private JButton buttonSurname = new JButton("LastName");
	private String name = "";
	private String surname = "";
	
	/**
	 * Constructor Creates a window with belonging buttons.
	 * Adds ActionListener to the buttons.
	 */
	public Main () {
		
		setLayout(new BorderLayout());

		// Setting buttons
		add(buttonName, BorderLayout.WEST);
		add(fullName, BorderLayout.CENTER);
		add(buttonSurname, BorderLayout.EAST);
		
		// Adding action listener to the buttons
		buttonName.addActionListener(new Action());
		buttonSurname.addActionListener(new Action());
		
		fullName.setHorizontalAlignment(JLabel.CENTER);
		
		// Setting the layout
		setResizable(false);
		setTitle("Task2");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Creating a class named Action that implements ActionListener interface.
	 * It allows us to create buttons behviour. 
	 * There are two buttons: 
	 * buttonName - returns randomly picked name and shows it in the label,
	 * buttonSurname - returns randomly picked surname and shows it in the label.
	 * @author ajla
	 *
	 */	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonName) {
				name = new Names().toString();
				fullName.setText(name + " " + surname);
			} else if (e.getSource() == buttonSurname) {
				surname = new Surnames().toString();
				fullName.setText(name + " " + surname);
			}
		}
	}
	
	/**
	 * Inner class that represents kind of names database.
	 * Contains an array of names.
	 * Has two methods: generateName(), that returns randomly picked up one name, and
	 * toString(), that prints out that randomly picked name.
	 * @author ajla
	 *
	 */
	public static class Names {
		private static int NAMES_NUMBER = 6;
		private String[] names = {"Sheldon", "Leonard", "Raj", "Howard", "Penny", "Leslie", "Berry"};

		/**
		 * Using Math.random function, generates one random number
		 * @returns a name that is located on that, randomly generated index, from names array
		 */
		public String generateName() {
			int index = (int)(Math.random() * NAMES_NUMBER);
			return names[index];
		}
		
		/**
		 * Prints out picked name
		 */
		public String toString() {
			return generateName();
		}
	}
	
	/**
	 * Inner class that represents kind of surnames database.
	 * Contains an array of surnames.
	 * Has two methods: generateSurname(), that returns randomly picked up one surname, and
	 * toString(), that prints out that randomly picked surname.
	 * @author ajla
	 *
	 */
	public static class Surnames {
		private static int SURNAMES_NUMBER = 6;
		private String[] surnames = {"Cooper", "Hofstadter", "Koothrappali", "Wolowitz", "Something", "Winkle", "Kripke"};

		/**
		 * Using Math.random function, generates one random number
		 * @returns a surname that is located on that, randomly generated index, from surnames array
		 */
		public String generateSurname() {
			int index = (int)(Math.random() * SURNAMES_NUMBER);
			return surnames[index];
		}
		
		/**
		 * Prints out picked surname
		 */
		public String toString() {
			return generateSurname();
		}
	}

	// Creates new instance of our GUI app
	public static void main(String[] args) {
		new Main();
	}

}
