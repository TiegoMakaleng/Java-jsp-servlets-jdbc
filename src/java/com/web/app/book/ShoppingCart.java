package com.web.app.book;

import java.util.List;

/**
 *
 * @author Tiego Makaleng
 */
public class ShoppingCart {
    private List<Book> books;
    private int bookID;
    private int quantity;
    private double bookTotPrice;
    private double price;
    private String title;
    
    public ShoppingCart() {
    }
    
    public ShoppingCart(List<Book> books) {
        this.books = books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
            
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBookTotPrice(double bookTotPrice) {
        this.bookTotPrice = bookTotPrice;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getBookTotPrice() {
        return bookTotPrice;
    }
        
    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookID() {
        return bookID;
    }
            
    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public void addBook(Book book) {
        books.add(book);
    } 
    
    public void removeBook(String isbn) {
        for (int i=0; i < books.size(); i++) {          
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
            }
        }
    }
    
    public List<Book> getBook(){
        return books;
    }
    
    public void updateTotalPrice(String isbn, int qty) {
        int i = 0;
//      double bkTot = 0;        
        for (Book book : books) {          
            if (book.getIsbn().equals(isbn)) {
                book.setQty(qty);                
//              bkTot = book.getCost().getPrice() * qty; 
//              setBookTotPrice(bkTot);
                books.add(i, book);
            }
            i++;
        }
    }
    
    public double calculateTotal(int qty) {
        double tot = 0.0;
        
        for (Book book : books) {  
            book.setQty(qty); 
            tot += book.getCost().getPrice() * book.getQty();  
        }
        return tot;
    }   
    
    public void removeAll(){
        books.clear();
    }
}
