package task4.http_image_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Represents a HTTP server, that displays list of web locations from the txt
 * file.
 * 
 * @author ajla
 *
 */
public class HttpServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			// Declaring server socket
			ServerSocket server = new ServerSocket(2706);
			System.out.println("Server started.");

			// Declaring and initializing buffered writer
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(
					"src/links.txt", true));
			
			// Declaring and initializing buffered reader to be able to read
			// from the file
			BufferedReader reader = new BufferedReader(new FileReader(
					"src/links.txt"));
			
			while (true) {
				// Declaring and initializing socket to be able to build html
				Socket socket = server.accept();

				InputStream in = socket.getInputStream();
				String fileName = "IMG"
						+ Calendar.getInstance().getTimeInMillis() + ".jpg";
				File file = new File(fileName);
				FileOutputStream fileWrite = new FileOutputStream(file);

				byte[] data = new byte[1024];
				int bytesRead;

				while ((bytesRead = in.read(data, 0, data.length)) > 0) {
					fileWrite.write(data, 0, bytesRead);
				}
				fileWrite.close();
				
				
				fileWriter.write(fileName);
				fileWriter.newLine();
				fileWriter.flush();

				

				// Declaring and initializing buffered writer
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream()));
				String htmlDoc = "";

				while (reader.ready()) {
					htmlDoc += "<a href=\"" + reader.readLine() + "\">" + "IMG"
							+ "</a>\n";
				}

				writer.write(htmlDoc);
				writer.flush();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
