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
