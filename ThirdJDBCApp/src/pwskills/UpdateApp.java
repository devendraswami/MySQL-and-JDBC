package pwskills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pwskills.utility.JdbcUtil;



public class UpdateApp { 
	public static void main(String args[]) {
	 
		// Resources used 
	Connection connection = null;
	PreparedStatement pstmt   = null; 
	ResultSet resultSet   = null; 
	Scanner scan = null;
	
	
	 try { 
		 // Established Connection
		connection = JdbcUtil.getdbConnection(); 
		
		String sqlUpdateQuery = "update student set sName = ? where sid = ? ";
		
		if(connection != null) 
			pstmt = connection.prepareStatement(sqlUpdateQuery);
		
		if(pstmt != null) {
			 scan = new Scanner(System.in);
			
			System.out.println("Entre the values of sid : ");
			int sid = scan.nextInt();
			
			System.out.println("Entre the Student Name : ");
			String sName = scan.next();
			
			
			
			pstmt.setInt(2, sid);
			pstmt.setString(1, sName);
			
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 1) {
				System.out.println("No. of Rows Affected : " + rowAffected);			
			} else {
				System.out.println("No query updated");
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
