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
			Cart cart = (Cart)session.getAttribute("cart");
			Shipping shipping = (Shipping)session.getAttribute("shipping");
			Billing billing = (Billing)session.getAttribute("billing");
			
			if(cart == null || cart.getCount() == 0) {
				url = response.encodeURL("cart");
				response.sendRedirect(url);
				return;
			}
			else if(shipping == null)
				url = "/checkout/shipping.jsp";
			else if(billing == null)
				url = "/checkout/shipping.jsp";
			else
				url = "/checkout/review.jsp";
		}
		else if(action.equals("shipping")) {
			String name = request.getParameter("name");
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			
			// Check to see if these variables actually exist
			if(name != null && street != null && city != null && 
				state != null && zip != null) {
				// Check length of strings
				if(name.length() != 0 && street.length() != 0 && city.length() != 0 &&
					state.length() != 0 && zip.length() != 0 ) {
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
			
			// Check to see if these variables actually exist
			if(email != null && cardHolderName != null && cardNumber != null &&
				expirationM != null && expirationY != null && 
				secureCode != null) {
				// Check length of strings
				if(email.length() != 0 && cardHolderName.length() != 0 && cardNumber.length() != 0 &&
					expirationM.length() != 0 && expirationY.length() != 0 && 
					secureCode.length() != 0) {
				Billing billing = new Billing(email, cardHolderName, cardNumber,
					expirationM, expirationY, secureCode);
				
				session.setAttribute("billing", billing);
				
				url = "/checkout/review.jsp";
				}
				else
					url = "/checkout/billing.jsp";
			}
			else {
				request.setAttribute("title", "Let's Review Your Order");
				url = "/checkout/billing.jsp";
			}
		}
		else if(action.equals("review")) {
			String finish = request.getParameter("finish");
			
			if(finish != null) {
				// Save order
				Cart cart = (Cart)session.getAttribute("cart");
				
				Order order = new Order();
				order.setTotal(cart.getTotal());
				
				order = OrderDB.insert(order);
				
				// Save billing to database
				Billing billing = (Billing)session.getAttribute("billing");
				billing.setOrderId(order.getOrderId());
				billing = BillingDB.insert(billing);
				
				// Save shipping to database
				Shipping shipping = (Shipping)session.getAttribute("shipping");
				shipping.setOrderId(order.getOrderId());
				shipping = ShippingDB.insert(shipping);
				
				// Save orderlines to database
				for(OrderLine line : cart.getItems()) {
					line.setOrderId(order.getOrderId());
					
					line = OrderLineDB.insert(line);
				}

				// Email user about order and shipping information
				String content = String.format("%s,  Your order has been placed. "
						+"your order number is %d and the total amount is %s." 
						+"<br />We appreciate your business.",
						shipping.getName(),order.getOrderId(),order.getTotalCurrencyFormat());
				String email = billing.getEmail();
				EmailGmail gmail = new EmailGmail();
				gmail.sendIt(email,content);
				
				request.setAttribute("shipping", shipping);
				request.setAttribute("order", order);
				
				session.removeAttribute("cart");
				session.removeAttribute("billing");
				session.removeAttribute("shipping");
				session.removeAttribute("order");
				
				request.setAttribute("title", "Thank you for your order");
				
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
