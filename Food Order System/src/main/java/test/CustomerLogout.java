package test;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/logout")

public class CustomerLogout extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Sessin Expired...");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			
			hs.removeAttribute("alist");
			hs.removeAttribute("al1list");
			hs.invalidate();
			int k=new DeleteCartItemsDAO().delete();
			if(k>0) {
				req.setAttribute("msg", "Logout Success");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}else {
				System.out.println("why not logout");
				req.setAttribute("msg", "NOt Logout");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
		}
		
	}
	
	


}
