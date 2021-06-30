<%@page import="com.lxisoft.servlet.*"%>
<%@page import="com.lxisoft.model.*"%>
<%@page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<%
	Connection con = null;
	ResultSet rs= null;
	Statement stmnt = null;
	PreparedStatement ps = null;;
	int row;
	String n = request.getParameter("id");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			try{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactapp","root","abi@1003");
				stmnt = con.createStatement();
			    rs = stmnt.executeQuery("select * from contacts where sno = '"+n+"'");
			    while(rs.next()){
			        %>
			        <div class="container">
		                <form action="contactEdit" method="GET">
		                    <h2>Add Details</h2>
		                    ID&nbsp&nbsp&nbsp<input type="text" name="sno" value="<%=rs.getInt("sno")%>"><br><br>
                		    Name &nbsp&nbsp &nbsp<input type="text" name="name" value="<%=rs.getString("name")%>"><br><br>
                		    Phone Number &nbsp&nbsp &nbsp <input type="text" name="number" value="<%=rs.getString("number")%>"><br><br>
	                	    E-Mail  &nbsp &nbsp&nbsp &nbsp<input type="text" name="email" value="<%=rs.getString("email")%>"><br><br>
		                    <button class="button">Change</button>
		                </form>	
		                <%
				    //String name = rs.getString("name");
				    //String number = rs.getString("number");
				    //String mail = rs.getString("email");
			    }	
			}catch(SQLException e)
			{	
				e.printStackTrace();	
		    }
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		//String name = request.getParameter("name");
		//String number  = request.getParameter("num");
		//String mail = request.getParameter("mail");
		%>
	
		<br>
		<a href="view"><button class="button">Home</button></a>
	</div>
</body>
</html>