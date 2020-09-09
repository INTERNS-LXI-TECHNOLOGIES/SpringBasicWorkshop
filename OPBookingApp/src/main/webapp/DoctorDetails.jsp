<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Details</title>
</head>
<body>
	<form>
		<fieldset>
			<legend>Doctor Details</legend>
			<table align="center">
				<tr>
					<td>Doctor Name</td>
					<td><input type="text" placeholder="Name"></td>
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
				<td><input type="submit" formaction="index.jsp"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>