<%--
   File: doCheck.jsp
   Description: connect with database 
--%>

<jsp:useBean id="db" class="bigjava.DataSourceBean" scope="application">
   <jsp:setProperty name="db" property="driver" 
      value='<%= application.getInitParameter("com.mysql.jdbc.Driver") %>'/>
   <jsp:setProperty name="db" property="url" 
      value='<%= application.getInitParameter("jdbc:mysql://localhost/cdcol") %>'/>
   <jsp:setProperty name="db" property="username" 
      value='<%= application.getInitParameter("root") %>'/>
   <jsp:setProperty name="db" property="password" 
      value='<%= application.getInitParameter("toor123456") %>'/>
</jsp:useBean>

<jsp:useBean id="zones" class="bigjava.MultiZoneBean" scope="session"/>
<jsp:setProperty name="zones" property="user" param="id"/>
<jsp:setProperty name="zones" property="pwd" param="pwd"/>
<jsp:setProperty name="zones" property="date" value="<%= new java.util.Date() %>"/>
<% if(!zones.getMatch()) 
   { %>
     <jsp:forward page="index.html" />
   <% } 
   else 
   { %>
      <jsp:forward page="zonedb1.jsp" />
<% } %>
