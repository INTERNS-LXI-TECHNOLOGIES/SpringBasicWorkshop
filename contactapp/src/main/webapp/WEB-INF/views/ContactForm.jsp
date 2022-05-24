<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>New/Edit Contact</title>
<style>
.login-card label {
    font-family: Calibri;
    font-size: 11pt;
    font-style: normal;
    text-align:center;
    margin-left:auto;
    margin-right:auto;
}
tr {
    text-align: center;
}
.login-card h1 {
    font-weight: 73;
    text-align: center;
    font-size: 3em;
}
.login-card input[type=submit] {
    width: 100%;
    display: block;
    margin-bottom: 20px;
    position: center;
}
.login-card input[type=text], input[type=password] {
    height: 44px;
    font-size: 16px;
    width: 100%;
    margin-bottom: 10px;
    -webkit-appearance: none;
    background: #fff;
    border: 1px solid #d9d9d9;
    border-top: 1px solid #c0c0c0;
    /* border-radius: 2px; */
    padding: 0 8px;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
}
</style>
</head>
<body style="background-color:#B0C4DE;">
    <div align="center" class="login-card">

        <form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="contact" style="background-color:#E6E6FA">
 <caption>
		            	<h1>
		            	${caption}
		            	</h1>
		            </caption>
        <table>
        <tr>
                        <td>

                                            </td>
            <form:hidden path="contact_id"/>
            </tr>
            <tr>
                                   <td>
                                       <form:label path="name">Name</form:label>
                                   </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                                    <td>
                                        <form:label path="email">Email</form:label>
                                    </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                                    <td>
                                        <form:label path="address">Address</form:label>
                                    </td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>

                                    <td>
                                        <form:label path="phone">Phone</form:label>
                                    </td>                <td><form:input path="phone" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>