<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thank You</title>
 <jsp:include page="header.jsp" flush="true" />
    
<style>
body {
	background-color: darkgrey;
	font-family: Arial, sans-serif;
	text-align: center;
	
}

.thank-you-message {
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
	max-width: 500px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div class="container my-5">
		<h1 class="text-center mb-4">Thank You!</h1>
		<p>
			Thank you,
			<%=request.getSession().getAttribute("user")%>, for your order!
		</p>
		<p>Your order has been processed successfully. We'll send you an
			email with your order details shortly.</p>
	</div>
	
	<a href="./${initParam.param1}" class="btn btn-warning">Continue Shopping</a>
	
	<a href="./${initParam.param1}?action=logout" class="btn btn-danger">Log out</a>
<!-- 
	<div class="thank-you-message">
		<h1>Thank You!</h1>
		<p>Your purchase is complete. We appreciate your business.</p>
		<p>For any inquiries, please contact our customer support.</p>
	</div> -->

</body>
</html>
