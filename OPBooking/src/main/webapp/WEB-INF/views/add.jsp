<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>New Doctor</title>
 <style>
    body{
     background-color: lightblue;
    /* margin-top:250px;*/
    /* text-align:center;*/
    }

    a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 20px;
}

    h1 {
        color: black;
        text-align: center;
        font-family: verdana;
      }
  .button {
  background-color: #4CAF50;
  border: none;
  color: white;

   border-radius: 5px;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button:hover {  background-color: black; }
.button2 {background-color: #4CAF50;}
.button2:hover {  background-color: #f44336;}

.search-container {  float: right;}

.search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #4CAF50;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}




  </style>
</head>
<body>
		<div class="container">
			<h2>ADD Doctor</h2>
			<form:form action="addDoctor" method="GET" modelAttribute="doctor">
				<table>
					<tr>
						<td>Name :</td>
						<td><form:input path = "name"/></td>
					</tr>

					<tr>
						<label for="branch">Choose a Branch:</label>

                        <select id="branch">
                          <option value="general">General</option>
                          <option value="cardiologist">Cardiologist</option>
                          <option value="neurologist">Neurologist</option>
                          <option value="ophthamologist">Ophthamologist</option>
                        </select>
					</tr>
					<tr>
						<td>Time:</td>
						<td><form:input path="time"/></td>
					</tr>

					<tr>
						<td colspan = "2" align = "center" ><input type = "submit" value="save"></td>
					</tr>
				</table>
			</form:form>

		</div>
</body>
</html>