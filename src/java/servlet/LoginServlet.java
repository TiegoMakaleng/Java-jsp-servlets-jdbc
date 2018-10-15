
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.app.eng.SoftwareEngineer;
import com.web.app.login.eng.LoginEngineer;
import com.web.app.login.mgr.LoginManager;
import com.web.app.login.user.LoginUser;
import com.web.app.login.userdao.UserDAO;
import com.web.app.mgr.Manager;
import com.web.app.user.User;

/**
 *
 * @author Tiego Makaleng
 */
public class LoginServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              //Interpret the request	   
                PrintWriter out = response.getWriter();
                HttpSession session = request.getSession(true);
                
                String decision = request.getParameter("login");
                String driver, url, user, pass;

                url = getServletContext().getInitParameter("url"); 
                driver = getServletContext().getInitParameter("driver"); 		
                user = getServletContext().getInitParameter("username"); 
                pass = getServletContext().getInitParameter("password"); 

                try
                {

                        UserDAO dao = new UserDAO(driver, url, user, pass);
                        
                        LoginUser objUser = new LoginUser(0, request.getParameter("usern"), request.getParameter("passw"));
                        boolean validUser = dao.loginUser(objUser.getUsername(), objUser.getPassword());
                        
                        LoginEngineer objEng = new LoginEngineer(0, request.getParameter("usern"), request.getParameter("passw"));
                        boolean validEngineer = dao.loginEngineer(objEng.getUsername(), objEng.getPassword());
                        
                        LoginManager objMgr = new LoginManager(0, request.getParameter("usern"), request.getParameter("passw"));
                        boolean validManager = dao.loginManager(objMgr.getUsername(), objMgr.getPassword());
                                                                        
                           if (request.getParameter("usern") != "" && request.getParameter("passw") != "") { 
                                if (validUser)
                                {
                                    response.sendRedirect("User.jsp");
                                    List<User> list = (ArrayList<User>)dao.getUserLoggedIn(request.getParameter("usern"), request.getParameter("passw"));
                                    
                                    session.setAttribute("listUser", list);                                   
                                }
                                else                                
                                if (validEngineer)
                                {                                
                                     List<SoftwareEngineer> list = (ArrayList<SoftwareEngineer>)dao.getEngineerLoggedIn(request.getParameter("usern"), request.getParameter("passw"));

                                     response.sendRedirect("Engineer.jsp");	
                                     session.setAttribute("listEngineer", list);
                                } 
                                else
                                if (validManager)
                                {
                                     List<Manager> list = (ArrayList<Manager>)dao.getManagerLoggedIn(request.getParameter("usern"), request.getParameter("passw"));
                                     session.setAttribute("listManager", list);
                                     response.sendRedirect("Manager.jsp");	                                
                                } 
                                else {
//                                  String invalidLogin = "Incorrect username/password.";
//                                  request.setAttribute("login", invalidLogin);
//                                  RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
//                                  dispatch.forward(request, response); 
                                    response.sendRedirect("invalidLogin.html"); 
                                }
                         }
                         else {
//                                  String invalidLogin = "All fields must be entered.";
//                                  request.setAttribute("loginFields", invalidLogin);
//                                  RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
//                                  dispatch.forward(request, response);
                                    response.sendRedirect("fields.html");
                        }         
                } catch (Exception e) {
                    out.println(e.getMessage());
                }	
				
	 }         
    
}
