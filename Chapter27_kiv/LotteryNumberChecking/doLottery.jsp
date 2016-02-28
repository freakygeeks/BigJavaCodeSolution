<%@page import="bigjava.LotteryBean" %>

<jsp:useBean id="lottery" scope="session" class="bigjava.LotteryBean" />

<%
        lottery.reset();
	 lottery.add(request.getParameter("n1"));
	 lottery.add(request.getParameter("n2"));
	 lottery.add(request.getParameter("n3"));
	 lottery.add(request.getParameter("n4"));
	 lottery.add(request.getParameter("n5"));
	 lottery.add(request.getParameter("n6"));
	 lottery.generateLottery();
        if (lottery.getError() == null) 
        {
%>

<jsp:forward page="lotteryResult.jsp" />

<%
        }
        else
        {
%>

<jsp:forward page="lotteryError.jsp" />

<%
        }
%>
