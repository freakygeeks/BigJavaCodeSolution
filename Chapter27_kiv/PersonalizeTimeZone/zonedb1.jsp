<%--
     File: zonedb1.jsp
     Description: This page displays the time of the user's favorite cities
--%> 

<jsp:useBean id="zones" class="bigjava.MultiZoneBean" scope="session" />
<html>
   <head>
      <title>Zone Database JSP</title>
   </head>
   <body>
      <h1>Zone Database JSP</h1>
      <form action="doAdd.jsp" method="POST">
       <table border="1">
  	<tr><th>City</th><th>Time</th></tr>
         <jsp:getProperty name="zones" property="times"/>
       </table>
	 <br/>
          Add City:
	     <input type="text" name="city"/>
             <input type="submit" name="add" value="Get Time"/>
   	     <input type="submit" name="logout" value="logout" />         
      </form>
   </body>
</html>
