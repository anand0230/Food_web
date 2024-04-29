package FoodWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteFoodDAO {
	public int k=0;
	public int delete(FoodBean fb) {
		try {
			
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete from food59 where fcode=?");
			ps.setString(1, fb.getFcode());
			k=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}

}
