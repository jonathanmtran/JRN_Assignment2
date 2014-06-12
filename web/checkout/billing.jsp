<jsp:include page="../inc/header.jsp" />
<h1>Billing Information</h1>

<p>Enter the billing information</p>

<form action="<%= response.encodeURL("checkout")%>" method="post" class="form-horizontal">
	<input type="hidden" name="action" value="billing" />
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Email Address</label>
		<div class="col-sm-10">
			<input type="email" name="email" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Card Holder Name</label>
		<div class="col-sm-10">
			<input type="text" name="cardHolderName" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Card Number</label>
		<div class="col-sm-10">
			<input type="text" name="cardNumber" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Expiration Month</label>
		<div class="col-sm-1">
			<input type="text" name="expirationMonth" size="2" class="form-control" />
		</div>
	</div>
		
	<div class="form-group">
		<label class="col-sm-2 control-label">Expiration Year</label>
		<div class="col-sm-1">
			<input type="text" name="expirationYear" size="4" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Secure Code</label>
		<div class="col-sm-1">
			<input type="text" name="secureCode" size="3" class="form-control" />
		</div>
	</div>
	
	<input type="submit" value="Review Order" class="btn btn-primary pull-right" />
</form>
	
<jsp:include page="../inc/footer.jsp" />
