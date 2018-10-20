<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>

	<head>
	  <title>Luv2code</title>
	</head>


     <body>
     	<div>
	     	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	     		<input type="Submit" value="Logout" />
	     	</form:form>
     	</div>
     	<div>
     		Welcome YoYo!
     	</div>
     	<hr />
     	<div>
     		<!-- display user name and role using spring security -->
     		<p>
     			User: <security:authentication property="principal.username"/>
     		</p>
     		<hr />
     		<p>
     			Role: <security:authentication property="principal.authorities"/>
     		</p>
     	</div>
     	<hr />
     	
     	<div>
     		<p>
     			<security:authorize access="hasRole('MANAGER')">
     				<a href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a>
     			</security:authorize>	
     		</p>
     	</div>
     	
     	<div>
     		<p>
     			<security:authorize access="hasRole('ADMIN')">
     				<a href="${pageContext.request.contextPath}/systems">Admin Meetings</a>
     			</security:authorize>	 			
     		</p>
     	</div>
     </body>
</html>