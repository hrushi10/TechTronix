/**
 * 
 */

function loginValidate() {
	const loginEmail = document.getElementById('loginEmail').value;
	const loginPassword = document.getElementById('loginPassword').value;
	var mailFormat = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	
	// email can't be empty
	if(loginEmail == ""){
        alert("Email should be filled out");
        return false;
    }
    
    // email format check
    if(!(loginEmail.match(mailFormat))){
        alert("Email format invalid");
        document.forms["loginForm"]["loginEmail"].focus()
        return false;
    }
    
    // login password field can't be empty
    if(loginPassword == ""){
        alert("Password should be filled out");
        document.forms["loginForm"]["loginPassword"].focus();
        return false;
    }
}