package task3;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task3 extends JFrame {
	private static final long serialVersionUID = -8404390128424131633L;
	private String password = "1234";
	private String username = "Mujo";
	
	
	JPanel panel = new JPanel();
	JLabel usernameLbl = new JLabel("Username:");
	JTextField usernameTf = new JTextField();
	JLabel passwordLbl = new JLabel("Password:");
	JPasswordField passwordPf = new JPasswordField();
	
	public Task3() {
		panel.setLayout(new GridLayout(2, 2));
		
		passwordPf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				String pass = "";
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					for (int i = 0; i < passwordPf.getPassword().length; i++) {
						pass += passwordPf.getPassword()[i];
					}
					if (pass.equals(password) && usernameTf.getText().equals(username)) {
						System.exit(0);
					} else {
						JOptionPane error = new JOptionPane("Wrong username and password!", JOptionPane.ERROR_MESSAGE);
						error.createDialog(panel, "Muhaha, you don't know your own credentials.").setVisible(true);
					}
				}
				
			}
			
		});
		
		setTitle("My lucky frame");
		setSize(200, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		add(panel);
		panel.add(usernameLbl);
		panel.add(usernameTf);
		panel.add(passwordLbl);
		panel.add(passwordPf);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task3();

	}
	
}
