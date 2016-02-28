<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
	<head>
		<title>Exercise Chapter 27.3</title>
	</head>
	<body>Rolled a <img src="resources/images/<%= (int)(Math.random()*6+1) %>.png">
			 and a <img src="resources/images/<%= (int)(Math.random()*6+1) %>.png">
	</body>
</html>
