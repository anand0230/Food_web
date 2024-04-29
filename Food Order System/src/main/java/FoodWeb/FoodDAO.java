package FoodWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAO  {
	
	public ArrayList<FoodBean> al= new ArrayList<FoodBean>();
	public ArrayList<FoodBean> retrieveFood() {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Food59");
			ResultSet rs=ps.executeQuery();
             while(rs.next()){
       FoodBean fb=new FoodBean();
       fb.setFcode(rs.getString(1));
       fb.setFname(rs.getString(2));
       fb.setPrice(rs.getLong(3));
       fb.setQty(rs.getInt(4));
       al.add(fb);   	
                         }
			
						
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		return al;
	}
	
	

}
