package FoodWeb;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/alogout")

public class ALogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired Please Login Again!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
			
		}else {
			hs.removeAttribute("alist");
			hs.removeAttribute("fbean");
			
			req.setAttribute("msg", "Logout Successfull...<br>");
			req.getRequestDispatcher("ALogout.jsp").forward(req, res);
			
		
			
			
			
			
		}
		
 	
		
	}

}
