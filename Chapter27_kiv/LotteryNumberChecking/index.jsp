<%@page import="bigjava.LotteryBean" %>
<jsp:useBean id="lottery" scope="session" class="bigjava.LotteryBean" />
<jsp:setProperty name="lottery" property="numbers" value="49" />
<jsp:setProperty name="lottery" property="choices" value="6" />

<html>
  <head>
    <title>
      Chapter27 - Exercise 27.5
    </title>
  </head>
  <body>
   <h1><font color="red">Lottery</font></h1>
   <h2>Please select your six lucky numbers!</h2>
    <form action="doLottery.jsp" method="post">
     <input type="text" name="n1"/>
     <input type="text" name="n2"/>
     <input type="text" name="n3"/>
     <input type="text" name="n4"/>
     <input type="text" name="n5"/>
     <input type="text" name="n6"/>
     <input type="submit" value="Go!"/>
    </form>
  </body>
</html>

