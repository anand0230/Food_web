package test;
import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/alogin")

public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
  
		String uN=req.getParameter("uname");
		String uP=req.getParameter("pword");
		AdminBean ab=new AdminDAO().aLogin(uN, uP);
		if(ab==null) {
			req.setAttribute("msg", "Admin Login faild Please enter Write Uname & Pword:");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);

		}
		else {
			
			HttpSession hs=req.getSession();
			hs.setAttribute("abean",ab);
			ServletContext sct=req.getServletContext();
			sct.setAttribute("msg", "hii i  am devil i am living everywhere in this application");
			req.setAttribute("aname", ab.getFname());
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
			
		    
			

		}
		
		
		
	
		
		
		
	}

}
