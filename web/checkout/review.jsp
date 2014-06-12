<%@page import="business.Billing,business.Shipping"%>
<jsp:include page="../inc/header.jsp" />
<%
	Shipping shipping = (Shipping)session.getAttribute("shipping");
	Billing billing = (Billing)session.getAttribute("billing");
%>
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
