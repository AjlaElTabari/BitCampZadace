package task1;

/**
 * Describes an element in story
 * @author ajla
 *
 */
public abstract class StoryElement {
	private String name;

	/**
	 * @param name
	 */
	public StoryElement(String name) {
		super();
		this.name = name;
	}
	
	public StoryElement() {
		this("STElement");
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
}
