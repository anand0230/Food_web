package test;

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
@WebServlet("/addtocartq")


public class AddToCartQServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
		
		HttpSession hs=req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg", "Session  Expired...");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}else {
		
		String fcode=req.getParameter("fcode");
		int qty=Integer.parseInt(req.getParameter("qty"));
	     
		ArrayList<FoodBean> al=(ArrayList<FoodBean>)hs.getAttribute("alist");
		Iterator itr=al.iterator();
		
		while(itr.hasNext()) {
			FoodBean fb=(FoodBean)itr.next();
			if(fb.getFcode().equals(fcode)) {
				
			  int k=new UpdateFoodDAO().updatef(fb, qty);
			  
			  int l=new AddToCartDAO().addtocart(fb, qty);
			  if(k>0 && l>0) {
				  req.setAttribute("msg", "Food Added in cart...<br> ");
				  req.getRequestDispatcher("Msg.jsp").forward(req, res);

			  }else {
				  req.setAttribute("msg", "Food NOt Added in Cart try again? <br>");
				  req.getRequestDispatcher("Msg.jsp").forward(req, res);
			  }

			
				break;
			}
			
			
			
			
		    
		}
		
		
		 
		 
		
		
		
	}
		
		
	
		
		
		
	}

}
