<%@page import="com.lxisoft.controller .*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Address</title>
    <style>
        table, th, td {
          border: 1px solid black;
          border-collapse: collapse;
        }
        th, td {
          background-color: #69A4A4;
        }
    </style>
</head>
<body style="background-color:powderblue;">
    <center>

    <%
    Address contactAddress = (Address)request.getAttribute("address");

    // for(Address contactAddress : contactWithAddress){

    %>
    <table style="width:50%" border="2" cellpadding="10" cellspacing="10">
        <tr>
            <th style="color:blue; font-style: italic;">Id</th>
            <th style="color:blue; font-style: italic;">Place Name</th>
            <th style="color:blue; font-style: italic;">Nationality</th>
        </tr>
        
            <!--<c:forEach var="contacts" items="${contactList}">-->
        <tr>
            <td><%out.print(contactAddress.getId());%></td>
            <td><%out.print(contactAddress.getPlaceName());%></td>
            <td><%out.print(contactAddress.getNationality());%></td>
        </tr>
    </table>
    <%// }%>
    <br>
    <a href="view"><button class="button">Back</button></a>
</center>
</body>
</html>
