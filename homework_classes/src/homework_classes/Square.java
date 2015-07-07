package homework_classes;

/**
 * Represents a geometry figure - square. Contains method to calculate area
 * and perimeter of the square, based on square side
 * 
 * @author ajla
 *
 */
public class Square {
	private double side;

	/**
	 * Constructor checking if entered value is larger then zero.
	 * @param side
	 */
	public Square(double side) {
		try {
			if (side > 0) {
				this.side = side;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out
					.println("Sides of square have to be larger than zero.");
		}
	}

	public double getSide() {
		return side;
	}
	
	/**
	 * Calculates the area of the square.
	 * @return - double value that represents area of square.
	 */
	public double getArea() {
		return Math.pow(side, 2);
	}

	/**
	 * Calculates the perimeter of the square. 
	 * @return double value that represents perimeter of square. 
	 */
	public double getPerimeter() {
		return 4 * side;
	}

	/**
	 * Prints out information about circle.
	 */
	public String toString() {
		return String.format("Side is: %f\nArea is: %f\nPerimeter is: %f\n",
				side, getArea(), getPerimeter());
	}
}
