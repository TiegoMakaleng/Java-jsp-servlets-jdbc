
package com.web.app.book;

/**
 *
 * @author Tiego Makaleng
 */
public class Publisher {
	
    private int pubId;
    private String pubName;
    private long contactno;
    private String email;    

    public Publisher(int pubId, String pubName,  long contactno, String email) {
        this.pubId = pubId;
        this.pubName = pubName;
        this.email = email;
        this.contactno = contactno;
    }

    public int getPubId() {
        return pubId;
    }

    public String getPubName() {
        return pubName;
    }
    
    public long getContactno() {
        return contactno;
    }    
    
    public String getEmail() {
        return email;
    } 
    
}
