package homework_weekend8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;

public class Browsing implements ActionListener {

	public enum PicturesExtenstions {
		JPG, PNG, GIF
	};

	public enum TextExtenstions {
		TXT, DOC, DOCX, PDF
	};

	public enum AudioExtenstions {
		MP3, MID, WMA
	};

	public enum VideoExtenstions {
		AVI, MP4, WMV
	};

	private File selected = null;
	private File documents = null;
	private Path destination = null;

	private DefaultListModel documentsListModel = new DefaultListModel();
	private DefaultListModel picturesListModel = new DefaultListModel();
	private DefaultListModel audioListModel = new DefaultListModel();
	private DefaultListModel videoListModel = new DefaultListModel();
	private DefaultListModel otherListModel = new DefaultListModel();

	public void actionPerformed(ActionEvent e) {
		JFileChooser open = new JFileChooser();
		open.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int option = open.showOpenDialog(null);

		if (option == open.APPROVE_OPTION) {

			File file = open.getSelectedFile();
			Path target = Paths.get(file.getPath());

			String extension = file.getName().substring(
					file.getName().lastIndexOf(".") + 1);

			if (extension.equalsIgnoreCase(TextExtenstions.DOC.toString())
					|| extension.equalsIgnoreCase(TextExtenstions.TXT
							.toString())
					|| extension.equalsIgnoreCase(TextExtenstions.DOCX
							.toString())
					|| extension.equalsIgnoreCase(TextExtenstions.PDF
							.toString())) {
				documents = new File(selected.getPath() + "/Documents");
				FilesHelper.copyFileInDirectory(documents, file, destination,
						target, documentsListModel);
			} else if (extension.equalsIgnoreCase(AudioExtenstions.MP3
					.toString())
					|| extension.equalsIgnoreCase(AudioExtenstions.MID
							.toString())
					|| extension.equalsIgnoreCase(AudioExtenstions.WMA
							.toString())) {
				File audio = new File(selected.getPath() + "/Audio");
				FilesHelper.copyFileInDirectory(audio, file, destination,
						target, audioListModel);
			} else if (extension.equalsIgnoreCase(PicturesExtenstions.GIF
					.toString())
					|| extension.equalsIgnoreCase(PicturesExtenstions.JPG
							.toString())
					|| extension.equalsIgnoreCase(PicturesExtenstions.PNG
							.toString())) {
				File pictures = new File(selected.getPath() + "/Pictures");
				FilesHelper.copyFileInDirectory(pictures, file, destination,
						target, picturesListModel);
			} else if (extension.equalsIgnoreCase(VideoExtenstions.AVI
					.toString())
					|| extension.equalsIgnoreCase(VideoExtenstions.MP4
							.toString())
					|| extension.equalsIgnoreCase(VideoExtenstions.WMV
							.toString())) {
				File video = new File(selected.getPath() + "/Video");
				FilesHelper.copyFileInDirectory(video, file, destination,
						target, videoListModel);
			} else {
				File other = new File(selected.getPath() + "/Other");
				FilesHelper.copyFileInDirectory(other, file, destination,
						target, otherListModel);
			}
		}
	}
}
