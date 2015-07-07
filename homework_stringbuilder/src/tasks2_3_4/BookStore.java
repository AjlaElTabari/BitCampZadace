package tasks2_3_4;

public class BookStore {
	private String name;
	private Book[] books;
	
	/**
	 * Constructor
	 * @param name
	 * @param books
	 */
	public BookStore(String name, Book[] books) {
		super();
		this.name = name;
		this.books = books;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the books
	 */
	public Book[] getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Book[] books) {
		this.books = books;
	}
	
	/**
	 * Prints out information about bookstore
	 */
	public String toString() {
		String s = "";
		s += "Name: " + name + "\n";
		for (int i = 0; i < books.length; i++) {
			s += "Book: \n" + this.books[i].toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Simulates procedure of selling books. 
	 * Finds desired book in the book store and 
	 * decreses its stock value by quantity, if it is possible
	 * @param b Book
	 */
	public void sellBook(Book b, int quantity) {
		for (int i = 0; i < books.length; i++) {
			if (b.equals(books[i])) {
				if(books[i].getStock() - quantity > 0) {
					books[i].setStock(books[i].getStock() - quantity);
				} else {
					System.out.println("There is no book on stock.");
				}
			}
		}
	}
	
	/**
	 * Simulates procedure of buying books. 
	 * Adds newd book in the book store and 
	 * increases its stock value by quantity, if book 
	 * already exists in the bookstore, or add completely 
	 * new book, if it doesn't
	 * @param b Book
	 */
	public void buyBook(Book b, int quantity) {
		for (int i = 0; i < books.length; i++) {
			if (b.equals(books[i])) {
				books[i].setStock(books[i].getStock() + quantity);
			} else {
				Book[] newBooks = new Book[books.length + 1];
				for (int j = 0; j < books.length; j++) {
					if(j < newBooks.length) {
						newBooks[j] = books[j];
					} else {
						newBooks[j] = b;
					}
				}
			}
		}
	}
	
}
