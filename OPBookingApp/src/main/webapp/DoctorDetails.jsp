<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Details</title>

<style type="text/css">
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

input[type=submit]:hover {
	background-color: #45a049;
}

input[type=text]:focus {
	background-color: #f1f1f1;
}

select {
	width: 100%;
	padding: 16px 20px;
	border: none;
	border-radius: 4px;
	background-color: #f1f1f1;
}
</style>
</head>
<body>
	<div align="center" style="background-color: #c89666;"> <font size="8"> Add Doctor</font> <br> <br>
	</div>
	<form>
		<fieldset>
			<legend>Doctor Details</legend>
			<table align="center">
				<tr>
					<td>Doctor Name</td>
					<td><input type="text" placeholder="Name" name="dname"></td>
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
					<td></td>
					<td><input type="submit" formaction="saveDoctor"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>