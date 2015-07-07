package company;

/**
 * Represents a business company
 * 
 * @author ajla
 *
 */
public class Company {
	// Declaring properties of firm
	private String name;
	private Employee director;
	private Employee[] employees;

	/**
	 * Constructor that makes Company object using this class as pattern
	 * 
	 * @param name
	 * @param director
	 * @param employees
	 */
	public Company(String name, Employee director, Employee[] employees) {
		super();
		this.name = name;
		this.director = director;
		this.employees = employees;
	}

	/**
	 * Getting the number of employees in the company. Director is an employee,
	 * but he/she is not in the array of employees
	 * 
	 * @return - int that represents number of employees in the company
	 */
	public int getNumberOfEmployees() {
		return employees.length;
	}

	/**
	 * Iterates through the employees array, calculating the sum of all monthly
	 * incomes
	 * 
	 * @return double that represents the sum of monthly incomes of all
	 *         employees
	 */
	public double getSumOfSalaries() {

		double sumOfMonthlyIncomes = 0;

		for (int i = 0; i < employees.length; i++) {
			sumOfMonthlyIncomes += employees[i].getMonthlyIncome();
		}

		return sumOfMonthlyIncomes;
	}

	/**
	 * Calculates the number of females in the company
	 * 
	 * @return int that represents the number of female employees in the
	 *         company.
	 */
	public int getNumberOfFemaleEmployees() {

		int numOfFemaleEmployees = 0;

		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getGender().equals("Female")) {
				numOfFemaleEmployees++;
			}
		}
		return numOfFemaleEmployees;
	}

	/**
	 * Increases monthly income by received amount It is not limited on positive
	 * numbers for amount, because negative amount can represent decrease of the
	 * monthly income
	 * 
	 * @param raise
	 */
	public void increaseMonthlyIncome(double raise) {
		for (int i = 0; i < employees.length; i++) {
			employees[i].setMonthlyIncome(employees[i].getMonthlyIncome()
					+ raise);
		}
	}

	/**
	 * Printing information about the company
	 */
	public String toString() {
		return String.format(
				"Name: %s\nDirector: %s\nNumber of employees: %s\n", name,
				director.getName(), String.valueOf(getNumberOfEmployees()));
	}

}
