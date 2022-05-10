<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body style="background-color:powderblue;">
	<h1 style="background-color:white;">Adding Address</h1>
		<form action="addContactAddress" method="get" modelAttribute="address">

			<table>
				<tr>
					<td>Contact Id</td>
					<td><input type="text" name="contactId" value= <%=request.getParameter("id")%>></td>
				</tr>
			<tr>
				<td>Place Name</td>
				<td><input type="text" placeholder="Enter Place Name" name="placeName" required></td>
			</tr>
			<br>
			<br>
			<tr>
				<td>Nationality</td>
				<td><input type="text" placeholder="Enter Nationality" name="nationality" required></td>
			</tr>
			<br>
			<br>
		    <tr>
		    	<td><input type="submit" class="button" style="background-color:silver;" value="Add"></td>
		    </tr>
		</table>
		</form>
		<br>
		<br>
		<a href="view"><input type="submit" class="button" style="background-color:silver;" value="Back"></a>
</body>
</html>