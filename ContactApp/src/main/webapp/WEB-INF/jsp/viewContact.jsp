<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
    <h4 style="float: right;"><security:authentication property = "name"/>  <security:authentication property = "principal.authorities"/></h4>
    <br>
    <br>
    <a href="logout" style="float: right;"><button class="button">Log out</button></a>
    <br>
    <security:authorize access= "isAuthenticated()">
        <center> 
            <h1 style="background-color: white; color: black; font-style: italic;">WELCOME <security:authentication property = "name"/></h1>
        </center>
    <br>
    <br>
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
                    <security:authorize access="hasAuthority('ADMIN')">
                        <th style="color:blue; font-style: italic;">Action</th>
                    </security:authorize>
                    
                </tr>
                <%
                List<Contact> contactsForUser = (List<Contact>) request.getAttribute("contactList");
                for(Contact contact : contactsForUser){

                %>

                <tr>
                    <td><%out.print(contact.getName());%></td>
                    <td><%out.print(contact.getNumber());%></td>
                    <td><%out.print(contact.getEmail());%></td>
                    <td><a href="viewContactAddress?id=<%=contact.getId()%>"><button class="button">View Address</button></a>
                        <security:authorize access="hasAuthority('ADMIN')"><td><a href="showContact?id=<%=contact.getId()%>"><button class="button">edit</button></a><a href="deleteContact?sno=<%=contact.getId()%>"><button class="button">delete</button></a></td></security:authorize>
                        

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
                <security:authorize access="hasAuthority('ADMIN')">
                    <a href="addContact"><button class="button">Add Contact</button></a>
                </security:authorize>
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
            <security:authorize access="hasAuthority('ADMIN')">
                <a href="addContact"><button class="button">Add Contact</button></a>
            </security:authorize>
            <br>
            <br>
            <a href="/"><button class="button">Back</button></a>
            <%
        }
    %>
    <br>
</center>


<br>
</center>
</security:authorize>




</body>
</html>