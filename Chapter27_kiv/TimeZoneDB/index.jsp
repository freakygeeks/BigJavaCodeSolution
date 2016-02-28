<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
      <head>                  
         <title>The timezone application</title>
      </head>
      <body>
	     <f:view>
         <h:form>
            <p>
               The current date and time in 
               <h:outputText value="#{zone.city}"/>
               is: 
               <h:outputText value="#{zone.time}"/>
            </p>
            <p>
               Set time zone:
               <h:inputText value="#{zone.city}"/>
            </p>
            <p>
               <h:commandButton value="Submit"/>
            </p>
         </h:form>
		 </f:view>
      </body>
</html>

