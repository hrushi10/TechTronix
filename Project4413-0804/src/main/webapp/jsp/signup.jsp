<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login/Sign Up</title>

<!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />

<!-- Sign Up Validation javascript file -->
<script src="./js/userSignUpValidation.js"></script>

<!-- End of Header -->
</head>
<body style="background-color: darkgrey;">

	<div class="container my-5">
		<div class="row">
			<div class="centerRegister">
				<%
				if (request.getAttribute("registeredMsg3") != null) {
				%>
				<h6 style="color: red; text-align: center;"><%=request.getAttribute("registeredMsg3")%></h6>
				<%
				}
				%>
				<h3 style="text-align: center;">Register</h3>
				<form name="signupForm" action="UserRegisterController"
					onsubmit="return signupValidate()" method="post">
					<div class="form-group">
						<label for="registerName">Name</label> <input type="text"
							class="form-control" id="registerName" name="registerName"
							style="width: 300px;">
					</div>
					<div class="form-group">
						<label for="registerEmail">Email</label> <input type="text"
							class="form-control" id="registerEmail" name="registerEmail"
							style="width: 300px;">
					</div>
					<div class="form-group">
						<label for="registerPassword">Password</label> <input
							type="password" class="form-control" id="registerPassword"
							name="registerPassword" style="width: 300px;">
					</div>
					<button type="submit" class="btn btn-success">Register</button>
				</form>
				<br> <br>
				<p>
					Already registered? Click <a
						href="./${initParam.param1}?action=login">here</a> to login.
				</p>
			</div>
		</div>
	</div>

</body>
</html>
