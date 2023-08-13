<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
      
  											  <!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />

														<!-- End of Header -->   
</head>
<body>

													

<div class="container my-5">
    <h1 class="text-center mb-4">Checkout</h1>
    <form action="processCheckout.jsp" method="post">
        <h3>Shipping Information</h3>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" required>
        </div>
        <div class="form-group">
            <label for="state">State</label>
            <input type="text" class="form-control" id="state" name="state" required>
        </div>
        
        <div class="form-group">
            <label for="zip">Country</label>
            <input type="text" class="form-control" id="zip" name="zip" required>
        </div>
        
        <div class="form-group">
            <label for="zip">ZIP Code</label>
            <input type="text" class="form-control" id="zip" name="zip" required>
        </div> 

        <h3>Payment Information</h3>
        <div class="form-group">
            <label for="cardName">Name on Card</label>
            <input type="text" class="form-control" id="cardName" name="cardName" required>
        </div>
        <div class="form-group">
            <label for="cardNumber">Card Number</label>
            <input type="text" class="form-control" id="cardNumber" name="cardNumber" required>
        </div>
        <div class="form-group">
            <label for="expiration">Expiration Date</label>
            <input type="text" class="form-control" id="expiration" name="expiration" required>
        </div>
        <div class="form-group">
            <label for="cvv">CVV</label>
            <input type="text" class="form-control" id="cvv" name="cvv" required>
        </div>
        
		 <input type="checkbox" id="billAddr" name="billAddr" value="billAddr" onclick="checkAddress(this)">
  		<label for="billAddr"> Billing Address same as Shipping Address</label><br><br>

			<div id="bill_Addr" >
				<h3>Billing Address</h3>
				<div class="form-group">
					<label for="address">Address</label> <input type="text"
						class="form-control" id="address" name="address" required>
				</div>
				<div class="form-group">
					<label for="city">City</label> <input type="text"
						class="form-control" id="city" name="city" required>
				</div>
				<div class="form-group">
					<label for="state">State</label> <input type="text"
						class="form-control" id="state" name="state" required>
				</div>

				<div class="form-group">
					<label for="zip">Country</label> <input type="text"
						class="form-control" id="zip" name="zip" required>
				</div>

				<div class="form-group">
					<label for="zip">ZIP Code</label> <input type="text"
						class="form-control" id="zip" name="zip" required>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Complete Purchase</button>
    </form>
</div>

<script>



</script>

</body>
</html>
