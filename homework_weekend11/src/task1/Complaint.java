package task1;

import java.util.Calendar;



public class Complaint {
	private Integer id;
	private String dateTime;
	private String text;
	
	public Complaint(String text) {
		super();
		
		Calendar cal = Calendar.getInstance();
		this.dateTime = cal.getTime().toString();
		this.text = text;
	}
	
	public Complaint(Integer id, String dateTime, String text) {
		super();
		
		this.id = id;
		this.dateTime = dateTime;
		this.text = text;
	}

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

	@Override
	public String toString() {
		String result = String.format("%d | %s | %s", id, dateTime, text);
		return result;
	}


	
}
