package task1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Represents a form for entering complaints. Contains fields that need to be
 * filled, and sends those data to the database.
 * 
 * @author ajla
 *
 */
public class GUI_AddComplaint extends JFrame {
	private static final long serialVersionUID = -3761268692329581822L;
	private JPanel pnlMain = new JPanel();
	private JPanel pnlButton = new JPanel();
	private JLabel lblComplaint = new JLabel("Please enter your complaint");
	private JTextArea taComplaint = new JTextArea();
	private JButton btnAdd = new JButton("Submit");

	/**
	 * Constructor that builds form.
	 */
	public GUI_AddComplaint() {

		pnlMain.setLayout(new BorderLayout());
		pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlButton.setLayout(new BorderLayout());

		pnlMain.add(lblComplaint, BorderLayout.NORTH);
		pnlMain.add(taComplaint, BorderLayout.CENTER);
		pnlMain.add(pnlButton, BorderLayout.SOUTH);
		pnlButton.add(btnAdd, BorderLayout.EAST);

		lblComplaint.setPreferredSize(new Dimension(500, 40));

		// On mouse click, collecting data from the fields and calling a method
		// from DBConnector to store entered complaint.
		btnAdd.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Complaint complaint = new Complaint(taComplaint.getText());
				DBConnector.storeComplaintToTheDB(complaint);
				setVisible(false);
			}

		});

		// Display settings for main frame.
		add(pnlMain);
		setTitle("Add complaint");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * Main method that calls constructor that makes complaint form.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI_AddComplaint();
	}

}
