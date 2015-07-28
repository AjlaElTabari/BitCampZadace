package homework_weekend8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class FileManagement extends JPanel {

	private static final long serialVersionUID = -7182519482021957303L;

	public enum picturesExtenstions {JPG, PNG, GIF, BMP};
	public enum textExtenstions {TXT, DOC, DOCX, MD, PDF, RTF, DAT};
	public enum audioExtenstions {MP3, M3U, M4U, MID, WMA};
	public enum videoExtenstions {AVi, FLV, M4V, MP4, MPG, WMV};
	
	private File selected = null;

	File documents = null;

	private File selectedToDelete;

	private Path destination = null;
	private JButton browse = new JButton("Browse");
	private JButton select = new JButton("Select Folder");
	private JButton delete = new JButton("Delete");
	private JPanel buttons = new JPanel();
	private JPanel fileList = new JPanel();

	private DefaultListModel documentsListModel = new DefaultListModel();
	private JList documentsList = new JList(documentsListModel);

	private DefaultListModel picturesListModel = new DefaultListModel();
	private JList picturesList = new JList(picturesListModel);

	private DefaultListModel audioListModel = new DefaultListModel();
	private JList audioList = new JList(audioListModel);

	private DefaultListModel videoListModel = new DefaultListModel();
	private JList videoList = new JList(videoListModel);

	private DefaultListModel otherListModel = new DefaultListModel();
	private JList otherList = new JList(otherListModel);



	public FileManagement() {
		setLayout(new BorderLayout());

		browse.addActionListener(new Browsing());

		select.addActionListener(new SearchAction());

		buttons.setLayout(new GridLayout(2, 1));
		buttons.add(select);
		buttons.add(browse);
		add(buttons, BorderLayout.NORTH);
		fileList.setBorder(BorderFactory.createTitledBorder("Files"));
		fileList.setLayout(new BorderLayout());

		fileList.setLayout(new GridLayout(1, 5));

		createList(fileList, documentsList, "Documents");
		createList(fileList, picturesList, "Pictures");
		createList(fileList, audioList, "Audio");
		createList(fileList, videoList, "Video");
		createList(fileList, otherList, "Other");

		add(fileList, BorderLayout.CENTER);
		add(delete, BorderLayout.SOUTH);

		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				deleteSelected(documentsList, documentsListModel);
				deleteSelected(picturesList, picturesListModel);
				deleteSelected(audioList, audioListModel);
				deleteSelected(videoList, videoListModel);
				deleteSelected(otherList, otherListModel);
			}
		});

	}

	private void createList(JPanel panel, JList list, String title) {
		panel.add(list);
		panel.add(new JScrollPane(list));
		list.setBorder(BorderFactory.createTitledBorder(title));
	}

	private void deleteSelected(JList list, DefaultListModel listModel) {
		String deletedPath = selectedToDelete.getPath() + "\\"
				+ list.getModel().getElementAt(list.getSelectedIndex());
		File deleted = new File(deletedPath);
		listModel.remove(list.getSelectedIndex());
		deleted.delete();
	}

	private class SearchAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser open = new JFileChooser();
			open.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int option = open.showOpenDialog(null);
			if (option == open.APPROVE_OPTION) {
				selected = open.getSelectedFile();

				fillList("Documents", documentsList, documentsListModel);
				fillList("Pictures", picturesList, picturesListModel);
				fillList("Audio", audioList, audioListModel);
				fillList("Video", videoList, videoListModel);
				fillList("Other", otherList, otherListModel);

			}
		}
	}

	private void fillList(String folder, JList list, DefaultListModel listModel) {
		selectedToDelete = new File(selected.getPath() + "/" + folder);

		if (selectedToDelete.isDirectory() == false) {
			if (selectedToDelete.exists() == false) {
				listModel.clear();
			}
		} else {
			for (int i = 0; i < selectedToDelete.list().length; i++) {
				listModel.add(i, selectedToDelete.list()[i]);
			}
			list.setVisibleRowCount(5);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
	}
}
