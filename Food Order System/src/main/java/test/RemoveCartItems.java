package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemoveCartItems {

	public int k=0;
	public int remove(CartBean cb, int rownum) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete from cart59 where rownum=?");
			ps.setInt(1, rownum);
			k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
