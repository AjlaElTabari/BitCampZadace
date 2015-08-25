package task1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Represents a form that displays all stored complaints as a list.
 * 
 * @author ajla
 *
 */
public class GUI_ComplaintsList extends JFrame {
	private static final long serialVersionUID = 8011891533194721376L;
	private ArrayList<Complaint> complaints = new ArrayList<>();
	private JPanel pnlMain = new JPanel();
	private JPanel pnlButton = new JPanel();
	private JLabel lblComplaintList = new JLabel("List of stored complaints");
	private JTextArea taComplaintList = new JTextArea();
	private JButton btnOk = new JButton("OK");

	public GUI_ComplaintsList() {

		// Panels settings
		pnlMain.setLayout(new BorderLayout());
		pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlButton.setLayout(new BorderLayout());

		pnlMain.add(lblComplaintList, BorderLayout.NORTH);
		pnlMain.add(taComplaintList, BorderLayout.CENTER);
		pnlMain.add(pnlButton, BorderLayout.SOUTH);
		pnlButton.add(btnOk, BorderLayout.EAST);

		lblComplaintList.setPreferredSize(new Dimension(500, 40));

		taComplaintList.setEditable(false);

		JScrollPane scroll = new JScrollPane(taComplaintList);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		pnlMain.add(scroll);

		// Calling a method from the DBConnector for selecting all complaints,
		// and filling an array list.
		complaints = DBConnector.selectAllComplaints();

		// Appending every complaint to the JList area.
		for (Complaint c : complaints) {
			taComplaintList.setText(taComplaintList.getText() + "\n"
					+ c.toString());
		}

		// On mouse click, form needs to be closed.
		btnOk.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}

		});

		// Main window settings.
		add(pnlMain);
		setTitle("Add complaint");
		setSize(500, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Main method that calls constructor that makes the form.
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI_ComplaintsList();
	}

}
