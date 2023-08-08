<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thank You</title>
</head>
<body>

<div class="container my-5">
    <h1 class="text-center mb-4">Thank You!</h1>
    <p>Thank you, <%= request.getParameter("name") %>, for your order!</p>
    <p>Your order has been processed successfully. We'll send you an email with your order details shortly.</p>
</div>

</body>
</html>
