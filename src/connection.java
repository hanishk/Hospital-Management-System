import java.sql.*;
public class connection {
   
	 Connection ce;
	 Statement st;
	
	public connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ce=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
			st=ce.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
