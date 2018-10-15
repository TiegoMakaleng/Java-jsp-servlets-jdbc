package com.web.app.login.user;

public class LoginUser {
	
   private int userID;
   private String username;
   private String password;
   
   public LoginUser(int userID, String username, String password) {
     this.userID = userID;
	 this.username = username;
	 this.password = password;
   }
   
   public int getUserid() {
     return userID;
   }
   
   public String getUsername() {
     return username;
   }
   
   public String getPassword() {
     return password;
   }
}
