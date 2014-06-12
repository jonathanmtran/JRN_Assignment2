<%@page import="business.Billing"%>
<%@page import="business.Shipping"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Let's Review Your Order</title>
        <%
            Shipping shipping = (Shipping)session.getAttribute("shipping");
            Billing billing = (Billing)session.getAttribute("billing");
        %>
    </head>
    <body>
        <form action="<%= response.encodeURL("checkout")%>" method="post">
        <br />
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
        <input type="hidden" name="action" value="review" />
	<input type="submit" name="finish" value="Finish" />
        </form>
        
    </body>
</html>
