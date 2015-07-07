package homework_classes;


/**
 * Represents a geometry figure - circle. Contains method to calculate 
 * area and perimeter of the circle, based on circle radius
 * @author ajla
 *
 */
public class Circle {
	private double radius;

	/**
	 * Constructor
	 * @param radius
	 */
	public Circle(double radius) {
		try {
			if (radius > 0) {
				this.radius = radius;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out
					.println("Radius must be larger then 0.");
		}

	}

	/**
	 * Prints out information about circle.
	 */
	public String toString() {
		return String.format("Radius: %f\n", radius);
	}

	/**
	 * Calculates the area of the circle.
	 * @return - double value that represents area of circle
	 */
	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

	/**
	 * Calculates the perimeter of the circle. 
	 * @return double value that represents perimeter of circle
	 */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
}