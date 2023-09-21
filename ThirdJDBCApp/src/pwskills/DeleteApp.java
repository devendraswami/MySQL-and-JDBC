package pwskills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pwskills.utility.JdbcUtil;



public class DeleteApp { 
	public static void main(String args[]) {
	 
		// Resources used 
	Connection connection = null;
	PreparedStatement pstmt   = null; 
	ResultSet resultSet   = null; 
	Scanner scan = null;
	
	
	 try { 
		 // Established Connection
		connection = JdbcUtil.getdbConnection(); 
		
		String sqlDeleteQuery = " delete from student where sid = ? ";
		
		if(connection != null) 
			pstmt = connection.prepareStatement(sqlDeleteQuery);
		
		if(pstmt != null) {
			 scan = new Scanner(System.in);
			
			System.out.println("Entre the values of sid : ");
			int sid = scan.nextInt();
			
			
			
			
			pstmt.setInt(1, sid);
			
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 1) {
				System.out.println("Successfull deleted ");			
			} else {
				System.out.println("record not availabe whith id " + sid);
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
