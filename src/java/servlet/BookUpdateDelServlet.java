import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.app.book.Book;
import com.web.app.bookdao.BookDAO;

/**
 *
 * @author Tiego Makaleng
 */
public class BookUpdateDelServlet extends HttpServlet {
         
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		//Interpret the request		
                String option = request.getParameter("update");
		PrintWriter out = response.getWriter();
                HttpSession session = request.getSession(true);
		String driver, url, user, pass;
                
		url    = getServletContext().getInitParameter("url"); 
		driver = getServletContext().getInitParameter("driver"); 		
		user   = getServletContext().getInitParameter("username"); 
		pass   = getServletContext().getInitParameter("password"); 

		try
		{
                        BookDAO dao = new BookDAO(driver, url, user, pass);
                        if (option.equals("DELETE")){
                                if ( request.getParameter("isbnbk") != null) {
                                   if (dao.deleteBook(request.getParameter("isbnbk"))> 0) {
                                       response.sendRedirect("delete.jsp");
                                   }
                                } else {
                                       response.sendRedirect("notice_delete.jsp");
                                }
                        }       
                        else
                            if (option.equals("EDIT")) { 
                                 if ( request.getParameter("isbnbk") != null) {
                                      List<Book> bk = dao.getBook(request.getParameter("isbnbk"));
                                      request.setAttribute("bk", bk);
                                      RequestDispatcher dispatch = request.getRequestDispatcher("editBook.jsp");
                                      dispatch.forward(request, response);  
                                 } else {
                                      response.sendRedirect("notice_edit.jsp");
                                 }
                              } 
                        if (request.getParameter("update").equals("OK")) {
                           if (dao.editBook(request.getParameter("bisbn"), request.getParameter("btitle"), Double.parseDouble(request.getParameter("bprice")))> 0) {
                                response.sendRedirect("update.jsp");
                           }
                       }
                        					
                }
		catch(Exception e)
		{
		
			out.println("Error Occured " + e.getMessage());
		}
        }    
}
