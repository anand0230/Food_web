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
@WebServlet("/delete")

public class DeleteFoodServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired Please Login Again!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
			
		}else {
			
			String fcode=req.getParameter("fcode");
			ArrayList<FoodBean> al=(ArrayList<FoodBean> )hs.getAttribute("alist");
			
			Iterator itr=al.iterator();
			while(itr.hasNext()) {
				FoodBean fb=(FoodBean)itr.next();
				if(fb.getFcode().equals(fcode)) {
					int k=new DeleteFoodDAO().delete(fb);
					if(k>0) {
						req.setAttribute("msg", "Food Deleted...<br>");
						req.getRequestDispatcher("Msg.jsp").forward(req, res);
						
					}else {
						req.setAttribute("msg", "Food Not Deleted...<br>");
						req.getRequestDispatcher("Msg.jsp").forward(req, res);
						
						
					}
					break;
					
				}
			}
			
			
			
		}
		
  
		
		
		
		
	}

}
