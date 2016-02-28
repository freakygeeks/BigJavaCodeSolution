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
               Enter city:
               <h:inputText value="#{zone.city}"/>
            </p>
            <p>
               <h:commandButton value="Submit" 
                     action="#{zone.addCity}"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>
