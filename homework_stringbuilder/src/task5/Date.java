package task5;


public class Date {
	private static final int DEFAULT_MONTH_AND_YEAR = 1;
	private int day;
	private int month;
	private int year;

	/**
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * @param day
	 * @param month
	 */
	public Date(int day, int month) {
		this(day, month, DEFAULT_MONTH_AND_YEAR);
	}

	/**
	 * @param day
	 */
	public Date(int day) {
		this(day, DEFAULT_MONTH_AND_YEAR, DEFAULT_MONTH_AND_YEAR);
	}
	
	/**
	 * Validates date 
	 * Checking if entered value for day, month and year is valid
	 * Considers leap years also
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	private boolean validateDate(int day, int month, int year) {
		boolean validDate = false;
		if ((month >= 1 && month <= 12) && (day >= 1 && day <= 31)) {
			// For months with 30 days
			validDate = ((month == 4 || month == 6 || month == 9 || month == 11) && (day <= 30)) ? true
					: false;

			// For months with 31 days
			validDate = ((month == 1 || month == 2 || month == 3 || month == 5
					|| month == 7 || month == 8 || month == 10 || month == 12) && (day <= 31)) ? true
					: false;

			// For February
			if ((month == 2) && (day < 30)) {
				// Boolean for valid leap year
				boolean validLeapYear = false;

				// A leap year is any year that is divisible by 4 but not
				// divisible by 100 unless it is also divisible by 400
				validLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) ? true
						: false;
				validDate = (validLeapYear == true && day <= 29) ? true : false;

				validDate = (validLeapYear == false && day <= 28) ? true
						: false;
			}
		}
		return validDate;
	}
	
	/**
	 * Changes date value
	 * Verifying new date, if it is valuable date,
	 * sets this.day on new value
	 * @param day
	 */
	public void setDay(int day) {
		if (validateDate(day, this.month, this.year)) {
			this.day = day;
		} else {
			System.out.println("Date is not valid.");
		}
	}
	
	/**
	 * Changes month value
	 * Verifying new date, if it is valuable date,
	 * sets this.month on new value
	 * @param month
	 */
	public void setMonth(int month) {
		if (validateDate(this.day, month, this.year)) {
			this.month = month;
		} else {
			System.out.println("Date is not valid.");
		}
	}
	
	/**
	 * Changes year value
	 * Verifying new date, if it is valuable date,
	 * sets this.year on new value
	 * @param year
	 */
	public void setYear(int year) {
		if (validateDate(this.day, this.month, year)) {
			this.year = year;
		} else {
			System.out.println("Date is not valid.");
		}
	}
	
	/**
	 * Simulating time passing
	 * Increases the day for one, 
	 * verifying date
	 */
	public void DayPassed() {
		if(validateDate(this.day + 1, this.month, this.year)) {
			this.day++;
		} else if (validateDate(1, this.month + 1, this.year)) {
			this.day = 1;
			this.month++;
		} else {
			this.day = 1;
			this.month = 1;
			this.year++;
		}
	}
	
	/**
	 * Simulating time passing
	 * Increases the month for one, 
	 * verifying date
	 */
	public void MonthPassed() {
		if (validateDate(this.day, this.month + 1, this.year)) {
			this.month++;
		} else {
			this.month = 1;
			this.year++;
		}
	}
	
	/**
	 * Simulating time passing
	 * Increases the year for one
	 */
	public String toString() {
		return this.day + "." + this.month + "." + this.year + ".";
	}
}
