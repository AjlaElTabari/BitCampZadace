package task2;


import task1.StoryCharacter;
import task1.StoryElement;

/**
 * Describes a goal of protagonist of the story
 * Contains difficulty of event: easy, hard and impossible
 * @author ajla
 *
 */
public class Goal extends StoryElement {
	public static final int EASY = 0;
	public static final int HARD = 1;
	public static final int IMPOSSIBLE = 2;
	
	private int difficulty;
	private int event;
	private StoryCharacter character;
	/**
	 * Constructor that makes a Goal object, setting
	 * mandatory properties 
	 * @param name
	 * @param difficulty
	 * @param event
	 * @param character
	 */
	public Goal(String name, int difficulty, int event, StoryCharacter character) {
		super(name);
		this.difficulty = difficulty;
		this.event = event;
		this.character = character;
	}
	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	/**
	 * @return the event
	 */
	public int getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(int event) {
		this.event = event;
	}
	/**
	 * @return the character
	 */
	public StoryCharacter getCharacter() {
		return character;
	}
	/**
	 * @param character the character to set
	 */
	public void setCharacter(StoryCharacter character) {
		this.character = character;
	}
	
}
