package task4;

import javax.swing.JOptionPane;

/**
 * Represents small GUI application that ask user to entering 
 * integer numbers, and returns sum of entered numbers.
 * Using only JOptionPane.
 * @author ajla
 *
 */
public class Task4 {

	public static void main(String[] args) {
		int sum = 0;
		String number;

		// Asking user to enter the first number
		number = JOptionPane.showInputDialog("Please enter the number");
		if (number == null) {
			System.exit(0);
		}
		try {
			sum += Integer.parseInt(number);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Wrong input", null,
					JOptionPane.ERROR_MESSAGE);
		}

		// Asking user to choose if they want to enter another number
		int dialog = JOptionPane.showConfirmDialog(null,
				"Do you want to enter another number?");
		if (dialog == JOptionPane.CANCEL_OPTION) {
			System.exit(0);

		} else {

			// Repeating until user wants it
			while (dialog == JOptionPane.YES_OPTION) {
				number = JOptionPane.showInputDialog("Enter the number");
				if (number == null) {
					System.exit(0);
				}
				try {
					sum += Integer.parseInt(number);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid input", null,
							JOptionPane.ERROR_MESSAGE);
				}
				dialog = JOptionPane.showConfirmDialog(null,
						"Do you want to e another number?");
			}
			if (dialog == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Sum of entered numbers is: " + sum);
			} else if (dialog == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		}

	}

}