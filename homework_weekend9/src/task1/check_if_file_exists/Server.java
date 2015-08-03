package task1.check_if_file_exists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents a server that receives a file path, and checks if that file exists
 * on the server. If it does, returns 1, if it doesn't, returns 0.
 * 
 * @author ajla
 *
 */
public class Server {

	public static void main(String[] args) {
		try {
			// Declaring and initializing server socket and socket
			ServerSocket server = new ServerSocket(2707);
			Socket client = server.accept();

			// Declaring buffered reader and writer to be able to read stream
			// from the client, and write that stream into the file
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));

			// Checking if received file location exists on the server
			File file = new File(reader.readLine());
			String result = (file.exists() && !file.isDirectory()) ? "1" : "0";

			System.out.println(result);

			// Sending result back to the client
			writer.write(result);
			writer.newLine();
			writer.flush();

			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
