
<head>
<link rel="stylesheet" href="./css/style.css" type="text/css" />
<script src="../js/sort.js"></script>
<script src="../js/filter.js"></script>
<script src="./js/cart.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<!-- Font Awesome for the cart icon -->

</head>


<!-- Header for Catalog Page -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid justify-content-center">
		<a class="navbar-brand mx-auto" href="./products"> <img
			src="./images/logo.png" alt="Logo" class="logo">
		</a>
		<div class="navbar-nav">
			<div class="dropdown">
				<button class="btn btn-outline-secondary dropdown-toggle"
					type="button" id="dropdownMenuButton" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Account</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<%
					if (null == request.getSession().getAttribute("user")) {
						// User is not logged in. 
					%>
						<a class="dropdown-item" href="./${initParam.param1}?action=login">Login/Sign Up</a> 
					<%	
					} else {
						// User IS logged in. 
					%>
						<p class="dropdown-item">
							Hello, <%= request.getSession().getAttribute("user") %>
						</p> 
						<a class="dropdown-item" href="./${initParam.param1}?action=logout">Logout</a>
					<% } %>
				</div>
			</div>
			&nbsp; <a href="./${initParam.param1}?action=cart"><button
					class="btn btn-outline-secondary cart-btn">
					<!--  href="./jsp/cart.jsp"><button class="btn btn-outline-secondary cart-btn" -->
					<i class="fas fa-shopping-cart"></i>
				</button> </a>
		</div>
	</div>
</nav>



<!-- End of Header -->
