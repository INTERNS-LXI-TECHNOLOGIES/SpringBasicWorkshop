<%@page import="com.lxisoft.servlet.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
	<title>Contacts</title>
</head>
<body>
	<center><h1>Contact List</h1></center>
	<br>
	<div align="center">
        <div class="search-container">
            <form action="search">
			    <input type="text" placeholder="Enter name to search" name="name">
			    <button type="submit">Search</button>			   
		    </form>
		    <a href="viewServlet"><button class="button">ClearSearch</button></a>
        </div>
    </div>
    <br>
    <br>
    <center>
	<%

		ArrayList<Contact> contacts = (ArrayList<Contact>)request.getAttribute("contactList");
		int id = 0;
		String name = null;
		if(request.isUserInRole("admin")){
	%>
	<table style="width:50%" border="1" cellpadding="10" cellspacing="10">
		<tr>
			<th>Name</th>
			<th>Number</th>
			<th>E-Mail</th>
			<th>Actions</th>
		</tr>
		<%

		for(Contact contact : contacts){
		    id = contact.getId();
		    name = contact.getName();
		%>
		<!--<c:forEach var="contacts" items="${contactList}">-->
		<tr>
		   	<td><%out.print(contact.getName());%></td>
			<td><%out.print(contact.getNumber());%></td>
			<td><%out.print(contact.getEmail());%></td>
			<td><a href="edit.jsp?id=<%=id%>"><button class="button">Edit</button></a>
			<a href="contactDelete?name=<%=name%>"><button class="button button2">Delete</button></a></td>	
			</tr>
		</tr>
		<%}%>
	    <!--</c:forEach>-->
	</table>
	<br>

<%
    int num = (Integer)request.getAttribute("numOfPage");
    for(int j=1; j<=num; j++){
        %>
        <a href="search?page=<%=j%>"><%=j%></a>
        &nbsp;&nbsp;&nbsp;&nbsp;
    <%
	}
	%>
	
	<br>
	<br>
	<a href="add.html"><button class="button">AddContact</button></a> 
	<br>
	<br>
	<a href="logout.jsp"><button class="button">Logout</button></a> 
<%}
else{
%>
    <table style="width:50%" border="1" cellpadding="10" cellspacing="10">
		<tr>
			<th>Name</th>
			<th>Number</th>
			<th>E-Mail</th>
		</tr>
		<%

		for(Contact contact : contacts){
		    id = contact.getId();
		    name = contact.getName();
		%>
		
		<tr>
		   	<td><%out.print(contact.getName());%></td>
			<td><%out.print(contact.getNumber());%></td>
			<td><%out.print(contact.getEmail());%></td>	
			</tr>
		</tr>
		<%}%>
	    <!--</c:forEach>-->
	</table>
	<br>

<%
    int num = (Integer)request.getAttribute("numOfPage");
    for(int j=1; j<=num; j++){
        %>
        <a href="search?page=<%=j%>"><%=j%></a>
        &nbsp;&nbsp;&nbsp;&nbsp;
    <%
	}
	%>
	
	<br>
	<br>
	<br>
	<a href="logout.jsp"><button class="button">Logout</button></a> 
<%}%>
</center>
</body>
</html>


































































































