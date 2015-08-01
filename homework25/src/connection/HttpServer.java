package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

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

			// Declaring and initializing buffered reader to be able to read from the file
			BufferedReader br = new BufferedReader(new FileReader(
					"src/links.txt"));

			while (true) {
				// Declaring and initializing socket to be able to build html 
				Socket socket = server.accept();

				// Declaring and initializing buffered writer
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream()));
				String htmlDoc = "";

				// Building html from the file
				while (br.ready()) {
					String[] parts = br.readLine().split(" ");
					htmlDoc += "<a href=\"" + parts[1] + "\">" + parts[0]
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
