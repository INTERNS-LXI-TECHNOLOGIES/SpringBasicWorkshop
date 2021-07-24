<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>

<html>
<head>
	<title>Contacts</title>
</head>
<body>
	<center><h1>Contact List</h1></center>
    <br>
    <br>
    <center>


	 <table style="width:50%" border="1" cellpadding="10" cellspacing="10">
    		<tr>
    			<th>Name</th>
    			<th>Number</th>
    			<th>E-Mail</th>
    		</tr>
    		<%
    		List<Contact> contacts = (List<Contact>)request.getAttribute("contactList");
    		for(Contact contact : contacts){

    		%>
    		<!--<c:forEach var="contacts" items="${contactList}">-->
    		<tr>
    		   	<td><%out.print(contact.getName());%></td>
    			<td><%out.print(contact.getNumber());%></td>
    			<td><%out.print(contact.getEmail());%></td>
    		</tr>
    		<%}%>
     </table>
    <br>


    	<br>
    	<br>
    	<br>
    	<a href="logout.jsp"><button class="button">Logout</button></a>
	</center>
</body>
</html>