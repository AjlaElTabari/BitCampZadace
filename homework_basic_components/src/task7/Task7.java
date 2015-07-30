package task7;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Represents small GUI app for drawing circle.
 * User needs to select position for circle center,
 * by clicking on desired location. Than they need to 
 * change slider value to increase or decrease the circle
 * If user does not pick position first, nothing will happen 
 * @author ajla
 */
public class Task7 extends JFrame {

	private static final long serialVersionUID = -4639553590382237119L;
	
	// Declaring variables
	private int radius = 0;
	private JPanel panel = new MyPanel();
	private int positionX;
	private int positionY;
	private boolean positionSelected = false;
	private JSlider slider = new JSlider(0, 300, radius);

	public Task7() {

		// Panel settings
		panel.setLayout(new BorderLayout());
		add(panel);

		// Window settings
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task7");

		// Adding slider to Panel
		panel.add(slider, BorderLayout.SOUTH);

		setVisible(true);
		
		// Adding ChangeListener to slider
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(positionSelected) {
					radius = slider.getValue();
				} 
			}
		});

		// Adding MouseListener to Panel
		// If user don't select position for circle center nothing will happen
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				positionX = e.getX();
				positionY = e.getY();
				positionSelected = true;
			}
		});
	}

	public static void main(String[] args) {
		new Task7();
	}

	private class MyPanel extends JPanel {

		private static final long serialVersionUID = 1099034440099780848L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawOval(positionX - radius / 2, positionY - radius / 2, radius, radius);
			repaint();
		}
	}

}
