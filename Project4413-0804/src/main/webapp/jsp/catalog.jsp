<%@ page import="java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TechTronix</title>
<!-- Header for Catalog Page -->

<link rel="stylesheet" href="./css/style.css" type="text/css" />
<jsp:include page="header.jsp" flush="true" />



<!-- End of Header -->
</head>
<body style="background-color: darkgrey;">

	<div class="container-fluid mt-4">
		<div class="row">
			<!-- Sort/Filter Section -->

			<div class="col-lg-2">
				<div class="list-group">
					<h5 class="list-group-item">Sort</h5>

					<a class="list-group-item list-group-item-action sort-btn"
						href="./${initParam.param1}?action=sortL_H"> <span
						class="label">Sort by Price (Low
							to High)</span>
					</a> <a class="list-group-item list-group-item-action sort-btn"
						href="./${initParam.param1}?action=sortH_L"> <span
						class="label">Sort by Price
							(High to Low)</span>
					</a> <a class="list-group-item list-group-item-action sort-btn"
						href="./${initParam.param1}?action=sortName"> <span
						class="label">Sort by Name</span>
					</a>

					<h5 class="list-group-item">Filter by Category</h5>

					<c:forEach items="${categoryList}" var='item'>


						<a class="list-group-item list-group-item-action filter-btn"
							href="./${initParam.param1}?action=category&category=${item}">
							${item} </a>
					</c:forEach>

					<h5 class="list-group-item">Filter by Brand</h5>

					<c:forEach items="${brandList}" var='item'>
						<a class="list-group-item list-group-item-action filter-btn"
							href="./${initParam.param1}?action=brand&brand=${item}">
							${item} </a>
					</c:forEach>

				</div>

				<a
					class="list-group-item list-group-item-action filter-btn text-danger"
					href="./${initParam.param1}?action=allproducts"> Clear Filters
				</a>
			</div>


			<!-- End of Sort/Filter Section -->


			<!-- Product Section -->


			<div class="col-lg-9">
				<div id="products-container" class="container mt-4">
					<div class="row">
						<c:forEach items="${productList}" var='item'>
							<div class="col-md-4 mb-5">
								<%-- <div class="card product-card" data-price=" ${item.price}"
									data-category=" ${item.category}" data-brand="${item.brand}">

									<img src="${item.image}" class="card-img-top"
										alt="${item.name} ">
									<div class="card-body">
										<h5 class="card-title">${item.name}</h5>
										<p class="card-text">${item.price}</p>

										<div class="product-description">${item.description}</div>
										<button class="btn btn-primary view-details-btn">View
											Details</button>
										<button class="btn btn-primary add-to-cart-btn"
											onclick="addToCart(this)" data-name="${item.name}"
											data-price="${item.price}" data-quantity="1">Add to
											Cart</button>
									</div>
								</div> --%>
								<div class="flip-card" data-price=" ${item.price}"
									data-category=" ${item.category}" data-brand="${item.brand}">
									<div class="flip-card-inner">
										<div class="flip-card-front">
											<img src="./images/${item.image}" alt="${item.name}"
												style="width: 200px; height: 200px; margin-top: 8%; margin-bottom: 2%">
											<h5 class="card-title">${item.name}</h5>
											<p class="card-text">${item.price}</p>
										</div>
										<div class="flip-card-back">
											<p class="item-description">${item.description}</p>
											<button class="btn btn-primary add-to-cart-btn"
												onclick="addToCart(this)" data-name="${item.name}"
												data-price="${item.price}" data-quantity="1">Add to
												Cart</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
			<!-- END ofProduct Section -->
		</div>
	</div>

</body>
</html>


