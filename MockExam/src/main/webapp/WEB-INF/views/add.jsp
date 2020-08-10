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
			background:white;
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
						<td><form:input path="option1"/></td>
					</tr>
					<tr>
						<td>OPT_2:</td>
						<td><form:input path="option2"/></td>
					</tr>
					<tr>
						<td>OPT_3:</td>
						<td><form:input path="option3"/></td>
					</tr>
					<tr>
						<td>OPT_4:</td>
						<td><form:input path="option4"/></td>
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