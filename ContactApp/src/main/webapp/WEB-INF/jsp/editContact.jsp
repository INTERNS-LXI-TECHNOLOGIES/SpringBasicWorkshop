<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Edit Contact</title>
</head>
<body style="background-color:powderblue;">
    <center>

	<%
	Contact contactToEdit = new Contact();
    Address addressToEdit = new Address();
    contactToEdit = (Contact)request.getAttribute("contact");
    addressToEdit = (Address)request.getAttribute("address");
    // for(Contact editContact : contact){
    %>
    <div class="container">
        <form action="editContact" method="GET" modelAttribute="contact">
            <h2>Edit Details</h2>
            <input type="text" name="sno" value="<%=contactToEdit.getId()%>"><br><br>
            Name &nbsp&nbsp &nbsp<input type="text" name="name" value="<%=contactToEdit.getName()%>"><br><br>
            Phone Number &nbsp&nbsp &nbsp <input type="text" name="number" value="<%=contactToEdit.getNumber()%>"><br><br>
            E-Mail  &nbsp &nbsp&nbsp &nbsp<input type="text" name="email" value="<%=contactToEdit.getEmail()%>"><br><br>
            <br>
            <br>
            Place Name  &nbsp &nbsp&nbsp &nbsp<input type="text" name="placeName" value="<%=addressToEdit.getPlaceName()%>"><br><br>
            Nationality  &nbsp &nbsp&nbsp &nbsp<input type="text" name="nationality" value="<%=addressToEdit.getNationality()%>"><br><br>
            <button class="button" style="background-color:silver;">Change</button>
        </form>
    </div>
    <%// }%>
	<br>
	<a href="view"><button class="button">Back</button></a>
</center>
</body>
</html>
