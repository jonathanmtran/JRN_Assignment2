<%@ page import="business.*, java.util.ArrayList" %>
<jsp:include page="inc/header.jsp" />

<h1>Your cart</h1>
<table class="table">
  <tr>
    <th>Quantity</th>
    <th>Name</th>
    <th>Image</th>
    <th>Price</th>
    <th>Amount</th>
	<th></th>
  </tr>
<% 
   Cart cart = (Cart)session.getAttribute("cart"); 
   ArrayList<OrderLine> items = cart.getItems();
   
   for (OrderLine item : items) {
       Item i = item.getItem();
%>

  <tr valign="top">
    <td>
      <form action="<%=response.encodeURL("cart?action=update")%>" method="post">
			<input type="hidden" name="cellPhoneCode" value="<%= i.getItemID() %>">
			<input type=text size=2 name="quantity" value="<%= item.getQuantity() %>">
			<input type="submit" value="Update" class="btn btn-default btn-sm">
      </form>
    </td>
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
    <td>
      <form action="<%= response.encodeURL("cart?action=remove")%>" method="post">
        <input type="hidden" name="cellPhoneCode" value="<%= i.getItemID() %>" />
        <input type="submit" value="Remove" class="btn btn-default btn-sm" />
      </form>
    </td>
  </tr>
<% } %>

  <tr>
    <td colspan="3">
      <p><b>To change the quantity</b>, enter the new quantity 
            and click on the Update button.</p>
    </td>
  </tr>
</table>

<br>

<a href="<%= request.getContextPath() %>" class="btn btn-default">Continue Shopping</a>

<% if(cart.getCount() > 0) { %>
<a href="<%= response.encodeURL("checkout") %>" class="btn btn-default pull-right">Checkout</a>
<% } %>

<jsp:include page="inc/footer.jsp" />
