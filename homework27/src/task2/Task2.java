package task2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Represents a tool to make a negative from the provided picture. For every
 * pixel, it changes color to the completely opposite color.
 * 
 * @author ajla
 *
 */
public class Task2 extends JFrame {

	// Declaring attributes
	private static final long serialVersionUID = 4211901136239424815L;
	private BufferedImage imgToRender;
	private JPanel pnlMain;
	private LinkedBlockingQueue<Runnable> consumers = new LinkedBlockingQueue<Runnable>();
	private ArrayList<Producer> producers = new ArrayList<Producer>();

	/**
	 * Constructor that makes new JFrame
	 */
	public Task2() {

		pnlMain = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgToRender, 0, 0, null);
				repaint();
			}
		};

		// Try to read provided image
		try {
			imgToRender = ImageIO
					.read(new File("src/task2/MyBelovedLondon.JPG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Frame settings
		add(pnlMain);
		setTitle("Negative");

		// Adjusting window size to the picture size
		setSize(imgToRender.getWidth(), imgToRender.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Method that starts process of changing colors and making a negative.
	 */
	public void startProcess() {

		// Making 8 threads, that is maximum that testing computer supports.
		for (int i = 0; i < 8; i++) {
			Producer producer = new Producer();
			producer.start();
			producers.add(producer);
		}

		// Creating and adding new consumer to the list of tasks.
		for (int i = 0; i < getHeight(); i++) {
			consumers.add(new Consumer(i));
		}

		// Joining the threads
		for (int i = 0; i < producers.size(); i++) {
			try {
				producers.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Represents producer side of Producer - Consumer methodology of threads
	 * implementation. It will keep taking tasks from the queue, until queue is
	 * empty.
	 * 
	 * @author ajla
	 *
	 */
	private class Producer extends Thread {

		@Override
		public void run() {
			while (!consumers.isEmpty()) {
				try {
					consumers.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Represents an actual task that needs to be done. It will receive a number
	 * of the line that needs to be repainted and it will do all repainting.
	 * 
	 * @author ajla
	 *
	 */
	private class Consumer implements Runnable {
		private int line;

		public Consumer(int line) {
			this.line = line;
		}

		@Override
		public void run() {
			for (int i = 0; i < imgToRender.getWidth(); i++) {
				int pixel = imgToRender.getRGB(i, line);
				imgToRender.setRGB(i, line, 255 - pixel);
			}
		}
	}

	/**
	 * Main method to actually execute this process.
	 * @param args
	 */
	public static void main(String[] args) {
		new Task2().startProcess();
	}
}
