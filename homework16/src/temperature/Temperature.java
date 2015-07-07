package temperature;

public class Temperature {
	private int temperature;
	
	// Original temperature is in C
	public Temperature(int temperature) {
		this.temperature = temperature;
	}
	
	/**
	 * Gets temperature
	 */
	public int getTemperature() {
		return this.temperature;
	}
	/**
	 * Converts temperatures in Celsius to Kelvins
	 * @return
	 */
	public double getTemperatureInK() {
		return this.temperature + 273.15;
	}
	/**
	 * Converts temperatures in Celsius to Fahrenheit
	 * @return
	 */
	public double getTemperatureInF() {
		return (9/5) * this.temperature + 32;
	}
}
