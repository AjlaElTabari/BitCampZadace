package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Represents a server that receives string from the client. That string should
 * be composed by two parts, web site name and location. Server will split these
 * attributes and check if web location is valid.
 * 
 * @author ajla
 *
 */
public class NormalServer {
	public static void main(String[] args) {
		try {
			// Declaring and initializing server socket and socket
			ServerSocket server = new ServerSocket(2707);
			Socket client = server.accept();

			// Declaring buffered reader and writer to be able to read stream
			// from the client, and write that stream into the file
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"src/links.txt", true));

			String line = reader.readLine();
			String[] parts = null;
			
			// Splitting received string into parts, web site name and location
			if(line != null && line.split(" ").length == 2) {
				parts = line.split(" ");	
				
				// Checking if received web location is valid web address
				if (validateURL(parts[1])) {
					writer.write(parts[0] + " " + parts[1]);
					writer.newLine();
					writer.flush();
					System.out.println("Validation successful. Link has been added to the file.");
				}
			} else {
				System.out.println("Wrong input.");
			}
			
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Receives string that suppose to be web location. Tries to make an URI
	 * from that location, and if succeed returns true, and if not returns
	 * false.
	 * 
	 * @param location
	 * @return boolean
	 */
	private static boolean validateURL(String location) {
		boolean result;
		try {
			URL url = new URL(location);
			url.toURI();
			result = true;
		} catch (URISyntaxException e) {
			System.out.println("Invalid address.");
			result = false;
		} catch (MalformedURLException e) {
			System.out.println("Invalid address.");
			result = false;
		}
		return result;
	}
}
