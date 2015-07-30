package chat;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

	private Socket client;

	private JPanel pnlMain = new JPanel();
	private JPanel pnlChatHistory = new JPanel();
	private JPanel pnlMsg = new JPanel();
	private JTextArea taChatHistory = new JTextArea();
	private JTextField txtMsg = new JTextField();

	private JScrollPane scroll = new JScrollPane(taChatHistory);

	/**
	 * Constructor 
	 * Allows client to receive and send message to the server.
	 */
	public Client() {
		pnlMain.setLayout(new BorderLayout());

		pnlChatHistory.setLayout(new BorderLayout());
		pnlChatHistory.setBorder(BorderFactory.createTitledBorder("Chat"));

		pnlChatHistory.add(scroll);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		pnlMsg.setLayout(new BorderLayout());
		pnlMsg.setBorder(BorderFactory.createTitledBorder("Input message"));
		pnlMsg.add(txtMsg);

		taChatHistory.setEditable(false);
		taChatHistory.setLineWrap(true);
		taChatHistory.setFont(new Font("Monospace", Font.PLAIN, 14));

		txtMsg.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !txtMsg.getText().equals("")) {
					try {
						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(client.getOutputStream()));
						writer.write(txtMsg.getText());
						writer.newLine();
						writer.flush();
						taChatHistory.append("Somebody else: " + txtMsg.getText()
								+ "\n");
						txtMsg.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		taChatHistory.setFont(new Font("Monospace", Font.PLAIN, 14));

		pnlMain.add(pnlChatHistory, BorderLayout.CENTER);
		pnlMain.add(pnlMsg, BorderLayout.SOUTH);

		add(pnlMain);

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

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String line = "";

			while (true) {
				line = "Somebody else: " + reader.readLine();
				if (line.split(" ")[0].equals("/open")) {
					String address = line.split(" ")[1];
					File file = new File(address);
					Desktop.getDesktop().open(file);
				} else if (line.split(" ")[0].equals("/web")) {
					String address = line.split(" ")[1];
					Desktop.getDesktop().browse(
							new URI("http://" + address));
				} else if (line.split(" ")[0].equals("/delete")) {
					String address = line.split(" ")[1];
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
		new Client();
	}

}
