<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Home Manager </title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <h3>
            <a href="${contextPath}">Home </a>
            &nbsp;&nbsp;||&nbsp;&nbsp;
            <a href="${contextPath}/create">New Contact</a>
            &nbsp;&nbsp;||&nbsp;&nbsp;
            </h3>
            <table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Action</th>

                <c:forEach var="contact" items="${contactList}" varStatus="status">
                <tr>
                   <td><c:out value="${status.index + 1}" /></td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.address}</td>
                    <td>${contact.phone}</td>
                    <td>
                        <a href="edit/${contact.contact_id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete/${contact.contact_id}">Delete</a>
                    </td>

                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>