<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
   <f:view>
      <head>                  
         <title>The multizone application</title>
      </head>
      <body>
         <h:form>
            <p>
               Sorry, no information is available for 
               <h:outputText value="#{zone.city}"/>
            </p>
            <p>
               <h:commandButton value="Back" action="back"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>