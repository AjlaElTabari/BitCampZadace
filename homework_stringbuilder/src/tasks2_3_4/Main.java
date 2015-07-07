package tasks2_3_4;


public class Main {

	public static void main(String[] args) {
				
		// Authors
		Author a = new Author("Mesa Selimovic", "mesa@tvrjava.ba", Author.MALE);
		Author a1 = new Author("Branko Copic", "branko@legenda.ba", Author.MALE);
		Author a2 = new Author("Antoine de Saint-Exupery", "anto@princ.ba", Author.MALE);
		Author a3 = new Author("Stella Gurney", "stela@mjau.ba", Author.FEMALE);
		Author a4 = new Author("Mario Saric", "mario@tresnje.ba", Author.MALE);
		Author a5 = new Author("Ivana Brlic Mezuranic", "ivana@svasta.ba", Author.FEMALE);
		System.out.println(a);
		
		// Books
		Book b = new Book("Tvrdjava", 15.60, a, 7);
		System.out.println(b);
		
		Book b1 = new Book("Mali princ", 15.60, a2, 12);
		Book b2 = new Book("Orlovi rano lete", 11.20, a1, 16);
		Book b3 = new Book("Macak u cizmama", 20.00, a3, 34);
		Book b4 = new Book("Tresnjevacke tresnje", 10.99, a4, 3);
		Book b5 = new Book("Segrt Hlapic", 6.60, a5, 11);
		Book b6 = new Book("Magarece godine", 8.90, a1, 3);
		
		Book[] books = {b1, b2, b3, b4, b5, b6};
		
		// Bookstore
		BookStore bs = new BookStore("Cipelici", books);
		
		System.out.println(bs);
		
		bs.sellBook(b6, 2);
		
		System.out.println(bs);
		
		bs.buyBook(b6, 14);
		System.out.println(bs);
		
	}

}
