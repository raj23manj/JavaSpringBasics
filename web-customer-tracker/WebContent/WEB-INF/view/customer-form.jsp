<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
	<head>
		<title>Save Form</title>
	    <link rel="stylesheet" 
	   		  type="text/css" 
	   		  href="${pageContext.request.contextPath}/resources/css/style.css">
	  	<link rel="stylesheet" 
	  		  type="text/css" 
	  		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">	  
	</head>
	
	<body>
	  <div id="wrapper">
	    <div id="header">
	      <h2>CRM - Customer Relationship Manager</h2>
	    </div>
	  </div>
	  
	  <div id="container">
	  	<h3>Save Customer</h3>
	  </div>
	  
	  
	<form:form action="saveCustomer" modelAttribute="customer" method="post">
	
		<table>
			<tbody>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				
				<tr>
					<td><label> Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="save" class="save"/></td>
				</tr>
				
			</tbody>
		</table>
	</form:form>
	
	<div style="clear; both;"></div>
	
	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back To List</a>
	</p>
	</body>
</html>