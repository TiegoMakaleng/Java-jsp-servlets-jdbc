
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.app.login.userdao.UserDAO;
import com.web.app.user.User;

/**
 *
 * @author Tiego Makaleng
 */
public class UserServlet extends HttpServlet {
    
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//Interpret the request
		String decision = request.getParameter("login");
		PrintWriter out = response.getWriter();
		String driver, url, user, pass;
                
		url = getServletContext().getInitParameter("url"); 
		driver = getServletContext().getInitParameter("driver"); 		
		user = getServletContext().getInitParameter("username"); 
		pass = getServletContext().getInitParameter("password"); 

		try
		{
			
            UserDAO dao = new UserDAO(driver, url, user, pass);
			ArrayList<User> list = (ArrayList<User>)dao.getAllUsers();
			//attach the value to the request
			request.setAttribute("listUsers",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("Members.jsp");
			dispatch.forward(request,response);	
			
		} catch(Exception e) {
			out.println("<html><body><span><font color=red>Session has expired.<br>Please Logout and Login Again.</font></span></body></html>");
		}
    }   
       	
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//Interpret the request		
		PrintWriter out = response.getWriter();
		String driver, url, user, pass;
                
		url = getServletContext().getInitParameter("url"); 
		driver = getServletContext().getInitParameter("driver"); 		
		user = getServletContext().getInitParameter("username"); 
		pass = getServletContext().getInitParameter("password"); 

		try
		{
                        UserDAO dao = new UserDAO(driver, url, user, pass);
			ArrayList<User> list = (ArrayList<User>)dao.getAllUsers();
			//attach the value to the request
			request.setAttribute("listUsers",list);				
			RequestDispatcher dispatch = request.getRequestDispatcher("Members.jsp");
			dispatch.forward(request,response);		
		}
		catch(Exception e)
		{
		
			out.println("<html><body><span><font color=red>Session has expired.<br>Please Logout and Login Again.</font></span></body></html>");
		}
        }   
}
