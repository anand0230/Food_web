package test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewcart")

public class ViewAllCartItemsServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "No Items Available...");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
		}else {
			
			
			ArrayList<CartBean> al1=new CartItemsDAO().cartitems();
			if(al1==null) {
				req.setAttribute("msg", "No Items Available...");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}else {
				
			hs.setAttribute("al1list", al1);
			req.getRequestDispatcher("ViewAllCartItems.jsp").forward(req, res);
			
			}
			
	
			
		}
				
	}
	
	
	
	
	
}
