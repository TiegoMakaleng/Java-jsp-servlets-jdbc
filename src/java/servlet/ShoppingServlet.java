package servlet;

//import ebookshop.Book;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import com.web.app.book.Book;
import com.web.app.book.ShoppingCart;
import com.web.app.bookdao.BookDAO;

public class ShoppingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              //Interpret the request	
//		PrintWriter out     = response.getWriter();
//                HttpSession session = request.getSession(true);
//		String driver, url, user, pass;
//                
//		url    = getServletContext().getInitParameter("url"); 
//		driver = getServletContext().getInitParameter("driver"); 		
//		user   = getServletContext().getInitParameter("username"); 
//		pass   = getServletContext().getInitParameter("password"); 
//                String[] items = request.getParameterValues("isbn");
//
//		try
//		{
//                        BookDAO dao = new BookDAO(driver, url, user, pass);
////                      int qty     = Integer.parseInt(request.getParameter("qty"));
//                        ShoppingCart shopping = (ShoppingCart) session.getAttribute("cart");
//		        String decision = request.getParameter("select");
//                        
////			if (shopping == null)
////			{
////				shopping = new ShoppingCart(new ArrayList<Book>());
////			}
//			
////			if(shopping != null)
////			{                            
//                            
//                            if (decision.equals("Remove")) { 
//                                    shopping.removeBook(request.getParameter("isbn"));
//                                    session.setAttribute("cart", shopping);
//                                    response.sendRedirect("ShopCart.jsp"); 
//                                                                    
//                             } else if (decision.equals("Remove All")) {
//                                shopping.removeAll();           
//                                String total = String.valueOf(shopping.calculateTotal(1));
//                                session.setAttribute("total", total);
//                                response.sendRedirect("ShopCart.jsp");                             
//
//                             } else if (decision.equals("Place Order")) {
//                                 try
//                                 {                                
//                                   String total = String.valueOf(shopping.calculateTotal(1)); 
//                                   Document document = new Document();
//        
//                                   PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Tebelelo/Desktop/Invoice.pdf"));
//                                   document.open();
//                                   document.addAuthor("ST Makaleng");
//                                   document.addCreationDate();
//                                   document.addCreator("www.onlinebookshop.com");
//                                   document.addTitle("Order Invoice");
//                                   document.add(new Paragraph("INVOICE ONLINEBOOKSHOP.COM"));
//                                   document.add(new Paragraph("**********************************************"));
//                                   List<Book> books = shopping.getBook();
//                                   for (Book bk: books) {
//                                    document.add(new Paragraph(bk.getTitle().toUpperCase()+"\t\t\t\tR"+String.valueOf(bk.getCost().getPrice())));
//                                   }
//                                   document.add(new Paragraph("Total Price\t\t\t\t\t\t:R" + total));
//                                   document.add(new Paragraph("*****************END*********************************"));
//                                   document.close();
//                                   JOptionPane.showMessageDialog(null, "Thank for shopping at our store.Check the invoice on your Desktop.");
//                                 } catch (Exception e) {
//                                   JOptionPane.showMessageDialog(null, e.getMessage());
//                                 }
//
//                             }
////                      }                     
//                }
//                catch(Exception e)
//		{
// 			out.println("Error: "+e.getStackTrace()+"\t"+e.getMessage());
////			out.println("<html><body><span><font color=red>Session has expired.<br>Please Logout and Login Again.</font></span></body></html>");
//		}
    }
    
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
                //Interpret the request	
		PrintWriter out     = response.getWriter();
                HttpSession session = request.getSession(true);
		String driver, url, user, pass;
                
		url    = getServletContext().getInitParameter("url"); 
		driver = getServletContext().getInitParameter("driver"); 		
		user   = getServletContext().getInitParameter("username"); 
		pass   = getServletContext().getInitParameter("password"); 
                String[] items = request.getParameterValues("isbn");

		try
		{
                        BookDAO dao = new BookDAO(driver, url, user, pass);
//                      int qty     = Integer.parseInt(request.getParameter("qty"));
                        ShoppingCart shopping = (ShoppingCart) session.getAttribute("cart");
		        String decision = request.getParameter("select");
                        
			if (shopping == null)
			{
				shopping = new ShoppingCart(new ArrayList<Book>());
			}
			
			if(shopping != null)
			{                            
                             if (decision.equalsIgnoreCase("Add to Cart")){
                                for (String isbn: items)
                                {
                                    Book book = dao.getABook(isbn);
                                    shopping.addBook(book);				
                                }
                                DecimalFormat df = new DecimalFormat("0.00");

                                session.setAttribute("cart", shopping);
                                String total = String.valueOf(df.format(shopping.calculateTotal(1)));
                                session.setAttribute("total", total);
                                response.sendRedirect("ShopCart.jsp");                             
                             } 
                            
                            if (decision.equals("Remove")) { 
                                    shopping.removeBook(request.getParameter("isbn"));
                                    session.setAttribute("cart", shopping);
                                    response.sendRedirect("ShopCart.jsp"); 
                                                                    
                             } else if (decision.equals("Remove All")) {
                                shopping.removeAll();           
                                String total = String.valueOf(shopping.calculateTotal(1));
                                session.setAttribute("total", total);
                                response.sendRedirect("ShopCart.jsp");                             

                             } else if (decision.equals("Place Order")) {
                                 try
                                 {                                
                                   String total = String.valueOf(shopping.calculateTotal(1)); 
                                   Document document = new Document();
        
                                   PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Tebelelo/Desktop/Invoice.pdf"));
                                   document.open();
                                   document.addAuthor("ST Makaleng");
                                   document.addCreationDate();
                                   document.addCreator("www.onlinebookshop.com");
                                   document.addTitle("Order Invoice");
                                   document.add(new Paragraph("INVOICE ONLINEBOOKSHOP.COM"));
                                   document.add(new Paragraph("**********************************************"));
                                   List<Book> books = shopping.getBook();
                                   for (Book bk: books) {
                                    document.add(new Paragraph(bk.getTitle().toUpperCase()+"\t\t\t\tR"+String.valueOf(bk.getCost().getPrice())));
                                   }
                                   document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------"));
                                   document.add(new Paragraph("Total Price\t\t\t\t\t\t:R" + total));
                                   document.add(new Paragraph("*****************END*********************************"));
                                   document.close();
                                   JOptionPane.showMessageDialog(null, "Thank for shopping at our store.Check the invoice on your Desktop.");
                                 } catch (Exception e) {
                                   JOptionPane.showMessageDialog(null, e.getMessage());
                                 }

                             }
                      }                     
                }
                catch(Exception e)
		{
 			out.println("Error: "+e.getStackTrace()+"\t"+e.getMessage());
//			out.println("<html><body><span><font color=red>Session has expired.<br>Please Logout and Login Again.</font></span></body></html>");
		}
        }     
        
}
   