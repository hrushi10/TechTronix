<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <!-- Header for Catalog Page -->
    <jsp:include page="header.jsp" flush="true" />
    <!-- End of Header -->
 
</head>
<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">Shopping Cart</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Items will be inserted here by the JavaScript -->
            </tbody>
        </table>
        <div class="text-right">
            <h3>Total: $</h3>
            <a href="./${initParam.param1}?action=checkout" class="btn btn-success">Proceed to Checkout</a>
        </div>
    </div>
</body>
</html>
