package task3.interrupting_a_thread;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Represents a small GUI application that has only a label and a button.
 * Application has one thread that writes letters of alphabet, letter by letter.
 * It stops when button is pressed. Application needs to stay opened.
 * 
 * @author ajla
 *
 */
public class InterruptingAThread extends JFrame {

	private static final long serialVersionUID = 4768679256765684805L;
	private JLabel lblLetters = new JLabel();
	private JButton btnStop = new JButton("STOP");

	/**
	 * Constructor that makes a GUI frame with desired components.
	 */
	public InterruptingAThread() {
		
		// Label settings
		lblLetters.setLayout(new BorderLayout());
		lblLetters.add(btnStop, BorderLayout.SOUTH);

		// Declaring, initializing and starting the thread.
		Thread lettersThread = new MyThread();
		lettersThread.start();

		lblLetters.setText(lettersThread.toString());
		lblLetters.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetters.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 20));

		// Adding action listener to the button
		// Pressing the button results with thread interrupting.
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lettersThread.interrupt();
			}
		});

		// Frame settings
		add(lblLetters);
		setTitle("Letters");
		setSize(400, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * Main method that makes new thread.
	 * @param args
	 */
	public static void main(String[] args) {
		new InterruptingAThread();
	}

	/**
	 * Inner class that represents Thread.
	 * @author ajla
	 *
	 */
	private class MyThread extends Thread {

		@Override
		public void run() {
			String letters = "";
			try {
				for (int i = 65; i <= 90; i++) {
					letters += (char) i;
					lblLetters.setText(letters);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread is interrupted.");
			}
		}

	}
}