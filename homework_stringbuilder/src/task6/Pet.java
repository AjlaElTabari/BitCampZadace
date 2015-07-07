package task6;

public abstract class Pet {
	public static final int CAT = 0;
	public static final int DOG = 1;
	private String name;
	private int age;
	private int species;
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 * @param species
	 */
	public Pet(String name, int age, int species) {
		super();
		this.name = name;
		this.age = age;
		this.species = species;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the species
	 */
	public int getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(int species) {
		this.species = species;
	}
	
	/**
	 * Prints out information about pet
	 */
	public String toString() {
		String s = "";
		s += "Name: " + name + "\n";
		s += "Age: " + age + "\n";
		s += "Speacies: \n";
		s += (species == 0) ? "Cat: " : "Dog: ";
		return s;
	}
	
}
