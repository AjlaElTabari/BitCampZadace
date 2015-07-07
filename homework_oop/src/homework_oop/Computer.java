package homework_oop;


import java.util.Arrays;

/**
 * Represents a computer, described with name and MAC addres
 * MAC addres is defined with nested class MacAddress
 * @author ajla
 *
 */
public abstract class Computer {
	// Proper MAC address will have exactly 12 characters, without separators
	private static final int MAC_ADDRESS_LENGTH = 12;
	private String name;
	private MacAddress macAddress;
	
	/**
	 * Constructor, sets Computer parameters, 
	 * @param name
	 * @param macAdress
	 */
	public Computer(String name, char[] macAddress) {
		super();
		this.name = name;
		this.macAddress = new MacAddress(macAddress);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the macAdress
	 */
	public MacAddress getMacAdress() {
		return macAddress;
	}

	/**
	 * @param macAdress the macAdress to set
	 */
	public void setMacAdress(MacAddress macAddress) {
			this.macAddress = macAddress;		
	}
	
	/**
	 * Nested Class MacAddress
	 * represents MAC address of the computer
	 * It is given as array of characters
	 * @author ajla
	 *
	 */
	public class MacAddress {
		private char[] address = new char[MAC_ADDRESS_LENGTH];

		/**
		 * @param address
		 */
		public MacAddress(char[] address) {
			super();		
			if(address.length != MAC_ADDRESS_LENGTH) {
				System.out.println("MAC addres you enterd is not valid!");
			} else {
				this.address = address;
			}
		} 
		
		/**
		 * Prints out MAC address, given as array of characters,
		 * formated to: 00:00:00:00:00:00 format
		 */
		public String toString() {
			String s = "MAC address: ";
			for (int i = 0; i <= this.address.length; i++) {
				if (i % 2 == 0 && i != 0) {
					s += ":" + address[i];
				} else {
					s += address[i];
				}
			}
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
			MacAddress other = (MacAddress) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(address, other.address))
				return false;
			return true;
		}

		private Computer getOuterType() {
			return Computer.this;
		}
		
		
	}
	
	
}
