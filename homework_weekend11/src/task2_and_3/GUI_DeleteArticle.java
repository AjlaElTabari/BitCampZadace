package task2_and_3;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Represents a GUI form for deleting selected articles.
 * 
 * @author ajla
 *
 */
public class GUI_DeleteArticle extends JFrame {

	// private attributes
	private static final long serialVersionUID = 4842260946622087825L;
	private JPanel pnlMain = new JPanel();
	private JButton btnDelete = new JButton("Delete");
	private DefaultListModel<Article> model = null;
	private JList<Article> listArticles = null;
	private ArrayList<Article> articles = null;

	/**
	 * Constructor for creating form for deleting articles.
	 */
	public GUI_DeleteArticle() {

		pnlMain.setLayout(new BorderLayout());

		// Creating new model for JList.
		model = new DefaultListModel<Article>();
		// Calling method from the DBConnector to get all articles.
		articles = DBConnector.selectAllArticles();
		// Creating a new JList with provided model
		listArticles = new JList<Article>(model);

		// Filling model with articles
		for (int i = 0; i < articles.size(); i++) {
			model.addElement(articles.get(i));
		}

		pnlMain.add(btnDelete, BorderLayout.SOUTH);
		pnlMain.add(listArticles, BorderLayout.CENTER);

		// On click, deleting selected article and refreshing JList.
		btnDelete.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Article a = (Article) listArticles.getSelectedValue();
				DBConnector.deleteArticle(a.getId());

				model.clear();
				articles = DBConnector.selectAllArticles();
				listArticles = new JList<Article>(model);

				for (int i = 0; i < articles.size(); i++) {
					model.addElement(articles.get(i));
				}

				repaint();
			}

		});

		// Main window settings
		add(pnlMain);
		setTitle("Delete article");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Main method that calls constructor that makes new form for deleting
	 * articles.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI_DeleteArticle();
	}

}
