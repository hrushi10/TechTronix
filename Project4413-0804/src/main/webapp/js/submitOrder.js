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
    
    if(cart == null){
		
		alert('The Cart is empty !! ');
	}
    
    
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
            window.location.href = './products?action=thankyou'; 
        } else {
            // If there's an error message from the server
            alert(data.message || 'Order processing failed. Please try again.');
        }
    })
    .catch(error => {
        alert('There was an error: ' + error);
    });
}

