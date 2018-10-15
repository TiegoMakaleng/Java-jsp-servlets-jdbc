package com.web.app.mgr;

/**
 *
 * @author Tiego Makaleng
 */
public class Manager {
	
    private int staffId;
    private String firstname, lastname, sex, birthdate, idno;
    private String address, areaCode, cellno, email;

    public Manager(int staffId, String firstname, String lastname, String sex, String birthdate, String idno, String address, String areaCode, String cellno, String email) {
        this.staffId = staffId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.birthdate = birthdate;
        this.idno = idno;
        this.address = address;
        this.areaCode = areaCode;
        this.cellno = cellno;
        this.email = email;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getIdno() {
        return idno;
    }

    public String getAddress() {
        return address;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getCellno() {
        return cellno;
    }

    public String getEmail() {
        return email;
    }    
}
