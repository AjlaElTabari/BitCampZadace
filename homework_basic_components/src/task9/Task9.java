package task9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Small GUI application that allows user to select file 
 * from the specific location and prints out everything 
 * from that file to the text area.
 * @author ajla
 *
 */
public class Task9 extends JFrame {

	private static final long serialVersionUID = -9088505779174744912L;
	
	//Declaring variables
	private JPanel pnlMain = new JPanel();
	private JLabel lblLocation = new JLabel("File location");
	private JTextField tfLocation = new JTextField();
	private JTextArea taText = new JTextArea();

	public Task9() {

		taText.setLineWrap(true);
		tfLocation.setPreferredSize(new Dimension(400, 25));
		pnlMain.add(lblLocation);
		pnlMain.add(tfLocation);
		
		//Window settings
		setLayout(new BorderLayout());
		add(pnlMain, BorderLayout.NORTH);
		add(taText, BorderLayout.CENTER);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Text from File");
		setVisible(true);
		
		//Adding KeyListener to text field
		tfLocation.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				String str = "";
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						TextIO.readFile(tfLocation.getText());
						while (!TextIO.eof()) {
							str += TextIO.getln() + "\n";
						} 
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, "File could not be found!", null,
								JOptionPane.ERROR_MESSAGE);
					}

					taText.setText(str);
					repaint();
				}
			}
		});
	}

	public static void main(String[] args) {
		new Task9();

	}

}
