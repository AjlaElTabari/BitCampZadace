package task6;

public class Cat extends Pet {

	/**
	 * @param name
	 * @param age
	 * @param species
	 */
	public Cat(String name, int age, int species) {
		super(name, age, species);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Prints out information about cat
	 */
	public String toString() {
		String s = super.toString();
		s += "\nGo away human!";
		return s;
	}
}