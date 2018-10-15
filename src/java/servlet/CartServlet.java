package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.app.book.Book;
import com.web.app.book.ShoppingCart;
import com.web.app.bookdao.BookDAO;

/**
 *
 * @author Tiego Makaleng
 */
public class CartServlet extends HttpServlet {
    
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
     {
		//Interpret the request	
//		PrintWriter out     = response.getWriter();
//                HttpSession session = request.getSession(true);
//		String driver, url, user, pass;
//                
//		url = getServletContext().getInitParameter("url"); 
//		driver = getServletContext().getInitParameter("driver"); 		
//		user = getServletContext().getInitParameter("username"); 
//		pass = getServletContext().getInitParameter("password"); 

//		try
//		{
//                        BookDAO dao = new BookDAO(driver, url, user, pass);
//                      int qty     = Integer.parseInt(request.getParameter("qty"));
//                        ShoppingCart shopping = (ShoppingCart) session.getAttribute("cart");
//		        String decision = request.getParameter("select");
                        
//			if (shopping == null)
//			{
//				shopping = new ShoppingCart(new ArrayList<Book>());
//			}
			
//			if (decision != null) {
////                             if (decision.equals("checkout")) {  
//                                   response.sendRedirect("OrderSummary.jsp");
//                             }
//                         }
//                             else if (decision.equals("Remove Book"))
//			     {
//				   String[] items = request.getParameterValues("isbns");
//				   
//				   for(String isbns : items)
//				   {
//				        shopping.removeBook(isbns);
//				   }
//                               
//				   response.sendRedirect("removeItem.html");
//		             }
//                             else if (decision.equals("Payment")){
//                                 response.sendRedirect("removeItem.html");
//                             }                                 
//                             else {
//                                  response.sendRedirect("bkusr.do");
//                             }
		                      
//                }
//                catch(Exception e)
//		{
// 			out.println("Error: "+e.getMessage());
////			out.println("<html><body><span><font color=red>Session has expired.<br>Please Logout and Login Again.</font></span></body></html>");
//		}
        }
        
}
