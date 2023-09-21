package pwskills.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcUtil {
   
	static {

		// First load and register the driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
	} 
}
	
	public static Connection getdbConnection() throws SQLException {

		// establish the connection 
		
		  String url = "jdbc:mysql://localhost:3306/pwskillsbatch"; 
		  String user = "root"; 
		  String password = "Devendra@12345";
		
		  return DriverManager.getConnection(url,user,password);   
		
	} 
	
	 
	public static void closeResource(ResultSet result, Connection connection, Statement statement)throws SQLException {
		
		 if(statement != null) 
			  statement.close();
		 
		 if(connection != null) 
			 connection.close();
			 
		 if(result != null) 
			 result.close();
			 
		 }
	}
	  

