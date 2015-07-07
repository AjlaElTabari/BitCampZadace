package homework_classes;

public class Locomotive {
	private Rectangle platform;
	private Circle wheels;
	private Square cabin;
	private Circle windows;
	private Rectangle chimney;

	/**
	 * @param platform
	 * @param wheels
	 * @param cabin
	 * @param windows
	 * @param chimney
	 */
	public Locomotive(Rectangle platform, Circle wheels, Square cabin,
			Circle windows, Rectangle chimney) {
		super();
		this.platform = platform;
		this.wheels = wheels;
		this.cabin = cabin;
		this.windows = windows;
		this.chimney = chimney;
	}

	/**
	 * Calculating the area of the locomotive. The area is calculated by adding
	 * areas of all locomotive parts except the windows
	 * 
	 * @return double value that represents the area of the locomotive
	 */
	public double getArea() {
		return platform.getArea() + 2 * wheels.getArea() + cabin.getArea()
				+ chimney.getArea() - 2 * windows.getArea();
	}

	/**
	 * Calculating the perimeter of the locomotive. The area is calculated by
	 * adding perimeters of all locomotive parts
	 * @return double value that represents the perimeter of the locomotive
	 */
	public double getPerimeter() {
		return platform.getPerimeter() + 2 * wheels.getPerimeter()
				+ cabin.getPerimeter() + chimney.getPerimeter() - 2
				* windows.getPerimeter();
	}
}
