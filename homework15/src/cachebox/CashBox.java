package cachebox;

public class CashBox {
	@SuppressWarnings("unused")
	private String title;
	private double currAmount;
	
	/**
	 * @param title
	 */
	public CashBox(String title) {
		super();
		this.title = title;
		this.currAmount = 0;
	}
	
	/**
	 * Increasing currentAmount by provided amount
	 * @param money
	 */
	public void addMoney(double money) {
		currAmount += money;
	}
	
	/**
	 * Setting currAmount to 0. Simulating action of taking all money from the cash box
	 */
	public void takeAllMoney() {
		currAmount = 0;
	}
	
	/**
	 * Printing information about balance in the cash box, depending on what is balance
	 */
	public void printInformation() {
		if (currAmount == 0) {
			System.out.println("It is empty.");
		} else if (currAmount >= 1 && currAmount <= 20) {
			System.out.println("There's some, but not much.");
		} else if (currAmount >= 21 && currAmount <= 100) {
			System.out.println("There's some.");
		} else {
			System.out.println("There's a lot.");
		}
	}
}