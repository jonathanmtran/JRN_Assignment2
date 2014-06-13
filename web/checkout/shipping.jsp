<jsp:include page="../inc/header.jsp" />

<h1>Shipping Information</h1>

<p>Enter the shipping information</p>

<form action="<%= response.encodeURL("checkout")%>" method="post" class="form-horizontal">
	<input type="hidden" name="action" value="shipping" />
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<input type="text" name="name" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Street</label>
		<div class="col-sm-10">
			<input type="text" name="street" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">City</label>
		<div class="col-sm-5">
			<input type="text" name="city" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">State</label>
		<div class="col-sm-2">
			<input type="text" name="state" size="2" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Zip</label>
		<div class="col-sm-2">
			<input type="text" name="zip" size="5" class="form-control" />
		</div>
	</div>
	
	<input type="submit" value="Go to Billing" class="btn btn-primary pull-right" />
</form>
	
<jsp:include page="../inc/footer.jsp" />
