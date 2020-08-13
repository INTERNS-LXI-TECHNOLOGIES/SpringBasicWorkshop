
<%@ page import = "com.lxisoft.model.*"%>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ADMIN</title>
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



  .pagination {  display: inline-block; }

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {  background-color: #4CAF50;
  color: white; }

.pagination a:hover:not(.active) {background-color: #ddd;}

  </style>

</head>
<body>
		<div id="addProblem">
			<a href="add"><button class="button">Add Question</button></a>
		</div>

		<div id="view">
		<table id="pager" border="2px" width="100%">
		<tr>
			<th>SL.NO</th>
			<th>ID</th>
			<th>QUESTION</th>
			<th>OPTION_1</th>
			<th>OPTION_2</th>
			<th>OPTION_3</th>
			<th>OPTION_4</th>
			<th>ANSWER</th>
		</tr>
		<%
        				ArrayList<Problem> questions = new ArrayList<Problem>();
        				questions = (ArrayList<Problem>)session.getAttribute("qList");
        				if(questions.size() == 0)
        				{%>
        				<script type="text/javascript">
        					window.alert("No Records To Display");
        				</script>
        			<%}
        			else
        			{
        				for (int i=0;i<questions.size();i++)
        				{%>

        				<tr>
        				<td><%out.println(i+1);%></td>
        			<td><%out.println(questions.get(i).getId());%></td>
        			<td><%out.println(questions.get(i).getQuestion());%></td>
        			<td><%out.println(questions.get(i).getOption1());%></td>
        			<td><%out.println(questions.get(i).getOption2());%></td>
        			<td><%out.println(questions.get(i).getOption3());%></td>
        			<td><%out.println(questions.get(i).getOption4());%></td>
        			<td><%out.println(questions.get(i).getAnswer());%></td>
        			<td><a href="editQuestion?id=<%=questions.get(i).getId()%>"><button class="button">Update</button></a></td>
        			<td><a href="deleteQuestion?id=<%=questions.get(i).getId()%>"><button class="button">Delete</button></a></td>
        			</tr>
        			<%}
        			}%>
		</table>
	</div>
</body>
</html>