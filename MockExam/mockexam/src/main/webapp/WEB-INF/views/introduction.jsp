<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>MockExam</title>
	<style type="text/css">
		head,body{
			background:#009b77;
		}
		#heading{
			text-align: center;
		}
		#box{
			background-color: lightgrey;
			width: 1150px;
			border:15px solid green;
			padding: 50px;
			padding-top: 5px;
			margin: 35px;
			border-radius: 45px;

		}
		#btn{
			border-radius: 15px;
			border-color: black;
			background-color: red;
			margin-top: -20px;
		}
		#bbtn{
			text-align: center;
			margin-top: 10px;
		}
	</style>
</head>
<body>
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
			<button id="btn" style="height: 50px;width: 100px">Start Exam</button>
		</form>
	</div>
</body>
</html>