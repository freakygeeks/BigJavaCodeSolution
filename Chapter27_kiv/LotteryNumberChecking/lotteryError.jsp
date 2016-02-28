<%@page import="bigjava.LotteryBean" %>
<%-- Display the lottery result. --%>

<jsp:useBean id="lottery" scope="session" class="bigjava.LotteryBean" />

<html>
  <head>
    <title>
      Chapter27 - Exercise 27.5
    </title>
  </head>
  <body>
	 <h1><font color="red">Input Error</font></h1>
	 <pre><%= lottery.getError() %><pre>
	 <form action="index.jsp" method="post">	
	 <input type="submit" value="One More Time"/>
	 </form>	 
  </body>
</html>
