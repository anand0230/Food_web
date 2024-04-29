package FoodWeb;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/clogin")

public class CustomerLoginServlet  extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String uN=req.getParameter("uname");
		String pW=req.getParameter("pword");
		CustomerBean cb=new CustomerDAO().clogin(uN,pW);
		if(cb==null) {
		req.setAttribute("msg", "NO User Found...");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("cbean", cb);
			req.setAttribute("cbean", cb);
			req.getRequestDispatcher("cloginsuccess.jsp").forward(req, res);
			
				System.out.println("hii");
		}
		
		
		
	}
	
	
	
	
}
