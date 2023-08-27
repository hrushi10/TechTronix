<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout</title>

<!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />
<!-- End of Header -->
<script type="text/javascript" src="./js/submitOrder.js"></script>
</head>
<body style="background-color: darkgrey;">
	<form onsubmit="submitOrder(event)" action="ProcessCheckout"
		method="post">
		<div class="container my-5">
			<div class="row">

				<!-- Checkout Form - Left side -->
				<div>
					<h1 class="text-center mb-4">Checkout</h1>
					<div class="shippingInformation" style="float: left; width: 30%; padding:30px;">
						<h3>Shipping Information</h3>

						<div class="form-group">
							<label for="fName">First Name</label> <input type="text"
								class="form-control" id="fName" name="fName" required>
						</div>
						<div class="form-group">
							<label for="lName">Last Name</label> <input type="text"
								class="form-control" id="lName" name="lName" required>
						</div>
						<div class="form-group">
							<label for="address">Address</label> <input type="text"
								class="form-control" id="address" name="address" required>
						</div>
						<div class="form-group">
							<label for="city">City</label> <input type="text"
								class="form-control" id="city" name="city" required>
						</div>
						<div class="form-group">
							<label for="state">Province</label> <input type="text"
								class="form-control" id="state" name="state" required>
						</div>

						<div class="form-group">
							<label for="zip">Country</label> <input type="text"
								class="form-control" id="country" name="country" required>
						</div>

						<div class="form-group">
							<label for="zip">ZIP Code</label> <input type="text"
								class="form-control" id="zip" name="zip" required>
						</div>
					</div>

					<div class="paymentInformation" style="float: left; width: 30%; padding:30px; margin-left:5%">
						<h3>Payment Information</h3>
						<div class="form-group">
							<label for="cardName">Name on Card</label> <input type="text"
								class="form-control" id="cardName" name="cardName" required>
						</div>
						<div class="form-group">
							<label for="cardNumber">Card Number</label> <input type="number"
								class="form-control" id="cardNumber" name="cardNumber" required>
						</div>
						<div class="form-group">
							<label for="expiration">Expiration Date</label> <input
								type="number" class="form-control" id="expiration"
								name="expiration" required>
						</div>
						<div class="form-group">
							<label for="cvv">CVV</label> <input type="number"
								class="form-control" id="cvv" name="cvv" required>
						</div>
					</div>
					
					<div class="orderSummaryTable" style="float: left; width: 30%; padding:30px; margin-left: 5%">
						<h3>Order Summary</h3>
						<table id="order-summary-checkout">
							<thead>
								<tr>
									<th>Product</th>
									<th>Price</th>
									<th>Qty</th>
									<th>Total</th>


								</tr>
							</thead>
							<tbody>
								<!-- Items will be inserted here by the JavaScript -->
							</tbody>
						</table>
						<br>
						<h3 class="text-right order-total" style="font-weight: bold;">
							<b> Total: $0.00</b>
						</h3>
						<a href="./${initParam.param1}?action=cart"
							class="btn btn-primary" style="float: right;">Back to
							shopping cart</a> <br> <br>
						<button type="submit" class="btn btn-success"
							style="float: right;">Complete Purchase</button>
					</div>
				</div>
				<!-- Order summary - Right side -->
			</div>
		</div>
	</form>
</body>
</html>