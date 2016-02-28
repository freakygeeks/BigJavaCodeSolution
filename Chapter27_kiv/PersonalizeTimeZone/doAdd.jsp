<%--
   File: doAdd.jsp
   Description:   a branching and forwarding page
--%>

<jsp:useBean id="zones" class="bigjava.MultiZoneBean" scope="session" />
 
 
<% if(request.getParameter("logout")!=null)
   {  
     session.invalidate();%>  
     <jsp:forward page="index.html" />
   <% } 
   else  
   { %>
     <jsp:setProperty name="zones" property="city" param="city"/>
     <jsp:setProperty name="zones" property="date" value="<%= new java.util.Date() %>"/>
     <jsp:forward page="zonedb1.jsp" />
<% } %>
