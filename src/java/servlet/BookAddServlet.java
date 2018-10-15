import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.app.book.Book;
import com.web.app.bookdao.BookDAO;
/**
 *
 * @author Tiego Makaleng
 */
public class BookAddServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		PrintWriter out = response.getWriter();
		String driver, url, user, pass;
                
		url = getServletContext().getInitParameter("url"); 
		driver = getServletContext().getInitParameter("driver"); 		
		user = getServletContext().getInitParameter("username"); 
		pass = getServletContext().getInitParameter("password"); 

		try
		{
            BookDAO dao = new BookDAO(driver, url, user, pass);
                        
			if (dao.addBook(request.getParameter("isbn"), request.getParameter("title"), request.getParameter("pdate"), Integer.parseInt(request.getParameter("pid")), request.getParameter("cat"), request.getParameter("ai"))>0) {
                 if (dao.addCost(request.getParameter("isbn"), Double.parseDouble(request.getParameter("price")))>0){
                     response.sendRedirect("add.html"); 
                } 
                else {
                  response.sendRedirect("addError.html"); 
                }
            }                        
					
        } catch(Exception e) {
			out.println("<html><body><span><font color=red>Session has expired.<br>Please Logout and Login Again.</font></span></body></html>");
		}
    }    
    
}
