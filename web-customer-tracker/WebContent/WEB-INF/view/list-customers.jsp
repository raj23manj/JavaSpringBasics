<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	
	
	<head>
		<title>List Customer</title>
		<link rel="stylesheet" type="text/css"           
   		      href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>

		<div>
		  List Customers
		</div>
		
		<div id="wrapper">
			<div id="header">
				<h2>
					CRM - Customer Relationship Manager
				</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
				<input type="button" value="Add Customer" 
					   onclick="window.location.href='showFormForAdd'; return false;"
					   class="add-button"
				 />
				
			  <table>
			  	<tr>
			  	  <th>First Name</th>
			  	  <th>Last Name</th>
			  	  <th>Email</th>
			  	</tr>
			  	<c:forEach var="tempCustomer" items="${customers}">
				  	<tr>	
				  		<td>${tempCustomer.firstName}</td>
				  		<td>${tempCustomer.lastName}</td>
				  		<td>${tempCustomer.email}</td>	
				  	</tr>
			  	</c:forEach>
			  </table>
			
			</div>
		</div>
		
	</body>
</html>	