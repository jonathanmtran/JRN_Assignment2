<form action="<%= response.encodeURL("checkout")%>" method="post">
	<input type="hidden" name="action" value="billing" />
	
	<label>Email Address</label><input type="email" name="email" /><br />
	
	<label>Card Holder Name</label><input type="text" name="cardHolderName" /><br />
	
	<label>Card Number</label><input type="text" name="cardNumber" /><br />
	
	<label>Expiration Month</label><input type="number" name="expirationMonth" size="2" />
	<label>Expiration Year</label><input type="number" name="expirationYear" size="4" /><br />
	
	<label>Secure Code</label><input type="number" name="secureCode" size="3" /><br />
	
	<input type="submit" value="Review Order" />
</form>