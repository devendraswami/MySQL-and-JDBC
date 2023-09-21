package pwskills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pwskills.utility.JdbcUtil;



public class Test { 
	public static void main(String args[]) {
	 
		// Resources used 
	Connection connection = null;
	Statement statement   = null; 
	ResultSet resultSet   = null; 
	
	 try { 
		 // Established Connection
		connection = JdbcUtil.getdbConnection(); 
		
		 if(connection != null) {
			  statement = connection.createStatement();
		  }
			
		  if(statement != null) {
			  String sqlSelectQuery = "select  sid,sName,sage,saddress from student";
			  resultSet = statement.executeQuery(sqlSelectQuery);
		  }
		 
		if(resultSet != null) { 
			 
			System.out.println("sid\tsName\tsage\tsaddress");
			
			while(resultSet.next()) { 
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + resultSet.getInt(3)
				+ "\t" + resultSet.getString(4) );
				
				
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	 // Closing Resources 
	 finally{
		 try {
			JdbcUtil.closeResource(resultSet, connection, statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

		
		
		
		
		
	}

}
