package task2_and_3;

/**
 * Represents an article from some kind of store.
 * 
 * @author ajla
 *
 */
public class Article {
	private Integer id;
	private String name;
	private Float price;

	/**
	 * Constructor that makes an article with id, name and price provided.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 */
	public Article(Integer id, String name, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * Constructor that makes an article with only name and price provided.
	 * @param name
	 * @param price
	 */
	public Article(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	// Getters and settes
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * Prints out information about an article.
	 */
	@Override
	public String toString() {
		return "Artical [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}

}
