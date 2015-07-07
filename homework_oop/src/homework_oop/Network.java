package homework_oop;


/**
 * Represents a computer network
 * Described with network name and array of computers
 * @author ajla
 *
 */
public abstract class Network {
	private static final int DEFAULT_NO_OF_COMPUTERS = 0;
	private String name;
	private Computer[] computers;
	
	/**
	 * Constructor
	 * Demands all arguments to be set during creation of object
	 * @param name
	 * @param computers
	 */
	public Network(String name, Computer[] computers) {
		super();
		this.name = name;
		this.computers = computers;
	}

	/**
	 * Constructor
	 * Setting array of computers to default value od zero
	 * @param name
	 */
	public Network(String name) {
		super();
		this.name = name;
		this.computers = new Computer[DEFAULT_NO_OF_COMPUTERS];
	}
	
	public Computer[] getComputers() {
		return computers;
	}
	
	public void setComputers(Computer[] computers) {
		this.computers = computers;
	}
	
	public abstract void addComputer(Computer c);
	
	public abstract void removeComputer(Computer c);
	
	 
}
