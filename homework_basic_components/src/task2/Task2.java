package task2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Task2 extends JFrame {

	private static final long serialVersionUID = 6223542897737322774L;
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Font Preview");
	
	JCheckBox cbBold = new JCheckBox("Bold");
	JCheckBox cbItalic = new JCheckBox("Italic");
	
	JButton apply = new JButton("Apply");
	
	Font fPlain = new Font("Serif", Font.PLAIN, 15);
	Font fBold = new Font("Serif", Font.BOLD, 15);
	Font fItalic = new Font("Serif", Font.ITALIC, 15);
	Font fBoldAndItalic = new Font("Serif", Font.BOLD + Font.ITALIC, 15);
	
	public Task2() {
		
		apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeFont();
			}
			
		});		
		setTitle("My lucky frame");
		setSize(300, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label.setPreferredSize(new Dimension(300, 100));
		label.setHorizontalAlignment(JLabel.CENTER);
		apply.setPreferredSize(new Dimension(300, 50));
		
		add(panel);
		panel.add(label);
		panel.add(cbBold);
		panel.add(cbItalic);
		panel.add(apply);
		

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task2();

	}
	
	private void changeFont() {
		if (cbBold.isSelected() && cbItalic.isSelected()) {
			label.setFont(fBoldAndItalic);
		} else if (!cbBold.isSelected() && cbItalic.isSelected()) {
			label.setFont(fItalic);
		} else if (cbBold.isSelected() && !cbItalic.isSelected()) {
			label.setFont(fBold);
		} else {
			label.setFont(fPlain);
		}
	}

}
