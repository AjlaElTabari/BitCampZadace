package task1;

import java.util.Calendar;

/**
 * Represents a class for storing digitally created complaint of any kind.
 * 
 * @author ajla
 *
 */
public class Complaint {
	private Integer id;
	private String dateTime;
	private String text;

	/**
	 * Constructor that makes a new complaint with provided content.
	 * 
	 * @param text
	 */
	public Complaint(String text) {
		super();

		Calendar cal = Calendar.getInstance();
		this.dateTime = cal.getTime().toString();
		this.text = text;
	}

	/**
	 * Constructor that makes a new complaint with id, timestamp and content
	 * provided.
	 * 
	 * @param id
	 * @param dateTime
	 * @param text
	 */
	public Complaint(Integer id, String dateTime, String text) {
		super();

		this.id = id;
		this.dateTime = dateTime;
		this.text = text;
	}

	// Getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Prints out information about complaint.
	 */
	@Override
	public String toString() {
		String result = String.format("%d | %s | %s", id, dateTime, text);
		return result;
	}

}
