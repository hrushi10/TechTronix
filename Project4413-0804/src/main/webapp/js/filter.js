var allProducts;

window.onload = function() {
  var productsContainer = document.getElementById('products-container');
  var rows = Array.from(productsContainer.getElementsByClassName('row'));
  allProducts = [];

  rows.forEach(row => {
    var rowProducts = Array.from(row.getElementsByClassName('col-md-3 mb-4'));
    allProducts.push(...rowProducts);
  });
};



function filterProducts(type, value) {
  var productsContainer = document.getElementById('products-container');

  // Filter allProducts by the selected type and value
  var filteredProducts = allProducts.filter(product => {
    var productValue = product.querySelector('.product-card').getAttribute('data-' + type);
    return value === '' || productValue === value;
  });

  // Clear the container and append filtered products
  productsContainer.innerHTML = '';
  var newRow = document.createElement('div');
  newRow.className = 'row';
  filteredProducts.forEach(function(product, index) {
    newRow.appendChild(product);
    if ((index + 1) % 4 === 0) {
        productsContainer.appendChild(newRow);
        newRow = document.createElement('div');
        newRow.className = 'row';
    }
  });
  productsContainer.appendChild(newRow); // Append any remaining products
}


function clearFilters() {
  var productsContainer = document.getElementById('products-container');
  productsContainer.innerHTML = ''; // Clear the container
  var newRow = document.createElement('div');
  newRow.className = 'row';
  allProducts.forEach(function(product, index) {
    newRow.appendChild(product);
    if ((index + 1) % 4 === 0) {
      productsContainer.appendChild(newRow);
      newRow = document.createElement('div');
      newRow.className = 'row';
    }
  });
  productsContainer.appendChild(newRow); // Append any remaining products
}
