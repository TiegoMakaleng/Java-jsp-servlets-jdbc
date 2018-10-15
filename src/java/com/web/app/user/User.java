package com.web.app.user;

/**
 *
 * @author Tiego Makaleng
 */
public class User {
	
    private int userid;
    private String lastName;
    private String firstName;
    private String sex;
    private String birthdate;
    private String address;
    private String code;
    private String idNo;
    private String cellNo;
    private String email;
    private String username, password;
    
    public User(int userid, String lastName, String firstName, String sex, String birthdate, String address, String code, String idNo, String cellNo, String email) {
        this.userid = userid;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.address = address;
        this.code = code;
        this.idNo = idNo;
        this.cellNo = cellNo;
        this.email = email;
    }

    public User(int userid, String lastName, String firstName, String sex, String birthdate, String address, String code, String idNo, String cellNo, String email, String username, String password) {
        this.userid = userid;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.address = address;
        this.code = code;
        this.idNo = idNo;
        this.cellNo = cellNo;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getEmail() {
        return email;
    }    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
