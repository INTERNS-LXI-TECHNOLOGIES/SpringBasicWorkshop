 <%@ page import="java.util.*" %>
 <%@ page import = "com.lxisoft.mockexam.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>Result</title>
	<style type="text/css">
		head,body{
			background-color: #7fcdcd;
		}
		#heading{
			text-align: center;
		}
		#box{
			background-color: lightgrey;
			width: 1150px;
			border:15px solid green;
			padding: 50px;
			padding-top: 5px;
			margin: 35px;
			border-radius: 45px;

		}
		#boxx{
			background-color: lightgrey;
			width: 1150px;
			border:15px solid green;
			padding: 50px;
			padding-top: 5px;
			margin: 35px;
			border-radius: 45px;

		}
		#btn{
			border-radius: 15px;
			border-color: black;
			background-color: red;
			margin-top: -20px;
		}
		#bbtn{
			text-align: center;
			margin-top: 10px;
			padding-right: 200px;
		}
		#bbbtn{
			text-align: center;
			margin-right: -55px;
			margin-top:-35px;
		}
	</style>
		
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

