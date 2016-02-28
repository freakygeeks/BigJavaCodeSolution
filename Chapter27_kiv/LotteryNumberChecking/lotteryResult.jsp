<%@page import="bigjava.LotteryBean" %>
<%@page import="bigjava.ArrayListFormatter" %>
<%-- Display the lottery result. --%>

<jsp:useBean id="lottery" scope="session" class="bigjava.LotteryBean" />

<jsp:useBean id="formatter" class="bigjava.ArrayListFormatter" />
<html>
  <head>
    <title>
      Chapter27 - Exercise 27.5
    </title>
  </head>
  <body>
	<center>
	 <h1><font color="red">Lottery Result</font></h1>
	 <h2>You have <font color="blue"> 	<%= lottery.getNumberOfHits() %> </font> matches.</h2>
	 <form action="index.jsp" method="post">	

		 <p>Lucky Numbers:</p>
     <%= formatter.format(lottery.getLotteryResults()) %>
		<p>Your Numbers: </p>
     <%= formatter.format(lottery.getUserLotteryNum()) %>     
	 <br/>
	 <input type="submit" value="One More Time"/>
	 </form>	 
  </body>
</html>
