package task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents connector between database and java classes. Opens connection to
 * database and runs queries on tables.
 * 
 * @author ajla
 *
 */
public class DBConnector {

	/**
	 * Opens connection to the database and stores a complaint to the database.
	 * 
	 * @param complaint
	 */
	public static void storeComplaintToTheDB(Complaint complaint) {
		
		// Establishing connection
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");

			// Defining path to the database
			conn = DriverManager
					.getConnection("jdbc:sqlite:C:/Users/ajla/Documents/sqlite3/complaints");
			System.out.println("Connection established.");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Could not connect to the database.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

		// Building and executing sql query
		try {
			Statement statement = conn.createStatement();

			String query = "INSERT INTO complaint(date_time, complaint) VALUES('"
					+ complaint.getDateTime()
					+ "', '"
					+ complaint.getText()
					+ "')";

			System.out.println(query);

			statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Bad SQL Command.");
			System.out.println("Continuing on.");
		}
	}

	/**
	 * Selects all complaints from the database.
	 * @return
	 */
	public static ArrayList<Complaint> selectAllComplaints() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");

			conn = DriverManager
					.getConnection("jdbc:sqlite:C:/Users/ajla/Documents/sqlite3/complaints");
			System.out.println("Connection established.");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Could not connect to the database.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

		ArrayList<Complaint> list = new ArrayList<>();

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("select * from complaint");

			while (result.next()) {
				int id = result.getInt(1);
				String dateTime = result.getString(2);
				String text = result.getString(3);

				Complaint e = new Complaint(id, dateTime, text);
				list.add(e);
			}
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

		return list;
	}
}
