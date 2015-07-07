package tasks2_3_4;


public class Author {
	public static boolean MALE = false;
	public static boolean FEMALE = true;
	private String name;
	private String email;
	private boolean sex;
	
	/**
	 * Constructor
	 * @param name
	 * @param email
	 * @param sex
	 */
	public Author(String name, String email, boolean sex) {
		super();
		this.name = name;
		this.email = email;
		this.sex = sex;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the sex
	 */
	public boolean isSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	/**
	 * Prints out information about author
	 */
	public String toString() {
		String s = "";
		s += "Name: " + name + "\n";
		s += "email: " + email + "\n";
		s += (sex) ? "Sex: female\n" : "Sex: male" + "\n"; 
		return s;
	}
	
}
