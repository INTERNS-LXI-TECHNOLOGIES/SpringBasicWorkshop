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
    <center>

    <%
    Address address = new Address();
    address = (Address)request.getAttribute("address");
    // for(Contact editContact : contact){
    %>
    <table style="width:50%" border="2" cellpadding="10" cellspacing="10">
        <tr>
            <th style="color:blue; font-style: italic;">Contact Id</th>
            <th style="color:blue; font-style: italic;">House Name</th>
            <th style="color:blue; font-style: italic;">Nationality</th>
        </tr>
        
            <!--<c:forEach var="contacts" items="${contactList}">-->
        <tr>
            <td><%out.print(address.getContactId());%></td>
            <td><%out.print(contact.getHouseName());%></td>
            <td><%out.print(contact.getNationality());%></td>
        </tr>
    </table>
    <%// }%>
    <br>
    <a href="view"><button class="button">Back</button></a>
</center>
</body>
</html>
