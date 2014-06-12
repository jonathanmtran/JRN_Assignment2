<%@page import="business.Order,business.Shipping"%>
<jsp:include page="../inc/header.jsp" />
<%
	Order o = (Order)request.getAttribute("order");
	Shipping s = (Shipping)request.getAttribute("shipping");
%>

<h1>We appreciate your business. Your order has been placed.</h1>

<p>
	Thank you, <%= s.getName() %>,  your order number is <%= o.getOrderId() %> and the total 
	amount is <%= o.getTotalCurrencyFormat() %>. An email for this order is sent to you.
</p>

<jsp:include page="../inc/footer.jsp" />
