package homework_oop;

/**
 * Represents a server
 * Described with Computer arguments and capacity,
 * that represents number of computers that can be connected
 * to the server, before it crashed
 * @author ajla
 *
 */
public class Server extends Computer {
	private int capacity;

	/**
	 * Constructor
	 * Sets Computer arguments plus capcity
	 * @param name
	 * @param macAddress
	 */
	public Server(String name, char[] macAddress, int capacity) {
		super(name, macAddress);
		this.capacity = capacity;
	}
	
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Prints out server information
	 */
	public String toString() {
		String s = super.toString();
		s += "Capacity: " + capacity;
		
		return s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (capacity != other.capacity)
			return false;
		return true;
	}
	
	
}