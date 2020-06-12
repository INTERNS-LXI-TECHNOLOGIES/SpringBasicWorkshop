 <%@ page import="java.util.*" %>
 <%@ page import = "com.lxisoft.mockexamjpa.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>Result</title>
		<link href='<c:url value="resources/css/resultcss.css"></c:url>' rel="stylesheet" type="text/css"/>	
</head>
<body>
	<%
	String score = request.getAttribute("totalScore").toString();
 	int mark = Integer.parseInt(score);
	%>
	
	<div id="heading">
	</div>
	<div id="box">
		<h5 style="text-align: center;font-size: 20px;color:black;">Mock Exam Result</h5>
		<p style="font-size: 30px">
			<ul>
				<li><h1> Thank U For Attending The Exam </h1></li>
				<li><h1> You Got <%out.println(mark);%> Marks.</h1></li>
				<%
				if(mark<6)
				{
				%>
				<li><h1> oops...! You Failed...</h1></li>
				<%}
				else 
				{
				%>	
				<li><h1> Hurray...Congragulation....You Passed...</h1></li>		
				<%	
				}
				%>
			</ul>
		</p>
	</div>
	<div id="bbtn" >
		<form action="home" method="GET">
			<button id="btn" style="height: 50px;width: 100px">Home</button>
		</form>
	</div>
	<div id="bbbtn" >
		<button id="btn" style="height: 50px;width: 100px" onclick="show()">Check</button>
	</div>
	<div id="bbbbtn" >
		<form action="${pageContext.request.contextPath}/logout" method="GET">
		<button id="btn" style="height: 50px;width: 100px" ">Logout</button>
		</form>
	</div>
	
	<div id="boxx" >
	<%
			ArrayList<Exam> data = new  ArrayList<Exam>();
			data = (ArrayList<Exam>)session.getAttribute("examdatas");
			ArrayList<String> list = (ArrayList<String>)session.getAttribute("ansSelected");
		
	%>
		<div id="view">
		<table id="pager" border="2px" width="100%">
		<tr>
			<th>SL.NO</th>
			<th>QUESTION</th>
			<th>ANSWER</th>
			<th>CLICKED_OPTION</th>
		</tr>
		<% 
				
			for (int i=0;i<data.size();i++)
				{%>
				
				<tr>
				<td><%out.println(i+1);%></td>				
			
			<td><%out.println(data.get(i).getQuestion());%></td> 
			<td><%out.println(data.get(i).getAnswer());%></td>
			<td><%out.println(list.get(i));%></td>	
			</tr>			
			<%} 
			%>
		</table>
	</div>
				
	</div>
	<script type="text/javascript">
		function show()
		{
			var x = document.getElementById("boxx");
			if(x.style.display !== "none")
			{
				x.style.display = "none";
			}	
			else
			{
				x.style.display = "block";
			}	
		}
	</script>
</body>
</html>
