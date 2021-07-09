<%@page import="com.lxisoft.servlet.*"%>
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
	<%

		ArrayList<Contact> contacts = (ArrayList<Contact>)request.getAttribute("contactList");
		int id = 0;
		String name = null;
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
		<!--<c:forEach var="contacts" items="${contactList}">-->
		<tr>
		   	<td><%out.print(contact.getName());%></td>
			<td><%out.print(contact.getNumber());%></td>
			<td><%out.print(contact.getEmail());%></td>
			</tr>
		</tr>

	    <!--</c:forEach>-->
	</table>
	<br>

<%
    int num = (Integer)request.getAttribute("numOfPage");
    for(int j=1; j<=num; j++){
        %>
        <a href="viewServlet?page=<%=j%>"><%=j%></a>
        &nbsp;&nbsp;&nbsp;&nbsp;
    <%
	}
	%>

	<br>
	<br>
	<a href="index.jsp"><button class="button">Logout</button></a>
</center>
</body>
</html>