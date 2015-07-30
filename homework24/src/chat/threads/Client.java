package chat.threads;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket toZaid = new Socket("localhost", 8888);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(toZaid.getOutputStream()));
			
			writer.write("/web google.ba");
			writer.newLine();
			writer.flush();
			
			System.out.println("Poslala poruku Zaidu.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
