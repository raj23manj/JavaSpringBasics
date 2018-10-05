<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	</body>
</html>