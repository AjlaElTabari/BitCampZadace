package task2_and_3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Represents a GUI form for inserting articles to the database.
 * 
 * @author ajla
 *
 */
public class GUI_AddArticle extends JFrame {

	// private attributes
	private static final long serialVersionUID = -3191794551353005781L;
	private JPanel pnlMain = new JPanel();
	private JPanel pnlFields = new JPanel();
	private JPanel pnlButton = new JPanel();
	private JLabel lblName = new JLabel("Name: ");
	private JLabel lblPrice = new JLabel("Price: ");
	private JTextField txtName = new JTextField();
	private JTextField txtPrice = new JTextField();
	private JButton btnAdd = new JButton("Add");

	/**
	 * Constructor that makes form for inserting articles to the database.
	 */
	public GUI_AddArticle() {

		// Pannels settings
		pnlMain.setLayout(new BorderLayout());
		pnlFields.setLayout(new GridLayout(2, 2));
		pnlButton.setLayout(new BorderLayout());

		pnlButton.add(btnAdd, BorderLayout.EAST);
		pnlFields.add(lblName);
		pnlFields.add(txtName);
		pnlFields.add(lblPrice);
		pnlFields.add(txtPrice);

		pnlMain.add(pnlFields, BorderLayout.CENTER);
		pnlMain.add(pnlButton, BorderLayout.SOUTH);

		// On click. collects data from the fields, creates a new Article object
		// and calls method from
		// DBConnector and inserts an article to the database.
		// Clears fields after insertion.
		btnAdd.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Article article = new Article(txtName.getText(), Float
						.parseFloat(txtPrice.getText()));
				DBConnector.addArticleToTheDB(article);
				txtName.setText("");
				txtPrice.setText("");
			}

		});

		// Main window settings
		add(pnlMain);
		setTitle("Add article");
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Main method that calls constructor, that makes a form for inserting
	 * articles.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI_AddArticle();

	}

}
