package task5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Represents small GUI application to mix colors
 * @author ajla
 *
 */
public class Task5 extends JFrame {

	private static final long serialVersionUID = -5112672093506590985L;
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;
	
	// Declaring panels
	private JPanel pnlMain = new JPanel();
	private JPanel pnlSliders = new JPanel();
	private JPanel pnlLabels = new JPanel();
	private JPanel pnlSlider = new JPanel();
	private JPanel pnlColorPrev = new JPanel();

	// Declaring labels
	private JLabel lblRed = new JLabel("Red");
	private JLabel lblGreen = new JLabel("Green");
	private JLabel lblBlue = new JLabel("Blue");

	// Declaring sliders
	JSlider redSlider = new JSlider(0, 255);
	JSlider greenSlider = new JSlider(0, 255);
	JSlider blueSlider = new JSlider(0, 255);

	public Task5() {

		// Setting panels layouts
		pnlMain.setLayout(new BorderLayout());
		pnlSliders.setLayout(new BorderLayout());
		pnlLabels.setLayout(new GridLayout(3, 1));
		pnlSlider.setLayout(new GridLayout(3, 1));

		// initializing sliders
		initSlider(redSlider, "Red");
		initSlider(greenSlider, "Green");
		initSlider(blueSlider, "Blue");

		// Positioning all components
		pnlLabels.setPreferredSize(new Dimension(80, 150));
		pnlColorPrev.setBackground(new Color(red, green, blue));
		pnlColorPrev.setPreferredSize(new Dimension(500, 150));

		pnlLabels.add(lblRed, BorderLayout.WEST);
		pnlSlider.add(redSlider, BorderLayout.CENTER);

		pnlLabels.add(lblGreen, BorderLayout.WEST);
		pnlSlider.add(greenSlider, BorderLayout.CENTER);

		pnlLabels.add(lblBlue, BorderLayout.WEST);
		pnlSlider.add(blueSlider, BorderLayout.CENTER);

		pnlMain.add(pnlSliders, BorderLayout.CENTER);
		pnlMain.add(pnlColorPrev, BorderLayout.SOUTH);

		pnlSliders.add(pnlLabels, BorderLayout.WEST);
		pnlSliders.add(pnlSlider, BorderLayout.CENTER);
		add(pnlMain);

		// Window properties
		setTitle("Task5");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	/**
	 * Initialize slider
	 * @param slider
	 * @param name
	 */
	private void initSlider(JSlider slider, String name) {
		slider.setName(name);
		slider.setValue(0);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();

				switch (name) {
				case "Red":
					red = changed.getValue();
					break;
				case "Green":
					green = changed.getValue();
					break;
				case "Blue":
					blue = changed.getValue();
					break;
				}
				updateColorPreview();
			}
		});
	}

	/**
	 * Update ColorPreview panel, to show picked color
	 */
	private void updateColorPreview() {
		pnlColorPrev.setBackground(new Color(red, green, blue));
	}

	public static void main(String[] args) {

		new Task5();
	}

}
