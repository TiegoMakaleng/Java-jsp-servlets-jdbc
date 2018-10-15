
package com.web.app.book;

/**
 *
 * @author Tiego Makaleng
 */
public class Cost {
	
    private String isbn;
    private double price;

    public Cost(String isbn, double price) {
        this.isbn = isbn;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }   

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
