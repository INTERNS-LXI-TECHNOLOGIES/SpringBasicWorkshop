<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<title>Contacts</title>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Contacts</h2>
   <hr />

   <input type="button" value="Add Contact"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Contact List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Name</th>
       <th>Number</th>
       <th>Email</th>
       <th>Action</th>
      </tr>


      <c:forEach var="tempContact" items="${contactList}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/contact/editContact">
        <c:param name="sno" value="${tempContact.id}" />
       </c:url>

       <c:url var="deleteLink" value="/contact/deleteContact">
        <c:param name="sno" value="${tempContact.id}" />
       </c:url>

       <tr>
        <td>${tempContact.name}</td>
        <td>${tempContact.number}</td>
        <td>${tempContact.email}</td>

        <td>
         <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>