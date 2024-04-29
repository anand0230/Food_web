package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddNewFoodDAO {
	
	public int k=0;
	public  int insert(FoodBean fb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into food59 values(?,?,?,?)");
			
			ps.setString(1, fb.getFcode());
			ps.setString(2, fb.getFname());
			ps.setLong(3, fb.getPrice());
			ps.setInt(4, fb.getQty());
			k=ps.executeUpdate();
		   
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return k;
	}

}
