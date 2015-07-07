package task6;

public class Dog extends Pet {
	private String breed;

	/**
	 * @param name
	 * @param age
	 * @param species
	 * @param breed
	 */
	public Dog(String name, int age, int species, String breed) {
		super(name, age, species);
		this.breed = breed;
	}
	
	/**
	 * Prints out information about dog
	 */
	public String toString() {
		String s = "\nBreed: " + breed + "\n";
		s += super.toString();
		s += "av av";
		return s;
	}
}
