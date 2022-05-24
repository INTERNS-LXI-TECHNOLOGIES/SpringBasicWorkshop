<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Home Manager </title>
  <style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid hsl(0, 20%, 50%);
  padding: 8px;
}

#customers tr:nth-child(odd){background-color:  hsl(0, 20%, 50%);}

#customers tr:hover {background-color:#006B54;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #A2242F;
  color: white;
}
th:nth-child(even) {background-color: hsl(0, 20%, 50%);}

</style>
    </head>
    <body style="background-color:RGB(146, 168, 209);">
        <div align="center">
            <h1>Contact List</h1>
            <h3>
            <a href="${contextPath}">Home </a>
            &nbsp;&nbsp;||&nbsp;&nbsp;
            <a href="${contextPath}/create">New Contact</a>
            &nbsp;&nbsp;||&nbsp;&nbsp;
            <a href="${contextPath}/logout">Logout</a>
            </h3>
           <table id="customers">
                <th>No</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Telephone</th>
                <sec:authorize access="hasRole('ADMIN')">
                <th>Action</th>
                </sec:authorize>

                <c:forEach var="contact" items="${contactList}" varStatus="status">
                <tr>
                   <td><c:out value="${status.index + 1}" /></td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.address}</td>
                    <td>${contact.phone}</td>
                     <sec:authorize access="hasRole('ADMIN')">
                    <td>
                        <a href="edit/${contact.contact_id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete/${contact.contact_id}" onclick="return confirm('Are you sure you want to delete This?')">Delete</a>
                    </td>
                    </sec:authorize>

                </tr>
                </c:forEach>
                 <tfoot>
                      <tr>
                        <th colspan='7'>
                        <center>  Interns @ LXISOFT    <center>
                        </th>
                      </tr>
                    </tfoot>
            </table>
        </div>
    </body>
</html>