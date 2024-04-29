package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteCartItemsDAO {
	
	public int k=0;
	public int delete() {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Delete from cart59");
			k=ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return k;
	}

}
