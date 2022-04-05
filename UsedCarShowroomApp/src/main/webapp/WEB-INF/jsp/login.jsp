<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Used Car Showroom Application</title>
	</head>
	<body style="margin:0;background: #e6f0e9;">
		<div
			style="background: #0a3939; color: white; text-align: center; padding: 9px; text-transform: uppercase;">
			<h1>Used Car Showroom Application</h1>
		</div>
		<div align="center">
			<h3>PLEASE LOGIN</h3>
			<form method="POST" action="j_security_check">
				Username: <input type="text" name="j_username"><br><br>
				Password: <input type="password" name="j_password"><br><br>
				<input type="submit" value="LOGIN" style="background: #040505; color: white; border-radius: 12px; padding: 6px 12px;">
			</form>
		</div>
	</body>
</html>