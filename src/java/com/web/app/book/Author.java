package com.web.app.book;

/**
 *
 * @author Tiego Makaleng
 */
public class Author {
	
    private String authorid, fname, lname;

    public Author(String authorid, String fname, String lname) {
        this.authorid = authorid;
        this.fname = fname;
        this.lname = lname;
    }

    public String getAuthorid() {
        return authorid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }       

}
