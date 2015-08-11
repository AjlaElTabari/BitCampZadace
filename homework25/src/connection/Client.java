package connection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * Represents a client that connects to server and sends web site name and
 * location to that server. These information is inputed from the user, using
 * console.
 * 
 * @author ajla
 *
 */
public class Client {
	public static void main(String[] args) {
		// Declaring and initializing scanner, so user will be able to
		// enter data from the console
		Scanner input = new Scanner(System.in);

		try {
			// Declaring and initializing socket
			Socket toServer = new Socket("localhost", 2707);

			// Declaring and initializing buffered writer to be able to send
			// data to server
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					toServer.getOutputStream()));

			// Entering data from the console
			System.out.println("Enter the name of the website");
			String name = input.nextLine();
			System.out.println("Enter the location of the website");
			String location = input.nextLine();

			// Sending data to the server
			writer.write(name + " " + location);
			writer.newLine();
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		input.close();
	}
}
