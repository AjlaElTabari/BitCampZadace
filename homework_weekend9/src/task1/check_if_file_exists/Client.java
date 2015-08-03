package task1.check_if_file_exists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Represents a client that sending a file path to the server
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
			Socket socket = new Socket("localhost", 2707);

			// Declaring and initializing buffered reader and writer to be able
			// to send
			// and receive data from the server
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// Entering data from the console
			System.out.println("File:");
			String file = input.nextLine();

			// Sending data to the server
			writer.write(file);
			writer.newLine();
			writer.flush();

			// Receiving data from the server
			String result = reader.readLine();
			System.out.println(result);

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		input.close();
	}
}
