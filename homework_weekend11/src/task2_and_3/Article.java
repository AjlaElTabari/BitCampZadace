package task2_and_3;

public class Article {
	private Integer id;
	private String name;
	private Float price;
	
	
	public Article(Integer id, String name, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Article(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}


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


	@Override
	public String toString() {
		return "Artical [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}
	
	
	
}
