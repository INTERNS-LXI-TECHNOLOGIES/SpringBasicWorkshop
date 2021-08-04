<%@page import="com.lxisoft.controller .*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Edit Contact</title>
</head>
<body>

	<%
    List<Contact> list = (ArrayList<Contact>)request.getAttribute("list");
    for(Contact contact : list){ 
    %>
    <div class="container">
        <form action="editContact" method="GET">
            <h2>Add Details</h2>
            Sno &nbsp&nbsp &nbsp<input type="text" name="sno" value="<%=contact.getId()%>"><br><br>
            Name &nbsp&nbsp &nbsp<input type="text" name="name" value="<%=contact.getName()%>"><br><br>
            Phone Number &nbsp&nbsp &nbsp <input type="text" name="number" value="<%=contact.getNumber()%>"><br><br>
            E-Mail  &nbsp &nbsp&nbsp &nbsp<input type="text" name="email" value="<%=contact.getEmail()%>"><br><br>
            <button class="button">Change</button>
        </form>
    </div>
    <%}%>
	<br>
	<a href="viewContact"><button class="button">Back</button></a>

</body>
</html>
