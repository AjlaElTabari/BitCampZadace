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
import java.net.ServerSocket;
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
 * Represents a chat window from the server
 * 
 * @author ajla
 *
 */
public class Server extends JFrame {

	private static final long serialVersionUID = 4614283558237688331L;
	
	// Declaring socket
	private Socket socket;
	private ServerSocket server;

	// GUI attributes
	private JPanel pnlMainPanel = new JPanel();
	private JPanel pnlChatHistory = new JPanel();
	private JPanel pnlMsg = new JPanel();
	private JTextArea taChatHistory = new JTextArea();
	private JTextField txtMsg = new JTextField();

	private JScrollPane scroll = new JScrollPane(taChatHistory);

	/**
	 * Constructor 
	 * Allows server to receive and send message to the client.
	 */
	public Server() {
		// GUI appearance of client chat window
		// Panels settings
		pnlMainPanel.setLayout(new BorderLayout());

		pnlChatHistory.setLayout(new BorderLayout());
		pnlChatHistory.setBorder(BorderFactory.createTitledBorder("Chat"));
		pnlChatHistory.add(scroll);

		// Scroll to be able to see all chat history
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// Text area settings
		taChatHistory.setEditable(false);
		taChatHistory.setLineWrap(true);
		taChatHistory.setFont(new Font("Monospace", Font.BOLD, 14));

		pnlMsg.setLayout(new BorderLayout());
		pnlMsg.setBorder(BorderFactory.createTitledBorder("Input message"));
		pnlMsg.add(txtMsg);

		// Text box for entering new message settings
		// Adding key listener to be able to send message on pressing ENTER key
		txtMsg.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// Checking if ENTER is pressed
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !txtMsg.getText().equals("")) {
					try {
						// Declaring and initializing buffered writer, to be
						// able to send message to the client
						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(socket.getOutputStream()));
						// Sending message to the client
						writer.write(txtMsg.getText());
						writer.newLine();
						writer.flush();

						// Adding new message to the chat history
						taChatHistory.append("Ajla: " + txtMsg.getText() + "\n");
						// Refreshing text area that contains chat history
						txtMsg.setText("");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"Message couldn't be sent.");
						e1.printStackTrace();
					}
				}
			}

		});
		taChatHistory.setFont(new Font("Monospace", Font.BOLD, 14));

		pnlMainPanel.add(pnlChatHistory, BorderLayout.CENTER);
		pnlMainPanel.add(pnlMsg, BorderLayout.SOUTH);

		add(pnlMainPanel);

		// Chat window settings
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 150);
		setTitle("Server Chat");
		setVisible(true);

		runServer();
	}

	/**
	 * Connects client and server and allows exchanging messages
	 */
	public void runServer() {
		try {
			server = new ServerSocket(2706);
			socket = server.accept();
			
			// Delcaring buffered reader to be able to receive message from the
			// client
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String line = "";

			// Check if received message contains some of these special
			// commands, and if it does do different things
			while (true) {
				line = "Somebody: " + reader.readLine();
				if (line.split(" ")[1].equals("/open")) {
					String address = line.split(" ")[2];
					File file = new File(address);
					Desktop.getDesktop().open(file);
				} else if (line.split(" ")[1].equals("/web")) {
					String address = line.split(" ")[2];
					Desktop.getDesktop().browse(
							new URI("http://" + address));
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

	public static void main(String[] args) {
		new Server();
	}

}