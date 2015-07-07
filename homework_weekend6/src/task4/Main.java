package task4;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 8871790462668859823L;
	private JButton[] buttons = new JButton[10];
	private String[] arr = new String[5];
	private int counter = 0;

	public Main() {
		setLayout(new GridLayout(2, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton((i) + "");
			buttons[i].setFont(new Font("Cambria", Font.PLAIN, 30));
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

	public static void main(String[] args) {
		new Main();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					arr[counter] = buttons[i].getText();
						buttons[i].setEnabled(false);
						if (i < 5) {
							buttons[i + 5].setEnabled(false);
							counter++;
						} else {
							buttons[i - 5].setEnabled(false);
							counter++;
						}
					} 
				}
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, Arrays.toString(arr));
				System.exit(EXIT_ON_CLOSE);
			}
		}
	}
}
