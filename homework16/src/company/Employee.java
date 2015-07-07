package company;

/**
 * Represents an employee of the company
 * @author ajla
 *
 */
public class Employee {
		private String name;
		private String gender;
		private double monthlyIncome;

		/**
		 * Constructor
		 * 
		 * @param name
		 * @param gender
		 * @param monthlyIncome
		 */
		public Employee(String name, String gender, double monthlyIncome) {
			this.name = name;
			this.gender = gender;
			this.monthlyIncome = monthlyIncome;
		}

		/**
		 * Prints information about employee.
		 */
		public String toString() {
			return String.format("Name: %s\nGender: %s\nSalary: %.2f\n", name,
					gender, monthlyIncome);
		}

		// Get methods
		public String getName() {
			return name;
		}

		public String getGender() {
			return gender;
		}

		public double getMonthlyIncome() {
			return monthlyIncome;
		}

		// Set method
		public double setMonthlyIncome(double monthlyIncome) {
			return this.monthlyIncome = monthlyIncome;
		}
}
