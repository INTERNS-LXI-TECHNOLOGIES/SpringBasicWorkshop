<%@page import="com.lxisoft.controller.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>

<html>
<head>
	<title>Contacts</title>
</head>
<body>
	<center><h1>Search List</h1></center>
    <br>
    <br>
    <div align="center">
        <div class="search-container">

            <form action="search">
    		    <input type="text" placeholder="Search" name="name">
    		    <button type="submit">Search</button>
    	    </form>
        </div>
    </div>
    <br>
    <br>
    <center>
	 <table style="width:50%" border="1" cellpadding="10" cellspacing="10">
    		<tr>
    			<th>Name</th>
    			<th>Number</th>
    			<th>E-Mail</th>
    			<th>Actions</th>
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
    			<td><a href="editContact.jsp?id=<%=contact.getId()%>"><button class="button">Edit</button></a>
                 	<a href="contactDelete?name=<%=contact.getName()%>"><button class="button button2">Delete</button></a></td>
    		</tr>
    		<%}%>
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
    	<a href="view"><button class="button">Back</button></a>
	</center>
</body>
</html>