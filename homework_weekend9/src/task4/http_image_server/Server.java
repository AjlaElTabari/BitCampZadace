package task4.http_image_server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2706);
			Socket socket = server.accept();
			
			InputStream in = socket.getInputStream();
			String fileName = socket.getInetAddress().getHostAddress().toString() + Calendar.getInstance().getTimeInMillis()+ ".jpg";
			File file = new File(fileName);
			FileOutputStream fileWrite = new FileOutputStream(file);
			
			byte[] data = new byte[1024];
			int bytesRead;
			
			// Radi dok ima sta citati
			while ((bytesRead = in.read(data, 0, data.length)) > 0) {
				fileWrite.write(data, 0, bytesRead);
			}
			fileWrite.close();
			
			String htmlDoc = "";

			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			
			// Building html from the file				
				htmlDoc += "<a href=\"" + fileName + "\">" + fileName
						+ "</a>\n";
				
				writer.write(htmlDoc);
				writer.flush();
				//socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}	
