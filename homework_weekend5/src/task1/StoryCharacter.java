package task1;

/**
 * Describes a story character
 * @author ajla
 *
 */
public class StoryCharacter extends StoryElement {
	private boolean sex;
	private boolean isAlive;
	private boolean isCapable;
	/**
	 * @param name
	 * @param sex
	 * @param isAlive
	 * @param isCapable
	 */
	public StoryCharacter(String name, boolean sex, boolean isAlive,
			boolean isCapable) {
		super(name);
		this.sex = sex;
		this.isAlive = isAlive;
		this.isCapable = isCapable;
	}
	
	/**
	 * @param name
	 * @param sex
	 * @param isCapable
	 */
	public StoryCharacter(String name, boolean sex, boolean isCapable) {
		this(name, sex, true, isCapable);
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * @return the isCapable
	 */
	public boolean isCapable() {
		return isCapable;
	}

	/**
	 * @param isCapable the isCapable to set
	 */
	public void setCapable(boolean isCapable) {
		this.isCapable = isCapable;
	}

	/**
	 * Kills StoryCharacter on demand,
	 * by setting isAlive property to false
	 */
	public void killCharacter() {
		if(isAlive) {
			isAlive = false;
		} else {
			System.out.println("Character is already dead.");
		}
	}
	
	/**
	 * Makes StoryCharacter capable,
	 * by setting isCapable property to true
	 */
	public void becameCapable() {
		if(!isCapable) {
			isCapable = true;
		} else {
			System.out.println("Character is already capable.");
		}
	}
}