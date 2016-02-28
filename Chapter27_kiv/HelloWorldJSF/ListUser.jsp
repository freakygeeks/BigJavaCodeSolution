<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
<head>
	<title>List of Users</title>
</head>
<body>
<f:view>
	<h:form>
		<h:outputText value="User #{userBean.name} is added successfully.">
		</h:outputText>
	</h:form>
</f:view>
</body>
</html>