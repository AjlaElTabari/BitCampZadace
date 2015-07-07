package task1;
import java.util.Arrays;


public class CampStringBuilder {
	private char[] characters;

	/**
	 * Constructor
	 * @param characters
	 */
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}

	/**
	 * @return the characters
	 */
	public char[] getCharacters() {
		return characters;
	}

	/**
	 * @param characters the characters to set
	 */
	public void setCharacters(char[] characters) {
		this.characters = characters;
	}
	
	/**
	 * Adds object.toString() to the end of char array
	 */
	public void append(Object o) {
		if (o instanceof String) {
			String s = (String)o; 
			int newLength = characters.length + s.length();
			char newCharacters[] = new char[newLength];
			int counter = 0;
			for (int i = 0; i < newLength; i++) {
				if(i < characters.length) {
					newCharacters[i] = characters[i];
				} else {
					newCharacters[i] = s.charAt(counter);
					counter++;
				}
			}
			// changing pointer of original array to new array
			characters = newCharacters;
		} else {
			System.out.println("Cannot append non String object.");
		}
	}
	
	/**
	 * Adds object.toString() to the beginning of char array
	 */
	public void prepend(Object o) {
		if (o instanceof String) {
			String s = (String)o; 
			int newLength = characters.length + s.length();
			char newCharacters[] = new char[newLength];
			int counter = 0;
			for (int i = 0; i < newLength; i++) {
				if(i < s.length()) {
					newCharacters[i] = s.charAt(i);
				} else {
					newCharacters[i] = characters[counter];
					counter++;
				}
			}
			// changing pointer of original array to new array
			characters = newCharacters;
		} else {
			System.out.println("Cannot append non String object.");
		}
	}
	
	/**
	 * Converts array of chars to String
	 * Override toString method
	 */
	public String toString() {
		return Arrays.toString(characters);
	}
	
}
