package company;

public class CompanyMain {

	public static void main(String[] args) {
		
		Employee director = new Employee("Jan-Luc Picard", "Male", 2600.00);
		
		Employee employee1 = new Employee("Data", "Male", 1800.00);
		Employee employee2 = new Employee("Deanna Troi", "Female", 2300.00);
		Employee employee3 = new Employee("Wesley Crusher", "Male", 1489.00);
		Employee employee4 = new Employee("Wiliam Riker", "Male", 1800.00);
		Employee employee5 = new Employee("Geordi La Forge", "Male", 1700.00);
		Employee employee6 = new Employee("Tasha Yar", "Female", 2600.00);

		// Declaring and initializing an array of employees
		Employee[] employees = { director, employee1, employee2, employee3,
				employee4, employee5, employee6 };

		Company company1 = new Company("USS Enterprise", director, employees);

		// Printing out company information
		System.out.println(company1);

		// Printing out the sum of all monthly incomes in the company
		System.out.printf("Sum of all salaries in the firm is: %.2f\n\n",
				company1.getSumOfSalaries());

		// Printing out the number of females in the company
		System.out.printf("Number of female employees in the firm is: %d\n\n",
				company1.getNumberOfFemaleEmployees());

		// Increasing monthly incomes
		company1.increaseMonthlyIncome(450.00);

		// Printing out the number of females in the company
		// to check if raise was processed
		System.out.println("The sum of all monthly incomes in the company is: " + " " + company1.getSumOfSalaries());


	}

}
