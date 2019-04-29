package database;
import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Views.MultiLogin;

/**
 *  Establish a connection to the MySQL server
 *  Update all existing values made by the user as needed
 *  Get all existing usernames and passwords in server (getConnection)
 *  Provide admin with special connection privileges (getAdministratorConnection)
 *  Provide process owner with special connection privileges (getProcessOwnerConnection)
 *  Provide executor with special connection privileges (getExecutorConnection)
 */
public class DBConnection {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String rootname = "root";
	String rootpassword = "Root";
	public ResultSet getConnection(String username, String password,String usertype) throws Exception{
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, rootname, rootpassword);
			System.out.println("Connected");
			Statement st = conn.createStatement();
			st.executeQuery("USE multiuserlogin");
			st.executeQuery("select * from users where Username='"+username+"' and Password='"+password+
					"' and Usertype='"+usertype+"'");
			ResultSet rs = st.getResultSet();
			return rs;
			} catch(Exception e) {System.out.println(e);}
		
		return null;

		}
	public ResultSet getAdminstratorConnection(String task_number, String task_name,String task_description) throws Exception{
		
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, rootname, rootpassword);
			System.out.println("Connected");
			Statement st = conn.createStatement();
			st.executeQuery("USE multiuserlogin");
			st.executeUpdate("insert into admin_tasks(task_number,task_name,task_description) values ("+task_number+",'"+task_name+"','"+task_description+"')");
			ResultSet admin_result= st.getResultSet();
			return admin_result;
			} catch(Exception e) {System.out.println(e);}
		return null;
		
	}
	public ResultSet getProcessOwnerConnection() throws Exception{
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, rootname, rootpassword);
			System.out.println("Connected");
Statement st = conn.createStatement();
			st.executeQuery("USE multiuserlogin");
			st.executeQuery("select task_name from admin_tasks");
			ResultSet rs = st.getResultSet();
			return rs;
			} catch(Exception e) {System.out.println(e);}
		return null;
	}
		public ResultSet getEvidenceConnection() throws Exception{
			try {
				
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, rootname, rootpassword);
				System.out.println("Connected");
				Statement st = conn.createStatement();
				st.executeQuery("USE multiuserlogin");
				st.executeQuery("select evidence_type from evidencetable");
				ResultSet result2 = st.getResultSet();
				return result2;
				} catch(Exception e) {System.out.println(e);}
		
		return null;
		}
		
		public ResultSet getExecutorConnection() throws Exception{
			try {
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, rootname, rootpassword);
				System.out.println("Connected");
				Statement st = conn.createStatement();
				st.executeQuery("USE multiuserlogin");
				st.executeQuery("select Executor_Name from executortable");
				ResultSet result3 = st.getResultSet();
				return result3;
				} catch(Exception e) {System.out.println(e);}
		
		return null;

		
		}
	}


