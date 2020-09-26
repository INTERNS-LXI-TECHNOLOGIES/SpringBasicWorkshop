<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.lxisoft.model.*"%>
<%@ page import="com.lxisoft.repository.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<style>
#doctor_table
 {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=text]:focus {
  background-color: lightblue;
}
input[type=submit]:hover {
  background-color: #45a049;
}
</style>
<meta charset="ISO-8859-1">
<title>Edit Doctor</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
Database db = new Database();
ArrayList<Doctor> doctors = new ArrayList<Doctor>();
doctors = db.getDoctorRecords();
%>
<div align="center" style="background-color: #c89666;"> <font size="8"> Edit Doctor Details</font> <br> <br>
	</div>
<form>
		<fieldset>
			<legend>Doctor Details</legend>
			<table align="center" id="doctor_table">
				<tr>
					<td>Doctor Name</td>
					<td><input type="text" placeholder=<%out.println(doctors.get(id).getName()); %> name="dname"></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><select name="departments" id="departments">
							<option value="skin">skin</option>
							<option value="dental">dental</option>
							<option value=cardi>cardi</option>
							<option value="gynacology">gynacology</option>
					</select></td>
				</tr>
				<tr>
				<td><input type="hidden" value=<%=id%> name="id"></td>
				<td><input type="submit" formaction="updateDoctor" value="Update"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>