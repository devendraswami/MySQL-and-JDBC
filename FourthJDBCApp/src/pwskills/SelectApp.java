package pwskills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pwskills.utility.JdbcUtil;



public class SelectApp { 
	public static void main(String args[]) {
	 
		// Resources used 
	Connection connection = null;
	PreparedStatement pstmt   = null; 
	ResultSet resultSet   = null; 
	Scanner scan = null;
	
	
	 try { 
		 // Established Connection
		connection = JdbcUtil.getdbConnection(); 
		
		String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid = ? ";
		
		if(connection != null) 
			pstmt = connection.prepareStatement(sqlSelectQuery);
		
		if(pstmt != null) {
			 scan = new Scanner(System.in);
			
			System.out.println("Entre the values of sid : ");
			int sid = scan.nextInt();
			
			
			
			
			pstmt.setInt(1, sid); 
			
			resultSet = pstmt.executeQuery();
			 
			
			if(resultSet != null) {
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS"); 
				
				if(resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" +
				resultSet.getInt(3)+"\t" + resultSet.getString(4));
				} else {
					System.out.println("No record found with sid : " + sid );
		}
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
			 scan.close();
			JdbcUtil.closeResource(resultSet, connection, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

		
		
		
		
		
	}

}
