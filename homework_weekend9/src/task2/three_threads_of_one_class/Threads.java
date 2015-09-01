package task2.three_threads_of_one_class;

import java.util.Random;

/**
 * Program with three threads, every thread does something different. Every
 * thread needs to wait all threads before to be finished.
 * 
 * @author ajla
 *
 */
public class Threads {

	public static void main(String[] args) {

		// Declaring and initializing threads
		Thread t1 = new Thread(new MyThread1());
		Thread t2 = new Thread(new MyThread2());
		Thread t3 = new Thread(new MyThread3());

		// Starting threads
		// Defining order of executon
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inner class that represents Thread. 
	 * @author ajla
	 *
	 */
	static class MyThread1 implements Runnable {

		@Override
		public void run() {
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println(i);
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Inner class that represents Thread. 
	 * @author ajla
	 *
	 */
	static class MyThread2 implements Runnable {

		@Override
		public void run() {
			try {
				for (int i = 0; i < 4; i++) {
					System.out.println("BitCamp");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Inner class that represents Thread. 
	 * @author ajla
	 *
	 */
	static class MyThread3 implements Runnable {

		@Override
		public void run() {
			try {
				Random rand = new Random();
				int randomNum = 0;
				for (int i = 0; i < 5; i++) {
					randomNum = rand.nextInt((5)) + 1;
					System.out.println(randomNum);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
