package chat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Represents a chat window from the server
 * @author ajla
 *
 */
public class Server extends JFrame {

	private static final long serialVersionUID = 4614283558237688331L;
	
	// Declaring client and server socket.
	private Socket socket;
	private ServerSocket server;

	// Declaring elements of frame.
	private JPanel pnlMainPanel = new JPanel();
	private JPanel pnlChatHistory = new JPanel();
	private JPanel pnlMsg = new JPanel();
	private JTextArea taChatHistory = new JTextArea();
	private JTextField txtMsg = new JTextField();
	
	private JScrollPane scroll = new JScrollPane(taChatHistory);

	/**
	 * Constructor of server that enables server to receive and send message to
	 * the client.
	 */
	public Server() {
		// Setting the layout of main panel.
		pnlMainPanel.setLayout(new BorderLayout());

		// Setting the appearance of the panel that contains text area.
		pnlChatHistory.setLayout(new BorderLayout());
		pnlChatHistory.setBorder(BorderFactory.createTitledBorder("Chat"));
		pnlChatHistory.add(scroll);

		// Setting the scroll pane and text area.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		taChatHistory.setEditable(false);
		taChatHistory.setLineWrap(true);
		taChatHistory.setFont(new Font("Monospace", Font.BOLD, 14));

		// Setting the appearance of the panel that contains text field.
		pnlMsg.setLayout(new BorderLayout());
		pnlMsg.setBorder(BorderFactory.createTitledBorder("Input message"));
		pnlMsg.add(txtMsg);

		// Adding the key listener and border on text field.
		txtMsg.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !txtMsg.getText().equals("")) {
					try {
						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(socket.getOutputStream()));
						writer.write(txtMsg.getText());
						writer.newLine();
						writer.flush();
						
						taChatHistory.append("Ajla: " + txtMsg.getText() + "\n");
						txtMsg.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
		taChatHistory.setFont(new Font("Monospace", Font.BOLD, 14));

		// Adding elements to the main panel.
		pnlMainPanel.add(pnlChatHistory, BorderLayout.CENTER);
		pnlMainPanel.add(pnlMsg, BorderLayout.SOUTH);

		// Adding main panel to the frame.
		add(pnlMainPanel);

		// Setting the appearance of the frame.
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 150);
		setTitle("Server Chat");
		setVisible(true);

		// Calling method runServer that creates server socket.
		runServer();
	}

	/**
	 * Creates server socket and enables server to receive messages from
	 * clients.
	 */
	public void runServer() {
		try {
			// Creating server and client socket.
			server = new ServerSocket(2706);
			socket = server.accept();
			// Declaring reader that will read messages sent from client.
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// Declaring string variable that will contain messages sent from
			// client.
			String areaText = "";

			while (true) {
				// Reading sent messages.
				areaText = "Client: " + reader.readLine();
				
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream()));

					writer.write(txtMsg.getText());
					writer.newLine();
					writer.flush();
				} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Server();
	}

}