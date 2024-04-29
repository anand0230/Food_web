package FoodWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO  {
	public AdminBean ab=null;

	public AdminBean aLogin(String uN,String pW) {
		
try {	
	
	Connection con=DBConnection.getCon();
	PreparedStatement ps=con.prepareStatement("select * from admin59 where uname=? and pword=?");
	ps.setString(1, uN);
	ps.setString(2, pW);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		ab=new AdminBean();
		ab.setUname(rs.getString(1));
		ab.setPword(rs.getString(2));
		ab.setFname(rs.getString(3));
		ab.setLname(rs.getString(4));
		ab.setAddr(rs.getString(5));
		ab.setMid(rs.getString(6));
		ab.setPhno(rs.getLong(7));
	}
	
}catch(Exception e) {
	e.printStackTrace();
	
}
		
		return ab;
	}

}
