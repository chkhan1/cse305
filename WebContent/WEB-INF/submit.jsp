<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
		<title>Login | Online Auction Bay</title>
	</head>
	<body bgcolor = "8B008B">
	
		<h1 align="center" top=20>Welcome to the Online Auction Bay</h1>
		<div class="container">
			<h2>New User</h2>
			<%
				//String firstName = (String)session.getAttribute("firstname");
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
				
				//redirect to home page if already logged in
				if(email != null) {
					if(role.equals("manager")) {
						response.sendRedirect("managerHome.jsp");
					}
					else if(role.equals("customerRepresentative")) {
						response.sendRedirect("customerRepresentativeHome.jsp");
					}
					else {
						response.sendRedirect("home.jsp");	
					}
				}
				String status = request.getParameter("status");
				if(status != null) {
					if(status.equals("false")) {
						out.print("Incorrect Login credentials!");
					}
					else {
						out.print("Some error occurred! Please try again.");
					}
				}
			%>
			<form action="login">
				<div class="form-group">
					<input type="firstname" class="form-control" name="firstname" placeholder="First Name" required>
				</div>
				<div class="form-group">
	            	<input type="lastname" class="form-control" name="lastname" placeholder="Last Name" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="address" class="form-control" name="address" placeholder="Address" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="city" class="form-control" name="city" placeholder="City" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="state" class="form-control" name="state" placeholder="State" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="zipcode" class="form-control" name="zipcode" placeholder="Zip Code" required>
	        	</div>
	        	</div>
	        	<div class="form-group">
	            	<input type="number" class="form-control" name="number" placeholder="Phone Number" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="email" class="form-control" name="email" placeholder="Email" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="ssn" class="form-control" name="ssn" placeholder="SSN" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="username" class="form-control" name="username" placeholder="User Name" required>
	        	</div>
	        	<div class="form-group">
	            	<input type="password" class="form-control" name="password" placeholder="Password" required>
	        	</div>
				<input type="submit" value="Login" class="btn btn-success"/>
			</form>
		</div>
		
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/bootstrap.min.js"></script>
	</body>
</html>