package FoodWeb;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection  {
	
	private static Connection con=null;
	private DBConnection() {
		
	}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			 con=DriverManager.getConnection(DBinfo.DBurl,DBinfo.DBuser,DBinfo.DBpass);
			
			
		}catch(Exception e){
		   e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		
		return con;
	}
	
	

}
