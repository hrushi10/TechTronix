/**
 * 
 */

function signupValidate() {
	const registerEmail = document.getElementById('registerEmail').value;
	const registerPassword = document.getElementById('registerPassword').value;
	const registerName = document.getElementById('registerName').value;

	var mailFormat = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	var passwordFormat = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@#$%^&+=!])(?!.*\s)[A-Za-z\d@#$%^&+=!]{8,}$/;

	if (registerName == "") {
		alert("Name should be filled out");
		return false;
	}

	if (registerEmail == "") {
		alert("Email should be filled out");
		return false;
	}

	if (!(registerEmail.match(mailFormat))) {
		alert("Email format invalid");
		document.forms["signupForm"]["registerEmail"].focus()
		return false;
	}

	if (registerPassword == "") {
		alert("Password should be filled out");
		document.forms["signupForm"]["registerPassword"].focus();
		return false;
	}

	if (!(registerPassword.match(passwordFormat))) {
		alert("Password format invalid.\n These are the password requirements (below):\n At least one alphabetical character.\n At least one digit.\n At least one special character.\n Minimum of 8 characters.");
		document.forms["signupForm"]["registerPassword"].focus();
		return false;
	}
}