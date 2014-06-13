<%@page import="business.Item,java.util.ArrayList"%>
<jsp:include page="inc/header.jsp" />

<table class="table"> 
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
					<input type="submit" value="Add to Cart" class="btn btn-default btn-sm" />
				</form>
			</span>
		</td>
	</tr>
<% } %>
</table>

<ul class="pagination pull-right">
<% 
	for(int i = 0; i < (int)request.getAttribute("pages"); i++) { 
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

<jsp:include page="inc/footer.jsp" />
