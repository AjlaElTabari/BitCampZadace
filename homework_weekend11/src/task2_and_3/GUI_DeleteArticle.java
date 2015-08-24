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

public class GUI_DeleteArticle extends JFrame {

	private static final long serialVersionUID = 4842260946622087825L;
	private JPanel pnlMain = new JPanel();
	private JButton btnDelete = new JButton("Delete");
	private DefaultListModel<Article> model = null;
	private JList<Article> listArticles = null;
	private ArrayList<Article> articles = null;
	
	public GUI_DeleteArticle() {
		
		pnlMain.setLayout(new BorderLayout());

		model = new DefaultListModel<Article>();
		articles = DBConnector.selectAllArticles();
		listArticles = new JList<Article>(model);
		
		for (int i = 0; i < articles.size(); i++) {
			model.addElement(articles.get(i));
		}
		
		pnlMain.add(btnDelete, BorderLayout.SOUTH);
		pnlMain.add(listArticles, BorderLayout.CENTER);
		
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
		
		add(pnlMain);
		setTitle("Delete article");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI_DeleteArticle();
	}

}
