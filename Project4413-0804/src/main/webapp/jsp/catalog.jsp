<%@ page import="java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.Product" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechTronix</title>
  													<!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />


														<!-- End of Header -->   
</head>
<body>

<div class="container-fluid mt-4">
  <div class="row">
															<!-- Sort/Filter Section -->
													
<div class="col-lg-2">
    <div class="list-group">
        <h5 class="list-group-item bg-light">Sort</h5>
   
        <a class="list-group-item list-group-item-action sort-btn" href="./${initParam.param1}?action=sortL_H"> <span class="label"
					style="margin-left: 15px;">Sort by Price (Low to High)</span>
				</a>
				
		<a class="list-group-item list-group-item-action sort-btn" href="./${initParam.param1}?action=sortH_L"> <span class="label"
					style="margin-left: 15px;">Sort by Price (High to Low)</span>
				</a>
				
		<a class="list-group-item list-group-item-action sort-btn" href="./${initParam.param1}?action=sortName"> <span class="label"
					style="margin-left: 15px;">Sort by Name</span>
				</a>		
				
        <h5 class="list-group-item bg-light">Filter by Category </h5>
        
        <c:forEach items="${categoryList}" var='item'>
        
                  
        <a class="list-group-item list-group-item-action filter-btn" href="./${initParam.param1}?action=category&category=${item}"> ${item}
		</a>	
        </c:forEach>
       
        <h5 class="list-group-item bg-light">Filter by Brand</h5>
       
          <c:forEach items="${brandList}" var='item'>
 			<a class="list-group-item list-group-item-action filter-btn" href="./${initParam.param1}?action=brand&brand=${item}"> ${item}
			</a>        
			</c:forEach>
      
    </div>
    
     <a class="list-group-item list-group-item-action filter-btn text-danger" href="./${initParam.param1}?action=allproducts"> Clear Filters
			</a> 
</div>


															<!-- End of Sort/Filter Section -->
 
 
 															<!-- Product Section --> 

  
<div class="col-lg-9">

<div id="products-container" class="container mt-4">
    <div class="row">
    <% List<Product> cartItems = new ArrayList<Product>(); %>
             
	 <c:forEach items="${productList}" var='item'>
	    
            <div class="col-md-3 mb-4">
            <div class="card product-card" data-price=" ${item.price}" data-category=" ${item.category}" data-brand="${item.brand}">
		  
		<img src="${item.image}" class="card-img-top" alt="${item.name} ">
                    <div class="card-body">
                    	    <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.price}</p>
                        
                        <div class="product-description">
                            ${item.description}
                        </div>
<button class="btn btn-primary add-to-cart-btn" onclick="addToCart(${item})" data-name="${item.price}" data-price="${item.price} data-quantity="1">Add to Cart</button>
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


