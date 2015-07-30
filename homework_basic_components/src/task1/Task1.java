package task1;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task1 extends JFrame {

	private static final long serialVersionUID = 4770525210171583125L;
	private int size = 15;
	JPanel panel = new JPanel();
	JLabel label = new JLabel("I need help");
	JSlider slider = new JSlider(10, 30, 15);
	
	
	public Task1() {
		setTitle("My lucky frame");
		setSize(200, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label.setPreferredSize(new Dimension(200, 100));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Sarif", Font.PLAIN, size));
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				label.setFont(new Font("Sarif", Font.PLAIN, slider.getValue()));
			}
			
		});
		
		add(panel);
		panel.add(label);
		panel.add(slider);
		

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task1();

	}

}
