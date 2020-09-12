<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button {
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.button:hover {
	background-color: #4CAF50;
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend> Admin Actions</legend>
		<button class="button" onclick="document.location='DoctorDetails.jsp'">Add Doctor</button>
		<button class="button" onclick="document.location='viewdoctor.jsp'">View Doctors Available</button>
	</fieldset>
</body>
</html>