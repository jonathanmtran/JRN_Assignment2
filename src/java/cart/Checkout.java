package cart;

import business.Billing;
import business.Cart;
import business.Order;
import business.OrderLine;
import business.Shipping;
import data.BillingDB;
import data.OrderDB;
import data.OrderLineDB;
import data.ShippingDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Checkout extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		String url = null;
		
		if(action == null) {
			url = "/cart";
		}
		else if(action.equals("shipping")) {
			String name = request.getParameter("name");
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			
			if(name != null && street != null && city != null && 
				state != null && zip != null) {
				Shipping shipping = new Shipping();
				shipping.setName(name);
				shipping.setStreet(street);
				shipping.setCity(city);
				shipping.setState(state);
				shipping.setZip(zip);
				
				session.setAttribute("shipping", shipping);
				
				url = "/checkout/billing.jsp";
			}
			else
				url = "/checkout/shipping.jsp";
		}
		else if(action.equals("billing")) {
			String email = request.getParameter("email");
			String cardHolderName = request.getParameter("cardHolderName");
			String cardNumber = request.getParameter("cardNumber");
			String expirationM = request.getParameter("expirationMonth");
			String expirationY = request.getParameter("expirationYear");
			String secureCode = request.getParameter("secureCode");
			
			if(email != null && cardHolderName != null && cardNumber != null &&
				expirationM != null && expirationY != null && 
				secureCode != null) {
				Billing billing = new Billing(email, cardHolderName, cardNumber,
					expirationM, expirationY, secureCode);
				
				session.setAttribute("billing", billing);
				
				url = "/checkout/review.jsp";
			}
			else
				url = "/checkout/billing.jsp";
		}
		else if(action.equals("review")) {
			String finish = request.getParameter("finish");
			
			if(finish != null) {
				// Save order
				Cart cart = (Cart)session.getAttribute("cart");
				
				Order order = new Order();
				order.setTotal(cart.getTotal());
				
				int orderId = OrderDB.insert(order);
				order = OrderDB.fetch(orderId);
				
				// Save billing to database
				Billing billing = (Billing)session.getAttribute("billing");
				billing.setOrderId(orderId);
				BillingDB.insert(billing);
				
				// Save shipping to database
				Shipping shipping = (Shipping)session.getAttribute("shipping");
				shipping.setOrderId(orderId);
				ShippingDB.insert(shipping);
				
				// Save orderlines to database
				for(OrderLine line : cart.getItems()) {
					line.setOrderId(orderId);
					
					OrderLineDB.insert(line);
				}
				
				// TODO: Email user about order and shipping information
				
				request.setAttribute("order", order);
				url = "/checkout/finish.jsp";
			}
			else
				url = "/checkout/review.jsp";
		}
		
		if(url != null) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}