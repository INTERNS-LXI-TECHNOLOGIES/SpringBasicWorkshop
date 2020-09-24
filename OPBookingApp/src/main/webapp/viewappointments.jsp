<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.model.*"%>
<%@ page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


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
				<td><a href="homepage.jsp"><button class="button">Back</button></a></td>
			</tr>
	</table>
</body>
</html>