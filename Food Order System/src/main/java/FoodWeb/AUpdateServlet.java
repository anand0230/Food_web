package FoodWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/aupdate")

public class AUpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired Please Login Again!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
			
		}else {
			String fcode= req.getParameter("fcode");
			String fname=req.getParameter("fname");
			long price=Long.parseLong(req.getParameter("price"));
			int qty=Integer.parseInt(req.getParameter("qty"));
			
			
			ArrayList<FoodBean> al=(ArrayList<FoodBean>)hs.getAttribute("alist");
			Iterator<FoodBean> it=al.iterator();
			while(it.hasNext()) {
				
			FoodBean fb=(FoodBean)it.next();
			if(fb.getFcode().equals(fcode)) {
				fb.setFname(fname);
				fb.setPrice(price);
				fb.setQty(qty);
				int k=new EditFoodDAO().edit(fb);
				if(k>0) {
					req.setAttribute("msg", "ProductUpdated...<br>");
					req.getRequestDispatcher("Msg.jsp").forward(req, res);
				}else {
					req.setAttribute("msg", "ProductNotUpdated...<br>");
					req.getRequestDispatcher("Msg.jsp").forward(req, res);
				}
				
				
			}//end of main if
				
			}//end of while
			
			
			
			   
					
		
			
		}
		
  
		
		
		
		
	}

}
