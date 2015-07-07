package cachebox;

public class Main {

	public static void main(String[] args) {
		// Declaring and initializing new Cash box
		CashBox cb1 = new CashBox("MySavings");
		// Printing information about the Cash box
		cb1.printInformation();
		
		// Adding some money
		cb1.addMoney(20);
		cb1.printInformation();

		cb1.addMoney(30);
		cb1.printInformation();
		
		cb1.addMoney(100);
		cb1.printInformation();
		
		// Taking everything
		cb1.takeAllMoney();
		cb1.printInformation();
	}

}