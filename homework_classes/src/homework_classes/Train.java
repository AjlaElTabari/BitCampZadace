package homework_classes;

public class Train {
	private Locomotive locomotive;
	private Wagon[] wagons;

	/**
	 * @param locomotive
	 * @param wagons
	 */
	public Train(Locomotive locomotive, Wagon[] wagons) {
		super();
		this.locomotive = locomotive;
		this.wagons = wagons;
	}

	/**
	 * Calculating the area of train.
	 * @return double value that represents the area of the train.
	 */
	public double getArea() {
		double area = 0;
		area = locomotive.getArea();
		
		for (int i = 0; i < wagons.length; i++) {
			area += wagons[i].getArea();
		}
		
		return area;
	}

	/**
	 * Calculating the perimeter of train.
	 * @return double value that represents the perimeter of the train.
	 */
	public double getPerimeter() {
		double perimeter = 0;
		perimeter = locomotive.getPerimeter();

		for (int i = 0; i < wagons.length; i++) {
			perimeter += wagons[i].getPerimeter();
		}

		return perimeter;
	}
}
