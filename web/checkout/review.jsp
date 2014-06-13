<%@page import="business.Billing,business.Cart,business.Shipping,business.OrderLine,business.Item,java.util.ArrayList"%>
<jsp:include page="../inc/header.jsp" />
<%
	Shipping shipping = (Shipping)session.getAttribute("shipping");
	Billing billing = (Billing)session.getAttribute("billing");
%>
<h1>Your Order</h1>
<table class="table">
  <tr>
    <th>Name</th>
    <th>Image</th>
    <th>Price</th>
    <th>Amount</th>
  </tr>
<% 
   Cart cart = (Cart)session.getAttribute("cart"); 
   ArrayList<OrderLine> items = cart.getItems();
   
   for (OrderLine item : items) {
       Item i = item.getItem();
%>

  <tr valign="top">
    <td>
      <%=i.getName()%>
    </td>
    <td>
        <img src="photos/<%=i.getImageLoc()%>" />
    </td>
    <td>
      <%=i.getPriceCurrencyFormat()%>
    </td>
    <td>
      <%=item.getTotalCurrencyFormat()%>
    </td>
  </tr>
<% } %>
</table>

<form action="<%= response.encodeURL("checkout")%>" method="post">
	<input type="hidden" name="action" value="review" />

	<h2>Shipping Information</h2>
	<p>Name : <%= shipping.getName() %> </p>
	<p>Street : <%= shipping.getStreet() %></p>
	<p>City : <%= shipping.getCity()%></p>
	<p>State : <%= shipping.getState() %></p>
	<p>Zip : <%= shipping.getZip() %></p>
	<br />

	<h2>Billing Information</h2>
	<p>Card Holder's Name : <%= billing.getCardHolderName() %></p>
	<p>Card Number : <%= billing.getCardNumber() %></p>
	<p>Email : <%= billing.getEmail() %></p>
	<p>Expiration Month : <%= billing.getExpirationMonth() %></p>
	<p>Expiration Year : <%= billing.getExpirationYear() %></p>
	<p>Card Security Code : <%= billing.getSecureCode() %></p>
	<br />
	
	<input type="submit" name="finish" value="Finish" class="btn btn-primary  pull-right" />
</form>

<jsp:include page="../inc/footer.jsp" />
