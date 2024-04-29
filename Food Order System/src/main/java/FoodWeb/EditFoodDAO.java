package FoodWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditFoodDAO {
	
	public int k=0;
	public int edit(FoodBean fb) {
		
		try {
			
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update food59 set fname=?,price=?,qty=? where fcode=?");
			ps.setString(1, fb.getFname());
			ps.setLong(2, fb.getPrice());
			ps.setInt(3, fb.getQty());
			ps.setString(4, fb.getFcode());
		 
			k=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
		
	}

}
