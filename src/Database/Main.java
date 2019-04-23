package Database;

import java.sql.Connection;

public class Main {
	
	public static void main (String[] args) throws Exception{
		DBConnection DB = new DBConnection();
		Connection connection = DB.getConnection();
	}
}