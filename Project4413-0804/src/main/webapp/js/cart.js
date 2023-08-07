function addToCart(button) {
  var name = button.getAttribute('data-name');
  var price = parseFloat(button.getAttribute('data-price'));
  var quantity = parseInt(button.getAttribute('data-quantity'));

  var cart = JSON.parse(localStorage.getItem('cart')) || [];

  // Check if the product is already in the cart
  var existingItem = cart.find(item => item.name === name);
  if (existingItem) {
    existingItem.quantity += quantity; // Increment the quantity
  } else {
    cart.push({ name: name, price: price, quantity: quantity });
  }

  localStorage.setItem('cart', JSON.stringify(cart));

  alert('Added to cart successfully!'); // Optional: Show a success message
}

 function renderCart() {
            var cart = JSON.parse(localStorage.getItem('cart')) || [];
            var tbody = document.querySelector('tbody');
            var total = 0;

            tbody.innerHTML = ''; // Clear existing cart items

            cart.forEach(function(item) {
                total += item.price * item.quantity;

                var row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.quantity}</td>
                    <td>${item.price * item.quantity}</td>
                    <td><button onclick="removeFromCart('${item.name}')" class="btn btn-danger">Remove</button></td>
                `;

                tbody.appendChild(row);
            });

            // Update the total price
            document.querySelector('.text-right h3').innerText = "Total: $" + total.toFixed(2);
        }

        function removeFromCart(productName) {
            var cart = JSON.parse(localStorage.getItem('cart')) || [];
            var newCart = cart.filter(item => item.name !== productName);

            localStorage.setItem('cart', JSON.stringify(newCart));
            renderCart(); // Update the cart display
        }

        // Call renderCart when the page loads
        document.addEventListener('DOMContentLoaded', renderCart);