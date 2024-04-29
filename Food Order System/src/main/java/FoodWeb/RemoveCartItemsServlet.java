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
@WebServlet("/remove")

public class RemoveCartItemsServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {	
	
	HttpSession hs=req.getSession();
	if(hs==null) {
		req.setAttribute("msg", "Session Excpired...");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}else {
		
	     
		int rownum=Integer.parseInt(req.getParameter("rownum"));
		
	ArrayList<CartBean> al1=(ArrayList<CartBean>) hs.getAttribute("al1list")  ;
	Iterator<CartBean> itr=al1.iterator();
	while(itr.hasNext()) {
		CartBean cb=(CartBean)itr.next();
	   if(cb.getRownum()==rownum) {
		   int k=new RemoveCartItems().remove(cb,rownum);
		   if(k>0)
		   {
			   req.setAttribute("msg", "Removed....");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);			   
		   }else{
			   req.setAttribute("msg", " not removed");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);		
		   }
	   }
	}
		
		
	}
	
}
	

}
