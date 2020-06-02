<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
   
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>UPDATE</title>
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
			<form:form action="update" method="GET" modelAttribute="questById">
				<table>
					<tr>
						<td>SL.NO:</td>
						<td><form:input path="id" type="text" name="id" value="${questById.getId()}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>QUESTION:</td>
						<td><form:input path="question" type="text" id="que" name="ques" value="${questById.getQuestion()}" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_1:</td>
						<td><form:input path="opt1" type="text" name="op1" value="${questById.getOpt1()}" required="required"/></td>	
					</tr>
					<tr>
						<td>OPT_2:</td>
						<td><form:input path="opt2" type="text" name="op2" value="${questById.getOpt2()}" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_3:</td>
						<td><form:input path="opt3" type="text" name="op3" value="${questById.getOpt3()}" required="required"/></td>
					</tr>
					<tr>
						<td>OPT_4:</td>
						<td><form:input path="opt4" type="text" name="op4" value="${questById.getOpt4()}" required="required"/></td>
					</tr>
					<tr>
						<td>ANSWER:</td>
						<td><form:input path="answer" type="text" name="ans" value="${questById.getAnswer()}" required="required"/></td>
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