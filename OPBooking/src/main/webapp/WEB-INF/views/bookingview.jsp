<%@ page import = "com.lxisoft.model.*"%>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>OP Booking</title>
<style>
    body{
             font-family: "Sofia";
              font-size: 22px;
            background-color: lightblue;
            /* margin-top:250px;*/
           text-align:center;
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



		<h3>Your Details</h3>


		<%
        				ArrayList<User> users = new ArrayList<User>();
        				users = (ArrayList<User>)session.getAttribute("uList");
        				String name = (String)session.getAttribute("sname");
        				int z=0;
        				for (int i=0;i<users.size();i++)
        				{
        				if(name.equals(users.get(i).getName()))
        				{
        				z++;
        				%>
                    <td><b>Name :</b><%out.println(users.get(i).getName());%></td><br>
        			<td><b>ID :</b><%out.println(users.get(i).getId());%></td><br>
        			<td><b>Place :</b><%out.println(users.get(i).getPlace());%></td><br>
        			<td><b>Contact Number :</b><%out.println(users.get(i).getNumber());%></td><br>
        			<td><b>Selected Session :</b><%out.println(users.get(i).getBranch());%></td><br>
        			<td><b>Doctors Name :</b><%out.println(users.get(i).getDoctor());%></td><br>
        			<td><b>Time :</b><%out.println(users.get(i).getDateandTime());%></td><br>
        			<td><a href="deleteUser?id=<%=users.get(i).getId()%>"><button class="button button2">Cancel</button></a></td>

        			<%}
        			}
        			if(z==0)
        			{%>
        			    <script type="text/javascript">
                        window.alert("No Records To Display");
                        window.location.href="home";
                        </script>
        			<%}
        			%>
		</table>

<a href="home"><button class="button">Close</button></a>
</div>
</div>
</body>
</html>
