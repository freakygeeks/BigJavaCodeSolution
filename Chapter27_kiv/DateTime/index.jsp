<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
   <f:view>
      <head>                  
         <title>The datetime application</title>
      </head>
      <body>
         <h:form>
            <p>Number of milliseconds since January 1, 1970: 
               <h:outputText value="#{dateTime.time}"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>