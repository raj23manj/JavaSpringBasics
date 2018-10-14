<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
				 
				 
				  <!--  add a search box -->
	            <form:form action="search" method="POST">
	                Search customer: <input type="text" name="theSearchName" />
	                
	                <input type="submit" value="Search" class="add-button" />
	            </form:form>

				 
				
			  <table>
			  	<tr>
			  	  <th>First Name</th>
			  	  <th>Last Name</th>
			  	  <th>Email</th>
			  	  <th>Action</th>
			  	</tr>
			  	<c:forEach var="tempCustomer" items="${customers}">
			  		<!-- construct url with tags -->
			  		<c:url var="updateLink" value="/customer/showFormForUpdate">
			  			<c:param name="customerId" value="${tempCustomer.id}" />
			  		</c:url>
			  		
			  		<c:url var="deleteLink" value="/customer/delete">
			  			<c:param name="customerId" value="${tempCustomer.id}" />
			  		</c:url>
			  	
				  	<tr>	
				  		<td>${tempCustomer.firstName}</td>
				  		<td>${tempCustomer.lastName}</td>
				  		<td>${tempCustomer.email}</td>
				  		<td>
				  			<a href="${updateLink}">Update</a> | 
				  			<a href="${deleteLink}" onclick="if(!(confirm('Are you sure ?'))) return false">Delete</a>
			  			</td>	
				  	</tr>
			  	</c:forEach>
			  </table>
			
			</div>
		</div>
		
	</body>
</html>	