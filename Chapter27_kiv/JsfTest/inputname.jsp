<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
 <head>
  <title>Enter your name page</title>
 </head>
 <body>
   <f:view>
     <h1>
      <h:outputText value="JSF Start"/>
     </h1>
     <h:form id="helloForm">
      <h:messages></h:messages>
      <h:outputText value="Tell Us Your Name:"/>
      <h:inputText value="#{personBean.personName}"/>
      <h:commandButton action="greeting" value="Say Hello"/>
     </h:form>
   </f:view>
 </body>
</html>  


