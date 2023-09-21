package pwskills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test { 
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
	
		/*
		// First load and register the driver
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		
		// establish the connection 
		
		  String url = "jdbc:mysql://localhost:3306/pwskillsbatch"; 
		  String user = "root"; 
		  String password = "Devendra@12345";
		
		Connection connection = 	DriverManager.getConnection(url,user,password);   
		
		
		// Create a statement object 
		
		Statement statement = connection.createStatement();
		
	   // Execute the Query 
		
		String sqlSelectQuery = "select sid,sname,sage,saddress from student";
		ResultSet resultSet =	statement.executeQuery(sqlSelectQuery); 
		
		
		// Process the resultSet 
		
	   System.out.println("SID\tSNAME\tSAGE\tSADDRESS"); 
	   
	   while(resultSet.next()) {
		   System.out.println(resultSet.getInt(1)+ "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + 
	   resultSet.getString(4));
		   
	   }
		
		statement.close();
		connection.close();
		resultSet.close(); 
		
		
		*/
		
		
		
		
		
		
		// Code to insert query 
		
		/*
		// First load and register the driver
		
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				
				
				// establish the connection 
				
				  String url = "jdbc:mysql://localhost:3306/pwskillsbatch"; 
				  String user = "root"; 
				  String password = "Devendra@12345";
				
				Connection connection = 	DriverManager.getConnection(url,user,password);   
				
				
				// Create a statement object 
				
				Statement statement = connection.createStatement();
				
			   // Execute the Query 
				
				String sqlInsertQuery = "insert into student(sid,sName,sage,saddress) values(5,'DevBhai',22,'Giroodi')";
				int rowAffected =	statement.executeUpdate(sqlInsertQuery);
				
				if(rowAffected == 1) {
					System.out.println("No. of rows affected is :: " + rowAffected );
					
				} else {
					System.out.println("Not a successful insertion....");
					
				}
			
				
				statement.close();
				connection.close();
				
				*/ 
		
		
	
		
		// code to delete query 
		/*
		
		// First load and register the driver
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		
		// establish the connection 
		
		  String url = "jdbc:mysql://localhost:3306/pwskillsbatch"; 
		  String user = "root"; 
		  String password = "Devendra@12345";
		
		Connection connection = 	DriverManager.getConnection(url,user,password);   
		
		
		// Create a statement object 
		
		Statement statement = connection.createStatement();
		
	   // Execute the Query 
		
		String sqlDeleteQuery = "delete from student where sid = 1 ";
		int rowAffected =	statement.executeUpdate(sqlDeleteQuery);
		
		if(rowAffected == 1) {
			System.out.println("No. of rows affected is :: " + rowAffected );
			
		} else {
			System.out.println("Not a successful deletion...");
			
		}
	
		
		statement.close();
		connection.close();
		*/
		
		
		
		
		// Code to update Query 
		

		
		// First load and register the driver
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		
		// establish the connection 
		
		  String url = "jdbc:mysql://localhost:3306/pwskillsbatch"; 
		  String user = "root"; 
		  String password = "Devendra@12345";
		
		Connection connection = 	DriverManager.getConnection(url,user,password);   
		
		
		// Create a statement object 
		
		Statement statement = connection.createStatement();
		
	   // Execute the Query 
		
		String sqlUpdateQuery = "update student set sName = 'Sachin' where sid = 2 ";
		int rowAffected =	statement.executeUpdate(sqlUpdateQuery);
		
		if(rowAffected == 1) {
			System.out.println("No. of rows affected is :: " + rowAffected );
			
		} else {
			System.out.println("No record found for updation ");
			
		}
	
		
		statement.close();
		connection.close();
				
		
		
	}

}
