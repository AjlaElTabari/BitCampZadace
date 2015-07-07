package tasks2_3_4;


public class Book {
	private String title;
	private double price;
	private Author author;
	private int stock;
	
	/**
	 * Constructor
	 * @param title
	 * @param price
	 * @param author
	 * @param stock
	 */
	public Book(String title, double price, Author author, int stock) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.stock = stock;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	/**
	 * Prints out information about book
	 */
	public String toString() {
		String s = "";
		s += "Title: " + title + "\n";
		s += "Price: " + price + "\n";
		s += "Author: \n" + this.author.toString();
		s += "Stock: " + stock + "\n";
		return s;
	}
	
	
}
