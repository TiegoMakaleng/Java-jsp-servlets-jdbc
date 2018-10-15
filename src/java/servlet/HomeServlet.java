import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Tiego Makaleng
 */
public class HomeServlet extends HttpServlet {
    
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//Interpret the request	
		PrintWriter out = response.getWriter();

		try
		{                   
                  response.sendRedirect("index.jsp");                  		
		}
		catch(Exception e)
		{
		
			out.println(e.getMessage());
		}
        }    
}
