<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body style="background-color:powderblue;">
	<h1 style="background-color:white;">Adding Contact</h1>

		<form action="addContact" method="post" modelAttribute="contact" modelAttribute="address">
			<tr>
				<td>Name</td>
				<td><input type="text" placeholder="Enter Name of Contact" name="name" required></td>
			</tr>
			<br>
			<br>
			<tr>
				<td>Number</td>
				<td><input type="text" placeholder="Enter Number of Contact" name="number" required></td>
			</tr>
			<br>
			<br>
			<tr>
				<td>E-Mail</td>
				<td><input type="text" placeholder="Enter Email id" name="email" required></td>
			</tr>
			<br>
			<br>
			<table>

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

            		</table>
		<!--	Name:<input type="text" placeholder="Enter Name" name="name" required><br><br>
			Number:<input type="text" placeholder="Enter Number" name="number" required><br><br>
			Email:<input type="text" placeholder="Enter Email id" name="mail" required><br><br>  -->
		    <tr>
		    	<td><input type="submit" class="button" style="background-color:silver;" value="Add"></td>
		    </tr>
		</form>
		<br>
		<br>
		<a href="view"><input type="submit" class="button" style="background-color:silver;" value="Back"></a>
</body>
</html>