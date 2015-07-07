package homework_oop;

/**
 * Represents a client computer, that can be connected
 * to a server or a network
 * @author ajla
 *
 */
public class Client extends Computer implements Connectable {
	private Computer connectedToComputer;
	private Network connectedToNetwork;
	
	/**
	 * Constructor
	 * Sets name and MAC address of client computer
	 * @param name
	 * @param macAddress
	 */
	public Client(String name, char[] macAddress) {
		super(name, macAddress);
	}

	/**
	 * @return the connectedToComputer
	 */
	public Computer getConnectedToComputer() {
		return connectedToComputer;
	}

	/**
	 * @return the connectedToNetwork
	 */
	public Network getConnectedToNetwork() {
		return connectedToNetwork;
	}

	/**
	 * Connects client to the server, if it is not already connected
	 * It could be connected only if both attributes are null
	 * @param Computer c
	 */
	@Override
	public void connect(Computer c) {
		if (this.connectedToComputer != null || this.connectedToNetwork != null) {
			throw new IllegalArgumentException("Link already exits.");
		} else {
			this.connectedToComputer = c;
		}
	}
	
	/**
	 * Connects client to the network, if it is not already connected
	 * It could be connected only if both attributes are null
	 * @param Network n
	 */
	@Override
	public void connect(Network n) {
		if (this.connectedToNetwork != null || this.connectedToComputer != null) {
			throw new IllegalArgumentException("Link already exits.");
		} else {
			this.connectedToNetwork = n;
		}
		
	}
	
	/**
	 * Disconnects the client from both, server and network
	 */
	@Override
	public void disconnect() {
		connectedToComputer = null;
		connectedToNetwork = null;
	}	
	
}
