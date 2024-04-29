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
@WebServlet("/edit")

public class EditFoodServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired Please Login Again!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
			
		}else {
			
			String fcode=req.getParameter("fcode");
			ArrayList<FoodBean> al=(ArrayList<FoodBean>) hs.getAttribute("alist");
			Iterator it=al.iterator();
			while(it.hasNext()) {
				FoodBean fb=(FoodBean)it.next();
				if(fb.getFcode().equals(fcode)) {
					
					req.setAttribute("fbean", fb);
					req.getRequestDispatcher("UpdateFood.jsp").forward(req, res);
					break;
					
					
				}
				
				
			}
			
			
			
			
			   
					
		
			
		}
		
  
		
		
		
		
	}

}
