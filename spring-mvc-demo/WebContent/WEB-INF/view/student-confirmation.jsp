<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	
	<head>
		<title>Student Confirmation Form</title>
	</head>
	
	<body>
		<div>Student is confirmed: ${student.firstName} ${student.lastName}</div>
		<br /><br />
		<div>Country: ${student.country}</div>
		<br /><br />
		<div>Language: ${student.favoriteLanguage}</div>
		<br /><br />
		<div>OS: 
				 <ul>
				 	<c:forEach var="temp" items="${student.operatingSystems}">
				 		<li>
				 			${temp}
				 		</li>
				 	</c:forEach>
				 </ul>
		</div>
	</body>
</html>