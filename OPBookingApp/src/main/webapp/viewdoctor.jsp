<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.model.*"%>
<%@ page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
<style>
#doctor_table {
	text-align: left;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	width: 100%;
}


#doctor_table td, #doctor_table th {
	border: 1px solid #ddd;
	padding: 8px;
}
#doctor_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

#doctor_table tr:nth-child(even) {
	background-color: #f2f2f2;
}

#doctor_table tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<table id="doctor_table">
		<tr>
			<th>Doctor Name</th>
			<th>Section</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			DatabaseRepo db = new DatabaseRepo();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		doctors = db.getDoctorRecords();
		for (int i = 0; i < doctors.size(); i++) {
		%>
		<tr>
			<td>
				<%
					out.println(doctors.get(i).getName());
				%>
			</td>
			<td>
				<%
					out.println(doctors.get(i).getDepartment());
				%>
			</td>
			<td><a href="editDoctor.jsp?id=<%=i%>"><button
						class="button">Update</button></a></td>
			<td><a href="deleteDoctor?id=<%=i%>"><button class="button">Delete</button></a>
			</td>
		</tr>
		<%
			}
		%>
		<tr>
			<td><a href="adminaction.jsp"><button class="button">Back</button></a>
	</table>

</body>
</html>