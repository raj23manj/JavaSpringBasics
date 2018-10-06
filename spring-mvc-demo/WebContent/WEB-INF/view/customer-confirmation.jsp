<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	
	<head>
		<title>Customer Confirmation</title>
	</head>
	
	<body>
		The Customer is: ${customer.firstName}-${customer.lastName}-${customer.freePasses}-${customer.postalCode}
	</body>
</html>