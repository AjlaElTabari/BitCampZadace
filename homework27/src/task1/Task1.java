package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Takes first letter from the provided file, and counts how many times that
 * letter repeats in the file.
 * 
 * @author ajla
 *
 */
public class Task1 {

	// Declaring attributes
	private static int counter = 0;
	private static BufferedReader reader = null;
	private static LinkedBlockingQueue<Runnable> consumers;
	private static ArrayList<Producer> producers;
	private static boolean isFirstLetter = true;
	private static String firstLetter;

	// Object that will be used to synchronize counter
	private static Object lock = new Object();

	public static void main(String[] args) {

		consumers = new LinkedBlockingQueue<Runnable>();
		try {
			reader = new BufferedReader(new FileReader(new File(
					"src/task1/file.txt")));

			// Reading lines from file, and adding them to the queue
			while (reader.ready()) {
				String line = reader.readLine();
				if (isFirstLetter) {
					firstLetter = Character.toString(line.charAt(0));
					isFirstLetter = false;
				}

				// every line is a task
				consumers.add(new Consumer(line));
			}

			producers = new ArrayList<>();
			// Creating a new producer
			for (int i = 0; i < 8; i++) {
				Producer producer = null;

				try {
					producer = new Producer();
					producer.start();
					producer.join();
				} catch (InterruptedException e) {
					System.out.println("Another producer couldn't be joined.");
					e.printStackTrace();
				}
				producers.add(producer);
			}

			System.out.printf("Letter '%s' appears %d times in provided file.",
					firstLetter, counter);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Represents a task that counts desired letter in the provided line.
	 * 
	 * @author ajla
	 *
	 */
	private static class Consumer implements Runnable {
		private String line;

		public Consumer(String line) {
			this.line = line;
		}

		@Override
		public void run() {
			for (int i = 0; i < line.length(); i++) {

				if (firstLetter.equalsIgnoreCase(Character.toString(line
						.charAt(i)))) {
					synchronized (lock) {
						counter++;
					}
				}
			}
		}
	}

	/**
	 * Represents a producer. Takes job from the queue and starts it.
	 * 
	 * @author ajla
	 *
	 */
	static class Producer extends Thread {

		@Override
		public void run() {
			while (!consumers.isEmpty()) {
				try {
					Runnable job = consumers.take();
					job.run();
				} catch (InterruptedException e) {
					System.out
							.println("Another job couldn't be taken from the queue.");
					e.printStackTrace();
				}
			}
		}
	}

}
