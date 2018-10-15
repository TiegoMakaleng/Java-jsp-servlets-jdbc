
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
public class UserRegisterServlet  extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
			
                        User objUser = new User(0, request.getParameter("lname"), request.getParameter("fname"),
                                request.getParameter("cSex"), request.getParameter("dob"), 
                                request.getParameter("address")
                              , request.getParameter("aCode"), request.getParameter("id"), 
                                request.getParameter("cellNo"), request.getParameter("email"),
                                request.getParameter("email"), request.getParameter("pwd")
                        );
                        
                      if (objUser.getLastName() != null || objUser.getFirstName() != null ||
                                  objUser.getSex() != null || objUser.getBirthdate() != null || 
                                  objUser.getAddress() != null || objUser.getCode() != null ||
                                  objUser.getIdNo() != null || objUser.getCellNo() != null ||
                                  objUser.getEmail() != null || objUser.getPassword() != null) {
                                   if (request.getParameter("passwd").equals(request.getParameter("pwd"))) { 
                                       if (dao.addUser(objUser)> 0) {
                                            response.sendRedirect("addUser.html"); 
                                        }
                                   }
                                   else                          
                                   {
                                        response.sendRedirect("mismatch.html");	
                                   }   
                            }
                            else {
                                      response.sendRedirect("fields.html");  
                            }                             
		}
		catch(Exception e)
		{		
			out.println("Error " + e.getMessage());
		}
        }   
}
