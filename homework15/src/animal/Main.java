package animal;

public class Main {

	public static void main(String[] args) {

		// Declaring and initializing Animal objects
		Animal lizard = new Animal("Lizard", (byte)1, (byte)1);
		Animal crocodile = new Animal("Crocodile", (byte)2, (byte)2);
		Animal cat = new Animal("Cat", (byte)2, (byte)1);
		Animal shark = new Animal("Shark", (byte)2, (byte)3);
		Animal parrot = new Animal("Parrot", (byte)1, (byte)1);
		
		// Printing out information about animals
		System.out.print("Lizard: "); 
		lizard.printStatus();
		System.out.print("Crocodile: "); 
		crocodile.printStatus();
		System.out.print("Cat: "); 
		cat.printStatus();
		System.out.print("Shark: "); 
		shark.printStatus();
		System.out.print("Parrot: "); 
		parrot.printStatus();
		
		// Testing
		Animal.cycleDayNight();
		Animal.setAmountOfWater((byte)2);
		
		// Printing out information about animals
		
		System.out.println();
		System.out.print("Lizard: "); 
		lizard.printStatus();
		System.out.print("Crocodile: "); 
		crocodile.printStatus();
		System.out.print("Cat: "); 
		cat.printStatus();
		System.out.print("Shark: "); 
		shark.printStatus();
		System.out.print("Parrot: "); 
		parrot.printStatus();
		
	}

}