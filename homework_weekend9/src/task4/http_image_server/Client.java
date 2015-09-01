package task4.http_image_server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 2706);
			
			FileInputStream in = new FileInputStream("Myao.jpg");
			
			OutputStream out = socket.getOutputStream();
			
			byte[] data = new byte[1024];
			int bytesRead;
			
			// Radi dok ima sta citati
			while ((bytesRead = in.read(data, 0, data.length)) > 0) {
				out.write(data, 0, bytesRead);
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
