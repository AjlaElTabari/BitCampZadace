package task6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Represents small GUI application that simulates stopwatch.
 * User enters  number of seconds, and app count down seconds to zero.
 * @author ajla
 *
 */
public class Task6 extends JFrame {

	private static final long serialVersionUID = -1950133239786399335L;
	
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private JTextField text = new JTextField();
	private JButton start = new JButton("Start");
	private int value;
	private Timer timer;

	public Task6() {

		//Adding panel to window
		add(panel);

		//Window settings
		setTitle("Task6");
		setSize(200, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		panel.add(label);
		panel.add(text);
		panel.add(start);
	
		setVisible(true);
		
		// Timer settings
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (value > 0) {
					value--;
					label.setText(value + "");
					panel.repaint();
				} else {
					timer.stop();
				}
			}
		});

		// Setting panel layout
		panel.setLayout(new GridLayout(3, 1));
		text.setHorizontalAlignment(JTextField.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		// Button settings
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == start) {
					value = Integer.parseInt(text.getText());
					label.setText("" + value);
					timer.start();
				}

			}
		});
	}

	public static void main(String[] args) {
		new Task6();

	}

}
