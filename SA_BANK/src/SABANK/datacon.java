package SABANK;
import java.sql.*;

public class datacon {

	Statement stmt;
	Connection con;
	datacon(){
		
		try {
			String url = "jdbc:mysql://localhost:3306/sbank";
			String username = "root";
			String password = "Sahil@123";
			
			con = DriverManager.getConnection(url,username,password);
	//		System.out.println("Connected successfully ");
			stmt = con.createStatement();
			
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		
	}
}
