package Database;
import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sql_server_demo";
			String username = "hey";
			String password = "mypass";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
			} catch(Exception e) {System.out.println(e);}
		
		return null;
		
		 
		}
	}


