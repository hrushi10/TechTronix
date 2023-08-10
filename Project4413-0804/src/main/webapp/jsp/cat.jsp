<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>TechTronix</title>
  <jsp:include page="header.jsp" flush="true" />
  										
</head>
<body>

<div class="container-fluid mt-4">
  <div class="row">
  <div class="col-lg-2">
  <div class="list-group">
        <h5 class="list-group-item bg-light">Sort</h5>
       
        <a class="list-group-item list-group-item-action sort-btn" href="../${initParam.param1}?action=sortL_H"> <span class="label"
					style="margin-left: 15px;">Sort by Price (Low to High)</span>
				</a>
				<a class="list-group-item list-group-item-action sort-btn" href="../${initParam.param1}?action=sortH_L"> <span class="label"
					style="margin-left: 15px;">Sort by Price (High to Low)</span>
				</a>
				
		<a class="list-group-item list-group-item-action sort-btn" href="../${initParam.param1}?action=sortName"> <span class="label"
					style="margin-left: 15px;">Sort by Name</span>
				</a>		
				
        <h5 class="list-group-item bg-light">Filter by Category </h5>
        
</div>
</div>
</div>
</div>

<div class="col-lg-9">

<div id="products-container" class="container mt-4">
    <div class="row">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   	 <c:forEach items="${productList}" var='item'>
   
        	<div class="col-md-3 mb-4">
            <div class="card product-card" data-price=" ${item.price}" data-category=" ${item.category}" data-brand="${item.brand}">
		  
		
                    <div class="card-body">
                    	    <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.price}</p>
                        
                        <div class="product-description">
                            ${item.description}
                        </div>
<button class="btn btn-primary add-to-cart-btn" onclick="addToCart(this)" data-name="${item.price}" data-price="${item.price} data-quantity="1">Add to Cart</button>
                     </div>
                </div>
             </div>
             
	 
	 </c:forEach> 
	 
	  </div>
    </div>

</div>

</body>
</html>