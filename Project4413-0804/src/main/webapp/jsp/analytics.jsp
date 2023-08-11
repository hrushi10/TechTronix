<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Analytics</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
    <!-- Header, like in your previous JSPs -->
    <jsp:include page="header.jsp" flush="true" />
      <script src="../js/analytics.js"></script>
</head>

<body>
    <div class="container my-5">
        <h1 class="text-center mb-4">Admin Analytics Dashboard</h1>

        <div class="row">
            <div class="col-md-4">
                <h4>Total Sales</h4>
                <p id="totalSales">$0</p>
            </div>
            <div class="col-md-4">
                <h4>Total Orders</h4>
                <p id="totalOrders">0</p>
            </div>
            <div class="col-md-4">
                <h4>Total Items Sold</h4>
                <p id="totalItemsSold">0</p>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-md-6">
                <h4>Recent Orders</h4>
                <ul id="recentOrders"></ul>
            </div>
            <div class="col-md-6">
                <h4>Top Selling Products</h4>
                <canvas id="topProductsChart"></canvas>
            </div>
        </div>
    </div>

    <script src="../js/analytics.js"></script>
</body>

</html>
