package homework_oop;


public class BusNetwork extends Network implements Functionable {
	private Server server;

	public BusNetwork(String name, Server server) {
		super(name);
		this.server = server;
	}


	/**
	 * Add computer in the computer array network.
	 * @param pc - Computer that needs to be added.
	 */
	public void addComputer(Computer computer) {

		Client c = (Client) computer;

		Computer[] computers = new Computer[getComputers().length + 1];

		// Checks if the network is empty
		if (getComputers()[0] == null) {
			computers[0] = c;
			c.connect(this);
		} else {
			System.arraycopy(getComputers(), 0, computers, 0, getComputers().length);
			computers[computers.length - 1] = c;
			c.connect(this);
			setComputers(computers);
		}

	}

	/**
	 * Remove computer from the computer network.
	 * @param pc - Computer that needs to be removed.
	 */
	public void removeComputer(Computer computer) {

		Client c = (Client) computer;

		for (int i = 0; i < getComputers().length; i++) {
			if (c.equals(getComputers()[i])) {
				c.disconnect();
				getComputers()[i] = null;
			} else {
				throw new IllegalArgumentException();
			}
		}

		Computer[] computers = new Computer[getComputers().length - 1];

		for (int i = 0; i < computers.length; i++) {
			if (getComputers()[i] != null) {
				computers[i] = getComputers()[i];
			}
		}
		setComputers(computers);
	}


	/**
	 * Checks if the network functioning
	 * Network is functioning if there is at least
	 * two computers connected to it
	 */
	public boolean isFunctioning() {
		int counter = 0;

		for (int i = 0; i < getComputers().length; i++) {
			if (getComputers()[i] != null) {
				counter++;
			}
		}
		if (counter >= 2) {
			return true;
		}
		return false;
	}
	
	/**
	 * Prints out information about the network
	 */
	
	public String toString() {
		String s = "Number of computers: ";
		s += getComputers().length;
		s += "Does network functioning? ";
		s += (isFunctioning()) ? "Yes" : "No";
		
		return s;
	}
}
