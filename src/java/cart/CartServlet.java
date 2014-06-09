package cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.*;
import data.*;

public class CartServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		String action = request.getParameter("action");
		
		if(action == null)
			action = "";
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		int itemId = Integer.parseInt(request.getParameter("cellPhoneCode"));
		Item item = ItemDB.selectItem(itemId);
		
		if(action.equals("add")) {	
			cart.addItem(new OrderLine(item, 1));
		}
		else if(action.equals("update")) {
			int qty = Integer.parseInt(request.getParameter("quantity"));
			
			if(qty <= 0)
				cart.removeItem(new OrderLine(item, qty));
			else
				cart.updateItem(new OrderLine(item, qty));
		}
		else if(action.equals("remove")) {
			cart.removeItem(new OrderLine(item, 0));
		}
		
		session.setAttribute("cart", cart);
		
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
