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
	 Contact model = new Contact();
     Connection con = null;
     ResultSet rs= null;
     Statement stmt = null;
     PreparedStatement ps = null;
	 try
     {
        Class.forName("com.mysql.jdbc.Driver");
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactapp","root","abi@1003");
        }
        catch(SQLException e)
         {	e.printStackTrace();	}
     }
     catch(ClassNotFoundException e){
          e.printStackTrace();
     }

	%>
	<table style="width:50%" border="1" cellpadding="10" cellspacing="10">
		<tr>
			<th>Name</th>
			<th>Number</th>
			<th>E-Mail</th>

		</tr>
		<%
		ArrayList<Contact> list = new ArrayList<Contact>();
        Contact contact = null;
        try
        {
             String sql  = "select * from contacts order by name";
             stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
             while(rs.next())
             {
                 contact = new Contact();
                 contact.setId(rs.getInt("sno"));
                 contact.setName(rs.getString("name"));
                 contact.setNumber(rs.getString("number"));
                 contact.setEmail(rs.getString("email"));
                 list.add(contact);
             }
             rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

		%>
		<!--<c:forEach var="contacts" items="${contactList}">-->
		<tr>
		<%for(int i=0;i<list.size();i++){%>
		   	<td><%out.print(list.get(i).getName());%></td>
			<td><%out.print(list.get(i).getNumber());%></td>
			<td><%out.print(list.get(i).getEmail());%></td>
			</tr>
		<%}%>
		</tr>

	    <!--</c:forEach>-->
	</table>
	<br>


	<br>
	<br>
	<a href="index.jsp"><button class="button">Logout</button></a>
</center>
</body>
</html>