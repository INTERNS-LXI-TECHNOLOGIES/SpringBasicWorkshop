<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>OP Booking</title>
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
<body >

<div id="box">
<div>
<h1>OP Booking.</h1>
</div>
<div>

<table id="pager" border="2px" width="100%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Branch</th>
			<th>Time</th>
		</tr>
		<%
        				ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        				doctors = (ArrayList<Doctor>)session.getAttribute("dList");
        				if(doctors.size() == 0)
        				{%>
        				<script type="text/javascript">
        					window.alert("No Records To Display");
        				</script>
        			<%}
        			else
        			{
        				for (int i=0;i<doctors.size();i++)
        				{%>

        				<tr>
        				<td><%out.println(i+1);%></td>
        			<td><%out.println(doctors.get(i).getId());%></td>
        			<td><%out.println(doctors.get(i).getName());%></td>
        			<td><%out.println(doctors.get(i).getBranch());%></td>
        			<td><%out.println(doctors.get(i).getTime());%></td>
        			<td><a href="editDoctor?id=<%=doctors.get(i).getId()%>"><button class="button">Update</button></a></td>
        			<td><a href="deleteDoctor?id=<%=doctors.get(i).getId()%>"><button class="button button2">Delete</button></a></td>
        			</tr>
        			<%}
        			}%>
		</table>


<a href="newdoctor"><button class="button">Doctor</button></a>

<a href="home"><button class="button">Home</button></a>
</div>
</div>
</body>
</html>
