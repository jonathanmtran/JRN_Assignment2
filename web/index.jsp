<%@page import="business.Item"%>
<%@page import="business.Item"%>
<%@page import="data.ItemDB"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>

<h1>CD list</h1>

<table cellpadding="5" border=1>

  
  <tr valign="bottom">
    <td align="left"><b>Name</b></td>
    <td align="left"><b>Image</b></td>
    <td align="left"><b>Description</b></td>
    <td align="left"><b>Specs</b></td>
    <td align="left"><b>Price</b></td>
    <td align="left"></td>
  </tr> 
<%
	ArrayList<Item> items = ItemDB.fetchAll();
	for(Item item : items) {
%>
	<tr>
		<td><%= item.getName() %></td>
		<td><img src="phones/<%= item.getImageLoc() %>" /></td>
		<td><%= item.getDescription() %></td>
		<td><%= item.getSpecs() %></td>
		<td><%= item.getPriceCurrencyFormat() %></td>
		<td><a href="<%= response.encodeUrl("cart?action=add&cellPhoneCode=" + item.getItemID()) %>">Add to Cart</a></td>
	</tr>
<% } %>
</table>
</body>
</html>