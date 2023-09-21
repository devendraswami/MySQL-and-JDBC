package pwskills;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import pwskills.utility.JdbcUtil;
import java.util.Date;



public class InsertApp { 
	public static void main(String args[]) {
	 
		// Resources used 
	Connection connection = null;
	PreparedStatement pstmt   = null; 
	ResultSet resultSet   = null; 
	Scanner scan = null;
	String sname = "";
	
	try {
		// Getting the connection
		connection = JdbcUtil.getdbConnection();
		String sqlSelectQuery = "select name,dob from person where name = ?";

		

		if (connection != null)
		pstmt = connection.prepareStatement(sqlSelectQuery);
		if (pstmt != null) {
		scan = new Scanner(System.in);
		System.out.print("Enter the name of the person:: ");
		sname = scan.next();
		// Setting the values for PreparedStatement
		pstmt.setString(1, sname);
		resultSet = pstmt.executeQuery();
		}
		if (resultSet != null) {
		if (resultSet.next()) {
		System.out.println("NAME\tDOB");
		Date sqlDate = resultSet.getDate(2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy");
		

		String stringDate = sdf.format(sqlDate);
		System.out.println(resultSet.getString(1)+"\t"+

		stringDate);

		} else {
		System.out.println("Record not available for the givename :: "+sname);

		
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
