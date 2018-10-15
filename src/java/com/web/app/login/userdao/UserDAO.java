package com.web.app.login.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.app.book.Author;
import com.web.app.book.Book;
import com.web.app.book.Cost;
import com.web.app.book.Publisher;
import com.web.app.eng.SoftwareEngineer;
import com.web.app.login.eng.LoginEngineer;
import com.web.app.login.mgr.LoginManager;
import com.web.app.login.user.LoginUser;
import com.web.app.mgr.Manager;
import com.web.app.user.User;

public class UserDAO {
	
    private Connection connection;
	private Statement statement;
	
	public UserDAO (String driver, String url, String username, String password) throws  ClassNotFoundException, SQLException {
	    Class.forName(driver);
		 
		connection = DriverManager.getConnection(url, username, password);
		statement  = connection.createStatement();
	}
        
    public int addUser(User user) throws SQLException {

		String sql = "insert into tbluser values(" + 0 +",'" + user.getLastName() + "','" + user.getFirstName() +"','"+user.getSex() + "','" + user.getBirthdate() + "','" + user.getAddress() + "','" + user.getCode() +"','"+user.getIdNo() + "','" + user.getCellNo() + "','" + user.getEmail() + "')";
        addLoginUser(user);
		
		return statement.executeUpdate(sql);	
	}
        
    public LoginUser checkUser(String username) throws SQLException {
        LoginUser objUser = null;
        String sql = "SELECT *"
                  + " FROM loginuser"
                  + " WHERE username='" + username + "'";
        ResultSet result = statement.executeQuery(sql);
	    while(result.next()) {
		   objUser = new LoginUser (result.getInt(1), result.getString(2), result.getString(3));			 
	    }
		return objUser;	
	}
                
    public int resetUserPassword(String username, String newPassword) throws SQLException {
        String sql = "Update loginuser"
                 +  " SET password='"+newPassword+"'"
                 +  " WHERE username='"+username+"'";
        return statement.executeUpdate(sql);	
	}
        
    public LoginEngineer checkEngineer(String username) throws SQLException {
        LoginEngineer objEng = null;
        String sql = "SELECT *"
                  + " FROM loginengineer"
                  + " WHERE username='"+username+"'";
        ResultSet result = statement.executeQuery(sql);
		while(result.next()) {
		     objEng = new LoginEngineer(result.getInt(1), result.getString(2), result.getString(3));			 
		     
		}
		return objEng;	
	}
                
    public int resetEngineerPassword(String username, String newPassword) throws SQLException {
        String sql = "Update loginengineer"
                 +  " SET password='" + newPassword + "'"
                 +  " WHERE username='" + username + "'";
		return statement.executeUpdate(sql);	
	}
        
    public LoginManager checkManager(String username) throws SQLException {
        LoginManager objMgr = null;
        String sql = "SELECT *"
                  + " FROM loginmanager"
                  + " WHERE username='" + username + "'";
        ResultSet result = statement.executeQuery(sql);
		while(result.next()) {
		    objMgr = new LoginManager (result.getInt(1), result.getString(2), result.getString(3));			  
		}
		return objMgr;	
	}
                
    public int resetManagerPassword(String username, String newPassword) throws SQLException {
        String sql = "Update loginmanager"
                 +  " SET password='" + newPassword + "'"
                 +  " WHERE username='" + username + "'";
		return statement.executeUpdate(sql);	
	}
        
	public int addLoginUser(User user) throws SQLException {
		String sql = "insert into loginuser values("+0+",'"+user.getUsername()+"','"+user.getPassword()+"')";
		return statement.executeUpdate(sql);	
	}              
        
	public boolean loginUser(String username, String password)  throws SQLException {	      
		LoginUser objUser = null;
		String sql = "select * from loginuser";
		ResultSet result = statement.executeQuery(sql);
		  
		boolean login = false;
		while(result.next()) {
		  objUser = new LoginUser (result.getInt(1), result.getString(2), result.getString(3));
		  if (objUser.getUsername().equalsIgnoreCase(username) && objUser.getPassword().equals(password)) {
			 login = true;
          }			 
		}
		return login;	
	} 
        
    public boolean loginEngineer(String username, String password)  throws SQLException {	      
		LoginEngineer objEng = null;
		  
		String sql = "select * from loginengineer";
		ResultSet result = statement.executeQuery(sql);
		  
		boolean login = false;
		while(result.next()) {
		   objEng = new LoginEngineer(result.getInt(1), result.getString(2), result.getString(3));
			 
		   if (objEng.getUsername().equalsIgnoreCase(username) && objEng.getPassword().equals(password)) {
			   login = true;
           }			 
		}
		return login;	
    } 
          
    public boolean loginManager(String username, String password)  throws SQLException {	      
		LoginManager objMgr = null;
		  
		String sql = "select * from loginmanager";
		ResultSet result = statement.executeQuery(sql);
		  
		boolean login = false;
		while(result.next()) {
		    objMgr = new LoginManager(result.getInt(1), result.getString(2), result.getString(3));
		    if (objMgr.getUsername().equalsIgnoreCase(username) && objMgr.getPassword().equals(password)) {
			    login = true;
            }			 
		}
		return login;	
	} 
        
	public List<User> getAllUsers() throws SQLException {
		
		String sql   = "select * from tbluser";
		ResultSet rs = statement.executeQuery(sql);
        List<User> list = new ArrayList<User>();
		                
		while (rs.next()) {                                         
           list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
		}
		
		return list;			
	}
        
    public List<User> getFemaleUsers() throws SQLException {
		
		String sql   = "select * from tbluser where sex='female'";
		ResultSet rs = statement.executeQuery(sql);
        List<User> list = new ArrayList<User>();
		                
		while (rs.next()) {                                         
            list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
		}
		return list;			
	}
        
    public List<User> getMaleUsers() throws SQLException {
		
		String sql   = "select * from tbluser where sex='male'";      
		ResultSet rs = statement.executeQuery(sql);
        List<User> list = new ArrayList<User>();
		                
		while (rs.next()) {                                         
           list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
		}
		
		return list;			
	}
        
    public List<Manager> getManagerLoggedIn(String username, String password) throws SQLException {
		String sql   = "select * "
                     + "from tblmanager, loginmanager "
                     + "where mgrId=staffId "
                     + "and username='" + username + "' "
                     + "and password='" + password + "'";
					 
		ResultSet rs = statement.executeQuery(sql);
        List<Manager> list = new ArrayList<Manager>();
		                
		while (rs.next()) {                                         
           list.add(new Manager(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
		}
		
		return list;			
	}
        
    public List<SoftwareEngineer> getEngineerLoggedIn(String username, String password) throws SQLException {
		String sql   = "select * "
                     + "from tblengineer, loginengineer "
                     + "where staffNo=staffId "
                     + "and username='"+username+"' "
                     + "and password='"+password+"'";
					 
		ResultSet rs = statement.executeQuery(sql);
        List<SoftwareEngineer> list = new ArrayList<SoftwareEngineer>();
		                
		while (rs.next()) {                                         
           list.add(new SoftwareEngineer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
		}
		
		return list;			
	}
        
    public List<User> getUserLoggedIn(String username, String password) throws SQLException {
		String sql   = "select * "
                             + "from tbluser, loginuser "
                             + "where loginuser.userId=tbluser.userId "
                             + "and username='" + username + "' "
                             + "and password='" + password + "'";
							 
		ResultSet rs = statement.executeQuery(sql);
        List<User> list = new ArrayList<User>();
		                
		while (rs.next()) {                                         
           list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
		}
		
		return list;			
	}
	
	// close database connection
	public void closeConnection() throws SQLException {
	   statement.close();
	   connection.close();
	}

}