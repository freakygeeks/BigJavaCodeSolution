<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
	<title></title>
</head>
	<body>
		<f:view>
		<h3>
		<h:outputText value="Welcome"/>
		<h:outputText value="#{UserBean.userName}"/> to our Shopping Mall
		</h3>
		</f:view>
	</body>
</html>