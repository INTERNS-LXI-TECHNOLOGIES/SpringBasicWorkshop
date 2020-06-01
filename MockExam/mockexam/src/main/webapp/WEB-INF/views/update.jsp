<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>ADD</title>
	<style type="text/css">
		.container
		{
			text-align:center;
			width: 100%;
			height: 100%;
			margin: 0 auto;
			padding-top: 40px;
			background:#009b77;
		}
		html,body
		{
			width: 100%;
			height: 100%;
			position: fixed;
			margin:0;
		}
		input
		{
			border-radius: 8px;
			border-spacing: 20px;
			width: 250px;
			height: 26px;
		}
		textarea
		{
			width: 300px;
			height: 50px;
		}
		button
		{
			width: 60px;
			height: 35px;
			border-radius: 10px;
		}
		form
		{
			padding-left:500px;
		}
	</style>
</head>
<body>
		<div class="container">
			<h2>UPDATE QUESTION</h2>
			<form:form action="updateQuestion" method="GET" modelAttribute="exam">
				<table>
					<tr>
						<td>SL.NO:</td>
						<td><input type="text" name="id" value="<%=request.getParameter("id")%>" readonly /></td>
					</tr>
					<tr>
						<td>QUESTION:</td>
						<td><input type="text" id="que" name="ques" value="<%=request.getParameter("question")%>" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_1:</td>
						<td><input type="text" name="op1" value="<%=request.getParameter("opt1")%>" required="required"/></td>	
					</tr>
					<tr>
						<td>OPT_2:</td>
						<td><input type="text" name="op2" value="<%=request.getParameter("opt2")%>" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_3:</td>
						<td><input type="text" name="op3" value="<%=request.getParameter("opt3")%>" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_4:</td>
						<td><input type="text" name="op4" value="<%=request.getParameter("opt4")%>" required="required"/></td>
					</tr>
					<tr>
						<td>ANSWER:</td>
						<td><input type="text" name="ans" value="<%=request.getParameter("answer")%>" required="required"/></td>
					</tr>
					<tr>
						<td colspan = "2" align = "center" ><button type = "submit" onclick="myFunction()">Save</button></td>
					</tr>
				</table>
			</form:form>	
		</div>
		<script type="text/javascript">
		
			function myFunction()
			{
				confirm("Successfully Updated.....");
			}
		
		</script>
</body>
</html>