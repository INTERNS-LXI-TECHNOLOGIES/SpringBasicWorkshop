<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
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
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>Name Of Patient</td>
				<td><input type="text" value="Enter your Name"></td>
			</tr>
			<tr>
				<td>Contact Number Of Patient</td>
				<td><input type="text" value="Enter your Number"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" formaction="index.jsp"></td>
			</tr>
		</table>
	</form>

</body>
</html>