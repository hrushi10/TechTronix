<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login/Sign Up</title>

<!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />

<!-- End of Header -->
</head>
<body>

	<div class="container my-5">
		<div class="row">
			<div class="col-lg-6">
				<h3>Login</h3>
				<form action="UserController" method="post">
					<div class="form-group">
						<label for="loginEmail">Email</label> <input type="email"
							class="form-control" id="loginEmail" name="loginEmail" required>
					</div>
					<div class="form-group">
						<label for="loginPassword">Password</label> <input type="password"
							class="form-control" id="loginPassword" name="loginPassword"
							required>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
				<br>
				<br>
				<p>
					Not registered? Click <a href="./${initParam.param1}?action=signup">here</a> to sign up.
				</p>
			</div>
		</div>
	</div>

</body>
</html>
