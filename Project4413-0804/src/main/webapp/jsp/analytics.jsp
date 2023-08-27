<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
     <script type="text/javascript" src='./js/admin.js'></script>
</head>

<body style="background-color: darkgrey;">
    <div class="container my-5">
        <h1 class="text-center mb-4">Admin Analytics Dashboard</h1>

      <h1>Sales Report</h1>
		<table>
			<tr>
				<th>Total Sales</th>
				<th>Total Orders</th>
				<th>Total Items Sold</th>
			</tr>
			<tr>
				<td>$<%=request.getAttribute("totalSales")%></td>
				<td><%=request.getAttribute("totalOrders")%></td>
				<td><%=request.getAttribute("totalItemsSold")%></td>
			</tr>
		</table>

        <div class="row mt-5">
            <div class="col-md-6">
                <h4>Order History</h4>
                
                <table class="table table-striped" id="orderHistory">
            <thead>
                <tr>
                	<th>Order Details</th>
                    <th>Order Id</th>
                    <th>User</th>
                    <th>Address Id</th>
                    <th>Pay Id</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody id='orderTable'>
                <!-- Items will be inserted here by the JavaScript -->
                  
                
                <c:forEach items = "${orderList}" var = 'item'>
                <tr>
                <td> <button class="btn detailBtn" style="background-color: orange; color: white;" onclick="clickme(${item.id})">Details</button></td>
                <td>${item.id}</td>
                <td>${item.user}</td>
                <td>${item.addressId}</td>
                <td>${item.payId}</td>
                <td>${item.date}</td>
                </tr> 
               </c:forEach>
               
            </tbody>
        </table>
                
            </div>
            <div class="col-md-6">
                <h4>Order Details</h4>
                    <table class="table table-striped" id="orderDetails">
            <thead>
                <tr>
                    <th>Order Id</th>
                    <th>Item List</th>
                    <th>Quantity</th>
                    <th>Price List</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <!-- Items will be inserted here by the JavaScript -->
            </tbody>
        </table>
            </div>
        </div>
    </div>

    <script src="../js/analytics.js"></script>
</body>

</html>
