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
               <h:selectOneRadio value="#{zone.cityToRemove}"
                  layout="pageDirection">
                  <f:selectItems value="#{zone.citiesAndTimes}"/>
               </h:selectOneRadio>
            </p>
            <p>
               <h:commandButton value="Remove selected" 
                     action="#{zone.removeCity}"/>
               <h:commandButton value="Add another" action="back"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>
