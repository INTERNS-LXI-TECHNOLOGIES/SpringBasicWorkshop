<!DOCTYPE html>
<html>
<head>
	<title>Logout</title>
</head>
<body>
	<%
	session.invalidate();
	%>
	<script type="text/javascript">
		window.alert("Logged out Successfully");
	    window.location.href="http://localhost:8080/ContactApp/index.html";
	</script>
</body>
</html>