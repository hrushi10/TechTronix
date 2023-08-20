<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login/Sign Up</title>

<!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />

<!-- Validation of login javascript file -->
<script src="./js/userLoginValidation.js"></script>

<!-- End of Header -->
</head>
<body>

	<div class="container my-5">
		<div class="row">
			<div class="centerLogin">
				<%
				if (request.getAttribute("error") != null) {
				%>
				<h6 style="color: red; text-align: center;"><%=request.getAttribute("error")%></h6>
				<%
				}
				%>
				<%
				if (request.getAttribute("registeredMsg") != null) {
				%>
				<h6 style="color: green; text-align: center;"><%=request.getAttribute("registeredMsg1")%></h6>
				<p style="font-size: 14px; text-align: center;"><%=request.getAttribute("registeredMsg2")%></p>
				<%
				}
				%>
				<h3 style="text-align: center;">Login</h3>
				<form name="loginForm" action="UserController"
					onsubmit="return loginValidate()" method="post">
					<div class="form-group">
						<label for="loginEmail">Email</label> <input type="text"
							class="form-control" id="loginEmail" name="loginEmail"
							style="width: 300px;">
					</div>
					<div class="form-group">
						<label for="loginPassword">Password</label> <input type="password"
							class="form-control" id="loginPassword" name="loginPassword"
							style="width: 300px;">
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
				<br> <br>
				<p>
					Not registered? Click <a href="./${initParam.param1}?action=signup">here</a>
					to sign up.
				</p>
			</div>
		</div>
	</div>
</body>
</html>
