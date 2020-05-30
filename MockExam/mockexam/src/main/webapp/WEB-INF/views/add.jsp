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
	</style>
</head>
<body>
		<div class="container">
			<h2>ADD QUESTION</h2>
			<form:form action="addQuestion" method="GET" modelAttribute="exam">
				<table>
					<tr>
						<td>QUESTION:</td>
						<td><form:input path = "question" /></td>
					</tr>
					<tr>
						<td>OPT_1:</td>
						<td><form:input path="opt1"/></td>	
					</tr>
					<tr>
						<td>OPT_2:</td>
						<td><form:input path="opt2"/></td>
					</tr>
					<tr>
						<td>OPT_3:</td>
						<td><form:input path="opt3"/></td>
					</tr>
					<tr>
						<td>OPT_4:</td>
						<td><form:input path="opt4"/></td>
					</tr>
					<tr>
						<td>ANSWER:</td>
						<td><form:input path="answer"/></td>
					</tr>
					<tr>
						<td colspan = "2" align = "center" ><input type = "submit" value="save"></td>
					</tr>
				</table>
			</form:form>	
			
		</div>
</body>
</html>