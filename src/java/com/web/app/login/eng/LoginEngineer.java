package com.web.app.login.eng;

/**
 *
 * @author Tiego Makaleng
 */
public class LoginEngineer {
	
    private int staffID;
    private String username, password;

    public LoginEngineer(int staffID, String username, String password) {
        this.staffID = staffID;
        this.username = username;
        this.password = password;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
