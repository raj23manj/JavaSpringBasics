<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	
	<head>
		<title>Customer Registration Form</title>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/test.css">
	</head>
	
	<body>
	Fill Out The Form
		<form:form action="processForm" modelAttribute="customer">
			First name: <form:input path="firstName"/>
			<br /><br />
			
			Last name (*): <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"></form:errors>
			
			<br /><br />
			FreePasses: <form:input path="freePasses"/>
			<form:errors path="freePasses" cssClass="error"></form:errors>
			
			<br /><br />
			PostalCode: <form:input path="postalCode"/>
			<form:errors path="postalCode" cssClass="error"></form:errors>
			
			<br /><br />
			<input type="submit" value="Submit">
			
		</form:form>
	</body>
</html>