
// creating a cart object and storing items in cart for further use
// this is not funny
function addToCart(button) {
    var name = button.getAttribute('data-name');
    var price = parseFloat(button.getAttribute('data-price'));
    var quantity = parseInt(button.getAttribute('data-quantity') || 1); // set to 1 if not provided

    var cart = JSON.parse(localStorage.getItem('cart')) || [];

    var existingItem = cart.find(item => item.name === name);
    if (existingItem) {
        existingItem.quantity += quantity;
    } else {
        cart.push({ name: name, price: price, quantity: quantity });
    }

    localStorage.setItem('cart', JSON.stringify(cart));
    alert('Added to cart successfully!');
}


function updateCartItemQuantity(element, productName) {
    var newQuantity = parseInt(element.value);
    var cart = JSON.parse(localStorage.getItem('cart')) || [];
    var item = cart.find(item => item.name === productName);

    if (item) {
        item.quantity = newQuantity;
        localStorage.setItem('cart', JSON.stringify(cart));
    }

    renderCart();
}



function renderCart() {
    var cart = JSON.parse(localStorage.getItem('cart')) || [];
    var tbody = document.querySelector('#cartTable  tbody');
    var total = 0;

    tbody.innerHTML = '';
    
    

    cart.forEach(function(item) {
        total += item.price * item.quantity;

        var row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.name}</td>
            <td>$${item.price.toFixed(2)}</td>
            <td><input type="number" min="1" value="${item.quantity}" onchange="updateCartItemQuantity(this, '${item.name}')" /></td>
            <td>$${(item.price * item.quantity).toFixed(2)}</td>
            <td><button onclick="removeFromCart('${item.name}')" class="btn btn-danger">Remove</button></td>
        `;

        tbody.appendChild(row);
    });

    document.querySelector('.text-right h3').innerText = "Total: $" + total.toFixed(2);
}

function removeFromCart(productName) {
    var cart = JSON.parse(localStorage.getItem('cart')) || [];
    var newCart = cart.filter(item => item.name !== productName);

    localStorage.setItem('cart', JSON.stringify(newCart));
    renderCart();
}

function submitOrder(event) {
    // Prevent default form submission
    event.preventDefault();
    
    let errors = [];

    const cardNumber = document.getElementById('cardNumber').value;
    const expiration = document.getElementById('expiration').value;
    const cvv = document.getElementById('cvv').value;

    // Sample validation rules (You can modify/add more rules based on your requirements)
    if (!/^\d{4}\s?\d{4}\s?\d{4}\s?\d{4}$/.test(cardNumber)) {
        errors.push('Card number should be 16 digits.');
    }
    if (!/^(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})$/.test(expiration)) {
        errors.push('Expiration date should be in MM/YY format.');
    }
    if (!/^\d{3,4}$/.test(cvv)) {
        errors.push('CVV should be 3 or 4 digits.');
    }

    if (errors.length > 0) {
        alert(errors.join('\n'));
        return;
    }
    var cart = JSON.parse(localStorage.getItem('cart')) || [];
    var formData = new FormData(document.querySelector('form'));
    
    var orderData = {
        customerName: formData.get('fName')+" "+formData.get('lName'),
        address: formData.get('address'),
        city: formData.get('city'),
        state: formData.get('state'),
        country: formData.get('country'),
        zip: formData.get('zip'),
        cardName: formData.get('cardName'),
        cardNumber: formData.get('cardNumber'),
        expiration: formData.get('expiration'),
        cvv: formData.get('cvv'),
        cartItems: cart
    };
    console.log(orderData);
      console.log("this is it");
    fetch('./ProcessCheckout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(orderData)
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => Promise.reject(text));
        }
        return response.json();
    })
    .then(data => {
        // Handle the success response here
        if (data.message && data.message.includes("Order processed successfully")) {
            localStorage.removeItem('cart');  // Clear the cart after successful order processing
            window.location.href = 'thankyou.jsp?name=' + encodeURIComponent(orderData.customerName);
        } else {
            // If there's an error message from the server
            alert(data.message || 'Order processing failed. Please try again.');
        }
    })
    .catch(error => {
        alert('There was an error: ' + error);
    });
}



function renderOrderSummary() {
    var cart = JSON.parse(localStorage.getItem('cart')) || [];
    var tbody = document.querySelector('#order-summary-checkout tbody');
    var total = 0;
    
   

    tbody.innerHTML = '';

    cart.forEach(function(item) {
        total += item.price * item.quantity;

        var row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.name}</td>
            <td>$${item.price.toFixed(2)}</td>
            <td>${item.quantity}</td>
            <td>$${(item.price * item.quantity).toFixed(2)}</td>
        `;

        tbody.appendChild(row);
    });

    document.querySelector('.order-total').innerText = "Total: $" + total.toFixed(2);
}


document.addEventListener('DOMContentLoaded', function() {
	 
    if (window.location.href.includes('checkout')== true) {
		
        renderOrderSummary();
    } else {
        renderCart();
    }
});


const cartData = localStorage.getItem('cart');
const url = '/ProcessCheckout';

fetch(url, {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: cartData,
})
.then(response => response.json())
.then(data => {
  // Handle the response from the servlet if needed
})


