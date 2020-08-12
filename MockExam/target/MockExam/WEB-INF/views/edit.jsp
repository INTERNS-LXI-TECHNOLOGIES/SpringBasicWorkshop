<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>UPDATE</title>
		<link href='<c:url value="resources/css/updatecss.css"></c:url>' rel="stylesheet" type="text/css"/>
</head>
<body>

		<div class="container">
			<h2>UPDATE QUESTION</h2>
			<form:form action="edit" method="GET" modelAttribute="questById">
				<table>
					<tr>
						<td>ID .:</td>
						<td><form:input path="id"  readonly="readonly" /></td>
					</tr>
					<tr>
						<td>QUESTION:</td>
						<td><form:input path="question"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-1:</td>
						<td><form:input path="option1"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-2:</td>
						<td><form:input path="option2"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-3:</td>
						<td><form:input path="option3"  required="required"/></td>
					</tr>
					<tr>
						<td>OPTION-4:</td>
						<td><form:input path="option4"  required="required"/></td>
					</tr>
					<tr>
						<td>ANSWER:</td>
						<td><form:input path="answer"  required="required"/></td>
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
				confirm("Edited Successfully.....");
			}

		</script>
</body>
</html>