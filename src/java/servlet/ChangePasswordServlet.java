package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class ChangePasswordServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //Interpret the request	   
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(true);

            String decision  = request.getParameter("change");
//            String username  = request.getParameter("username");
//            String newPass1  = request.getParameter("password1");
//            String newPass2  = request.getParameter("password2");
            
            String driver, url, user, pass;

            url = getServletContext().getInitParameter("url"); 
            driver = getServletContext().getInitParameter("driver"); 		
            user = getServletContext().getInitParameter("username"); 
            pass = getServletContext().getInitParameter("password"); 

            try
            {

                      UserDAO dao = new UserDAO(driver, url, user, pass);
                      
                      LoginUser objUser = dao.checkUser(request.getParameter("username"));
                      LoginEngineer objEng = dao.checkEngineer(request.getParameter("username"));
                      LoginManager objMgr = dao.checkManager(request.getParameter("username"));
                      
                      if (request.getParameter("username") != "" || request.getParameter("password1") != "" || request.getParameter("password2") != "") { 
//                        if(request.getParameter("password1").equals(request.getParameter("password2"))){ 
                          if (objUser != null) { 
                              if(request.getParameter("password1") != "" && request.getParameter("password2") != "") { 
                                if (request.getParameter("password1").equals(request.getParameter("password2"))) { 
                                   if (dao.resetUserPassword(request.getParameter("username"), request.getParameter("password1")) > 0)
                                   {
                                        response.sendRedirect("updatedPassword.html");                                                               
                                   }
                                   else                          
                                   {
                                        response.sendRedirect("update_1.html");	
                                   }   
                                 } else {
                                        response.sendRedirect("mismatch.html");
                                 } 
                              } else {
                                  response.sendRedirect("mismatch_1.html");
                              } 
                            }
                            else if (objEng != null)
                            {
                               if(request.getParameter("password1") != "" && request.getParameter("password2") != "") { 
                                if (request.getParameter("password1").equals(request.getParameter("password2"))) { 
                                   if (dao.resetEngineerPassword(request.getParameter("username"), request.getParameter("password1")) > 0)
                                   {
                                        response.sendRedirect("updatedPassword.html");                                                               
                                   }
                                   else                          
                                   {
                                        response.sendRedirect("update_1.html");	
                                   }   
                                 } else {
                                        response.sendRedirect("mismatch.html");
                                 } 
                               } else {
                                        response.sendRedirect("mismatch_1.html");
                               }         
                             } 
                             else if (objMgr != null)
                             {
                                if(request.getParameter("password1") != "" && request.getParameter("password2") != "") { 
                                    if (request.getParameter("password1").equals(request.getParameter("password2"))) { 
                                       if (dao.resetManagerPassword(request.getParameter("username"), request.getParameter("password1")) > 0)
                                       {
                                            response.sendRedirect("updatedPassword.html");                                                               
                                       }
                                       else                          
                                       {
                                            response.sendRedirect("update_1.html");	
                                       }   
                                     } else {
                                            response.sendRedirect("mismatch.html");
                                     } 
                                } else {
                                            response.sendRedirect("mismatch_1.html");
                                }
                             } 
                             else {
                                      response.sendRedirect("invalidLogin_1.html");	
                             }                         
//                        }
//                        else {                                   
//                                      response.sendRedirect("mismatch.html");
//                        }
                      }
                      else {
                                      response.sendRedirect("fields.html");  
                      }
            } catch (Exception e) {
                out.println(e.getMessage()); 
//               out.println("Your Session has expired." ); 
            }	
				
	 }           
}
