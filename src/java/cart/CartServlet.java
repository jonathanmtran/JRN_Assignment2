package cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.*;
import data.*;

/**
 *
 * @author Joel Murach
 * @version
 */
public class CartServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String cellPhoneCode = request.getParameter("cellPhoneCode");
        String quantityAsString = request.getParameter("quantity");
        HttpSession session = request.getSession();
        synchronized(session)
        {
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null)
            {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            int quantity = 1;
            try
            {
                quantity = Integer.parseInt(quantityAsString);
                if (quantity < 0)
                    quantity = 1;
            }
            catch(NumberFormatException nfe)
            {
                quantity = 1;
            }
            
            ServletContext sc = getServletContext();
            String path = sc.getRealPath("WEB-INF/phones.txt");
            CellPhone cellPhone = DataIO.getCellPhone(cellPhoneCode, path);
            LineItem lineItem = new LineItem();
            lineItem.setCellPhone(cellPhone);
            lineItem.setQuantity(quantity);
            if (quantity > 0)
                cart.addItem(lineItem);
            else if (quantity <= 0)
                cart.removeItem(lineItem);
            session.setAttribute("cart", cart);
        }
                       
        String url = "/cart.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    public String getServletInfo()
    {
        return "Short description";
    }
}
