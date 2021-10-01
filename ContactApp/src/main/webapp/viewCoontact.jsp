<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Contacts</title>
</head>
<body style="background-color: rgb(5, 5, 5);">
	<%@ page import = "com.lxisoft.controller.*" %>
	<%@ page import = "com.lxisoft.model.*" %>
	<%@ page import = "com.lxisoft.repository.*" %>
	<%@ page import = "java.util.*" %>
	<center>
		<h1>Contacts</h1>
	</center>
	<center>
		<table align="utf-8" style="utf-8">
			<tr>
				<th>Name</th>
				<th>Number</th>
				<th>E-Mail</th>
			</tr>
			<%
			List<Contact> contactList = (List<Contact>)request.getAttribute("contactList");
		    for(Contact contact : contactList){
		    %>
		    <tr>
		    	<td><% out.println(contact.getName()); %></td>
		    	<td><% out.println(contact.getNumber()); %></td>
		    	<td><% out.println(contact.getEmail()); %></td>
		    </tr>
		    <%
		    }
		    %>
		</table>
		<br>
		<br>
		<br>
		<a href="getContact"><button class="button">Add Contact</button></a>
	</center>
	<a href="index.jsp"><button class="button">Back</button></a>
</body>
</html>