<%@ page import="java.sql.*" %>

<%
ResultSet rs = null; 
Connection con = null;
Statement stmt = null;
ResultSet rsCategory = null;
ResultSet rsBrand = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://eecs4413.ceik1relpviq.us-east-2.rds.amazonaws.com:3306/project4413", "admin", "mysql4413");

    stmt = con.createStatement();
    rsCategory = stmt.executeQuery("SELECT DISTINCT category FROM products");

    Statement stmtBrand = con.createStatement();
    rsBrand = stmtBrand.executeQuery("SELECT DISTINCT brand FROM products");

    Statement stmtProducts = con.createStatement();
    rs = stmtProducts.executeQuery("SELECT id, name, price, image, description, category, brand FROM products");
    
    // further processing
} catch (ClassNotFoundException e) {
    // Handle the error related to Class not found
    out.print("Driver not found: " + e.getMessage());
} catch (SQLException e) {
    // Handle errors related to SQL
    out.print("SQL Exception: " + e.getMessage());
}
%>



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
        <button class="list-group-item list-group-item-action sort-btn" onclick="sortProducts('asc')">Sort by Price (Low to High)</button>
        <button class="list-group-item list-group-item-action sort-btn" onclick="sortProducts('desc')">Sort by Price (High to Low)</button>
        <button class="list-group-item list-group-item-action sort-btn" onclick="sortProducts('name')">Sort by Name</button>
        <h5 class="list-group-item bg-light">Filter by Category </h5>
        
        
        <%
           while (rsCategory.next()) {
        %>
          <button class="list-group-item list-group-item-action filter-btn" onclick="filterProducts('category', '<%= rsCategory.getString("category") %>')"><%= rsCategory.getString("category") %></button>
          
        <% } %>
        <h5 class="list-group-item bg-light">Filter by Brand</h5>
        <%
          while (rsBrand.next()) {
        %>
        <button class="list-group-item list-group-item-action filter-btn" onclick="filterProducts('brand', '<%= rsBrand.getString("brand") %>')"><%= rsBrand.getString("brand") %></button>
        
        <% } %>
    </div>
    <button class="list-group-item list-group-item-action filter-btn text-danger" onclick="clearFilters()">Clear Filters</button>
    
</div>


															<!-- End of Sort/Filter Section -->
 



																<!-- Product Section --> 

  
<div class="col-lg-9">

<div id="products-container" class="container mt-4">
    <div class="row">
        <% while (rs.next()) { %>
            <div class="col-md-3 mb-4">
            <div class="card product-card" data-price="<%= rs.getString("price") %>" data-category="<%= rs.getString("category") %>" data-brand="<%= rs.getString("brand") %>">
		
                    <img src="<%= rs.getString("image") %>" class="card-img-top" alt="<%= rs.getString("name") %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= rs.getString("name") %></h5>
                        <p class="card-text">$<%= rs.getString("price") %></p>
                        <div class="product-description">
                            <%= rs.getString("description") %>
                        </div>
<button class="btn btn-primary add-to-cart-btn" onclick="addToCart(this)" data-name="<%= rs.getString("name") %>" data-price="<%= rs.getFloat("price") %>" data-quantity="1">Add to Cart</button>
                     </div>
                </div>
               
            </div>
            <% if ((rs.getRow()) % 4 == 0 && !rs.isLast()) { %>
                </div>
                <div class="row">
            <% } %>
        <% } %>
    </div>
    </div>

</div>

<%
rs.close();
stmt.close();
rsCategory.close();
rsBrand.close();
con.close();
   
%>
									<!-- END ofProduct Section -->   



  </div>
</div>
   

   
</body>
</html>


