<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!--
	This is the Customer Details page
	This page displays the data for each Customer object in the ArrayList from the getCustomers method in dao.CustomerDao class
	The details are fetched using the "customers" field from the request object
-->


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width:device-width, initial-scale=1">
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	<title>Customer Details</title>
</head>
<body style="background-color:powderblue;">
	<div>
	<div class="container pt-1" align="left">
		<form action="home.jsp">
			<input type="submit" value="Home" class="btn btn-success"/>
		</form>
	</div>
	<h1 align="center">Customer Details:</h1>
	<c:if test="${empty customers}">
		<h3> Customer details not found! </h3> 
	</c:if>
	
	<c:if test="${not empty customers}">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th style="background-color:lightblue">Customer ID</th>
		      <th style="background-color:lightblue">First Name</th>
		      <th style="background-color:lightblue">Last Name</th>
		      <th style="background-color:lightblue">Address</th>
		      <th style="background-color:lightblue">City</th>
		      <th style="background-color:lightblue">State</th>
		      <th style="background-color:lightblue">Zip Code</th>
			  <th style="background-color:lightblue">Telephone</th>
			  <th style="background-color:lightblue">Email</th>
			  <th style="background-color:lightblue">Credit Card</th>
			  <th style="background-color:lightblue">Rating</th>
			  <th style="background-color:lightblue"></th>
			  <th style="background-color:lightblue"></th>
			  <th style="background-color:lightblue"></th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${customers}" var="cd">
		       <tr>
		         <td style="background-color:#9999FF">${cd.customerID}</td>
		         <td>${cd.firstName}</td>
		         <td style="background-color:#9999FF">${cd.lastName}</td>
		         <td>${cd.address}</td>
		         <td style="background-color:#9999FF">${cd.city}</td>
		         <td>${cd.state}</td>
		         <td style="background-color:#9999FF">${cd.zipCode}</td>
		         <td>${cd.telephone}</td>
		         <td style="background-color:#9999FF">${cd.email}</td>
		         <td>${cd.creditCard}</td>
		         <td style="background-color:#9999FF">${cd.rating}</td>
   		         <td>
		         	<form method="POST" action="getItemSuggestions">
						<div class="form-group">
			            	<input type="hidden" class="form-control" name="customerID" value=${cd.customerID}>
			        	</div>
						<input type="submit" value="Suggestions" class="btn btn-success"/>
					</form>
		         </td>		         
		         <td>
		         	<form method="POST" action="editCustomer">
						<div class="form-group">
			            	<input type="hidden" class="form-control" name="customerID" value=${cd.customerID}>
			        	</div>
						<input type="submit" value="Edit" class="btn btn-success"/>
					</form>
		         </td>
   		         <td>
		         	<form method="POST" action="deleteCustomer">
						<div class="form-group">
			            	<input type="hidden" class="form-control" name="customerID" value=${cd.customerID}>
			        	</div>
						<input type="submit" value="Delete" class="btn btn-success"/>
					</form>
		         </td>		         
		       </tr>
		     </c:forEach>
		  </tbody>
		</table>
	</c:if>
	</div>
	<div class="container pt-1" align="center">
		<form action="home.jsp">
			<input type="submit" value="Home" class="btn btn-success"/>
		</form>
	</div>
	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
</body>
</html>