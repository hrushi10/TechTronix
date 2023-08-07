function sortProducts(order) {
    var productsContainer = document.getElementById('products-container');
    var rows = Array.from(productsContainer.getElementsByClassName('row'));
    var products = [];

    rows.forEach(row => {
        var rowProducts = Array.from(row.getElementsByClassName('col-md-3 mb-4'));
        products.push(...rowProducts);
    });

    // Sort products by data-price attribute or name
    products.sort(function(a, b) {
        if (order === 'asc' || order === 'desc') {
            var priceA = parseFloat(a.querySelector('.product-card').getAttribute('data-price'));
            var priceB = parseFloat(b.querySelector('.product-card').getAttribute('data-price'));
            return order === 'asc' ? priceA - priceB : priceB - priceA;
        } else if (order === 'name') {
            var nameA = a.querySelector('.card-title').innerText.trim();
            var nameB = b.querySelector('.card-title').innerText.trim();
            return nameA.localeCompare(nameB); // Sort by name
        }
    });

    // Clear the container and append sorted products
    productsContainer.innerHTML = '';
    var newRow = document.createElement('div');
    newRow.className = 'row';
    products.forEach(function(product, index) {
        newRow.appendChild(product);
        if ((index + 1) % 4 === 0) {
            productsContainer.appendChild(newRow);
            newRow = document.createElement('div');
            newRow.className = 'row';
        }
    });
    productsContainer.appendChild(newRow); // Append any remaining products
}
