<%@ page import = "com.lxisoft.model.*"%>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>New User</title>
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
  font-size: 17px;8137952715
  border: none;7034043856
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
			<h2>ADD User Details</h2>
			<form:form action="addUser" method="GET" modelAttribute="user">
				<table>
					<tr>
						<td>Name :</td>
						<td><form:input path = "name" /></td>
					</tr>
					<tr>
						<td>Place :</td>
						<td><form:input path="place"/></td>
					</tr>
					<tr>
						<td>Number :</td>
						<td><form:input path="number"/></td>
					</tr>
					<tr>
					 <%ArrayList<Doctor> doctors = new ArrayList<Doctor>();
                     doctors = (ArrayList<Doctor>)session.getAttribute("dList");%>

                          <%
                          for (int i=0;i<doctors.size();i++)
                          {%>
								<input type="radio"  id="1" value=<%=i%> name="browser" onclick="myFunction(this.value)">
								<label>Name : <%out.println(doctors.get(i).getName());%> Branch : <%out.println(doctors.get(i).getBranch());%></label><br>
                    	 <%}%>
                    </tr>

					<tr>
					 Your Doctors Name : <input type="text" id="dname" path="doctor">

					</tr>
					<tr>
                        Your Session Name : <input type="text" id="branch" path="branch">
                    </tr>
                    <tr>
                        Your Time : <input type="text" id="time" path="dateandTime">
                    </tr>
				</table>
			</form:form>

			<script>
            function myFunction(browser) {
            int val=browser;
              document.getElementById("dname").value =doctors.get(val).getName() ;
              document.getElementById("branch").value =doctors.get(val).getBranch() ;
              document.getElementById("time").value =doctors.get(val).getDateandTime() ;
            }
            </script>

		</div>
</body>
</html>