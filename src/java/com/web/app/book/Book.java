package com.web.app.book;

/**
 * @author Tiego Makaleng
 */
public class Book {
   /*
    private String isbn, title, fname, lname, category, pubname, pubdate;

    public Book(String isbn, String title, String fname, String lname, String category, String pubname, String pubdate) {
        this.isbn = isbn;
        this.title = title;
        this.fname = fname;
        this.lname = lname;
        this.category = category;
        this.pubname = pubname;
        this.pubdate = pubdate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCategory() {
        return category;
    }

    public String getPubname() {
        return pubname;
    }

    public String getPubdate() {
        return pubdate;
    }
    */
    private String isbn;
    private String title;
    private String pubdate;
    private int pubid;
    private String category;
    private String authorid;
    private Author author;
    private Publisher publisher;
    private Cost cost;
    private int qty; 
	
    public Book(String isbn, String title, String pubdate, int pubid, String category, String authorid, Author author, Publisher publisher, Cost cost) {
        this.isbn = isbn;
        this.title = title;
        this.pubdate = pubdate;
        this.pubid = pubid;
        this.category = category;
        this.authorid = authorid;
        this.author = author;
        this.publisher = publisher;
        this.cost = cost;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getPubdate() {
        return pubdate;
    }

    public int getPubid() {
        return pubid;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthorid() {
        return authorid;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Cost getCost() {
        return cost;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
    
}
