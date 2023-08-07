<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


<div class="col-lg-2">
      <div class="list-group">
        <h5 class="list-group-item bg-light">Sort</h5>
        <button class="list-group-item list-group-item-action sort-btn" onclick="sortProducts('asc')">Sort Items by Price (Ascending)</button>
		<button class="list-group-item list-group-item-action sort-btn" onclick="sortProducts('desc')">Sort Items by Price(Descending)</button>
		<button class="list-group-item list-group-item-action sort-btn" onclick="sortProducts('name')">Sort Items by Name</button>
        <h5 class="list-group-item bg-light">Filter</h5>
        <button class="list-group-item list-group-item-action filter-btn" onclick="filterItems('categories')">Filter by Categories</button>
        <button class="list-group-item list-group-item-action filter-btn" onclick="filterItems('brand')">Filter by Brands</button>
      </div>
    </div>
    
    

</body>
</html>