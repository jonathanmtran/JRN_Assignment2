<form action="<%= response.encodeURL("checkout")%>" method="post">
	<input type="hidden" name="action" value="review" />
	<input type="submit" name="finish" value="Finish" />
</form>