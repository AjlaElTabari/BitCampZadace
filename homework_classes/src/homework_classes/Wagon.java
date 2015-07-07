package homework_classes;

public class Wagon {
	private Rectangle platform;
	private Circle wheels;

	/**
	 * @param platform
	 * @param wheels
	 */
	public Wagon(Rectangle platform, Circle wheels) {
		super();
		this.platform = platform;
		this.wheels = wheels;
	}

	/**
	 * Calculating the area of the wagon. The area of the wagon is calculated by
	 * adding areas of all parts that wagon is composed from
	 * 
	 * @return double value that represents the area of the wagon
	 */
	public double getArea() {
		return platform.getArea() + 2 * wheels.getArea();
	}

	/**
	 * Calculates the parimeter of the wagon. The parimeter of the wagon is
	 * calculated by adding parimeter of all parts that wagon is composed from
	 * 
	 * @return double value that represents the perimeter of the wagon
	 */
	public double getPerimeter() {
		return platform.getPerimeter() + 2 * wheels.getPerimeter();
	}
}
