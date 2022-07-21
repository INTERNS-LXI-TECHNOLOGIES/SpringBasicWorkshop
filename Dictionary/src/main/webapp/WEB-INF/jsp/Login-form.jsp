<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<body onload='document.loginForm.username.focus();'>
	<head>
		<title>Dictionary Application</title>

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	</head>
   <div
   style="background: #14eddb; color: rgb(8, 0, 0); text-align: center;">
   <h2>Dictionary Application</h2>

   <c:if test="${not empty message}"><div>${message}</div></c:if>
</div>

<div align="center">

		</div>
		<div align="center">

			<h3>Log In</h3>
			<form name='login' action="<c:url value='/Login-form' />" method='POST'>
				Username: <input type="text" name="username"><br><br>
				Password: <input type="password"  name="password" ><br><br>
				<input type="submit" value="Log In" style="background: #54b0b0; color: white; border-radius: 15px; padding: 6px 12px; ">

				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</body>
</html>