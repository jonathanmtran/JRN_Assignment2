<%@page import="java.util.ArrayList,business.Item,data.ItemDB"%>
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
<% for(Item item : (ArrayList<Item>)request.getAttribute("items")) { %>
	<tr>
		<td><%= item.getName() %></td>
		<td><img src="photos/<%= item.getImageLoc() %>" /></td>
		<td><%= item.getDescription() %></td>
		<td><%= item.getSpecs() %></td>
		<td><%= item.getPriceCurrencyFormat() %></td>
		<td>
			<span style="text-align: center">
				<form action="<%= response.encodeURL("cart") %>" method="post">
					<input type="hidden" name="action" value="add" />
					<input type="hidden" name="cellPhoneCode" value="<%= item.getItemID() %>" />
					<input type="text" size="2" name="quantity" value="1" />
					<input type="submit" value="Add to Cart" />
				</form>
			</span>
		</td>
	</tr>
<% } %>
</table>

<ul class="pagination">
<% 
	for(int i = 0; i <= (int)request.getAttribute("pages"); i++) { 
		int pageNum = i + 1;
%>
	
<%		if(pageNum != (int)request.getAttribute("page")) { %>
	<li><a href="<%= response.encodeURL("?page=" + pageNum) %>"><%= pageNum %></a></li>
<%		
		}
		else {	
%>
	<li class="active"><span><%= pageNum %> <span class="sr-only">(current)</span></span></li>
<%
		}
	} 
%>
</ul>

</body>
</html>