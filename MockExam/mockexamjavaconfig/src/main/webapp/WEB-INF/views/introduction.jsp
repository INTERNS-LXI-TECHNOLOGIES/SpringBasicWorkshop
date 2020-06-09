<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>MockExam</title>
	<link href='<c:url value="resources/css/introductioncss.css"></c:url>' rel="stylesheet" type="text/css"/>
</head>
<body background="<c:url value='resources/images/121440.jpg'/>">
	<div id="heading">
	<h1>Mock Exam</h1>
	</div>
	<div id="box">
		<h5 style="text-align: center;font-size: 20px;color:black; ">Instruction To The Candidates</h5>
		<p style="font-size: 30px">
			<ul>
				<li><h1>  Exam has Total 10 Questions. </h1></li>
				<li><h1>  Each Question has 10 seconds. </h1></li>
				<li><h1>  No Negative Marks.</h1></li>
				<li><h1>  Minimum 6 Right Answers For Pass.</h1></li>
			</ul>
		</p>
	</div>
	<div id="bbtn" >
		<form action="getExamData" method="GET">
			<input type="hidden" name="count" value="0">
			<button id="btn" style="height: 50px;width: 100px;color:black">Start Exam</button>
		</form>
	</div>
</body>
</html>