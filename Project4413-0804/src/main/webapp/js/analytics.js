// Fetch total sales, total orders, and total items sold
fetch('/Project4413/FetchAnalyticsServlet?type=summary')
    .then(response => response.json())
    .then(data => {
        document.getElementById('totalSales').innerText = `$${data.totalSales}`;
        document.getElementById('totalOrders').innerText = data.totalOrders;
        document.getElementById('totalItemsSold').innerText = data.totalItemsSold;
    });

// Fetch recent orders
fetch('/Project4413/FetchAnalyticsServlet?type=recentOrders')
    .then(response => response.json())
    .then(data => {
        const recentOrdersElem = document.getElementById('recentOrders');
        recentOrdersElem.innerHTML = ''; // Clear existing orders
        
        data.orders.forEach(order => {
            const li = document.createElement('li');
            li.innerText = `Order #${order.id} by ${order.customerName} - $${order.total}`;
            recentOrdersElem.appendChild(li);
        });
    })
    .catch(error => {
        console.log("Error fetching recent orders:", error);
    });


// Fetch top selling products and display as a bar chart
fetch('/Project4413/FetchAnalyticsServlet?type=topSellingProducts')
    .then(response => response.json())
    .then(data => {
        const ctx = document.getElementById('topProductsChart').getContext('2d');
        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: data.products,  // ['Product1', 'Product2', ...]
                datasets: [{
                    label: 'Top Selling Products',
                    data: data.quantities,  // [5, 3, ...]
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            }
        });
    });
    
      
      
      
    const checkboxes = document.getElementById("xxx");
    const detailsTable = document.getElementById("orderDetails");

    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener("change", function() {
            if (checkbox.checked) {
				console.log("this is working fine");
                const selectedId = checkbox.value;
                // Fetch details based on the selectedId
                // You can use AJAX here to fetch data from the server
                const details = getDetailsFromServer(selectedId); // Replace with your implementation
                
                // Add details row to the details table
                const newRow = detailsTable.insertRow();
                const idCell = newRow.insertCell(0);
                const detailsCell = newRow.insertCell(1);
                idCell.textContent = selectedId;
                detailsCell.textContent = details;
            } else {
                // Remove details row if checkbox is unchecked
                // Implementation depends on your needs
            }
        });
    });
    
  
  
 
function clickme(){
	const loadButton = document.getElementById("detailBtn");
    const orderTableBody = document.querySelector("#orderTable tbody");


	const ordId = loadButton.value;
        const url = '/AdminViewController?ordId=${ordId}';
        
        console.log("button id = "+ordId);
        
        fetch(url)
            .then(response => response.json())
            .then(data => {
                populateTable(data);
            })
            .catch(error => {
                console.error("Error fetching order details:", error);
            });
            
               function populateTable(data) {
        orderTableBody.innerHTML = ""; // Clear previous data

        data.forEach(order => {
            const row = orderTableBody.insertRow();
            const productNameCell = row.insertCell(0);
            const quantityCell = row.insertCell(1);

            productNameCell.textContent = order.productName;
            quantityCell.textContent = order.quantity;
            // Add more cells as needed
        });
    }
    
}
