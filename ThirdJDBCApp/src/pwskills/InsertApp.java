package pwskills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pwskills.utility.JdbcUtil;



public class InsertApp { 
	public static void main(String args[]) {
	 
		// Resources used 
	Connection connection = null;
	PreparedStatement pstmt   = null; 
	ResultSet resultSet   = null; 
	Scanner scan = null;
	
	
	 try { 
		 // Established Connection
		connection = JdbcUtil.getdbConnection(); 
		
		String sqlInsertQuery = "insert into student(sid,sName,sage,saddress) values(?,?,?,?)";
		
		if(connection != null) 
			pstmt = connection.prepareStatement(sqlInsertQuery);
		
		if(pstmt != null) {
			 scan = new Scanner(System.in);
			
			System.out.println("Entre the values of sid : ");
			int sid = scan.nextInt();
			
			System.out.println("Entre the Student Name : ");
			String sName = scan.next();
			
			System.out.println("Entre the age of Student : ");
			int sage = scan.nextInt();
			
			System.out.println("Entre the address of Student : "); 
			String saddress = scan.next();
			
			
			pstmt.setInt(1, sid);
			pstmt.setString(2, sName);
			pstmt.setInt(3, sage);
			pstmt.setString(4, saddress); 
			
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
