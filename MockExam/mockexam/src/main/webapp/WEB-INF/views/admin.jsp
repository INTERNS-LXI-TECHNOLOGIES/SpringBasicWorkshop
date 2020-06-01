<%@ page import = "com.lxisoft.mockexam.model.*"%>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ADMIN</title>
	
	<style type="text/css">
		
		html,body{
			padding: 5px;margin: 10px;
			background:#009b77;
		}

		.button1{
			background-color: #008cba;
			color: white;
			padding: 15px 30px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 15px;
			border-radius: 10px;
		}
		#logout
		{
			float: right;
			position: relative;
			top: -50px;	
			left: 50px;
		}
		#exam
		{
			float: right;
			position: relative;
			top: -50px;	
			left: -210px;
		}
		table
		{
    		align-content: center;
   			margin: inherit;
    		width: 100%;
		}
		
	</style>
</head>
<body>
		<form action="${pageContext.request.contextPath}/add" id="addQuestion" method="GET">
			<button class="button1">Add Question</button>
		</form>
		
		<form action="${pageContext.request.contextPath}/introduction" id="exam" >
			<button class="button4" style="height: 50px;background-color: #008cba; width: 100px; color: white;border-radius: 10px;">
			Test Exam
			</button>
		</form>
		
		<form action="${pageContext.request.contextPath}/logout"  id="logout" method="GET">
			<button class="button3" style="height: 50px;background-color: #008cba; width: 100px; color: white;border-radius: 10px;">
			Logout
			</button>
		</form>	
		
		<div id="view">
		<table id="pager" border="2px" width="100%">
		<tr>
			<th>SL.NO</th>
			<th>ID</th>
			<th>QUESTION</th>
			<th>OPT_1</th>
			<th>OPT_2</th>
			<th>OPT_3</th>
			<th>OPT_4</th>
			<th>ANSWER</th>
		</tr>
		<% 
				ArrayList<Exam> questions = new ArrayList<Exam>();
				questions = (ArrayList<Exam>)session.getAttribute("qList");
				if(questions.size() == 0)
				{%>
				<script type="text/javascript">
					window.alert("No Records To Display");
				</script>	
			<%}
			else
			{
				for (int i=0;i<questions.size();i++)
				{%>
				
				<tr>
				<td><%out.println(i+1);%></td>				
			<td><%out.println(questions.get(i).getId());%></td>
			<td><%out.println(questions.get(i).getQuestion());%></td>
			<td><%out.println(questions.get(i).getOpt1());%></td>
			<td><%out.println(questions.get(i).getOpt2());%></td>
			<td><%out.println(questions.get(i).getOpt3());%></td>
			<td><%out.println(questions.get(i).getOpt4());%></td> 
			<td><%out.println(questions.get(i).getAnswer());%></td>
			<td><a href="${pageContext.request.contextPath}/updateQuestion?
					id=<%=questions.get(i).getId()%>&
				question=<%=questions.get(i).getQuestion()%>&
				opt1=<%=questions.get(i).getOpt1()%>&
				opt2=<%=questions.get(i).getOpt2()%>&
				opt3=<%=questions.get(i).getOpt3()%>&
				opt4=<%=questions.get(i).getOpt4()%>&
				answer=<%=questions.get(i).getAnswer()%>"
				><button>Update</button></a></td>
			<td><a><button>Delete</button></a></td>	
			</tr>			
			<%} 
			}%>
		</table>
	</div>
	<div id="pageNavPosition" class="pager-nav" style="float: right;"></div>
		
	
</body>
</html>