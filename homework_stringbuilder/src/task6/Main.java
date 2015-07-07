package task6;

public class Main {

	public static void main(String[] args) {

		Cat c = new Cat("Myao", 3, Pet.CAT);
		Dog d = new Dog("Max", 3, Pet.DOG, "Bosanski tornjak");
		
		System.out.println(c);
		System.out.println(d);

	}

}
