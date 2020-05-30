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
		<div id="addQuestion">
			<a href="add"><button class="button1">Add Question</button></a>
		</div>
		
		<div id="exam">
			<a href="secured/introduction"><button class="button4" style="height: 50px;background-color: #008cba; width: 100px; color: white;border-radius: 10px;">
			Test Exam
			</button></a>
		</div>
		
		<div id="logout">
			<a href="../logout.jsp"><button class="button3" style="height: 50px;background-color: #008cba; width: 100px; color: white;border-radius: 10px;">
			Logout
			</button></a>
		</div>	
		
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
		<c:forEach var = "quest" items = "${questionList}">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><button>Delete</button></td>
				<td><button>Update</button></td>				
			</tr>			
		</c:forEach>
		</table>
	</div>
</body>
</html>