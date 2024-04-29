package FoodWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddToCartDAO {
	public int k=0;
	public int addtocart(FoodBean fb,int qty) {
		try {
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("insert into cart59 values(sq1.nextval,?,?,?)");
			long price=fb.getPrice()*qty;
			ps.setString(1, fb.getFname());
			ps.setLong(2, price);
			ps.setInt(3, qty);
			k=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
			
			
		}
		
		return k;
		
		
	}

}
