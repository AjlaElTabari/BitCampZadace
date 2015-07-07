package homework_oop;

public class Main {

	public static void main(String[] args) {

		// MAC Addresses
		char[] macAdd1 = { '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C' };
		char[] macAdd2 = { '2', 'B', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C' };
		char[] macAdd3 = { '2', 'B', '3', '4', '5', 'T', '7', '5', 'G',
				'A', 'B', 'C' };

		// Clients
		Client client1 = new Client("Test", macAdd1);
		Client client2 = new Client("Test2", macAdd2);

		// Server
		Server serverOne = new Server("Server one", macAdd3, 2);

		// Connecting clients to servers
		client1.connect(serverOne);
		client2.connect(serverOne);
		client1.disconnect();
		client1.connect(serverOne);
	}

}
