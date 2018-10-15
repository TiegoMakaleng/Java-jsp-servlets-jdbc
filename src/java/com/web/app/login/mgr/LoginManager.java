package com.web.app.login.mgr;

/**
 *
 * @author Tiego Makaleng
 */
public class LoginManager {
	
    private int mgrID;
    private String username, password;

    public LoginManager(int mgrID, String username, String password) {
        this.mgrID = mgrID;
        this.username = username;
        this.password = password;
    }

    public int getMgrID() {
        return mgrID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }    
}
