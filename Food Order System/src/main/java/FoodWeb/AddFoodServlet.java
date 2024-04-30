package FoodWeb;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/addfood")

public class AddFoodServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired Please Login Again!");
		}else {
			FoodBean fb=new FoodBean();
			fb.setFcode(req.getParameter("fcode"));
			fb.setFname(req.getParameter("fname"));
			fb.setPrice(Long.parseLong(req.getParameter("price")));
			fb.setQty(Integer.parseInt(req.getParameter("qty")));
			
			int k=new AddNewFoodDAO().insert(fb);
			if(k>0) {
				req.setAttribute("msg", "NewFoodAdded..");
				req.getRequestDispatcher("AddSuccess.jsp").forward(req, res);
			}else {
				req.setAttribute("msg", "Food Not added...");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}	
			
		}
						
	}

}
