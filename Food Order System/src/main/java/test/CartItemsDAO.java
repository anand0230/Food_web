package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartItemsDAO {
	
	public ArrayList<CartBean> al1=new ArrayList<CartBean>();

	public ArrayList<CartBean> cartitems(){
		try {
		
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("select  * from cart59");
			
	     	ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			CartBean cb=new CartBean();
			cb.setRownum(rs.getInt(1));
			cb.setFname(rs.getString(2));
			cb.setPrice(rs.getLong(3));
			cb.setQty(rs.getInt(4));
			al1.add(cb);
			
		}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return al1;
	}
	

}
