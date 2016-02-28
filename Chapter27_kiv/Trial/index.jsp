<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
	<title></title>
</head>
	<body>
		<f:view>
		<h1>
		<h:outputText value="Welcome to our Shopping Mall"/>
		</h1>
		<h:form id="LoginForm">
		<h:outputText value="Enter Your Name:"/>
		<h:inputText value="#{UserBean.userName}"/>
		<h:commandButton action="welcome" value="Submit"/>
		</h:form>
		</f:view>
	</body>
</html>