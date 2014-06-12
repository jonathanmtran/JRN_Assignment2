<%-- 
    Document   : finish
    Created on : Jun 3, 2014, 2:17:24 PM
    Author     : dead
--%>
<%@page import="business.Order,business.Shipping"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Thank you for your order</title>
    </head>
    <body>
<%
	Order o = (Order)request.getAttribute("order");
	Shipping s = (Shipping)request.getAttribute("shipping");
%>
		<p>
			Thanks, <%= s.getName() %>,  your order number is <%= o.getOrderId() %> and the total 
			amount is <%= o.getTotalCurrencyFormat() %>. An email for this order is sent to you
		</p>
    </body>
</html>
