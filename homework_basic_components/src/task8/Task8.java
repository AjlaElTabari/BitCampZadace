package task8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Represents small GUI application for registration.
 * Registration will be successful if username and password 
 * are longer than 6 characters, and if password contains at least
 * one special character and one number.
 * @author ajla
 *
 */
public class Task8 extends JFrame {

	private static final long serialVersionUID = 1788825113584408633L;

	// Declaring variables
	private JPanel pnlMain = new JPanel();
	private JPanel pnlTextFields = new JPanel();
	private JPanel pnlButtons = new JPanel();

	private JButton btnClear = new JButton("Clear");
	private JButton btnSubmit = new JButton("Submit");

	private JTextField tfUsername = new JTextField();
	private JPasswordField pfPassword = new JPasswordField();
	private JPasswordField pfReenterPassword = new JPasswordField();

	public Task8() {

		// Main panel layout
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(pnlTextFields, BorderLayout.CENTER);

		// TextFields panel layout
		pnlTextFields.setLayout(new GridLayout(3, 2));

		// Adding text fields to main panel
		pnlTextFields.add(new JLabel("Username: "));
		pnlTextFields.add(tfUsername);
		pnlTextFields.add(new JLabel("Password: "));
		pnlTextFields.add(pfPassword);
		pnlTextFields.add(new JLabel("Reenter password: "));
		pnlTextFields.add(pfReenterPassword);

		// Buttons panel position
		pnlMain.add(pnlButtons, BorderLayout.SOUTH);

		// Adding button
		pnlButtons.add(btnClear);
		pnlButtons.add(btnSubmit);

		// Adding main panel to window
		add(pnlMain);

		// Window settings
		setSize(300, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 8");
		setVisible(true);

		// Adding ActionListener to Submit button
		btnSubmit.addActionListener(new Submit());

		// Adding ActionListener to Clear button
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnClear) {
					tfUsername.setText("");
					pfPassword.setText("");
					pfReenterPassword.setText("");
				}
			}
		}); 
	}

	public static void main(String[] args) {
		new Task8();
	}

	private class Submit implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {

				// Turning password into string
				String passwordText = String.valueOf(pfPassword.getPassword());
				String passwordRetypeText = String.valueOf(pfReenterPassword
						.getPassword());

				// Checking password for special characters

				Pattern pSpecialCharacters = Pattern.compile("[^a-z0-9 ]",
						Pattern.CASE_INSENSITIVE);
				Matcher mSpecialCharacters = pSpecialCharacters
						.matcher(passwordText);
				boolean containsSpecialCharacters = mSpecialCharacters.find();

				// Checking password for numbers
				Pattern pNumbers = Pattern.compile("^[0-9]");
				Matcher mNumbers = pNumbers.matcher(passwordText);
				boolean containsNumbers = mNumbers.find();

				// Username must be at least 6 characters long
				if (tfUsername.getText().length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Username must be at least 6 characters long!");
					tfUsername.setText("");
					pfPassword.setText("");
					pfReenterPassword.setText("");

					// Password must be at least 6 characters long
				} else if (passwordText.length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Password must be at least 6 characters long!");
					pfPassword.setText("");
					pfReenterPassword.setText("");

					// Password must have at least one special character and at
					// least one number
				} else if (!containsSpecialCharacters) {
					JOptionPane
							.showMessageDialog(null,
									"Password must contain at least one special character!");
					pfPassword.setText("");
					pfReenterPassword.setText("");
				} else if (!containsNumbers) {
					JOptionPane.showMessageDialog(null,
							"Password must contain at least one number!");
					pfPassword.setText("");
					pfReenterPassword.setText("");

					// Retyped password must match with password
				} else if (!passwordText.equals(passwordRetypeText)) {
					JOptionPane
							.showMessageDialog(null, "Passwords dont match!");
					pfPassword.setText("");
					pfReenterPassword.setText("");
				} else {
					JOptionPane
							.showMessageDialog(null,
									"Congratulation! Your registration was successful!");
					System.exit(0);
				}

			}

		}

	}
}
