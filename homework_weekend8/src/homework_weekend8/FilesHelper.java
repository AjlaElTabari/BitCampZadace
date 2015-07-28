package homework_weekend8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.DefaultListModel;

public class FilesHelper {
	public static void copyFileInDirectory(File directory, File file,
			Path destination, Path target, DefaultListModel listModel) {
		if (directory.exists()) {
			destination = Paths.get(directory + "/" + file.getName());
		} else {
			directory.mkdir();
			destination = Paths.get(directory + "/" + file.getName());
		}
		try {
			Files.copy(target, destination, StandardCopyOption.REPLACE_EXISTING);
			listModel.addElement(file.getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
