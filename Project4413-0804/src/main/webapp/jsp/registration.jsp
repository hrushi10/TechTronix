<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login/Signup</title>
        
   										 <!-- Header for Catalog Page -->
<jsp:include page="header.jsp" flush="true" />

														<!-- End of Header -->   
</head>
<body>
													
<div class="container my-5">
    <div class="row">
        <div class="col-lg-6">
            <h3>Login</h3>
            <form action="processLogin.jsp" method="post">
                <div class="form-group">
                    <label for="loginEmail">Email</label>
                    <input type="email" class="form-control" id="loginEmail" name="loginEmail" required>
                </div>
                <div class="form-group">
                    <label for="loginPassword">Password</label>
                    <input type="password" class="form-control" id="loginPassword" name="loginPassword" required>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            
        </div>
        <div class="col-lg-6">
            <h3>Register</h3>
            <form action="processRegister.jsp" method="post">
                <div class="form-group">
                    <label for="registerName">Name</label>
                    <input type="text" class="form-control" id="registerName" name="registerName" required>
                </div>
                <div class="form-group">
                    <label for="registerEmail">Email</label>
                    <input type="email" class="form-control" id="registerEmail" name="registerEmail" required>
                </div>
                <div class="form-group">
                    <label for="registerPassword">Password</label>
                    <input type="password" class="form-control" id="registerPassword" name="registerPassword" required>
                </div>
                <button type="submit" class="btn btn-success">Register</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
