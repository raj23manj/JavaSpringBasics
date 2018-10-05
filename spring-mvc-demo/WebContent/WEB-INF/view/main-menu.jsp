<!DOCTYPE html>
<html>
	
	<head>
		<link rel="stylesheet" type="text/css"           
           href="${pageContext.request.contextPath}/resources/css/test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
	</head>
	
	<body>
		<h2>Spring MVC Demo - Hello</h2>
		<hr>
		<a href="hello/showForm">Hello World Form</a>
		<br /><br />
		<a href="student/showForm">Student Form</a>
		<br /><br />
		<a href="customer/showForm">Customer Form</a>
		<%-- <img src="${pageContext.request.contextPath}/resources/images/spring-logo.png"> --%>
	</body>
</html>