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
public class BookIndexServlet extends HttpServlet {
    
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//Interpret the request		
		PrintWriter out = response.getWriter();
		String driver, url, user, pass;
                String option = request.getParameter("bk");
		url = getServletContext().getInitParameter("url"); 
		driver = getServletContext().getInitParameter("driver"); 		
		user = getServletContext().getInitParameter("username"); 
		pass = getServletContext().getInitParameter("password"); 

		try
		{
                    BookDAO dao = new BookDAO(driver, url, user, pass);
                    
                    if(option.equals("Business")) { 
                        
                        ArrayList<Book> list = (ArrayList<Book>)dao.getBusinessBooks();
                        //attach the value to the request
                        request.setAttribute("listBook",list);				
                        RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
                        dispatch.forward(request,response);
                        
                     } else if (option.equals("Children")){         
                         
			ArrayList<Book> list = (ArrayList<Book>)dao.getChildrenBooks();
			//attach the value to the request
			request.setAttribute("listBook",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
			dispatch.forward(request,response);
                        
                     } else if (option.equals("Computer")){
                         
                         ArrayList<Book> list = (ArrayList<Book>)dao.getComputerBooks();
			//attach the value to the request
			request.setAttribute("listBook",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
			dispatch.forward(request,response);
                        
                     } else if (option.equals("Cooking")){
                         
                         ArrayList<Book> list = (ArrayList<Book>)dao.getCookingBooks();
			//attach the value to the request
			request.setAttribute("listBook",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
			dispatch.forward(request,response);
                        
                     } else if (option.equals("Family Life")){
                         
                         ArrayList<Book> list = (ArrayList<Book>)dao.getFamilyBooks();
			//attach the value to the request
			request.setAttribute("listBook",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
			dispatch.forward(request,response);
                        
                     } else if (option.equals("Fitness")){
                         
                         ArrayList<Book> list = (ArrayList<Book>)dao.getFitnessBooks();
			//attach the value to the request
			request.setAttribute("listBook",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
			dispatch.forward(request,response);
                        
                     } else if (option.equals("Programming")){
                         
                         ArrayList<Book> list = (ArrayList<Book>)dao.getProgrammingBooks();
			//attach the value to the request
			request.setAttribute("listBook",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("BooksIndex.jsp");
			dispatch.forward(request,response);
                     }	
			
		}
		catch(Exception e)
		{
		
			out.println(e.getMessage());
		}
        }    
}
