<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
	<head>
		<title>Exercise Chapter 27.1</title>
	</head>
	<body>
		<table border="1">
		<tr>
			<td>Java Version</td>
			<td><%= System.getProperty("java.version") %></td>
		</tr>
		<tr>
			<td>Operating System Name</td>
			<td><%= System.getProperty("os.name") %>
		</tr>
		<tr>
			<td>Operating System Version</td>
			<td><%= System.getProperty("os.version") %>
		</tr>
		</table>
	</body>
</html>
				