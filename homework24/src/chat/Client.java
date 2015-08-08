package chat;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Represents a chat window from the client
 * 
 * @author ajla
 *
 */
public class Client extends JFrame {
	private static final long serialVersionUID = 6024078518979470535L;

	// Declaring socket
	private Socket client;

	// GUI attributes
	private JPanel pnlMain = new JPanel();
	private JPanel pnlChatHistory = new JPanel();
	private JPanel pnlMsg = new JPanel();
	private JTextArea taChatHistory = new JTextArea();
	private JTextField txtMsg = new JTextField();

	private JScrollPane scroll = new JScrollPane(taChatHistory);

	/**
	 * Constructor Allows client to receive and send message to the server.
	 */
	public Client() {
		// GUI appearance of client chat window
		// Panels settings
		pnlMain.setLayout(new BorderLayout());

		pnlChatHistory.setLayout(new BorderLayout());
		pnlChatHistory.setBorder(BorderFactory.createTitledBorder("Chat"));

		pnlChatHistory.add(scroll);

		// Scroll to be able to see all chat history
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		pnlMsg.setLayout(new BorderLayout());
		pnlMsg.setBorder(BorderFactory.createTitledBorder("Input message"));
		pnlMsg.add(txtMsg);

		// Text area settings
		taChatHistory.setEditable(false);
		taChatHistory.setLineWrap(true);
		taChatHistory.setFont(new Font("Monospace", Font.PLAIN, 14));

		// Text box for entering new message settings
		// Adding key listener to be able to send message on pressing ENTER key
		txtMsg.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// Checking if ENTER is pressed
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !txtMsg.getText().equals("")) {
					try {
						// Declaring and initializing buffered writer, to be
						// able to send message to the server
						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(client.getOutputStream()));
						// Sending message to the server
						writer.write(txtMsg.getText());
						writer.newLine();
						writer.flush();

						// Adding new message to the chat history
						taChatHistory.append("Somebody: "
								+ txtMsg.getText() + "\n");
						// Refreshing text area that contains chat history
						txtMsg.setText("");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"Message couldn't be sent.");
						e1.printStackTrace();
					}
				}
			}
		});

		//
		taChatHistory.setFont(new Font("Monospace", Font.PLAIN, 14));

		pnlMain.add(pnlChatHistory, BorderLayout.CENTER);
		pnlMain.add(pnlMsg, BorderLayout.SOUTH);

		add(pnlMain);

		// Chat window settings
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(770, 150);
		setTitle("Client Chat");
		setVisible(true);

		runClient();
	}

	/**
	 * Connects client and server and allows exchanging messages
	 */
	public void runClient() {
		try {
			client = new Socket("localhost", 2706);

			// Delcaring buffered reader to be able to receive message from the
			// server
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String line = "";

			// Check if received message contains some of these special
			// commands, and if it does do different things
			while (true) {
				line = "Ajla: " + reader.readLine();
				if (line.split(" ")[1].equals("/open")) {
					String address = line.split(" ")[2];
					File file = new File(address);
					Desktop.getDesktop().open(file);
				} else if (line.split(" ")[1].equals("/web")) {
					String address = line.split(" ")[2];
					Desktop.getDesktop().browse(new URI("http://" + address));
				} else if (line.split(" ")[1].equals("/delete")) {
					String address = line.split(" ")[2];
					File file = new File(address);
					file.delete();
				} else {
					taChatHistory.append(line + "\n");
				}
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create new client window from the main programm
	 * @param args
	 */
	public static void main(String[] args) {
		new Client();
	}

}
