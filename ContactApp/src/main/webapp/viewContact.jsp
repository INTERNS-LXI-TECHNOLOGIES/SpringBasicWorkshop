<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>

<html>
<head>
    <title>Contacts</title>
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
    <center><h1 style="background-color: white; color: black; font-style: italic;">Contact List</h1></center>
    <br>
    <br>
    <div align="center">
        <div class="search-container">
            <form action="view" style="background-color:white;">
                <input type="text" placeholder="Enter name to search" name="name">
                <button type="submit">Search</button>
            </form>
        </div>
    </div>
    <br>
    <br>
    <center>
     <table style="width:50%" border="2" cellpadding="10" cellspacing="10">
            <tr>
                <th style="color:blue; font-style: italic;">Name</th>
                <th style="color:blue; font-style: italic;">Number</th>
                <th style="color:blue; font-style: italic;">E-Mail</th>
                <th style="color:blue; font-style: italic;">Address</th>
                <th style="color:blue; font-style: italic;">Actions</th>
            </tr>
            <%
            List<Contact> contacts = (List<Contact>) request.getAttribute("contactList");
            for(Contact contact : contacts){

            %>
            <!--<c:forEach var="contacts" items="${contactList}">-->
            <tr>
                <td><%out.print(contact.getName());%></td>
                <td><%out.print(contact.getNumber());%></td>
                <td><%out.print(contact.getEmail());%></td>
                <td><a href="viewContactAddress?id=<%=contact.getId()%>"><button class="button">View Address</button></a>
                <td><a href="addAddress.jsp?id=<%=contact.getId()%>"><button class="button">Add Address</button></a>
                    <a href="showContact?id=<%=contact.getId()%>"><button class="button">Edit</button></a>
                    <a href="deleteContact?sno=<%=contact.getId()%>"><button class="button button2">Delete</button></a></td>
            </tr>
            <%}%>
     </table>
     <br>
    <%

    if(request.getAttribute("name") != null){

        int num = (Integer)request.getAttribute("numOfPage");
        for(int j=1; j<=num; j++){
        %>
            <a href="view?page=<%=(j-1)%>&name=<%=request.getAttribute("name")%>"><%=j%></a>
            &nbsp;&nbsp;&nbsp;&nbsp;
         <%
        }
    %>
        <br>
        <br>
        <a href="addContact.jsp"><button class="button">Add Contacts</button></a>
        <br>
        <br>
        <a href="view"><button class="button">Back</button></a>
    <%
    }
    else{
        int num = (Integer)request.getAttribute("numOfPage");
        for(int j=1; j<=num; j++){
        %>
            <a href="view?page=<%=j%>"><%=j%></a>
            &nbsp;&nbsp;&nbsp;&nbsp;
    <%
        }
        %>
        <br>
        <br>
        <a href="addContact.jsp"><button class="button">Add Contacts</button></a>
        <br>
        <br>
        <a href="index.jsp"><button class="button">Back</button></a>
        <%
    }
     %>
     <br>




    </center>
</body>
</html>