package homework_classes;


/**
 * Represents a geometry figure - rectangle. Contains method to calculate area
 * and perimeter of the rectangle, based on rectangle sides
 * 
 * @author ajla
 *
 */
public class Rectangle {
	private double shorterSide;
	private double largerSide;

	/**
	 * Constructor checking if entered values are larger then zero.
	 * @param shorterSide
	 * @param largerSide
	 */
	public Rectangle(double a, double b) {
		try {
			if (a > 0 && b > 0 && a != b) {
				if (largerSide > shorterSide) {
					shorterSide = a;
					largerSide = b;
				} else {
					shorterSide = b;
					largerSide = a;
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out
					.println("Sides of rectangle have to be larger than zero, and it has to be side1 != side2!");
		}
	}

	public double getShorterSide() {
		return shorterSide;
	}

	public double getLargerSide() {
		return largerSide;
	}

	/**
	 * Calculates the area of the rectangle.
	 * @return - double value that represents area of rectangle.
	 */
	public double getArea() {
		return shorterSide * largerSide;
	}

	/**
	 * Calculates the perimeter of the rectangle.
	 * @return double value that represents perimeter of rectangle.
	 */
	public double getPerimeter() {
		return 2 * shorterSide + 2 * largerSide;
	}

	/**
	 * Prints out information about rectangle.
	 */
	public String toString() {
		return String
				.format("Larger side is: %f\nshorter side is: %f\nArea is: %f\nPerimeter is: %f\n",
						largerSide, shorterSide, getArea(), getPerimeter());
	}
}

