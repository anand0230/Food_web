package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {
	
	public CustomerBean cb=null;
	public CustomerBean clogin(String uN,String pW) {
		
	try {
	    Connection con=DBConnection.getCon();
	    PreparedStatement ps=con.prepareStatement("select * from customer59 where uname=? and pword=?");
	    ps.setString(1, uN);
	    ps.setString(2, pW);
	    
	    ResultSet rs=ps.executeQuery();
	    if(rs.next()) {
	    	cb=new CustomerBean();
	    	cb.setUname(rs.getString(1));
	    	cb.setPword(rs.getString(2));
	    	cb.setFname(rs.getString(3));
	    	cb.setLname(rs.getString(4));
	    	cb.setAddr(rs.getString(5));
	    	cb.setMid(rs.getString(6));
	    	cb.setPhno(rs.getLong(7));
	    	
	    }
	    
	    
	}catch(Exception e){
		e.printStackTrace();	
	}
	
		return cb;
		
		
	}
	

}
