<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
  <head>
   <title>greeting page</title>
  </head>    
  <body>
     <f:view>
     	<h3>
 	 <h:outputText value="WelCome To JSF ,"/>
 	 <h:outputText value="#{personBean.personName}"/>
         <h:outputText value="!"/>
    	</h3>
     </f:view>
 </body>	
</html> 