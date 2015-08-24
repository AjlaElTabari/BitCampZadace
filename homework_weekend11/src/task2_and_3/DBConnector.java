package task2_and_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnector {

	private static Connection openConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");
			
			conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/ajla/Documents/sqlite3/articles");
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
		
		return conn;
	}
	
	public static void addArticleToTheDB(Article article) {
		
		Connection conn = openConnection();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "INSERT INTO article(name, price) VALUES('" + article.getName() + "', " + article.getPrice() + ")";
			
			statement.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Bad SQL Command.");
			System.out.println("Continuing on.");
		}
	}
	
	public static ArrayList<Article> selectAllArticles() {
		
		Connection conn = openConnection();
		
		ArrayList<Article> list = new ArrayList<>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from article");
		
			while (result.next()) {				
				int id = result.getInt(1);
				String name = result.getString(2);
				Float price = result.getFloat(3);
				
				Article a = new Article(id, name, price);
				list.add(a);
			}
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
		return list;
	}
	
	public static boolean doesArticleExist(Integer idForCheck) {
		
		Connection conn = openConnection();
		boolean exists = false;

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from article where id = " + idForCheck);
		
			while (result.next()) {	
				if (idForCheck == result.getInt(1)) {
					exists = true;
				} 
			}
			exists = false;
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
		return exists;
		
	}
	
	public static void deleteArticle(Integer idToDelete) {

		Connection conn = openConnection();

		try {
			Statement statement = conn.createStatement();
			String query = "DELETE FROM article WHERE id = " + idToDelete;
			statement.executeUpdate(query);			
		
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
	}
	
}
