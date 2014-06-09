<form action="<%= response.encodeURL("checkout")%>" method="post">
	<input type="hidden" name="action" value="shipping" />
	<label>Name</label><input type="text" name="name" /><br />
	
	<label>Street</label><input type="text" name="street" /><br />
	
	<label>City</label><input type="text" name="city" /><br />
	
	<label>State</label><input type="text" name="state" size="2" /><br />
	
	<label>Zip</label><input type="text" name="zip" size="5" /><br />
	
	<input type="submit" value="Go to Billing" />
</form>