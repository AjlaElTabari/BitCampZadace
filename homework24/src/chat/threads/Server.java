package chat.threads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			ServerSocket server = new ServerSocket(2706);
			
			while (true) {
				Socket client = server.accept();
				
				Thread t = new Thread(new MyThread(client));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static class MyThread implements Runnable {
		public Socket client;
		
		public MyThread(Socket client) {
			this.client = client;
		}
		
		@Override
		public void run() {
			
			BufferedReader reader;
			try {
				reader = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				
				String msg = reader.readLine();
				
				System.out.println(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
						client.getOutputStream()));
				
				writer.write("blll");
				writer.newLine();
				writer.flush();			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Poslala poruku Nareni.");
			
		}
		
	}
}
