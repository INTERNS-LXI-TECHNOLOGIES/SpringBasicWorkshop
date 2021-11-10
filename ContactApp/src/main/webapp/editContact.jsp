<%@page import="com.lxisoft.controller .*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Edit Contact</title>
</head>
<body style="background-color:powderblue;">

	<%
	Contact contactToEdit = new Contact();
    contactToEdit = (Contact)request.getAttribute("contact");
    // for(Contact editContact : contact){
    %>
    <div class="container">
        <form action="editContact" method="GET">
            <h2>Add Details</h2>
            Sno &nbsp&nbsp &nbsp<input type="text" name="sno" value="<%=contactToEdit.getId()%>"><br><br>
            Name &nbsp&nbsp &nbsp<input type="text" name="name" value="<%=contactToEdit.getName()%>"><br><br>
            Phone Number &nbsp&nbsp &nbsp <input type="text" name="number" value="<%=contactToEdit.getNumber()%>"><br><br>
            E-Mail  &nbsp &nbsp&nbsp &nbsp<input type="text" name="email" value="<%=contactToEdit.getEmail()%>"><br><br>
            <button class="button" style="background-color:silver;">Change</button>
        </form>
    </div>
    <%// }%>
	<br>
	<a href="view"><button class="button">Back</button></a>

</body>
</html>
