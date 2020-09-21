<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.model.*"%>
<%@ page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
#patient_table {
	text-align: left;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	width: 100%;
}


#patient_table td, #patient_table th {
	border: 1px solid #ddd;
	padding: 8px;
}
#patient_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

#patient_table tr:nth-child(even) {
	background-color: #f2f2f2;
}

#patient_table tr:hover {
	background-color: #ddd;
}
</style>

<title>Appointments</title>


</head>
<body>
	<div align="center" style="background-color: #c89666;">
		<font size="8"> Available Doctors</font>
	</div>

	<table id="patient_table">
		<tr>
			<th>Patient Name</th>
			<th>Contact Number</th>
			<th>Address</th>
			<th>Selected Doctor</th>
		</tr>
		<%
		DatabaseRepo db = new DatabaseRepo();
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients = db.getPatientRecords();
		for (int i = 0; i < patients.size(); i++) {
		%>
		<tr>
			<td>
				<%
					out.println(patients.get(i).getName());
				%>
			</td>
			<td>
				<%
					out.println(patients.get(i).getPhoneNumber());
				%>
			</td>
			<td>
			<%
				out.println(patients.get(i).getAddress());
			%>
			</td>
			<td>
			<%
				out.println(patients.get(i).getDoctorName());
			%>
			</td>
			</tr>
			<% } %>
			
			<tr>
				<td><a href="adminaction.jsp"><button class="button">Back</button></a></td>
			</tr>
	</table>
</body>
</html>