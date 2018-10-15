import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tiego Makaleng
 */
public class LogoutServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(true);
           
            try
            {
                session.invalidate();
                response.sendRedirect("index.jsp"); 
            } catch (Exception e) {
               out.println("Your Session has expired." ); 
            }
       }
}
