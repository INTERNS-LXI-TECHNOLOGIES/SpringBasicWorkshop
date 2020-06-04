<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>ADD</title>
		<link href='<c:url value="resources/css/addcss.css"></c:url>' rel="stylesheet" type="text/css"/>
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
						
						<td colspan = "2" align = "center"><button type = "submit" onclick="myFunction()">Save</button></td>
					</tr>
				</table>
			</form:form>	
			
		</div>
		<script type="text/javascript">
		function myFunction()
		{
			confirm("Successfully Added.....");
		}
		</script>
</body>
</html>