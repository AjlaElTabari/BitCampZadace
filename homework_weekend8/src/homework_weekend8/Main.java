package homework_weekend8;

import javax.swing.JFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = -7470862646059054433L;

	public Main() {

		FileManagement panel = new FileManagement();

		add(panel);

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("File Management");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}