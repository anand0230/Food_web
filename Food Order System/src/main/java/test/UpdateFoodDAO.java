package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SuppressWarnings("serial")
public class UpdateFoodDAO implements Serializable {
	
	
	public int k=0;
	public int updatef(FoodBean fb ,int qty) {
		
		try {
		Connection con=DBConnection.getCon();
	     
		PreparedStatement ps=con.prepareStatement("update food59 set qty=? where fcode=?");
		int qty1=fb.getQty()-qty;
		ps.setInt(1, qty1);
		ps.setString(2, fb.getFcode());
		k=ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return k;
		
	}
   
	
	
	
	

}
