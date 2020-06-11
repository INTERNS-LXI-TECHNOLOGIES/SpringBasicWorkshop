<%@ page import = "com.lxisoft.mockexamjavaconfig.model.*"%> 
<%@page import = "java.util.*" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<title>Questions</title>
		<link href='<c:url value="resources/css/questionscss.css"></c:url>' rel="stylesheet" type="text/css"/>
	</head>
<body background="<c:url value='resources/images/49375.jpg'/>">
		<%
			int qCount = Integer.parseInt(request.getParameter("count"));
			ArrayList<Exam> data = new  ArrayList<Exam>();
			data  = (ArrayList<Exam>)session.getAttribute("examdatas");
			if(data.size() == 0)
			{
				response.sendRedirect("introduction");
			}
			else if(qCount<data.size())
			{
		%>
		 <form action="checkAnswer" method="GET">
			<div id="clock">
				 <input type="hidden" name="count" value="<%=qCount%>"> 
			 	<label id="timerclock">Time : <span id="timer"></span></label>		
		  	</div>
		</form>
	
		<div id="question">
		<p style="font-size:40px;">Q<%out.println(qCount+1);%>---><%out.println(data.get(qCount).getQuestion());%></p>
		<form action="checkAnswer" method="GET">
		<input type="hidden" name="id" value="<%=data.get(qCount).getId()%>">
		<div id="option">
			<span>
			<input type="radio" id="radiobtn" name="ans" value="<%=data.get(qCount).getOpt1()%>" required="required">
			<label><%out.println(data.get(qCount).getOpt1());%></label><br>
			</span>
			<span>
			<input type="radio" id="radiobtn" name="ans" value="<%=data.get(qCount).getOpt2()%>">
			<label><%out.println(data.get(qCount).getOpt2());%></label><br>
			</span>
			<span>
			<input type="radio" id="radiobtn" name="ans" value="<%=data.get(qCount).getOpt3()%>">
			<label><%out.println(data.get(qCount).getOpt3());%></label><br>
			</span>
			<span>
			<input type="radio" id="radiobtn" name="ans" value="<%=data.get(qCount).getOpt4()%>">
			<label><%out.println(data.get(qCount).getOpt4());%></label>
			</span>
		</div>
			<%
				qCount ++;
			%>
			<input type="hidden" name="count" value="<%=qCount%>" id="cnt">
			<a href=""><button type="submit" id="btn" style="height: 45px;width: 110px;">Next</button></a>
			
		</form>
			<%
		}
		else
		{
			response.sendRedirect("validateResult");	
		}
		%>
		</div>	
		<script type="text/javascript">
		var qCount=document.getElementById('cnt').value;
		var sec = 10;
		var time = setInterval(myTimer, 1000);
		function myTimer() 
		{
    		document.getElementById('timer').innerHTML = sec + "sec left";
    		sec--;
    		if (sec == -1) 
    		{
        		clearInterval(time);
        		alert("Time out!! :(");
        		// console.log(qCount);
        		window.location.href="http://localhost:1546/mockexam/checkAnswer?count="+qCount;
    		}
		}
	</script>	
</body>
</html>
