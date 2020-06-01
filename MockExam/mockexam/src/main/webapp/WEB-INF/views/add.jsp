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
			padding-left:450px;
		}
	</style>
</head>
<body>
		<div class="container">
			<h2>ADD QUESTION</h2>
			<form:form action="addQuestion" method="GET" modelAttribute="exam">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>QUESTION:</td>
						<td><form:input path="question"  required="required"/></td>
					</tr>
					<tr>
						<td>OPT_1:</td>
						<td><form:input path="opt1" required="required"/></td>	
					</tr>
					<tr>
						<td>OPT_2:</td>
						<td><form:input path="opt2" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_3:</td>
						<td><form:input path="opt3" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_4:</td>
						<td><form:input path="opt4" required="required"/></td>
					</tr>
					<tr>
						<td>ANSWER:</td>
						<td><form:input path="answer" required="required"/></td>
					</tr>
					<tr>
						
						<td colspan = "2" align = "center"><input type = "submit" value="save"></td>
					</tr>
				</table>
			</form:form>	
			
		</div>
</body>
</html>