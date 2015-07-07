package temperature;

public class TemperatureMain {

	public static void main(String[] args) {
		
		Temperature t1 = new Temperature(0);
		
		System.out.println("C: " + t1.getTemperature());
		System.out.println("C to K: " + t1.getTemperatureInK());
		System.out.println("C to F: " + t1.getTemperatureInF());

	}

}