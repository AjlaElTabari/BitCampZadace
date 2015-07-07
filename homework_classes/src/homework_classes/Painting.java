package homework_classes;

/**
 * Calculate how much of the maint we need to draw and paint a train
 * @author ajla
 *
 */
public class Painting {

	public static void main(String[] args) {
		double paintNeededPerMeter = 0.05;

		// Parts of the train
		Rectangle platform = new Rectangle(6, 2);
		Circle wheel = new Circle(0.75);
		Square cabine = new Square(3);
		Circle window = new Circle(0.3);
		Rectangle chimney = new Rectangle(0.5, 1);

		// Locomotive
		Locomotive locomotive = new Locomotive(platform, wheel, cabine, window,
				chimney);

		// Wwagons
		Wagon wagon1 = new Wagon(platform, wheel);
		Wagon wagon2 = new Wagon(platform, wheel);

		// Wagons
		Wagon[] wagons = { wagon1, wagon2 };

			// Train
		Train train = new Train(locomotive, wagons);
		double paintNeededForArea = getPaintNeededPerMeter(
				Math.pow(paintNeededPerMeter, 2), train.getArea(), 1);
		double paintNeededForLines = getPaintNeededPerMeter(
				paintNeededPerMeter, train.getPerimeter(), 0.5); // 0.5 is line thickness
		System.out
				.printf("Paint needed for draw the train lines is: %.2f kilograms. \nPaint needed for paint complete train is: %.2f kilograms.",
						paintNeededForLines, paintNeededForArea);

	}

	public static double getPaintNeededPerMeter(double paintPerMeter,
			double amountPerMeter, double lineThickness) {
		return paintPerMeter * amountPerMeter * lineThickness;
	}

}
