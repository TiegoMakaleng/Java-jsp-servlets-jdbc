package com.web.app.bookdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.web.app.book.Author;
import com.web.app.book.Book;
import com.web.app.book.Cost;
import com.web.app.book.Publisher;
import com.web.app.book.ShoppingCart;

/**
* @author Tiego Makaleng 
*/

public class BookDAO {
	
	private Connection connection;
	private Statement statement;
	
	public BookDAO(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();
	}
	
	public List<Book> getAllBooks() throws SQLException {
		String sql = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn";
		ResultSet rs = statement.executeQuery(sql);
	
        List<Book> list = new ArrayList<Book>();
		                
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;		
	}
        
    public Book getABook(String isbn) throws SQLException {
		Book book = null;
		String sql = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and bk_costs.isbn='" + isbn + "'";
                               
		ResultSet rs = statement.executeQuery(sql);
                
		while (rs.next()) {                                         
           book =   new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
           new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
           new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
           new Cost(rs.getString(14), rs.getDouble(15)));  
		}
		
        return book;		
	}
	
    /**
	* @param isbn The isbn of the book we are looking for.
	* @return list The list of books we are looking for.
	*/
    public List<Book> getBook(String isbn) throws SQLException {
        List<Book> list = new ArrayList<Book>();
        Book book = null;
		
		String sql = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and bk_costs.isbn='"+isbn+"'";
                               
		ResultSet rs = statement.executeQuery(sql);
                
		while (rs.next()) {                                         
            book =   new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15)));  
            list.add(book);
		}
		
        return list;		
	}
        
    public List<Book> getBusinessBooks() throws SQLException {
		String sql   = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='business'";
				
		ResultSet rs = statement.executeQuery(sql);
        List<Book> list = new ArrayList<Book>();
		                
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;			
	}
        
    public List<Book> getChildrenBooks() throws SQLException {
		
		String sql   = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='children'";              
                
		ResultSet rs = statement.executeQuery(sql);
        List<Book> list = new ArrayList<Book>();  
		
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;			
	}
        
    public List<Book> getComputerBooks() throws SQLException {
		String sql = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='computer'"; 
		ResultSet rs = statement.executeQuery(sql);
	
                List<Book> list = new ArrayList<Book>();
		                
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;				
	}
        
    public List<Book> getCookingBooks() throws SQLException {
		String sql   = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='cooking'";  
		ResultSet rs = statement.executeQuery(sql);
	
        List<Book> list = new ArrayList<Book>();
		
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;				
	}
        
    public List<Book> getFamilyBooks() throws SQLException {
		String sql   = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='family life'";
				
		ResultSet rs = statement.executeQuery(sql);
        List<Book> list = new ArrayList<Book>();
		                
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;				
	}
	
    public List<Book> getFitnessBooks() throws SQLException{
		String sql   = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='fitness'";
				
		ResultSet rs = statement.executeQuery(sql);
        List<Book> list = new ArrayList<Book>();
		                
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;			
	}
        
    /*
    public List<Book> getProgrammingBooks() throws SQLException
	{
                String sql   = "select isbn,title,fname,lname,category,pubname,pubdate"
                + " from bk_books, bk_author, publisher"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and category='programming'";
		ResultSet rs = statement.executeQuery(sql);
	
                List<Book> list = new ArrayList<Book>();
		               
                Author objAuthor = null;
                Publisher objPublisher = null;
                Cost objCost = null;
                
		while (rs.next())
		{  
//                    objAuthor    = new Author(rs.getString(1), rs.getString(2), rs.getString(3));
//                    objPublisher = new Publisher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));
//                    objCost      = new Cost(rs.getString(1), rs.getDouble(2));
                    
                    list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7)));                                        
		}
		
		return list;		
	}
        */
        
       public List<Book> getProgrammingBooks() throws SQLException {
                String sql  = "select bk_books.isbn,title,pubdate,bk_books.pubid,category,bk_books.authorid,bk_author.authorid,fname,lname,publisher.pubId,pubname,contactno,email,bk_costs.isbn,cost"
                + " from bk_books, bk_author, publisher, bk_costs"
                + " where bk_books.authorid=bk_author.authorid"
                + " and bk_books.pubid=publisher.pubid"
                + " and bk_costs.isbn=bk_books.isbn"
                + " and category='programming'";
				
		ResultSet rs = statement.executeQuery(sql);
        List<Book> list = new ArrayList<Book>();
		                
		while (rs.next()) {                                         
            list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
            new Author(rs.getString(7), rs.getString(8), rs.getString(9)),
            new Publisher(rs.getInt(10), rs.getString(11), rs.getLong(12), rs.getString(13)),
            new Cost(rs.getString(14), rs.getDouble(15))));                                  
		}
		
		return list;		
	}
          
    public int editBook(String isbn, String title, double price) throws SQLException {
		String sql = "update bk_Books set title = '"+title+"',isbn='"+isbn+"' where isbn='"+isbn+"'";
		editCost(isbn, price);
        return statement.executeUpdate(sql);
	}
	
    public int editCost(String isbn, double price) throws SQLException	{
		String sql = "update bk_costs set cost=" + price + ",isbn='" + isbn + "' where isbn='" + isbn +"'";		
        return statement.executeUpdate(sql);
	}
        
	public int addBook(String isbn, String title, String pdate, int pubid, String cat, String authorid) throws SQLException {
		String sql = "insert into bk_books(isbn, title, pubdate, pubid, category, authorid)"
               + " values('"+isbn+"','"+title+"','"+pdate+"',"+pubid+",'"+cat+"','"+authorid+"')";	
		return statement.executeUpdate(sql);	
	}
        
    public int addCost(String isbn, double price) throws SQLException {
		String sql = "insert into bk_costs(isbn,cost)"
                          + " values('"+isbn+"',"+price+")";	
		return statement.executeUpdate(sql);	
	}
        
    public int deleteBook(String isbn) throws SQLException {
		String sql = "delete from bk_books where isbn='"+isbn+"'";                
                deleteCost(isbn);
		return statement.executeUpdate(sql);	
	}
        
    public int deleteAuthor(String authorid) throws SQLException {
		String sql = "delete from bk_author where authorid='"+authorid+"'";
		return statement.executeUpdate(sql);	
	}
        
    public int deletePublisher(int pubid) throws SQLException {
		String sql = "delete from publisher where pubid='"+pubid+"'";
		return statement.executeUpdate(sql);	
	}
        
    public int deleteCost(String isbn) throws SQLException {
		String sql = "delete from bk_costs where isbn='"+isbn+"'";
		return statement.executeUpdate(sql);	
	}
       
    public int removeItem(int bookID) throws SQLException {
		String sql = "delete from shoppingcart where bookID="+bookID;
		return statement.executeUpdate(sql);	
	}
        
	public void close() throws SQLException {
		statement.close();
		connection.close();
	}
}